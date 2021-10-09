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
		setOpaque(false);//�I���z��
		
		
		//�Ĥ@�C�ج[
		JPanel panel1 = new JPanel();
		panel1.setLayout(null);
		panel1.setBounds(45, 50, 580, 50);
		panel1.setOpaque(false);//�I���z��
		add(panel1);
		//���u�s��_����		
		JLabel W_Id_comp = new JLabel("���u�s��");
		W_Id_comp.setBounds(10, 10, 80, 30);
		W_Id_comp.setFont(new Font("Microsoft JhengHei", Font.BOLD, 20));
		panel1.add(W_Id_comp);
		//���u�s��_��r��
		T_Id_comp = new JTextField();
		T_Id_comp.setBounds(95, 10, 170, 30);
		T_Id_comp.setFont(new Font("�L�n������", Font.BOLD, 20));
		T_Id_comp.setBorder(null);//�h�����
		panel1.add(T_Id_comp);
		T_Id_comp.setColumns(10);
		
		//�j�M��ƫ��s
		JButton Button_Search = new JButton("");
		Button_Search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String search_Id = T_Id_comp.getText().replaceAll("\\s+", "");
				SearchFromDatabase(search_Id);}
			});
		Button_Search.setContentAreaFilled(false);
		
		Button_Search.setFont(new Font("�L�n������", Font.BOLD, 16));
		Button_Search.setBorder(null);//�h�����
		Button_Search.setBounds(269, 14, 25, 25);
		panel1.add(Button_Search);		
		
		
		//����_����
		JLabel W_Department = new JLabel("��       ��");
		W_Department.setBounds(315, 10, 80, 30);
		W_Department.setFont(new Font("Microsoft JhengHei", Font.BOLD, 20));
		panel1.add(W_Department);
		//����_��r��
		String[] arr ={"--�п�ܳ���--"};
		String[] arr2 ={"�H�O�귽��","�޳N��o��","���@���Y��","�`�ȳ�","��~��","���ѫ�"};
		//����_�U�Ԧ����		
		CB_Department = new JComboBox(arr);   /*�إߡu�����v���U�Ԧ����(��)*/		
		for(String i:arr2) {CB_Department.addItem(i);}		
		CB_Department.setBounds(400, 10, 170, 30);
		CB_Department.setFont(new Font("�L�n������", Font.BOLD, 20));
		CB_Department.setBorder(null);//�h�����
		panel1.add(CB_Department);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(269, 14, 25, 25);
		panel1.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search.png")).getImage().getScaledInstance(19, 19, Image.SCALE_SMOOTH)));
		
		//�ĤG�C�ج[
		JPanel panel2 = new JPanel();
		panel2.setLayout(null);
		panel2.setBounds(45, 100, 580, 50);
		panel2.setOpaque(false);//�I���z��
		add(panel2);
		//����m�W_����		
		JLabel W_ChineseName = new JLabel("����m�W");
		W_ChineseName.setBounds(10, 10, 80, 30);
		W_ChineseName.setFont(new Font("Microsoft JhengHei", Font.BOLD, 20));
		panel2.add(W_ChineseName);
		//����m�W_��r��	
		T_ChineseName = new JTextField();
		T_ChineseName.setBounds(95, 10, 170, 30);
		T_ChineseName.setFont(new Font("�L�n������", Font.BOLD, 20));
		T_ChineseName.setBorder(null);//�h�����
		panel2.add(T_ChineseName);
		T_ChineseName.setColumns(10);
		//�^��m�W_����
		JLabel W_EnglishName = new JLabel("�^��m�W");
		W_EnglishName.setBounds(315, 10, 80, 30);
		W_EnglishName.setFont(new Font("Microsoft JhengHei", Font.BOLD, 20));
		panel2.add(W_EnglishName);
		//�^��m�W_��r��
		T_EnglishName = new JTextField();
		T_EnglishName.setBounds(400, 10, 170, 30);
		T_EnglishName.setFont(new Font("�L�n������", Font.BOLD, 20));
		T_EnglishName.setBorder(null);//�h�����
		panel2.add(T_EnglishName);
		T_EnglishName.setColumns(10);
		
		//�ĤT�C�ج[
		JPanel panel3 = new JPanel();
		panel3.setLayout(null);
		panel3.setBounds(45, 150, 580, 50);
		panel3.setOpaque(false);//�I���z��
		add(panel3);
		//�����Ҹ�_����
		JLabel W_IdNumber = new JLabel("�����Ҹ�");
		W_IdNumber.setBounds(10, 10, 80, 30);
		W_IdNumber.setFont(new Font("�L�n������", Font.BOLD, 20));
		panel3.add(W_IdNumber);
		//�����Ҹ�_����
		T_IdNumber = new JTextField("");
		T_IdNumber.setBounds(95, 10, 170, 30);
		T_IdNumber.setFont(new Font("�L�n������", Font.BOLD, 20));
		T_IdNumber.setBorder(null);//�h�����
		T_IdNumber.setColumns(10);
		panel3.add(T_IdNumber);
		
		//��¾���_����
		JLabel W_WorkDate = new JLabel("��¾���",JLabel.LEFT);
		W_WorkDate.setBounds(315, 10, 80, 30);
		W_WorkDate.setFont(new Font("�L�n������", Font.BOLD, 20));
		panel3.add(W_WorkDate);
		
		//��¾���_�ɶ���ܾ�
		DT_WorkDate = new JDateChooser();
		DT_WorkDate.setBounds(400, 10, 170, 30);
		DT_WorkDate.setFont(new Font("�L�n������", Font.BOLD, 16));
		DT_WorkDate.setBorder(null);//�h�����
		panel3.add(DT_WorkDate);

		//�ĥ|�C�ج[
		JPanel panel4 = new JPanel();
		panel4.setLayout(null);
		panel4.setOpaque(false);
		panel4.setBounds(45, 200, 580, 50);
		add(panel4);
		//�ʧO_����
		JLabel W_Gender = new JLabel("��       �O");
		W_Gender.setFont(new Font("�L�n������", Font.BOLD, 20));
		W_Gender.setBounds(10, 10, 80, 30);
		panel4.add(W_Gender);
		//�ʧO_�k_���
		Gender_male = new JRadioButton("�k");
		Gender_male.setFont(new Font("�L�n������", Font.BOLD, 20));
		Gender_male.setBounds(120, 15, 50, 20);
		Gender_male.setOpaque(false);//�I���z��
		panel4.add(Gender_male);
		//�ʧO_�k_���
		Gender_female = new JRadioButton("�k");
		Gender_female.setFont(new Font("�L�n������", Font.BOLD, 20));
		Gender_female.setBounds(180, 15, 50, 20);
		Gender_female.setOpaque(false);//�I���z��
		panel4.add(Gender_female);
		
		bg_Gender=new ButtonGroup();
		bg_Gender.add(Gender_male);
		bg_Gender.add(Gender_female);
				
		//�B�ê��A_����
		JLabel W_Marriage = new JLabel("�B�ê��A", SwingConstants.LEFT);
		W_Marriage.setFont(new Font("�L�n������", Font.BOLD, 20));
		W_Marriage.setBounds(315, 10, 80, 30);
		panel4.add(W_Marriage);
		//�B�ê��A_���B_���
		Marriage_unmarried = new JRadioButton("���B");
		Marriage_unmarried.setFont(new Font("�L�n������", Font.BOLD, 20));
		Marriage_unmarried.setBounds(415, 15, 70, 20);
		Marriage_unmarried.setOpaque(false);//�I���z��
		panel4.add(Marriage_unmarried);
		//�B�ê��A_�w�B_���
		Marriage_married = new JRadioButton("�w�B");
		Marriage_married.setFont(new Font("�L�n������", Font.BOLD, 20));
		Marriage_married.setBounds(490, 15, 70, 20);
		Marriage_married.setOpaque(false);//�I���z��
		panel4.add(Marriage_married);
				
		bg_Marriage=new ButtonGroup();
		bg_Marriage.add(Marriage_married);
		bg_Marriage.add(Marriage_unmarried);
		
		//�Ĥ��C�ج[
		JPanel panel5 = new JPanel();
		panel5.setLayout(null);
		panel5.setBounds(45, 250, 580, 50);
		panel5.setOpaque(false);//�I���z��
		add(panel5);
		//�X�ͤ��_����
		JLabel W_Born = new JLabel("�X�ͤ��");
		W_Born.setFont(new Font("�L�n������", Font.BOLD, 20));
		W_Born.setBounds(10, 10, 80, 30);
		panel5.add(W_Born);
		//�X�ͤ��_�ɶ���ܾ�		
		DT_Birth = new JDateChooser();
		DT_Birth.setBounds(95, 10, 170, 30);
		DT_Birth.setFont(new Font("�L�n������", Font.BOLD, 16));
		DT_Birth.setBorder(null);//�h�����
		panel5.add(DT_Birth);
		
		//�p�����_����
		JLabel W_Phone = new JLabel("�p�����");
		W_Phone.setFont(new Font("�L�n������", Font.BOLD, 20));
		W_Phone.setBounds(315, 10, 80, 30);
		panel5.add(W_Phone);
		//�p�����_��r��
		T_Phone = new JTextField();
		T_Phone.setColumns(10);
		T_Phone.setBounds(400, 10, 170, 30);
		T_Phone.setFont(new Font("�L�n������", Font.BOLD, 20));
		T_Phone.setBorder(null);//�h�����
		panel5.add(T_Phone);
				
		//�Ĥ��C�ج[		
		JPanel panel6 = new JPanel();
		panel6.setLayout(null);
		panel6.setBounds(45, 300, 580, 50);
		panel6.setOpaque(false);//�I���z��
		add(panel6);
		//�a�}_����
		JLabel W_Address = new JLabel("�a       �}",JLabel.LEFT);
		W_Address.setFont(new Font("�L�n������", Font.BOLD, 20));
		W_Address.setBounds(10, 10, 80, 30);
		panel6.add(W_Address);
		//�a�}_��r��
		T_Address = new JTextField();
		T_Address.setColumns(10);
		T_Address.setBounds(95, 10, 475, 30);
		T_Address.setFont(new Font("�L�n������", Font.BOLD, 20));
		T_Address.setBorder(null);//�h�����
		panel6.add(T_Address);
				
		//�ĤC�C�ج[
		JPanel panel7 = new JPanel();
		panel7.setLayout(null);
		panel7.setBounds(45, 350, 580, 50);
		panel7.setOpaque(false);//�I���z��
		add(panel7);
		//�̰��Ǿ�_����
		JLabel W_School = new JLabel("�̰��Ǿ�");
		W_School.setFont(new Font("�L�n������", Font.BOLD, 20));
		W_School.setBounds(10, 10, 80, 30);
		panel7.add(W_School);
		//�̰��Ǿ�_��r��
		T_School = new JTextField();
		T_School.setColumns(10);
		T_School.setBounds(95, 10, 170, 30);
		T_School.setFont(new Font("�L�n������", Font.BOLD, 20));
		T_School.setBorder(null);//�h�����
		panel7.add(T_School);
		//�Ǯըt�O_����
		JLabel W_Education = new JLabel("�Ǯըt�O");
		W_Education.setFont(new Font("�L�n������", Font.BOLD, 20));
		W_Education.setBounds(315, 10, 80, 30);
		panel7.add(W_Education);
		//�Ǯըt�O_��r��
		T_Education = new JTextField();
		T_Education.setColumns(10);
		T_Education.setBounds(400, 10, 170, 30);
		T_Education.setFont(new Font("�L�n������", Font.BOLD, 20));
		T_Education.setBorder(null);//�h�����
		panel7.add(T_Education);
		
	//�Ӥ���	
