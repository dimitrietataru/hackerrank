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
        {
            int testCases = scan.nextInt();
            while(testCases-- > 0) {
                int size = scan.nextInt();
                String input = scan.next();
                happyLadybugs(size, input.toCharArray());
            }
        }
        scan.close();
    }

    private static void happyLadybugs(int size, char[] chars) {
        if (chars.length == 1) {
            System.out.println(chars[0] == '_' ? "YES" : "NO");
            return;
        }

        int underScores = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : chars) {
            if (ch == '_') {
                underScores++;
            } else {
                map.put(ch, (map.containsKey(ch) ? (map.get(ch) + 1) : 1));
            }
        }

        if (underScores == size) {
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
            if (underScores == 0) {
                int sum = 0;
                for (int i = 0; i < size - 1; ++i) {
                    if (chars[i] == ch) {
                        sum++;
                        if ((chars[i + 1] != ch) && (sum != val) && ((sum % 2 == 1)
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
