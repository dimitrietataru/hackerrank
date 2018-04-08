/**
 *              07 | PATTERN SYNTAX CHECKER
 * Domain       JAVA
 * Sub domain   STRINGS
 */

// http://docs.oracle.com/javase/6/docs/api/java/util/regex/Pattern.html#compile%28java.lang.String%29

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner scan = new Scanner(file);
        {
            int testCases = Integer.parseInt(scan.nextLine());
            while (testCases-- > 0) {
                String pattern = scan.nextLine();
                patternSyntaxChecker(pattern);
            }
        }
        scan.close();
    }

    private static void patternSyntaxChecker(String pattern) {
        try {
            Pattern p = Pattern.compile(pattern);
            System.out.println("Valid");
        } catch (PatternSyntaxException pse) {
            System.out.println("Invalid");
        }
    }
}
