package FoodOrdering;

import java.util.Scanner;

public class Display {
    Scanner input = new Scanner(System.in);
    LoginUser lUser = new LoginUser();
    LoginManagement lManage = new LoginManagement();
    MenuFood mFood = new MenuFood();
    MenuBeverage mBeverage = new MenuBeverage();
    MenuComboMeals mCombo = new MenuComboMeals();
    Order o1 = new Order();


    //main interface start from here
    public void mainInterface (){
        lUser.data(); // add pre define data
        lManage.data(); // add pre define data
        lUser.balanceData(); // add pre define data
        mFood.defineFoodData(); // add pre define data
        mBeverage.defineBeverageData(); // add pre define data
        mCombo.defineComboData(); //add pre define data


        while (true) {

            System.out.print("\n\n\n\t\tWelcome to UoW Malaysia Cafeteria\n\n");
            System.out.print("================================================\n");
            System.out.print("*                                              *\n");
            System.out.print("*          1. Continue as Guest                *\n");
            System.out.print("*          2. Continue as User                 *\n");
            System.out.print("*          3. Continue as Management           *\n");
            System.out.print("*          0. Exit                             *\n");
            System.out.print("*                                              *\n");
            System.out.print("================================================\n");
            System.out.print("\n\n\t\tPlease enter your selection: ");
            int selection1 = input.nextInt();
            switch (selection1) {
                case 1:
                        userMenu(selection1, "Guest");
                        break;
                case 2:
                    boolean flag2 = lUser.showLoginUser();
                    if (flag2 == true) {
                        System.out.print("\n\n\nLogin Successful\n\n\n");
                        String disName = lUser.displayUsername();
                        userMenu(selection1, disName);
                        break;

                    } else {
                        System.out.print("\n\n\nInvalid username or password. Try again.\nPress enter to continue...");
                        input.nextLine();
                        String clear = input.nextLine();
                        System.out.print("\n\n\n\n\n");
                        break;
                    }
                case 3:

                    boolean flag3 = lManage.showLoginManagement();
                    if (flag3 == true) {
                        System.out.print("\n\n\nLogin Successful\n\n\n");
                        String disName = lManage.displayUsername();
                        managementInterface(disName);
                        break;
                    }
                    else {
                        System.out.print("\n\n\nInvalid username or password. Try again.\nPress enter to continue...");
                        input.nextLine();
                        String clear = input.nextLine();
                        System.out.print("\n\n\n\n\n");
                        break;
                    }
                case 0:
                    System.out.print("\n\n\t\tThank you for your using");
                    return;

                default:
                    System.out.print("Error selection please try again. Please enter to continue...");
                    input.nextLine();
                    String clear = input.nextLine();
                    System.out.print("\n\n\n\n\n");
                    break;
            }
        }

    }


    // management Interface
    public void managementInterface(String disName) {

        while (true) {
            System.out.print("\n\n\n\t\tWelcome " + disName +"\n\n");
            System.out.print("================================================\n");
            System.out.print("*                                              *\n");
            System.out.print("*          1. Manage Menu                      *\n");
            System.out.print("*          2. Manage User                      *\n");
            System.out.print("*          3. View sales                       *\n");
            System.out.print("*          4. View order                       *\n");
            System.out.print("*          5. Cash Payment                     *\n");
            System.out.print("*          6. View reservation                 *\n");
            System.out.print("*          0. Exit                             *\n");
            System.out.print("*                                              *\n");
            System.out.print("================================================\n");
            System.out.print("\n\n\t\tPlease enter your selection: ");
            int selection3 = input.nextInt();
            switch (selection3) {
                case 1:
                    manageMenu();
                    break;
                case 2:
                    manageUser();
                    break;
                case 3:
                    viewSalesInterface();
                    break;
                case 4:
                    boolean flagViewOrder = o1.viewOrderDetail();
                    if (flagViewOrder == false){
                        System.out.print("\n\n\t\tNo order data");

                    }

                    if (flagViewOrder == true){
                        boolean flagCall = false;
                        while (flagCall == false) {
                            System.out.print("\n\n\t\tEnter Completed Order Number");
                            System.out.print("\n\t\t0. to Exit ");
                            System.out.print("\n\t\tYour selection: ");
                            int completeOrder = input.nextInt();
                            if (completeOrder != 0){
                                flagCall = o1.callOrder(completeOrder);
                            }
                            else{
                                flagCall = true;
                            }

                        }
                    }

                    break;
                case 5:
                    boolean flagPayment = o1.viewCahPayment();
                    if (flagPayment == true){
                        o1.cashPayment();
                    }
                    if (flagPayment == false){
                        System.out.print("\n\n\t\tNo Pending Cash Payment Data");
                    }
                    break;
                case 6:
                    boolean reservationData = o1.managementViewReservation();
                    if (reservationData == false){
                        System.out.print("\n\n\t\tNo reservation data");
                    }
                    break;
                case 0:
                    //System.out.print("\n\n\t\tThank you for your using");
                    return;
                default:
                    System.out.print("Error selection please try again. Please enter to continue...");
                    input.nextLine();
                    String clear = input.nextLine();
                    System.out.print("\n\n\n\n\n");
                    break;
            }
        }
    }

