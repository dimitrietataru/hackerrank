/**
 *              02 | JAVA 2D ARRAY
 * Domain       JAVA
 * Sub domain   DATA STRUCTURES
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        final int n = 6;
        File file = new File("input.txt");
        Scanner scan = new Scanner(file);
        int arr[][] = new int[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                arr[i][j] = scan.nextInt();
            }
        }
        scan.close();

        int largestSum = Integer.MIN_VALUE;
        for (int i = 1; i < n - 1; ++i) {
            for (int j = 1; j < n - 1; ++j) {
                int currentSum = arr[i-1][j-1] + arr[i-1][j] + arr[i-1][j+1]
                                                + arr[i][j] +
                                 arr[i+1][j-1] + arr[i+1][j] + arr[i+1][j+1];
                if (currentSum > largestSum) {
                    largestSum = currentSum;
                }
            }
        }

        System.out.println(largestSum);
    }
}