package HR_Package;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import com.toedter.calendar.JDateChooser;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JTable;

public class Information_B_Page extends JPanel {
	
	private JTextField T_ChineseName;
	private JTextField T_EnglishName;
	private JTextField T_IdNumber;
	private JTextField T_WorkDate;
	private JDateChooser DT_WorkDate;
	private JTextField T_Address;
	private JTextField T_Birth;
	private JDateChooser DT_Birth;
	private JTextField T_Phone;
	private JTextField T_School;
	private JTextField T_Education;
	private JTextField T_Email;
	private JTextField T_Id_comp;
	private JTextField T_Department;
	private JComboBox CB_Department;
	private JRadioButton Gender_male;
	private JRadioButton Gender_female;
	private JRadioButton Marriage_married;
	private JRadioButton Marriage_unmarried;
	private String gender;
	private String marital;
	ButtonGroup bg_Gender;
	ButtonGroup bg_Marriage;

	/**
	 * Create the panel.
	 */
	public Information_B_Page() {
		
//		setBackground(SystemColor.menu);
		
		setBounds(35,43,670, 550);
		setLayout(null);
		setBorder(null);
		setOpaque(false);//背景透明
		
		
		//第一列框架
		JPanel panel1 = new JPanel();
		panel1.setLayout(null);
		panel1.setBounds(45, 50, 580, 50);
		panel1.setOpaque(false);//背景透明
		add(panel1);
		//員工編號_標籤		
		JLabel W_Id_comp = new JLabel("員工編號");
		W_Id_comp.setBounds(10, 10, 80, 30);
		W_Id_comp.setFont(new Font("Microsoft JhengHei", Font.BOLD, 20));
		panel1.add(W_Id_comp);
		//員工編號_文字欄
		T_Id_comp = new JTextField();
		T_Id_comp.setBounds(95, 10, 170, 30);
		T_Id_comp.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		T_Id_comp.setBorder(null);//去除邊框
		panel1.add(T_Id_comp);
		T_Id_comp.setColumns(10);
		
		//搜尋資料按鈕
		JButton Button_Search = new JButton("");
		Button_Search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String search_Id = T_Id_comp.getText().replaceAll("\\s+", "");
				SearchFromDatabase(search_Id);}
			});
		Button_Search.setContentAreaFilled(false);
		
		Button_Search.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		Button_Search.setBorder(null);//去除邊框
		Button_Search.setBounds(269, 14, 25, 25);
		panel1.add(Button_Search);		
		
		
		//部門_標籤
		JLabel W_Department = new JLabel("部       門");
		W_Department.setBounds(315, 10, 80, 30);
		W_Department.setFont(new Font("Microsoft JhengHei", Font.BOLD, 20));
		panel1.add(W_Department);
		//部門_文字欄
		String[] arr ={"--請選擇部門--"};
		String[] arr2 ={"人力資源部","技術研發部","公共關係部","總務部","營業部","秘書室"};
		//部門_下拉式選單		
		CB_Department = new JComboBox(arr);   /*建立「部門」的下拉式選單(空)*/		
		for(String i:arr2) {CB_Department.addItem(i);}		
		CB_Department.setBounds(400, 10, 170, 30);
		CB_Department.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		CB_Department.setBorder(null);//去除邊框
		panel1.add(CB_Department);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(269, 14, 25, 25);
		panel1.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search.png")).getImage().getScaledInstance(19, 19, Image.SCALE_SMOOTH)));
		
		//第二列框架
		JPanel panel2 = new JPanel();
		panel2.setLayout(null);
		panel2.setBounds(45, 100, 580, 50);
		panel2.setOpaque(false);//背景透明
		add(panel2);
		//中文姓名_標籤		
		JLabel W_ChineseName = new JLabel("中文姓名");
		W_ChineseName.setBounds(10, 10, 80, 30);
		W_ChineseName.setFont(new Font("Microsoft JhengHei", Font.BOLD, 20));
		panel2.add(W_ChineseName);
		//中文姓名_文字欄	
		T_ChineseName = new JTextField();
		T_ChineseName.setBounds(95, 10, 170, 30);
		T_ChineseName.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		T_ChineseName.setBorder(null);//去除邊框
		panel2.add(T_ChineseName);
		T_ChineseName.setColumns(10);
		//英文姓名_標籤
		JLabel W_EnglishName = new JLabel("英文姓名");
		W_EnglishName.setBounds(315, 10, 80, 30);
		W_EnglishName.setFont(new Font("Microsoft JhengHei", Font.BOLD, 20));
		panel2.add(W_EnglishName);
		//英文姓名_文字欄
		T_EnglishName = new JTextField();
		T_EnglishName.setBounds(400, 10, 170, 30);
		T_EnglishName.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		T_EnglishName.setBorder(null);//去除邊框
		panel2.add(T_EnglishName);
		T_EnglishName.setColumns(10);
		
		//第三列框架
		JPanel panel3 = new JPanel();
		panel3.setLayout(null);
		panel3.setBounds(45, 150, 580, 50);
		panel3.setOpaque(false);//背景透明
		add(panel3);
		//身分證號_標籤
		JLabel W_IdNumber = new JLabel("身分證號");
		W_IdNumber.setBounds(10, 10, 80, 30);
		W_IdNumber.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		panel3.add(W_IdNumber);
		//身分證號_標籤
		T_IdNumber = new JTextField("");
		T_IdNumber.setBounds(95, 10, 170, 30);
		T_IdNumber.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		T_IdNumber.setBorder(null);//去除邊框
		T_IdNumber.setColumns(10);
		panel3.add(T_IdNumber);
		
		//到職日期_標籤
		JLabel W_WorkDate = new JLabel("到職日期",JLabel.LEFT);
		W_WorkDate.setBounds(315, 10, 80, 30);
		W_WorkDate.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		panel3.add(W_WorkDate);
		
		//到職日期_時間選擇器
		DT_WorkDate = new JDateChooser();
		DT_WorkDate.setBounds(400, 10, 170, 30);
		DT_WorkDate.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		DT_WorkDate.setBorder(null);//去除邊框
		panel3.add(DT_WorkDate);

		//第四列框架
		JPanel panel4 = new JPanel();
		panel4.setLayout(null);
		panel4.setOpaque(false);
		panel4.setBounds(45, 200, 580, 50);
		add(panel4);
		//性別_標籤
		JLabel W_Gender = new JLabel("性       別");
		W_Gender.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		W_Gender.setBounds(10, 10, 80, 30);
		panel4.add(W_Gender);
		//性別_男_單選
		Gender_male = new JRadioButton("男");
		Gender_male.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		Gender_male.setBounds(120, 15, 50, 20);
		Gender_male.setOpaque(false);//背景透明
		panel4.add(Gender_male);
		//性別_女_單選
		Gender_female = new JRadioButton("女");
		Gender_female.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		Gender_female.setBounds(180, 15, 50, 20);
		Gender_female.setOpaque(false);//背景透明
		panel4.add(Gender_female);
		
		bg_Gender=new ButtonGroup();
		bg_Gender.add(Gender_male);
		bg_Gender.add(Gender_female);
				
		//婚姻狀態_標籤
		JLabel W_Marriage = new JLabel("婚姻狀態", SwingConstants.LEFT);
		W_Marriage.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		W_Marriage.setBounds(315, 10, 80, 30);
		panel4.add(W_Marriage);
		//婚姻狀態_未婚_單選
		Marriage_unmarried = new JRadioButton("未婚");
		Marriage_unmarried.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		Marriage_unmarried.setBounds(415, 15, 70, 20);
		Marriage_unmarried.setOpaque(false);//背景透明
		panel4.add(Marriage_unmarried);
		//婚姻狀態_已婚_單選
		Marriage_married = new JRadioButton("已婚");
		Marriage_married.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		Marriage_married.setBounds(490, 15, 70, 20);
		Marriage_married.setOpaque(false);//背景透明
		panel4.add(Marriage_married);
				
		bg_Marriage=new ButtonGroup();
		bg_Marriage.add(Marriage_married);
		bg_Marriage.add(Marriage_unmarried);
		
		//第五列框架
		JPanel panel5 = new JPanel();
		panel5.setLayout(null);
		panel5.setBounds(45, 250, 580, 50);
		panel5.setOpaque(false);//背景透明
		add(panel5);
		//出生日期_標籤
		JLabel W_Born = new JLabel("出生日期");
		W_Born.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		W_Born.setBounds(10, 10, 80, 30);
		panel5.add(W_Born);
		//出生日期_時間選擇器		
		DT_Birth = new JDateChooser();
		DT_Birth.setBounds(95, 10, 170, 30);
		DT_Birth.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		DT_Birth.setBorder(null);//去除邊框
		panel5.add(DT_Birth);
		
		//聯絡手機_標籤
		JLabel W_Phone = new JLabel("聯絡手機");
		W_Phone.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		W_Phone.setBounds(315, 10, 80, 30);
		panel5.add(W_Phone);
		//聯絡手機_文字欄
		T_Phone = new JTextField();
		T_Phone.setColumns(10);
		T_Phone.setBounds(400, 10, 170, 30);
		T_Phone.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		T_Phone.setBorder(null);//去除邊框
		panel5.add(T_Phone);
				
		//第六列框架		
		JPanel panel6 = new JPanel();
		panel6.setLayout(null);
		panel6.setBounds(45, 300, 580, 50);
		panel6.setOpaque(false);//背景透明
		add(panel6);
		//地址_標籤
		JLabel W_Address = new JLabel("地       址",JLabel.LEFT);
		W_Address.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		W_Address.setBounds(10, 10, 80, 30);
		panel6.add(W_Address);
		//地址_文字欄
		T_Address = new JTextField();
		T_Address.setColumns(10);
		T_Address.setBounds(95, 10, 475, 30);
		T_Address.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		T_Address.setBorder(null);//去除邊框
		panel6.add(T_Address);
				
		//第七列框架
		JPanel panel7 = new JPanel();
		panel7.setLayout(null);
		panel7.setBounds(45, 350, 580, 50);
		panel7.setOpaque(false);//背景透明
		add(panel7);
		//最高學歷_標籤
		JLabel W_School = new JLabel("最高學歷");
		W_School.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		W_School.setBounds(10, 10, 80, 30);
		panel7.add(W_School);
		//最高學歷_文字欄
		T_School = new JTextField();
		T_School.setColumns(10);
		T_School.setBounds(95, 10, 170, 30);
		T_School.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		T_School.setBorder(null);//去除邊框
		panel7.add(T_School);
		//學校系別_標籤
		JLabel W_Education = new JLabel("學校系別");
		W_Education.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		W_Education.setBounds(315, 10, 80, 30);
		panel7.add(W_Education);
		//學校系別_文字欄
		T_Education = new JTextField();
		T_Education.setColumns(10);
		T_Education.setBounds(400, 10, 170, 30);
		T_Education.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		T_Education.setBorder(null);//去除邊框
		panel7.add(T_Education);
		
	//照片框	
