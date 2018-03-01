/**
 *              10 | JAVA LAMBDA EXPRESSIONS
 * Domain       JAVA
 * Sub domain   ADVANCED
 */

// https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner scan = new Scanner(file);
        int testCases = scan.nextInt();

        while (testCases-- > 0) {
            int operation = scan.nextInt();
            int number = scan.nextInt();

            if (operation == 1) {
                PerformOperation po = MyMath.isOdd();
                boolean isOdd = MyMath.checker(po, number);
                System.out.println(isOdd ? "ODD" : "EVEN");
            } else if (operation == 2) {
                PerformOperation po = MyMath.isPrime();
                boolean isPrime = MyMath.checker(po, number);
                System.out.println(isPrime ? "PRIME" : "COMPOSITE");
            } else if (operation == 3) {
                PerformOperation po = MyMath.isPalindrome();
                boolean isPalindrome = MyMath.checker(po, number);
                System.out.println(isPalindrome ? "PALINDROME" : "NOT PALINDROME");
            }
        }
        scan.close();
    }
}

interface PerformOperation {
    boolean check(int a);
}

class MyMath {
    static boolean checker(PerformOperation p, int num) {
        return p.check(num);
    }

    static PerformOperation isOdd() {
        return (int a) -> a % 2 != 0;
    }

    static PerformOperation isPrime() {
        return (int a) -> BigInteger.valueOf(a).isProbablePrime(1);
    }

    static PerformOperation isPalindrome() {
        return (int a) -> Integer.toString(a)
            .equals(new StringBuilder(Integer.toString(a)).reverse().toString());
    }
}