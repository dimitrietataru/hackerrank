/**
 *              35 | NON-DIVISIBLE SUBSET
 * Domain       ALGORITHMS
 * Sub domain   IMPLEMENTATION
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner scan = new Scanner(file);
        int n = scan.nextInt();
        int divisor = scan.nextInt();
        int[] dividedArray = new int[n];
        for (int i = 0; i < dividedArray.length; i++) {
            dividedArray[i] = (scan.nextInt() % divisor);
        }
        scan.close();

        int result = nonDivisibleSubset(dividedArray, divisor);
        System.out.println(result);
    }

    private static int nonDivisibleSubset(int[] array, int divisor) {
        if (divisor == 1) {
            return 1;
        }

        int[] modArray = new int[divisor];
        for (int i : array) {
            modArray[i]++;
        }

        System.out.println(Arrays.toString(modArray));

        /* For even divisors, only one value can be added to the result set */
        int result = (divisor % 2 == 0 && modArray[divisor / 2] > 0) ? 1 : 0;

        /* At most one value which is evenly divisible can be added to the result set */
        result += (modArray[0] > 0) ? 1 : 0;

        /* For every remainder pair, choose the biggest one */
        for (int i = 1; i <= divisor / 2; i++) {
                result += (i != divisor - i) ? Math.max(modArray[i], modArray[divisor - i]) : 0;
        }

        return result;
    }
}