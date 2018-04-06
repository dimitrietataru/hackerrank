/**
 *              22 | ANGRY PROFESSOR
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
                int[] students = new int[scan.nextInt()];
                int threshold = scan.nextInt();
                for (int i = 0; i < students.length; ++i) {
                    students[i] = scan.nextInt();
                }
                angryProfessor(students, threshold);
            }
        }
        scan.close();
    }

    private static void angryProfessor(int[] students, int threshold) {
        int arrivedStuds = 0;
        for (int s : students) {
            arrivedStuds += (s <= 0) ? 1 : 0;
        }

        System.out.println((arrivedStuds <= threshold) ? "YES" : "NO");
    }
}
