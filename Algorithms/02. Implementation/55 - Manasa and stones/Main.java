/**
 *              55 | MANASA AND STONES
 * Domain       ALGORITHMS
 * Sub domain   IMPLEMENTATION
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner scan = new Scanner(file);
        {
            int testCases = scan.nextInt();
            while(testCases-- > 0) {
                int stones = scan.nextInt();
                int a = scan.nextInt();
                int b = scan.nextInt();

                manasaAndStones(stones - 1, Math.min(a, b), Math.max(a, b));
            }
        }
        scan.close();
    }

    private static void manasaAndStones(int n, int a, int b) {
        int current = a * n;
        int max = b * n;
        int difference = b - a;
        if (a == b) {
            System.out.print(current + " ");
        } else {
            while (current <= max) {
                System.out.print(current + " ");
                current += difference;
            }
        }
        System.out.println();
    }
}
