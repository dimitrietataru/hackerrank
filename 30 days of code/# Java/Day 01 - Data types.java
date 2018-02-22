/**
 *              DATA TYPES | JAVA
 * Domain       30 DAYS OF CODE
 * Sub domain   DAY 01
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        int i = 4;
        double d = 4.0;
        String s = "HackerRank ";

        File file = new File("input.txt");
        Scanner scan = new Scanner(file);

        int i2 = scan.nextInt();
        scan.nextLine();
        double d2 = Double.parseDouble(scan.nextLine());
        String s2 = scan.nextLine();

        scan.close();

        System.out.println(i + i2);
        System.out.println(d + d2);
        System.out.println(s + s2);
    }
}