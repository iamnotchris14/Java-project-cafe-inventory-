package FoodOrdering;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import java.util.Date;

public class Order {
    private int orderId;
    private int identity;
    private int status;
    private int time;
    private int ID;
    private String dataDesc;
    private double price;
    private int qty;
    private int paymentMethod;
    private int paymentStatus;
    private String userID;
    private int year;
    private int month;
    private int date;

    Date d1 = new Date();
    Scanner input = new Scanner(System.in);
    Calendar cl = Calendar.getInstance();
    DecimalFormat d = new DecimalFormat("#0.00");

    ArrayList<Order>SaveData = new ArrayList<>();

    ArrayList<Order>OrderData = new ArrayList<>();

    public Order (){

    }

    public Order (int orderId, int identity, int status, int time, int ID, String dataDesc, double price, int qty){
        this.orderId = orderId;
        this.identity = identity;
        this.status = status;
        this.time = time;
        this.ID = ID;
        this.dataDesc = dataDesc;
        this.price = price;
        this.qty =qty;
    }

    public Order (int orderId, int identity, int status, int time, int ID, String dataDesc, double price, int qty, int paymentMethod, int paymentStatus, String userID, int year, int month, int date){
        this.orderId = orderId;
        this.identity = identity;
        this.status = status;
        this.time = time;
        this.ID = ID;
        this.dataDesc = dataDesc;
        this.price = price;
        this.qty = qty;
        this.paymentStatus = paymentStatus;
        this.paymentMethod = paymentMethod;
        this.userID = userID;
        this.year = year;
        this.month = month;
        this.date = date;
    }

    public void setOrderId (int orderId){
        this.orderId = orderId;
    }

    public int getOrderId (){
        return orderId;
    }

    public void setIdentity (int identity){
        this.identity = identity;
    }

    public int getIdentity (){
        return identity;
    }

    public void setStatus (int status){
        this.status = status;
    }

    public int getStatus (){
        return status;
    }

    public void setTime(int time){
        this.time = time;
    }

    public int getTime(){
        return time;
    }

    public void setID(int ID){
        this.ID = ID;
    }

    public int getID (){
        return ID;
    }

    public void setUserID(String userID){
        this.userID = userID;
    }
    public String getUserID(){
        return userID;
    }

    public void setDataDesc(String dataDesc){
        this.dataDesc = dataDesc;
    }

    public String getDataDesc(){
        return dataDesc;
    }
    public void setPrice(double price){
        this.price = price;
    }

    public double getPrice(){
        return price;
    }

    public void setQty(int qty){
        this.qty = qty;
    }

    public int getQty(){
        return qty;
    }

    public void setPaymentMethod(int paymentMethod){
        this.paymentMethod = paymentMethod;
    }

    public int getPaymentMethod(){
        return paymentMethod;
    }

    public void setPaymentStatus(int paymentStatus){
        this.paymentStatus = paymentStatus;
    }

    public int getPaymentStatus(){
        return paymentStatus;
    }
    public void setYear (int year){
        this.year = year;
    }
    public int getYear(){
        return year;
    }
    public void setMonth(int month){
        this.month = month;
    }
    public int getMonth(){
        return month;
    }
    public void setDate(int date){
        this.date = date;
    }
    public int getDate(){
        return date;
    }

    /*
    public void defineData(){
        Order o1 = new Order(1001, 1, 1, 0, 201, 0.50, 1);
        SaveData.add(o1);
    }

     */


    public void addOrderData(int identity, int status, int timeSelection, int ID, String desc, double price, int qty){

        int orderId = findOrderID(OrderData);
        int neworderId = orderId + 1;
        boolean flag = checkDuplicateAddOrderData(neworderId, identity, status, timeSelection, ID, desc, price, qty, SaveData);
        if (flag == true){
            Order oTempData = new Order (neworderId, identity, status, timeSelection, ID, desc, price, qty);
            SaveData.add(oTempData);
        }


    }