    public void manageMenu(){
        while (true){
            System.out.print("\n\n\n");
            System.out.print("================================================\n");
            System.out.print("*                                              *\n");
            System.out.print("*          1. Food                             *\n");
            System.out.print("*          2. Beverage                         *\n");
            System.out.print("*          3. Combo Meal                       *\n");
            System.out.print("*          0. Exit                             *\n");
            System.out.print("*                                              *\n");
            System.out.print("================================================\n");
            System.out.print("\n\n\t\tPlease enter your selection: ");
            int selection6 = input.nextInt();
            switch (selection6){
                case 1:
                    mFood.requestViewFood();
                    addDeleteMenu(selection6);
                    break;
                case 2:
                    mBeverage.requestViewBeverage();
                    addDeleteMenu(selection6);
                    break;
                case 3:
                    mCombo.requestViewCombo();
                    addDeleteMenu(selection6);
                    break;
                case 0:
                    return;
                default:
                    System.out.print("Error selection please try again. Please enter to continue...");
                    input.nextLine();
                    String clear = input.nextLine();
                    System.out.print("\n\n\n\n\n");
                    break;
            }
        }
    }

    public void addDeleteMenu(int categorySelect){
        System.out.print("\n\n1. Add menu");
        System.out.print("\n2. Delete menu");
        System.out.print("\n0. Exit");
        System.out.print("\n\n\t\tPlease enter your selection: ");
        int selection7 = input.nextInt();
        switch (selection7){
            case 1:
                if (categorySelect == 1){
                    boolean flag = mFood.addFood();
                    if (flag == false){
                        System.out.print("\n\n\t\tDuplicate ID or Invalid ID\n\n\n");
                        return;
                    }
                    else {
                        System.out.print ("\n\n\t\tAdd menu successfully\n\n\n");
                        return;
                    }
                }
                if (categorySelect == 2){
                    boolean flag = mBeverage.addBeverage();
                    if (flag == false){
                        System.out.print("\n\n\t\tDuplicate ID or Invalid ID\n\n\n");
                        return;
                    }
                    else {
                        System.out.print ("\n\n\t\tAdd menu successfully\n\n\n");
                        return;
                    }
                }
                if (categorySelect == 3){
                    boolean flag = mCombo.addCombo();
                    if (flag == false){
                        System.out.print("\n\n\t\tDuplicate ID or Invalid ID\n\n\n");
                        return;
                    }
                    else {
                        System.out.print ("\n\n\t\tAdd menu successfully\n\n\n");
                        return;
                    }
                }
            case 2:
                if (categorySelect == 1){
                    boolean flag = mFood.deleteFood();
                    if (flag == false){
                        System.out.print("\n\n\t\tUnavailable ID");
                        return;
                    }
                    else {
                        System.out.print("\n\n\t\tDelete Food successfully");
                        return;
                    }

                }
                if (categorySelect == 2) {
                    boolean flag = mBeverage.deleteBeverage();
                    if (flag == false) {
                        System.out.print("\n\n\t\tUnavailable ID\n");
                        return;
                    } else {
                        System.out.print("\n\n\t\tDelete Food successfully\n");
                        return;
                    }
                }
                if (categorySelect == 3) {
                    boolean flag = mCombo.deleteCombo();
                    if (flag == false) {
                        System.out.print("\n\n\t\tUnavailable ID\n");
                        return;
                    } else {
                        System.out.print("\n\n\t\tDelete Food successfully\n");
                        return;
                    }
                }
            case 0:
                return;
            default:
                System.out.print("Error selection please try again. Please enter to continue...");
                input.nextLine();
                String clear = input.nextLine();
                System.out.print("\n\n\n\n\n");
                return;
        }
    }

