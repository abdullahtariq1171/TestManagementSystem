package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import Data.Course;

public class CourseDAO implements ICourseDAO{

	public Course[] getCourses(String userID)
	{
		Course[] c = null;
		try{
			Connection conn = TMSDB.dbconn();
			String type = new UserDAO().getUserType(userID);
			String query = "", countQuery = "";
			if (type.equals("Admin")){ //only admin have access to all the course
				query = "SELECT * FROM courses";
				countQuery = "SELECT COUNT(*) FROM courses";
			}
			else{
				//query = "SELECT c.* FROM users AS u JOIN course_user_relations AS ucr ON u.id=ucr.user_id  JOIN courses AS c ON c.code=ucr.course_code WHERE u.id='"+userID+"'"; //"+userID+"'"
				//countQuery = "SELECT COUNT(*) FROM users AS u JOIN course_user_relations AS ucr ON u.id=ucr.user_id  JOIN courses AS c ON c.code=ucr.course_code WHERE u.id='"+userID+"'";
				
				query = "SELECT c.name, c.code from courses AS c, course_user_relations AS cr where c.code = cr.course_code AND cr.user_id='"+userID+"'";
				countQuery = "SELECT COUNT(*) from courses AS c, course_user_relations AS cr where c.code = cr.course_code AND cr.user_id='"+userID+"'";
			}
			
			PreparedStatement pst = conn.prepareStatement(query);
			ResultSet rs = pst.executeQuery();

			pst = conn.prepareStatement(countQuery);
			ResultSet rsC = pst.executeQuery();
						
			int rowcount = rsC.getInt(1);			
			c =new Course[rowcount];
			int i=0;
			while(rs.next())
			{
				c[i] = new Course(rs.getString(1),rs.getString(2));
				++i;
			}
		}catch(Exception e1){
			JOptionPane.showMessageDialog(null, e1);
		}
		return c;
	}
}
