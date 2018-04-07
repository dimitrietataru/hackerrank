/**
 *              32 | SHERLOCK AND SQUARES
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
            int testCases = scan.nextInt();
            while(testCases-- > 0) {
                int start = scan.nextInt();
                int end = scan.nextInt();
                sherlockAndSquares(start, end);
            }
        }
        scan.close();
    }

    private static void sherlockAndSquares(int start, int end) {
        double s = Math.ceil(Math.sqrt(start));
        double e = Math.floor(Math.sqrt(end));
        System.out.println((int) (e - s + 1));
    }
}
