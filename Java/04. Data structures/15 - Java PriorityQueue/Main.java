/**
 *              15 | JAVA PRIORITY QUEUE
 * Domain       JAVA
 * Sub domain   DATA STRUCTURES
 */

// https://docs.oracle.com/javase/7/docs/api/java/util/PriorityQueue.html

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("input.txt");
        Scanner scan = new Scanner(file);
        {
            Priorities priorities = new Priorities();
            List<String> actions = new ArrayList<>();

            int n = Integer.parseInt(scan.nextLine());
            while (n-- > 0) {
                String event = scan.nextLine();
                actions.add(event);
            }

            List<Student> students = priorities.getStudents(actions);
            if (students.isEmpty()) {
                System.out.println("EMPTY");
            } else {
                for (Student student : students) {
                    System.out.println(student.getName());
                }
            }
        }
        scan.close();
    }
}

class Student {
    private String name;
    private double gpa;
    private int id;

    Student(String name, double gpa, int id) {
        this.name = name;
        this.gpa = gpa;
        this.id = id;
    }

    int getId() {
        return id;
    }

    String getName() {
        return name;
    }

    double getGpa() {
        return gpa;
    }
}

class Priorities {
    List<Student> getStudents(List<String> actions) {
        List<Student> result = new ArrayList<>();

        actions.forEach(action -> {
            String[] events = action.split(" ");
            switch (events[0]) {
                case "ENTER":
                    String name = events[1];
                    double gpa = Double.parseDouble(events[2]);
                    int id = Integer.parseInt(events[3]);
                    result.add(new Student(name, gpa, id));
                    break;
                case "SERVED":
                    result.sort(Comparator.comparing(Student::getGpa).reversed()
                            .thenComparing(Student::getName)
                            .thenComparing(Student::getId));
                    if (!result.isEmpty()) {
                        result.remove(0);
                    }
                    break;
                default:
                    break;
            }
        });

        return result;
    }
}
