package HR_Package;

import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JDateChooser;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class Proclamationl_B_Page extends JPanel {
	private JTextField T_Title;        //主旨
	private JComboBox T_Department;    //部門
	private JDateChooser D_Time;       //時間
	private JTextArea textArea;        //說明
	

	/**
	 * Create the panel.
	 */
	public Proclamationl_B_Page() {
		setBounds(35,43,670, 550);
		setLayout(null);
		setBorder(null);
		setOpaque(false);//背景透明
		
		//第一列
		JPanel panel1 = new JPanel();
		panel1.setLayout(null);
		panel1.setBounds(45, 50, 575, 56);
		panel1.setOpaque(false);//背景透明
		add(panel1);
				
		JLabel W_Title = new JLabel("\u4E3B\u3000\u3000\u65E8",JLabel.LEFT);
		W_Title.setBounds(0, 10, 84, 30);
		W_Title.setFont(new Font("Microsoft JhengHei", Font.BOLD, 20));
		panel1.add(W_Title);
		
		T_Title = new JTextField();
		T_Title.setBounds(95, 10, 420, 30);
		T_Title.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		T_Title.setBorder(null);//去除邊框
		panel1.add(T_Title);
		T_Title.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(520, 10, 25, 25);
		panel1.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search.png")).getImage().getScaledInstance(19, 19, Image.SCALE_SMOOTH)));


		JButton Button_Search = new JButton("");
		Button_Search.setContentAreaFilled(false);
		Button_Search.setBounds(520, 10, 25, 25);
		Button_Search.setBorder(null);//去除邊框
		panel1.add(Button_Search);
		Button_Search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String search_Id = T_Title.getText().replaceAll("\\s+", "");
				SearchFromDatabase(search_Id);}
			});
		
		
		//第二列
		JPanel panel2 = new JPanel();
		panel1.setLayout(null);
		

		panel2.setBounds(45, 116, 298, 48);
		panel2.setOpaque(false);//背景透明
		add(panel2);
		panel2.setLayout(null);
		
		JLabel W_Time = new JLabel("\u516C\u544A\u6642\u9593");
		W_Time.setBounds(0, 0, 298, 48);
		W_Time.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		panel2.add(W_Time);
		
		D_Time = new JDateChooser();
		D_Time.setBounds(95, 10, 163, 28);
		D_Time.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		D_Time.setBorder(null);//去除邊框
		panel2.add(D_Time);

		
		
		//第三列	
		JPanel panel3 = new JPanel();
		panel3.setBounds(45, 238, 575, 204);
		panel3.setOpaque(false);//背景透明
		add(panel3);
		panel3.setLayout(null);
		
		JLabel W_Explanation = new JLabel("\u8AAA\u3000\u3000\u660E",JLabel.LEFT);
		W_Explanation.setBounds(0, 10, 85, 31);
		W_Explanation.setFont(new Font("Microsoft JhengHei", Font.BOLD, 20));
		panel3.add(W_Explanation);
		
				
		textArea = new JTextArea();
		textArea.setBounds(95, 10, 470, 185);
		textArea.setFont(new Font("Microsoft JhengHei", Font.BOLD, 20));
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		panel3.add(textArea);
		
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(95, 10, 470, 185);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);//需要時顯示垂直滾動條
		scrollPane.setViewportBorder(new EmptyBorder(0, 0, 0, 0));//隱藏邊框(要跟下一行一起)
		scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));//隱藏邊框(要跟上一行一起)
		panel3.add(scrollPane);
	
		
		JPanel panel4 = new JPanel();
		panel4.setLayout(null);
		panel4.setOpaque(false);
		panel4.setBounds(46, 177, 298, 48);
		add(panel4);
		
		JLabel W_Department = new JLabel("\u90E8\u3000\u3000\u9580");
		W_Department.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		W_Department.setBounds(0, 10, 83, 30);
		panel4.add(W_Department);
		
		//部門_文字欄
		String[] arr ={"--請選擇部門--"};
		String[] arr2 ={"人力資源部","技術研發部","公共關係部","總務部","營業部","秘書室"};
		//部門_下拉式選單		
		T_Department = new JComboBox(arr);   /*建立「部門」的下拉式選單(空)*/		
		for(String i:arr2) {T_Department.addItem(i);}		
		T_Department.setBounds(95, 10, 163, 30);
		T_Department.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		T_Department.setBorder(null);//去除邊框
		panel4.add(T_Department);
	
		
		JButton btnRevise = new JButton("\u4FEE\u6539");
		btnRevise.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		btnRevise.setBounds(164, 465, 85, 37);
		btnRevise.setBorder(null);//去除邊框
		add(btnRevise);
		
		//點擊「清除」按鈕的觸發事件 → 資料清除
		btnRevise.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//清除主旨
				T_Title.setText("");
				//清除時間
				D_Time.setCalendar(null);								
				//清除說明
				textArea.setText("");
				
			}
							
		});
		
		
		JButton btnConfirm = new JButton("\u78BA\u8A8D");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SaveToDatabase();
			}
		});
		btnConfirm.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		btnConfirm.setBounds(398, 465, 85, 37);
		btnConfirm.setBorder(null);//去除邊框
		add(btnConfirm);
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
			String search = "SELECT * FROM emp_news WHERE subject = ?";
			PreparedStatement ps = con.prepareStatement(search);
			
			ps.setString(1, beSelected);			
			ps.execute();
			
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				T_Title.setText(rs.getString("subject"));
				D_Time.setDate(rs.getDate("time"));
				T_Department.setSelectedItem(rs.getString("department"));				
				textArea.setText(rs.getString("explanation"));
				}
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

		
		
		
		private void SaveToDatabase() {
			Connection con = con();
			try {
				
				String query = "insert into emp_news values(?,?,?,?)";
				PreparedStatement ps = con.prepareStatement(query);
		
				ps.setString(1, T_Title.getText());
				ps.setDate(2, new java.sql.Date(D_Time.getDate().getTime()));
				ps.setString(3, (String)T_Department.getSelectedItem());
				ps.setString(4, textArea.getText());

				ps.execute();
				JOptionPane.showMessageDialog(null, "儲存成功！");

				
				ps.close();
				con.close();
						
				}catch (Exception e) {
					System.out.println("Error:" + e);
					JOptionPane.showMessageDialog(null, "請確認:\n所有欄位皆填寫完畢");
			}
		}
		

	}