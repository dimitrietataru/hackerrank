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
        {
            String str1 = scan.next();
            String str2 = scan.next();

            boolean result = isAnagram(str1, str2);
            System.out.println(result ? "Anagrams" : "Not Anagrams");
        }
        scan.close();
    }

    private static boolean isAnagram(String str1, String str2) {
        String s1 = str1.toLowerCase().trim();
        String s2 = str2.toLowerCase().trim();

        for(int i = 0; i < s1.length(); ++i) {
            for (int j = 0; j < s2.length(); j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    s1 = s1.substring(0, i) + s1.substring(i + 1);
                    s2 = s2.substring(0, j) + s2.substring(j + 1);
                    i--;
                    break;
                }
            }
        }
        return (s1.length() == 0 && s2.length() == 0);
    }
}
