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
        {
            String s = scan.next();
            int len = scan.nextInt();

            System.out.println(getSmallestAndLargest(s, len));
        }
        scan.close();
    }

    private static String getSmallestAndLargest(String s, int len) {
        if (s.length() == 0) {
            return "Empty string!";
        }

        if (len > s.length()) {
            return "Length error!";
        }
        String smallest = s.substring(0, len);
        String largest = s.substring(0, len);

        for (int i = 1; i <= s.length() - len; ++i) {
            String current = s.substring(i, i + len);
            if (smallest.compareTo(current) > 0) {
                smallest = current;
            }
            if (largest.compareTo(current) < 0) {
                largest = current;
            }
        }
        
        return smallest + "\n" + largest;
    }
}
