/**
 *              HELLO, WORLD | JAVA
 * Domain       RUNNING TIME AND COMPLEXITY
 * Sub domain   DAY 25
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner scan = new Scanner(file);
        {
            int testCases = scan.nextInt();
            while (testCases-- > 0) {
                int number = scan.nextInt();
                System.out.println(isPrime(number));
            }
        }
        scan.close();
    }

    private static String isPrime(int n) {
        if (n <= 1) {
            return "Not prime";
        }

        if (n == 2 || n == 3) {
            return "Prime";
        }

        if (n % 2 == 0 || n % 3 == 0) {
            return "Not prime";
        }

        for (int i = 4; (i * i) <= n; ++i) {
            if (n % i == 0) {
                return "Not prime";
            }
        }

        return "Prime";
    }
}
