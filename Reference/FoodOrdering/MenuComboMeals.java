package FoodOrdering;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuComboMeals extends Menu{

    Scanner input = new Scanner(System.in);

    ArrayList<Menu> ComboData = new ArrayList<>();

    //pre define data
    public void defineComboData(){
        Menu comboData = new Menu (301, "Nasi Lemak + Plain Water", 2.70, 100);
        ComboData.add(comboData);
        Menu comboData2 = new Menu (302, "Nasi Goreng + Teh Tarik", 6.00, 100);
        ComboData.add(comboData2);
        Menu comboData3 = new Menu (303, "Michelin Steak + Lemon Tea", 31.00, 10);
        ComboData.add(comboData3);
    }

    public void requestViewCombo(){
        boolean flag = viewData(ComboData);
    }

    public boolean addCombo(){
        System.out.print ("\n\nEnter a new Beverage ID start from 3xx: ");
        ID = input.nextInt();

        System.out.print("\nEnter Food Description: ");
        input.nextLine();
        foodDesc = input.nextLine();
        System.out.print("\nEnter Price(RM): ");
        foodPrice = input.nextDouble();
        System.out.print ("\nEnter Quantity Available: ");
        foodQty = input.nextInt();
        if (ID < 300 || ID > 399){
            return false;
        }
        boolean flag = checkAddData(ID, foodDesc, foodPrice, foodQty, ComboData);
        return flag;

    }


    public boolean deleteCombo(){
        System.out.print("\n\nEnter the ID: ");
        ID = input.nextInt();
        boolean flag = checkDeleteID(ID, ComboData);
        return flag;
    }

    public boolean requestComboAddOrder(int Id, int qty, int status){
        boolean flag = checkAddOrderID(Id, qty, ComboData, status);
        return flag;
    }

    public double getComboPriceData(int id){
        return checkPrice(id, ComboData);
    }

    public String findComboDesc(int id){
        return checkDesc(id, ComboData);
    }

    public void updateQty(int ID, int totalQty){
        decreaseQty(ID, totalQty, ComboData);
    }

    public void increaseQty(int ID, int qty){
        addQty(ID, qty, ComboData);
    }

}