    //manage user interface
    public void manageUser() {

        while (true) {

            lUser.requestView();
            System.out.print("\n\n\t\t1. add user");
            System.out.print("\n\t\t2. delete user");
            System.out.print("\n\t\t3. topup account");
            System.out.print("\n\t\t0. exit");
            System.out.print("\n\n\t\tPlease enter your selection: ");
            int selection4 = input.nextInt();
            switch (selection4) {
                case 1:
                    boolean flag = lUser.addUser();
                    if (flag == true){
                        System.out.print ("\n\n\t\tAdd user successfully");
                        break;
                    }
                    else {
                        System.out.print ("\n\n\t\tThe username already exist");
                        break;
                    }
                case 2:
                    boolean flag2 = lUser.deleteUser();
                    if (flag2 == true){
                        System.out.print ("\n\n\t\tDelete user successfully");
                        break;
                    }
                    else {
                        System.out.print ("\n\n\t\tThe username not available");
                        break;
                    }
                case 3:
                    lUser.requestBalance();
                    System.out.print ("\n\nEnter Username: ");
                    input.nextLine();
                    String inUsername = input.nextLine();
                    System.out.print ("\nEnter topup amount: ");
                    double amount = input.nextDouble();
                    if (amount < 0){
                        System.out.print ("\n\n\t\tPlease enter a balance > 0");
                    }
                    if (amount >= 0) {
                        boolean flag3 = lUser.requestTopup(inUsername, amount);
                        if (flag3 == true){
                            System.out.print ("\n\n\t\tTopup successfully");
                        }
                        else{
                            System.out.print ("\n\n\t\tUsername not available");
                        }

                    }

                    break;


                case 0:
                    System.out.print("\n\n");
                    return;
                default:
                    System.out.print("Error selection please try again. Please enter to continue...");
                    input.nextLine();
                    String clear = input.nextLine();
                    System.out.print("\n\n\n\n\n");
                    break;
            }

        }
    }

