/**
 *              03 | JAVA PRIMALITY TEST
 * Domain       JAVA
 * Sub domain   BIG NUMBER
 */

// https://docs.oracle.com/javase/7/docs/api/java/math/BigInteger.html#isProbablePrime%28int%29

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner scan = new Scanner(file);
        {
            BigInteger big = scan.nextBigInteger();

            if (big.isProbablePrime(1)) {
                System.out.println("prime");
            } else {
                System.out.println("not prime");
            }
        }
        scan.close();
    }
}
