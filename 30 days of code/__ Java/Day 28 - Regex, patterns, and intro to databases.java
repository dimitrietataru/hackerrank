/**
 *              HELLO, WORLD | JAVA
 * Domain       30 DAYS OF CODE
 * Sub domain   DAY 28
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner scan = new Scanner(file);
        {
            List<String> names = new ArrayList<>();
            int n = Integer.parseInt(scan.nextLine());
            while (n-- > 0) {
                String s[] = scan.nextLine().split(" ");
                if (isValidEmail(s[1])) {
                    names.add(s[0]);
                }
            }
            sortAndPrintList(names);
        }
        scan.close();
    }

    private static boolean isValidEmail(String email) {
        return email.matches("^(.+)(@gmail.com)$");
    }

    private static void sortAndPrintList(List<String> names) {
        Collections.sort(names);
        names.forEach(System.out::println);
    }
}
