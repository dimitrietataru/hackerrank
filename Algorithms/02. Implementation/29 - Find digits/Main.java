/**
 *              29 | FIND DIGITS
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
                int number = scan.nextInt();
                findDigits(number);
            }
        }
        scan.close();
    }

    private static void findDigits(int number) {
        int initial = number;
        int result = 0;
        while (number > 0) {
            int digit = number % 10;
            number /= 10;

            result += (isDivisible(initial, digit)) ? 1 : 0;
        }
        System.out.println(result);
    }

    private static boolean isDivisible(int number, int digit) {
        return (digit != 0) && (number % digit == 0);
    }
}
