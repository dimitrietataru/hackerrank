/**
 *              EXCEPTIONS (STRING TO INTEGER) | JAVA
 * Domain       30 DAYS OF CODE
 * Sub domain   DAY 16
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

        try {
            int n = Integer.parseInt(input);
            System.out.println(n);
        } catch (NumberFormatException nfe) {
            System.out.println("Bad String");
        }
    }
}