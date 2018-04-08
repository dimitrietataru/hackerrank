/**
 *              52 | FLATLAND SPACE STATIONS
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
            int[] cities = new int[scan.nextInt()];
            int stations = scan.nextInt();
            for (int i = 0; i < stations; ++i) {
                cities[scan.nextInt()] = 1;
            }

            flatlandSpaceStations(cities);
        }
        scan.close();
    }

    private static void flatlandSpaceStations(int[] cities) {
        int len = cities.length;
        int result = 0;

        for (int i = 0; i < len; i++) {
            if (cities[i] == 1) continue;

            int l = 1;
            int r = 1;
            boolean isEdge = (i == 0) || (i == len - 1);

            for (int j = i - 1; j >= 0 && cities[j] == 0; --j, ++l);
            for (int j = i + 1; j < len && cities[j] == 0; ++j, ++r);

            int best = (isEdge) ? Math.max(l, r) : Math.min(l, r);
            result = Math.max(best, result);
        }
        System.out.println(result);
    }
}
