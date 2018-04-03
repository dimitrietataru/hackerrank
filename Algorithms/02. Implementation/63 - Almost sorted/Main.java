/**
 *              63 | ALMOST SORTED
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

        int n = scan.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; ++i) {
            array[i] = scan.nextInt();
        }
        scan.close();

        almostSorted(array);
    }

    private static void almostSorted(int[] a) {
        if (isSortedArray(a)) {
            System.out.println("yes");
        }

        int startIndex = 0;
        int endIndex = 0;
        for (int i = 0; i < a.length - 1; ++i) {
            if (a[i] > a[i + 1]) {
                startIndex = i;
                break;
            }
        }
        for (int i = a.length - 1; i > 0; --i) {
            if (a[i] < a[i - 1]) {
                endIndex = i;
                break;
            }
        }

        swap(a, startIndex, endIndex);
        if (isSortedArray(a)) {
            System.out.printf("yes\nswap %d %d", startIndex + 1, endIndex + 1);
            return;
        } else {
            swap(a, startIndex, endIndex);
            reverse(a, startIndex, endIndex);
        }
        if (isSortedArray(a)) {
            System.out.printf("yes\nreverse %d %d", startIndex + 1, endIndex + 1);
            return;
        }
        System.out.println("no");
    }

    private static boolean isSortedArray(int[] a) {
        for (int i = 0; i < a.length - 1; ++i) {
            if (a[i] > a[i + 1]) {
                return false;
            }
        }
        return true;
    }

    private static void swap(int[] a, int start, int end) {
        int temp = a[start];
        a[start] = a[end];
        a[end] = temp;
    }

    private static void reverse(int[] a, int start, int end) {
        int mid = (start + end) / 2;
        for (int i = start; i <= mid; ++i) {
            int temp = a[i];
            a[i] = a[end];
            a[end--] = temp;
        }
    }
}