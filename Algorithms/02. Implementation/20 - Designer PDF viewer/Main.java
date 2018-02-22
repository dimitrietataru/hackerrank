/**
 *              20 | DESIGNER PDF VIEWER
 * Domain       ALGORITHMS
 * Sub domain   IMPLEMENTATION
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner scan = new Scanner(file);
        int[] letterHeight = new int[26];
        for (int i = 0; i < letterHeight.length; ++i) {
            letterHeight[i] = scan.nextInt();
        }
        String input = scan.next();
        scan.close();

        int maxHeight = 0;
        for (int i = 0; i < input.length(); ++i) {
            char letter = input.charAt(i);
            int asciiNumber = (int) letter;
            int currentHeight = letterHeight[asciiNumber % 97];

            maxHeight = (currentHeight > maxHeight) ? currentHeight : maxHeight;
        }
        System.out.println(maxHeight * input.length());
    }
}