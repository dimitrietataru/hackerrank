/**
 *              03 | JAVA ABSTRACT CLASS
 * Domain       JAVA
 * Sub domain   OBJECT ORIENTED PROGRAMMING
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner scan = new Scanner(file);
        String title = scan.nextLine();
        scan.close();

        MyBook myBook = new MyBook();
        myBook.setTitle(title);

        System.out.println("The title is: " + myBook.getTitle());
    }
}

abstract class Book {
    String title;

    abstract void setTitle(String s);

    String getTitle() {
        return title;
    }
}

class MyBook extends Book {
    @Override
    void setTitle(String s) {
        super.title = s;
    }
}