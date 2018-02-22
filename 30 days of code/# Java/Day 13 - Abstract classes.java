/**
 *              ABSTRACT CLASSES | JAVA
 * Domain       30 DAYS OF CODE
 * Sub domain   DAY 13
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner scan = new Scanner(file);
        String title = scan.nextLine();
        String author = scan.nextLine();
        int price = scan.nextInt();
        scan.close();

        Book book = new MyBook(title, author, price);
        book.display();
    }
}

abstract class Book {
    String title;
    String author;

    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    abstract void display();
}

class MyBook extends Book {
    private int price;

    MyBook(String title, String author, int price) {
        super(title, author);
        this.price = price;
    }

    @Override
    void display() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: " + price);
    }
}