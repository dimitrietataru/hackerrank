/**
 *              60 | THE BOMBER MAN GAME
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
        int m = scan.nextInt();
        int seconds = scan.nextInt();
        seconds = (seconds > 1) ? (seconds % 4 + 4) : seconds;
        seconds--;
        scan.nextLine();
        int[][] matrix = new int[n][m];

        for (int i = 0; i < n; ++i) {
            String currentLine = scan.nextLine();
            for (int j = 0; j < currentLine.length(); ++j) {
                matrix[i][j] = currentLine.charAt(j) == 'O' ? 2 : 0;
            }
        }
        scan.close();

        play(matrix, n, m, seconds);
    }

    private static void play(int[][] matrix, int n, int m, int seconds) {
        int counter = 0;
        while (seconds-- > 0) {
            if (counter % 2 == 0) {
                for (int i = 0; i < n; ++i) {
                    for (int j = 0; j < m; ++j) {
                        if (matrix[i][j] == 0) {
                            matrix[i][j] = 3;
                        } else {
                            matrix[i][j]--;
                        }
                    }
                }
            }
            else {
                for (int i = 0; i < n; ++i) {
                    for (int j = 0; j < m; ++j) {
                        if (matrix[i][j] > 0) {
                            if (matrix[i][j] == 1) {
                                matrix[i][j] = 0;
                                explode(matrix, n, m, i, j);
                            } else {
                                matrix[i][j]--;
                            }
                        }
                    }
                }
            }
            counter++;
        }
        printMatrix(matrix, n, m);
    }

    private static void explode(int[][] matrix, int n, int m, int i, int j) {
        boolean t = (i > 0), r = (j < m - 1), b = (i < n - 1), l = (j > 0);

        if (t && (matrix[i - 1][j] != 1)) {
            matrix[i - 1][j] = 0;
        }

        if (r && (matrix[i][j + 1] != 1)) {
            matrix[i][j + 1] = 0;
        }

        if (b && (matrix[i + 1][j] != 1)) {
            matrix[i + 1][j] = 0;
        }

        if (l && (matrix[i][j - 1] != 1)) {
            matrix[i][j - 1] = 0;
        }
    }

    private static void printMatrix(int[][] matrix, int n, int m) {
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                System.out.print((matrix[i][j] > 0) ? "O" : ".");
            }
            System.out.println();
        }
    }
}