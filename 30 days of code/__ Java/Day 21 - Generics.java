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
        {
            Integer[] intArray = new Integer[scan.nextInt()];
            for (int i = 0; i < intArray.length; ++i) {
                intArray[i] = scan.nextInt();
            }

            String[] stringArray = new String[scan.nextInt()];
            for (int i = 0; i < stringArray.length; ++i) {
                stringArray[i] = scan.next();
            }

            Printer<Integer> intPrinter = new Printer<>();
            Printer<String> stringPrinter = new Printer<>();

            intPrinter.printArray(intArray);
            stringPrinter.printArray(stringArray);
        }
        scan.close();
    }
}

class Printer <T> {
    void printArray(T[] array) {
        for (T t : array) {
            System.out.println(t);
        }
    }
}
