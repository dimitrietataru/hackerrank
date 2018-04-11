/**
 *              11 | FUNNY STRING
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
            int testCases = scan.nextInt();
            scan.nextLine();
            while (testCases-- > 0) {
                String input = scan.next();
                funnyString(input);
            }
        }
        scan.close();
    }

    private static void funnyString(String input) {
        String reverse = new StringBuilder(input).reverse().toString();

        for (int i = 1; i < input.length(); ++i) {
            int dif1 = Math.abs(input.charAt(i) - input.charAt(i - 1));
            int dif2 = Math.abs(reverse.charAt(i) - reverse.charAt(i - 1));
            if (dif1 != dif2) {
                System.out.println("Not Funny");
                return;
            }
        }
        System.out.println("Funny");
    }
}
