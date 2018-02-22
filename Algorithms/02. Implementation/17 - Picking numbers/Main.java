/**
 *              17 | PICKING NUMBERS
 * Domain       ALGORITHMS
 * Sub domain   IMPLEMENTATION
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner scan = new Scanner(file);
        int n = scan.nextInt();
        Integer[] array = new Integer[n];
        for (int i = 0; i < array.length; ++i) {
            array[i] = scan.nextInt();
        }
        scan.close();

        pickingNumbers(array);
    }

    private static void pickingNumbers(Integer[] array) {
        Arrays.sort(array);
        int maxArray = 0;
        int currentLength = array.length;
        for (int i = 0; i < array.length; ++i) {
            for (int j = i; j < array.length; ++j) {
                if (Math.abs(array[j] - array[i]) > 1) {
                    currentLength = j - i;
                    break;
                }
            }
            maxArray = (currentLength > maxArray) ? currentLength : maxArray;
        }
        System.out.println(maxArray);
    }
}