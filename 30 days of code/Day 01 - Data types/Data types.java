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
        File file = new File("input.txt");
        Scanner scan = new Scanner(file);
        {
            int i = Integer.parseInt(scan.nextLine());
            double d = Double.parseDouble(scan.nextLine());
            String s = scan.nextLine();

            System.out.println(4 + i);
            System.out.println(4.0 + d);
            System.out.println("HackerRank" + s);
        }
        scan.close();
    }
}
