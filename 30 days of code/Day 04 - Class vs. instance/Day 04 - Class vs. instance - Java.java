/**
 *              CLASS VS. INSTANCE | JAVA
 * Domain       30 DAYS OF CODE
 * Sub domain   DAY 04
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner scan = new Scanner(file);
        int testCases = scan.nextInt();
        while (testCases-- > 0) {
            int age = scan.nextInt();
            Person person = new Person(age);
            person.amIOld();
            for (int i = 0; i < 3; ++i) {
                person.yearPasses();
            }
            person.amIOld();
            System.out.println();
        }
        scan.close();
    }

}

class Person {
    private int age;

    public Person(int initialAge) {
        if (initialAge < 0) {
            System.out.println("Age is not valid, setting age to 0.");
            this.age = 0;
        } else {
            this.age = initialAge;
        }
    }

    public void amIOld() {
        if (age < 13) {
            System.out.println("You are young.");
        } else if (age < 18) {
            System.out.println("You are a teenager.");
        } else {
            System.out.println("You are old.");
        }
    }

    public void yearPasses() {
        this.age++;
    }
}