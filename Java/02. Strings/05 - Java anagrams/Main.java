/**
 *              05 | JAVA ANAGRAMS
 * Domain       JAVA
 * Sub domain   STRINGS
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner scan = new Scanner(file);
        String string1 = scan.next();
        String string2 = scan.next();
        scan.close();

        boolean result = isAnagram(string1, string2);
        System.out.println((result) ? "Anagrams" : "Not Anagrams");
    }

    private static boolean isAnagram(String string1, String string2) {
        String s1 = string1.toLowerCase().trim();
        String s2 = string2.toLowerCase().trim();

        for(int i = 0; i < s1.length(); ++i) {
            for (int j = 0; j < s2.length(); j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    s1 = s1.substring(0, i) + s1.substring(i+1, s1.length());
                    s2 = s2.substring(0, j) + s2.substring(j+1, s2.length());
                    i--;
                    break;
                }
            }
        }
        return (s1.length() == 0 && s2.length() == 0);
    }
}