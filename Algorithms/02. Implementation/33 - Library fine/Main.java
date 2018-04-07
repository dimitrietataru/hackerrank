/**
 *              33 | LIBRARY FINE
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
            int retD = scan.nextInt();
            int retM = scan.nextInt();
            int retY = scan.nextInt();

            int lastD = scan.nextInt();
            int lastM = scan.nextInt();
            int lastY = scan.nextInt();

            int result = libraryFine(retD, retM, retY, lastD, lastM, lastY);
            System.out.println(result);
        }
        scan.close();
    }

    private static int libraryFine(int retD, int retM, int retY, int lastD, int lastM, int lastY) {
        if (retY > lastY) {
            return 10000;
        }

        if (retY == lastY) {
            if (retM > lastM) {
                return 500 * (retM - lastM);
            } else if (retM == lastM) {
                if (retD > lastD) {
                    return 15 * (retD - lastD);
                }
            }
        }

        return 0;
    }
}
