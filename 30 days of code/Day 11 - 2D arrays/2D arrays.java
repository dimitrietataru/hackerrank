/**
 *              2D ARRAYS | JAVA
 * Domain       30 DAYS OF CODE
 * Sub domain   DAY 11
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner scan = new Scanner(file);
        int n = 6;
        int[][] matrix = new int[n][n];
        for(int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                matrix[i][j] = scan.nextInt();
            }
        }
        scan.close();

        hourGlass(matrix, n);
    }

    private static void hourGlass(int[][] matrix, int n) {
        int max = Integer.MIN_VALUE;
        for(int i = 1; i < n - 1; ++i) {
            for (int j = 1; j < n - 1; ++j) {
                int currentSum = matrix[i - 1][j - 1] + matrix[i - 1][j] + matrix[i - 1][j + 1]
                                                        + matrix[i][j] +
                                 matrix[i + 1][j - 1] + matrix[i + 1][j] + matrix[i + 1][j + 1];
                max = (currentSum > max) ? currentSum : max;
            }
        }

        System.out.println(max);
    }
}