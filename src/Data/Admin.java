package Data;

import DAL.CourseDAO;

public class Admin extends User{
	String id;

	public Admin( String id , String name, String password, int age,  boolean is_male) {
		super(name, password, is_male, age);
		this.id = id;
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "Admin";
	}
	
	//for admin it will return all the courses
	 public Course[] getCourses()
	 {
		 return new CourseDAO().getCourses(id);		 
	 }
}
