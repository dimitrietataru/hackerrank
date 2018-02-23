/**
 *              03 | JAVA SUBSTRING COMPARISONS
 * Domain       JAVA
 * Sub domain   STRINGS
 */

// https://en.wikipedia.org/wiki/Lexicographical_order

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");

        Scanner scan = new Scanner(file);
        String s = scan.next();
        int substringLength = scan.nextInt();
        scan.close();

        System.out.println(getSmallestAndLargest(s, substringLength));
    }

    private static String getSmallestAndLargest(String s, int substringLength) {
        if (s.length() == 0) {
            return "Empty string!";
        }

        if (substringLength > s.length()) {
            return "Length error!";
        }

        String smallest = s.substring(0, substringLength);
        String largest = s.substring(0, substringLength);

        for (int i = 1; i <= s.length() - substringLength; ++i) {
            String currentString = s.substring(i, i + substringLength);
            if (smallest.compareTo(currentString) > 0) {
                smallest = currentString;
            }
            if (largest.compareTo(currentString) < 0) {
                largest = currentString;
            }
        }
        return smallest + "\n" + largest;
    }
}