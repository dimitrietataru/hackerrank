/**
 *              37 | JUMPING ON THE CLOUDS
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
        int cloudCount = scan.nextInt();
        int[] clouds = new int[cloudCount];
        for (int i = 0; i < clouds.length; i++) {
            clouds[i] = scan.nextInt();
        }
        scan.close();

        jumpingOnTheClouds(clouds);
    }

    /* Start from index 0
    *  At each index, increment number of jumps
    *  If we can jump over 2 clouds, increment the index
    *  If we are at 'length - 2', there is guaranteed that we can jump to 'n - 1', therefore to 'n'  */
    private static void jumpingOnTheClouds(int[] clouds) {
        int jumps = 0;
        for (int i = 0; i < clouds.length - 1; ++i, jumps++) {
            if ((i < clouds.length - 2) && (clouds[i + 2] == 0)) {
                i++;
            }
        }
        System.out.println(jumps);
    }
}