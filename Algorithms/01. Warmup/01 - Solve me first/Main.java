/**
 *              01 | SOLVE ME FIRST
 * Domain       ALGORITHMS
 * Sub domain   WARMUP
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner scan = new Scanner(file);
        int a = scan.nextInt();
        int b = scan.nextInt();
        scan.close();

        int sum = sum(a, b);
        System.out.println(sum);
    }

    private static int sum(int a, int b) {
        return a + b;
    }
}