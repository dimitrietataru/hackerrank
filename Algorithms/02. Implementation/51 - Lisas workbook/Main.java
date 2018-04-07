/**
 *              51 | LISA'S WORKBOOK
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
            int chapters = scan.nextInt();
            int capacity = scan.nextInt();
            int[] problems = new int[chapters];
            for (int i = 0; i < problems.length; i++) {
                problems[i] = scan.nextInt();
            }

            lisasWorkbook(chapters, capacity, problems);
        }
        scan.close();
    }

    private static void lisasWorkbook(int chapters, int capacity, int[] problems) {
        int result = 0;
        int page = 1;
        for (int i = 0; i < chapters; i++) {
            for (int j = 1; j <= problems[i]; ++j) {
                if (j == page) {
                    result++;
                }
                if ((j % capacity == 0) && (j != problems[i])) {
                    page++;
                }
            }
            page++;
        }
        System.out.println(result);
    }
}
