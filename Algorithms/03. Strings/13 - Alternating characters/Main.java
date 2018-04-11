/**
 *              13 | ALTERNATING CHARACTERS
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
                alternatingCharacters(input);
            }
        }
        scan.close();
    }

    private static void alternatingCharacters(String input) {
        int result = 0;

        Character ch = input.charAt(0);
        for (int i = 1; i < input.length(); ++i) {
            Character current = input.charAt(i);
            if (current.equals(ch)) {
                result++;
            }
            else {
                ch = current;
            }
        }

        System.out.println(result);
    }
}
