/**
 *              09 | JAVA END-OF-FILE
 * Domain       JAVA
 * Sub domain   INTRODUCTION
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner scan = new Scanner(file);
        {
            int index = 0;
            while(scan.hasNext()) {
                System.out.println(++index + " " + scan.nextLine());
            }
        }
        scan.close();
    }
}
