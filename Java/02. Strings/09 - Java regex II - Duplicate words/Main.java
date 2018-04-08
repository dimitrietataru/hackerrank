/**
 *              09 | JAVA REGEX II - DUPLICATE WORDS
 * Domain       JAVA
 * Sub domain   STRINGS
 */

// https://docs.oracle.com/javase/8/docs/api/java/util/regex/Pattern.html#sum
// http://tutorials.jenkov.com/java-regex/matcher.html
// https://docs.oracle.com/javase/tutorial/essential/regex/groups.html

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner scan = new Scanner(file);
        {
            String regex = "\\b(\\w+)(\\W+\\1\\b)+";
            Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

            int testCases = Integer.parseInt(scan.nextLine());
            while (testCases-- > 0) {
                String input = scan.nextLine();

                Matcher matcher = pattern.matcher(input);
                while (matcher.find()) {
                    input = input.replaceAll(matcher.group(), matcher.group(1));
                }
                System.out.println(input);
            }
        }
        scan.close();
    }
}

/*      REGEX
* \w - a word character: [a-zA-Z_0-9]
* \W - a non-word character: [~\w]
* \1 - matches whatever was matched in the 1st group of parentheses, which in our case is (\w+)
* \b - A word boundary - The \b boundaries are needed for special cases
*           like "Bob and Andy", where we don't want to match "and" twice
*
*       GROUPS
*  input = input.replaceAll(m.group(), m.group(1))
*           replaces the entire match with the first group in the match
*  m.group() - the entire match
*  m.group(n) - the nth match
* */
