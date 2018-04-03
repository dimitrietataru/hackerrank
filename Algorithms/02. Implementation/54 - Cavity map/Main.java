/**
 *              54 | CAVITY MAP
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
        int matrix[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            String s = scan.next();
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
            }
        }
        scan.close();

        cavityMap(matrix, n);
    }

    private static void cavityMap(int[][] mat, int n) {
        for (int i = 0; i < n && n > 1; i++) {
            System.out.print((i < n - 1) ? mat[0][i] : mat[0][i] + "\n");
        }

        for (int i = 1; i < n - 1; i++) {
            System.out.print(mat[i][0]);

            for (int j = 1; j < n - 1; j++) {
                int x = mat[i][j];
                if ((x > mat[i - 1][j]) && (x > mat[i + 1][j])
                        && (x > mat[i][j - 1]) && (x > mat[i][j + 1])) {
                    System.out.print("X");
                } else {
                    System.out.print(mat[i][j]);
                }
            }

            System.out.print(mat[i][n - 1] + "\n");
        }

        for (int i = 0; i < n; i++) {
            System.out.print(mat[n - 1][i]);
        }
    }
}