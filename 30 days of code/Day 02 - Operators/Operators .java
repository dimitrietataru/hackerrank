/**
 *              OPERATORS | JAVA
 * Domain       30 DAYS OF CODE
 * Sub domain   DAY 02
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner scan = new Scanner(file);
        {
            double mealCost = Double.parseDouble(scan.nextLine());
            int tipPercent = scan.nextInt();
            int taxPercent = scan.nextInt();

            double tip = (mealCost * tipPercent) / 100;
            double tax = (mealCost * taxPercent) / 100;
            int totalCost = (int) Math.round(mealCost + tip + tax);

            System.out.println("The total meal cost is " + totalCost + " dollars.");
        }
        scan.close();
    }
}
