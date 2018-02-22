/**
 *              33 | LIBRARY FINE
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
        int rDay = scan.nextInt();
        int rMonth = scan.nextInt();
        int rYear = scan.nextInt();

        int dDay = scan.nextInt();
        int dMonth = scan.nextInt();
        int dYear = scan.nextInt();
        scan.close();

        if (rYear < dYear) {
            System.out.println("0");
        } else if (rYear > dYear) {
            System.out.println("10000");
        } else if (rMonth < dMonth) {
            System.out.println("0");
        } else if (rMonth > dMonth) {
            System.out.println(500 * (rMonth - dMonth));
        } else if (rDay <= dDay) {
            System.out.println("0");
        } else {
            System.out.println(15 * (rDay - dDay));
        }
    }
}