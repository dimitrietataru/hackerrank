/**
 *              64 | MATRIX LAYER ROTATION
 * Domain       ALGORITHMS
 * Sub domain   IMPLEMENTATION
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner scan = new Scanner(file);
        {
            int n = scan.nextInt();
            int m = scan.nextInt();
            int rotations = scan.nextInt();
            int[][] matrix = new int[n][m];
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < m; ++j) {
                    matrix[i][j] = scan.nextInt();
                }
            }
            matrixRotation(matrix, n, m, rotations);
        }
        scan.close();
    }

    private static void matrixRotation(int[][] matrix, int n, int m, int rotations) {
        int layers = (n >= m) ? (m / 2) : (n / 2);

        for (int l = 0; l < layers; ++l) {
            List<Integer> layerAsList = getLayer(matrix, n, m, l);
            List<Integer> rotatedLayer = rotateLayer(layerAsList, rotations);
            updateMatrix(matrix, n, m, l, rotatedLayer);
        }
        printMatrix(matrix, n, m);
    }

    private static List<Integer> getLayer(int[][] matrix, int n, int m, int l) {
        List<Integer> result = new ArrayList<>();

        for (int i = l; i < m - l; ++i) {
            result.add(matrix[l][i]);
        }
        for (int i = (l + 1); i < (n - l - 1); ++i) {
            result.add(matrix[i][m - l - 1]);
        }
        for (int i = (m - l - 1); i >= l; --i) {
            result.add(matrix[n - l - 1][i]);
        }
        for (int i = (n - l - 2); i > l; --i) {
            result.add(matrix[i][l]);
        }

        return result;
    }

    private static List<Integer> rotateLayer(List<Integer> layer, int r) {
        r = (layer.size() + r) % layer.size();

        List<Integer> result = new ArrayList<>(layer.size());
        for (int i = 0; i < layer.size(); ++i) {
            int indexR = (i + r) % layer.size();
            result.add(layer.get(indexR));
        }

        return result;
    }
    
    private static void updateMatrix(int[][] matrix, int n, int m, int l, List<Integer> elements) {
        int index = 0;
        for (int i = l; i < m - l; ++i) {
            matrix[l][i] = elements.get(index++);
        }
        for (int i = (l + 1); i < (n - l - 1); ++i) {
            matrix[i][m - l - 1] = elements.get(index++);
        }
        for (int i = (m - l - 1); i >= l; --i) {
            matrix[n - l - 1][i] = elements.get(index++);
        }
        for (int i = (n - l - 2); i > l; --i) {
            matrix[i][l] = elements.get(index++);
        }
    }

    private static void printMatrix(int[][] matrix, int n, int m) {
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
