package Data;

public class Teacher extends User {
	
	String id;
	String discipline;
	
	public Teacher(String name, String id,  String password, boolean is_male, int age,  String discipline) {
		super(name, password, is_male, age);
		this.id = id;
		this.discipline = discipline;
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "Teacher";
	}
	
}
