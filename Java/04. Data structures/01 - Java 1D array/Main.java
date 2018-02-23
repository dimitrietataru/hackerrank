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
        int arrayLength = scan.nextInt();
        int[] array = new int[arrayLength];
        for (int i = 0; i < array.length; ++i) {
            array[i] = scan.nextInt();
        }
        scan.close();

        for (int n : array) {
            System.out.println(n);
        }
    }
}