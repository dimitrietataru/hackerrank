/**
 *              08 | JAVA DATATYPES
 * Domain       JAVA
 * Sub domain   INTRODUCTION
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        long byte_low = (long) -Math.pow(2, 7);
        long byte_high = (long) Math.pow(2, 7) - 1;

        long short_low = (long) -Math.pow(2, 15);
        long short_high = (long) Math.pow(2, 15) - 1;

        long int_low = (long) -Math.pow(2, 31);
        long int_high = (long) Math.pow(2, 31) - 1;

        long long_low = (long) -Math.pow(2, 63);
        long long_high = (long) Math.pow(2, 63);

        System.out.println("BYTE:  " + byte_low + " .. " + byte_high);
        System.out.println("SHORT: " + short_low + " .. " + short_high);
        System.out.println("INT:   " + int_low + " .. " + int_high);
        System.out.println("LONG:  " + long_low + " .. " + long_high + "\n");

        File file = new File("input.txt");
        Scanner scan = new Scanner(file);
        {
            int testCases = scan.nextInt();
            while (testCases-- > 0) {
                try {
                    long x = scan.nextLong();
                    System.out.println(x + " can be fitted in:");
                    if (x >= byte_low && x <= byte_high) {
                        System.out.println("* byte");
                    }
                    if (x >= short_low && x <= short_high) {
                        System.out.println("* short");
                    }
                    if (x >= int_low && x <= int_high) {
                        System.out.println("* int");
                    }
                    if (x >= long_low && x <= long_high) {
                        System.out.println("* long");
                    }
                } catch (Exception e) {
                    System.out.println(scan.next() + " can't be fitted anywhere.");
                }
            }
        }
        scan.close();
    }
}
