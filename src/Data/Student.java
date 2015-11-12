package Data;

public class Student extends User {
	
	String rollno;
	String discipline;
	
	
	public Student(final String roll_no, final String name, final String password, final int age, boolean is_male, final String discipline ) 
	{
		super(name, password, is_male, age);
		this.rollno = roll_no ;
		this.discipline = discipline;
	}


	public String getRollno() {
		return rollno;
	}


	public void setRollno(String rollno) {
		this.rollno = rollno;
	}


	public String getDiscipline() {
		return discipline;
	}


	public void setDiscipline(String discipline) {
		this.discipline = discipline;
	}
	
	
	public String getType() {
		// TODO Auto-generated method stub
		return "Student";
	}
	
}