    public boolean checkDuplicateAddOrderData(int orderId, int identity, int status, int timeSelection, int ID, String desc, double price, int qty, ArrayList<Order>checkAdd){
        for (int i = 0; i < checkAdd.size(); i++){
            Order addData1 = checkAdd.get(i);
            if (addData1.getID() == ID){
                int totalQty = addData1.getQty() + qty;
                Order addQty = new Order(orderId, identity, status, timeSelection, ID, desc, price, totalQty);
                checkAdd.set(i, addQty);
                return false;
            }
        }
        return true;
    }
    public int findOrderID(ArrayList<Order>availableData){
        int getIDCount = availableData.size();
        for (int i = 0; i < availableData.size(); i++){
            Order findID = availableData.get(i);
            if (getIDCount == i+1){
                return findID.getOrderId();

            }
        }
        return 1000;
    }

    public boolean viewChart(){
        boolean flag = checkChart(SaveData);
        if (flag == false){
            System.out.print("\n\n\t\tYour Chat is empty");
            return false;
        }
        return true;
    }

    public boolean checkCartSize(){
        if (SaveData.size() != 0){
            return false;
        }
        return true;
    }

    public boolean checkChart(ArrayList<Order>ChartData){
        double grantTotal = 0.00;
        if (ChartData.size() == 0){
            return false;
        }

        else {
            System.out.print("\n\n\t\tYour Cart:");
            System.out.print("\n\t\tID: \t\tDescription: \t\tPrice(RM): \t\tQuantity:\t\tSubTotal(RM):");
        }

        for (int i = 0; i < ChartData.size(); i++){
            Order cart1 = ChartData.get(i);
            double subTotal = cart1.getPrice() * cart1.getQty();
            System.out.print("\n\t\t" +cart1.getID()+"\t\t\t"+cart1.getDataDesc()+"\t\t\t"+ d.format(cart1.getPrice())+"\t\t\t\t"+cart1.getQty()+"\t\t\t\t"+ d.format(subTotal));
            grantTotal = subTotal + grantTotal;
            //System.out.print("\n\n" +cart1.getOrderId() + cart1.getIdentity() + cart1.getStatus() + cart1.getTime()+cart1.getID()+cart1.getDataDesc()+cart1.getPrice()+cart1.getQty());
        }

        System.out.print ("\n\n\t\tGrant Total(RM): " + d.format(grantTotal));

        return true;
    }

    public boolean requestCancelOrder(int ID, int qty){
        boolean flag = deleteOrder(ID, qty, SaveData);
        return flag;
    }

    public boolean deleteOrder(int ID, int qty, ArrayList<Order>DeleteOrder){
        if (qty < 0){
            return false;
        }
        for (int i = 0; i < DeleteOrder.size(); i++){
            Order delete = DeleteOrder.get(i);
            if (delete.getID() == ID){
                if (delete.getQty() < qty){
                    return false;
                }
                int newQty = delete.getQty() - qty;
                if (newQty == 0){
                    DeleteOrder.remove(i);
                    return true;
                }
                Order updateData = new Order(delete.getOrderId(), delete.getIdentity(), delete.getStatus(), delete.getTime(), delete.getID(), delete.getDataDesc(), delete.getPrice(), newQty);
                DeleteOrder.set(i, updateData);
                return true;
            }
        }
        return false;
    }

    public int addFinalOrderData(String userID, int paymentMethod, int paymentStatus){
        int latestOrderID = 0;
        for (int i = 0; i < SaveData.size(); i++){
            Order tempData = SaveData.get(i);
            cl.setTime(d1);
            int year = cl.get(Calendar.YEAR);
            int month = cl.get(Calendar.MONTH) + 1;
            int date = cl.get(Calendar.DATE);
            Order corrData = new Order(tempData.getOrderId(), tempData.getIdentity(), tempData.getStatus(), tempData.getTime(), tempData.getID(), tempData.getDataDesc(), tempData.getPrice(), tempData.getQty(), paymentMethod, paymentStatus, userID, year, month, date);
            OrderData.add(corrData);
            latestOrderID = tempData.getOrderId();

        }

        SaveData.clear();
        return latestOrderID;
        /*
        for (int i = 0; i < SaveData.size(); i++){
            Order getData = SaveData.get(i);
            Order deleteData = new Order(getData.getOrderId(), getData.getIdentity(), getData.getStatus(), getData.getTime(), getData.getID(), getData.getDataDesc(), getData.getPrice(), getData.getQty());
            SaveData.clear();
        }

         */
    }

