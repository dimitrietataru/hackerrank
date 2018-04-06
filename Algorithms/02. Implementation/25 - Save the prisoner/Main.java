/**
 *              25 | SAVE THE PRISONER!
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
            int testCases = scan.nextInt();
            while(testCases-- > 0) {
                int prisoners = scan.nextInt();
                int sweets = scan.nextInt();
                int prisonerID = scan.nextInt();
                saveThePrisoner(prisoners, sweets, prisonerID);
            }
        }
        scan.close();
    }

    private static void saveThePrisoner(int prisoners, int sweets, int prisonerID) {

        /* Long version */
        //int lastPrisoner = (prisonerID + sweets - 1) % prisoners;
        //lastPrisoner = (lastPrisoner == 0) ? prisoners : lastPrisoner;

        int lastPrisoner = (((prisonerID - 1 + sweets - 1) % prisoners) + 1);
        System.out.println(lastPrisoner);
    }
}
