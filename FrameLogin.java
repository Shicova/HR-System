package HR_Package;

import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.DropMode;
import java.awt.Font;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.UIManager;

public class FrameLogin extends JFrame {
	// SQL�]�w
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost:3306/HRsystem?"
    	                    	+ "useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    static final String USERNAME = "root";
    static final String PASSWORD = "12345678";
	
    private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameLogin frame = new FrameLogin();
					frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
						}
				}
			});
		}
	Color  black  = new Color(44, 47, 51); /*�]�w��������*/
	// �ŧi�U�ت���
	private JTextField txtUserName;
	private JPasswordField txtPassword;
	private JTextField textSingIN;
	private JLabel lblLoginMessage = new JLabel("");
	
	// �غc�l
	public FrameLogin() {
		// �����G���]�w
		contentPane = new JPanel();
		
		setBounds(100, 100, 360, 470);
		contentPane.setBackground(black);
		contentPane.setBorder(new LineBorder(UIManager.getColor("windowBorder"), 2));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true); /*�ϥ~�ؤ��ಾ��*/
		setLocationRelativeTo(null); /*�ϥ~�ئb�e������*/
		
		// �ϥΪ̦W�ٳ]�w 
		txtUserName = new JTextField();
		txtUserName.addFocusListener(new FocusAdapter() {
			@Override  /*��Ц�m*/
			public void focusGained(FocusEvent e) {
				txtUserName.setForeground(Color.black); /*��Цb�ɡA�r�鬰�¦�*/
				if(txtUserName.getText().equals("UserName")) {
					txtUserName.setText("");
				}
				else {
					txtUserName.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				
				if(txtUserName.getText().equals("")){
					txtUserName.setText("UserName");
					txtUserName.setForeground(Color.gray);} /*������}�ɡA�r�鬰�Ǧ�*/
			}
		});
		txtUserName.setText("UserName");
		txtUserName.setFont(new Font("Arial", Font.BOLD, 15));
		txtUserName.setForeground(Color.gray); /*�r��w�]���Ǧ�*/
		txtUserName.setBounds(70, 211, 216, 21);
		contentPane.add(txtUserName);
		txtUserName.setColumns(10);
		txtUserName.setBorder(null);
		
		// �ϥΪ̱K�X�]�w
		txtPassword = new JPasswordField();
		txtPassword.addFocusListener(new FocusAdapter() {
			@Override  /*��Ц�m*/
			public void focusGained(FocusEvent e) {
				txtPassword.setForeground(Color.black); /*��Цb�ɡA�r�鬰�¦�*/
				if(txtPassword.getText().equals("Password")) {
					txtPassword.setEchoChar('��');
					txtPassword.setText("");
				}
				else {
					txtPassword.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				
				if(txtPassword.getText().equals("")) {
					txtPassword.setText("Password");
					txtPassword.setEchoChar((char)0);
					txtPassword.setForeground(Color.gray); /*������}�ɡA�r�鬰�Ǧ�*/
					
				}					
			}
		});
		txtPassword.setText("Password");		
		txtPassword.setFont(new Font("Arial", Font.BOLD, 15));	
		txtPassword.setForeground(Color.gray); /*�r��w�]���Ǧ�*/
		txtPassword.setBounds(70, 269, 216, 21);
		contentPane.add(txtPassword);
		txtPassword.setBorder(null);
		txtPassword.setEchoChar((char)0); /*�]�w�^���r���A(char)0 ��{�쥻��r*/
		
		// �ϥΪ̦W�٩��ϳ]�w
		JLabel lblUserName = new JLabel("");
		lblUserName.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserName.setIcon(new ImageIcon(FrameLogin.class.getResource("/img/Arc_UserName.png")));
		lblUserName.setBounds(10, 184, 340, 75);
		contentPane.add(lblUserName);
		 //�վ�Ϲ��j�p�ŦX�~��
		lblUserName.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Arc_UserName.png")).getImage().getScaledInstance(267, 40, Image.SCALE_SMOOTH)));
		
		// �ϥΪ̱K�X���ϳ]�w
		JLabel lblPassWord = new JLabel("");
		lblPassWord.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassWord.setIcon(new ImageIcon(FrameLogin.class.getResource("/img/Arc_UserName.png")));
		lblPassWord.setBounds(7, 243, 340, 75);
		contentPane.add(lblPassWord);
		 // �վ�Ϲ��j�p�ŦX�~��
		lblPassWord.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Arc_UserName.png")).getImage().getScaledInstance(267, 40, Image.SCALE_SMOOTH)));
		
		// �n�J���s��ť
		JButton SignINButton = new JButton("SIGN IN");
		SignINButton.addMouseListener(new MouseAdapter() {			
     		@Override   
     		//���s��|��ܰT������
			public void mouseClicked(MouseEvent e) {
				Connection conn = null;
		        Statement stmt = null;
		        ResultSet rs = null;
		   
		        try{
		            Class.forName(JDBC_DRIVER);		            
		            conn = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
		            stmt = conn.createStatement();
		            String user_login;
		            
		            user_login = "SELECT id_comp,password FROM Emp_Treat";
		            rs = stmt.executeQuery(user_login);		
		            		            
		           
//		            //�b���K�X���ŭ�
//					if(txtUserName.getText().equals("")||txtUserName.getText().equals("UserName")||
//					       txtPassword.getText().equals("")||txtPassword.getText().equals("Password")) {
//						lblLoginMessage.setText("Please input all requirements!");
//						}					
//				   //�޲z���n�J:�b�����T
//					else if(txtUserName.getText().equals("admin")) {
//						//�K�X���T
//						if(txtPassword.getText().equals("admin123")) {
//							lblLoginMessage.setText("");
//							JOptionPane.showMessageDialog(null, "Login Successful");
//						     // ���I���إ� �D�e��
//							FrameB_Dashboard frameB_Dashboard = new FrameB_Dashboard();
//						     // �����n�J����
//							FrameLogin.this.dispose();
//						     // ��ܥD�e��
//							frameB_Dashboard.setVisible(true);
//						}
//						//�K�X���~
//						else {
//							lblLoginMessage.setText("Username and password didn't match!");
//							}
//						}
//					else if (rs.next()) {
//					
//					
//						//���u�n�J
//			            while (rs.next()) {
//			            	String id_comp = rs.getString("id_comp");
//			            	String password = rs.getString("password");
//			            	
//			            	//�b���K�X���T
//			            	if (txtUserName.getText().equals(id_comp) && txtPassword.getText().equals(password)) {
//			            		JOptionPane.showMessageDialog(null, "Login Successful");
//							     // ���I���إ� �D�e��
//								FrameDashboard frameDashboard = new FrameDashboard(id_comp,id_comp);
//							     // �����n�J����
//								FrameLogin.this.dispose();
//							     // ��ܥD�e��
//								frameDashboard.setVisible(true);
//								}
//			            	//�b�����T�B�K�X���~
//			            	else if (txtUserName.getText().equals(id_comp)){
//			            		lblLoginMessage.setText("Username and password didn't match!");
//			            		}
//			            	} 	}else {	            
//			            //�b�����s�b
//			            
//			            	lblLoginMessage.setText("Username isn't existed!");}
			            	
		          //�b���K�X���ŭ�
					if(txtUserName.getText().equals("")||txtUserName.getText().equals("UserName")||
					       txtPassword.getText().equals("")||txtPassword.getText().equals("Password")) {
						lblLoginMessage.setText("Please input all requirements!");
						}					
				   //�޲z���n�J:�b�����T
					if(txtUserName.getText().equals("admin")) {
						//�K�X���T
						if(txtPassword.getText().equals("admin123")) {
							lblLoginMessage.setText("");
							JOptionPane.showMessageDialog(null, "Login Successful");
							// ���I���إ� �D�e��
							FrameB_Dashboard frameB_Dashboard = new FrameB_Dashboard();
						     // �����n�J����
							FrameLogin.this.dispose();
						     // ��ܥD�e��
							frameB_Dashboard.setVisible(true);
							}
						//�K�X���~
						else {
							lblLoginMessage.setText("Username and password didn't match!");
							}
						}
					
						//���u�n�J
						
		            	while (rs.next()) {
		            	String id_comp = rs.getString("id_comp");
		            	String password = rs.getString("password");
		            	
		            	//�b���K�X���T
		            	if (txtUserName.getText().equals(id_comp) && txtPassword.getText().equals(password)) {
		            		JOptionPane.showMessageDialog(null, "Login Successful");
						     // ���I���إ� �D�e��
							FrameDashboard frameDashboard = new FrameDashboard(id_comp);
						     // �����n�J����
							FrameLogin.this.dispose();
						     // ��ܥD�e��
							frameDashboard.setVisible(true);
							break;
							}
		            	//�b�����T�B�K�X���~
		            	else if (txtUserName.getText().equals(id_comp)){
		            		lblLoginMessage.setText("Username and password didn't match!");
		            		}
		            	
		            	else {
		            		lblLoginMessage.setText("Username isn't existed!");
		            	}
		            
		            	}
														
//						//���u�n�J
//					
//			            	while (rs.next()) {
//			            	String id_comp = rs.getString("id_comp");
//			            	String password = rs.getString("password");
//			            	
//			            	//�b���K�X���T
//			            	if (txtUserName.getText().equals(id_comp) && txtPassword.getText().equals(password)) {
//			            		JOptionPane.showMessageDialog(null, "Login Successful");
//							     // ���I���إ� �D�e��
//								FrameDashboard frameDashboard = new FrameDashboard(id_comp);
//							     // �����n�J����
//								FrameLogin.this.dispose();
//							     // ��ܥD�e��
//								frameDashboard.setVisible(true);
//								break;
//								}
//			            	//�b�����T�B�K�X���~
//			            	else if (txtUserName.getText().equals(id_comp)){
//			            		lblLoginMessage.setText("Username and password didn't match!");
//			            		}
//			            	
//			            	else {
//			            		lblLoginMessage.setText("Username isn't existed!");
//			            	}
//			            
//			            	}
			     	
						
						
						
					
					
					
					
					
					
					
					
					// ������Ʈw�s��
		            rs.close();
		            stmt.close();
		            conn.close();
		        }catch(SQLException se){
		        	se.printStackTrace();
		        }catch(Exception e1){
		        	e1.printStackTrace();
		        }
		        System.out.println("Exit Select Mysql DB Example!");		   	
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				SignINButton.setBackground(new Color(30,60,60));
			}
		});
		SignINButton.setForeground(Color.WHITE);
		SignINButton.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		SignINButton.setBounds(6, 351, 340, 23);
		SignINButton.setOpaque(false);/*�]�m���z��*/
		SignINButton.setContentAreaFilled(false);/*���B�׫᭱���I��*/
		SignINButton.setMargin(new Insets(0,0,0,0));/*�]�m��ج�0�A���O���W�A���A�U�A�k*/
		SignINButton.setBorderPainted(false);/*���ѬO�_ø�s��� �_*/
		SignINButton.setBorder(null);/*�L���*/
		contentPane.add(SignINButton);
		
		//�n�J���s���ϳ]�w
		JLabel lblSignIN = new JLabel("");
		lblSignIN.setHorizontalAlignment(SwingConstants.CENTER);
		lblSignIN.setIcon(new ImageIcon(FrameLogin.class.getResource("/img/Arc_SignIn.png")));
		lblSignIN.setBounds(7,326, 340, 75);
		contentPane.add(lblSignIN);
		//�վ�Ϲ��j�p�ŦX�~��
		lblSignIN.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Arc_SignIn.png")).getImage().getScaledInstance(267, 40, Image.SCALE_SMOOTH)));

		
		// EXIT���s��ť�A�P�_��������
		JButton ExitButton = new JButton("Exit");
		ExitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (JOptionPane.showConfirmDialog(null, 
						"Are you sure you want to close this application?",
						"Confirmation",JOptionPane.YES_NO_OPTION)==0) {
					 FrameLogin.this.dispose();
				}else {	}			     
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				ExitButton.setForeground(Color.RED);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				ExitButton.setForeground(Color.WHITE);
			}
		});
				
		ExitButton.setForeground(Color.LIGHT_GRAY); /*�]�w�r���C��*/
