/* filename: Login.java */
/* subclass of User.Java */
/* invoke user input */
package JavaProjectCafeInventory;

public class Login
{
	protected String username,id;
	protected int passcode;
		
	List<Users> listOfUsers = new ArrayList<Users>();
		
	listOfUsers.add(new Users("Siew ", "1234"));
	listOfUsers.add(new Users("Jayden ", "2345"));
	listOfUsers.add(new Users("JJ ", "3456"));
	listOfUsers.add(new Users("Chris ", "4567"));

		
	public User()
	{
			
	}
		
	public User(String uName, String uId, int uPasscode)
	{
			
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
}
