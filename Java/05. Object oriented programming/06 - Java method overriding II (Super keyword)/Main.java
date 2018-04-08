/**
 *              06 | JAVA METHOD OVERRIDING II (SUPER KEYWORD)
 * Domain       JAVA
 * Sub domain   OBJECT ORIENTED PROGRAMMING
 */

public class Main {
    public static void main(String[] args) {
        new Motorcycle();
    }
}

class Bicycle {
    String defineMe() {
        return "a vehicle with pedals.";
    }
}

class Motorcycle extends Bicycle {
    Motorcycle() {
        System.out.println("Hello I am a motorcycle, I am " + defineMe());
        System.out.println("My ancestor is a cycle who is " + super.defineMe());
    }

    String defineMe() {
        return "a cycle with an engine.";
    }
}
