/**
 *              26 | CIRCULAR ARRAY ROTATION
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
        int length = scan.nextInt();
        int rotation = scan.nextInt() % length;
        int queries = scan.nextInt();
        int[] array = new int[length];
        for (int i = 0; i < length; ++i) {
            array[i] = scan.nextInt();
        }

        array = circularArrayRotation(array, rotation);
        while (queries-- > 0) {
            System.out.println(array[scan.nextInt()]);
        }
        scan.close();
    }

    private static int[] circularArrayRotation(int[] array, int rotation) {
        int length = array.length;
        int[] array2 = new int[length];
        for (int i = 0; i < length; ++i) {
            array2[i] = array[(i - rotation + length) % length];
        }
        return array2;
    }
}