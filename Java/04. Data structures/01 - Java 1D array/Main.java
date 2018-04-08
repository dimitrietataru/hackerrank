/**
 *              01 | JAVA 1D ARRAY
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

            for (int i : array) {
                System.out.println(i);
            }
        }
        scan.close();
    }
}
