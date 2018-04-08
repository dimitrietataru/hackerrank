/**
 *              BINARY NUMBERS | JAVA
 * Domain       30 DAYS OF CODE
 * Sub domain   DAY 10
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner scan = new Scanner(file);
        {
            int n = scan.nextInt();
            binaryNumbers(n);
        }
        scan.close();
    }

    private static void binaryNumbers(int n) {
        ArrayList<Integer> bytes = intToBinary(n);
        int currentCount = 0;
        int result = 0;

        for (Integer i : bytes) {
            currentCount = (i == 1) ? (currentCount + 1) : 0;
            result = Math.max(currentCount, result);
        }

        System.out.println(result);
    }

    private static ArrayList<Integer> intToBinary(int n) {
        ArrayList<Integer> bytes = new ArrayList<>();

        while (n > 0) {
            bytes.add(n % 2);
            n /= 2;
        }

        return bytes;
    }
}
