/**
 *              LET'S REVIEW | JAVA
 * Domain       30 DAYS OF CODE
 * Sub domain   DAY 06
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner scan = new Scanner(file);
        int testCases = scan.nextInt();
        scan.nextLine();
        while (testCases-- > 0) {
            String input = scan.nextLine();
            letsReview(input);
        }
        scan.close();
    }

    private static void letsReview(String input) {
        String even = "";
        String odd = "";

        for (int i = 0; i < input.length(); ++i) {
            if (i % 2 == 0) {
                even = even.concat(String.valueOf(input.charAt(i)));
            } else {
                odd = odd.concat(String.valueOf(input.charAt(i)));
            }
        }

        System.out.printf("%s %s\n", even, odd);
    }
}