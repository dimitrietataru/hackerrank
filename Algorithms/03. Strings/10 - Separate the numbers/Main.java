/**
 *              10 | SEPARATE THE NUMBERS
 * Domain       ALGORITHMS
 * Sub domain   STRINGS
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner scan = new Scanner(file);
        {
            int testCases = Integer.parseInt(scan.nextLine());
            while (testCases-- > 0) {
                String input = scan.next();
                String result = separateTheNumbers(input);
                System.out.println(result);
            }
        }
        scan.close();
    }

    private static String separateTheNumbers(String input) {
        if (input.length() == 1) {
            return "NO";
        }

        for (int i = 1; i <= input.length() / 2; ++i) {
            boolean isValid = checkNumbers(input, i);
            if (isValid) {
                return "YES " + input.substring(0, i);
            }
        }

        return "NO";
    }

    private static boolean checkNumbers(String input, int interval) {
        String str = input.substring(0, interval);
        long number = Long.parseLong(str);

        if (!str.equals(String.valueOf(number))) {
            return false;
        }

        for (int i = interval; i < input.length(); i += interval) {
            String expected = String.valueOf(++number);
            interval = expected.length();

            if (i + interval > input.length()) {
                return false;
            }

            String actually = input.substring(i, i + interval);
            if (!actually.equals(expected)) {
                return false;
            }
        }

        return true;
    }
}
