/**
 *              02 | SIMPLE ARRAY SUM
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
        int arrayLength = scan.nextInt();
        int[] array = new int[arrayLength];
        for (int i = 0; i < array.length; ++i) {
            array[i] = scan.nextInt();
        }
        scan.close();

        int result = simpleArraySum(array);
        System.out.println(result);
    }

    private static int simpleArraySum(int[] array) {
        int sum = 0;

        for (int i : array) {
            sum+= i;
        }

        return sum;
    }
}