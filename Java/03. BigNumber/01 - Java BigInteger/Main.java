/**
 *              01 | JAVA BIG INTEGER
 * Domain       JAVA
 * Sub domain   BIG NUMBER
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner scan = new Scanner(file);
        BigInteger number1 = new BigInteger(scan.next());
        BigInteger number2 = new BigInteger(scan.next());
        scan.close();

        System.out.println(number1.add(number2));
        System.out.println(number1.multiply(number2));
    }
}