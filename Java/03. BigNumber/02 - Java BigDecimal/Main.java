/**
 *              02 | JAVA BIG DECIMAL
 * Domain       JAVA
 * Sub domain   BIG NUMBER
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner scan = new Scanner(file);
        {
            String[] strArray = new String[scan.nextInt()];
            for (int i = 0; i < strArray.length; ++i) {
                strArray[i] = scan.next();
            }

//          Arrays.sort(strArray, 0, strArray.length,
//              Collections.reverseOrder(Comparator.comparing(BigDecimal::new)));

            Arrays.sort(strArray, 0, strArray.length, Collections.reverseOrder((s1, s2) -> {
                /* Convert to BigDecimal inside comparator => string values are never changed */
                /* You only use the BigDecimal values to compare the strings */
                BigDecimal bigDecimal1 = new BigDecimal(s1);
                BigDecimal bigDecimal2 = new BigDecimal(s2);
                return bigDecimal1.compareTo(bigDecimal2);
            }));

            for (String str : strArray) {
                System.out.println(str);
            }
        }
        scan.close();
    }
}
