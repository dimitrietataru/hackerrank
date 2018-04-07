/**
 *              66 | 3D SURFACE AREA
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
            int toyLayers = 1;
            int h = scan.nextInt();
            int w = scan.nextInt();
            int[][] matrix = new int[h][w];
            for (int i = 0; i < h; ++i) {
                for (int j = 0; j < w; ++j) {
                    int value = scan.nextInt();
                    matrix[i][j] = value;
                    toyLayers = Math.max(value, toyLayers);
                }
            }
            surfaceArea(h, w, matrix, toyLayers);
        }
        scan.close();
    }

    private static void surfaceArea(int h, int w, int[][] matrix, int layers) {
        int sum = (w * h) + (2 * (w + h));

        while (layers-- > 0) {
            for (int i = 0; i < h; ++i) {
                for (int j = 0; j < w; ++j) {
                    matrix[i][j]--;
                }
            }

            for (int i = 0; i < h; ++i) {
                for (int j = 0; j < w; ++j) {
                    if (matrix[i][j] == 0) {
                        sum++;
                    }
                    if (matrix[i][j] <= 0) continue;

                    boolean t = (i == 0), b = (i == h - 1), l = (j == 0), r = (j == w - 1);
                    sum += (!t && matrix[i - 1][j] <= 0) ? 1 : 0;
                    sum += (!b && matrix[i + 1][j] <= 0) ? 1 : 0;
                    sum += (!l && matrix[i][j - 1] <= 0) ? 1 : 0;
                    sum += (!r && matrix[i][j + 1] <= 0) ? 1 : 0;

                    sum += (t ? 1 : 0) + (b ? 1 : 0) + (l ? 1 : 0) + (r ? 1 : 0);
                }
            }
        }
        System.out.println(sum);
    }
}
