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
        {
            int testCases = Integer.parseInt(scan.nextLine());
            while (testCases-- > 0) {
                String input = scan.nextLine();
                String result = biggerIsGreater(input.toCharArray(), input.length());
                System.out.println(result);
            }
        }
        scan.close();
    }

    private static String biggerIsGreater(char[] chars, int len) {
        if (len <= 1) {
            return "no answer";
        }

        // Find longest non-increasing suffix
        int pivotL = len - 1;
        while (pivotL > 0 && chars[pivotL - 1] >= chars[pivotL]) {
            pivotL--;
        }

        // Check if there is a possible permutation
        if (pivotL <= 0) {
            return "no answer";
        }

        // Find the rightmost element that exceeds the pivot
        int pivotR = len - 1;
        while (chars[pivotR] <= chars[pivotL - 1]) {
            pivotR--;
        }

        // Swap pivots
        char temp = chars[pivotL - 1];
        chars[pivotL - 1] = chars[pivotR];
        chars[pivotR] = temp;

        // Reverse the suffix
        pivotR = len - 1;
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
