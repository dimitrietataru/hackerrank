/**
 *              09 | BIRTHDAY CAKE CANDLES
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
        int n = scan.nextInt();

        int max = 1;
        int count = 0;
        for (int i = 0; i < n; ++i) {
            int in = scan.nextInt();

            if (in > max) {
                max = in;
                count = 1;
            }

            count += (max == in) ? 1 : 0;
        }
        scan.close();

        System.out.println(count);
    }
}