    public double viewReceipt(int orderID){
        String status = "";
        int counter = 0;
        int no = 1;
        int payMethod = 0;
        double grandTotal = 0.00;
        for (int i = 0; i < OrderData.size(); i++ ) {
            Order allData = OrderData.get(i);
            if (allData.getOrderId() == orderID) {
                counter ++;
                if (counter == 1) {
                    payMethod = allData.getPaymentMethod();
                    System.out.print("\n\n\n\t\t\t\t   UoW Malaysia Cafeteria");
                    System.out.print("\n\tJalan Kontraktor U1/14, Glenpark U1, 40150 Shah Alam, Selangor");
                    System.out.print("\n\n\t\t\t\tOfficial Receipt");
                    System.out.print("\n\n\t\t\t\tYour Order Number: " + allData.getOrderId());
                    if (allData.getIdentity() == 2){
                        System.out.print("\n\t\t\t\tYour User ID: " + allData.getUserID());
                    }
                    if (allData.getIdentity() == 1){
                        System.out.print("\n\t\t\t\tYour User ID: Guest" );
                    }
                    if (allData.getStatus() == 1){
                        status = "Dine In";
                    }
                    if (allData.getStatus() == 2){
                        status = "Take Away";
                    }
                    if (allData.getStatus() == 3){
                        status = "Reservation";
                    }
                    System.out.print("\n\t\t\t\tYour Status: "+ status);
                    System.out.print("\n\t\t\t\tDate:" + allData.getYear() + "/" + allData.getMonth() + "/" + allData.getDate());
                    System.out.print("\n\n=====================================================================================================");
                    System.out.print("\n\nNo: \tItem ID: \tItem Desc: \t\tPrice(RM): \tQuantity: \t SubTotal(RM):");
                }
                double subTotal = allData.getQty() * allData.getPrice();
                System.out.print("\n" + no + "\t\t" + allData.getID() + "\t\t\t" + allData.getDataDesc() + "\t\t" + d.format(allData.getPrice()) + "\t\t\t\t" + allData.getQty() + "\t\t\t\t" + d.format(subTotal));
                no ++;
                grandTotal = subTotal + grandTotal;

                //System.out.print("\n\n" + allData.getOrderId() + allData.getIdentity() + allData.getStatus() + allData.getTime() + allData.getID() + allData.getDataDesc() + allData.getPrice() + allData.getQty() + allData.getPaymentMethod() + allData.getPaymentStatus() + allData.getUserID() + allData.getYear() + allData.getMonth() + allData.getDate());
            }
        }
        System.out.print ("\n\n\n\t\t\t\t\t\t\t\t\t\t\t\tGrand Total (RM): " + d.format(grandTotal));
        if (payMethod == 1){
            System.out.print ("\n\t\t\t\t\t\t\t\t\t\t\t\tPayment Method: Credit/Debit Card");
        }
        if (payMethod == 2){
            System.out.print ("\n\t\t\t\t\t\t\t\t\t\t\t\tPayment Method: EWallet");
        }
        if (payMethod == 3){
            System.out.print ("\n\t\t\t\t\t\t\t\t\t\t\t\tPayment Method: Account Balance");
        }

        return grandTotal;
    }

