/**
 *              40 | ACM ICPC TEAM
 * Domain       ALGORITHMS
 * Sub domain   IMPLEMENTATION
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner scan = new Scanner(file);
        int peoples = scan.nextInt();
        int topics = scan.nextInt();
        byte[][] bytes = new byte[peoples][topics];
        for (int i = 0; i < peoples; ++i) {
            String in = scan.next();
            for (int j = 0; j < in.length(); ++j) {
                bytes[i][j] = Byte.parseByte(String.valueOf(in.charAt(j)));
            }
        }
        scan.close();

        acmIcpcTeam(bytes, peoples, topics);
    }

    private static void acmIcpcTeam(byte[][] b, int p, int t) {
        int result = 0;
        int max = 0;
        for (int i = 0; i < p - 1; ++i) {
            for (int j = i + 1; j < p; ++j) {
                int count = 0;
                for (int k = 0; k < t; ++k) {
                    count += b[i][k] | b[j][k];
                }
                if (count > max) {
                    max = count;
                    result = 0;
                }
                if (count == max) {
                    result++;
                }
            }
        }
        System.out.println(max + "\n" + result);
    }
}