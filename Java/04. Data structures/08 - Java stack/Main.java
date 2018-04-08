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
        {
            while (scan.hasNext()) {
                String input = scan.nextLine();
                System.out.println(isBalanced(input));
            }
        }
        scan.close();
    }

    private static boolean isBalanced(String s) {
        final ArrayDeque<Character> stack = new ArrayDeque<> ();
        for (char ch : s.toCharArray()) {
            char match = '.';
            switch (ch) {
                case '(':
                case '{':
                case '[':
                    stack.addFirst (ch);
                    break;
                case ')':
                    match = '(';
                case '}':
                    if (match == '.') {
                        match = '{';
                    }
                case ']':
                    if (match == '.') {
                        match = '[';
                    }
                    if (stack.isEmpty() || (stack.removeFirst () != match)) {
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
        while (s.length() != (s = s.replaceAll("\\(\\)|\\[]|\\{}", "")).length());
        return s.isEmpty();
    }
}
