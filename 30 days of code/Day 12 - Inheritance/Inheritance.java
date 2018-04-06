/**
 *              INHERITANCE | JAVA
 * Domain       30 DAYS OF CODE
 * Sub domain   DAY 12
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner scan = new Scanner(file);
        {
            String firstName = scan.next();
            String lastName = scan.next();
            int id = scan.nextInt();
            int[] testScores = new int[scan.nextInt()];
            for (int i = 0; i < testScores.length; ++i) {
                testScores[i] = scan.nextInt();
            }
            Student student = new Student(firstName, lastName, id, testScores);
            student.printPerson();
            System.out.println("Grade: " + student.calculate());
        }
        scan.close();
    }
}

class Person {
    private String firstName, lastName;
    private int id;

    Person(String firstName, String lastName, int id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }

    void printPerson() {
        System.out.println("Name: " + lastName + ", " + firstName + "\nID: " + id);
    }
}

class Student extends Person {
    private int[] testScores;

    Student(String firstName, String lastName, int id, int[] testScores) {
        super(firstName, lastName, id);
        this.testScores = testScores;
    }

    char calculate() {
        int total = IntStream.of(testScores).sum();// 0;
        int mean = total / testScores.length;
        if (mean >= 90 && mean <= 100) {
            return 'O';
        } else if (mean >= 80) {
            return 'E';
        } else if (mean >= 70) {
            return 'A';
        } else if (mean >= 55) {
            return 'P';
        } else if (mean >= 40) {
            return 'D';
        } else {
            return 'T';
        }
    }
}
