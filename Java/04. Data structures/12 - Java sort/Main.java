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
        List<Student> studentList = new ArrayList<>();
        File file = new File("input.txt");
        Scanner scan = new Scanner(file);
        int testCases = Integer.parseInt(scan.nextLine());
        while (testCases-- > 0) {
            int id = scan.nextInt();
            String name = scan.next();
            double gpa = scan.nextDouble();
            Student student = new Student(id, name, gpa);
            studentList.add(student);
        }
        scan.close();
        studentList.sort(new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                if (s1.getCgpa() > s2.getCgpa()) {
                    return -1;
                } else if (s1.getCgpa() < s2.getCgpa()) {
                    return 1;
                }
                return s1.getFname().compareTo(s2.getFname());
            }
        });

        for (Student student : studentList) {
            System.out.println(student.getFname());
        }
    }
}

class Student {
    private int id;
    private String fname;
    private double cgpa;

    Student(int id, String fname, double cgpa) {
        this.id = id;
        this.fname = fname;
        this.cgpa = cgpa;
    }

    String getFname() {
        return fname;
    }

    double getCgpa() {
        return cgpa;
    }
}