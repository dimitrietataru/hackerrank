/**
 *              08 | JAVA STACK
 * Domain       JAVA
 * Sub domain   DATA STRUCTURES
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner scan = new Scanner(file);
        while (scan.hasNext()) {
            String input = scan.nextLine();
            System.out.println(isBalanced(input));
        }
        scan.close();
    }

    private static boolean isBalanced(String s) {
        final ArrayDeque<Character> stack = new ArrayDeque<> ();
        final char[] charArray = s.toCharArray ();

        for (char character : charArray) {
            char matchingCharacter = '.';
            switch (character) {
                case '(':
                case '{':
                case '[':
                    stack.addFirst (character);
                    break;
                case ')':
                    matchingCharacter = '(';
                case '}':
                    if (matchingCharacter == '.') matchingCharacter = '{';
                case ']':
                    if (matchingCharacter == '.') matchingCharacter = '[';
                    if (stack.isEmpty() || (stack.removeFirst () != matchingCharacter)) {
                        return false;
                    }
                    break;
                default:
                    return false;
            }
        }
        return stack.isEmpty();
    }

    private static boolean shortIsBalanced(String s) {
        while (s.length() != (s = s.replaceAll("\\(\\)|\\[\\]|\\{\\}", "")).length());
        return s.isEmpty();
    }
}