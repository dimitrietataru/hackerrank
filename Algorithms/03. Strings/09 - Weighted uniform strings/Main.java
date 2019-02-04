/**
 *              09 | WEIGHTED UNIFORM STRINGS
 * Domain       ALGORITHMS
 * Sub domain   STRINGS
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
            String input = scan.nextLine();
            Set<Integer> weights = getWeights(input);
            int testCases = scan.nextInt();
            while (testCases-- > 0) {
                int query = scan.nextInt();
                System.out.println(weights.contains(query) ? "Yes" : "No");
            }
        }
        scan.close();
    }

    private static Set<Integer> getWeights(String input) {
        Integer[] weights = new Integer[input.length()];
        for (int i = 0; i < input.length(); ++i) {
            weights[i] = input.charAt(i) - 96;
        }

        int sum = 0;
        int lastElement = 0;
        Set<Integer> set = new HashSet<>();
        for (int i : weights) {
            if (i == lastElement) {
                sum += lastElement;
            }
            if (i != lastElement) {
                lastElement = sum = i;
            }
            set.add(sum);
        }
        return set;
    }
}
