package DataBase;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class CreateDataBase {

	  // MySQL 8.0 �H�W���� - JDBC Driver & DB URL
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost:3306/"
    		+ "?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
  
    // DB username & password
    static final String USERNAME = "root";
    static final String PASSWORD = "12345678";
 
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try{
            //  JDBC Driver register
            Class.forName(JDBC_DRIVER);
        
            // link
            System.out.println("prepare connect DB...");
            conn = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
        
            // Mysql select
            System.out.println(" �غc�l.�ò���Statement����...");
            stmt = conn.createStatement();
            String sql ;
                        
            sql="CREATE DATABASE HRsystem";
                        
            //update & delete
            stmt.executeUpdate(sql);
            
            stmt.close();
            conn.close();
        }catch(Exception e){
            // handle Class.forName error
            e.printStackTrace();
        }finally{
            // �����B�z�A�����@�Ǹ��
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        System.out.println("Exit create DB to Mysql DB Example!");
		
        }

}
