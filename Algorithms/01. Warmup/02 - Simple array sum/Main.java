/**
 *              02 | SIMPLE ARRAY SUM
 * Domain       ALGORITHMS
 * Sub domain   WARMUP
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner scan = new Scanner(file);
        {
            int[] array = new int[scan.nextInt()];
            for (int i = 0; i < array.length; ++i) {
                array[i] = scan.nextInt();
            }

            int result = simpleArraySum(array);
            System.out.println(result);
        }
        scan.close();
    }

    private static int simpleArraySum(int[] array) {
        return IntStream.of(array).sum();
    }
}
