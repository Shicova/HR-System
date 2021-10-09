package HR_Package;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JRadioButton;

public class Salary_Page extends JPanel {
	
	private JTextField T_Id_comp;
	private JTextField T_Position;
	private JTextField T_jobDay;
	private JTextField T_Department;
	private JTextField T_ChineseName;
	private JTextField T_EnglishName;
	private JTextField T_BankCode;
	private JTextField T_BankNumber;
	private JTextField T_Principal;
	private JTextField T_EmpInsurance;
	private JTextField T_Allowance;
	private JTextField T_HealthInsurance;
	private JTextField T_TotalAllowance;
	private JTextField T_SalaryFull;
	private ButtonGroup bg_panel4;
	private ButtonGroup bg_panel5;
	
	private JRadioButton M_Monthly;
	private JRadioButton M_Daily;
	private JRadioButton M_Hourly;
	private JRadioButton M_PieceCounting;
	private JRadioButton M_Remittance;
	private JRadioButton M_Cash;
	private JRadioButton M_Other;	
	private String salary_pay;
	private String salary_get;
	
	private JPanel panel9;
	
	private String salaryFull_string;
	private JTextField T_SalaryFull2;

	
	/**
	 * Create the panel.
	 */
	public Salary_Page(String currentUser) {
//		setBackground(SystemColor.menu);
		
		setBounds(35,43,670, 550);
		setLayout(null);
		setBorder(null);
		setOpaque(false);//背景透明
		
		//第一列
		JPanel panel1 = new JPanel();
		panel1.setLayout(null);
		panel1.setBounds(45, 50, 580, 50);
		panel1.setOpaque(false);//背景透明
		add(panel1);
				
		JLabel W_Id_comp = new JLabel("員工編號");
		W_Id_comp.setBounds(10, 10, 80, 30);
		W_Id_comp.setFont(new Font("Microsoft JhengHei", Font.BOLD, 20));
		panel1.add(W_Id_comp);
		
		T_Id_comp = new JTextField();
		T_Id_comp.setBounds(95, 10, 170, 30);
		T_Id_comp.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		T_Id_comp.setBorder(null);//去除邊框
		panel1.add(T_Id_comp);
		T_Id_comp.setColumns(10);
		
		JLabel W_jobDay = new JLabel("\u5230\u8077\u65E5\u671F");
		W_jobDay.setBounds(300, 10, 80, 30);
		W_jobDay.setFont(new Font("Microsoft JhengHei", Font.BOLD, 20));
		panel1.add(W_jobDay);
		
		T_jobDay = new JTextField();
		T_jobDay.setBounds(385, 10, 185, 30);
		T_jobDay.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		T_jobDay.setBorder(null);//去除邊框
		panel1.add(T_jobDay);
		T_jobDay.setColumns(10);
		
		
		
		JPanel panel2 = new JPanel();
		panel2.setLayout(null);
		panel2.setBounds(45, 150, 580, 50);
		panel2.setOpaque(false);//背景透明
		add(panel2);
				
		JLabel W_ChineseName = new JLabel("\u4E2D\u6587\u59D3\u540D");
		W_ChineseName.setBounds(10, 10, 80, 30);
		W_ChineseName.setFont(new Font("Microsoft JhengHei", Font.BOLD, 20));
		panel2.add(W_ChineseName);
		
		T_ChineseName = new JTextField();
		T_ChineseName.setBounds(95, 10, 170, 30);
		T_ChineseName.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		T_ChineseName.setBorder(null);//去除邊框
		panel2.add(T_ChineseName);
		T_ChineseName.setColumns(10);
		
		JLabel W_EnglishName = new JLabel("\u82F1\u6587\u59D3\u540D");
		W_EnglishName.setBounds(300, 10, 80, 30);
		W_EnglishName.setFont(new Font("Microsoft JhengHei", Font.BOLD, 20));
		panel2.add(W_EnglishName);
		
		T_EnglishName = new JTextField();
		T_EnglishName.setBounds(385, 10, 185, 30);
		T_EnglishName.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		T_EnglishName.setBorder(null);//去除邊框
		panel2.add(T_EnglishName);
		T_EnglishName.setColumns(10);		
		
		
		JPanel panel3 = new JPanel();
		panel3.setLayout(null);
		panel3.setOpaque(false);
		panel3.setBounds(45, 200, 580, 50);
		add(panel3);
		
		JLabel W_BankCode = new JLabel("\u9280\u884C\u4EE3\u865F");
		W_BankCode.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		W_BankCode.setBounds(10, 10, 80, 30);
		panel3.add(W_BankCode);
		
		T_BankCode = new JTextField();
		T_BankCode.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		T_BankCode.setColumns(10);
		T_BankCode.setBorder(null);
		T_BankCode.setBounds(95, 10, 170, 30);
		panel3.add(T_BankCode);
		
		JLabel W_BankNumber = new JLabel("\u5E33\u6236\u865F\u78BC");
		W_BankNumber.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		W_BankNumber.setBounds(300, 10, 80, 30);
		panel3.add(W_BankNumber);
		
		T_BankNumber = new JTextField();
		T_BankNumber.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		T_BankNumber.setColumns(10);
		T_BankNumber.setBorder(null);
		T_BankNumber.setBounds(385, 10, 185, 30);
		panel3.add(T_BankNumber);
		

		
		
		
		//薪資別
		JPanel panel4 = new JPanel();
		panel4.setLayout(null);
		panel4.setOpaque(false);
		panel4.setBounds(45, 250, 420, 50);
		add(panel4);
		
		JLabel W_Salary = new JLabel("\u85AA  \u8CC7  \u5225");
		W_Salary.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		W_Salary.setBounds(10, 10, 88, 30);
		panel4.add(W_Salary);
				
		M_Monthly = new JRadioButton("\u6708\u85AA");
		M_Monthly.setOpaque(false);
		M_Monthly.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		M_Monthly.setBounds(105, 15, 74, 23);
		panel4.add(M_Monthly);
		
		M_Daily = new JRadioButton("\u65E5\u85AA");
		M_Daily.setOpaque(false);
		M_Daily.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		M_Daily.setBounds(180, 15, 71, 23);
		panel4.add(M_Daily);
		
		M_Hourly = new JRadioButton("\u6642\u85AA");
		M_Hourly.setOpaque(false);
		M_Hourly.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		M_Hourly.setBounds(255, 15, 71, 23);
		panel4.add(M_Hourly);
		
		M_PieceCounting = new JRadioButton("\u8A08\u4EF6");
		M_PieceCounting.setOpaque(false);
		M_PieceCounting.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		M_PieceCounting.setBounds(330, 15, 74, 23);
		panel4.add(M_PieceCounting);
		
		//薪資別變單選
		bg_panel4=new ButtonGroup();
		bg_panel4.add(M_PieceCounting);
		bg_panel4.add(M_Monthly);
		bg_panel4.add(M_Daily);
		bg_panel4.add(M_Hourly);
		
		
		
		
		
		
		//領薪方式
		JPanel panel5 = new JPanel();
		panel5.setLayout(null);
		panel5.setOpaque(false);
		panel5.setBounds(45, 300, 420, 50);
		add(panel5);
		
		JLabel W_Paid = new JLabel("\u9818\u85AA\u65B9\u5F0F");
		W_Paid.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		W_Paid.setBounds(10, 10, 88, 30);
		panel5.add(W_Paid);
		
		
		M_Remittance = new JRadioButton("\u532F\u6B3E");
		M_Remittance.setOpaque(false);
		M_Remittance.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		M_Remittance.setBounds(105, 15, 74, 23);
		panel5.add(M_Remittance);
		
		M_Cash = new JRadioButton("\u4ED8\u73FE");
		M_Cash.setOpaque(false);
		M_Cash.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		M_Cash.setBounds(180, 15, 74, 23);
		panel5.add(M_Cash);

		M_Other = new JRadioButton("\u5176\u4ED6");
		M_Other.setOpaque(false);
		M_Other.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		M_Other.setBounds(255, 15, 71, 23);
		panel5.add(M_Other);
				
		//領薪方式變單選
		bg_panel5=new ButtonGroup();
		bg_panel5.add(M_Other);
		bg_panel5.add(M_Cash);
		bg_panel5.add(M_Remittance);
		
		
		
		
		
		
		
		
		JPanel panel6 = new JPanel();
		panel6.setLayout(null);
		panel6.setOpaque(false);
		panel6.setBounds(45, 100, 580, 50);
		add(panel6);
		
		JLabel W_Department = new JLabel("\u90E8       \u9580", SwingConstants.LEFT);
		W_Department.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		W_Department.setBounds(10, 10, 80, 30);
		panel6.add(W_Department);
		
		T_Department = new JTextField();
		T_Department.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		T_Department.setColumns(10);
		T_Department.setBorder(null);
		T_Department.setBounds(95, 10, 170, 30);
		panel6.add(T_Department);
		
		JLabel W_Position = new JLabel("\u8077       \u4F4D");
		W_Position.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		W_Position.setBounds(300, 10, 80, 30);
		panel6.add(W_Position);
		
		T_Position = new JTextField();
		T_Position.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		T_Position.setColumns(10);
		T_Position.setBorder(null);
		T_Position.setBounds(385, 10, 185, 30);
		panel6.add(T_Position);
		
		
		JPanel panel7 = new JPanel();
		panel7.setLayout(null);
		panel7.setOpaque(false);
		panel7.setBounds(45, 350, 580, 50);
		add(panel7);
		
		JLabel W_Principal = new JLabel("\u672C\u85AA\u91D1\u984D");
		W_Principal.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		W_Principal.setBounds(10, 10, 80, 30);
		panel7.add(W_Principal);
		
		T_Principal = new JTextField();
		T_Principal.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		T_Principal.setColumns(10);
		T_Principal.setBorder(null);
		T_Principal.setBounds(95, 10, 170, 30);
		panel7.add(T_Principal);
		
		JLabel W_EmpInsurance = new JLabel("\uFF0D\u52DE\u4FDD\u8CBB");
		W_EmpInsurance.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		W_EmpInsurance.setBounds(300, 10, 80, 30);
		panel7.add(W_EmpInsurance);
		
		T_EmpInsurance = new JTextField();
		T_EmpInsurance.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		T_EmpInsurance.setColumns(10);
		T_EmpInsurance.setBorder(null);
		T_EmpInsurance.setBounds(385, 10, 185, 30);
		panel7.add(T_EmpInsurance);
		
	
		JPanel panel8 = new JPanel();
		panel8.setLayout(null);
		panel8.setOpaque(false);
		panel8.setBounds(45, 400, 580, 50);
		add(panel8);
		
		JLabel W_Allowance = new JLabel("\u4F19\u98DF\u6D25\u8CBC");
		W_Allowance.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		W_Allowance.setBounds(10, 10, 80, 30);
		panel8.add(W_Allowance);
		
		T_Allowance = new JTextField();
		T_Allowance.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		T_Allowance.setColumns(10);
		T_Allowance.setBorder(null);
		T_Allowance.setBounds(95, 10, 170, 30);
		panel8.add(T_Allowance);
		
		JLabel W_HealthInsurance = new JLabel("\uFF0D\u5065\u4FDD\u8CBB");
		W_HealthInsurance.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		W_HealthInsurance.setBounds(300, 10, 80, 30);
		panel8.add(W_HealthInsurance);
		
		T_HealthInsurance = new JTextField();
		T_HealthInsurance.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		T_HealthInsurance.setColumns(10);
		T_HealthInsurance.setBorder(null);
		T_HealthInsurance.setBounds(385, 10, 185, 30);
		panel8.add(T_HealthInsurance);
		
		JPanel panel9 = new JPanel();
		panel9.setLayout(null);
		panel9.setOpaque(false);
		panel9.setBounds(45, 450, 580, 50);
		add(panel9);
		
		JLabel W_TotalAllowance = new JLabel("\u5176\u4ED6\u6D25\u8CBC");
		W_TotalAllowance.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		W_TotalAllowance.setBounds(10, 10, 80, 30);
		panel9.add(W_TotalAllowance);
		
		T_TotalAllowance = new JTextField();
		T_TotalAllowance.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		T_TotalAllowance.setColumns(10);
		T_TotalAllowance.setBorder(null);
		T_TotalAllowance.setBounds(95, 10, 170, 30);
		panel9.add(T_TotalAllowance);
		
		JLabel W_SalaryFull = new JLabel("\u5168\u85AA\u5408\u8A08");
		W_SalaryFull.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		W_SalaryFull.setBounds(300, 10, 80, 30);
		panel9.add(W_SalaryFull);
		
		
		T_SalaryFull = new JTextField();
		T_SalaryFull.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		T_SalaryFull.setColumns(10);
		T_SalaryFull.setBorder(null);
		T_SalaryFull.setBounds(385, 10, 185, 30);
		panel9.add(T_SalaryFull);
		
		
		
		  //半透明圓角視窗
        JLabel lblMainContent = new JLabel("");
		lblMainContent.setHorizontalAlignment(SwingConstants.CENTER);
		lblMainContent.setIcon(new ImageIcon(FrameDashboard.class.getResource("/img/JPanel-1.png")));
		lblMainContent.setBounds(0, 0, getWidth(), getHeight());
		//調整圖像大小符合外框
		lblMainContent.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/img/JPanel-1.png")).getImage().getScaledInstance(lblMainContent.getWidth(), lblMainContent.getHeight(), Image.SCALE_SMOOTH)));
		add(lblMainContent);
		
		
		
		
		T_Id_comp.setEditable(false); T_Id_comp.setDisabledTextColor(Color.BLACK);		
		T_Department.setEditable(false); T_Department.setDisabledTextColor(Color.BLACK);		
		T_jobDay.setEditable(false); T_jobDay.setDisabledTextColor(Color.BLACK);		
		T_ChineseName.setEditable(false); T_ChineseName.setDisabledTextColor(Color.BLACK);		
		T_EnglishName.setEditable(false);  T_EnglishName.setDisabledTextColor(Color.BLACK);		
		T_Position.setEditable(false);  T_Position.setDisabledTextColor(Color.BLACK);		
		T_BankCode.setEditable(false);  T_BankCode.setDisabledTextColor(Color.BLACK);		
		T_BankNumber.setEditable(false);  T_BankNumber.setDisabledTextColor(Color.BLACK);		
		
		T_Principal.setEditable(false);  T_Principal.setDisabledTextColor(Color.BLACK);		
		T_EmpInsurance.setEditable(false);  T_EmpInsurance.setDisabledTextColor(Color.BLACK);		
		T_Allowance.setEditable(false);  T_Allowance.setDisabledTextColor(Color.BLACK);		
		T_HealthInsurance.setEditable(false);  T_HealthInsurance.setDisabledTextColor(Color.BLACK);		
		T_TotalAllowance.setEditable(false);  T_TotalAllowance.setDisabledTextColor(Color.BLACK);		
		T_SalaryFull.setEditable(false);  T_SalaryFull.setDisabledTextColor(Color.BLACK);		
		
	
//		M_Monthly.setEnabled(false); 
//		M_Monthly.setForeground(Color.BLACK);
//		M_Daily.setEnabled(false); 		M_Daily.setForeground(Color.BLACK);
//		M_Hourly.setEnabled(false); M_Hourly.setForeground(Color.BLACK);
//		M_PieceCounting.setEnabled(false); M_PieceCounting.setForeground(Color.BLACK);
//		
//		M_Remittance.setEnabled(false); M_Remittance.setForeground(Color.BLACK);
//		M_Cash.setEnabled(false); M_Cash.setForeground(Color.BLACK);
//		M_Other.setEnabled(false); M_Other.setForeground(Color.BLACK);
		
		
		if(currentUser != null && currentUser != "") {
			SearchFromDatabase(currentUser);
		}
	}
		
        
	
	
	static Connection con() {
		try {
			String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
			String DB_URL = "jdbc:mysql://localhost:3306/HRsystem?"
                	+ "useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
			String USERNAME = "root";
		    String PASSWORD = "12345678";
			Class.forName(JDBC_DRIVER);
			return DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
		}catch (Exception e) {
			System.out.println("Connection Failed!" + e);
		}
		return null;
	}
	