    public boolean userViewReservation(String userID){
        int counter = 0;
        int counter2 = 0;
        int no = 1;
        int gotData = 0;
        for (int i = 0; i < OrderData.size(); i++){
            Order reservation = OrderData.get(i);
            if (reservation.getUserID().equals(userID)) {
                if (reservation.getStatus() == 3) {
                    counter++;
                    if (counter == 1) {
                        System.out.print("\n\n\t\tYour reservation:");
                        System.out.print("\n\nNo: \tItem ID: \tItem Desc: \t\tPrice(RM): \tQuantity: \t\tReservation Time:");
                    }
                    if (reservation.getOrderId() != counter2) {
                        if (reservation.getPaymentStatus() == 2){
                            System.out.print("\nOrder ID: " + reservation.getOrderId() + "\tPlease go to counter pay by today" + "\tOrder Time: " + reservation.getYear() + "/" + reservation.getMonth() + "/" + reservation.getDate());
                        }
                        else {
                            System.out.print("\nOrder ID: " + reservation.getOrderId() + "\tOrder Time: " + reservation.getYear() + "/" + reservation.getMonth() + "/" + reservation.getDate());
                        }

                    }

                    String reservationTime = "";
                    if (reservation.getTime() == 1) {
                        reservationTime = "Tmr 8.00am-9.00am breakfast";
                    }
                    if (reservation.getTime() == 2) {
                        reservationTime = "Tmr 11.00am-12.00pm lunch";
                    }

                    System.out.print("\n" + no + "\t\t" + reservation.getID() + "\t\t\t" + reservation.getDataDesc() + "\t\t" + reservation.getPrice() + "\t\t\t\t" + reservation.getQty() + "\t\t\t" + reservationTime);
                    gotData++;
                    no++;
                    counter2 = reservation.getOrderId();
                }
            }
        }
        if (gotData == 0){
            return false;
        }
        return true;
    }

    public boolean managementViewReservation(){
        int counter = 0;
        int counter2 = 0;
        int no = 1;
        int gotData = 0;
        for (int i = 0; i < OrderData.size(); i++){
            Order reservation = OrderData.get(i);

            if (reservation.getStatus() == 3 && reservation.getPaymentStatus() == 1) {
                counter ++;
                if (counter == 1) {
                    System.out.print("\n\n\t\tCustomer reservation:");
                    System.out.print("\n\nNo: \tItem ID: \tItem Desc: \t\tPrice(RM): \tQuantity: \t\tReservation Time:");
                }
                if (reservation.getOrderId() != counter2) {
                    System.out.print("\nOrder ID: " + reservation.getOrderId() + "\tOrder by: " + reservation.getUserID() + "\tOrder Time: " + reservation.getYear() + "/" + reservation.getMonth() + "/" + reservation.getDate());
                }
                String reservationTime = "";
                if (reservation.getTime() == 1) {
                    reservationTime = "Tmr 8.00am-9.00am breakfast";
                }
                if (reservation.getTime() == 2) {
                    reservationTime = "Tmr 11.00am-12.00pm lunch";
                }

                System.out.print("\n" + no + "\t\t" + reservation.getID() + "\t\t\t" + reservation.getDataDesc() + "\t\t" + reservation.getPrice() + "\t\t\t\t" + reservation.getQty() + "\t\t\t" + reservationTime);
                gotData++;
                no++;
                counter2 = reservation.getOrderId();

            }

        }
        if (gotData == 0){
            return false;
        }
        return true;
    }

    public boolean viewCahPayment(){
        int counter = 0;
        int no = 1;
        int gotData = 0;
        int orderIDCounter = 0;
        for (int i = 0; i < OrderData.size(); i++){
            Order cash = OrderData.get(i);
            if (cash.getPaymentStatus() == 2 && orderIDCounter != cash.getOrderId()){
                counter ++;
                if (counter == 1){
                    System.out.print("\n\n\t\tPending Cash Payment:");
                    System.out.print("\n\nNo: \t\t\tOrder ID:");
                }
                System.out.print("\n" + no + "\t\t\t\t" + cash.getOrderId());
                orderIDCounter = cash.getOrderId();
                no++;
                gotData++;
            }
        }
        if (gotData == 0){
            return false;
        }
        return true;
    }

