/**
 *              04 | JAVA STRING REVERSE
 * Domain       JAVA
 * Sub domain   STRINGS
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner scan = new Scanner(file);
        String input = scan.next();
        scan.close();

        String reverse = "";
        for (int i = input.length() - 1; i >= 0; --i) {
            reverse = reverse.concat(String.valueOf(input.charAt(i)));
        }

        System.out.println((reverse.equals(input)) ? "Yes" : "No");
    }
}