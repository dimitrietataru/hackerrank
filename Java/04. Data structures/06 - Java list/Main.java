/**
 *              06 | JAVA LIST
 * Domain       JAVA
 * Sub domain   DATA STRUCTURES
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner scan = new Scanner(file);
        int n = scan.nextInt();

        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; ++i) {
            int value = scan.nextInt();
            list.add(i, value);
        }

        int operations = scan.nextInt();
        while (operations -- > 0) {
            String action = scan.next();
            if (action.equals("Insert")) {
                int index = scan.nextInt();
                int value = scan.nextInt();
                list.add(index, value);
            }

            if (action.equals("Delete")) {
                int index = scan.nextInt();
                list.remove(index);
            }
        }
        scan.close();

        for (int value : list) {
            System.out.print(value + " ");
        }
    }
}