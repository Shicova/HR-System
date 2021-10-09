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
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JRadioButton;

//import PageWork.GetEmpData;
//import PageWork.GetEmpTreat;
//import PageWork.PageQuery;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;

public class Salary_B_Page extends JPanel {
	// SQL設定
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost:3306/HRsystem?"
	                          + "useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
	static final String USERNAME = "root";
	static final String PASSWORD = "12345678";
	
	
	private JTextField T_Position;
	private JTextField T_ChineseName;
	private JTextField T_EnglishName;
	private JTextField T_BankCode;
	private JTextField T_BankNumber;
	JTextField T_Principal;
	JTextField T_EmpInsurance;
	JTextField T_Allowance;
	JTextField T_HealthInsurance;
	JTextField T_TotalAllowance;
	
	private JTextField T_SalaryFull;
	private ButtonGroup bg_panel5;
	private ButtonGroup bg_panel6;
	
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
	private JComboBox C_Id_comp ;
	private JComboBox C_Department;
	private JDateChooser Date_jobDay;
    
	
	
	
	/**
	 * Create the panel.
	 */
	public Salary_B_Page() {
		Connection con = con();
		Statement stmt = null;
		PreparedStatement pstmt = null;
		
		setBounds(35,43,670, 550);
		setLayout(null);
		setBorder(null);
		setOpaque(false);//背景透明
		
		try{
			Class.forName(JDBC_DRIVER);	            
			con = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
			stmt = con.createStatement();
		
			//第一列
			JPanel panel1 = new JPanel();
			panel1.setLayout(null);
			panel1.setBounds(45, 50, 580, 50);
			panel1.setOpaque(false);//背景透明
			add(panel1);
						
			/*部門 Department*/
			//部門_標籤		
			JLabel W_Department = new JLabel("\u90E8\u3000\u3000\u9580");
			W_Department.setBounds(10, 10, 80, 30);
			W_Department.setFont(new Font("Microsoft JhengHei", Font.BOLD, 20));
			panel1.add(W_Department);
			
			//部門_文字(下拉選單)
			String[] arr ={"--請選擇部門--"};
			C_Department = new JComboBox(arr);     /*建立「部門」的下拉式選單(空)*/
			ResultSet rs;			
			try {
				stmt = con.createStatement();
				rs = stmt.executeQuery("SELECT DISTINCT department FROM emp_treat");
				while(rs.next()) {
					C_Department.addItem(rs.getString("department"));  /*在下拉式選單中加入「部門」的項目*/
					}
				rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
					}
			
			//職位_標籤
			JLabel W_Position = new JLabel("\u8077\u3000\u3000\u4F4D");
			W_Position.setBounds(300, 10, 80, 30);
			W_Position.setFont(new Font("Microsoft JhengHei", Font.BOLD, 20));
			panel1.add(W_Position);
			//職位_文字欄
			T_Position = new JTextField();
			T_Position.setBounds(385, 10, 185, 30);
			T_Position.setFont(new Font("微軟正黑體", Font.BOLD, 20));
			T_Position.setBorder(null);//去除邊框
			panel1.add(T_Position);
//			T_Position.setColumns(10);
			
			//第二列框架
			JPanel panel2 = new JPanel();
			panel2.setLayout(null);
			panel2.setOpaque(false);
			panel2.setBounds(45, 100, 580, 50);
			add(panel2);
			//員工編號_標籤
			JLabel W_Id_comp = new JLabel("員工編號", SwingConstants.LEFT);
			W_Id_comp.setFont(new Font("微軟正黑體", Font.BOLD, 20));
			W_Id_comp.setBounds(10, 10, 80, 30);
			panel2.add(W_Id_comp);
			//員工編號_下拉式清單
			C_Id_comp = new JComboBox();
			C_Id_comp.setFont(new Font("微軟正黑體", Font.BOLD, 20));
			C_Id_comp.setBounds(95, 10, 170, 30);
			panel2.add(C_Id_comp);
			//到職日期_標籤
			JLabel W_jobDay = new JLabel("\u5230\u8077\u65E5\u671F");
			W_jobDay.setFont(new Font("微軟正黑體", Font.BOLD, 20));
			W_jobDay.setBounds(300, 10, 80, 30);
			panel2.add(W_jobDay);
			//到職日期_時間選擇器
			Date_jobDay = new JDateChooser();
			Date_jobDay.setFont(new Font("微軟正黑體", Font.BOLD, 20));
			Date_jobDay.setBounds(385, 10, 185, 30);
			panel2.add(Date_jobDay);
						
			//第三列框架
			JPanel panel3 = new JPanel();
			panel3.setLayout(null);
			panel3.setBounds(45, 150, 580, 50);
			panel3.setOpaque(false);//背景透明
			add(panel3);
			//中文姓名_標籤		
			JLabel W_ChineseName = new JLabel("中文姓名");
			W_ChineseName.setBounds(10, 10, 80, 30);
			W_ChineseName.setFont(new Font("Microsoft JhengHei", Font.BOLD, 20));
			panel3.add(W_ChineseName);
			//中文姓名_文字欄
			T_ChineseName = new JTextField();
			T_ChineseName.setBounds(95, 10, 170, 30);
			T_ChineseName.setFont(new Font("微軟正黑體", Font.BOLD, 20));
			T_ChineseName.setBorder(null);//去除邊框
			T_ChineseName.setEditable(false);
			panel3.add(T_ChineseName);
			T_ChineseName.setColumns(10);
			//英文姓名_標籤
			JLabel W_EnglishName = new JLabel("英文姓名");
			W_EnglishName.setBounds(300, 10, 80, 30);
			W_EnglishName.setFont(new Font("Microsoft JhengHei", Font.BOLD, 20));
			panel3.add(W_EnglishName);
			//英文姓名_文字欄
			T_EnglishName = new JTextField();
			T_EnglishName.setBounds(385, 10, 185, 30);
			T_EnglishName.setFont(new Font("微軟正黑體", Font.BOLD, 20));
			T_EnglishName.setBorder(null);//去除邊框
			T_EnglishName.setEditable(false);
			panel3.add(T_EnglishName);
			T_EnglishName.setColumns(10);		
			
			//第四列框架
			JPanel panel4 = new JPanel();
			panel4.setLayout(null);
			panel4.setOpaque(false);
			panel4.setBounds(45, 200, 580, 50);
			add(panel4);
			//銀行代碼_標籤
			JLabel W_BankCode = new JLabel("銀行代碼");
			W_BankCode.setFont(new Font("微軟正黑體", Font.BOLD, 20));
			W_BankCode.setBounds(10, 10, 80, 30);
			panel4.add(W_BankCode);
			//銀行代碼_文字欄
			T_BankCode = new JTextField();
			T_BankCode.setFont(new Font("微軟正黑體", Font.BOLD, 20));
			T_BankCode.setColumns(10);
			T_BankCode.setBorder(null);
			T_BankCode.setBounds(95, 10, 170, 30);
			panel4.add(T_BankCode);
			//帳戶號碼_標籤
			JLabel W_BankNumber = new JLabel("帳戶號碼");
			W_BankNumber.setFont(new Font("微軟正黑體", Font.BOLD, 20));
			W_BankNumber.setBounds(300, 10, 80, 30);
			panel4.add(W_BankNumber);
			//帳戶號碼_文字欄
			T_BankNumber = new JTextField();
			T_BankNumber.setFont(new Font("微軟正黑體", Font.BOLD, 20));
			T_BankNumber.setColumns(10);
			T_BankNumber.setBorder(null);
			T_BankNumber.setBounds(385, 10, 185, 30);
			panel4.add(T_BankNumber);
			
			//第五列框架
			JPanel panel5 = new JPanel();
			panel5.setLayout(null);
			panel5.setOpaque(false);
			panel5.setBounds(45, 250, 420, 50);
			add(panel5);
			//薪資別_標籤
			JLabel W_Salary = new JLabel("薪  資  別");
			W_Salary.setFont(new Font("微軟正黑體", Font.BOLD, 20));
			W_Salary.setBounds(10, 10, 88, 30);
			panel5.add(W_Salary);
			//薪資別_單選_月薪	
			M_Monthly = new JRadioButton("月薪");
			M_Monthly.setOpaque(false);
			M_Monthly.setFont(new Font("微軟正黑體", Font.BOLD, 20));
			M_Monthly.setBounds(105, 15, 74, 23);
			panel5.add(M_Monthly);
			//薪資別_單選_日薪
			M_Daily = new JRadioButton("日薪");
			M_Daily.setOpaque(false);
			M_Daily.setFont(new Font("微軟正黑體", Font.BOLD, 20));
			M_Daily.setBounds(180, 15, 71, 23);
			panel5.add(M_Daily);
			//薪資別_單選_時薪
			M_Hourly = new JRadioButton("時薪");
			M_Hourly.setOpaque(false);
			M_Hourly.setFont(new Font("微軟正黑體", Font.BOLD, 20));
			M_Hourly.setBounds(255, 15, 71, 23);
			panel5.add(M_Hourly);
			//薪資別_單選_計件
			M_PieceCounting = new JRadioButton("計件");
			M_PieceCounting.setOpaque(false);
			M_PieceCounting.setFont(new Font("微軟正黑體", Font.BOLD, 20));
			M_PieceCounting.setBounds(330, 15, 74, 23);
			panel5.add(M_PieceCounting);
			
			//薪資別變單選
			bg_panel5=new ButtonGroup();
			bg_panel5.add(M_PieceCounting);
			bg_panel5.add(M_Monthly);
			bg_panel5.add(M_Daily);
			bg_panel5.add(M_Hourly);
			
			//第六列框架
			JPanel panel6 = new JPanel();
			panel6.setLayout(null);
			panel6.setOpaque(false);
			panel6.setBounds(45, 300, 420, 50);
			add(panel6);
			//領薪方式_標籤
			JLabel W_Paid = new JLabel("領薪方式");
			W_Paid.setFont(new Font("微軟正黑體", Font.BOLD, 20));
			W_Paid.setBounds(10, 10, 88, 30);
			panel6.add(W_Paid);
			
			//領薪方式_單選_匯款
			M_Remittance = new JRadioButton("匯款");
			M_Remittance.setOpaque(false);
			M_Remittance.setFont(new Font("微軟正黑體", Font.BOLD, 20));
			M_Remittance.setBounds(105, 15, 74, 23);
			panel6.add(M_Remittance);
			//領薪方式_單選_付現
			M_Cash = new JRadioButton("付現");
			M_Cash.setOpaque(false);
			M_Cash.setFont(new Font("微軟正黑體", Font.BOLD, 20));
			M_Cash.setBounds(180, 15, 74, 23);
			panel6.add(M_Cash);
			//領薪方式_單選_其他
			M_Other = new JRadioButton("其他");
			M_Other.setOpaque(false);
			M_Other.setFont(new Font("微軟正黑體", Font.BOLD, 20));
			M_Other.setBounds(255, 15, 71, 23);
			panel6.add(M_Other);
					
			//領薪方式變單選
			bg_panel6 = new ButtonGroup();
			bg_panel6.add(M_Other);
			bg_panel6.add(M_Cash);
			bg_panel6.add(M_Remittance);
			
			//第七列框架
			JPanel panel7 = new JPanel();
			panel7.setLayout(null);
			panel7.setOpaque(false);
			panel7.setBounds(45, 350, 580, 50);
			add(panel7);
			//本薪金額_標籤
			JLabel W_Principal = new JLabel("本薪金額");
			W_Principal.setFont(new Font("微軟正黑體", Font.BOLD, 20));
			W_Principal.setBounds(10, 10, 80, 30);
			panel7.add(W_Principal);
			//本薪金額_文字欄
			T_Principal = new JTextField();
			T_Principal.setFont(new Font("微軟正黑體", Font.BOLD, 20));
			T_Principal.setColumns(10);
			T_Principal.setBorder(null);
			T_Principal.setBounds(95, 10, 170, 30);
			panel7.add(T_Principal);
			//勞保費_標籤
			JLabel W_EmpInsurance = new JLabel("- 勞保費");
			W_EmpInsurance.setFont(new Font("微軟正黑體", Font.BOLD, 20));
			W_EmpInsurance.setBounds(300, 10, 80, 30);
			panel7.add(W_EmpInsurance);
			//勞保費_文字欄
			T_EmpInsurance = new JTextField();
			T_EmpInsurance.setFont(new Font("微軟正黑體", Font.BOLD, 20));
			T_EmpInsurance.setColumns(10);
			T_EmpInsurance.setBorder(null);
			T_EmpInsurance.setBounds(385, 10, 185, 30);
			panel7.add(T_EmpInsurance);
			
			//第八列框架
			JPanel panel8 = new JPanel();
			panel8.setLayout(null);
			panel8.setOpaque(false);
			panel8.setBounds(45, 400, 580, 50);
			add(panel8);
			//伙食津貼_標籤
			JLabel W_Allowance = new JLabel("伙食津貼");
			W_Allowance.setFont(new Font("微軟正黑體", Font.BOLD, 20));
			W_Allowance.setBounds(10, 10, 80, 30);
			panel8.add(W_Allowance);
			//伙食津貼_文字欄
			T_Allowance = new JTextField();
			T_Allowance.setFont(new Font("微軟正黑體", Font.BOLD, 20));
			T_Allowance.setColumns(10);
			T_Allowance.setBorder(null);
			T_Allowance.setBounds(95, 10, 170, 30);
			panel8.add(T_Allowance);
			//健保費_標籤
			JLabel W_HealthInsurance = new JLabel("- 健保費");
			W_HealthInsurance.setFont(new Font("微軟正黑體", Font.BOLD, 20));
			W_HealthInsurance.setBounds(300, 10, 80, 30);
			panel8.add(W_HealthInsurance);
			//健保費_文字欄
			T_HealthInsurance = new JTextField();
			T_HealthInsurance.setFont(new Font("微軟正黑體", Font.BOLD, 20));
			T_HealthInsurance.setColumns(10);
			T_HealthInsurance.setBorder(null);
			T_HealthInsurance.setBounds(385, 10, 185, 30);
			panel8.add(T_HealthInsurance);
			
			//第九列框架
			JPanel panel9 = new JPanel();
			panel9.setLayout(null);
			panel9.setOpaque(false);
			panel9.setBounds(45, 450, 580, 50);
			add(panel9);
			//其他津貼_標籤
			JLabel W_TotalAllowance = new JLabel("其他津貼");
			W_TotalAllowance.setFont(new Font("微軟正黑體", Font.BOLD, 20));
			W_TotalAllowance.setBounds(10, 10, 80, 30);
			panel9.add(W_TotalAllowance);
			//其他津貼_文字欄
			T_TotalAllowance = new JTextField();
			T_TotalAllowance.setFont(new Font("微軟正黑體", Font.BOLD, 20));
			T_TotalAllowance.setColumns(10);
			T_TotalAllowance.setBorder(null);
			T_TotalAllowance.setBounds(95, 10, 170, 30);
			panel9.add(T_TotalAllowance);
			//全薪合計_標籤
			JLabel W_SalaryFull = new JLabel("全薪合計");
			W_SalaryFull.setFont(new Font("微軟正黑體", Font.BOLD, 20));
			W_SalaryFull.setBounds(300, 10, 80, 30);
			panel9.add(W_SalaryFull);
			
			//全薪合計_文字欄
			T_SalaryFull = new JTextField();
			T_SalaryFull.setFont(new Font("微軟正黑體", Font.BOLD, 20));
			T_SalaryFull.setColumns(10);
			T_SalaryFull.setBorder(null);
			T_SalaryFull.setEditable(false);
			T_SalaryFull.setBounds(385, 10, 115, 30);
			panel9.add(T_SalaryFull);
			
			
			//點「部門」時的觸發事件 →「人員編號」的下拉式選單			
			C_Department.addActionListener(new ActionListener() {      /*點擊「部門」的下拉式選單時，「人員編號」的下拉式選單的聯動*/
				public void actionPerformed(ActionEvent e) {					
					String search_depart = (String) C_Department.getSelectedItem();			
					
					if(C_Department.getSelectedIndex()==0) {
						T_ChineseName.setText("");				
						T_EnglishName.setText("");				
						Date_jobDay.setDate(null);				
//						T_Position.setText("");				
//						T_BankCode.setText("");				
//						T_BankNumber.setText("");										
//						bg_panel5.clearSelection();						
//						bg_panel6.clearSelection();						
//						T_Principal.setText("");				
//						T_EmpInsurance.setText("");				
//						T_Allowance.setText("");				
//						T_HealthInsurance.setText("");				
//						T_TotalAllowance.setText("");				
//						T_SalaryFull.setText("");
					}
										
					getIdCompFromDepart(search_depart);	
					
					}
				});
			C_Department.setBounds(95, 10, 170, 30);
			C_Department.setFont(new Font("Microsoft JhengHei", Font.BOLD, 20));
			C_Department.setBorder(null);//去除邊框
			panel1.add(C_Department);
			
			
			
			
			//點「人員編號」時的觸發事件1 → 從Emp_Data取三筆資料(部門、員編、姓名)	
			//點「人員編號」時的觸發事件2 → 從Emp_Treat取其他資料	
			C_Id_comp.addActionListener(new ActionListener() {      /*點擊「人員編號」的下拉式選單時，「中文姓名」的文字區域的聯動*/
				public void actionPerformed(ActionEvent e) {
					String search_emp_data = (String) C_Id_comp.getSelectedItem();			
					String search_emp_treat = (String) C_Id_comp.getSelectedItem();			
					getThreeDataFromIdComp(search_emp_data);	
					getElseFromIdComp(search_emp_treat);
						}
				}
			);
		
			//計算按鈕
			JButton Button_Confirm = new JButton("計算薪資");
			Button_Confirm.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					T_SalaryFull.setText(CountSalary());
				}
			});
			Button_Confirm.setBounds(500, 10, 70, 30);
			Button_Confirm.setBorder(null);
			panel9.add(Button_Confirm);
			Button_Confirm.setFont(new Font("微軟正黑體", Font.BOLD, 16));
			
			
			//新增資料按鈕
			JButton Button_Save = new JButton("\u65B0\u589E");
			Button_Save.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {		
					SaveToDatabase();											
					}			
				});
			Button_Save.setFont(new Font("微軟正黑體", Font.BOLD, 16));
			Button_Save.setBounds(545, 250, 70, 25);
			Button_Save.setBorder(null);
			add(Button_Save);
			
			//更新資料按鈕
			JButton Button_Update = new JButton("更新");
			Button_Update.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String update_ID = (String) C_Id_comp.getSelectedItem();			
					if(JOptionPane.showConfirmDialog(null,"確認更新資料嗎?","資料更新中", JOptionPane.YES_NO_OPTION) == 0){
						UpdateToDatabase(update_ID);
					}						
				}			
			});
			Button_Update.setFont(new Font("微軟正黑體", Font.BOLD, 16));
			Button_Update.setBounds(545, 287, 70, 25);
			Button_Update.setBorder(null);
			add(Button_Update);
			


			//刪除資料按鈕
			JButton Button_Delete = new JButton("刪除");
			Button_Delete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String update_ID = (String) C_Id_comp.getSelectedItem();			
					if(JOptionPane.showConfirmDialog(null,"確認刪除資料嗎?","資料刪除中", JOptionPane.YES_NO_OPTION) == 0){
						DeleteFromDatabase(update_ID);
					}						
				}			
			});
			Button_Delete.setFont(new Font("微軟正黑體", Font.BOLD, 16));
			Button_Delete.setBounds(545, 324, 70, 25);
			Button_Delete.setBorder(null);
			add(Button_Delete);
			
			
			
			//半透明圓角視窗
	        JLabel lblMainContent = new JLabel("");
			lblMainContent.setHorizontalAlignment(SwingConstants.CENTER);
			lblMainContent.setIcon(new ImageIcon(FrameDashboard.class.getResource("/img/JPanel-1.png")));
			lblMainContent.setBounds(0, 0, getWidth(), getHeight());
			//調整圖像大小符合外框
			lblMainContent.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/img/JPanel-1.png")).getImage().getScaledInstance(lblMainContent.getWidth(), lblMainContent.getHeight(), Image.SCALE_SMOOTH)));
			add(lblMainContent);
		

		
        
	
	    }catch(SQLException se){
	    	se.printStackTrace();
	    }catch(Exception e1){
	    	e1.printStackTrace();
	    }
