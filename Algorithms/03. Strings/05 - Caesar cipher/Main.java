/**
 *              05 | CAESAR CIPHER
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
            scan.nextLine();
            String input = scan.next();
            int rotate = scan.nextInt();
            caesarCipher(input, rotate);
        }
        scan.close();
    }

    private static void caesarCipher(String input, int rotate) {
        char[] chars = input.toCharArray();
        for (int i = 0; i < chars.length; ++i) {
            char c = chars[i];
            if (Character.isLowerCase(c)) {
                chars[i] = (char) ((c - 'a' + rotate) % 26 + 'a');
            } else if (Character.isUpperCase(c)) {
                chars[i] = (char) ((c - 'A' + rotate) % 26 + 'A');
            }
        }
        System.out.println(String.valueOf(chars));
    }
}
