/**
 *              49 | CHOCOLATE FEAST
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
        {
            int trips = scan.nextInt();
            for (int i = 0; i < trips; ++i) {
                int dollars = scan.nextInt();
                int cost = scan.nextInt();
                int wrapperCost = scan.nextInt();

                chocolateFeast(trips, dollars, cost, wrapperCost);
            }
        }
        scan.close();
    }

    private static void chocolateFeast(int trips, int dollars, int cost, int wCost) {
        int result = dollars / cost;
        int wrappers = result;
        while (trips-- >= 0 && (wrappers >= wCost)) {
            int chocoWrappers = wrappers / wCost;
            wrappers = (wrappers % wCost) + (wrappers / wCost);

            wrappers += chocoWrappers;
            result += chocoWrappers;
        }

        System.out.println(result);
    }
}
