/**
 *              02 | JAVA SUBSTRING
 * Domain       JAVA
 * Sub domain   STRINGS
 */

// https://docs.oracle.com/javase/8/docs/api/java/lang/String.html#substring

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner scan = new Scanner(file);
        {
            String s = scan.next();
            int start = scan.nextInt();
            int end = scan.nextInt();

            System.out.println(s.substring(start, end));
        }
        scan.close();
    }
}
