/**
 *              10 | JAVA GENERICS
 * Domain       JAVA
 * Sub domain   DATA STRUCTURES
 */

// https://docs.oracle.com/javase/tutorial/extra/generics/methods.html

public class Main {
    public static void main(String[] args) {
        Printer myPrinter = new Printer();

        Integer[] intArray = {1, 2, 3};
        String[] stringArray = {"Hello", "World"};

        myPrinter.printArray(intArray);
        myPrinter.printArray(stringArray);
    }
}

class Printer {

    Printer() {}

    <T> void printArray(T[] a) {
        for (T obj : a) {
            System.out.println(obj + " ");
        }
    }

    /* Cheat code */
    void generalPrintArray(Object[] array) {
        for (Object object : array) {
            System.out.println(object);
        }
    }
}
