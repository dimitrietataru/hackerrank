/**
 *              53 | FAIR RATIONS
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
        int n = scan.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scan.nextInt();
        }
        scan.close();

        fairRations(array);
    }

    private static void fairRations(int[] array) {
        int count = 0;
        for (int i = 0; i < array.length - 1; ++i) {
            if (array[i] % 2 == 1) {
                array[i]++;
                array[i + 1]++;
                count++;
            }
        }
        if (array[array.length - 1] % 2 == 1) {
            System.out.println("NO");
        } else {
            System.out.println(count * 2);
        }
    }
}