/**
 *              12 | JAVA DATE AND TIME
 * Domain       JAVA
 * Sub domain   INTRODUCTION
 */

// https://docs.oracle.com/javase/7/docs/api/java/util/Calendar.html

import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import java.io.File;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        String[] DAYS = {"SUNDAY", "MONDAY","TUESDAY", "WEDNESDAY", "THURSDAY","FRIDAY","SATURDAY"};
        File file = new File("input.txt");
        Scanner scan = new Scanner(file);
        {
            int month = scan.nextInt();
            int day = scan.nextInt();
            int year = scan.nextInt();

            /* Using LocalDate */
            LocalDate localDate = LocalDate.of(year, month, day);
            System.out.println(localDate.getDayOfWeek());

            /* Using Calendar */
            Calendar calendar = Calendar.getInstance();
            calendar.set(year, month - 1, day);
            System.out.println(calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.US)
                    .toUpperCase());

            /* Using GregorianCalendar */
            Date date = (new GregorianCalendar(year, month - 1, day)).getTime();
            SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
            String result = sdf.format(date).toUpperCase();
            System.out.println(result);

            /* Zeller's congruence */
            int dd = day;
            int mm = month;
            int yy = year;
            dd += ((mm < 3) ? yy-- : (yy - 2));
            int finalDay = ((((23 * mm) / 9) + dd + 4 + (yy / 4)) - (yy / 100) + (yy / 400)) % 7;
            System.out.println(DAYS[finalDay]);

            /* HackerRank method */
            int a = ((14 - month) / 12);
            int yyy = (year - a);
            int mmm = (month + (12 * a) - 2);
            int ddd = ((day + yyy + (yyy / 4) - (yyy / 100) + (yyy / 400) + ((31 * mmm) / 12)) % 7);
            System.out.println(DAYS[ddd]);
        }
        scan.close();
    }
}
