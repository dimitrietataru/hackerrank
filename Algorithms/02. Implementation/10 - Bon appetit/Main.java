/**
 *              10 | BON APPETIT
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
            int[] costs = new int[scan.nextInt()];
            int k = scan.nextInt();

            for (int i = 0; i < costs.length; ++i) {
                costs[i] = scan.nextInt();
            }

            int charged = scan.nextInt();
            bonAppetit(costs, k, charged);
        }
        scan.close();
    }

    private static void bonAppetit(int[] costs, int k, int charged) {
        int sum = -costs[k];
        for (int i : costs) {
            sum += i;
        }

        System.out.println((sum / 2 == charged) ? "Bon Appetit" : (charged - (sum / 2)));
    }
}
