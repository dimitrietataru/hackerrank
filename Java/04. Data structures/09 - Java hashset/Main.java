/**
 *              09 | JAVA HASH SET
 * Domain       JAVA
 * Sub domain   DATA STRUCTURES
 */

// https://docs.oracle.com/javase/7/docs/api/java/util/HashSet.html

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner scan = new Scanner(file);
        {
            Set<String> set = new HashSet<>();

            int entries = scan.nextInt();
            while (entries-- > 0) {
                set.add(scan.next() + " " + scan.next());
                System.out.println(set.size());
            }
        }
        scan.close();
    }
}
