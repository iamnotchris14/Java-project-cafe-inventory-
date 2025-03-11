package FoodOrdering;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuBeverage extends Menu{

    Scanner input = new Scanner(System.in);

    ArrayList<Menu> BeverageData = new ArrayList<>();

    //pre define data
    public void defineBeverageData(){
        Menu beverageData = new Menu (201, "Plain Water", 0.50, 1000);
        BeverageData.add(beverageData);
        Menu beverageData2 = new Menu (202, "Lemon Tea", 2.50, 1000);
        BeverageData.add(beverageData2);
        Menu beverageData3 = new Menu (203, "Teh Tarik", 2.30, 1000);
        BeverageData.add(beverageData3);
    }

    public void requestViewBeverage(){
        boolean flag = viewData(BeverageData);
    }


    public boolean addBeverage(){
        System.out.print ("\n\nEnter a new Beverage ID start from 2xx: ");
        ID = input.nextInt();

        System.out.print("\nEnter Food Description: ");
        input.nextLine();
        foodDesc = input.nextLine();
        System.out.print("\nEnter Price(RM): ");
        foodPrice = input.nextDouble();
        System.out.print ("\nEnter Quantity Available: ");
        foodQty = input.nextInt();
        if (ID < 200 || ID > 299){
            return false;
        }

        boolean flag = checkAddData(ID, foodDesc, foodPrice, foodQty, BeverageData);
        return flag;

    }

    public boolean deleteBeverage(){
        System.out.print("\n\nEnter the ID: ");
        ID = input.nextInt();
        boolean flag = checkDeleteID(ID, BeverageData);
        return flag;
    }

    public boolean requestBeverageAddOrder(int Id, int qty, int status){
        boolean flag = checkAddOrderID(Id, qty, BeverageData, status);
        return flag;
    }

    public double getBeveragePriceData(int id){
        return checkPrice(id, BeverageData);
    }

    public String findBeverageDesc(int id){
        return checkDesc(id, BeverageData);
    }

    public void updateQty(int ID, int totalQty){
        decreaseQty(ID, totalQty, BeverageData);
    }

    public void increaseQty(int ID, int qty){
        addQty(ID, qty, BeverageData);
    }

}
