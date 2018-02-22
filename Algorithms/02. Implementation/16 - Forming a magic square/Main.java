/**
 *              16 | FORMING A MAGIC SQUARE
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
        int[] characteristic = new int[9];
        int[][] matrix = new int[3][3];
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                matrix[i][j] = scan.nextInt();
                characteristic[matrix[i][j] - 1]++;
            }
        }
        scan.close();

        int minCost = Integer.MAX_VALUE;
        for (int[][] array : seed) {
            int currentCost = 0;
            for (int i = 0; i < 3; ++i) {
                for (int j = 0; j < 3; ++j) {
                    currentCost += Math.abs(matrix[i][j] - array[i][j]);
                }
            }
            minCost = (currentCost < minCost) ? currentCost : minCost;
        }

        System.out.println(minCost);
    }

    private static final int[][][] seed = {
            {{8, 1, 6}, {3, 5, 7}, {4, 9, 2}},
            {{8, 3, 4}, {1, 5, 9}, {6, 7, 2}},
            {{6, 1, 8}, {7, 5, 3}, {2, 9, 4}},
            {{6, 7, 2}, {1, 5, 9}, {8, 3, 4}},
            {{4, 9, 2}, {3, 5, 7}, {8, 1, 6}},
            {{4, 3, 8}, {9, 5, 1}, {2, 7, 6}},
            {{2, 9, 4}, {7, 5, 3}, {6, 1, 8}},
            {{2, 7, 6}, {9, 5, 1}, {4, 3, 8}}};
}