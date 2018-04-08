/**
 *              03 | JAVA SUB ARRAY
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
        {
            int[] array = new int[scan.nextInt()];
            for (int i = 0; i < array.length; ++i) {
                array[i] = scan.nextInt();
            }
            negativeArrays(array);
        }
        scan.close();
    }

    private static void negativeArrays(int[] array) {
        int result = 0;
        for (int i = 0; i < array.length; ++i) {
            int sum = 0;
            for (int j = i; j < array.length; ++j) {
                sum += array[j];
                result += (sum < 0) ? 1 : 0;
            }
        }
        System.out.println(result);
    }
}
