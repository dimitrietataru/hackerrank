/**
 *              01 | JAVA EXCEPTION HANDLING (TRY-CATCH)
 * Domain       JAVA
 * Sub domain   EXCEPTION HANDLING
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File file = new File("input.txt");
        try {
            Scanner scan = new Scanner(file);
            int x = scan.nextInt();
            int y = scan.nextInt();
            scan.close();

            System.out.println(x / y);
        } catch (FileNotFoundException fnf) {
            System.out.println(fnf.toString() + " " + file.toString());
        } catch (ArithmeticException ae) {
            System.out.println(ae.toString());
        } catch (InputMismatchException ime) {
            System.out.println(ime.getClass().getName());
        }
    }
}
