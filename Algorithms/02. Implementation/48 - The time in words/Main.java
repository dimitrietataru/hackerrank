/**
 *              48 | THE TIME IN WORDS
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
        int hour = scan.nextInt();
        int min = scan.nextInt();
        scan.close();

        theTimeInWords(hour, min);
    }

    private static void theTimeInWords(int h, int m) {
        final String[] words = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight",
            "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen",
            "seventeen", "eighteen", "nineteen", "twenty", "twenty one", "twenty two", "twenty three",
            "twenty four", "twenty five", "twenty six", "twenty seven", "twenty eight", "twenty nine" };

        if (m == 0) {
            System.out.println(words[h] + " o' clock");
        } else if (m == 15) {
            System.out.println("quarter past " + words[h]);
        } else if (m == 30) {
            System.out.println("half past " + words[h]);
        } else if (m == 45) {
            System.out.println("quarter to " + words[h + 1]);
        } else if (m < 30) {
            System.out.println(words[m] + " minutes past " + words[h]);
        } else {
            m = 60 - m;
            System.out.println(words[m] + " minutes to " + words[h + 1]);
        }
    }
}