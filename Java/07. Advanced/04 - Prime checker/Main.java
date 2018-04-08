/**
 *              04 | PRIME CHECKER
 * Domain       JAVA
 * Sub domain   ADVANCED
 */

// https://en.wikipedia.org/wiki/Prime_number

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

            Prime prime = new Prime();
            prime.check(n1);
            prime.check(n1, n2);
            prime.check(n1, n2, n3);
            prime.check(n1, n2, n3, n4, n5);
        }
        br.close();
    }
}

class Prime {
    void check(int... args) {
        for (int i : args) {
            if (isPrime(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println("");
    }

    private boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }

        if (n == 2 || n == 3) {
            return true;
        }

        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }

        for (int i = 5, w = 2; (i * i) <= n; i += w, w = 6 - w) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}
