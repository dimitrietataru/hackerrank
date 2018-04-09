/**
 *              08 | PANGRAMS
 * Domain       ALGORITHMS
 * Sub domain   STRINGS
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner scan = new Scanner(file);
        {
            String input = scan.nextLine();
            System.out.println(pangrams(input));
        }
        scan.close();
    }

    private static String pangrams(String input) {
        int[] freq = new int[26];

        for (char c : input.toCharArray()) {
            if (Character.isUpperCase(c)) {
                freq[c - 65]++;
            }
            if (Character.isLowerCase(c)) {
                freq[c - 97]++;
            }
        }

        if (Arrays.stream(freq).boxed().collect(Collectors.toList()).contains(0)) {
            return "not pangram";
        }

        return "pangram";
    }
}
