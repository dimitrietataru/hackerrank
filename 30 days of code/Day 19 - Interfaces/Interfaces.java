/**
 *              INTERFACES | JAVA
 * Domain       30 DAYS OF CODE
 * Sub domain   DAY 19
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner scan = new Scanner(file);
        {
            int n = scan.nextInt();

            IAdvancedArithmetic calculator = new Calculator();
            System.out.println("I implemented: " + calculator.getClass().getInterfaces()[0].getName());

            int sum = calculator.divisorSum(n);
            System.out.println(sum);
        }
        scan.close();
    }
}

interface IAdvancedArithmetic {
    int divisorSum(int n);
}

class Calculator implements IAdvancedArithmetic {
    public int divisorSum(int n) {
        int sum = n;
        for (int i = 1; i <= n / 2; ++i) {
            sum += (n % i == 0) ? i : 0;
        }

        return sum;
    }
}
