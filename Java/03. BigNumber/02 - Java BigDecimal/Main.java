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
        int n = scan.nextInt();

        String[] s = new String[n+2];
        for (int i = 0; i < n; ++i) {
            s[i] = scan.next();
        }
        scan.close();

        //Arrays.sort(s, 0, n, Collections.reverseOrder(Comparator.comparing(BigDecimal::new)));
        Arrays.sort(s, 0, n, Collections.reverseOrder(
                new Comparator<String>() {
                    @Override
                    public int compare(String str1, String str2) {
                        /* Convert to BigDecimal inside comparator => string values are never changed */
                        /* You only use the BigDecimal values to compare the strings */
                        BigDecimal bigDecimal1 = new BigDecimal(str1);
                        BigDecimal bigDecimal2 = new BigDecimal(str2);
                        return bigDecimal1.compareTo(bigDecimal2);
                    }
                }
        ));

        for (int i = 0; i < n; ++i) {
            System.out.println(s[i]);
        }
    }
}