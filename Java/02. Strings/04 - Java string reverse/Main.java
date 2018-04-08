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
        {
            String input = scan.next();
            String reverse = new StringBuilder(input).reverse().toString();

            System.out.println((reverse.equals(input)) ? "Yes" : "No");
        }
        scan.close();
    }
}
