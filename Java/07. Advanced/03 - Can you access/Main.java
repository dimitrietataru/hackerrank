/**
 *              03 | CAN YOU ACCESS?
 * Domain       JAVA
 * Sub domain   ADVANCED
 */

// http://tutorials.jenkov.com/java/nested-classes.html

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner scan = new Scanner(file);
        {
            Object o = new Inner().new Private();
            int num = scan.nextInt();

            System.out.println(num + " is " + ((Main.Inner.Private)o).powerOf2(num));
            System.out.println("An instance of class: "
                    + o.getClass().getCanonicalName() + " has been created");
        }
        scan.close();
    }

    private static class Inner {
        private class Private {
            private String powerOf2(int num) {
                return ((num & num - 1) == 0 ? "power of 2" : "not a power of 2");
            }
        }
    }
}
