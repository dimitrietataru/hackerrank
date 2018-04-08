/**
 *              06 | JAVA SINGLETON PATTERN
 * Domain       JAVA
 * Sub domain   ADVANCED
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner scan = new Scanner(file);
        {
            String input = scan.nextLine();

            Singleton singleton = Singleton.getSingleInstance(input);
            Singleton singleton2 = Singleton.getSingleInstance(input);
        }
        scan.close();
    }
}

class Singleton {
    private volatile static Singleton singleton;

    private Singleton() {}

    static Singleton getSingleInstance(String input) {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    System.out.println("NULL");
                    singleton = new Singleton();
                }
            }
        }
        System.out.println(input + "\n");
        return singleton;
    }
}

/*                       "Double-checked locking" design pattern, and guarantees the following:
 * Lazy initialization  - great for resource allocation,no resources are wasted with eager initialization)
 * No race condition    - Two+ threads trying to create a singleton will fail, guaranteed by 'synchronized')
 * Acquiring a lock     - Is done only once, and there is no performance penalty (Expensive operation)
 * Volatile keyword     - Allows the singleton to be used only when it is fully instantiated  */

/*      OUTPUT:
        NULL
        hello world

        hello world
*/

class SingletonVariant {
    private SingletonVariant() {}

    public static SingletonVariant getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder {
        static final SingletonVariant INSTANCE = new SingletonVariant();
    }
}
