package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import Data.Admin;
import Data.Student;
import Data.Teacher;
import Data.User;

public class UserDAO implements IUserDAO{
	public User validateUser(String name,String pass)
	{
		try{
			Connection conn = TMSDB.dbconn();
			String query = "SELECT * FROM users where id='" + name + "' AND password='" + pass + "'";
			PreparedStatement pst = conn.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			if (rs.next()){//record exist
				User u = null;
				if (rs.getInt("type") == 0 ) { //its student
					u = new Student(rs.getString(1), rs.getString(2),rs.getString(3), rs.getInt(4),rs.getBoolean(5) ,rs.getString(7)); 			
				} else if (rs.getInt("type") == 1 ) { //its teacher
					u = new Teacher(rs.getString(1), rs.getString(2),rs.getString(3), rs.getInt(4), rs.getBoolean(5), rs.getString(7)); 			
				}else { //its student
					u = new Admin(rs.getString(1), rs.getString(2),rs.getString(3), rs.getInt(4), rs.getBoolean(5));
				}
				return u;
			} 
			else{
				return null;
			}
		}catch(Exception e1){
			JOptionPane.showMessageDialog(null, e1);
			return null;
		}
	}	
	public String getUserType(String id)
	{
		String type = null;
		try{
			Connection conn = TMSDB.dbconn();
			String query = "SELECT u.type FROM users AS u where u.id='"+id+"'";
			PreparedStatement pst = conn.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			if (rs.next()){//record exist
				if (rs.getInt(1)==0)
					type = "Student";
				 else if(rs.getInt(1)==1) 
					type = "Teacher";
				else type = "Admin";			} 
		}catch(Exception e1){
			JOptionPane.showMessageDialog(null, e1);
		}
		return type;
	}
}
