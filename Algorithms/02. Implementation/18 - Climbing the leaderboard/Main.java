/**
 *              18 | CLIMBING THE LEADERBOARD
 * Domain       ALGORITHMS
 * Sub domain   IMPLEMENTATION
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import static java.util.stream.IntStream.range;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner scan = new Scanner(file);

        int n = scan.nextInt();
        int[] playerInput = new int[n];
        for (int i = 0; i < playerInput.length; ++i) {
            playerInput[i] = scan.nextInt();
        }
        int[] playerDistinct = range(0, n).map(i -> playerInput[i]).distinct().toArray();

        int m = scan.nextInt();
        int index = playerDistinct.length - 1;
        for (int i = 0; i < m; ++i) {
            int aliceValue = scan.nextInt();

            while (index >= 0) {
                if (aliceValue >= playerDistinct[index]) {
                    index--;
                } else {
                    System.out.println(index + 2);
                    break;
                }
            }
            if (index < 0) {
                System.out.println(1);
            }
        }
        scan.close();
    }
}