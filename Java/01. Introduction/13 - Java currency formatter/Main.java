/**
 *              13 | JAVA CURRENCY FORMATTER
 * Domain       JAVA
 * Sub domain   INTRODUCTION
 */

// https://en.wikipedia.org/wiki/Double-precision_floating-point_format
// https://docs.oracle.com/javase/8/docs/api/java/text/NumberFormat.html
// https://docs.oracle.com/javase/8/docs/api/java/text/NumberFormat.html#getCurrencyInstance-java.util.Locale-

import java.io.File;
import java.io.FileNotFoundException;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Locale localeIndia = new Locale("en", "IN");
        File file = new File("input.txt");
        Scanner scan = new Scanner(file);
        {
            double payment = scan.nextDouble();

            String us = NumberFormat.getCurrencyInstance(Locale.US).format(payment);
            String india = NumberFormat.getCurrencyInstance(localeIndia).format(payment);
            String china = NumberFormat.getCurrencyInstance(Locale.CHINA).format(payment);
            String france = NumberFormat.getCurrencyInstance(Locale.FRANCE).format(payment);

            System.out.println("US: " + us);
            System.out.println("India: " + india);
            System.out.println("China: " + china);
            System.out.println("France: " + france);
        }
        scan.close();
    }
}
