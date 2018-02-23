/**
 *              03 | JAVA SUBARRAY
 * Domain       JAVA
 * Sub domain   DATA STRUCTURES
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner scan = new Scanner(file);
        int n = scan.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; ++i) {
            array[i] = scan.nextInt();
        }
        scan.close();

        int negativeArrays = 0;
        for (int i = 0; i < n; ++i) {
            int sum = 0;
            for (int j = i; j < n; ++j) {
                sum += array[j];
                negativeArrays += (sum < 0) ? 1 : 0;
            }
        }
        System.out.println(negativeArrays);
    }
}