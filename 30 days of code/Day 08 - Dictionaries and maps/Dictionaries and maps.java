/**
 *              DICTIONARIES AND MAPS | JAVA
 * Domain       30 DAYS OF CODE
 * Sub domain   DAY 08
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner scan = new Scanner(file);
        int n = scan.nextInt();
        scan.nextLine();
        Map<String, Integer> phoneBook = new HashMap<>(n);
        for (int i = 0; i < n; ++i) {
            phoneBook.put(scan.next(), scan.nextInt());
        }
        scan.nextLine();

        while (scan.hasNextLine()) {
            String s = scan.nextLine();
            if (phoneBook.containsKey(s)) {
                System.out.printf("%s=%d\n", s, phoneBook.get(s));
            } else {
                System.out.println("Not found");
            }
        }

        scan.close();
    }
}