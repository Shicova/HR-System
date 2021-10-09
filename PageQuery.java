package PageWork;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;



public class PageQuery {
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost:3306/HRsystem?"
		                    	+ "useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
	static final String USERNAME = "root";
	static final String PASSWORD = "12345678";
	
	public Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
		}catch(SQLException se){
			se.printStackTrace();
		}catch(Exception e1){
			e1.printStackTrace();
		}
		System.out.println("資料處理結束!");		   	
		return conn;		
	}
	
	
	
	public String From_IdComp_get_Name(String beSelected){
		String x = null ;
		Connection conn = getConnection(); 
		PreparedStatement pstmt;
		Statement stmt;
		ResultSet rs;
		
		try {
			pstmt = conn.prepareStatement("SELECT `id_comp`, `name` FROM Emp_Treat WHERE id_comp = ?");
			pstmt.setString(1, beSelected);			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				x = new String(rs.getString("name"));
			}						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return x;			
	}


public String From_Name_get_IdComp(String beSelected){
	String x = null ;
	Connection conn = getConnection(); 
	PreparedStatement pstmt;
	Statement stmt;
	ResultSet rs;
	
	try {
		pstmt = conn.prepareStatement("SELECT `id_comp`, `name` FROM Emp_Treat WHERE name = ?");
		pstmt.setString(1, beSelected);			
		rs = pstmt.executeQuery();
		
		while (rs.next()) {
			x = new String(rs.getString("id_comp"));
		}						
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}		
	return x;			
}
}
	







