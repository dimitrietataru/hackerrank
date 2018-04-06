/**
 *              02 | APPLE AND ORANGE
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
            int houseX = scan.nextInt();
            int houseY = scan.nextInt();
            int treeA = scan.nextInt();
            int treeO = scan.nextInt();
            int aCount = scan.nextInt();
            int oCount = scan.nextInt();
            int[] apples = new int[aCount];
            int[] oranges = new int[oCount];
            int aHit = 0;
            int oHit = 0;
            for (int i = 0; i < aCount; ++i) {
                apples[i] = scan.nextInt();
                if ((treeA + apples[i] >= houseX) && (treeA + apples[i]) <= houseY) {
                    aHit++;
                }
            }
            for (int i = 0; i < oCount; ++i) {
                oranges[i] = scan.nextInt();
                if ((treeO + oranges[i] >= houseX)&& (treeO + oranges[i]) <= houseY) {
                    oHit++;
                }
            }
            System.out.println(aHit + "\n" + oHit);
        }
        scan.close();
    }
}
