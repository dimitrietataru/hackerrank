/**
 *              24 | VIRTUAL ADVERTISING
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
        int input = scan.nextInt();
        scan.close();

        viralAdvertising(input);
    }

    private static void viralAdvertising(int input) {
        if (input == 0) {
            System.out.println(0);
            return;
        }
        int seeds = 5;
        int nextSeeds = seeds / 2;
        int result = nextSeeds;
        while(--input > 0) {
            seeds = nextSeeds * 3;
            nextSeeds = seeds / 2;
            result += nextSeeds;
        }
        System.out.println(result);
    }
}