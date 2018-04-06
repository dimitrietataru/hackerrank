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
        {
            int[] letterSizes = new int[26];
            for (int i = 0; i < letterSizes.length; ++i) {
                letterSizes[i] = scan.nextInt();
            }

            int maxHeight = 0;
            String input = scan.next();
            for (char ch : input.toCharArray()) {
                int height = letterSizes[ch % 97];
                maxHeight = Math.max(height, maxHeight);
            }
            System.out.println(maxHeight * input.length());
        }
        scan.close();
    }
}
