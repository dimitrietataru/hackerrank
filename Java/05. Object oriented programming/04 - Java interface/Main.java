/**
 *              04 | JAVA INTERFACE
 * Domain       JAVA
 * Sub domain   OBJECT ORIENTED PROGRAMMING
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner scan = new Scanner(file);
        {
            AdvancedArithmetic calc = new MyCalculator();

            System.out.print("I implemented: ");
            printInterfaces(calc);

            int n = scan.nextInt();
            System.out.println(calc.divisorSum(n) + "\n");
        }
        scan.close();
    }

    private static void printInterfaces(Object object){
        Class[] interfaces = object.getClass().getInterfaces();
        for (Class c : interfaces){
            System.out.println(c.getName() + " ");
        }
    }
}

interface AdvancedArithmetic {
    int divisorSum(int n);
}

class MyCalculator implements AdvancedArithmetic {
    MyCalculator() {}

    public int divisorSum(int n) {
        int sum = n;

        for (int i = 1; i <= n / 2; ++i) {
            if (n % i == 0) {
                sum += i;
            }
        }

        return sum;
    }
}
