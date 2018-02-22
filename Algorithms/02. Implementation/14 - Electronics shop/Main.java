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
        int money = scan.nextInt();
        int kbCount = scan.nextInt();
        int usbCount = scan.nextInt();
        Integer[] kb = new Integer[kbCount];
        Integer[] usb = new Integer[usbCount];
        for (int i = 0 ; i < kb.length; ++i) {
            kb[i] = scan.nextInt();
        }
        for (int i = 0 ; i < usb.length; ++i) {
            usb[i] = scan.nextInt();
        }
        scan.close();

        int moneySpent = getMoneySpent(kb, usb, money);
        System.out.println(moneySpent);
    }

    private static int getMoneySpent(Integer[] kb, Integer[] usb, int money) {
        int max = -1;
        for (int i : kb) {
            for (int j : usb) {
                int currentSum = i + j;
                max = ((currentSum <= money) && (currentSum > max)) ? currentSum : max;
            }
        }
        return max;
    }

    private static int getMoneySpentOptimized(Integer[] kb, Integer[] usb, int money) {
        /* Sort the arrays in descending and ascending order */
        Arrays.sort(kb, Collections.reverseOrder());
        Arrays.sort(usb);
        int max = -1;

        for (int i = 0, j = 0; i < kb.length; ++i) {
            for (; j < usb.length; ++j) {
                int currentSum = kb[i] + usb[j];
                if (currentSum > money) {
                    /* This prevents j from incrementing */
                    break;
                }
                if (currentSum > max) {
                    max = currentSum;
                }
            }
        }
        return max;
    }
}