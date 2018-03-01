/**
 *              04 | PRIME CHECKER
 * Domain       JAVA
 * Sub domain   ADVANCED
 */

// https://en.wikipedia.org/wiki/Prime_number

import java.io.*;
import static java.lang.System.*;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("input.txt");

            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            int n1 = Integer.parseInt(bufferedReader.readLine());
            int n2 = Integer.parseInt(bufferedReader.readLine());
            int n3 = Integer.parseInt(bufferedReader.readLine());
            int n4 = Integer.parseInt(bufferedReader.readLine());
            int n5 = Integer.parseInt(bufferedReader.readLine());
            bufferedReader.close();

            Prime prime = new Prime();
            prime.checkPrime(n1);
            prime.checkPrime(n1, n2);
            prime.checkPrime(n1, n2, n3);
            prime.checkPrime(n1, n2, n3, n4, n5);
    }
}

class Prime {
    public void checkPrime(int... args) {
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