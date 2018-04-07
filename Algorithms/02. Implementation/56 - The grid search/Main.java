/**
 *              56 | THE GRID SEARCH
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
            int testCases = scan.nextInt();
            while(testCases-- > 0) {
                int x1 = scan.nextInt();
                int y1 = scan.nextInt();
                int[][] matrix1 = new int[x1 + 1][y1 + 1];
                for (int i = 0; i < x1; i++) {
                    String line = scan.next();
                    for (int j = 0; j < y1; j++) {
                        matrix1[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
                    }
                }

                int x2 = scan.nextInt();
                int y2 = scan.nextInt();
                int[][] matrix2 = new int[x2 + 1][y2 + 1];
                for (int i = 0; i < x2; i++) {
                    String line = scan.next();
                    for (int j = 0; j < y2; j++) {
                        matrix2[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
                    }
                }

                theGridSearch(matrix1, x1, y1, matrix2, x2, y2);
            }
        }
        scan.close();
    }

    private static void theGridSearch(int[][] m1, int x1, int y1, int[][] m2, int x2, int y2) {
        for (int i = 0; i < (x1 - x2 + 1); ++i) {
            for (int j = 0; j < (y1 - y2 + 1); ++j) {
                if (m1[i][j] == m2[0][0]) {
                    if (isFound(m1, m2, x2, y2, i, j)) {
                        System.out.println("YES");
                        return;
                    }
                }
            }
        }
        System.out.println("NO");
    }

    private static boolean isFound(int[][] m1, int[][] m2, int x2, int y2, int offX, int offY) {
        for (int i = 0; i < x2; i++) {
            for (int j = 0; j < y2; j++) {
                if (m1[i + offX][j + offY] != m2[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
