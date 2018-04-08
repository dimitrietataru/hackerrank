/**
 *              41 | TAUM AND B'DAY
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
            int testCases = scan.nextInt();
            while (testCases-- > 0) {
                long blacks = scan.nextLong();
                long whites = scan.nextLong();
                long blackCost = scan.nextLong();
                long whiteCost = scan.nextLong();
                long exchangeCost = scan.nextLong();
                taumAndBday(blacks, whites, blackCost, whiteCost, exchangeCost);
            }
        }
        scan.close();
    }

    private static void taumAndBday(long blacks, long whites, long b, long w, long x) {
        // Exchange black to white
        if ((b + x) < w) {
            System.out.println((blacks * b) + (whites * (b + x)));
            return;
        }

        // Exchange white to black
        if ((w + x) < b) {
            System.out.println((whites * w) + (blacks * (w + x)));
            return;
        }

        // Don't exchange
        System.out.println((blacks * b) + (whites * w));
    }
}
