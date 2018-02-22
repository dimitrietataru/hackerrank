/**
 *              06 | BIRTHDAY CHOCOLATE
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
        int[] chocolateBar = new int[n];
        for (int i = 0; i < n; ++i) {
            chocolateBar[i] = scan.nextInt();
        }
        int d = scan.nextInt();
        int m = scan.nextInt();
        scan.close();

        shareChocolate(chocolateBar, d, m);
    }

    private static void shareChocolate(int[] choco, int d, int m) {
        int result = 0;
        for (int i = 0; i <= choco.length - m; ++i) {
            int currentSum = 0;
            for (int j = i; j < i + m; ++j) {
                currentSum += choco[j];
            }
            if (currentSum == d) {
                result++;
            }
        }
        System.out.println(result);
    }
}