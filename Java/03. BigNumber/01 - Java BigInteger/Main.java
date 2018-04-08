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
        {
            BigInteger big1 = new BigInteger(scan.next());
            BigInteger big2 = new BigInteger(scan.next());

            System.out.println(big1.add(big2));
            System.out.println(big1.multiply(big2));
        }
        scan.close();
    }
}
