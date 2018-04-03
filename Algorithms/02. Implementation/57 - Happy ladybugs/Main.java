/**
 *              57 | HAPPY LADYBUGS
 * Domain       ALGORITHMS
 * Sub domain   IMPLEMENTATION
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
        int testCases = scan.nextInt();
        while(testCases-- > 0) {
            int size = scan.nextInt();
            String input = scan.next();
            happyLadybugs(size, input);
        }
        scan.close();
    }

    private static void happyLadybugs(int size, String str) {
        if (size == 1) {
            System.out.println((str.charAt(0) == '_') ? "YES" : "NO");
            return;
        }

        int underscores = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < size; i++) {
            char ch = str.charAt(i);
            if(ch == '_') {
                underscores++;
            } else {
                map.put(ch, (map.containsKey(ch) ? (map.get(ch) + 1) : 1));
            }
        }

        if (underscores == size) {
            System.out.println("YES");
            return;
        }

        for(Map.Entry<Character, Integer> entry : map.entrySet()) {
            Character ch = entry.getKey();
            Integer val = entry.getValue();
            if (val == 1) {
                System.out.println("NO");
                return;
            }

            if (underscores == 0) {
                int sum = 0;
                for (int i = 0; i < size - 1; ++i) {
                    if (str.charAt(i) == ch) {
                        sum++;
                        if ((str.charAt(i + 1) != ch) && (sum != val) && ((sum % 2 == 1)
                                && (val - sum <= 1))) {
                            System.out.println("NO");
                            return;
                        }
                    }
                }
            }
        }
        System.out.println("YES");
    }
}