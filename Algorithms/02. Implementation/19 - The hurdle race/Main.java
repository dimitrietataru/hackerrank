/**
 *              19 | THE HURDLE RACE
 * Domain       ALGORITHMS
 * Sub domain   IMPLEMENTATION
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
            int maxJump = scan.nextInt();

            int max = Integer.MIN_VALUE;
            for (int i = 0; i < n; ++i) {
                int hurdle = scan.nextInt();
                max = Math.max(hurdle, max);
            }

            System.out.println((max > maxJump) ? (max - maxJump) : 0);
        }
        scan.close();
    }
}
