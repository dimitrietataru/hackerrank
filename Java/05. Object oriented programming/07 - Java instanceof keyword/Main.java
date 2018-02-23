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
        ArrayList<Object> arrayList = new ArrayList<>();
        File file = new File("input.txt");
        Scanner scan = new Scanner(file);
        int n = scan.nextInt();
        for (int i = 0; i < n; ++i) {
            String input = scan.next();
            if (input.equals("Student")) {
                arrayList.add(new Student());
            }
            if (input.equals("Rockstar")) {
                arrayList.add(new Rockstar());
            }
            if (input.equals("Hacker")) {
                arrayList.add(new Hacker());
            }
        }
        scan.close();
        System.out.println(count(arrayList));
    }

    @SuppressWarnings("unchecked")
    private static String count(ArrayList<Object> arrayList) {
        int a = 0;
        int b = 0;
        int c = 0;

        for (int i = 0; i < arrayList.size(); ++i) {
            Object object = arrayList.get(i);
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