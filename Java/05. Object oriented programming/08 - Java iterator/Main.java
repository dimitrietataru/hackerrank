/**
 *              08 | JAVA ITERATOR
 * Domain       JAVA
 * Sub domain   OBJECT ORIENTED PROGRAMMING
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner scan = new Scanner(file);
        {
            ArrayList<Object> elements = new ArrayList<>();
            int n = scan.nextInt();
            int m = scan.nextInt();

            for (int i = 0; i < n; ++i) {
                elements.add(scan.nextInt());
            }

            elements.add("###");
            for (int i = 0; i < m; ++i) {
                elements.add(scan.next());
            }

            Iterator it = getIterator(elements);
            while (it.hasNext()) {
                Object element = it.next();
                System.out.println((String) element);
            }
        }
        scan.close();
    }

    private static Iterator getIterator(ArrayList elements) {
        Iterator it = elements.iterator();
        while (it.hasNext()) {
            Object element = it.next();
            if (element instanceof String) {
                break;
            }
        }
        return it;
    }
}
