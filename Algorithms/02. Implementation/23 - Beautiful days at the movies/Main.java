/**
 *              23 | BEAUTIFUL DAYS AT THE MOVIES
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
        int i = scan.nextInt();
        int j = scan.nextInt();
        int k = scan.nextInt();
        scan.close();
        beautifulDaysAtTheMovies(i, j, k);
    }

    private static void beautifulDaysAtTheMovies(int startDay, int endDay, int reverse) {
        int result = 0;
        for (int i = startDay; i <= endDay; ++i) {
            double beautiful = (double) Math.abs((i - reverse(i))) / reverse;
            if ((beautiful - (int) beautiful) == 0) {
                result++;
            }
        }
        System.out.println(result);
    }

    private static int reverse(int n) {
        int result = 0;
        while (n != 0) {
            result *= 10;
            result += (n % 10);
            n /= 10;
        }
        return result;
    }
}