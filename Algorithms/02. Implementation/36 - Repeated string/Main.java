/**
 *              36 | REPEATED STRING
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
            String input = scan.next();
            long n = scan.nextLong();

            repeatedString(input, n);
        }
        scan.close();
    }

    private static void repeatedString(String input, long letters) {
        /* Calculate number of 'a' in input string and multiply it total apparitions */
        long count = letters / input.length();
        count *= getACount(input, input.length());

        /* Calculate number of 'a' in the remaining substring */
        long remainder = letters % input.length();
        count += getACount(input, remainder);

        System.out.println(count);
    }

    private static long getACount(String s, long length) {
        long result = 0;
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == 'a') {
                result++;
            }
        }
        return result;
    }
}
