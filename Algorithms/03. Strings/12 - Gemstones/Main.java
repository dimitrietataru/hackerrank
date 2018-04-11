/**
 *              12 | GEMSTONES
 * Domain       ALGORITHMS
 * Sub domain   STRINGS
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner scan = new Scanner(file);
        {
            Map<Character, Integer> map = new HashMap<>();
            int gems = Integer.parseInt(scan.nextLine());
            for (int i = 0; i < gems; ++i) {
                String gem = scan.next();
                buildGemstoneMap(map, gem);
            }
            checkGemstones(map, gems);
        }
        scan.close();
    }

    private static void buildGemstoneMap(Map<Character, Integer> map, String gem) {
        Set<Character> chars = gem.chars().mapToObj(c -> (char) c).collect(Collectors.toSet());
        for (char c : chars) {
            map.put(c, (map.containsKey(c) ? map.get(c) + 1 : 1));
        }
    }

    private static void checkGemstones(Map<Character, Integer> map, int gems) {
        int result = 0;
        for (Map.Entry<Character, Integer> pair : map.entrySet()) {
            result += (pair.getValue() >= gems) ? 1 : 0;
        }

        System.out.println(result);
    }
}
