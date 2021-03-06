/**
 *              05 | JAVA 1D ARRAY II
 * Domain       JAVA
 * Sub domain   DATA STRUCTURES
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner scan = new Scanner(file);
        {
            int testCases = scan.nextInt();
            while (testCases-- > 0) {
                int[] game = new int[scan.nextInt()];
                int leap = scan.nextInt();

                for (int i = 0; i < game.length; ++i) {
                    game[i] = scan.nextInt();
                }

                System.out.println((canWin(game, leap, 0) ? "YES" : "NO"));
            }
        }
        scan.close();
    }

    private static boolean canWin(int[] game, int leap, int i) {
        if (i < 0 || game[i] == 1) {
            return false;
        }

        if ((i + 1 >= game.length) || (i + leap >= game.length)) {
            return true;
        }

        game[i] = 1;
        return canWin(game, leap, i + leap) ||
                canWin(game, leap, i + 1) ||
                canWin(game, leap, i - 1);
    }
}

/*      arr = { 0 1 1 0 0 1 0 0 1 };
        leap = 4
    Start off in position 0:
        { *0* 1 1 0 0 1 0 0 1 }
    Can't walk forward, but can jump forward by m positions: i + m = 0 + 4 = 4, now we're at position 4
        { 0 1 1 0 *0* 1 0 0 1 }
    Can't walk forward, can't jump forward, but can walk backward to i - 1 = 3, end up in position 3
        { 0 1 1 *0* 0 1 0 0 1 }
    Can jump from here because i + m = 3 + 4 = 7; position 7 contains a 0, legal move, you end up here
        { 0 1 1 0 0 1 0 *0* 1 }
    Can jump 4 position forward and end up at i = 11 which is beyond the array length and win! */
