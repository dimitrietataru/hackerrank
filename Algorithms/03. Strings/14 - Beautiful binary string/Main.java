/**
 *              14 | BEAUTIFUL BINARY STRING
 * Domain       ALGORITHMS
 * Sub domain   STRINGS
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner scan = new Scanner(file);
        {
            scan.nextLine();
            String input = scan.next();
            beautifulBinaryString(input);
        }
        scan.close();
    }

    private static void beautifulBinaryString(String input) {
        int result = 0;
        for (int i = 3; i < input.length() - 1; i++) {
            String sub = input.substring(i - 3, i);
            if (sub.equals("010")) {
                result++;
                sub = (input.charAt(i + 1) == '1') ? "000" : "011";
            }
            input = input.substring(0, i - 3) + sub + input.substring(i);
        }
        if (input.substring(input.length() - 3).equals("010")) {
            result++;
        }

        System.out.println(result);
    }
}
