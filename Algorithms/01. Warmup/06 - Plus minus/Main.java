/**
 *              06 | PLUS MINUS
 * Domain       ALGORITHMS
 * Sub domain   WARMUP
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner scan = new Scanner(file);
        {
            int positive = 0;
            int negative = 0;
            int zero = 0;

            int n = scan.nextInt();
            for (int i = 0; i < n; ++i) {
                int number = scan.nextInt();
                if (number > 0) {
                    positive++;
                } else if (number < 0) {
                    negative++;
                } else {
                    zero++;
                }
            }

            System.out.printf("%.6f\n",(double)positive / n);
            System.out.printf("%.6f\n",(double)negative / n);
            System.out.printf("%.6f\n",(double)zero / n);
        }
        scan.close();
    }
}
