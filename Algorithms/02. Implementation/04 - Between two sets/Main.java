/**
 *              04 | BETWEEN TWO SETS
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
        int aCount = scan.nextInt();
        int bCount = scan.nextInt();

        int[] a = new int[aCount];
        for (int i = 0; i < aCount; ++i) {
            a[i] = scan.nextInt();
        }

        int[] b = new int[bCount];
        for (int i = 0; i < bCount; ++i) {
            b[i] = scan.nextInt();
        }
        scan.close();

        int result = solveTwoSets(a, b);
        System.out.println(result);
    }

    private static int solveTwoSets(int[] a, int[] b) {
        int lcmSet1 = getLowestCommonMultipleFromSet(a);
        int gcdSet2 = getGreatestCommonDivisor(b);

        if (lcmSet1 > getMinValueFromArray(b) || lcmSet1 < 0) {
            return 0;
        }
        return countMultiples(lcmSet1, gcdSet2);
    }

    private static int getMaxValueFromArray(int[] array) {
        int max = Integer.MIN_VALUE;
        for (int i : array) {
            max = (i > max) ? i : max;
        }
        return max;
    }

    private static int getMinValueFromArray(int[] array) {
        int min = Integer.MAX_VALUE;
        for (int i : array) {
            min = (i < min) ? i : min;
        }
        return min;
    }

    private static int getLowestCommonMultipleFromSet(int[] array) {
        int value = getMaxValueFromArray(array);
        for (int i : array) {
            value *= (value % i == 0) ? 1 : getLowestCommonMultiple(value, i);
        }
        return value;
    }

    private static int getGreatestCommonDivisor(int[] array) {
        int index = 1;
        int value = 0;
        int min = getMinValueFromArray(array);

        while (index++ <= min) {
            boolean isTrue = true;
            for (int i : array) {
                if (i % index == 0) {
                    isTrue = true;
                } else {
                    isTrue = false;
                    break;
                }
            }
            if (isTrue) {
                value = index;
            }
        }
        return value;
    }

    private static int getLowestCommonMultiple(int a, int b) {
        int value = 1;
        int index = 1;
        while (index++ <= Math.sqrt(b)) {
            value = ((index * a) % b == 0) ? index : value;
        }
        return value;
    }

    private static int countMultiples(int a, int b) {
        int result = 0;
        int index = a;
        while (index <= b) {
            if ((b % index == 0) && (index % a == 0)) {
                result++;
            }
            index++;
        }
        return result;
    }
}