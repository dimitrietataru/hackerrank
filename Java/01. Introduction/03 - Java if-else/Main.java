/**
 *              03 | JAVA IF-ELSE
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
            int n = scan.nextInt();

            String answer = "";
            if (n % 2 == 1) {
                answer = "Weird";
            } else {
                if (n > 20) {
                    answer = "Not Weird";
                } else if (n >= 6) {
                    answer = "Weird";
                } else if (n >= 2) {
                    answer = "Not Weird";
                }
            }

            System.out.println(answer);
        }
        scan.close();
    }
}
