/**
 *              07 | DIVISIBLE SUM PAIRS
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
        int n = scan.nextInt();
        int k = scan.nextInt();
        int[] inputArray = new int[n];
        for (int i = 0; i < n; ++i) {
            inputArray[i] = scan.nextInt();
        }
        scan.close();

        divisibleSumPairs(inputArray, k);
    }

    private static void divisibleSumPairs(int[] array, int k) {
        int result = 0;
        for (int i = 0; i < array.length - 1; ++i) {
            for (int j = i + 1; j < array.length; ++j) {
                if ((array[i] + array[j]) % k == 0) {
                    result++;
                }
            }
        }
        System.out.println(result);
    }
}