/**
 *              15 | THE LOVE-LETTER MYSTERY
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
                //loveLetterMystery(input);
                System.out.println(loveLetterMysteryRecursion(input, 0, input.length() - 1));
            }
        }
        scan.close();
    }

    private static void loveLetterMystery(String input) {
        int result = 0;
        for (int i = 0; i < input.length() / 2; ++i) {
            Character left = input.charAt(i);
            Character right = input.charAt(input.length() - i - 1);
            result += Math.abs(left - right);
        }
        System.out.println(result);
    }

    private static int loveLetterMysteryRecursion(String input, int i, int j) {
        if (i >= j) {
            return 0;
        }

        Character left = input.charAt(i);
        Character right = input.charAt(input.length() - i - 1);

        return Math.abs(left - right) + loveLetterMysteryRecursion(input, ++i, --j);
    }
}
