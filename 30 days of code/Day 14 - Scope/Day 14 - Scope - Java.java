/**
 *              SCOPE | JAVA
 * Domain       30 DAYS OF CODE
 * Sub domain   DAY 14
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
        for (int i = 0; i < array.length; ++i) {
            array[i] = scan.nextInt();
        }
        scan.close();

        Difference difference = new Difference(array);
        difference.computeDifference();
        System.out.println(difference.maximumDifference);
    }
}

class Difference {
    private int[] elements;
    int maximumDifference;

    Difference(int[] elements) {
        this.elements = elements;
    }

    void computeDifference() {
        maximumDifference = Integer.MIN_VALUE;
        for (int i = 0; i < elements.length - 1; ++i) {
            for (int j = i + 1; j < elements.length; ++j) {
                int difference = Math.abs(elements[i] - elements[j]);
                maximumDifference = (difference > maximumDifference) ? difference : maximumDifference;
            }
        }
    }
}