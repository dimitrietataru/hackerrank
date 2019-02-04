/**
 *              06 | MARS EXPLORATION
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
            String input = scan.next();
            marsExploration(input);
        }
        scan.close();
    }

    private static void marsExploration(String input) {
        final String sos = "SOS";
        int result = 0;
        int index = 0;
        for (char c : input.toCharArray()) {
            if (c != sos.charAt(index++)) {
                result++;
            }
            index %= 3;
        }

        System.out.println(result);
    }
}
