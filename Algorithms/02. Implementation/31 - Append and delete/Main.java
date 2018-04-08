/**
 *              31 | APPEND AND DELETE
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
            String str1 = scan.nextLine();
            String str2 = scan.nextLine();
            int operations = scan.nextInt();
            appendAndDelete(str1, str2, operations);
        }
        scan.close();
    }

    private static void appendAndDelete(String str1, String str2, int operations) {
        int len1 = str1.length();
        int len2 = str2.length();
        int common = commonLength(str1, str2);

        /* Check if there are enough operations to equalize strings */
        if ((len1 + len2) - (2 * common) > operations) {
            System.out.println("No");
            return;
        }

        /* Check if there are odd/even operations left */
        if (((len1 + len2) - (2 * common)) % 2 == operations % 2) {
            System.out.println("Yes");
            return;
        }

        /* Check if we can perform multiple deletes */
        if (len1 + len2 - operations < 0) {
            System.out.println("Yes");
            return;
        }

        /* Everything failed. Can't equalize strings */
        System.out.println("No");
    }

    private static int commonLength(String str1, String str2) {
        int result = 0;
        int minIndex = Math.min(str1.length(), str2.length());
        for (int i = 0; i < minIndex; ++i) {
            if (str1.charAt(i) == str2.charAt(i)) {
                result++;
            } else {
                break;
            }
        }
        return result;
    }
}
