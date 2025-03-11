package FoodOrdering;

import java.util.ArrayList;

public class LoginManagement extends Login {


    ArrayList <Login> managementData = new ArrayList<>();


    //pre define value
    public void data(){
        Login d1 = new Login("admin1", "123.com","management1");
        managementData.add(d1);

        //System.out.print(d1.getUserName()+d1.getPassWord());//test data saved in Arraylist

    }

    public boolean showLoginManagement(){
        showLogin();
        //data(); // add pre define data
        boolean flag = auth(managementData);
        //displayData(managementData);
        //System.out.print (userName + passWord); //test input received

        return flag;
    }

    public String displayUsername(){
        return checkUsername(managementData);
    }



}
