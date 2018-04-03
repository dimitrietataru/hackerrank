/**
 *              44 | BIGGER IS GREATER
 * Domain       ALGORITHMS
 * Sub domain   IMPLEMENTATION
 */

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner scan = new Scanner(file);
        int testCases = scan.nextInt();
        scan.nextLine();
        while (testCases-- > 0) {
            String input = scan.nextLine();
            System.out.println(biggerIsGreater(input));
        }
        scan.close();
    }

    private static String biggerIsGreater(String input) {
        // Length = 0..1
        int size = input.length();
        if (size <= 1) {
            return "no answer";
        }

        // Convert input String -> char[]
        char[] chars = input.toCharArray();

        // Find longest non-increasing suffix
        int pivotL = size - 1;
        while (pivotL > 0 && chars[pivotL - 1] >= chars[pivotL]) {
            pivotL--;
        }

        // Check if there is a possible permutation
        if (pivotL <= 0) {
            return "no answer";
        }

        // Find the rightmost element that exceeds the pivot
        int pivotR = size - 1;
        while (chars[pivotR] <= chars[pivotL - 1]) {
            pivotR--;
        }

        // Swap pivots
        char temp = chars[pivotL - 1];
        chars[pivotL - 1] = chars[pivotR];
        chars[pivotR] = temp;

        // Reverse the suffix
        pivotR = size - 1;
        while (pivotL < pivotR) {
            temp = chars[pivotL];
            chars[pivotL] = chars[pivotR];
            chars[pivotR] = temp;
            pivotL++;
            pivotR--;
        }

        return new String(chars);
    }
}