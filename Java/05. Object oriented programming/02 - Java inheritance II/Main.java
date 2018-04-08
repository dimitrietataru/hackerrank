/**
 *              02 | JAVA INHERITANCE II
 * Domain       JAVA
 * Sub domain   OBJECT ORIENTED PROGRAMMING
 */

public class Main {
    public static void main(String[] args) {
        Adder adder = new Adder();

        System.out.println("My superclass is: " + adder.getClass().getSuperclass().getName());

        System.out.print(adder.add(10, 32) + " ");
        System.out.print(adder.add(11, 12) + " ");
        System.out.print(adder.add(10, 10) + "\n");
    }
}

class Arithmetic {
    int add(int i1, int i2) {
        return i1 + i2;
    }
}

class Adder extends Arithmetic {
    Adder() {}
}
