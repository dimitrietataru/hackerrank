/**
 *              02 | JAVA EXCEPTION HANDLING
 * Domain       JAVA
 * Sub domain   EXCEPTION HANDLING
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        MyCalculator myCalculator = new MyCalculator();
        File file = new File("input.txt");
        Scanner scan = new Scanner(file);
        while (scan.hasNextInt()) {
            int n = scan.nextInt();
            int m = scan.nextInt();

            try {
                System.out.println(myCalculator.power(n, m));
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
        scan.close();
    }
}

class MyCalculator{
    public long power(int i1, int i2) throws Exception {
        if (i1 == 0 && i2 == 0) {
            throw new Exception("n and p should not be zero.");
        } else if (i1 < 0 || i2 < 0) {
            throw new Exception("n or p should not be negative.");
        }
        return (long) Math.pow(i1, i2);
    }
}