/**
 *              46 | BEAUTIFUL TRIPLETS
 * Domain       ALGORITHMS
 * Sub domain   IMPLEMENTATION
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner scan = new Scanner(file);
        {
            int[] array = new int[scan.nextInt()];
            int difference = scan.nextInt();

            for (int i = 0; i < array.length; ++i) {
                array[i] = scan.nextInt();
            }

            beautifulTriplets(array, difference);
            beautifulTripletsWithSet(array, difference);
        }
        scan.close();
    }

    private static void beautifulTriplets(int[] array, int d) {
        int result = 0;
        for (int i = 0; i < array.length - 2; i++) {
            for (int j = i + 1; j < array.length - 1; ++j ) {
                if (Math.abs(array[i] - array[j]) == d) {
                    for (int k = j + 1; k < array.length; k++) {
                        if (Math.abs(array[j] - array[k]) == d) {
                            result++;
                            break;
                        }
                    }
                }
            }
        }
        System.out.println(result);
    }

    private static void beautifulTripletsWithSet(int[] array, int d) {
        Set<Integer> set = new HashSet<>();

        int result = 0;
        for (int i : array) {
            if (set.contains(i - d) && set.contains(i - (d * 2))) {
                result++;
            }
            set.add(i);
        }

        System.out.println(result);
    }
}
