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
        Priorities priorities = new Priorities();
        List<String> events = new ArrayList<>();
        File file = new File("input.txt");
        Scanner scan = new Scanner(file);
        int totalEvents = scan.nextInt();
        scan.nextLine();
        while (totalEvents-- > 0) {
            String event = scan.nextLine();
            events.add(event);
        }
        scan.close();

        List<Student> studentList = priorities.getStudents(events);
        if (studentList.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student student : studentList) {
                System.out.println(student.getName());
            }
        }
    }
}

class Student {
    private int id;
    private String name;
    private double gpa;

    Student(int id, String name, double gpa) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
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
    Priorities() {}

    List<Student> getStudents(List<String> events) {
        List<Student> bufferList = new ArrayList<>();

        for (int i = 0; i < events.size(); ++i) {
            String[] eventArray = events.get(i).split(" ");
            String action = eventArray[0];

            switch (action) {
                case "ENTER":
                    String name = eventArray[1];
                    double gpa = Double.parseDouble(eventArray[2]);
                    int id = Integer.parseInt(eventArray[3]);
                    bufferList.add(new Student(id, name, gpa));
                    break;
                case "SERVED":
                    bufferList.sort(Comparator.comparing(Student::getGpa).reversed()
                                              .thenComparing(Student::getName)
                                              .thenComparing(Student::getId));
                    if (!bufferList.isEmpty()) {
                        bufferList.remove(0);
                    }
                    break;
                default:
                    break;
            }
        }
        return bufferList;
    }
}