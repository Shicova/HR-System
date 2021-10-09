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
	// SQL�]�w
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
		setOpaque(false);//�I���z��
		
		try{
			Class.forName(JDBC_DRIVER);	            
			con = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
			stmt = con.createStatement();
		
			//�Ĥ@�C
			JPanel panel1 = new JPanel();
			panel1.setLayout(null);
			panel1.setBounds(45, 50, 580, 50);
			panel1.setOpaque(false);//�I���z��
			add(panel1);
						
			/*���� Department*/
			//����_����		
			JLabel W_Department = new JLabel("\u90E8\u3000\u3000\u9580");
			W_Department.setBounds(10, 10, 80, 30);
			W_Department.setFont(new Font("Microsoft JhengHei", Font.BOLD, 20));
			panel1.add(W_Department);
			
			//����_��r(�U�Կ��)
			String[] arr ={"--�п�ܳ���--"};
			C_Department = new JComboBox(arr);     /*�إߡu�����v���U�Ԧ����(��)*/
			ResultSet rs;			
			try {
				stmt = con.createStatement();
				rs = stmt.executeQuery("SELECT DISTINCT department FROM emp_treat");
				while(rs.next()) {
					C_Department.addItem(rs.getString("department"));  /*�b�U�Ԧ���椤�[�J�u�����v������*/
					}
				rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
					}
			
			//¾��_����
			JLabel W_Position = new JLabel("\u8077\u3000\u3000\u4F4D");
			W_Position.setBounds(300, 10, 80, 30);
			W_Position.setFont(new Font("Microsoft JhengHei", Font.BOLD, 20));
			panel1.add(W_Position);
			//¾��_��r��
			T_Position = new JTextField();
			T_Position.setBounds(385, 10, 185, 30);
			T_Position.setFont(new Font("�L�n������", Font.BOLD, 20));
			T_Position.setBorder(null);//�h�����
			panel1.add(T_Position);
//			T_Position.setColumns(10);
			
			//�ĤG�C�ج[
			JPanel panel2 = new JPanel();
			panel2.setLayout(null);
			panel2.setOpaque(false);
			panel2.setBounds(45, 100, 580, 50);
			add(panel2);
			//���u�s��_����
			JLabel W_Id_comp = new JLabel("���u�s��", SwingConstants.LEFT);
			W_Id_comp.setFont(new Font("�L�n������", Font.BOLD, 20));
			W_Id_comp.setBounds(10, 10, 80, 30);
			panel2.add(W_Id_comp);
			//���u�s��_�U�Ԧ��M��
			C_Id_comp = new JComboBox();
			C_Id_comp.setFont(new Font("�L�n������", Font.BOLD, 20));
			C_Id_comp.setBounds(95, 10, 170, 30);
			panel2.add(C_Id_comp);
			//��¾���_����
			JLabel W_jobDay = new JLabel("\u5230\u8077\u65E5\u671F");
			W_jobDay.setFont(new Font("�L�n������", Font.BOLD, 20));
			W_jobDay.setBounds(300, 10, 80, 30);
			panel2.add(W_jobDay);
			//��¾���_�ɶ���ܾ�
			Date_jobDay = new JDateChooser();
			Date_jobDay.setFont(new Font("�L�n������", Font.BOLD, 20));
			Date_jobDay.setBounds(385, 10, 185, 30);
			panel2.add(Date_jobDay);
						
			//�ĤT�C�ج[
			JPanel panel3 = new JPanel();
			panel3.setLayout(null);
			panel3.setBounds(45, 150, 580, 50);
			panel3.setOpaque(false);//�I���z��
			add(panel3);
			//����m�W_����		
			JLabel W_ChineseName = new JLabel("����m�W");
			W_ChineseName.setBounds(10, 10, 80, 30);
			W_ChineseName.setFont(new Font("Microsoft JhengHei", Font.BOLD, 20));
			panel3.add(W_ChineseName);
			//����m�W_��r��
			T_ChineseName = new JTextField();
			T_ChineseName.setBounds(95, 10, 170, 30);
			T_ChineseName.setFont(new Font("�L�n������", Font.BOLD, 20));
			T_ChineseName.setBorder(null);//�h�����
			T_ChineseName.setEditable(false);
			panel3.add(T_ChineseName);
			T_ChineseName.setColumns(10);
			//�^��m�W_����
			JLabel W_EnglishName = new JLabel("�^��m�W");
			W_EnglishName.setBounds(300, 10, 80, 30);
			W_EnglishName.setFont(new Font("Microsoft JhengHei", Font.BOLD, 20));
			panel3.add(W_EnglishName);
			//�^��m�W_��r��
			T_EnglishName = new JTextField();
			T_EnglishName.setBounds(385, 10, 185, 30);
			T_EnglishName.setFont(new Font("�L�n������", Font.BOLD, 20));
			T_EnglishName.setBorder(null);//�h�����
			T_EnglishName.setEditable(false);
			panel3.add(T_EnglishName);
			T_EnglishName.setColumns(10);		
			
			//�ĥ|�C�ج[
			JPanel panel4 = new JPanel();
			panel4.setLayout(null);
			panel4.setOpaque(false);
			panel4.setBounds(45, 200, 580, 50);
			add(panel4);
			//�Ȧ�N�X_����
			JLabel W_BankCode = new JLabel("�Ȧ�N�X");
			W_BankCode.setFont(new Font("�L�n������", Font.BOLD, 20));
			W_BankCode.setBounds(10, 10, 80, 30);
			panel4.add(W_BankCode);
			//�Ȧ�N�X_��r��
			T_BankCode = new JTextField();
			T_BankCode.setFont(new Font("�L�n������", Font.BOLD, 20));
			T_BankCode.setColumns(10);
			T_BankCode.setBorder(null);
			T_BankCode.setBounds(95, 10, 170, 30);
			panel4.add(T_BankCode);
			//�b�ḹ�X_����
			JLabel W_BankNumber = new JLabel("�b�ḹ�X");
			W_BankNumber.setFont(new Font("�L�n������", Font.BOLD, 20));
			W_BankNumber.setBounds(300, 10, 80, 30);
			panel4.add(W_BankNumber);
			//�b�ḹ�X_��r��
			T_BankNumber = new JTextField();
			T_BankNumber.setFont(new Font("�L�n������", Font.BOLD, 20));
			T_BankNumber.setColumns(10);
			T_BankNumber.setBorder(null);
			T_BankNumber.setBounds(385, 10, 185, 30);
			panel4.add(T_BankNumber);
			
			//�Ĥ��C�ج[
			JPanel panel5 = new JPanel();
			panel5.setLayout(null);
			panel5.setOpaque(false);
			panel5.setBounds(45, 250, 420, 50);
			add(panel5);
			//�~��O_����
			JLabel W_Salary = new JLabel("�~  ��  �O");
			W_Salary.setFont(new Font("�L�n������", Font.BOLD, 20));
			W_Salary.setBounds(10, 10, 88, 30);
			panel5.add(W_Salary);
			//�~��O_���_���~	
			M_Monthly = new JRadioButton("���~");
			M_Monthly.setOpaque(false);
			M_Monthly.setFont(new Font("�L�n������", Font.BOLD, 20));
			M_Monthly.setBounds(105, 15, 74, 23);
			panel5.add(M_Monthly);
			//�~��O_���_���~
			M_Daily = new JRadioButton("���~");
			M_Daily.setOpaque(false);
			M_Daily.setFont(new Font("�L�n������", Font.BOLD, 20));
			M_Daily.setBounds(180, 15, 71, 23);
			panel5.add(M_Daily);
			//�~��O_���_���~
			M_Hourly = new JRadioButton("���~");
			M_Hourly.setOpaque(false);
			M_Hourly.setFont(new Font("�L�n������", Font.BOLD, 20));
			M_Hourly.setBounds(255, 15, 71, 23);
			panel5.add(M_Hourly);
			//�~��O_���_�p��
			M_PieceCounting = new JRadioButton("�p��");
			M_PieceCounting.setOpaque(false);
			M_PieceCounting.setFont(new Font("�L�n������", Font.BOLD, 20));
			M_PieceCounting.setBounds(330, 15, 74, 23);
			panel5.add(M_PieceCounting);
			
			//�~��O�ܳ��
			bg_panel5=new ButtonGroup();
			bg_panel5.add(M_PieceCounting);
			bg_panel5.add(M_Monthly);
			bg_panel5.add(M_Daily);
			bg_panel5.add(M_Hourly);
			
			//�Ĥ��C�ج[
			JPanel panel6 = new JPanel();
			panel6.setLayout(null);
			panel6.setOpaque(false);
			panel6.setBounds(45, 300, 420, 50);
			add(panel6);
			//���~�覡_����
			JLabel W_Paid = new JLabel("���~�覡");
			W_Paid.setFont(new Font("�L�n������", Font.BOLD, 20));
			W_Paid.setBounds(10, 10, 88, 30);
			panel6.add(W_Paid);
			
			//���~�覡_���_�״�
			M_Remittance = new JRadioButton("�״�");
			M_Remittance.setOpaque(false);
			M_Remittance.setFont(new Font("�L�n������", Font.BOLD, 20));
			M_Remittance.setBounds(105, 15, 74, 23);
			panel6.add(M_Remittance);
			//���~�覡_���_�I�{
			M_Cash = new JRadioButton("�I�{");
			M_Cash.setOpaque(false);
			M_Cash.setFont(new Font("�L�n������", Font.BOLD, 20));
			M_Cash.setBounds(180, 15, 74, 23);
			panel6.add(M_Cash);
			//���~�覡_���_��L
			M_Other = new JRadioButton("��L");
			M_Other.setOpaque(false);
			M_Other.setFont(new Font("�L�n������", Font.BOLD, 20));
			M_Other.setBounds(255, 15, 71, 23);
			panel6.add(M_Other);
					
			//���~�覡�ܳ��
			bg_panel6 = new ButtonGroup();
			bg_panel6.add(M_Other);
			bg_panel6.add(M_Cash);
			bg_panel6.add(M_Remittance);
			
			//�ĤC�C�ج[
			JPanel panel7 = new JPanel();
			panel7.setLayout(null);
			panel7.setOpaque(false);
			panel7.setBounds(45, 350, 580, 50);
			add(panel7);
			//���~���B_����
			JLabel W_Principal = new JLabel("���~���B");
			W_Principal.setFont(new Font("�L�n������", Font.BOLD, 20));
			W_Principal.setBounds(10, 10, 80, 30);
			panel7.add(W_Principal);
			//���~���B_��r��
			T_Principal = new JTextField();
			T_Principal.setFont(new Font("�L�n������", Font.BOLD, 20));
			T_Principal.setColumns(10);
			T_Principal.setBorder(null);
			T_Principal.setBounds(95, 10, 170, 30);
			panel7.add(T_Principal);
			//�ҫO�O_����
			JLabel W_EmpInsurance = new JLabel("- �ҫO�O");
			W_EmpInsurance.setFont(new Font("�L�n������", Font.BOLD, 20));
			W_EmpInsurance.setBounds(300, 10, 80, 30);
			panel7.add(W_EmpInsurance);
			//�ҫO�O_��r��
			T_EmpInsurance = new JTextField();
			T_EmpInsurance.setFont(new Font("�L�n������", Font.BOLD, 20));
			T_EmpInsurance.setColumns(10);
			T_EmpInsurance.setBorder(null);
			T_EmpInsurance.setBounds(385, 10, 185, 30);
			panel7.add(T_EmpInsurance);
			
			//�ĤK�C�ج[
			JPanel panel8 = new JPanel();
			panel8.setLayout(null);
			panel8.setOpaque(false);
			panel8.setBounds(45, 400, 580, 50);
			add(panel8);
			//�뭹�z�K_����
			JLabel W_Allowance = new JLabel("�뭹�z�K");
			W_Allowance.setFont(new Font("�L�n������", Font.BOLD, 20));
			W_Allowance.setBounds(10, 10, 80, 30);
			panel8.add(W_Allowance);
			//�뭹�z�K_��r��
			T_Allowance = new JTextField();
			T_Allowance.setFont(new Font("�L�n������", Font.BOLD, 20));
			T_Allowance.setColumns(10);
			T_Allowance.setBorder(null);
			T_Allowance.setBounds(95, 10, 170, 30);
			panel8.add(T_Allowance);
			//���O�O_����
			JLabel W_HealthInsurance = new JLabel("- ���O�O");
			W_HealthInsurance.setFont(new Font("�L�n������", Font.BOLD, 20));
			W_HealthInsurance.setBounds(300, 10, 80, 30);
			panel8.add(W_HealthInsurance);
			//���O�O_��r��
			T_HealthInsurance = new JTextField();
			T_HealthInsurance.setFont(new Font("�L�n������", Font.BOLD, 20));
			T_HealthInsurance.setColumns(10);
			T_HealthInsurance.setBorder(null);
			T_HealthInsurance.setBounds(385, 10, 185, 30);
			panel8.add(T_HealthInsurance);
			
			//�ĤE�C�ج[
			JPanel panel9 = new JPanel();
			panel9.setLayout(null);
			panel9.setOpaque(false);
			panel9.setBounds(45, 450, 580, 50);
			add(panel9);
			//��L�z�K_����
			JLabel W_TotalAllowance = new JLabel("��L�z�K");
			W_TotalAllowance.setFont(new Font("�L�n������", Font.BOLD, 20));
			W_TotalAllowance.setBounds(10, 10, 80, 30);
			panel9.add(W_TotalAllowance);
			//��L�z�K_��r��
			T_TotalAllowance = new JTextField();
			T_TotalAllowance.setFont(new Font("�L�n������", Font.BOLD, 20));
			T_TotalAllowance.setColumns(10);
			T_TotalAllowance.setBorder(null);
			T_TotalAllowance.setBounds(95, 10, 170, 30);
			panel9.add(T_TotalAllowance);
			//���~�X�p_����
			JLabel W_SalaryFull = new JLabel("���~�X�p");
			W_SalaryFull.setFont(new Font("�L�n������", Font.BOLD, 20));
			W_SalaryFull.setBounds(300, 10, 80, 30);
			panel9.add(W_SalaryFull);
			
			//���~�X�p_��r��
			T_SalaryFull = new JTextField();
			T_SalaryFull.setFont(new Font("�L�n������", Font.BOLD, 20));
			T_SalaryFull.setColumns(10);
			T_SalaryFull.setBorder(null);
			T_SalaryFull.setEditable(false);
			T_SalaryFull.setBounds(385, 10, 115, 30);
			panel9.add(T_SalaryFull);
			
			
			//�I�u�����v�ɪ�Ĳ�o�ƥ� ���u�H���s���v���U�Ԧ����			
			C_Department.addActionListener(new ActionListener() {      /*�I���u�����v���U�Ԧ����ɡA�u�H���s���v���U�Ԧ���檺�p��*/
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
			C_Department.setBorder(null);//�h�����
			panel1.add(C_Department);
			
			
			
			
			//�I�u�H���s���v�ɪ�Ĳ�o�ƥ�1 �� �qEmp_Data���T�����(�����B���s�B�m�W)	
			//�I�u�H���s���v�ɪ�Ĳ�o�ƥ�2 �� �qEmp_Treat����L���	
			C_Id_comp.addActionListener(new ActionListener() {      /*�I���u�H���s���v���U�Ԧ����ɡA�u����m�W�v����r�ϰ쪺�p��*/
				public void actionPerformed(ActionEvent e) {
					String search_emp_data = (String) C_Id_comp.getSelectedItem();			
					String search_emp_treat = (String) C_Id_comp.getSelectedItem();			
					getThreeDataFromIdComp(search_emp_data);	
					getElseFromIdComp(search_emp_treat);
						}
				}
			);
		
			//�p����s
			JButton Button_Confirm = new JButton("�p���~��");
			Button_Confirm.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					T_SalaryFull.setText(CountSalary());
				}
			});
			Button_Confirm.setBounds(500, 10, 70, 30);
			Button_Confirm.setBorder(null);
			panel9.add(Button_Confirm);
			Button_Confirm.setFont(new Font("�L�n������", Font.BOLD, 16));
			
			
			//�s�W��ƫ��s
			JButton Button_Save = new JButton("\u65B0\u589E");
			Button_Save.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {		
					SaveToDatabase();											
					}			
				});
			Button_Save.setFont(new Font("�L�n������", Font.BOLD, 16));
			Button_Save.setBounds(545, 250, 70, 25);
			Button_Save.setBorder(null);
			add(Button_Save);
			
			//��s��ƫ��s
			JButton Button_Update = new JButton("��s");
			Button_Update.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String update_ID = (String) C_Id_comp.getSelectedItem();			
					if(JOptionPane.showConfirmDialog(null,"�T�{��s��ƶ�?","��Ƨ�s��", JOptionPane.YES_NO_OPTION) == 0){
						UpdateToDatabase(update_ID);
					}						
				}			
			});
			Button_Update.setFont(new Font("�L�n������", Font.BOLD, 16));
			Button_Update.setBounds(545, 287, 70, 25);
			Button_Update.setBorder(null);
			add(Button_Update);
			


			//�R����ƫ��s
			JButton Button_Delete = new JButton("�R��");
			Button_Delete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String update_ID = (String) C_Id_comp.getSelectedItem();			
					if(JOptionPane.showConfirmDialog(null,"�T�{�R����ƶ�?","��ƧR����", JOptionPane.YES_NO_OPTION) == 0){
						DeleteFromDatabase(update_ID);
					}						
				}			
			});
			Button_Delete.setFont(new Font("�L�n������", Font.BOLD, 16));
			Button_Delete.setBounds(545, 324, 70, 25);
			Button_Delete.setBorder(null);
			add(Button_Delete);
			
			
			
			//�b�z���ꨤ����
	        JLabel lblMainContent = new JLabel("");
			lblMainContent.setHorizontalAlignment(SwingConstants.CENTER);
			lblMainContent.setIcon(new ImageIcon(FrameDashboard.class.getResource("/img/JPanel-1.png")));
			lblMainContent.setBounds(0, 0, getWidth(), getHeight());
			//�վ�Ϲ��j�p�ŦX�~��
			lblMainContent.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/img/JPanel-1.png")).getImage().getScaledInstance(lblMainContent.getWidth(), lblMainContent.getHeight(), Image.SCALE_SMOOTH)));
			add(lblMainContent);
		

		
        
	
	    }catch(SQLException se){
	    	se.printStackTrace();
	    }catch(Exception e1){
	    	e1.printStackTrace();
	    }
