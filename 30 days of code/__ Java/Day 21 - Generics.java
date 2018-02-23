/**
 *              GENERICS | JAVA
 * Domain       30 DAYS OF CODE
 * Sub domain   DAY 21
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner scan = new Scanner(file);
        int n = scan.nextInt();
        Integer[] intArray = new Integer[n];
        for (int i = 0; i < n; ++i) {
            intArray[i] = scan.nextInt();
        }

        n = scan.nextInt();
        String[] stringArray = new String[n];
        for (int i = 0; i < n; ++i) {
            stringArray[i] = scan.next();
        }
        scan.close();

        Printer<Integer> intPrinter = new Printer<>();
        Printer<String> stringPrinter = new Printer<>();

        intPrinter.printArray(intArray);
        stringPrinter.printArray(stringArray);
    }
}

class Printer <T> {
    void printArray(T[] array) {
        for (T t : array) {
            System.out.println(t);
        }
    }
}