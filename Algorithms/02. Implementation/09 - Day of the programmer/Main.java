/**
 *              09 | DAY OF THE PROGRAMMER
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
            int year = scan.nextInt();
            dayOfTheProgrammer(year);
        }
        scan.close();
    }

    private static void dayOfTheProgrammer(int year) {
        int day = 13;
        int month = 9;
        if (year >= 1700 && year <= 1917) {
            if (year % 4 == 0) {
                day = 12;
            }
        }

        if (year >= 1919 && year <= 2700) {
            if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) {
                day = 12;
            }
        }

        if (year == 1918) {
            day = 26;
        }

        System.out.printf("%d.0%d.%d", day, month, year);
    }
}
