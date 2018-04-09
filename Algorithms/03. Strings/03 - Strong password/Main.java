/**
 *              03 | STRONG PASSWORD
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
            String pass = scan.next();
            strongPassword(pass);
        }
        scan.close();
    }

    private static void strongPassword(String pass) {
        int missLength = 0;
        if (pass.length() < 6) {
            missLength = 6 - pass.length();
        }

        int missChars = 0;
        if (pass.length() == pass.replaceAll("[0-9]", "").length()) {
            missChars++;
        }
        if (pass.length() == pass.replaceAll("[a-z]", "").length()) {
            missChars++;
        }
        if (pass.length() == pass.replaceAll("[A-Z]", "").length()) {
            missChars++;
        }
        if (pass.length() == pass.replaceAll("[!@#$%^&*()\\-+]", "").length()) {
            missChars++;
        }

        System.out.println(Math.max(missLength, missChars));
    }
}
