/**
 *              62 | LARRY'S ARRAY
 * Domain       ALGORITHMS
 * Sub domain   IMPLEMENTATION
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner scan = new Scanner(file);

        int testCases = scan.nextInt();
        while (testCases-- > 0) {
            int n = scan.nextInt();
            int[] array = new int[n];
            for (int i = 0; i < n; ++i) {
                array[i] = scan.nextInt();
            }
            larrysArray(array);
        }

        scan.close();
    }

    private static void larrysArray(int[] array) {
        int count = 0;
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < array.length - 1; ++i) {
                if (array[i] > array[i + 1]) {
                    count += smallBubbleSort(array, i, i + 2);
                    isSorted = false;
                }
            }
        }

        System.out.println(count % 2 == 0 ? "YES" : "NO");
    }

    private static int smallBubbleSort(int[] array, int start, int end) {
        int count = 0;
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = start; i < end; ++i) {
                if (array[i] > array[start + 1]) {
                    array[i] = array[i] + array[i + 1] - (array[i + 1] = array[i]);
                    count++;
                    isSorted = false;
                }
            }
        }
        return count;
    }
}