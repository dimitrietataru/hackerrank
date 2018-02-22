/**
 *              08 | MINI-MAX SUM
 * Domain       ALGORITHMS
 * Sub domain   WARMUP
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner scan = new Scanner(file);

        long[] array = new long[5];
        long max = Long.MIN_VALUE;
        long min = Long.MAX_VALUE;
        long sum = 0;

        for (int i = 0; i < array.length; ++i) {
            array[i] = scan.nextInt();
            sum+= array[i];

            if (array[i] > max) {
                max = array[i];
            }
            if (array[i] < min) {
                min = array[i];
            }
        }
        scan.close();

        System.out.println((sum - max) + " " + (sum - min));
    }
}