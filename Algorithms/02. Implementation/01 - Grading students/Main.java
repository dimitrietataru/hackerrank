/**
 *              01 | GRADING STUDENTS
 * Domain       ALGORITHMS
 * Sub domain   IMPLEMENTATION
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner scan = new Scanner(file);
        {
            int testCases = scan.nextInt();
            while (testCases-- > 0) {
                int grade = scan.nextInt();
                System.out.println(gradingStudents(grade));
            }
        }
        scan.close();
    }

    private static int gradingStudents(int grade) {
        if ((grade % 5 <= 2) || (grade < 38)) {
            return grade;
        }
        //return grade / 5 * 5 + 5;
        return grade + (5 - grade % 5);
    }
}
