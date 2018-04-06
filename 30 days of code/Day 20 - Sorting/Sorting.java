/**
 *              SORTING | JAVA
 * Domain       30 DAYS OF CODE
 * Sub domain   DAY 20
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner scan = new Scanner(file);
        {
            int[] array = new int[scan.nextInt()];
            for (int i = 0; i < array.length; ++i) {
                array[i] = scan.nextInt();
            }
            sort(array);
        }
        scan.close();
    }

    private static void sort(int[] array) {
        int totalSwaps = 0;
        boolean isSorted;

        do {
            isSorted = true;
            for (int i = 0; i < array.length - 1; ++i) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;

                    isSorted = false;
                    totalSwaps++;
                }
            }
        } while (!isSorted);

        System.out.println("Array is sorted in " + totalSwaps + " swaps.");
        System.out.println("First Element: " + array[0]);
        System.out.println("Last Element: " + array[array.length - 1]);
    }
}
