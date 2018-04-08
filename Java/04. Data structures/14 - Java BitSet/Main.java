/**
 *              15 | JAVA BITSET
 * Domain       JAVA
 * Sub domain   DATA STRUCTURES
 */

// https://docs.oracle.com/javase/7/docs/api/java/util/BitSet.html

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner scan = new Scanner(file);
        {
            int length = scan.nextInt();
            BitSet b1 = new BitSet(length);
            BitSet b2 = new BitSet(length);

            int operations = scan.nextInt();
            while (operations-- > 0) {
                String operation = scan.next();
                int val1 = scan.nextInt();
                int val2 = scan.nextInt();
                switch (operation) {
                    case "AND":
                        if (val1 == 1) {
                            b1.and(b2);
                        } else {
                            b2.and(b1);
                        }
                        break;
                    case "OR":
                        if (val1 == 1) {
                            b1.or(b2);
                        } else {
                            b2.or(b1);
                        }
                        break;
                    case "XOR":
                        if (val1 == 1) {
                            b1.xor(b2);
                        } else {
                            b2.xor(b1);
                        }
                        break;
                    case "SET":
                        if (val1 == 1) {
                            b1.set(val2);
                        } else {
                            b2.set(val2); }
                        break;
                    case "FLIP":
                        if (val1 == 1) {
                            b1.flip(val2);
                        } else {
                            b2.flip(val2); }
                        break;
                }
                System.out.println(b1.cardinality() + " " + b2.cardinality());
            }
        }
        scan.close();
    }
}
