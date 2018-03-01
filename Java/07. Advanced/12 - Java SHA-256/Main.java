/**
 *              12 | JAVA SHA-256
 * Domain       JAVA
 * Sub domain   ADVANCED
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, NoSuchAlgorithmException {
        File file = new File("input.txt");
        Scanner scan = new Scanner(file);
        String input = scan.next();
        scan.close();

        SHA256(input);
    }

    private static void SHA256(String input) throws NoSuchAlgorithmException{
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(input.getBytes());
        byte[] result = md.digest();

        for (byte b : result) {
            System.out.printf("%02x", b);
        }
    }
}