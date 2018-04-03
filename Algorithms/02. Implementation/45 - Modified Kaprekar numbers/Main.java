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
        long start = scan.nextLong();
        long end = scan.nextLong();
        scan.close();

        modifiedKaprekarNumbers(start, end);
    }

    private static void modifiedKaprekarNumbers(long start, long end) {
        int count = 0;
        for (long i = start; i <= end; i++) {
            long power = (long) Math.pow(i, 2);
            String powerS = String.valueOf(power);
            String l = powerS.substring(0, powerS.length() / 2);
            String r = powerS.substring(powerS.length() / 2, powerS.length());
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