/**
 *              BITWISE AND | JAVA
 * Domain       30 DAYS OF CODE
 * Sub domain   DAY 29
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
                int n = scan.nextInt();
                int k = scan.nextInt();
                maximumAnd(n, k);
            }
        }
        scan.close();
    }

    private static void maximumAnd(int n, int k) {
        int max = 0;
        for (int i = 1; i <= n - 1; ++i) {
            for (int j = i + 1; j <= n; ++j) {
                int and = i & j;
                max = (and > max && and < k) ? and : max;
            }
        }
        System.out.println(max);
    }
}
