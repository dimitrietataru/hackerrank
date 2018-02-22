/**
 *              10 | TIME CONVERSION
 * Domain       ALGORITHMS
 * Sub domain   WARMUP
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner scan = new Scanner(file);
        String s = scan.next();
        scan.close();

        String result = timeConversion(s);
        System.out.println(result);
    }

    private static String timeConversion(String s) {
        String[] sArray = s.split(":");
        int hour = Integer.parseInt(sArray[0]);
        String format = sArray[2].substring(2, 3);

        if ("A".equals(format) && hour == 12) {
                hour = 0;
        } else if ("P".equals(format) && hour < 12) {
            hour += 12;
        }

        String sHour = (hour <= 9) ? ("0".concat(String.valueOf(hour))) : String.valueOf(hour);
        return (sHour + ":" + sArray[1] + ":" + sArray[2].substring(0, 2));
    }
}