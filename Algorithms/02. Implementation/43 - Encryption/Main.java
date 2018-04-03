/**
 *              43 | ENCRYPTION
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
        String input = scan.nextLine();
        scan.close();

        encryption(input);
    }

    private static void encryption(String input) {
        input = input.trim().replace(" ", "");
        int n = (int) Math.sqrt(input.length());
        int m = (n * n >= input.length()) ? n : n + 1;
        n += (n * m < input.length()) ? 1 : 0;

        int index = 0;
        char[][] matrix = new char[n + 1][m + 1];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                matrix[i][j] = (index < input.length()) ? input.charAt(index++) : ' ';
            }
        }

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                String letter = String.valueOf(matrix[j][i]);
                System.out.print(letter.equals(" ") ? "" : letter);
            }
            System.out.print(" ");
        }
    }
}