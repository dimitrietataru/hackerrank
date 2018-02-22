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
        int gameCount = scan.nextInt();
        int[] gameArray = new int[gameCount];
        for (int i = 0; i < gameCount; ++i) {
            gameArray[i] = scan.nextInt();
        }
        scan.close();

        breakRecords(gameArray);
    }

    private static void breakRecords(int[] gameArray) {
        int highestScore = gameArray[0];
        int lowestScore = gameArray[0];

        int highStreak = 0;
        int lowStreak = 0;

        for (int i = 1; i < gameArray.length; ++i) {
            int currentScore = gameArray[i];
            if (currentScore > highestScore) {
                highestScore = currentScore;
                highStreak++;
            }

            if (currentScore < lowestScore) {
                lowestScore = currentScore;
                lowStreak++;
            }
        }

        System.out.println(highStreak + " " + lowStreak);
    }
}