//		JPanel contentPane = new JPanel();
//		contentPane.setLayout(null);
//		contentPane.setOpaque(false);
//		contentPane.setBounds(517, 115, 120, 150);
//		add(contentPane);
//		
//		JLabel lbl_phto = new JLabel("");
//		lbl_phto.setFont(new Font("�L�n������", Font.BOLD, 20));
//		lbl_phto.setBounds(10, 10, 100, 130);
//		contentPane.add(lbl_phto);
		
	//�W�ǷӤ����s
//		JButton Button_photo = new JButton("\u4E0A\u50B3\u7167\u7247");
//		Button_photo.setFont(new Font("�L�n������", Font.BOLD, 16));
//		Button_photo.setBounds(535, 286, 100, 23);
//		add(Button_photo);
//		
		//�s�W��ƫ��s
		JButton Button_Confirm = new JButton("�s�W");
		Button_Confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SaveToDatabase();
				}				
		});
		Button_Confirm.setFont(new Font("�L�n������", Font.BOLD, 20));
		Button_Confirm.setBorder(null);//�h�����
		Button_Confirm.setBounds(100, 470, 85, 37);
		add(Button_Confirm);
		
		
		//��s��ƫ��s
		JButton Button_Update = new JButton("��s");
		Button_Update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String update_ID = T_Id_comp.getText();			
				if(JOptionPane.showConfirmDialog(null,"�T�{��s��ƶ�?","��Ƨ�s��", JOptionPane.YES_NO_OPTION) == 0){
					UpdateToDatabase(update_ID);
					}						
				}			
			});
		Button_Update.setFont(new Font("�L�n������", Font.BOLD, 20));
		Button_Update.setBorder(null);//�h�����
		Button_Update.setBounds(300, 470, 85, 37);
		add(Button_Update);
		
		
		//�R����ƫ��s
		JButton Button_Delete = new JButton("�R��");
		
		Button_Delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String delete_ID = T_Id_comp.getText();
				
				if(JOptionPane.showConfirmDialog(null,"�T�{�R����ƶ�?", 
						"��ƧR����", JOptionPane.YES_NO_OPTION) == 0)
				 {
					DeleteFromDatabase(delete_ID);
					}else {				
				}
				}
			});
		Button_Delete.setFont(new Font("�L�n������", Font.BOLD, 20));
		Button_Delete.setBorder(null);//�h�����
		Button_Delete.setBounds(500, 470, 85, 37);
		add(Button_Delete);
		

		//�ĤK�C�ج[
		JPanel panel8 = new JPanel();
		panel8.setLayout(null);
		panel8.setOpaque(false);
		panel8.setBounds(45, 400, 580, 50);
		add(panel8);
		//�q�l�H�c_����
		JLabel W_Email = new JLabel("�q�l�H�c", SwingConstants.LEFT);
		W_Email.setFont(new Font("�L�n������", Font.BOLD, 20));
		W_Email.setBounds(10, 10, 80, 30);
		panel8.add(W_Email);
		//�q�l�H�c_��r��
		T_Email = new JTextField();
		T_Email.setFont(new Font("�L�n������", Font.BOLD, 20));
		T_Email.setColumns(10);
		T_Email.setBorder(null);
		T_Email.setBounds(95, 10, 475, 30);
		panel8.add(T_Email);
		
        //�b�z���ꨤ����
        JLabel lblMainContent = new JLabel("");
		lblMainContent.setHorizontalAlignment(SwingConstants.CENTER);
		lblMainContent.setIcon(new ImageIcon(FrameDashboard.class.getResource("/img/JPanel-1.png")));
		lblMainContent.setBounds(0, 0, getWidth(), getHeight());
		//�վ�Ϲ��j�p�ŦX�~��
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
				JOptionPane.showMessageDialog(null, "�ӱb�����s�b�A�Э��s�ާ@");
				
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
				
				if (rs.getString("gender") == "�k") {
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
				JOptionPane.showMessageDialog(null, "���b���w�s�b�A�нT�{�᭫�s��J");
							
			}else if (CB_Department.getSelectedIndex()==0){
				JOptionPane.showMessageDialog(null, "�����|������A�ЦA���T�{");
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
		        gender="�k";
			else if(Gender_female.isSelected()) 
		        gender="�k";
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
			JOptionPane.showMessageDialog(null, "�x�s���\�I");

			
			ps.close();
			con.close();
			}			
			}catch (Exception e) {
				System.out.println("Error:" + e);
				JOptionPane.showMessageDialog(null, "�нT�{�Ҧ����Ҷ�g����");
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
				JOptionPane.showMessageDialog(null, "���b�����s�b�A�нT�{�᭫�s��J");
				}else if (CB_Department.getSelectedIndex()==0){
					JOptionPane.showMessageDialog(null, "�����|������A�ЦA���T�{");
				}
			else {
			PreparedStatement ps = con.prepareStatement(update);			
			ps.setString(1, (String)CB_Department.getSelectedItem());
			ps.setString(2, T_ChineseName.getText());
			ps.setString(3, T_EnglishName.getText());
			ps.setString(4, T_IdNumber.getText());
			ps.setDate(5, new java.sql.Date(DT_WorkDate.getDate().getTime()));
			
			if(Gender_male.isSelected()) 
		        gender="�k";
			else if(Gender_female.isSelected()) 
		        gender="�k";
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
			
			JOptionPane.showMessageDialog(null, "��s���\�I");
			}
			
		}catch (Exception e) {
			System.out.println("Error:" + e);
			JOptionPane.showMessageDialog(null, "�нT�{�Ҧ����Ҷ�g����");	
			}
		}

	
	
	private void DeleteFromDatabase(String beSelected) {
		Connection con = con();
		try {
			if (checkRedundant()==0) {
				JOptionPane.showMessageDialog(null, "�R�����ѡA���b�����s�b");									
				}
			else {
			
			String sql = "DELETE FROM emp_data WHERE id_comp = ?";
			PreparedStatement ps = con.prepareStatement(sql);
	
			ps.setString(1, beSelected);
			
			ps.execute();
			JOptionPane.showMessageDialog(null, "�R���H����Ʀ��\");
			
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
	
	//�d�ϥΪ̬O�_�s�b
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
        return flag;//�����ƨϥΪ̦^��1
    }
}
