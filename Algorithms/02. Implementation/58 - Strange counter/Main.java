/**
 *              58 | STRANGE COUNTER
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
            long n = scan.nextLong();
            strangeCounter(n);
        }
        scan.close();
    }

    private static void strangeCounter(long time) {
        long start = 0;
        long end = 3 + (start * 2);
        while (!(time > start && time <= end)) {
            start = end;
            end = 3 + (start * 2);
        }

        long result = end - time + 1;
        System.out.println(result);
    }
}
