/**
 *              04 | A VERY BIG SUM
 * Domain       ALGORITHMS
 * Sub domain   WARMUP
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.stream.LongStream;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner scan = new Scanner(file);
        {
            int n = scan.nextInt();
            long[] array = new long[n];
            for (int i = 0; i < n; ++i) {
                array[i] = scan.nextInt();
            }

            long result = aVeryBigSum(array);
            System.out.println(result);
        }
        scan.close();
    }

    private static long aVeryBigSum(long[] array) {
        return LongStream.of(array).sum();
    }
}
