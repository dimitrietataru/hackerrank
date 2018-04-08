/**
 *              05 | BREAKING THE RECORDS
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
            int[] games = new int[scan.nextInt()];
            for (int i = 0; i < games.length; ++i) {
                games[i] = scan.nextInt();
            }
            breakRecords(games);
        }
        scan.close();
    }

    private static void breakRecords(int[] gameArray) {
        int highScore = gameArray[0];
        int lowScore = gameArray[0];

        int highStreak = 0;
        int lowStreak = 0;

        for (int i = 1; i < gameArray.length; ++i) {
            int currentScore = gameArray[i];
            if (currentScore > highScore) {
                highScore = currentScore;
                highStreak++;
            }

            if (currentScore < lowScore) {
                lowScore = currentScore;
                lowStreak++;
            }
        }

        System.out.println(highStreak + " " + lowStreak);
    }
}
