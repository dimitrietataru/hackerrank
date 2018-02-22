/**
 *              15 | CATS AND A MOUSE
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
        int queries = scan.nextInt();
        for (int i = 0; i < queries; ++i) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            int z = scan.nextInt();
            catsAndMouse(x, y, z);
        }
        scan.close();
    }

    private static void catsAndMouse(int x, int y, int z) {
        int distanceA = Math.abs(z - x);
        int distanceB = Math.abs(z - y);

        if (distanceA == distanceB) {
            System.out.println("Mouse C");
        } else if (distanceA > distanceB) {
            System.out.println("Cat B");
        } else {
            System.out.println("Cat A");
        }
    }
}