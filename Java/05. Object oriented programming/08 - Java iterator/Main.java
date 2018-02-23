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
        ArrayList<Object> arrayList = new ArrayList<>();
        File file = new File("input.txt");
        Scanner scan = new Scanner(file);
        int n = scan.nextInt();
        int m = scan.nextInt();

        for (int i = 0; i < n; ++i) {
            arrayList.add(scan.nextInt());
        }

        arrayList.add("###");
        for (int i = 0; i < m; ++i) {
            arrayList.add(scan.next());
        }
        scan.close();

        Iterator iterator = getIterator(arrayList);
        while (iterator.hasNext()) {
            Object element = iterator.next();
            System.out.println((String) element);
        }
    }

    private static Iterator getIterator(ArrayList arrayList) {
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            Object object = iterator.next();
            if (object instanceof String) {
                break;
            }
        }
        return iterator;
    }
}