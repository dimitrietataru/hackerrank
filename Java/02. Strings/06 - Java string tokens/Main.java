/**
 *              06 | JAVA STRING TOKENS
 * Domain       JAVA
 * Sub domain   STRINGS
 */

// https://docs.oracle.com/javase/8/docs/api/java/lang/String.html#split-java.lang.String-
// https://docs.oracle.com/javase/8/docs/api/java/util/regex/Pattern.html

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner scan = new Scanner(file);
        {
            String input = scan.nextLine().trim();
            stringTokens(input);
        }
        scan.close();
    }

    private static void stringTokens(String input) {
        if (input.length() == 0) {
            System.out.println("0");
            return;
        }

        String regexSplit = "[\\s!,?._'@]+";
        String[] tokens = input.split(regexSplit);

        System.out.println(tokens.length);

        for (String s : tokens) {
            System.out.println(s);
        }
    }
}
