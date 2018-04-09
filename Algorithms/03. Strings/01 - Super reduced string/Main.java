/**
 *              01 | SUPER REDUCED STRING
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
            String input = scan.next();
            superReducedString(input);
        }
        scan.close();
    }

    private static void superReducedString(String input) {
        boolean isReduced = false;
        while (!isReduced) {
            isReduced = true;
            int maxIndex = input.length() - 1;
            for (int i = 0; i < maxIndex; ++i) {
                if (input.charAt(i) == input.charAt(i + 1)) {
                    input = input.substring(0, i) + input.substring(i + 2);
                    isReduced = false;
                    maxIndex -= 2;
                }
            }
        }
        if ("".equals(input)) {
            System.out.println("Empty String");
        } else {
            System.out.println(input);
        }
    }
}
