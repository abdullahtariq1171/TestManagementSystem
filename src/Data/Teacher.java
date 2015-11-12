package Data;

import DAL.CourseDAO;

public class Teacher extends User {
	
	String id;
	String discipline;
	
	public Teacher(String id, String name,  String password, int age, boolean is_male, String discipline){
		super(name, password, is_male, age);
		this.id = id;
		this.discipline = discipline;
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "Teacher";
	}	

	//it will return only courses where Teacher is teaching
	 public Course[] getCourses()
	 {
		 return new CourseDAO().getCourses(id);		 
	 }
}
