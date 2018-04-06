/**
 *              12 | DRAWING BOOK
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
            int totalPages = scan.nextInt();
            int page = scan.nextInt();

            drawingBook(totalPages, page);
        }
        scan.close();
    }

    private static void drawingBook(int totalPages, int page) {
        if (totalPages == page || page == 1) {
            System.out.println("0");
            return;
        }

        int totalStart = page / 2;
        int totalEnd = (totalPages / 2) - (page / 2);

        System.out.println(Math.min(totalStart, totalEnd));
    }
}
