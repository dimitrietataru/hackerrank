/**
 *              10 | JAVA STATIC INITIALIZER BLOCK
 * Domain       JAVA
 * Sub domain   INTRODUCTION
 */

// https://docs.oracle.com/javase/tutorial/java/javaOO/initial.html

import java.io.File;
import java.util.Scanner;

public class Main {
    private static File file = new File("input.txt");
    private static boolean flag = true;
    private static int Breadth;
    private static int Height;

    static {
        try {
            Scanner s = new Scanner(file);
            Breadth = s.nextInt();
            Height = s.nextInt();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static {
        try {
            if (Breadth <= 0 || Height <= 0) {
                flag = false;
                throw new Exception("Breadth and height must be positive");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        if (flag) {
            int area = Breadth * Height;
            System.out.println(area);
        }
    }
}