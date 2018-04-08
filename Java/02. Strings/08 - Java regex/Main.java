/**
 *              08 | JAVA REGEX
 * Domain       JAVA
 * Sub domain   STRINGS
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class MyRegex {
    //private String smallRegex = "(\\d{1,2} | [0-1]\\d{2} | 2[0-4]\\d | 25[0-5] )";
    //String smallPattern = "(" + smallRegex + "\\.){3}" + smallRegex;

    private String zeroTo255 = "([0-9]"                     // any number between 0-9
                                + "|" + "[0-9][0-9]"        // any number between 00-99
                                + "|" + "[0-1][0-9]{2}"     // any number between 000-199
                                + "|" + "2[0-4][0-9]"       // any number between 200-249
                                + "|" + "25[0-5])";         // any number between 250-255

    String pattern = zeroTo255 + "\\." + zeroTo255 + "\\." + zeroTo255 + "\\." + zeroTo255;
}

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner scan = new Scanner(file);
        {
            while (scan.hasNext()) {
                String IP = scan.next();
                System.out.println(IP.matches(new MyRegex().pattern));
            }
        }
        scan.close();
    }
}
