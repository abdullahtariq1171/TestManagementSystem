package DAL;

import java.sql.*;
import javax.swing.*;
public class TMSDB {

	Connection conn= null;
	
	public static Connection dbconn(){
		try{
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Moon\\workspace\\TestingManagementSystem\\DB\\TMSdb.sqlite");
			//JOptionPane.showMessageDialog(null, "Connection Successful");
			return conn;
		}		
		catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}
	
}