//		JPanel contentPane = new JPanel();
//		contentPane.setLayout(null);
//		contentPane.setOpaque(false);
//		contentPane.setBounds(517, 115, 120, 150);
//		add(contentPane);
//		
//		JLabel lbl_phto = new JLabel("");
//		lbl_phto.setFont(new Font("微軟正黑體", Font.BOLD, 20));
//		lbl_phto.setBounds(10, 10, 100, 130);
//		contentPane.add(lbl_phto);
		
	//上傳照片按鈕
//		JButton Button_photo = new JButton("\u4E0A\u50B3\u7167\u7247");
//		Button_photo.setFont(new Font("微軟正黑體", Font.BOLD, 16));
//		Button_photo.setBounds(535, 286, 100, 23);
//		add(Button_photo);
//		
		//新增資料按鈕
		JButton Button_Confirm = new JButton("新增");
		Button_Confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SaveToDatabase();
				}				
		});
		Button_Confirm.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		Button_Confirm.setBorder(null);//去除邊框
		Button_Confirm.setBounds(100, 470, 85, 37);
		add(Button_Confirm);
		
		
		//更新資料按鈕
		JButton Button_Update = new JButton("更新");
		Button_Update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String update_ID = T_Id_comp.getText();			
				if(JOptionPane.showConfirmDialog(null,"確認更新資料嗎?","資料更新中", JOptionPane.YES_NO_OPTION) == 0){
					UpdateToDatabase(update_ID);
					}						
				}			
			});
		Button_Update.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		Button_Update.setBorder(null);//去除邊框
		Button_Update.setBounds(300, 470, 85, 37);
		add(Button_Update);
		
		
		//刪除資料按鈕
		JButton Button_Delete = new JButton("刪除");
		
		Button_Delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String delete_ID = T_Id_comp.getText();
				
				if(JOptionPane.showConfirmDialog(null,"確認刪除資料嗎?", 
						"資料刪除中", JOptionPane.YES_NO_OPTION) == 0)
				 {
					DeleteFromDatabase(delete_ID);
					}else {				
				}
				}
			});
		Button_Delete.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		Button_Delete.setBorder(null);//去除邊框
		Button_Delete.setBounds(500, 470, 85, 37);
		add(Button_Delete);
		

		//第八列框架
		JPanel panel8 = new JPanel();
		panel8.setLayout(null);
		panel8.setOpaque(false);
		panel8.setBounds(45, 400, 580, 50);
		add(panel8);
		//電子信箱_標籤
		JLabel W_Email = new JLabel("電子信箱", SwingConstants.LEFT);
		W_Email.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		W_Email.setBounds(10, 10, 80, 30);
		panel8.add(W_Email);
		//電子信箱_文字欄
		T_Email = new JTextField();
		T_Email.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		T_Email.setColumns(10);
		T_Email.setBorder(null);
		T_Email.setBounds(95, 10, 475, 30);
		panel8.add(T_Email);
		
        //半透明圓角視窗
        JLabel lblMainContent = new JLabel("");
		lblMainContent.setHorizontalAlignment(SwingConstants.CENTER);
		lblMainContent.setIcon(new ImageIcon(FrameDashboard.class.getResource("/img/JPanel-1.png")));
		lblMainContent.setBounds(0, 0, getWidth(), getHeight());
		//調整圖像大小符合外框
		lblMainContent.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/img/JPanel-1.png")).getImage().getScaledInstance(lblMainContent.getWidth(), lblMainContent.getHeight(), Image.SCALE_SMOOTH)));
		add(lblMainContent);


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
			if (checkRedundant()==0) {
				JOptionPane.showMessageDialog(null, "該帳號不存在，請重新操作");
				
				T_Id_comp.setText("");
				CB_Department.setSelectedIndex(0);				
				T_ChineseName.setText("");
				T_EnglishName.setText("");
				T_IdNumber.setText("");
				DT_WorkDate.setDate(null);
							
				bg_Gender.clearSelection();
				bg_Marriage.clearSelection();
				
				DT_Birth.setDate(null);
				T_Phone.setText("");
				T_Address.setText("");
				T_School.setText("");
				T_Education.setText("");
				T_Email.setText("");
					
				}
			else {
			
			String search = "SELECT * FROM emp_data WHERE id_comp = ?";
			PreparedStatement ps = con.prepareStatement(search);
			
			ps.setString(1, beSelected);			
			ps.execute();
			
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				T_Id_comp.setText(rs.getString("id_comp"));
				CB_Department.setSelectedItem(rs.getString("department"));				
				T_ChineseName.setText(rs.getString("name"));
				T_EnglishName.setText(rs.getString("name_EN"));
				T_IdNumber.setText(rs.getString("id_num"));
				DT_WorkDate.setDate(rs.getDate("onduty"));
				
				if (rs.getString("gender") == "男") {
					Gender_male.setSelected(true);
				}else {Gender_female.setSelected(true);}
				
				if (rs.getString("marital") == "Y") {
					Marriage_married.setSelected(true);
				}else {Marriage_unmarried.setSelected(true);}

				DT_Birth.setDate(rs.getDate("birth"));
				T_Phone.setText(rs.getString("phone"));
				T_Address.setText(rs.getString("address"));
				T_School.setText(rs.getString("school"));
				T_Education.setText(rs.getString("education"));
				T_Email.setText(rs.getString("email"));			
			}
				
			rs.close();
			ps.close();
			con.close();}
			
		}catch (Exception e) {
			
			System.out.println("Error:" + e);
			
		}
	}
	
	
	
	private void SaveToDatabase() {
		Connection con = con();
		try {
			if (checkRedundant()==1) {
				JOptionPane.showMessageDialog(null, "此帳號已存在，請確認後重新輸入");
							
			}else if (CB_Department.getSelectedIndex()==0){
				JOptionPane.showMessageDialog(null, "部門尚未選取，請再次確認");
			}			
			
			else {			
			String query = "insert into emp_data values(?,?,?,?,?"
													+ ",?,?,?,?,?"
													+ ",?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
	
			ps.setString(1, T_Id_comp.getText());
			ps.setString(2, (String)CB_Department.getSelectedItem());
			ps.setString(3, T_ChineseName.getText());
			ps.setString(4, T_EnglishName.getText());
			ps.setString(5, T_IdNumber.getText());
			ps.setDate(6, new java.sql.Date(DT_WorkDate.getDate().getTime()));
			
			if(Gender_male.isSelected()) 
		        gender="男";
			else if(Gender_female.isSelected()) 
		        gender="女";
			ps.setString(7, gender);
			
			if(Marriage_married.isSelected()) 
				marital="Y";
			else if(Marriage_unmarried.isSelected()) 
				marital="N";
			ps.setString(8, marital);
			
			ps.setDate(9, new java.sql.Date(DT_Birth.getDate().getTime()));			
			ps.setString(10, T_Phone.getText());
			ps.setString(11, T_Address.getText());
			ps.setString(12, T_School.getText());
			ps.setString(13, T_Education.getText());
			ps.setString(14, T_Email.getText());
			
			ps.execute();
			JOptionPane.showMessageDialog(null, "儲存成功！");

			
			ps.close();
			con.close();
			}			
			}catch (Exception e) {
				System.out.println("Error:" + e);
				JOptionPane.showMessageDialog(null, "請確認所有欄位皆填寫完畢");
		}
	}
