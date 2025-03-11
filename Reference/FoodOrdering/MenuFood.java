package FoodOrdering;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuFood extends Menu{
    Scanner input = new Scanner(System.in);

    ArrayList<Menu>FoodData = new ArrayList<>();

    //pre define data
    public void defineFoodData(){
        Menu foodData = new Menu (101, "Nasi Lemak", 2.50, 10);
        FoodData.add(foodData);
        Menu foodData2 = new Menu (102, "Nasi Goreng", 4.50, 100);
        FoodData.add(foodData2);
        Menu foodData3 = new Menu (103, "Michelin Steak", 30.50, 10);
        FoodData.add(foodData3);
    }

    public void requestViewFood(){
        boolean flag = viewData(FoodData);
        if(flag == false){
            System.out.print ("\n\n\nNo data found\n\n");
        }
    }

    public boolean addFood(){
        System.out.print ("\n\nEnter a new Food ID start from 1xx: ");
        ID = input.nextInt();
        System.out.print("\nEnter Food Description: ");
        input.nextLine();
        foodDesc = input.nextLine();
        System.out.print("\nEnter Price(RM): ");
        foodPrice = input.nextDouble();
        System.out.print ("\nEnter Quantity Available: ");
        foodQty = input.nextInt();
        if (ID < 100 || ID > 199){
            return false;
        }
        boolean flag = checkAddData(ID, foodDesc, foodPrice, foodQty, FoodData);
        return flag;

    }


    public boolean deleteFood(){
        System.out.print("\n\nEnter the ID: ");
        ID = input.nextInt();
        boolean flag = checkDeleteID(ID, FoodData);
        return flag;
    }

    public boolean requestFoodAddOrder(int Id, int qty, int status){
        boolean flag = checkAddOrderID(Id, qty, FoodData, status);
        return flag;
    }

    public double getFoodPriceData(int id){
        return checkPrice(id, FoodData);
    }

    public String findFoodDesc(int id){
        return checkDesc(id, FoodData);
    }

    public void updateQty(int ID, int totalQty){
        decreaseQty(ID, totalQty, FoodData);
    }

    public void increaseQty(int ID, int qty){
        addQty(ID, qty, FoodData);
    }


}
