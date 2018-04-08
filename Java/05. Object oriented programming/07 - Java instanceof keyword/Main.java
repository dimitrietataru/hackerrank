/**
 *              07 | JAVA INSTANCEOF KEYWORD
 * Domain       JAVA
 * Sub domain   OBJECT ORIENTED PROGRAMMING
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner scan = new Scanner(file);
        {
            ArrayList<Object> object = new ArrayList<>();

            int instances = scan.nextInt();
            while (instances-- > 0) {
                String type = scan.next();
                switch (type) {
                    case "Student":
                        object.add(new Student());
                        break;
                    case "Rockstar":
                        object.add(new Rockstar());
                        break;
                    case "Hacker":
                        object.add(new Hacker());
                        break;
                    default: break;
                }
            }
            System.out.println(countInstances(object));
        }
        scan.close();
    }

    @SuppressWarnings("unchecked")
    private static String countInstances(ArrayList<Object> objects) {
        int a = 0;
        int b = 0;
        int c = 0;

        for (Object object : objects) {
            if (object instanceof Student) {
                a++;
            }
            if (object instanceof Rockstar) {
                b++;
            }
            if (object instanceof Hacker) {
                c++;
            }
        }
        return (a + " " + b + " " + c);
    }
}

class Student {}

class Rockstar {}

class Hacker {}
