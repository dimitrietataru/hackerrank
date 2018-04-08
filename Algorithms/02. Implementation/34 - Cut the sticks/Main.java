/**
 *              34 | CUT THE STICKS
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
            int[] array = new int[scan.nextInt()];
            for (int i = 0; i < array.length; ++i) {
                array[i] = scan.nextInt();
            }
            cutTheSticks(array);
        }
        scan.close();
    }

    private static void cutTheSticks(int[] array) {
        int min;
        int counter = 0;
        boolean cuts = true;

        while (cuts) {
            cuts = false;
            min = getMin(array);
            for (int i = 0; i < array.length; ++i) {
                if (array[i] >= min) {
                    counter++;
                    array[i] -= min;
                    cuts = true;
                }
            }

            if (cuts) {
                System.out.println(counter);
                counter = 0;
            }
        }
    }

    private static int getMin(int[] array) {
        int min = Integer.MAX_VALUE;
        for (int i : array) {
            min = ((i > 0) && (i < min)) ? i : min;
        }
        return min;
    }
}
