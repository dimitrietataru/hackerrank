/**
 *              13 | COUNTING VALLEYS
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
        int n = scan.nextInt();
        scan.nextLine();
        String road = scan.nextLine();
        scan.close();

        int position = 0;
        int valleyCount = 0;
        for (int i = 0; i < n; ++i) {
            if (road.charAt(i) == 'U') {
                position++;
            } else if (road.charAt(i) == 'D') {
                if (position == 0) {
                    valleyCount++;
                }
                position--;
            }
        }

        System.out.println(valleyCount);
    }
}