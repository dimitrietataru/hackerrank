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
        {
            int[] chocolate = new int[scan.nextInt()];
            for (int i = 0; i < chocolate.length; ++i) {
                chocolate[i] = scan.nextInt();
            }
            int d = scan.nextInt();
            int m = scan.nextInt();

            shareChocolate(chocolate, d, m);
        }
        scan.close();
    }

    private static void shareChocolate(int[] chocolate, int d, int m) {
        int result = 0;
        for (int i = 0; i <= chocolate.length - m; ++i) {
            int currentSum = 0;
            for (int j = i; j < i + m; ++j) {
                currentSum += chocolate[j];
            }
            if (currentSum == d) {
                result++;
            }
        }
        System.out.println(result);
    }
}