    public boolean cashPayment(){
        System.out.print("\n\n\t\tEnter Order ID: ");
        int inputID = input.nextInt();
        for (int i = 0; i < OrderData.size(); i++){
            Order cash = OrderData.get(i);
            if (cash.getOrderId() == inputID && cash.getPaymentStatus() == 2){
                double grandTotal = viewReceipt(inputID);
                System.out.print("\n\t\t\t\t\t\t\t\t\t\t\t\tCash Pay(RM): ");
                double amount = input.nextDouble();
                if (amount < grandTotal){
                    System.out.print("\n\n\t\tPlease enter a valid Cah Pay");
                    return false;
                }
                System.out.print("\t\t\t\t\t\t\t\t\t\t\t\tChange Amount(RM): " + d.format((amount - grandTotal)));
                System.out.print ("\n\t\t\t\t\t\t\t\t\t\t\t\tPayment Method: Cash Payment");
                updatePaymentStatus(inputID);
                return true;
            }
        }
        System.out.print("\n\n\t\tError Selection");
        return false;
    }

    public void updatePaymentStatus(int orderId){
        for (int i = 0; i < OrderData.size(); i++){
            Order updatePayStatus = OrderData.get(i);
            if (updatePayStatus.getOrderId() == orderId){
                Order newStatus = new Order(updatePayStatus.getOrderId(), updatePayStatus.getIdentity(), updatePayStatus.getStatus(), updatePayStatus.getTime(), updatePayStatus.getID(), updatePayStatus.getDataDesc(), updatePayStatus.getPrice(), updatePayStatus.getQty(), updatePayStatus.getPaymentMethod(), 1, updatePayStatus.getUserID(), updatePayStatus.getYear(), updatePayStatus.getMonth(), updatePayStatus.getDate());
                OrderData.set(i, newStatus);
            }
        }

    }

    public boolean viewOrderDetail(){
        int counter = 0;
        int counter2 = 0;
        int no = 1;
        int gotData = 0;
        cl.setTime(d1);
        int year = cl.get(Calendar.YEAR);
        int month = cl.get(Calendar.MONTH) + 1;
        int date = cl.get(Calendar.DATE);
        for (int i = 0; i < OrderData.size(); i++){
            Order oDetail = OrderData.get(i);
            if (oDetail.getPaymentStatus() == 1 && oDetail.getStatus() != 3 && oDetail.getDate() == date){
                counter ++;
                if (counter == 1){
                    System.out.print("\n\nAll Order by Today: " + year + "/" + month +"/" + date);
                    System.out.print("\n\nNo: \tItem ID: \tItem Desc: \t\t\t\t\tQuantity: ");
                }
                if (oDetail.getOrderId() != counter2) {
                    if (oDetail.getUserID().equals("0")){
                        System.out.print("\nOrder ID: " + oDetail.getOrderId() + "\tOrder by: Guest");
                    }
                    else {
                        System.out.print("\nOrder ID: " + oDetail.getOrderId() + "\tOrder by: " + oDetail.getUserID());
                    }

                }

                System.out.print("\n" + no + "\t\t" + oDetail.getID() + "\t\t\t" + oDetail.getDataDesc() + "\t\t\t\t\t" + oDetail.getQty());
                gotData++;
                no++;
                counter2 = oDetail.getOrderId();
            }
        }
        if (gotData == 0){
            return false;
        }
        return true;
    }

    public boolean callOrder(int orderID){
        int gotdata = 0;
        for (int i = 0; i < OrderData.size(); i++){
            Order updateCall = OrderData.get(i);
            if (updateCall.getOrderId() == orderID && updateCall.getPaymentStatus() == 1){
                Order update = new Order(updateCall.getOrderId(), updateCall.getIdentity(), updateCall.getStatus(), updateCall.getTime(), updateCall.getID(), updateCall.getDataDesc(), updateCall.getPrice(), updateCall.getQty(), updateCall.getPaymentMethod(), 3, updateCall.getUserID(), updateCall.getYear(), updateCall.getMonth(), updateCall.getDate());
                OrderData.set(i, update);
                gotdata ++;
            }
        }
        if (gotdata == 0){
            System.out.print("\n\n\t\tOrder ID not found");
            return false;
        }
        System.out.print("\n\n\t\tDing Dong !!!! Ding Dong!!!!");
        System.out.print("\n\t\tYour Order Number: \n\t\t\t\t" + orderID);
        System.out.print("\n\t\tCollect your Food at Counter");
        return true;
    }

