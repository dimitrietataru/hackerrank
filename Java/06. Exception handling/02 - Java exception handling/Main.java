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
        File file = new File("input.txt");
        Scanner scan = new Scanner(file);
        {
            MyCalculator calc = new MyCalculator();
            while (scan.hasNextInt()) {
                int n = scan.nextInt();
                int m = scan.nextInt();

                try {
                    System.out.println(calc.power(n, m));
                } catch (Exception e) {
                    System.out.println(e.toString());
                }
            }
        }
        scan.close();
    }
}

class MyCalculator{
    long power(int num1, int num2) throws Exception {
        if (num1 == 0 && num2 == 0) {
            throw new Exception("n and p should not be zero.");
        } else if (num1 < 0 || num2 < 0) {
            throw new Exception("n or p should not be negative.");
        }
        return (long) Math.pow(num1, num2);
    }
}
