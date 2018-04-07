/**
 *              45 | MODIFIED KAPREKAR NUMBERS
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
            long start = scan.nextLong();
            long end = scan.nextLong();

            modifiedKaprekarNumbers(start, end);
        }
        scan.close();
    }

    private static void modifiedKaprekarNumbers(long start, long end) {
        int count = 0;
        for (long i = start; i <= end; i++) {
            String power = String.valueOf(i * i);

            String l = power.substring(0, power.length() / 2);
            String r = power.substring(power.length() / 2);

            long left = l.isEmpty() ? 0 : Long.parseLong(l);
            long right = r.isEmpty() ? 0 : Long.parseLong(r);

            if (right + left == i) {
                System.out.print(i + " ");
                count++;
            }
        }
        if (count == 0) {
            System.out.println("INVALID RANGE");
        }
    }
}
