package FoodOrdering;

import java.util.ArrayList;

public class LoginUser extends Login{

    private double accountBalance;

    ArrayList<Login> userData = new ArrayList<>();
    ArrayList<LoginUser>userBalance = new ArrayList<>();

    public LoginUser (){

    }

    public LoginUser(String userName, double accountBalance){
        this.userName = userName;
        this.accountBalance = accountBalance;
    }

    public void setAccountBalance(double accountBalance){
        this.accountBalance = accountBalance;
    }

    public double getAccountBalance(){
        return accountBalance;
    }

    //pre define value
    public void data(){
        Login u1 = new Login("0135057", "123.com", "Enoch");
        userData.add(u1);
        Login u2 = new Login("0145050", "123", "test01");
        userData.add(u2);
        Login u3 = new Login("0133393", "123.com", "Jun Cheng");
        userData.add(u3);
        Login u4 = new Login("0133841", "123.com", "Joon Ee");
        userData.add(u4);
        Login u5 = new Login("0133968", "123.com", "Shuba");
        userData.add(u5);
        Login u6 = new Login("0131275", "123.com", "Celine");
        userData.add(u6);

        //System.out.print(u1.getUserName()+u1.getPassWord());//test data saved in Arraylist

    }

    public void balanceData(){
        LoginUser userBalance1 = new LoginUser("0135057", 200.00);
        userBalance.add(userBalance1);
        LoginUser userBalance2 = new LoginUser("0145050", 100.00);
        userBalance.add(userBalance2);
        LoginUser userBalance3 = new LoginUser("0133393", 200.00);
        userBalance.add(userBalance3);
        LoginUser userBalance4 = new LoginUser("0133841", 200.00);
        userBalance.add(userBalance4);
        LoginUser userBalance5 = new LoginUser("0133968", 200.00);
        userBalance.add(userBalance5);
        LoginUser userBalance6 = new LoginUser("0131275", 200.00);
        userBalance.add(userBalance6);

    }


    //show login interface & authenticate
    public boolean showLoginUser(){
        showLogin(); //show login interface
        boolean flag = auth(userData); // authenticate
        //System.out.print (userName + passWord); //test input received

        return flag;
    }


    // from manage user first interface
    public void requestView(){

        //boolean flag = displayData(userData, userBalance);
        boolean flag = true;
        if (userData.size() !=0){
            System.out.print("\n\n\nUsername: \t\t\tPassword: \t\t\tFullname: \t\t\tBalance(RM):\n");
        }
        for (int i = 0; i<userData.size();i++){
            Login u1 = userData.get(i);
            LoginUser b1 = userBalance.get(i);
            System.out.print(u1.getUserName()+"\t\t\t\t"+u1.getPassWord()+"\t\t\t\t"+u1.getName()+"\t\t\t\t"+b1.getAccountBalance()+"\n");
        }
        if (userData.size() == 0){
            flag = false;
        }
        if(flag == false){
            System.out.print ("\n\n\nNo data found\n\n");
        }
    }

    /*
    //display all the available account details (username, password, fullname and balance)
    public boolean displayData (ArrayList<Login> userData, ArrayList<LoginUser>userBalance){
        boolean flag = true;
        if (userData.size() !=0){
            System.out.print("\n\n\nUsername: \t\t\tPassword: \t\t\tFullname: \t\t\tBalance(RM):\n");
        }
        for (int i = 0; i<userData.size();i++){
            Login u1 = userData.get(i);
            LoginUser b1 = userBalance.get(i);
            System.out.print(u1.getUserName()+"\t\t\t\t"+u1.getPassWord()+"\t\t\t\t"+u1.getName()+"\t\t\t\t"+b1.getAccountBalance()+"\n");
        }
        if (userData.size() == 0){
            flag = false;
            return flag;
        }
        return flag;
    }

     */

    //management add user
    public boolean addUser(){
        System.out.print("\n\n\t\tEnter Username: ");
        userName = input.nextLine();
        System.out.print ("\n\t\tEnter Password: ");
        passWord = input.nextLine();
        System.out.print ("\n\t\tEnter Fullname: ");
        name = input.nextLine();
        boolean flag = checkDuplicate(userName, passWord, name);
        return flag;
    }

