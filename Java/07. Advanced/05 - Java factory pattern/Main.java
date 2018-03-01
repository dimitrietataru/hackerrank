/**
 *              05 | JAVA FACTORY PATTERN
 * Domain       JAVA
 * Sub domain   ADVANCED
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        String[] foodInput = new String[2];
        File file = new File("input.txt");
        Scanner scan = new Scanner(file);
        foodInput[0] = scan.nextLine();
        foodInput[1] = scan.nextLine();
        scan.close();

        FoodFactory foodFactory = new FoodFactory();

        for (String s : foodInput) {
            Food food = foodFactory.getFood(s);
            System.out.println("The factory returned " + food.getClass());
            System.out.println(food.getType() + "\n");
        }
    }
}

interface Food {
    String getType();
}

class Pizza implements Food {
    public String getType() {
        return "Someone ordered a Fast Food!";
    }
}

class Cake implements Food {
    public String getType() {
        return "Someone ordered a Dessert!";
    }
}

class FoodFactory {
    Food getFood(String order) {
        switch (order.toLowerCase()) {
            case "cake":
                return new Cake();
            case "pizza":
                return new Pizza();
            default:
                return null;
        }
    }
}