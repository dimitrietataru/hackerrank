/**
 *              05 | JAVA FACTORY PATTERN
 * Domain       JAVA
 * Sub domain   ADVANCED
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner scan = new Scanner(file);
        {
            List<String> foods = new ArrayList<>();
            foods.add(scan.nextLine());
            foods.add(scan.nextLine());
            FoodFactory foodFactory = new FoodFactory();

            for (String s : foods) {
                Food food = foodFactory.getFood(s);
                System.out.println("The factory returned " + food.getClass());
                System.out.println(food.getType() + "\n");
            }
        }
        scan.close();
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