    //management check duplicate username, if no add new account
    public boolean checkDuplicate(String username, String password, String fullname){
        for (int i = 0; i<userData.size();i++){
            Login u1 = userData.get(i);
            if(u1.getUserName().equals(username)){
                return false;
            }
        }
        Login u2 = new Login(username, password, fullname);
        userData.add(u2);
        LoginUser createBalance = new LoginUser(username, 0.00);
        userBalance.add(createBalance);
        return true;
    }

    //for management delete user
    public boolean deleteUser(){
        System.out.print("\n\n\t\tEnter Username: ");
        userName = input.nextLine();
        boolean flag = checkAvailable(userName);
        return flag;
    }

    //management insert username check the username available or false
    public boolean checkAvailable(String username){
        for (int i = 0; i<userData.size();i++) {
            Login u1 = userData.get(i);
            LoginUser b1 = userBalance.get(i);
            if (u1.getUserName().equals(username)) {
                userData.remove(i);
                userBalance.remove(i);
                return true;
            }
        }
        return false;
    }

    //for management view in topup
    public void requestBalance(){
        boolean flag = displayBalance();
        if(flag == false){
            System.out.print ("\n\n\nNo data found\n\n");
        }
    }

    //management view all username and its balance
    public boolean displayBalance(){
        if (userBalance.size()>0){
            System.out.print("\n\n\t\tUsername:\t\tBalance(RM):");
        }
        for (int i = 0;i<userBalance.size();i++){
            LoginUser lu1 = userBalance.get(i);
            System.out.print("\n\t\t" + lu1.getUserName() + "\t\t\t" + lu1.getAccountBalance());
        }
        if (userBalance.size() == 0){
            return false;
        }
        return true;
    }

    //for management topup
    public boolean requestTopup(String username, double amount){

        //boolean flag = topup(username, amount, userBalance);
        //return flag;
        for (int i = 0; i < userBalance.size(); i++) {
            LoginUser L1 = userBalance.get(i);

            if (L1.getUserName().equals(username)){
                double total = amount + L1.getAccountBalance();
                LoginUser balance = new LoginUser(username, total);
                userBalance.set(i, balance);
                return true;
            }

        }
        return false;
    }

    /*
    //management find the correct username and add the topup balance
    public boolean topup (String username, double amount, ArrayList<LoginUser>userBalance){

        //System.out.print("\n\nTest:" + username+ + userBalance.size()+"\n\n\n");
        for (int i = 0; i < userBalance.size(); i++) {
            LoginUser L1 = userBalance.get(i);
            //System.out.print("\n\nTest:"+L1.getUserName()+username+"\n\n\n");

            if (L1.getUserName().equals(username)){
                double total = amount + L1.getAccountBalance();
                LoginUser balance = new LoginUser(username, total);
                userBalance.set(i, balance);
                return true;
            }

        }
        return false;
    }

     */

    //for user display fullname
    public String displayUsername(){
        return checkUsername(userData);
    }


    //for user display account balance
    public double displayUserBalance(){
        //return checkBalance(userBalance);
        for (int i = 0; i<userBalance.size(); i++){
            LoginUser b1 = userBalance.get(i);
            if (b1.getUserName().equals(userName)){
                return b1.getAccountBalance();
            }
        }
        return 0.00;
    }

    /*
    //get the account balance of specific login user
    public double checkBalance(ArrayList<LoginUser>userBalance){
        for (int i = 0; i<userBalance.size(); i++){
            LoginUser b1 = userBalance.get(i);
            if (b1.getUserName().equals(userName)){
                return b1.getAccountBalance();
            }
        }
        return 0.00;
    }

     */

    public void decreaseUserBalance(String userID, double grandTotal){
        for (int i = 0; i < userBalance.size(); i ++ ){
            LoginUser userbalance = userBalance.get(i);
            if (userbalance.getUserName().equals(userID)){
                double newBalance = userbalance.getAccountBalance() - grandTotal;
                LoginUser latestBalance = new LoginUser(userbalance.getUserName(), newBalance);
                userBalance.set(i, latestBalance);
            }
        }
    }


}
