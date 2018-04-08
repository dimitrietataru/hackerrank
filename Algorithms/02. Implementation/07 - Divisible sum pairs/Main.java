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
        {
            int[] array = new int[scan.nextInt()];
            int divisor = scan.nextInt();

            for (int i = 0; i < array.length; ++i) {
                array[i] = scan.nextInt();
            }

            divisibleSumPairs(array, divisor);
        }
        scan.close();
    }

    private static void divisibleSumPairs(int[] array, int divisor) {
        int result = 0;
        for (int i = 0; i < array.length - 1; ++i) {
            for (int j = i + 1; j < array.length; ++j) {
                if ((array[i] + array[j]) % divisor == 0) {
                    result++;
                }
            }
        }
        System.out.println(result);
    }
}
