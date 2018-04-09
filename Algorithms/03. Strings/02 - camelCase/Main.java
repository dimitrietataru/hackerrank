/**
 *              02 | CamelCase
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
            camelCase(input);
        }
        scan.close();
    }

    private static void camelCase(String input) {
        int result = 1;
        for (char ch : input.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                result++;
            }
        }
        System.out.println(result);
    }

    private static void camelCase2(String input) {
        System.out.println(input.chars().filter(c -> Character.isUpperCase(c)).count() + 1);
    }
}
