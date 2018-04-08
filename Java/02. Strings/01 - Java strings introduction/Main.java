/**
 *              01 | JAVA STRINGS INTRODUCTION
 * Domain       JAVA
 * Sub domain   STRINGS
 */

// https://en.wikipedia.org/wiki/String_(computer_science)

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner scan = new Scanner(file);
        {
            String a = scan.next();
            String b = scan.next();

            int lengthSum = a.length() + b.length();
            System.out.println(lengthSum);

            if (a.charAt(0) > b.charAt(0)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }

            String upperA = a.substring(0,1).toUpperCase() + a.substring(1);
            String upperB = b.substring(0,1).toUpperCase() + b.substring(1);
            System.out.println(upperA + " " + upperB);
        }
        scan.close();
    }
}
