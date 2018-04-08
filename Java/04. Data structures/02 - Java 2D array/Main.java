/**
 *              02 | JAVA 2D ARRAY
 * Domain       JAVA
 * Sub domain   DATA STRUCTURES
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner scan = new Scanner(file);
        {
            final int n = 6;
            int mat[][] = new int[n][n];
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    mat[i][j] = scan.nextInt();
                }
            }
            largestSum(mat, n);
        }
        scan.close();
    }

    private static void largestSum(int[][] mat, int n) {
        int result = Integer.MIN_VALUE;
        for (int i = 1; i < n - 1; ++i) {
            for (int j = 1; j < n - 1; ++j) {
                int sum = mat[i-1][j-1] + mat[i-1][j] + mat[i-1][j+1]
                                         + mat[i][j] +
                          mat[i+1][j-1] + mat[i+1][j] + mat[i+1][j+1];
                result = Math.max(sum, result);
            }
        }

        System.out.println(result);
    }
}
