package Data;

public abstract class User 
{
	protected String name;
	protected String password;
	protected boolean is_male;
	protected int age;
	
	public User(String name, String password, boolean is_male, int age) {
		this.name = name;
		this.password = password;
		this.is_male = is_male;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean is_male() {
		return is_male;
	}

	public void setIs_male(boolean is_male) {
		this.is_male = is_male;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	 public abstract String getType();
	
}
