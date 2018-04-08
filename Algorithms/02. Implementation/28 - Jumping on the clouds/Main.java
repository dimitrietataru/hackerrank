/**
 *              28 | JUMPING ON THE CLOUDS
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
            int[] clouds = new int[scan.nextInt()];
            int jump = scan.nextInt();

            for (int i = 0; i < clouds.length; ++i) {
                clouds[i] = scan.nextInt();
            }

            jumpingOnTheClouds(clouds, jump);
        }
        scan.close();
    }

    private static void jumpingOnTheClouds(int[] clouds, int jump) {
        int total = clouds.length;
        int energy = 100;
        int start = 0;
        while (energy > 0) {
            start = (start + jump + total) % total;
            energy -= (clouds[start] == 1) ? 3 : 1;
            
            if (start == 0) {
                System.out.println(energy);
                return;
            }
        }
        System.out.println("0");
    }
}
