
import java.util.Scanner;

public class Menu {
    Scanner input = new Scanner(System.in);

    protected String itemId;
    protected String itemName;
    protected double itemPrice;
    protected int itemQty;

    public Menu()
    {

    }

    public Menu (String itemId, String itemName, double itemPrice , int itemQty )
    {
        // this.itemId = itemId;
        // this.itemName = itemName;
        // this.itemId = itemPrice;
        // this.itemId = itemQty;

    }

    public void setMenu(String itemId, String itemName, double itemPrice , int itemQty )
    {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemQty = itemQty;
    }

    

}







