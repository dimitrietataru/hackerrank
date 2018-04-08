/**
 *              12 | JAVA SORT
 * Domain       JAVA
 * Sub domain   DATA STRUCTURES
 */

// http://docs.oracle.com/javase/tutorial/collections/interfaces/order.html

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner scan = new Scanner(file);
        {
            List<Student> students = new ArrayList<>();
            int testCases = Integer.parseInt(scan.nextLine());
            while (testCases-- > 0) {
                int id = scan.nextInt();
                String name = scan.next();
                double gpa = scan.nextDouble();
                students.add(new Student(id, name, gpa));
            }

            students.sort((s1, s2) -> {
                if (s1.getGpa() > s2.getGpa()) {
                    return -1;
                } else if (s1.getGpa() < s2.getGpa()) {
                    return 1;
                }
                return s1.getName().compareTo(s2.getName());
            });

            for (Student s : students) {
                System.out.println(s.getName());
            }
        }
        scan.close();
    }
}

class Student {
    private int id;
    private String name;
    private double gpa;

    Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.gpa = cgpa;
    }

    String getName() {
        return name;
    }

    double getGpa() {
        return gpa;
    }
}
