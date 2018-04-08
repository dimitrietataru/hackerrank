/**
 *              05 | JAVA OUTPUT FORMATTING
 * Domain       JAVA
 * Sub domain   INTRODUCTION
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner scan = new Scanner(file);
        {
            System.out.println("================================");
            for(int i = 0; i < 3; i++) {
                String s = scan.next();
                int n = scan.nextInt();
                System.out.printf("%-15s%03d%n", s, n);
            }
            System.out.println("================================");
        }
        scan.close();
    }
}
