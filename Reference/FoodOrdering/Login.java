package FoodOrdering;
import java.util.ArrayList;
import java.util.Scanner;

public class Login {

    Scanner input = new Scanner(System.in);
    protected String userName;
    protected String passWord;
    protected String name;

    public Login(){

    }

    public Login(String username, String password, String name){
        this.userName = username;
        this.passWord = password;
        this.name = name;

    }

    public void setUserName(String userName){
        this.userName = userName;
    }

    public String getUserName(){
        return userName;
    }

    public void setPassWord(String passWord){
        this.passWord = passWord;
    }

    public String getPassWord(){
        return passWord;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    //display login interface
    public void showLogin(){
        System.out.print ("\n\n\n\n\t\tUsername: ");
        userName = input.nextLine();
        System.out.print ("\n\t\tPassword: ");
        passWord = input.nextLine();

    }

    //authentication
    public boolean auth(ArrayList<Login>authData){
        for (int i = 0; i < authData.size(); i++){
            Login u1 = authData.get(i);
            if(u1.getUserName().equals(userName) && u1.getPassWord().equals(passWord)){
                return true;
            }
        }

        return false;
    }

    //find specific username its fullname and return to display
    public String checkUsername(ArrayList<Login>allData){
        for (int i = 0; i < allData.size(); i++){
            Login d1 = allData.get(i);
            if (d1.getUserName().equals(userName)){
                return d1.getName();
            }
        }
        return null;
    }


}
