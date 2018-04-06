/**
 *              08 | MIGRATORY BIRDS
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
            int[] birdsArray = new int[scan.nextInt()];
            for (int i = 0; i < birdsArray.length; ++i) {
                birdsArray[i] = scan.nextInt();
            }

            migratoryBirds(birdsArray);
        }
        scan.close();

    }

    private static void migratoryBirds(int[] birdsArray) {
        int[] freq = new int[5];
        for (int i : birdsArray) {
            freq[i - 1]++;
        }

        int max = 0;
        for (int i = 0; i < freq.length; ++i) {
            max = (freq[i] > freq[max]) ? i : max;
        }

        System.out.println(max + 1);
    }
}