//
	private void UpdateToDatabase(String beSelected) {
		Connection con = con();
		String update = "UPDATE Emp_data SET department=?, name=?, name_EN=?, id_num=?,"
				+ "onduty=?, gender=?, marital=?, birth=?, phone=?, "
				+ "address=?, school=?, education=?, email=? WHERE id_comp =?";
		
		try {	
			if (checkRedundant()==0) {
				JOptionPane.showMessageDialog(null, "此帳號不存在，請確認後重新輸入");
				}else if (CB_Department.getSelectedIndex()==0){
					JOptionPane.showMessageDialog(null, "部門尚未選取，請再次確認");
				}
			else {
			PreparedStatement ps = con.prepareStatement(update);			
			ps.setString(1, (String)CB_Department.getSelectedItem());
			ps.setString(2, T_ChineseName.getText());
			ps.setString(3, T_EnglishName.getText());
			ps.setString(4, T_IdNumber.getText());
			ps.setDate(5, new java.sql.Date(DT_WorkDate.getDate().getTime()));
			
			if(Gender_male.isSelected()) 
		        gender="男";
			else if(Gender_female.isSelected()) 
		        gender="女";
			ps.setString(6, gender);
			
			if(Marriage_married.isSelected()) 
				marital="Y";
			else if(Marriage_unmarried.isSelected()) 
				marital="N";
			ps.setString(7, marital);
			
			ps.setDate(8, new java.sql.Date(DT_Birth.getDate().getTime()));			
			ps.setString(9, T_Phone.getText());
			ps.setString(10, T_Address.getText());
			ps.setString(11, T_School.getText());
			ps.setString(12, T_Education.getText());
			ps.setString(13, T_Email.getText());
			ps.setString(14, beSelected);
			
			ps.execute();
	
			ps.close();
			con.close();
			
			JOptionPane.showMessageDialog(null, "更新成功！");
			}
			
		}catch (Exception e) {
			System.out.println("Error:" + e);
			JOptionPane.showMessageDialog(null, "請確認所有欄位皆填寫完畢");	
			}
		}

	
	
	private void DeleteFromDatabase(String beSelected) {
		Connection con = con();
		try {
			if (checkRedundant()==0) {
				JOptionPane.showMessageDialog(null, "刪除失敗，此帳號不存在");									
				}
			else {
			
			String sql = "DELETE FROM emp_data WHERE id_comp = ?";
			PreparedStatement ps = con.prepareStatement(sql);
	
			ps.setString(1, beSelected);
			
			ps.execute();
			JOptionPane.showMessageDialog(null, "刪除人員資料成功");
			
			ps.close();
			con.close();}

			T_Id_comp.setText("");
			CB_Department.setSelectedIndex(0);				
			T_ChineseName.setText("");
			T_EnglishName.setText("");
			T_IdNumber.setText("");
			DT_WorkDate.setDate(null);
						
			bg_Gender.clearSelection();
			bg_Marriage.clearSelection();
			
			DT_Birth.setDate(null);
			T_Phone.setText("");
			T_Address.setText("");
			T_School.setText("");
			T_Education.setText("");
			T_Email.setText("");
			
		}catch (Exception e) {
			System.out.println("Error:" + e);
			
		}
	}
	
	//查使用者是否存在
	public int checkRedundant(){    
        String checkSQL = "select * from emp_data "; 
        int flag = 0;
        Connection con = con();
        try {
        	
        	Statement st = con.createStatement(); 
            ResultSet rs = st.executeQuery(checkSQL); 
            while (rs.next()) {
                 if (rs.getString("id_comp").equals(T_Id_comp.getText()))
                     flag = 1;
            }
        } catch (SQLException e) {

        }
        return flag;//有重複使用者回傳1
    }
}
