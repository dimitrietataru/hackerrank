/**
 *              06 | JAVA LOOPS I
 * Domain       JAVA
 * Sub domain   INTRODUCTION
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
            for (int i = 1; i <= 10; i++) {
                System.out.printf("%d x %d = %d%n", n, i, (n * i));
            }
        }
        scan.close();
    }
}
