/**
 *              07 | JAVA LOOPS II
 * Domain       JAVA
 * Sub domain   INTRODUCTION
 */

// https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner scan = new Scanner(file);
        int queries = scan.nextInt();

        for (int i = 0; i < queries; ++i) {
            int a = scan.nextInt();
            int b = scan.nextInt();
            int n = scan.nextInt();

            int result = a;
            for (int j = 0; j < n; ++j) {
                result += (int) (Math.pow(2, j) * b);
                System.out.print(result + " ");
            }
            System.out.println();
        }
        scan.close();
    }
}