/**
 *              59 | ABSOLUTE PERMUTATION
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
        int testCases = scan.nextInt();
        while (testCases-- > 0) {
            int n = scan.nextInt();
            int k = scan.nextInt();

            absolutePermutation(n, k);
        }
        scan.close();
    }

    private static void absolutePermutation(int n, int k) {
        if (k == 0) {
            for (int i = 1; i <= n; ++i) {
                System.out.print(i + " ");
            }
            System.out.println();
        } else if (n % (2 * k) == 0){
            int kSinged = k;
            for(int i = 1; i <= n; ++i) {
                System.out.print((i + kSinged) + " ");
                if (i % k == 0) {
                    kSinged *= -1;
                }
            }
            System.out.println();
        } else {
            System.out.println("-1");
        }
    }
}