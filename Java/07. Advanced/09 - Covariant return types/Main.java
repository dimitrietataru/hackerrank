/**
 *              09 | COVARIANT RETURN TYPES
 * Domain       JAVA
 * Sub domain   ADVANCED
 */

// https://docs.oracle.com/javase/tutorial/java/javaOO/returnvalue.html
// https://docs.oracle.com/javase/tutorial/java/annotations/basics.html
// https://docs.oracle.com/javase/tutorial/java/IandI/override.html
// http://wiki.c2.com/?CovariantReturnTypes
// https://blogs.oracle.com/sundararajan/covariant-return-types-in-java
// https://stackoverflow.com/questions/4202252/how-does-class-forname-work

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner scan = new Scanner(file);
        {
            String input = scan.next();
            try {
                State state = (State) Class.forName(input).newInstance();
                Flower flower = state.yourNationalFlower();
                System.out.println(flower.whatsYourName());
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
                ex.printStackTrace();
            }
        }
        scan.close();
    }
}

class Flower {
    String whatsYourName() {
        return "I have many names and types";
    }
}

class Jasmine extends Flower {
    @Override
    String whatsYourName() {
        return "Jasmine";
    }
}

class Lily extends Flower {
    @Override
    String whatsYourName() {
        return "Lily";
    }
}

class Lotus extends Flower {
    @Override
    String whatsYourName() {
        return "Lotus";
    }
}

abstract class State {
    abstract Flower yourNationalFlower();
}

class WestBengal extends State {
    @Override
    Jasmine yourNationalFlower() {
        return new Jasmine();
    }
}

class Karnataka extends State {
    @Override
    Lotus yourNationalFlower() {
        return new Lotus();
    }
}

class AndhraPradesh extends State {
    @Override
    Lily yourNationalFlower() {
        return new Lily();
    }
}