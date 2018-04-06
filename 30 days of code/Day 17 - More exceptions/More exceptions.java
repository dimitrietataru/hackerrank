/**
 *              MORE EXCEPTIONS | JAVA
 * Domain       30 DAYS OF CODE
 * Sub domain   DAY 17
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner scan = new Scanner(file);
        {
            Calculator calculator = new Calculator();
            int testCases = scan.nextInt();
            while (testCases-- > 0) {
                int n = scan.nextInt();
                int p = scan.nextInt();
                try {
                    int answer = calculator.power(n, p);
                    System.out.println(answer);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        scan.close();
    }
}

class Calculator {
    int power(int n, int p) throws Exception {
        if (n < 0 || p < 0) {
            throw new Exception("n and p should be non-negative");
        }
        return (int)Math.pow(n, p);
    }
}
