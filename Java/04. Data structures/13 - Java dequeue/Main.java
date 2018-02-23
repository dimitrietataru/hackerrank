/**
 *              13 | JAVA DEQUEUE
 * Domain       JAVA
 * Sub domain   DATA STRUCTURES
 */

// http://docs.oracle.com/javase/7/docs/api/java/util/Deque.html

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Deque<Integer> deque = new ArrayDeque<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        File file = new File("input.txt");
        Scanner scan = new Scanner(file);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int max = 0;

        for (int i = 0; i < n; i++) {
            /* Remove old value, if necessary */
            if (i >= m) {
                int oldValue = deque.remove();
                if (map.get(oldValue) == 1) {
                    map.remove(oldValue);
                } else {
                    map.put(oldValue, map.get(oldValue) - 1);
                }
            }

            /* Add new value */
            int value = scan.nextInt();
            deque.add(value);
            map.merge(value,1, Integer::sum);

            max = Math.max(max, map.size());
        }
        scan.close();

        System.out.println(max);
    }
}

            /* HASH SET METHOD - TIMES OUT ON LARGE TEST CASES - 100.000 LENGTH ARRAYS */
//          HashSet<Integer> set = new HashSet<>();
//          for (int i = 0; i < n; ++i) {
//              int value = scan.nextInt();
//              deque.addFirst(value);
//              set.add(value);
//
//              if (deque.size() == m) {
//                  if (set.size() > max) {
//                      max = set.size();
//                  }
//                  int first = deque.remove();
//                  if (!deque.contains(first)) {
//                      set.remove(first);
//                  }
//              }
//          }