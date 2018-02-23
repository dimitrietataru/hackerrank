/**
 *              02 | JAVA INHERITANCE II
 * Domain       JAVA
 * Sub domain   OBJECT ORIENTED PROGRAMMING
 */

public class Main {
    public static void main(String[] args) {

        /* Create a new adder class */
        Adder adder = new Adder();

        /* Print the name of the superclass on a new line */
        System.out.println("My superclass is: " + adder.getClass().getSuperclass().getName());

        /* Print the result of 3 calls to Adder's add method */
        System.out.println(adder.add(10, 32) + " " + adder.add(10, 3) + " " + adder.add(10, 10) + "\n");
    }
}

class Arithmetic {
    public int add(int i1, int i2) {
        return i1 + i2;
    }
}

class Adder extends Arithmetic {
    public Adder() {}
}