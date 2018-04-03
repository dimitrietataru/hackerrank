/**
 *              46 | BEAUTIFUL TRIPLETS
 * Domain       ALGORITHMS
 * Sub domain   IMPLEMENTATION
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner scan = new Scanner(file);
        int length = scan.nextInt();
        int difference = scan.nextInt();
        int[] array = new int[length];
        for (int i = 0; i < length; ++i) {
            array[i] = scan.nextInt();
        }
        scan.close();

        beautifulTriplets(array, difference);
        beautifulTripletsWithSet(array, difference);
    }

    private static void beautifulTriplets(int[] array, int difference) {
        int counter = 0;
        for (int i = 0; i < array.length - 2; i++) {
            for (int j = i + 1; j < array.length - 1; ++j ) {
                if (Math.abs(array[i] - array[j]) == difference) {
                    for (int k = j + 1; k < array.length; k++) {
                        if (Math.abs(array[j] - array[k]) == difference) {
                            counter++;
                            break;
                        }
                    }
                }
            }
        }
        System.out.println(counter);
    }

    private static void beautifulTripletsWithSet(int[] array, int difference) {
        HashSet<Integer> set = new HashSet<>();
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (set.contains(array[i] - difference) && set.contains(array[i] - (difference * 2))) {
                count++;
            }
            set.add(array[i]);
        }

        System.out.println(count);
    }
}