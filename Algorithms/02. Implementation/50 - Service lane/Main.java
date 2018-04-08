/**
 *              50 | SERVICE LANE
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
            int[] highway = new int[scan.nextInt()];
            int testCases = scan.nextInt();

            for (int i = 0; i < highway.length; i++) {
                highway[i] = scan.nextInt();
            }

            while (testCases-- > 0) {
                final int start = scan.nextInt();
                final int end = scan.nextInt();
                serviceLane(highway, start, end);
            }
        }
        scan.close();
    }

    private static void serviceLane(int[] highway, int start, int end) {
        int min = Integer.MAX_VALUE;
        for (int i = start; i <= end; i++) {
            min = Math.min(min, highway[i]);
            if (min == 1) {
                break;
            }
        }
        System.out.println(min);
    }
}
