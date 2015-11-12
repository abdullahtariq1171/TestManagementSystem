package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class Login_DAO {
	/*
	public boolean login_success(String username, String password){		
	try{
		Connection conn = TMSDB.dbconn();
		String query = "select * from user where username = ? and password = ?";
		PreparedStatement pst = conn.prepareStatement(query);
		pst.setString(1, username);
		pst.setString(2, password);
		ResultSet rs = pst.executeQuery();			
		int count =0;
		while(rs.next()){
			count++;
		}
		pst.close();
		rs.close();
		if(count==1){				
			//conn.close();
			return true;
		}			
		return false;
		
		}catch(Exception e1){
			
			JOptionPane.showMessageDialog(null, e1);
			return false;
		}
	}
	*/
	
}