//	    System.out.println("��ƳB�z����!");
	    
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
				JOptionPane.showMessageDialog(null, "���b���w�s�b�A�нT�{�᭫�s��J");
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
					salary_get="���~";}
				else if(M_Daily.isSelected()) {
					salary_get="���~";}
				else if(M_Hourly.isSelected()) {
					salary_get="���~";}
				else if(M_PieceCounting.isSelected()) {
					salary_get="�p��";}
				ps.setString(9, salary_get);
				
				if(M_Remittance.isSelected()){
					salary_pay="�״�";}
				else if(M_Cash.isSelected()){
					salary_pay="�I�{";}
				else if(M_Other.isSelected()){
					salary_pay="��L";}
				ps.setString(10, salary_pay);
				
				ps.setDouble(11, Double.valueOf(T_Principal.getText()));
				ps.setDouble(12, Double.valueOf(T_EmpInsurance.getText()));
				ps.setDouble(13, Double.valueOf(T_Allowance.getText()));
				ps.setDouble(14, Double.valueOf(T_HealthInsurance.getText()));
				ps.setDouble(15, Double.valueOf(T_TotalAllowance.getText()));
				ps.setDouble(16, Double.valueOf(T_SalaryFull.getText()));
				
/*------�o�̦����D-------------------------------------------------------------------*/
				ps.setString(17, "0000");
				ps.setDouble(18, 0);
				ps.setDouble(19, 0);
				ps.setDouble(20, 0);
