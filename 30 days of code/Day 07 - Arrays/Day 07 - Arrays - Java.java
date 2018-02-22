/**
 *              ARRAYS | JAVA
 * Domain       30 DAYS OF CODE
 * Sub domain   DAY 07
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
        for(int i = 0; i < n; ++i) {
            array[i] = scan.nextInt();
        }
        scan.close();

        for (int i = n - 1; i >= 0 ; --i) {
            System.out.print(array[i] + " ");
        }
    }
}