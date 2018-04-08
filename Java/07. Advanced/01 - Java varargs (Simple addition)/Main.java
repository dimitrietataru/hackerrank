/**
 *              01 | JAVA VARARGS (SIMPLE ADDITION)
 * Domain       JAVA
 * Sub domain   ADVANCED
 */

// https://docs.oracle.com/javase/1.5.0/docs/guide/language/varargs.html

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("input.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        {
            int n1 = Integer.parseInt(br.readLine());
            int n2 = Integer.parseInt(br.readLine());
            int n3 = Integer.parseInt(br.readLine());
            int n4 = Integer.parseInt(br.readLine());
            int n5 = Integer.parseInt(br.readLine());
            int n6 = Integer.parseInt(br.readLine());

            Add add = new Add();
            add.add(n1, n2);
            add.add(n1, n2, n3);
            add.add(n1, n2, n3, n4, n5);
            add.add(n1, n2, n3, n4, n5, n6);
        }
        br.close();
    }
}

class Add {
    void add(int... arg) {
        int sum = 0;
        String separator = "";

        for (int i : arg) {
            sum += i;
            System.out.print(separator + i);
            separator = "+";
        }

        System.out.println("=" + sum);
    }
}