/*------�o�̦����D-------------------------------------------------------------------*/				
				
				
				ps.execute();
				
				ps.close();
				con.close();
				
				JOptionPane.showMessageDialog(null, "�s�W�H����Ʀ��\�I");
			}
			
		}catch (Exception e) {
			System.out.println("Error:" + e);
			System.out.println(e.getStackTrace());
			JOptionPane.showMessageDialog(null, "�нT�{�Ҧ����Ҷ�g����");	
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
				JOptionPane.showMessageDialog(null, "������H���s���A�ЦA���ާ@");
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
				salary_get="���~";
			else if(M_Daily.isSelected()) 
				salary_get="���~";
			else if(M_Hourly.isSelected()) 
				salary_get="���~";
			else if(M_PieceCounting.isSelected()) 
				salary_get="�p��";
			ps.setString(8, salary_get);
			
			if(M_Remittance.isSelected()) 
				salary_pay="�״�";
			else if(M_Cash.isSelected()) 
				salary_pay="�I�{";
			else if(M_Other.isSelected()) 
				salary_pay="��L";
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
			
			JOptionPane.showMessageDialog(null, "��s�H����Ʀ��\�I");
			}
			
		}catch (Exception e) {
			System.out.println("Error:" + e);
			JOptionPane.showMessageDialog(null, "�нT�{:\n1.�Ҧ����Ҷ�g����");	
			}
		}
	
	private void DeleteFromDatabase(String beSelected) {
		Connection con = con();
		try {
			if (checkRedundant()==0) {
				JOptionPane.showMessageDialog(null, "�R�����ѡA���b�����s�b");
				}
			else {
			
			String sql = "DELETE FROM Emp_Treat WHERE id_comp = ?";
			PreparedStatement ps = con.prepareStatement(sql);
	
			ps.setString(1, beSelected);
			
			ps.execute();
			JOptionPane.showMessageDialog(null, "�R���H����Ʀ��\�I");
			
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
				
				if(rs.getString("salary_get").equals("���~")) {
					M_Monthly.setSelected(true);
					}else if(rs.getString("salary_get").equals("���~")){
						M_Daily.setSelected(true);
					}else if(rs.getString("salary_get").equals("���~")){
						M_Hourly.setSelected(true);
					}else{
						M_PieceCounting.setSelected(true);
						}
					
				
				if(rs.getString("salary_pay").equals("�״�")) {
					M_Remittance.setSelected(true);
				}else if(rs.getString("salary_pay").equals("�I�{")) {
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
	//�d�ϥΪ̬O�_�s�b
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
	        return flag;//�����ƨϥΪ̦^��1
	    }
		
}


