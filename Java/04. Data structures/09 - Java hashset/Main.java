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
        HashSet<String> hashSet = new HashSet<>();
        File file = new File("input.txt");
        Scanner scan = new Scanner(file);
        int queries = scan.nextInt();

        String[] pair_left = new String[queries];
        String[] pair_right = new String[queries];

        for (int i = 0; i < queries; ++i) {
            pair_left[i] = scan.next();
            pair_right[i] = scan.next();
        }
        scan.close();

        for (int i = 0; i < queries; ++i) {
            hashSet.add(pair_left[i] + " " + pair_right[i]);
            System.out.println(hashSet.size());
        }
    }
}