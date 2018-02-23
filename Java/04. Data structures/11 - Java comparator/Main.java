/**
 *              11 | JAVA COMPARATOR
 * Domain       JAVA
 * Sub domain   DATA STRUCTURES
 */

// https://docs.oracle.com/javase/7/docs/api/java/util/Comparator.html#compare%28T,%20T%29

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner scan = new Scanner(file);
        int queries = scan.nextInt();

        Player[] playerArray = new Player[queries];
        Checker checker = new Checker();

        for (int i = 0; i < queries; ++i) {
            String name = scan.next();
            int score = scan.nextInt();
            playerArray[i] = new Player(name, score);
        }
        scan.close();

        Arrays.sort(playerArray, checker);
        for (Player p : playerArray) {
            System.out.printf("%s %s\n", p.name, p.score);
        }
    }
}

class Player {
    String name;
    int score;

    Player(String name, int score) {
        this.name = name;
        this.score = score;
    }
}

class Checker implements Comparator<Player>{
    @Override
    public int compare(Player p1, Player p2) {
        if (p1.score == p2.score) {
            return p1.name.compareTo(p2.name);
        } else {
            return (p1.score > p2.score ? -1 : 1);
        }
    }
}