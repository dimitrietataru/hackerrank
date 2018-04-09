/**
 *              04 | TWO CHARACTERS
 * Domain       ALGORITHMS
 * Sub domain   STRINGS
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner scan = new Scanner(file);
        {
            scan.nextLine();
            String input = scan.next();
            twoCharacters(input);
        }
        scan.close();
    }

    private static void twoCharacters(String input) {
        if (input.length() < 2) {
            System.out.println("0");
            return;
        }

        HashSet<Character> set = new HashSet<>();
        for (char c : input.toCharArray()) {
            set.add(c);
        }

        int max = Integer.MIN_VALUE;
        for (Character c : set) {
            for (Character c2 : set) {
                max = Math.max(max, isValidString(input, c, c2));
            }
        }
        System.out.println(max);
    }

    private static int isValidString(String input, char c1, char c2) {
        String current = input.replaceAll("[^" + c1 + c2 + "]", "");
        char[] ca = current.toCharArray();
        for (int i = 0; i < ca.length - 1; ++i) {
            if (ca[i] == ca[i+1]) {
                return 0;
            }
        }
        return current.length();
    }
}
