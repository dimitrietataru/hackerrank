/**
 *              65 | HALLOWEEN SALE
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
            int price = scan.nextInt();
            int dif = scan.nextInt();
            int min = scan.nextInt();
            int wallet = scan.nextInt();

            halloweenSale(price, dif, min, wallet);
        }
        scan.close();
    }

    private static void halloweenSale(int price, int dif, int min, int wallet) {
        int result = 0;
        while (price <= wallet) {
            wallet -= price;
            price -= dif;
            price = Math.max(min, price);
            result++;
        }
        System.out.println(result);
    }
}