	private void SearchFromDatabase(String beSelected) {
		Connection con = con();
		try {
			String search = "SELECT * FROM emp_treat WHERE id_comp = ?";
			PreparedStatement ps = con.prepareStatement(search);
			
			ps.setString(1, beSelected);			
			ps.execute();
			
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				T_Id_comp.setText(rs.getString("id_comp"));
				T_Department.setText(rs.getString("department"));								
				T_Position.setText(rs.getString("position"));								
				T_jobDay.setText(rs.getString("onduty"));								
				T_ChineseName.setText(rs.getString("name"));
				T_EnglishName.setText(rs.getString("name_EN"));
				T_BankCode.setText(rs.getString("bank_code"));
				T_BankNumber.setText(rs.getString("account"));
				
				T_Principal.setText(rs.getString("salary"));
				T_EmpInsurance.setText(rs.getString("emp_insurance"));
				T_Allowance.setText(rs.getString("bonus_food"));
				T_HealthInsurance.setText(rs.getString("health_Insurance"));
				T_TotalAllowance.setText(rs.getString("bonus_other"));			
				T_SalaryFull.setText(rs.getString("salary_total"));
							
				if(rs.getString("salary_get").equals("月薪")) {
					M_Monthly.setSelected(true);
					M_Monthly.setEnabled(true);
					M_Daily.setEnabled(false);
					M_Hourly.setEnabled(false);
					M_PieceCounting.setEnabled(false);
					
				}else if(rs.getString("salary_get").equals("日薪")){
					M_Daily.setSelected(true);
					M_Monthly.setEnabled(false);
					M_Daily.setEnabled(true);
					M_Hourly.setEnabled(false);
					M_PieceCounting.setEnabled(false);
					
				}else if(rs.getString("salary_get").equals("時薪")){		
					M_Hourly.setSelected(true);
					M_Monthly.setEnabled(false);
					M_Daily.setEnabled(false);
					M_Hourly.setEnabled(true);
					M_PieceCounting.setEnabled(false);
					
				}else{
					M_PieceCounting.setSelected(true);
					M_Monthly.setEnabled(false);
					M_Daily.setEnabled(false);
					M_Hourly.setEnabled(false);
					M_PieceCounting.setEnabled(true);
					}
					
				
				if(rs.getString("salary_pay").equals("匯款")) {
					M_Remittance.setSelected(true);
					M_Remittance.setEnabled(true);
					M_Cash.setEnabled(false);
					M_Other.setEnabled(false);
				}else if(rs.getString("salary_pay").equals("付現")) {
					M_Cash.setSelected(true);
					M_Remittance.setEnabled(false);
					M_Cash.setEnabled(true);
					M_Other.setEnabled(false);
				}else{
					M_Other.setSelected(true);
					M_Remittance.setEnabled(false);
					M_Cash.setEnabled(false);
					M_Other.setEnabled(true);
	
							
				}}
			else {
				
			}
	
			rs.close();
			ps.close();
			con.close();
			
		}catch (Exception e) {
			
			System.out.println("Error:" + e);
			JOptionPane.showMessageDialog(null, "請確認:\n1.所有欄位皆填寫完畢\n2.日期格式正確");
		}
	}
	
	private String CountSalary() {
		String input_Principal = T_Principal.getText();
		int value_Principal = Integer.parseInt(input_Principal);
		
		String input_Allowance = T_Allowance.getText();
		int value_Allowance = Integer.parseInt(input_Allowance);
		
		String input_TotalAllowance = T_TotalAllowance.getText();
		int value_TotalAllowance = Integer.parseInt(input_TotalAllowance);
		
		String input_EmpInsurance = T_EmpInsurance.getText();
		int value_EmpInsurance = Integer.parseInt(input_EmpInsurance);
		
		String input_HealthInsurance = T_HealthInsurance.getText();
		int value_HealthInsurance = Integer.parseInt(input_HealthInsurance);
		
		int salaryFull = (value_Principal+value_Allowance+value_TotalAllowance-value_EmpInsurance-value_HealthInsurance);
		String salaryFull_string = Integer.toString(salaryFull);
		

		T_SalaryFull2 = new JTextField(salaryFull_string);
		T_SalaryFull2.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		T_SalaryFull2.setColumns(10);
		T_SalaryFull2.setBorder(null);
		T_SalaryFull2.setBounds(0, 460, 115, 30);//430
		add(T_SalaryFull2);		
		
		
		return salaryFull_string;
	}
}