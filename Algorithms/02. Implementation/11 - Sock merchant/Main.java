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
        Set<Integer> socks = new HashSet<>();
        File file = new File("input.txt");
        Scanner scan = new Scanner(file);
        int n = scan.nextInt();

        int sockPairs = 0;
        for (int i = 0; i < n; ++i) {
            int currentSock = scan.nextInt();
            if (socks.contains(currentSock)) {
                socks.remove(currentSock);
                sockPairs++;
            } else {
                socks.add(currentSock);
            }
        }
        scan.close();

        System.out.println(sockPairs);
    }
}