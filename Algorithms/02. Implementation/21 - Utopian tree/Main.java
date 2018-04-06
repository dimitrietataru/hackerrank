/**
 *              21 | UTOPIAN TREE
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
            int testCases = scan.nextInt();
            while (testCases-- > 0) {
                int cycles = scan.nextInt();
                utopianTree(cycles);
            }
        }
        scan.close();
    }

    private static void utopianTree(int cycles) {
        int height = 1;
        for (int i = 1; i <= cycles; ++i) {
            if (i % 2 == 1) {
                height *= 2;
            } else {
                height++;
            }
        }
        System.out.println(height);
    }
}
