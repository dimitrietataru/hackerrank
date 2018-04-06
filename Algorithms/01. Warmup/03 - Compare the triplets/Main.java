/**
 *              03 | COMPARE THE TRIPLETS
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
        {
            int a0 = scan.nextInt();
            int a1 = scan.nextInt();
            int a2 = scan.nextInt();
            int b0 = scan.nextInt();
            int b1 = scan.nextInt();
            int b2 = scan.nextInt();

            int[] result = solve(a0, a1, a2, b0, b1, b2);
            System.out.println(result[0] + " " + result[1]);
        }
        scan.close();
    }

    private static int[] solve(int a0, int a1, int a2, int b0, int b1, int b2) {
        int[] result = new int[2];

        result[0] = ((a0 > b0) ? 1 : 0) + ((a1 > b1) ? 1 : 0) + ((a2 > b2) ? 1 : 0);
        result[1] = ((b0 > a0) ? 1 : 0) + ((b1 > a1) ? 1 : 0) + ((b2 > a2) ? 1 : 0);

        return result;
    }
}
