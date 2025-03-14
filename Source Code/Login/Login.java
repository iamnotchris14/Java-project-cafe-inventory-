/* filename: Login.java */
/* subclass of User.Java */
/* invoke user input */
package JavaProjectCafeInventory;

import java.util.*;

public class Login
{
	protected String username, id;
	protected int passcode;
		
	ArrayList<Obejct>Users = new ArrayList<Object>();
	
	Users.add("Siew ", "ID001", 1234);
	Users.add("Jayden ", "ID002", 2345);
	Users.add("JJ ", "ID003", 3456);
	Users.add("Chris ", "ID004", 4567);
	Users.add("Ryan ", "ID005", 5678);

	
	public Login()
	{
		
	}
		
	public Login(String uName, String uId, int uPasscode)
	{
		this.username = uName;
		this.id = uId;
		this.passcode = uPasscode;
	}
		
	public void setUser(String uName, String uId, int uPasscode )
	{
		this.username = uName;
		this.id = uId;
		this.passcode = uPasscode;

	}
		
	public String getName()
	{
		return username;
	}
		
	public String getId()
	
	{
		return id;
	}
		
	public int getPasscode()
	{
		return passcode;
	}
	
	Scanner scln = new Scanner(System.in);
	username scln = scan.nextLine();
	id scln = scan.nextLine();
	passcode scln = scan.nextInt();
	
	
	boolean found = false;
	
	
	
	
}