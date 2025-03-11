package FoodOrdering;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    Scanner input = new Scanner(System.in);
    DecimalFormat d = new DecimalFormat("#0.00");

    protected int ID;
    protected String foodDesc;
    protected double foodPrice;
    protected int foodQty;

    public Menu(){

    }

    public Menu (int ID, String foodDesc, double foodPrice, int foodQty){
        this.ID = ID;
        this.foodDesc = foodDesc;
        this.foodPrice = foodPrice;
        this.foodQty = foodQty;
    }

    public void setID(int ID){
        this.ID = ID;
    }
    public int getID(){
        return ID;
    }
    public void setFoodDesc(String foodDesc){
        this.foodDesc = foodDesc;
    }
    public String getFoodDesc(){
        return foodDesc;
    }
    public void setFoodPrice(double foodPrice){
        this.foodPrice = foodPrice;
    }
    public double getFoodPrice(){
        return foodPrice;
    }
    public void setFoodQty(int foodQty){
        this.foodQty = foodQty;
    }
    public int getFoodQty(){
        return foodQty;
    }

    //display its category data
    public boolean viewData(ArrayList<Menu>AllData){
        if (AllData.size()>0){
            System.out.print ("\t\tFood ID:\t\tDescription:\t\tPrice(RM):\t\tQuantity Available:\n");
        }
        for (int i = 0; i < AllData.size(); i++){
            Menu m1 = AllData.get(i);
            System.out.print("\t\t" + m1.getID() + "\t\t\t\t" + m1.getFoodDesc()+"\t\t\t"+d.format(m1.getFoodPrice())+"\t\t\t\t"+m1.getFoodQty()+"\n");

        }
        if (AllData.size() < 0){
            return false;
        }
        return true;
    }

    //check is the ID got duplicate or not, no then add data
    public boolean checkAddData(int newID, String desc, double newPrice, int newQty, ArrayList<Menu>AllData){
        for (int i = 0; i < AllData.size(); i++){
            Menu m1 = AllData.get(i);
            if (m1.getID() == newID){
                return false;
            }

        }
        Menu m2 = new Menu(newID, desc, newPrice, newQty);
        AllData.add(m2);
        return true;
    }

    //check is the ID available or not
    public boolean checkDeleteID(int ID, ArrayList<Menu>AllData){
        for (int i = 0; i < AllData.size(); i++){
            Menu m1 = AllData.get(i);

            if (m1.getID() == ID){
                AllData.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean checkAddOrderID(int Id, int qty, ArrayList<Menu>checkData, int status){
        if (qty == 0){
            return false;
        }
        for (int i = 0; i < checkData.size(); i++){
            Menu add1 = checkData.get(i);
            if (status != 3){
                if (add1.getID() == Id && add1.getFoodQty() >= qty){
                    return true;
                }
            }
            if (status == 3){
                if (add1.getID() == Id){
                    return true;
                }
            }
        }
        return false;
    }

    public double checkPrice(int id, ArrayList<Menu>price){
        for (int i = 0; i < price.size(); i++){
            Menu p1 = price.get(i);
            if(p1.getID() == id){
                return p1.getFoodPrice();
            }
        }
        return 0.00;
    }

    public String checkDesc(int id, ArrayList<Menu>Desc){
        for (int i = 0; i < Desc.size(); i++){
            Menu desc1 = Desc.get(i);
            if (desc1.getID() == id){
                return desc1.getFoodDesc();
            }
        }
        return "null";
    }

    public void decreaseQty (int ID, int TotalQty, ArrayList<Menu>Data){
        for (int i = 0; i < Data.size(); i++){
            Menu changeQty = Data.get(i);
            if (changeQty.getID() == ID){
                int newQty = changeQty.getFoodQty() - TotalQty;
                String desc = changeQty.getFoodDesc();
                double price = changeQty.getFoodPrice();

                Menu updateQty = new Menu(ID, desc, price, newQty);
                Data.set(i, updateQty);
            }
        }
    }

    public void addQty (int ID, int qty, ArrayList<Menu>Data){

        for (int i = 0; i < Data.size(); i++){
            Menu addQty = Data.get(i);
            if (addQty.getID() == ID){
                int newQty = addQty.getFoodQty() + qty;
                String desc = addQty.getFoodDesc();
                double price = addQty.getFoodPrice();

                Menu updateQty = new Menu(ID, desc, price, newQty);
                Data.set(i, updateQty);
            }
        }
    }

}
