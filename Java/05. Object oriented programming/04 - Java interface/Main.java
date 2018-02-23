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
        int n = scan.nextInt();
        scan.close();

        MyCalculator myCalculator = new MyCalculator();

        System.out.println("I implemented: ");
        ImplementedInterfaceNames(myCalculator);

        System.out.println(myCalculator.divisorSum(n) + "\n");
    }

    private static void ImplementedInterfaceNames(Object object){
        Class[] classInterfaceArray = object.getClass().getInterfaces();
        for (Class ci : classInterfaceArray){
            String interfaceName = ci.getName();
            System.out.println(interfaceName);
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