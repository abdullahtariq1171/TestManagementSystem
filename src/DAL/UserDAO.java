package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Data.Admin;
import Data.Student;
import Data.Teacher;
import Data.User;

public class UserDAO implements IUserDAO{

/*
	public int getuser(String username,User user){
		
		try{
			Connection conn = TMSDB.dbconn();
			String query = "select * from user where username = ?";
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setString(1, username);
			//pst.setString(2, password);
			ResultSet rs = pst.executeQuery();
			
			rs.next();
			
			if(rs.getInt(4)==2){
				String name=rs.getString(2);
				String uname=rs.getString(0);
				String pass=rs.getString(1);
				String rollno=rs.getString(3);
				
				rs.close();
				pst.close();
				user = new Student(name,uname,pass,rollno); 
				return 2;
			}
			else{	
				return 4;
			}
			}catch(Exception e1){
				
				JOptionPane.showMessageDialog(null, e1);
				return 4;
			}	
		}
*/

	@Override
	public Student getUser() {
		// TODO Auto-generated method stub
		try{
			Connection conn = TMSDB.dbconn();
			String query = "SELECT * FROM user where id='l13-4219'";
			PreparedStatement pst = conn.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			return new Student(rs.getString(0), rs.getString(1),rs.getString(2), rs.getInt(3),rs.getBoolean(4) ,rs.getString(6));
		}catch(Exception e1){
			JOptionPane.showMessageDialog(null, e1);
			return null;
		}
	}
	
	public User validateUser(String name,String pass)
	{
		try{
			Connection conn = TMSDB.dbconn();
			String query = "SELECT * FROM user where id='" + name + "' AND password='" + pass + "'";
			PreparedStatement pst = conn.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			if (rs.next()){//record exist
				User u = null;
				if (rs.getInt("type") == 0 ) { //its student
					u = new Student(rs.getString(1), rs.getString(2),rs.getString(3), rs.getInt(4),rs.getBoolean(5) ,rs.getString(7)); 			
				} else if (rs.getInt("type") == 1 ) { //its teacher
					u = new Teacher(rs.getString(1), rs.getString(2),rs.getString(3),rs.getBoolean(5), rs.getInt(4), rs.getString(7)); 			
				}else { //its student
					new Admin(rs.getString(1), rs.getString(2),rs.getString(3),rs.getBoolean(5), rs.getInt(4)); 			
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
}
