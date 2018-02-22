/**
 *              07 | STAIRCASE
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
        int n = scan.nextInt();
        scan.close();

        printStaircase(n);
    }

    private static void printStaircase(int n) {
        String s = "#";
        for (int i = 0; i < n; ++i) {
            System.out.printf("%" + (n + 1) + "s", s + "\n");
            s = s.concat("#");
        }
    }
}