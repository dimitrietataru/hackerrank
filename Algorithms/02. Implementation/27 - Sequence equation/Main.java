/**
 *              27 | SEQUENCE EQUATION
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
            int[] array = new int[scan.nextInt() + 1];
            for (int i = 1; i < array.length; ++i) {
                array[scan.nextInt()] = i;
            }

            for (int i = 1; i < array.length; ++i) {
                int result = array[array[i]];
                System.out.println(result);
            }
        }
        scan.close();
    }
}
