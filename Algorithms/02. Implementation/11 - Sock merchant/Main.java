/**
 *              11 | SOCK MERCHANT
 * Domain       ALGORITHMS
 * Sub domain   IMPLEMENTATION
 */

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
            Set<Integer> socks = new HashSet<>();
            int n = scan.nextInt();

            int pairs = 0;
            for (int i = 0; i < n; ++i) {
                int currentSock = scan.nextInt();
                if (socks.contains(currentSock)) {
                    socks.remove(currentSock);
                    pairs++;
                } else {
                    socks.add(currentSock);
                }
            }
            System.out.println(pairs);
        }
        scan.close();
    }
}
