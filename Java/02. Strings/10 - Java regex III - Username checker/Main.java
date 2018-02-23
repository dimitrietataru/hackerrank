/**
 *              10 | JAVA REGEX III - USERNAME CHECKER
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
        Scanner scan = new Scanner(file);
        int testCases = scan.nextInt();
        scan.nextLine();

        while (testCases-- > 0) {
            String username = scan.nextLine();

            String regex = "^[aA-zZ]\\w{7,29}$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(username);

            if (matcher.find()) {
                System.out.println(username + " - Valid");
            } else {
                System.out.println(username + " - Invalid");
            }
        }
        scan.close();
    }
}

/*
*       REGEX EXPLAINED
*   ^ - starting character of the string
*   [aA-zZ] - starting character is in the lowercase or uppercase of alphabet
*   \w - word, can be written as "[a-zA-Z_0-9]"
*   \w{7,29} - number of words
*       \X{n,m} - 'X', at least 'n' times, but no more than 'm' times
*/