    //User category menu Interface
    public void userMenu (int typeuser, String disName){
        while (true) {
            System.out.print("\n\n\n\t\tWelcome " + disName + "\n\n");
            //double balance = lUser.displayUserBalance();
            double balance = lUser.displayUserBalance();
            if (typeuser == 2){

                System.out.print("\t\tYour balance: RM" +balance + "");
                if (balance < 1.00){
                    System.out.print("\n\t\tPlease Top Up your account");
                }
                if (balance < 10.00 && balance > 1.00){
                    System.out.print("\n\t\tYour balance is low. Please Top Up your account");
                }
            }

            //System.out.print("\t\tYour balance: RM" +balance + "\n");
            System.out.print("\n\n================================================\n");
            System.out.print("*                                              *\n");
            System.out.print("*          1. Dine in                          *\n");
            System.out.print("*          2. Take away                        *\n");
            if (typeuser == 2){
                System.out.print("*          3. Make Reservation                 *\n");
                System.out.print("*          4. View Reservation                 *\n");
            }
            System.out.print("*          0. Exit                             *\n");
            System.out.print("*                                              *\n");
            System.out.print("================================================\n");
            System.out.print("\n\n\t\tPlease enter your selection: ");
            int selection4 = input.nextInt();
            int timeSelection = 0;
            switch (selection4){
                case 1:
                    categoryMenu(typeuser, selection4, timeSelection, disName, balance);
                    return;
                case 2:
                    categoryMenu(typeuser, selection4, timeSelection, disName, balance);
                    return;
                case 3:
                    if (typeuser == 1){
                        System.out.print("\n\n\t\tError selection");
                        break;
                    }
                    System.out.print ("\n\n\t\tReservation collecting time:" );
                    System.out.print("\n\t\t1. Tmr 8.00am-9.00am breakfast");
                    System.out.print("\n\t\t2. Tmr 11.00am-12.00pm lunch");
                    System.out.print("\n\t\tEnter your selection: ");
                    timeSelection = input.nextInt();
                    if (timeSelection == 1 || timeSelection == 2){
                        categoryMenu(typeuser, selection4, timeSelection, disName, balance);
                        return;
                    }
                    else {
                        System.out.print("\n\n\tError selection");
                        break;
                    }
                case 4:
                    if (typeuser == 1){
                        System.out.print("\n\n\t\tError selection");
                        break;
                    }
                    String userID = lUser.getUserName();
                    boolean flagReserve = o1.userViewReservation(userID);
                    if (flagReserve == false){
                        System.out.print("\n\n\t\tNo reservation Data");
                    }
                    break;

                case 0:
                    return;
                default:
                    System.out.print("Error selection please try again. Please enter to continue...");
                    input.nextLine();
                    String clear = input.nextLine();
                    System.out.print("\n\n\n\n\n");
                    break;
            }
        }
    }

    public void categoryMenu (int typeUser, int status, int timeSelection, String disName, double balance){
        while (true) {
            System.out.print("\n\n\n\t\tWelcome " + disName + "\n\n");
            if (typeUser == 2) {
                System.out.print("\t\tYour balance: RM" + balance + "\n");

                if (balance < 1.00){
                    System.out.print("\n\t\tPlease Top Up your account");
                }

                if (balance < 10.00 && balance > 1.00){
                    System.out.print("\n\t\tYour balance is low. Please Top Up your account");
                }

            }
            System.out.print("\n\n================================================\n");
            System.out.print("*                                              *\n");
            System.out.print("*          1. Food                             *\n");
            System.out.print("*          2. Beverage                         *\n");
            System.out.print("*          3. Combo Meal                       *\n");
            System.out.print("*          4. View Cart                        *\n");
            System.out.print("*          0. Exit                             *\n");
            System.out.print("*                                              *\n");
            System.out.print("================================================\n");
            System.out.print("\n\n\t\tPlease enter your selection: ");
            int selection5 = input.nextInt();
            switch (selection5) {
                case 1:
                    mFood.requestViewFood();
                    System.out.print("\n\n\t\tInsert the Food ID: ");
                    int ID = input.nextInt();
                    System.out.print("\n\t\tInsert Quantity: ");
                    int qty = input.nextInt();
                    boolean flag;
                    flag = mFood.requestFoodAddOrder(ID, qty, status);

                    if (flag == true){
                        System.out.print("\n\n\t\tAdd order successfully");
                        double getPrice = mFood.getFoodPriceData(ID);
                        String dataDesc = mFood.findFoodDesc(ID);
                        o1.addOrderData(typeUser, status, timeSelection, ID, dataDesc, getPrice, qty);
                        if (status == 3){
                            mFood.updateQty(ID, 0);
                        }
                        else{
                            mFood.updateQty(ID, qty);
                            break;
                        }

                    }
                    else {
                        System.out.print("\n\n\t\tAdd order unsuccessfully, please confirm the ID and quantity you insert is correct.");
                    }
                    break;
                case 2:
                    mBeverage.requestViewBeverage();
                    System.out.print("\n\n\t\tInsert the Beverage ID: ");
                    ID = input.nextInt();
                    System.out.print("\n\t\tInsert Quantity: ");
                    qty = input.nextInt();
                    flag = mBeverage.requestBeverageAddOrder(ID, qty, status);

                    if (flag == true){
                        System.out.print("\n\n\t\tAdd order successfully");
                        double getPrice = mBeverage.getBeveragePriceData(ID);
                        String dataDesc = mBeverage.findBeverageDesc(ID);
                        o1.addOrderData(typeUser, status, timeSelection, ID, dataDesc, getPrice, qty);
                        if (status == 3){
                            mBeverage.updateQty(ID, 0);
                        }
                        else {
                            mBeverage.updateQty(ID, qty);
                            break;
                        }

                    }
                    else {
                        System.out.print("\n\n\t\tAdd order unsuccessfully, please confirm the ID and quantity you insert is correct.");
                    }
                    break;
                case 3:
                    mCombo.requestViewCombo();
                    System.out.print("\n\n\t\tInsert the Combo ID: ");
                    ID = input.nextInt();
                    System.out.print("\n\t\tInsert Quantity: ");
                    qty = input.nextInt();
                    flag = mCombo.requestComboAddOrder(ID, qty, status);

                    if (flag == true){
                        System.out.print("\n\n\t\tAdd order successfully");
                        double getPrice = mCombo.getComboPriceData(ID);
                        String dataDesc = mCombo.findComboDesc(ID);
                        o1.addOrderData(typeUser, status, timeSelection, ID, dataDesc, getPrice, qty);
                        if (status == 3){
                            mCombo.updateQty(ID, 0);
                        }
                        else {
                            mCombo.updateQty(ID, qty);
                            break;
                        }

                    }
                    else {
                        System.out.print("\n\n\t\tAdd order unsuccessfully, please confirm the ID and quantity you insert is correct.");
                    }
                    break;
                case 4:
                    boolean flagOrder = orderCart(typeUser, balance, status);
                    if (flagOrder == true){
                        return;
                    }
                    break;
                case 0:
                    boolean flagExit = o1.checkCartSize();
                    if (flagExit == false){
                        System.out.print("\n\n\t\tPlease go to View Cart clear all order");
                        break;
                    }
                    return;
                default:
                    System.out.print("Error selection please try again. Please enter to continue...");
                    input.nextLine();
                    String clear = input.nextLine();
                    System.out.print("\n\n\n\n\n");
                    break;
            }
        }


    }

