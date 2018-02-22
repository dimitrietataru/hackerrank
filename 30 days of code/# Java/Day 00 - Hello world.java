/**
 *              HELLO, WORLD | JAVA
 * Domain       30 DAYS OF CODE
 * Sub domain   DAY 00
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner scan = new Scanner(file);
        String s = scan.nextLine();

        System.out.println("Hello, World.");
        System.out.println(s);

        scan.close();
    }
}