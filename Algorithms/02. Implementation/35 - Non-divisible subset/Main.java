/**
 *              35 | NON-DIVISIBLE SUBSET
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
            int n = scan.nextInt();
            int divisor = scan.nextInt();
            int[] array = new int[n];
            for (int i = 0; i < array.length; i++) {
                array[i] = (scan.nextInt() % divisor);
            }

            int result = nonDivisibleSubset(array, divisor);
            System.out.println(result);
        }
        scan.close();
    }

    private static int nonDivisibleSubset(int[] array, int divisor) {
        if (divisor == 1) {
            return 1;
        }

        int[] freq = new int[divisor];
        for (int i : array) {
            freq[i]++;
        }

        /* For even divisors, only one value can be added to the result set */
        int result = (divisor % 2 == 0 && freq[divisor / 2] > 0) ? 1 : 0;

        /* At most one value which is evenly divisible can be added to the result set */
        result += (freq[0] > 0) ? 1 : 0;

        /* For every remainder pair, choose the biggest one */
        for (int i = 1; i <= divisor / 2; i++) {
            if (i != divisor - i) {
                result += Math.max(freq[i], freq[divisor - i]);
            }
        }

        return result;
    }
}
