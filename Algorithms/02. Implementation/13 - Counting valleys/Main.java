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
        {
            scan.nextLine();
            String road = scan.nextLine();

            int position = 0;
            int valleyCount = 0;
            for (char ch : road.toCharArray()) {
                if (ch == 'U') {
                    position++;
                } else if (ch == 'D') {
                    if (position == 0) {
                        valleyCount++;
                    }
                    position--;
                }
            }

            System.out.println(valleyCount);
        }
        scan.close();
    }
}