    public boolean viewMonthSales(int inYear, int inMonth){
        int counter = 0;
        int counter2 = 0;
        int counter3 = 0;
        int no = 1;
        int gotData = 0;
        double totalSales = 0.00;
        for (int i = 0; i < OrderData.size(); i++){
            Order monthSales = OrderData.get(i);
            if (monthSales.getPaymentStatus() != 2){
                counter2 = monthSales.getOrderId();
                if (monthSales.getYear() == inYear && monthSales.getMonth() == inMonth && counter2 == monthSales.getOrderId()){
                    counter ++;

                    if (counter == 1){
                        System.out.print("\n\n\t\tSales Report on: " + monthSales.getYear() + "/" + monthSales.getMonth());
                        System.out.print("\n\nNo: \tItem ID: \tItem Desc: \t\t\t\tPrice(RM): \t\tQuantity: \t\tCharges(RM):" );
                    }
                    if (counter3 != monthSales.getOrderId()){
                        System.out.print("\nOrder ID: " + monthSales.getOrderId() );
                    }
                    double charges = monthSales.getPrice()*monthSales.getQty();
                    System.out.print("\n" + no + "\t\t" + monthSales.getID() + "\t\t\t" + monthSales.getDataDesc() + "\t\t\t\t" + d.format(monthSales.getPrice()) + "\t\t\t\t" + monthSales.getQty() + "\t\t\t\t\t" + d.format(charges));
                    gotData++;
                    no++;
                    counter3 = monthSales.getOrderId();
                    totalSales = charges + totalSales;
                }
            }
        }
        if (gotData == 0){
            return false;
        }
        System.out.print("\n\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tTotal Sales(RM): " + totalSales);
        return true;
    }

    public boolean viewDateSales(int inYear, int inMonth, int inDate){
        int counter = 0;
        int counter2 = 0;
        int counter3 = 0;
        int no = 1;
        int gotData = 0;
        double totalSales = 0.00;
        for (int i = 0; i < OrderData.size(); i++){
            Order monthSales = OrderData.get(i);
            if (monthSales.getPaymentStatus() != 2){
                counter2 = monthSales.getOrderId();
                if (monthSales.getYear() == inYear && monthSales.getMonth() == inMonth && monthSales.getDate() == inDate && counter2 == monthSales.getOrderId()){
                    counter ++;

                    if (counter == 1){
                        System.out.print("\n\n\t\tSales Report on: " + monthSales.getYear() + "/" + monthSales.getMonth() + "/" + monthSales.getDate());
                        System.out.print("\n\nNo: \tItem ID: \tItem Desc: \t\t\t\tPrice(RM): \t\tQuantity: \t\tCharges(RM):" );
                    }
                    if (counter3 != monthSales.getOrderId()){
                        System.out.print("\nOrder ID: " + monthSales.getOrderId());
                    }
                    double charges = monthSales.getPrice()*monthSales.getQty();
                    System.out.print("\n" + no + "\t\t" + monthSales.getID() + "\t\t\t" + monthSales.getDataDesc() + "\t\t\t\t" + d.format(monthSales.getPrice()) + "\t\t\t\t" + monthSales.getQty() + "\t\t\t\t\t" + d.format(charges));
                    gotData++;
                    no++;
                    counter3 = monthSales.getOrderId();
                    totalSales = charges + totalSales;
                }
            }
        }
        if (gotData == 0){
            return false;
        }
        System.out.print("\n\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tTotal Sales(RM): " + d.format(totalSales));
        return true;
    }

}
