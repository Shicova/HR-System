package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class CreateTable {
	 
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost:3306/HRsystem"
    		+ "?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
  
    // DB username & password
    static final String USERNAME = "root";
    static final String PASSWORD = "12345678";
 
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try{
            
            Class.forName(JDBC_DRIVER);        
            conn = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
            stmt = conn.createStatement();
            String sql1 , sql2, sql3;
            
            sql1 = "CREATE TABLE Emp_Data " +
                    "(id_comp VARCHAR(20) not NULL, department VARCHAR(10), " +
                    "name VARCHAR(10), name_EN VARCHAR(20), id_num VARCHAR(10), " +
                    "onduty DATE , gender CHAR(1),  marital CHAR(1), " +
                    " birth DATE, phone CHAR(10), address VARCHAR(50) , "+
                    "school VARCHAR(10),  education VARCHAR(15),   " + 
                    " email VARCHAR(50),  PRIMARY KEY ( id_comp ))";
            
            sql2 = "CREATE TABLE Emp_Treat " +
                    "(id_comp VARCHAR(20) not NULL, " +            		
                    " onduty DATE , department VARCHAR(10), position VARCHAR(5) ," +                                        
                    " name VARCHAR(10), name_EN VARCHAR(20), bank_code CHAR(3),  account CHAR(14)," +
                    " salary_get CHAR(2) ,  salary_pay CHAR(2) , salary DOUBLE ,  " +
                    " emp_insurance DOUBLE, bonus_food DOUBLE , health_Insurance DOUBLE , bonus_other DOUBLE, " +
                    " salary_total DOUBLE, password VARCHAR(30),  rest_leave DOUBLE,  personal_leave DOUBLE,  sick_leave DOUBLE, " +
                                                                               
                    " PRIMARY KEY ( id_comp ))";
            
            sql3 = "CREATE TABLE Emp_News " +
            		"(subject VARCHAR(80) not NULL, " + 
            		" time DATE , department VARCHAR(10), explanation VARCHAR(500) ," +
            		" PRIMARY KEY ( subject ))";
         
           stmt.executeUpdate(sql1);
           stmt.executeUpdate(sql2);
           stmt.executeUpdate(sql3);
           
           stmt.close();
            conn.close();
        }catch(Exception e){           
        	e.printStackTrace();
        	}
        
        System.out.println("Exit create DB to Mysql DB Example!");
        }
}

