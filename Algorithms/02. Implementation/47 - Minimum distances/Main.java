/**
 *              47 | MINIMUM DISTANCES
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
            int[] array = new int[scan.nextInt()];
            for (int i = 0; i < array.length; i++) {
                array[i] = scan.nextInt();
            }

            minimumDistances(array);
        }
        scan.close();
    }

    private static void minimumDistances(int[] array) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    int distance = Math.abs(i - j);
                    min = Math.min(distance, min);
                    break;
                }
            }
        }
        System.out.println(Math.max(min, -1));
    }
}