    public boolean orderCart(int typeuser, double balance, int status){
        while (true){
            boolean flagView = o1.viewChart();
            if (flagView == false){
                System.out.print("\n\n\t\tPress enter to continue shopping....");
                input.nextLine();
                String enter = input.nextLine();
                return false;
            }
            System.out.print ("\n\n\t\t1. Cancel order");
            System.out.print ("\n\t\t2. Proceed to payment");
            System.out.print ("\n\t\t0. Continue Shopping");
            System.out.print ("\n\n\t\tYour selection: ");
            int selectCart = input.nextInt();
            switch (selectCart){
                case 1:
                    System.out.print("\n\n\t\tInsert ID: ");
                    int ID = input.nextInt();
                    System.out.print("\n\t\tQuantity you want delete: ");
                    int qty = input.nextInt();
                    boolean flag = o1.requestCancelOrder(ID, qty);
                    if (flag == true && status != 3){
                        System.out.print("\n\n\t\tCancel order successfully");
                        if (ID > 100 && ID < 200){
                            mFood.increaseQty(ID, qty);
                        }
                        if (ID > 200 && ID < 300){
                            mBeverage.increaseQty(ID, qty);
                        }
                        if (ID > 300 && ID < 400){
                            mCombo.increaseQty(ID, qty);
                        }
                        break;
                    }
                    if (flag == false){
                        System.out.print("\n\n\t\tCancel order unsuccessfully please check ID and Quantity you insert is valid");
                        break;
                    }
                    break;
                case 2:
                    System.out.print("\n\n\t\t1. Credit/Debit Card");
                    System.out.print("\n\t\t2. EWallet");
                    if (typeuser != 1){
                        System.out.print("\n\t\t3. Account Balance " + "\t(Your Account balance(RM): " + balance + ")" );
                    }
                    System.out.print("\n\t\t4. Cash Payment");
                    System.out.print("\n\t\t0. Cancel Payment");
                    System.out.print("\n\n\t\tEnter your payment method selection: ");
                    int selectPayment = input.nextInt();
                    if (selectPayment == 1 || selectPayment == 2){
                        System.out.print("\n\n\t\tPayment successfully. Your order has been sent to kitchen");
                        //add data to AllData
                        String userID;
                        int oID = 0;
                        if (typeuser != 1){
                            userID = lUser.getUserName();
                            oID = o1.addFinalOrderData(userID, selectPayment, 1);
                        }
                        else {
                            userID = "0";
                            oID = o1.addFinalOrderData(userID, selectPayment, 1);
                        }

                        //display receipt
                        o1.viewReceipt(oID);
                        return true;
                    }

                    if (typeuser == 2 && selectPayment == 3){
                        if (balance <= 0.00){
                            System.out.print("\n\n\t\tYour balance already credit max. You are not able to make payment.");
                            break;
                        }
                        String userID;
                        int oID = 0;
                        System.out.print("\n\n\t\tPayment successfully. Your order has been sent to kitchen");
                        //add data to AllData
                        userID = lUser.getUserName();
                        oID = o1.addFinalOrderData(userID, selectPayment, 1);
                        //display receipt
                        double grandTotal = o1.viewReceipt(oID);
                        //decrease balance
                        lUser.decreaseUserBalance(userID, grandTotal);
                        return true;
                    }
                    if (typeuser == 1 && selectPayment == 3){
                        System.out.print("\n\n\t\tError selection please try again. Please enter to continue...");
                        input.nextLine();
                        String clear = input.nextLine();
                        System.out.print("\n\n\n\n\n");
                        break;
                    }
                    if (selectPayment == 4){
                        String userID;
                        int oID = 0;
                        System.out.print("\n\n\t\tPlease go to counter to make payment using the Order Number given.");
                        //add data to AllData
                        if (typeuser != 1){
                            userID = lUser.getUserName();
                            oID = o1.addFinalOrderData(userID, selectPayment, 2);
                        }
                        else {
                            userID = "0";
                            oID = o1.addFinalOrderData(userID, selectPayment, 2);
                        }
                        //display receipt
                        System.out.print("\n\t\tYour Order Number: " + oID);
                        return true;
                    }
                    if (selectPayment == 0){
                        break;
                    }
                case 0:
                    return false;
                default:
                    System.out.print("\n\n\t\tError selection please try again. Please enter to continue...");
                    input.nextLine();
                    String clear = input.nextLine();
                    System.out.print("\n\n\n\n\n");
                    break;
            }
        }
    }

