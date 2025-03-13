import java.util.ArrayList;
import java.util.Scanner;

public class MenuFood extends Menu {
    Scanner input = new Scanner(System.in);
    private Menu food1;
    private Menu food2;
    private Menu food3;

    public void defFoodData() {
        food1 = new Menu(101, "Chicken Chop", 12.50, 10);
        food2 = new Menu(102, "Carbonara", 15.50, 100);
        food3 = new Menu(103, "Steak", 35.50, 10);
    }
   
    // Method to find a food item by ID
   private Menu getFoodById(int id) {
    switch (id) {
        case 101: return food1;
        case 102: return food2;
        case 103: return food3;
        default: return null;
    }
}
    // Add food quantity
    public void increaseQty(int id, int qty) {
        Menu food = getFoodById(id);
        if (food != null) {
            food.setFoodQty(food.getFoodQty() + qty);
            System.out.println("Quantity updated!");
        } else {
            System.out.println("Invalid food ID.");
        }
    }

    // Decrease food quantity
    public void updateQty(int id, int qty) {
        Menu food = getFoodById(id);
        if (food != null && food.getFoodQty() >= qty) {
            food.setFoodQty(food.getFoodQty() - qty);
            System.out.println("Quantity decreased.");
        } else {
            System.out.println("Not enough stock or invalid ID.");
        }
    }

}