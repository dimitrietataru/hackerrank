/**
 *              07 | JAVA MAP
 * Domain       JAVA
 * Sub domain   DATA STRUCTURES
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        HashMap<String, Integer> hashMap = new HashMap<>();
        File file = new File("input.txt");
        Scanner scan = new Scanner(file);
        {
            int entries = Integer.parseInt(scan.nextLine());
            while (entries-- > 0) {
                String name = scan.nextLine();
                int phone = Integer.parseInt(scan.nextLine());
                hashMap.put(name, phone);
            }
            
            while (scan.hasNext()) {
                String test = scan.nextLine();
                if (!hashMap.containsKey(test)) {
                    System.out.println("Not found");
                } else {
                    System.out.println(test + "=" + hashMap.get(test));
                }
            }
        }
        scan.close();
    }
}
