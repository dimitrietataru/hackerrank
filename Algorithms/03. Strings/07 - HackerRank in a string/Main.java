/**
 *              07 | HACKERRANK IN A STRING
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
                String input = scan.nextLine();
                hackerrankInString(input);
            }
        }
        scan.close();
    }

    private static void hackerrankInString(String input) {
        String test = "hackerrank";
        int index = 0;

        for (char c : input.toCharArray()) {
            if (c == test.charAt(index)) {
                if (++index == test.length()) {
                    System.out.println("YES");
                    return;
                }
            }
        }
        System.out.println("NO");
    }
}
