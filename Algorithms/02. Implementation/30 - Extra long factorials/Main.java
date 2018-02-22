/**
 *              30 | EXTRA LONG FACTORIALS
 * Domain       ALGORITHMS
 * Sub domain   IMPLEMENTATION
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner scan = new Scanner(file);
        int n = scan.nextInt();
        scan.close();

        extraLongFactorial(n);
        customFactorial(n);
    }

    private static void extraLongFactorial(int n) {
        BigInteger bigInt = new BigInteger(String.valueOf(n));
        while (--n > 0) {
            bigInt = bigInt.multiply(new BigInteger(String.valueOf(n)));
        }
        System.out.println(String.valueOf(bigInt));
    }

    private static void customFactorial(int n) {
        int[] digits = new int[200];

        // Initial product = 1
        digits[0] = 1;

        // Current number of digits in array
        int k = 0;

        // Remainder
        int carry = 0;

        for (int i = 1; i <= n; ++i) {
            for (int j = 0; j <= k; ++j) {
                digits[j] = digits[j] * i + carry;
                carry = digits[j] / 10;
                digits[j] = digits[j] % 10;
            }

            while (carry != 0) {
                k++;
                digits[k] = carry % 10;
                carry /= 10;
            }
        }

        for (int i = k; i >= 0; --i) {
            System.out.print(digits[i]);
        }
    }
}