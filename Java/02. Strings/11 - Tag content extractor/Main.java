/**
 *              11 | TAG CONTENT EXTRACTOR
 * Domain       JAVA
 * Sub domain   STRINGS
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        String regex = "<(.+)>([^<>]+)</\\1>";
        // String rx = "<([^>]+)>([^<>]+)</\\1>";

        Scanner scan = new Scanner(file);
        int testCases = scan.nextInt();
        scan.nextLine();

        while (testCases-- > 0) {
            String input = scan.nextLine();

            boolean matchFound = false;
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input);
            while (matcher.find()) {
                if (matcher.group(2).length() != 0) {
                    System.out.println(matcher.group(2));
                    matchFound = true;
                }
            }
            if (!matchFound) {
                System.out.println("None");
            }
        }
        scan.close();
    }
}

/*
*       REGEX EXPLAINED
*   <(.+)>  - matches HTML start tags. The parentheses save the contents inside the brackets in Group #1
*   ([^<]+) - matches the text between HTML start and end tags. Content is saved in Group #2
*   </\\1>  - match the HTML end brace that corresponds to out previous start brace.
*             The \1 is used to match all text from Group #1
* */