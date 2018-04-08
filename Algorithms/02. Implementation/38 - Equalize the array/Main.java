/**
 *              38 | EQUALIZE THE ARRAY
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
        {
            int[] array = new int[scan.nextInt()];
            for (int i = 0; i < array.length; ++i) {
                array[i] = scan.nextInt();
            }

            equalizeTheArray(array);
        }
        scan.close();
    }

    private static void equalizeTheArray(int[] array) {
        int[] freq = new int[100];
        for (int i : array) {
            freq[i - 1]++;
        }

        int max = Integer.MIN_VALUE;
        for (int i : freq) {
            max = Math.max(i, max);
        }

        System.out.println(array.length - max);
    }
}
