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
	// SQL設定
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
	Color  black  = new Color(44, 47, 51); /*設定頁面底色*/
	// 宣告各種物件
	private JTextField txtUserName;
	private JPasswordField txtPassword;
	private JTextField textSingIN;
	private JLabel lblLoginMessage = new JLabel("");
	
	// 建構子
	public FrameLogin() {
		// 頁面佈局設定
		contentPane = new JPanel();
		
		setBounds(100, 100, 360, 470);
		contentPane.setBackground(black);
		contentPane.setBorder(new LineBorder(UIManager.getColor("windowBorder"), 2));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true); /*使外框不能移動*/
		setLocationRelativeTo(null); /*使外框在畫面中央*/
		
		// 使用者名稱設定 
		txtUserName = new JTextField();
		txtUserName.addFocusListener(new FocusAdapter() {
			@Override  /*游標位置*/
			public void focusGained(FocusEvent e) {
				txtUserName.setForeground(Color.black); /*游標在時，字體為黑色*/
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
					txtUserName.setForeground(Color.gray);} /*游標離開時，字體為灰色*/
			}
		});
		txtUserName.setText("UserName");
		txtUserName.setFont(new Font("Arial", Font.BOLD, 15));
		txtUserName.setForeground(Color.gray); /*字體預設為灰色*/
		txtUserName.setBounds(70, 211, 216, 21);
		contentPane.add(txtUserName);
		txtUserName.setColumns(10);
		txtUserName.setBorder(null);
		
		// 使用者密碼設定
		txtPassword = new JPasswordField();
		txtPassword.addFocusListener(new FocusAdapter() {
			@Override  /*游標位置*/
			public void focusGained(FocusEvent e) {
				txtPassword.setForeground(Color.black); /*游標在時，字體為黑色*/
				if(txtPassword.getText().equals("Password")) {
					txtPassword.setEchoChar('●');
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
					txtPassword.setForeground(Color.gray); /*游標離開時，字體為灰色*/
					
				}					
			}
		});
		txtPassword.setText("Password");		
		txtPassword.setFont(new Font("Arial", Font.BOLD, 15));	
		txtPassword.setForeground(Color.gray); /*字體預設為灰色*/
		txtPassword.setBounds(70, 269, 216, 21);
		contentPane.add(txtPassword);
		txtPassword.setBorder(null);
		txtPassword.setEchoChar((char)0); /*設定回應字元，(char)0 顯現原本文字*/
		
		// 使用者名稱底圖設定
		JLabel lblUserName = new JLabel("");
		lblUserName.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserName.setIcon(new ImageIcon(FrameLogin.class.getResource("/img/Arc_UserName.png")));
		lblUserName.setBounds(10, 184, 340, 75);
		contentPane.add(lblUserName);
		 //調整圖像大小符合外框
		lblUserName.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Arc_UserName.png")).getImage().getScaledInstance(267, 40, Image.SCALE_SMOOTH)));
		
		// 使用者密碼底圖設定
		JLabel lblPassWord = new JLabel("");
		lblPassWord.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassWord.setIcon(new ImageIcon(FrameLogin.class.getResource("/img/Arc_UserName.png")));
		lblPassWord.setBounds(7, 243, 340, 75);
		contentPane.add(lblPassWord);
		 // 調整圖像大小符合外框
		lblPassWord.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Arc_UserName.png")).getImage().getScaledInstance(267, 40, Image.SCALE_SMOOTH)));
		
		// 登入按鈕監聽
		JButton SignINButton = new JButton("SIGN IN");
		SignINButton.addMouseListener(new MouseAdapter() {			
     		@Override   
     		//按鈕後會顯示訊息提醒
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
		            		            
		           
//		            //帳號密碼有空值
//					if(txtUserName.getText().equals("")||txtUserName.getText().equals("UserName")||
//					       txtPassword.getText().equals("")||txtPassword.getText().equals("Password")) {
//						lblLoginMessage.setText("Please input all requirements!");
//						}					
//				   //管理員登入:帳號正確
//					else if(txtUserName.getText().equals("admin")) {
//						//密碼正確
//						if(txtPassword.getText().equals("admin123")) {
//							lblLoginMessage.setText("");
//							JOptionPane.showMessageDialog(null, "Login Successful");
//						     // 先背景建立 主畫面
//							FrameB_Dashboard frameB_Dashboard = new FrameB_Dashboard();
//						     // 關掉登入視窗
//							FrameLogin.this.dispose();
//						     // 顯示主畫面
//							frameB_Dashboard.setVisible(true);
//						}
//						//密碼錯誤
//						else {
//							lblLoginMessage.setText("Username and password didn't match!");
//							}
//						}
//					else if (rs.next()) {
//					
//					
//						//員工登入
//			            while (rs.next()) {
//			            	String id_comp = rs.getString("id_comp");
//			            	String password = rs.getString("password");
//			            	
//			            	//帳號密碼正確
//			            	if (txtUserName.getText().equals(id_comp) && txtPassword.getText().equals(password)) {
//			            		JOptionPane.showMessageDialog(null, "Login Successful");
//							     // 先背景建立 主畫面
//								FrameDashboard frameDashboard = new FrameDashboard(id_comp,id_comp);
//							     // 關掉登入視窗
//								FrameLogin.this.dispose();
//							     // 顯示主畫面
//								frameDashboard.setVisible(true);
//								}
//			            	//帳號正確、密碼有誤
//			            	else if (txtUserName.getText().equals(id_comp)){
//			            		lblLoginMessage.setText("Username and password didn't match!");
//			            		}
//			            	} 	}else {	            
//			            //帳號不存在
//			            
//			            	lblLoginMessage.setText("Username isn't existed!");}
			            	
		          //帳號密碼有空值
					if(txtUserName.getText().equals("")||txtUserName.getText().equals("UserName")||
					       txtPassword.getText().equals("")||txtPassword.getText().equals("Password")) {
						lblLoginMessage.setText("Please input all requirements!");
						}					
				   //管理員登入:帳號正確
					if(txtUserName.getText().equals("admin")) {
						//密碼正確
						if(txtPassword.getText().equals("admin123")) {
							lblLoginMessage.setText("");
							JOptionPane.showMessageDialog(null, "Login Successful");
							// 先背景建立 主畫面
							FrameB_Dashboard frameB_Dashboard = new FrameB_Dashboard();
						     // 關掉登入視窗
							FrameLogin.this.dispose();
						     // 顯示主畫面
							frameB_Dashboard.setVisible(true);
							}
						//密碼錯誤
						else {
							lblLoginMessage.setText("Username and password didn't match!");
							}
						}
					
						//員工登入
						
		            	while (rs.next()) {
		            	String id_comp = rs.getString("id_comp");
		            	String password = rs.getString("password");
		            	
		            	//帳號密碼正確
		            	if (txtUserName.getText().equals(id_comp) && txtPassword.getText().equals(password)) {
		            		JOptionPane.showMessageDialog(null, "Login Successful");
						     // 先背景建立 主畫面
							FrameDashboard frameDashboard = new FrameDashboard(id_comp);
						     // 關掉登入視窗
							FrameLogin.this.dispose();
						     // 顯示主畫面
							frameDashboard.setVisible(true);
							break;
							}
		            	//帳號正確、密碼有誤
		            	else if (txtUserName.getText().equals(id_comp)){
		            		lblLoginMessage.setText("Username and password didn't match!");
		            		}
		            	
		            	else {
		            		lblLoginMessage.setText("Username isn't existed!");
		            	}
		            
		            	}
														
//						//員工登入
//					
//			            	while (rs.next()) {
//			            	String id_comp = rs.getString("id_comp");
//			            	String password = rs.getString("password");
//			            	
//			            	//帳號密碼正確
//			            	if (txtUserName.getText().equals(id_comp) && txtPassword.getText().equals(password)) {
//			            		JOptionPane.showMessageDialog(null, "Login Successful");
//							     // 先背景建立 主畫面
//								FrameDashboard frameDashboard = new FrameDashboard(id_comp);
//							     // 關掉登入視窗
//								FrameLogin.this.dispose();
//							     // 顯示主畫面
//								frameDashboard.setVisible(true);
//								break;
//								}
//			            	//帳號正確、密碼有誤
//			            	else if (txtUserName.getText().equals(id_comp)){
//			            		lblLoginMessage.setText("Username and password didn't match!");
//			            		}
//			            	
//			            	else {
//			            		lblLoginMessage.setText("Username isn't existed!");
//			            	}
//			            
//			            	}
			     	
						
						
						
					
					
					
					
					
					
					
					
					// 關閉資料庫連結
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
		SignINButton.setOpaque(false);/*設置為透明*/
		SignINButton.setContentAreaFilled(false);/*不遮擋後面的背景*/
		SignINButton.setMargin(new Insets(0,0,0,0));/*設置邊框為0，分別為上，左，下，右*/
		SignINButton.setBorderPainted(false);/*標識是否繪製邊框 否*/
		SignINButton.setBorder(null);/*無邊框*/
		contentPane.add(SignINButton);
		
		//登入按鈕底圖設定
		JLabel lblSignIN = new JLabel("");
		lblSignIN.setHorizontalAlignment(SwingConstants.CENTER);
		lblSignIN.setIcon(new ImageIcon(FrameLogin.class.getResource("/img/Arc_SignIn.png")));
		lblSignIN.setBounds(7,326, 340, 75);
		contentPane.add(lblSignIN);
		//調整圖像大小符合外框
		lblSignIN.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Arc_SignIn.png")).getImage().getScaledInstance(267, 40, Image.SCALE_SMOOTH)));

		
		// EXIT按鈕監聽，判斷關閉視窗
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
				
		ExitButton.setForeground(Color.LIGHT_GRAY); /*設定字體顏色*/
//		ExitButton.setBackground(Color.LIGHT_GRAY); /*設定背景色*/
		ExitButton.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		ExitButton.setBounds(10, 411, 340, 23);
//		ExitButton.setOpaque(false);/*設置為透明*/
		ExitButton.setContentAreaFilled(false);/*不遮擋後面的背景*/
		ExitButton.setMargin(new Insets(0,0,0,0));/*設置邊框為0，分別為上，左，下，右*/
		ExitButton.setBorderPainted(false);/*標識是否繪製邊框 否*/
		ExitButton.setBorder(null);/*無邊框*/
		contentPane.add(ExitButton);
		
		//設定Logo圖片
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(FrameLogin.class.getResource("/img/logo.png")));
		lblNewLabel.setBounds(10, 51, 340, 130);
		//調整圖像大小符合外框
		lblNewLabel.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo.png")).getImage().getScaledInstance(204, 110, Image.SCALE_SMOOTH)));
		contentPane.add(lblNewLabel);
		
//		JLabel label = new JLabel("New label");
//		label.setBounds(98, 358, 165, 16);
//		contentPane.add(label);
		
		
	    /*
		JLabel lblExit_ = new JLabel("X");
		lblExit_.addMouseListener(new MouseAdapter() {
			//右上角x加入判斷是否關閉的視窗
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
		
		//帳密錯誤提示訊息
		lblLoginMessage.setFont(new Font("Arial", Font.BOLD, 12));
		lblLoginMessage.setForeground(Color.PINK);
		lblLoginMessage.setBounds(57, 315, 253, 15);
		contentPane.add(lblLoginMessage);
		}	
	
	
	
	
}
