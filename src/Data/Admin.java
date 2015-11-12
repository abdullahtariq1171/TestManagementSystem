package Data;

public class Admin extends User{
	String id;

	public Admin( String id , String name, String password, boolean is_male, int age) {
		super(name, password, is_male, age);
		this.id = id;
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "Admin";
	}
	
	
	
	
}
