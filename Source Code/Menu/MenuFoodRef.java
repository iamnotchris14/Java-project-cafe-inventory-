package JavaProjectCafeInventory;
import java.util.Scanner;

public class MenuFood extends Menu {
    Scanner input = new Scanner(System.in);

    // Individual food items
    private Menu food1, food2, food3;

    // Constructor to initialize food items
    public MenuFood() {
        food1 = new Menu(101, "Chicken Chop", 12.50, 10);
        food2 = new Menu(102, "Carbonara", 15.50, 100);
        food3 = new Menu(103, "Steak", 35.50, 10);
    }

    // Method to display all food items
    public void requestViewFood() {
        System.out.println("\nFood Menu:");
        displayFood(food1);
        displayFood(food2);
        displayFood(food3);
    }

    private void displayFood(Menu food) {
        if (food != null) {
            System.out.println("ID: " + food.getID() + " | " + food.getFoodDesc() + 
                               " | Price: RM" + food.getFoodPrice() + 
                               " | Quantity: " + food.getFoodQty());
        }
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

    // Get food price
    public double getFoodPriceData(int id) {
        Menu food = getFoodById(id);
        return (food != null) ? food.getFoodPrice() : -1;
    }

    // Get food description
    public String findFoodDesc(int id) {
        Menu food = getFoodById(id);
        return (food != null) ? food.getFoodDesc() : "Food not found.";
    }
}