//		ExitButton.setBackground(Color.LIGHT_GRAY); /*�]�w�I����*/
		ExitButton.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		ExitButton.setBounds(10, 411, 340, 23);
//		ExitButton.setOpaque(false);/*�]�m���z��*/
		ExitButton.setContentAreaFilled(false);/*���B�׫᭱���I��*/
		ExitButton.setMargin(new Insets(0,0,0,0));/*�]�m��ج�0�A���O���W�A���A�U�A�k*/
		ExitButton.setBorderPainted(false);/*���ѬO�_ø�s��� �_*/
		ExitButton.setBorder(null);/*�L���*/
		contentPane.add(ExitButton);
		
		//�]�wLogo�Ϥ�
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(FrameLogin.class.getResource("/img/logo.png")));
		lblNewLabel.setBounds(10, 51, 340, 130);
		//�վ�Ϲ��j�p�ŦX�~��
		lblNewLabel.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo.png")).getImage().getScaledInstance(204, 110, Image.SCALE_SMOOTH)));
		contentPane.add(lblNewLabel);
		
//		JLabel label = new JLabel("New label");
//		label.setBounds(98, 358, 165, 16);
//		contentPane.add(label);
		
		
	    /*
		JLabel lblExit_ = new JLabel("X");
		lblExit_.addMouseListener(new MouseAdapter() {
			//�k�W��x�[�J�P�_�O�_����������
			@Override
			public void mouseClicked(MouseEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Are you sure you want to close this application?","Confirmation",JOptionPane.YES_NO_OPTION)==0);
			      FrameLogin.this.dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblExit_.setForeground(Color.RED);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblExit_.setForeground(Color.WHITE);
			}
		});
		lblExit_.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 14));
		lblExit_.setForeground(Color.WHITE);
		lblExit_.setBounds(335, 10, 14, 23);
		contentPane.add(lblExit_);
		*/
		
		//�b�K���~���ܰT��
		lblLoginMessage.setFont(new Font("Arial", Font.BOLD, 12));
		lblLoginMessage.setForeground(Color.PINK);
		lblLoginMessage.setBounds(57, 315, 253, 15);
		contentPane.add(lblLoginMessage);
		}	
	
	
	
	
}
