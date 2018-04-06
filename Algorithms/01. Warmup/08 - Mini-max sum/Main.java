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
        {
            long[] array = new long[5];
            long max = Long.MIN_VALUE;
            long min = Long.MAX_VALUE;
            long sum = 0;

            for (int i = 0; i < array.length; ++i) {
                array[i] = scan.nextInt();
                sum+= array[i];

                max = Math.max(array[i], max);
                min = Math.min(array[i], min);
            }

            System.out.println((sum - max) + " " + (sum - min));
        }
        scan.close();
    }
}
