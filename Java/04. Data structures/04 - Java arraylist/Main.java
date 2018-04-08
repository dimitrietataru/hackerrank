/**
 *              04 | JAVA ARRAY LIST
 * Domain       JAVA
 * Sub domain   DATA STRUCTURES
 */

// https://docs.oracle.com/javase/7/docs/api/java/util/ArrayList.html

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner scan = new Scanner(file);
        {
            ArrayList<ArrayList<Integer>> arrays = new ArrayList<>();

            int n = scan.nextInt();
            for (int i = 0; i < n; ++i) {
                int len = scan.nextInt();
                ArrayList<Integer> array = new ArrayList<>(len);
                for (int j = 0; j < len; ++j) {
                    array.add(scan.nextInt());
                }
                arrays.add(i, array);
            }

            int queries = scan.nextInt();
            for (int i = 0; i < queries; ++i) {
                int x = scan.nextInt();
                int y = scan.nextInt();
                try {
                    int value = arrays.get(x - 1).get(y - 1);
                    System.out.println(value);
                } catch (IndexOutOfBoundsException oob) {
                    System.out.println("ERROR!");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        scan.close();
    }
}