//	    System.out.println("資料處理結束!");
	    
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
	

	private void SaveToDatabase() {
		Connection con = con();
		String update = "INSERT INTO Emp_Treat VALUES( ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
		
		try {	
			if (checkRedundant()==1) {
				JOptionPane.showMessageDialog(null, "此帳號已存在，請確認後重新輸入");
			}
			else {
				PreparedStatement ps = con.prepareStatement(update);			
				
				ps.setString(3, (String)C_Department.getSelectedItem());
				ps.setString(4, T_Position.getText());
				ps.setString(1, (String)C_Id_comp.getSelectedItem());
				ps.setDate(2, new java.sql.Date(Date_jobDay.getDate().getTime()));
				
				ps.setString(5, T_ChineseName.getText());
				ps.setString(6, T_EnglishName.getText());			
				ps.setString(7, T_BankCode.getText());
				ps.setString(8, T_BankNumber.getText());
				
				if(M_Monthly.isSelected()) { 
					salary_get="月薪";}
				else if(M_Daily.isSelected()) {
					salary_get="日薪";}
				else if(M_Hourly.isSelected()) {
					salary_get="時薪";}
				else if(M_PieceCounting.isSelected()) {
					salary_get="計件";}
				ps.setString(9, salary_get);
				
				if(M_Remittance.isSelected()){
					salary_pay="匯款";}
				else if(M_Cash.isSelected()){
					salary_pay="付現";}
				else if(M_Other.isSelected()){
					salary_pay="其他";}
				ps.setString(10, salary_pay);
				
				ps.setDouble(11, Double.valueOf(T_Principal.getText()));
				ps.setDouble(12, Double.valueOf(T_EmpInsurance.getText()));
				ps.setDouble(13, Double.valueOf(T_Allowance.getText()));
				ps.setDouble(14, Double.valueOf(T_HealthInsurance.getText()));
				ps.setDouble(15, Double.valueOf(T_TotalAllowance.getText()));
				ps.setDouble(16, Double.valueOf(T_SalaryFull.getText()));
				
/*------這裡有問題-------------------------------------------------------------------*/
				ps.setString(17, "0000");
				ps.setDouble(18, 0);
				ps.setDouble(19, 0);
				ps.setDouble(20, 0);
/*------這裡有問題-------------------------------------------------------------------*/				
				
				
				ps.execute();
				
				ps.close();
				con.close();
				
				JOptionPane.showMessageDialog(null, "新增人員資料成功！");
			}
			
		}catch (Exception e) {
			System.out.println("Error:" + e);
			System.out.println(e.getStackTrace());
			JOptionPane.showMessageDialog(null, "請確認所有欄位皆填寫完畢");	
		}
	}
	
	private void UpdateToDatabase(String beSelected) {
		Connection con = con();
		String update = "UPDATE Emp_Treat SET department=?, position=?, onduty=?,"
				+ " name=?, name_EN=?, bank_code=?, account=?, salary_get=?,"				
				+ " salary_pay=?, salary=?, emp_insurance=?, bonus_food=?,"
				+ " health_Insurance=?, bonus_other=?, salary_total=? WHERE id_comp =?";
		
		try {	
			if (checkRedundant()==0) {
				JOptionPane.showMessageDialog(null, "未選取人員編號，請再次操作");
				}
			else {
			PreparedStatement ps = con.prepareStatement(update);			
			ps.setString(1, (String)C_Department.getSelectedItem());
			ps.setString(2, T_Position.getText());
			ps.setDate(3, new java.sql.Date(Date_jobDay.getDate().getTime()));
			ps.setString(4, T_ChineseName.getText());
			ps.setString(5, T_EnglishName.getText());			
			ps.setString(6, T_BankCode.getText());
			ps.setString(7, T_BankNumber.getText());
			
			if(M_Monthly.isSelected()) 
				salary_get="月薪";
			else if(M_Daily.isSelected()) 
				salary_get="日薪";
			else if(M_Hourly.isSelected()) 
				salary_get="時薪";
			else if(M_PieceCounting.isSelected()) 
				salary_get="計件";
			ps.setString(8, salary_get);
			
			if(M_Remittance.isSelected()) 
				salary_pay="匯款";
			else if(M_Cash.isSelected()) 
				salary_pay="付現";
			else if(M_Other.isSelected()) 
				salary_pay="其他";
			ps.setString(9, salary_pay);
									
			ps.setDouble(10, Double.valueOf(T_Principal.getText()));
			ps.setDouble(11, Double.valueOf(T_EmpInsurance.getText()));
			ps.setDouble(12, Double.valueOf(T_Allowance.getText()));
			ps.setDouble(13, Double.valueOf(T_HealthInsurance.getText()));
			ps.setDouble(14, Double.valueOf(T_TotalAllowance.getText()));
			ps.setDouble(15, Double.valueOf(T_SalaryFull.getText()));

			ps.setString(16, beSelected);
						
			ps.execute();
	
			ps.close();
			con.close();
			
			JOptionPane.showMessageDialog(null, "更新人員資料成功！");
			}
			
		}catch (Exception e) {
			System.out.println("Error:" + e);
			JOptionPane.showMessageDialog(null, "請確認:\n1.所有欄位皆填寫完畢");	
			}
		}
	
	private void DeleteFromDatabase(String beSelected) {
		Connection con = con();
		try {
			if (checkRedundant()==0) {
				JOptionPane.showMessageDialog(null, "刪除失敗，此帳號不存在");
				}
			else {
			
			String sql = "DELETE FROM Emp_Treat WHERE id_comp = ?";
			PreparedStatement ps = con.prepareStatement(sql);
	
			ps.setString(1, beSelected);
			
			ps.execute();
			JOptionPane.showMessageDialog(null, "刪除人員資料成功！");
			
			C_Department.setSelectedIndex(0);
			Date_jobDay.setDate(null);
			T_ChineseName.setText("");				
			T_EnglishName.setText("");				
			T_Position.setText("");				
			T_BankCode.setText("");				
			T_BankNumber.setText("");
							
			bg_panel5.clearSelection();
			
			bg_panel6.clearSelection();
			
			T_Principal.setText("");				
			T_EmpInsurance.setText("");				
			T_Allowance.setText("");				
			T_HealthInsurance.setText("");				
			T_TotalAllowance.setText("");				
			T_SalaryFull.setText("");			
			
			ps.close();
			con.close();}
		}catch (Exception e) {
			System.out.println("Error:" + e);			
		}
	}
	
	private void getIdCompFromDepart(String beSelected) {
		C_Id_comp.removeAllItems();                    
		
		Connection con = con();					
		try {
			String Id_comp = "SELECT * FROM emp_data WHERE department = ?";			
			PreparedStatement ps = con.prepareStatement(Id_comp);
			
			ps.setString(1, beSelected);			
			ps.execute();
			
			ResultSet rs = ps.executeQuery();
//			ArrayList <String> id_comp_list = new ArrayList<String>();			
			while(rs.next()) {
				String s = rs.getString("id_comp");	
				C_Id_comp.addItem(s);					
				}
			}catch (Exception e) {			
				System.out.println("Error:" + e);
				}
		}
	
	private void getThreeDataFromIdComp(String beSelected) {		
		Connection con = con();					
		try {
			String Id_comp = "SELECT * FROM Emp_Data WHERE id_comp = ?";			
			PreparedStatement ps = con.prepareStatement(Id_comp);
			
			ps.setString(1, beSelected);			
			ps.execute();
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {						
				Date_jobDay.setDate(rs.getDate("onduty"));
				T_ChineseName.setText(rs.getString("name"));
				T_EnglishName.setText(rs.getString("name_EN"));
			}
		}catch (Exception e) {			
			System.out.println("Error:" + e);
		}
	}
	
	private void getElseFromIdComp(String beSelected) {		
		Connection con = con();					
		try {
			String Id_comp = "SELECT * FROM Emp_Treat WHERE id_comp = ?";			
			PreparedStatement ps = con.prepareStatement(Id_comp);
			
			ps.setString(1, beSelected);			
			ps.execute();
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {	
				T_Position.setText(rs.getString("position"));				
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
					}else if(rs.getString("salary_get").equals("日薪")){
						M_Daily.setSelected(true);
					}else if(rs.getString("salary_get").equals("時薪")){
						M_Hourly.setSelected(true);
					}else{
						M_PieceCounting.setSelected(true);
						}
					
				
				if(rs.getString("salary_pay").equals("匯款")) {
					M_Remittance.setSelected(true);
				}else if(rs.getString("salary_pay").equals("付現")) {
					M_Cash.setSelected(true);
				}else{
					M_Other.setSelected(true);
					}				
						
			}
			else {
				T_Position.setText("");				
				T_BankCode.setText("");				
				T_BankNumber.setText("");
								
				bg_panel5.clearSelection();
				
				bg_panel6.clearSelection();
				
				T_Principal.setText("");				
				T_EmpInsurance.setText("");				
				T_Allowance.setText("");				
				T_HealthInsurance.setText("");				
				T_TotalAllowance.setText("");				
				T_SalaryFull.setText("");			
				}			
			}catch (Exception e) {			
			System.out.println("Error:" + e);
		}
	}

	
	public String CountSalary() {
		
		String input_Principal = T_Principal.getText();
		float value_Principal = Float.parseFloat(input_Principal);
		
		String input_Allowance = T_Allowance.getText();
		float value_Allowance = Float.parseFloat(input_Allowance);
		
		String input_TotalAllowance = T_TotalAllowance.getText();
		float value_TotalAllowance = Float.parseFloat(input_TotalAllowance);
		
		String input_EmpInsurance = T_EmpInsurance.getText();
		float value_EmpInsurance = Float.parseFloat(input_EmpInsurance);
		
		String input_HealthInsurance = T_HealthInsurance.getText();
		float value_HealthInsurance = Float.parseFloat(input_HealthInsurance);
		
		float salaryFull = (value_Principal+value_Allowance+value_TotalAllowance-value_EmpInsurance-value_HealthInsurance);
		String salaryFull_string = Float.toString(salaryFull);
			
		return salaryFull_string;
	}
	//查使用者是否存在
		public int checkRedundant(){    
	        String checkSQL = "select * from emp_treat "; 
	        int flag = 0;
	        Connection con = con();
	        try {
	        	
	        	Statement st = con.createStatement(); 
	            ResultSet rs = st.executeQuery(checkSQL); 
	            while (rs.next()) {
	                 if (rs.getString("id_comp").equals((String) C_Id_comp.getSelectedItem())) 	                
	                     flag = 1;
	            }
	        } catch (SQLException e) {

	        }
	        return flag;//有重複使用者回傳1
	    }
		
}


