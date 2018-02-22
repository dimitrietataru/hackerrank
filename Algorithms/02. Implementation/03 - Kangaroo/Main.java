/**
 *              03 | KANGAROO
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
        int k1Position = scan.nextInt();
        int k1Leap = scan.nextInt();
        int k2Position = scan.nextInt();
        int k2Leap = scan.nextInt();
        scan.close();

        String result = playKangaroo(k1Position, k1Leap, k2Position, k2Leap);
        System.out.println(result);
    }

    private static String playKangaroo(int k1Position, int k1Leap, int k2Position, int k2Leap) {
        if (k2Leap >= k1Leap) {
            return "NO";
        }

        while ((k1Position += k1Leap) <= (k2Position += k2Leap)) {
            if (k1Position == k2Position) {
                return "YES";
            }
        }
        return "NO";
    }
}