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

        int n = scan.nextInt();
        int m = scan.nextInt();
        int rotations = scan.nextInt();
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                matrix[i][j] = scan.nextInt();
            }
        }
        scan.close();

        matrixRotation(matrix, n, m, rotations);
    }

    private static void matrixRotation(int[][] matrix, int n, int m, int r) {
        int totalLayers = (n >= m) ? (m / 2) : (n / 2);
        for (int layer = 0; layer < totalLayers; ++layer) {
            List<Integer> inputLayer = getLayer(matrix, n, m, layer);
            List<Integer> rotatedLayer = rotateLayer(inputLayer, r);
            updateMatrix(matrix, n, m, rotatedLayer, layer);
        }
        printMatrix(matrix, n, m);
    }

    private static List<Integer> getLayer(int[][] matrix, int n, int m, int layer) {
        List<Integer> layerList = new ArrayList<>();
        for (int i = layer; i < m - layer; ++i) {
            layerList.add(matrix[layer][i]);
        }
        for (int i = (layer + 1); i < (n - layer - 1); ++i) {
            layerList.add(matrix[i][m - layer - 1]);
        }
        for (int i = (m - layer - 1); i >= layer; --i) {
            layerList.add(matrix[n - layer - 1][i]);
        }
        for (int i = (n - layer - 2); i > layer; --i) {
            layerList.add(matrix[i][layer]);
        }

        return layerList;
    }

    private static List<Integer> rotateLayer(List<Integer> layer, int r) {
        r = (layer.size() + r) % layer.size();

        List<Integer> rotatedLayer = new ArrayList<>(layer.size());
        for (int i = 0; i < layer.size(); ++i) {
            rotatedLayer.add(i, layer.get((i + layer.size() + r) % layer.size()));
        }

        return rotatedLayer;
    }

    private static void updateMatrix(int[][] matrix, int n, int m, List<Integer> elements, int layer) {
        int index = 0;
        for (int i = layer; i < m - layer; ++i) {
            matrix[layer][i] = elements.get(index++);
        }
        for (int i = (layer + 1); i < (n - layer - 1); ++i) {
            matrix[i][m - layer - 1] = elements.get(index++);
        }
        for (int i = (m - layer - 1); i >= layer; --i) {
            matrix[n - layer - 1][i] = elements.get(index++);
        }
        for (int i = (n - layer - 2); i > layer; --i) {
            matrix[i][layer] = elements.get(index++);
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