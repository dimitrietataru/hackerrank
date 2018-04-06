/**
 *              18 | CLIMBING THE LEADERBOARD
 * Domain       ALGORITHMS
 * Sub domain   IMPLEMENTATION
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner scan = new Scanner(file);
        {
            int[] players = new int[scan.nextInt()];
            for (int i = 0; i < players.length; ++i) {
                players[i] = scan.nextInt();
            }

            int[] uniquePlayers = Arrays.stream(players).distinct().toArray();

            int n = scan.nextInt();
            int index = uniquePlayers.length - 1;
            for (int i = 0; i < n; ++i) {
                int aliceValue = scan.nextInt();

                while (index >= 0) {
                    if (aliceValue >= uniquePlayers[index]) {
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
        }
        scan.close();
    }
}
