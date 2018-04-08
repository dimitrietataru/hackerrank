/**
 *              11 | JAVA MD5
 * Domain       JAVA
 * Sub domain   ADVANCED
 */

// https://en.wikipedia.org/wiki/MD5

import java.io.File;
import java.io.FileNotFoundException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, NoSuchAlgorithmException {
        File file = new File("input.txt");
        Scanner scan = new Scanner(file);
        {
            String input = scan.next();
            MD5(input);
        }
        scan.close();
    }

    private static void MD5(String input) throws NoSuchAlgorithmException {

        /* Encode the String using MD5 */
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(input.getBytes());
        byte[] result = md.digest();

        /* Print the encoded value in hexadecimal */
        for (byte b : result) {
            System.out.printf("%02x", b);
        }
    }
}

/*
    %02x EXPLAINED
    02  - 2 characters, with leading zeros if necessary
    x   - hexadecimal
*/
