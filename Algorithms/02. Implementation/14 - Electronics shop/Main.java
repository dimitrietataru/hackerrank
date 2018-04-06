/**
 *              14 | ELECTRONICS SHOP
 * Domain       ALGORITHMS
 * Sub domain   IMPLEMENTATION
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner scan = new Scanner(file);
        {
            int budget = scan.nextInt();
            Integer[] keyboards = new Integer[scan.nextInt()];
            Integer[] usbs = new Integer[scan.nextInt()];
            for (int i = 0; i < keyboards.length; ++i) {
                keyboards[i] = scan.nextInt();
            }
            for (int i = 0; i < usbs.length; ++i) {
                usbs[i] = scan.nextInt();
            }

            int moneySpent = getMoneySpent(keyboards, usbs, budget);
            System.out.println(moneySpent);
        }
        scan.close();
    }

    private static int getMoneySpent(Integer[] keyboards, Integer[] usbs, int budget) {
        int max = -1;
        for (int kb : keyboards) {
            for (int usb : usbs) {
                int sum = kb + usb;
                max = ((sum <= budget) && (sum > max)) ? sum : max;
            }
        }
        return max;
    }

    private static int getMoneySpentOptimized(Integer[] keyboards, Integer[] usbs, int budget) {
        /* Sort the arrays in descending and ascending order */
        Arrays.sort(keyboards, Collections.reverseOrder());
        Arrays.sort(usbs);

        int max = -1;
        for (int i = 0, j = 0; i < keyboards.length; ++i) {
            for (; j < usbs.length; ++j) {
                int sum = keyboards[i] + usbs[j];
                if (sum > budget) {
                    /* This prevents j from incrementing */
                    break;
                }
                max = Math.max(sum, max);
            }
        }
        return max;
    }
}
