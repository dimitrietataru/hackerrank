/**
 *              INTRO TO CONDITIONAL STATEMENTS | JAVA
 * Domain       30 DAYS OF CODE
 * Sub domain   DAY 03
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner scan = new Scanner(file);
        int n = scan.nextInt();
        scan.close();

        introToConditionalStatements(n);
    }

    private static void introToConditionalStatements(int n) {
        if (n % 2 == 1) {
            System.out.println("Weird");
        } else {
            if ((n > 20) || ((n >= 2) && (n <= 5))) {
                System.out.println("Not Weird");
            }
            if ((n >= 6) && (n <= 20)) {
                System.out.println("Weird");
            }
        }
    }
}