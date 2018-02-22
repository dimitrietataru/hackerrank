/**
 *              05 | DIAGONAL DIFFERENCE
 * Domain       ALGORITHMS
 * Sub domain   WARMUP
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner scan = new Scanner(file);
        int n = scan.nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                matrix[i][j] = scan.nextInt();
            }
        }
        scan.close();

        int result = diagonalDifference(matrix, n);
        System.out.println(result);

        int superResult = superDiagonalDifference(matrix, n);
        System.out.println(superResult);
    }

    private static int diagonalDifference(int[][] matrix, int n) {
        int sumDiagonal1 = 0;
        int sumDiagonal2 = 0;

        for (int i = 0; i < n; ++i) {
            sumDiagonal1 += matrix[i][i];
            sumDiagonal2 += matrix[i][n - i - 1];
        }
        return Math.abs(sumDiagonal1 - sumDiagonal2);
    }

    private static int superDiagonalDifference(int[][] matrix, int n) {
        int sumDiagonal1 = 0;
        int sumDiagonal2 = 0;

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i == j) {
                    sumDiagonal1 += matrix[i][j];
                }
                if ((i + j) == (n - 1)) {
                    sumDiagonal2 += matrix[i][j];
                }
            }
        }
        return Math.abs(sumDiagonal1 - sumDiagonal2);
    }
}