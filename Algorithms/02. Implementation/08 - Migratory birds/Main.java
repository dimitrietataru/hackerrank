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
        int n = scan.nextInt();
        int[] birdsArray = new int[n];
        for (int i = 0; i < n; ++i) {
            birdsArray[i] = scan.nextInt();
        }
        scan.close();

        migratoryBirds(birdsArray);
    }

    private static void migratoryBirds(int[] birdsArray) {
        int[] characteristicArray = new int[5];
        for (int i : birdsArray) {
            characteristicArray[i - 1]++;
        }

        int max = 0;
        for (int i = 0; i < characteristicArray.length; ++i) {
            max = (characteristicArray[i] > characteristicArray[max]) ? i : max;
        }
        
        System.out.println(max + 1);
    }
}