    public void viewSalesInterface(){
        while (true){
            System.out.print ("\n\n\t\t1. View by Month");
            System.out.print ("\n\t\t2. View by Date");
            System.out.print ("\n\t\t0. Exit");
            System.out.print("\n\n\t\tEnter your selection: ");
            int timeSelection = input.nextInt();
            switch (timeSelection) {
                case 1:
                    System.out.print("\n\n\t\tEnter the Year(YYYY): ");
                    int inputYear = input.nextInt();
                    System.out.print("\n\t\tEnter the Month(MM): ");
                    int inputMonth = input.nextInt();
                    boolean statusMonth = o1.viewMonthSales(inputYear, inputMonth);
                    if (statusMonth == false){
                        System.out.print("\n\n\t\tNo Data Found");
                    }
                    break;
                case 2:
                    System.out.print("\n\n\t\tEnter the Year(YYYY): ");
                    inputYear = input.nextInt();
                    System.out.print("\n\t\tEnter the Month(MM): ");
                    inputMonth = input.nextInt();
                    System.out.print("\n\t\tEnter the Date (DD): ");
                    int inputDate = input.nextInt();
                    boolean statusDate = o1.viewDateSales(inputYear, inputMonth, inputDate);
                    if (statusDate == false){
                        System.out.print("\n\n\t\tNo Data Found");
                    }
                    break;
                case 0:
                    return;
                default:
                    System.out.print("\n\n\t\tError selection");
                    break;
            }
        }
    }

}
