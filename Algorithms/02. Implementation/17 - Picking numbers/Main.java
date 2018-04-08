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
        {
            Integer[] array = new Integer[scan.nextInt()];
            for (int i = 0; i < array.length; ++i) {
                array[i] = scan.nextInt();
            }

            pickingNumbers(array);
        }
        scan.close();
    }

    private static void pickingNumbers(Integer[] array) {
        Arrays.sort(array);
        int maxArray = 0;
        int length = array.length;
        for (int i = 0; i < array.length; ++i) {
            for (int j = i; j < array.length; ++j) {
                if (Math.abs(array[j] - array[i]) > 1) {
                    length = j - i;
                    break;
                }
            }
            maxArray = Math.max(length, maxArray);
        }
        System.out.println(maxArray);
    }
}
