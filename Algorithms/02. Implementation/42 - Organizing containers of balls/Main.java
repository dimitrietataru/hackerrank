/**
 *              42 | ORGANIZING CONTAINERS OF BALLS
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
        int testCases = scan.nextInt();
        while (testCases-- > 0) {
            int n = scan.nextInt();
            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; ++i) {
                for(int j = 0; j < n; ++j) {
                    matrix[i][j] = scan.nextInt();
                }
            }
            organizingContainersOfBalls(matrix, n);
        }
        scan.close();
    }

    private static void organizingContainersOfBalls(int[][] matrix, int n) {
        long[] types = new long[n];
        long[] containers = new long[n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                types[i] += matrix[j][i];
                containers[i] += matrix[i][j];
            }
        }
        Arrays.sort(types);
        Arrays.sort(containers);
        System.out.println(Arrays.equals(types, containers) ? "Possible" : "Impossible");
    }

    private static void organizingContainersOfBallsHackerRank(int[][] matrix, int n) {
        int[] a = new int[n];                           // Number of balls in each container
        int[] b = new int[n];                           // Number of balls of each type
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                a[i] += matrix[i][j];
                b[j] += matrix[i][j];
            }
        }

        for (int i = 0; i < n; ++i) {
            int j;
            for (j = i; j < n; ++j) {
                if (a[i] == b[j]) {             // Ball type can exactly fill a container
                    int temp = b[j];            // Swap positions
                    b[j] = b[i];                // Don't check that ball-container combo again
                    b[i] = temp;
                    break;
                }
            }
            if (j == n) {                       // Array iterated and no matching container was found
                System.out.println("Impossible");
                return;
            }
        }
        System.out.println("Possible");
    }
}