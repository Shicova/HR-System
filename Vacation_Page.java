package HR_Package;

import java.awt.Color;

import java.util.*;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.plaf.metal.MetalComboBoxButton;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.List;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import PageWork.PageQuery;
import javax.swing.JButton;


public class Vacation_Page extends JPanel {
	// SQL設定
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost:3306/HRsystem?"
	                          + "useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
	static final String USERNAME = "root";
	static final String PASSWORD = "12345678";
	private JComboBox cb_idcomp;
	
	//建構子
	public Vacation_Page() {
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		
		//透明背景區塊
		setBackground(SystemColor.menu);
		setBounds(35,43,670, 550);
		setLayout(null);
		setBorder(null);
		setOpaque(false);//背景透明
		
		try{
			Class.forName(JDBC_DRIVER);	            
			conn = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
			stmt = conn.createStatement();
						
		//第一列 填表日期與部門
			//第一列框架
			JPanel panel1 = new JPanel();
			panel1.setLayout(null);
			panel1.setBounds(45, 50, 580, 50);
			panel1.setOpaque(false);//背景透明
			add(panel1);
			
		    /*填表日期 Date*/
			//填表日期_標籤		
			JLabel lb_date = new JLabel("填表日期",JLabel.LEFT);
			lb_date.setBounds(300, 10, 94, 30);
			lb_date.setFont(new Font("Microsoft JhengHei", Font.BOLD, 20));
			//填表日期_文字 (系統依當日自動生成)
			DateFormat dateFormat = new SimpleDateFormat("YYYY/MM/dd");
			JFormattedTextField tf_today = new JFormattedTextField(dateFormat); /*tf_today 為自動抓取時間的TextField*/
			tf_today.setBounds(390, 10, 180, 30);
			tf_today.setName("today");
			tf_today.setColumns(10);
			tf_today.setEditable(false);
			tf_today.setFont(new Font("微軟正黑體", Font.BOLD, 20));
			tf_today.setValue(new Date());
			lb_date.setLabelFor(tf_today); /*連結兩個物件*/
			panel1.add(lb_date);
			panel1.add(tf_today);
								
			/*部門 Department*/
			//部門_標籤
			JLabel lb_depart = new JLabel("部       門");
			lb_depart.setBounds(10, 10, 80, 30);
			lb_depart.setFont(new Font("Microsoft JhengHei", Font.BOLD, 20));
			panel1.add(lb_depart);
			
			//部門_文字(下拉選單)
			String[] arr ={"--請選擇部門--"};
			JComboBox cb_deaprt = new JComboBox(arr);   /*建立「部門」的下拉式選單(空)*/
			ResultSet rs;			
			try {
				stmt = conn.createStatement();
				rs = stmt.executeQuery("SELECT DISTINCT department FROM emp_data");
				while(rs.next()) {
					cb_deaprt.addItem(rs.getString("department"));  /*在下拉式選單中加入「部門」的項目*/
					}
				rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
					}	
			
			cb_deaprt.setBounds(100, 10, 180, 30);
			cb_deaprt.setFont(new Font("微軟正黑體", Font.BOLD, 20));
			cb_deaprt.setBorder(null);//去除邊框
			panel1.add(cb_deaprt);
			

		//第二列 人員姓名、人員編號
			//第二列框架
			JPanel panel2 = new JPanel();
			panel2.setLayout(null);
			panel2.setBounds(45, 100, 580, 50);
			panel2.setOpaque(false);//背景透明
			add(panel2);
						
			//人員編號 Id_Comp
			//人員編號_標籤
			JLabel lb_idcomp = new JLabel("人員編號");
			lb_idcomp.setBounds(10, 10, 90, 30);
			lb_idcomp.setFont(new Font("微軟正黑體", Font.BOLD, 20));
			panel2.add(lb_idcomp);
			//人員編號_文字(下拉選單)
			
			cb_idcomp = new JComboBox();                  /*建立「人員編號」的下拉式選單(空)*/
			cb_idcomp.setBounds(100, 10, 180, 30);
			cb_idcomp.setFont(new Font("微軟正黑體", Font.BOLD, 20));
//			cb_idcomp.setBorder(null);//去除邊框				
			panel2.add(cb_idcomp);
			
			//人員姓名 Name
			//人員姓名_標籤
			JLabel lb_name = new JLabel("人員姓名");
			lb_name.setBounds(300, 10, 90, 30);
			lb_name.setFont(new Font("微軟正黑體", Font.BOLD, 20));
			panel2.add(lb_name);
			//人員姓名_文字區域
			JTextField tf_name = new JTextField();                  /*建立「人員姓名」的文字區域(空)*/
			tf_name.setBounds(390, 10, 180, 30);
			tf_name.setFont(new Font("微軟正黑體", Font.BOLD, 20));
//			tf_name.setBorder(null);//去除邊框	
			tf_name.setEditable(false);
			panel2.add(tf_name);
	
		//第三列 起始日期、截止日期
			//第三列框架
			JPanel panel3 = new JPanel();
			panel3.setLayout(null);
			panel3.setBounds(45, 150, 580, 50);
			panel3.setOpaque(false);//背景透明
			add(panel3);
				
			//起始日期 St_Day
			//起始日期_標籤
			JLabel lb_stday = new JLabel("起始日期");
			lb_stday.setBounds(10, 10, 91, 30);
			lb_stday.setFont(new Font("微軟正黑體", Font.BOLD, 20));
			panel3.add(lb_stday);
			
			//起始日期_時間選擇器
			JDateChooser dateChooser_stday = new JDateChooser();
			dateChooser_stday.setBounds(100, 10, 180, 30);
			dateChooser_stday.setFont(new Font("微軟正黑體", Font.BOLD, 16));
			panel3.add(dateChooser_stday);
			
			//截止日期 Ed_Day
			//截止日期_標籤
			JLabel lb_edday = new JLabel("截止日期");
			lb_edday.setFont(new Font("微軟正黑體", Font.BOLD, 20));
			lb_edday.setBounds(300, 10, 91, 30);
			panel3.add(lb_edday);
			
			//截止日期_時間選擇器
			JDateChooser dateChooser_edday = new JDateChooser();
			dateChooser_edday.setBounds(390, 10, 180, 30);
			dateChooser_edday.setFont(new Font("微軟正黑體", Font.BOLD, 16));
			panel3.add(dateChooser_edday);
			
		//第四列 假別、請假時數	
			//第四列框架
			JPanel panel4 = new JPanel();
			panel4.setLayout(null);
			panel4.setBounds(45, 200, 580, 50);
			panel4.setOpaque(false);//背景透明
			add(panel4);
			
			//請假假別_標籤
			JLabel lb_leave_type = new JLabel("請假假別");
			lb_leave_type.setFont(new Font("微軟正黑體", Font.BOLD, 20));
			lb_leave_type.setBounds(10, 10, 90, 30);
			panel4.add(lb_leave_type);
			
			//請假假別_單選
			JRadioButton rb_leave_type = new JRadioButton("休假");
			rb_leave_type.setFont(new Font("微軟正黑體", Font.BOLD, 18));
			rb_leave_type.setBounds(93, 9, 67, 32);
			rb_leave_type.setOpaque(false);//背景透明
						
			JRadioButton rb_leave_type1 = new JRadioButton("事假");
			rb_leave_type1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
			rb_leave_type1.setBounds(156, 9, 67, 32);
			rb_leave_type1.setOpaque(false);//背景透明
						
			JRadioButton rb_leave_type2 = new JRadioButton("其他");
			rb_leave_type2.setFont(new Font("微軟正黑體", Font.BOLD, 18));
			rb_leave_type2.setBounds(225, 9, 67, 32);
			rb_leave_type2.setOpaque(false);//背景透明
			
			ButtonGroup bg = new ButtonGroup();
			bg.add(rb_leave_type); 
			bg.add(rb_leave_type1);	
			bg.add(rb_leave_type2);			
			panel4.add(rb_leave_type);
			panel4.add(rb_leave_type1);
			panel4.add(rb_leave_type2);
			
			//請假時數_標籤
			JLabel lb_leave_period = new JLabel("請假時數");
			lb_leave_period.setFont(new Font("微軟正黑體", Font.BOLD, 20));
			lb_leave_period.setBounds(300, 10, 85, 30);
			panel4.add(lb_leave_period);
			JLabel lb_leave_hrs = new JLabel("小時");
			lb_leave_hrs.setFont(new Font("微軟正黑體", Font.BOLD, 20));
			lb_leave_hrs.setBounds(526, 10, 44, 30);
			panel4.add(lb_leave_hrs);
			//請假時數_文字區域
			JTextField tf_leave = new JTextField();                  /*建立「請假時數」的文字區域*/
			tf_leave.setBounds(395, 10, 126, 30);
			tf_leave.setFont(new Font("微軟正黑體", Font.BOLD, 20));
//			tf_leave.setBorder(null);//去除邊框	
			panel4.add(tf_leave);
			
		//第五列 請假事由	
			//第五列框架
			JPanel panel5 = new JPanel();
			panel5.setLayout(null);
			panel5.setBounds(45, 250, 332, 190);
			panel5.setOpaque(false);//背景透明
			add(panel5);	
				
			//請假事由欄
			//請假事由_標籤
			JLabel lb_leave_reason = new JLabel("請假事由");
			lb_leave_reason.setFont(new Font("微軟正黑體", Font.BOLD, 20));
			lb_leave_reason.setBounds(10, 10, 100, 30);
			panel5.add(lb_leave_reason);
			
			JTextArea tf_leave_reason = new JTextArea();
			tf_leave_reason.setBounds(10, 49, 310, 137);
			tf_leave_reason.setFont(new Font("Microsoft JhengHei", Font.BOLD, 20));
			tf_leave_reason.setLineWrap(true);
			tf_leave_reason.setWrapStyleWord(true);
			panel5.add(tf_leave_reason);
			
			/*
			JTextArea textArea = new JTextArea();
			textArea.setBounds(10, 50, 560, 200);
			panel5.add(textArea);
			textArea.setColumns(10);
			textArea.setFont(new Font("微軟正黑體", Font.BOLD, 20));
			textArea.setBorder(null);
			*/
		
			
		//第六列 請假資訊
			JPanel panel6 = new JPanel();
			panel6.setBounds(427, 300, 173, 130);
			add(panel6);
			panel6.setLayout(null);
			panel6.setOpaque(false);//背景透明
			JLabel lb_rest_leave = new JLabel("休假:");
			lb_rest_leave.setForeground(Color.WHITE);
			lb_rest_leave.setFont(new Font("微軟正黑體", Font.BOLD, 20));
			lb_rest_leave.setBounds(0, 25, 61, 30);
			panel6.add(lb_rest_leave);
						
			JTextField tf_rest_leave = new JTextField();
			tf_rest_leave.setForeground(Color.WHITE);
			tf_rest_leave.setHorizontalAlignment(SwingConstants.CENTER);
			tf_rest_leave.setFont(new Font("微軟正黑體", Font.BOLD, 20));
			tf_rest_leave.setEditable(false);
			tf_rest_leave.setBounds(42, 25, 84, 30);
			tf_rest_leave.setOpaque(false);//背景透明
			tf_rest_leave.setBorder(null);
			panel6.add(tf_rest_leave);
			
			JLabel lb_personal_leave = new JLabel("事假:");
			lb_personal_leave.setForeground(Color.WHITE);
			lb_personal_leave.setFont(new Font("微軟正黑體", Font.BOLD, 20));
			lb_personal_leave.setBounds(0, 60, 61, 30);
			panel6.add(lb_personal_leave);
			
			JTextField tf_personal_leave = new JTextField();
			tf_personal_leave.setForeground(Color.WHITE);
			tf_personal_leave.setHorizontalAlignment(SwingConstants.CENTER);
			tf_personal_leave.setFont(new Font("微軟正黑體", Font.BOLD, 20));
			tf_personal_leave.setEditable(false);
			tf_personal_leave.setBounds(42, 60, 84, 30);
			tf_personal_leave.setOpaque(false);//背景透明
			tf_personal_leave.setBorder(null);
			panel6.add(tf_personal_leave);
			
			JLabel lb_sick_leave = new JLabel("病假:");
			lb_sick_leave.setForeground(Color.WHITE);
			lb_sick_leave.setFont(new Font("微軟正黑體", Font.BOLD, 20));
			lb_sick_leave.setBounds(0, 100, 61, 30);
			panel6.add(lb_sick_leave);
			
			JTextField tf_sick_leave = new JTextField();
			tf_sick_leave.setForeground(Color.WHITE);
			tf_sick_leave.setHorizontalAlignment(SwingConstants.CENTER);
			tf_sick_leave.setFont(new Font("微軟正黑體", Font.BOLD, 20));
			tf_sick_leave.setEditable(false);
			tf_sick_leave.setBounds(42, 100, 86, 30);
			tf_sick_leave.setOpaque(false);//背景透明
			tf_sick_leave.setBorder(null);
			panel6.add(tf_sick_leave);
			
			JLabel lb_rest_leave_1 = new JLabel("小時");
			lb_rest_leave_1.setForeground(Color.WHITE);
			lb_rest_leave_1.setFont(new Font("微軟正黑體", Font.BOLD, 20));
			lb_rest_leave_1.setBounds(126, 25, 47, 30);
			panel6.add(lb_rest_leave_1);
			
			JLabel lb_personal_leave_1 = new JLabel("小時");
			lb_personal_leave_1.setForeground(Color.WHITE);
			lb_personal_leave_1.setFont(new Font("微軟正黑體", Font.BOLD, 20));
			lb_personal_leave_1.setBounds(126, 60, 47, 30);
			panel6.add(lb_personal_leave_1);
			
			JLabel lb_sick_leave_1 = new JLabel("小時");
			lb_sick_leave_1.setForeground(Color.WHITE);
			lb_sick_leave_1.setFont(new Font("微軟正黑體", Font.BOLD, 20));
			lb_sick_leave_1.setBounds(125, 100, 48, 30);
			panel6.add(lb_sick_leave_1);
			
			
			//點「部門」時的觸發事件 →「人員編號」的下拉式選單	
			cb_deaprt.addActionListener(new ActionListener() {      /*暺��������������犖�蝺刻������������*/
				public void actionPerformed(ActionEvent e) {					
					String search_depart = (String) cb_deaprt.getSelectedItem();			
					getIdCompFromDepart(search_depart);															
					}
				});
			
			
            //點「人員編號」時的觸發事件1 →「休假」時數呈現	
			cb_idcomp.addActionListener(new ActionListener() {      
				public void actionPerformed(ActionEvent e) {
					Connection conn = con();
					PreparedStatement pstmt;
					String sql = "SELECT `rest_leave`, `personal_leave`, `sick_leave` FROM Emp_Treat WHERE name = ?";
					
					try {
						pstmt = conn.prepareStatement(sql);
						pstmt.setString(1,tf_name.getText());
						pstmt.execute();
						
						ResultSet rs = pstmt.executeQuery();
						if(rs.next()) {
							String rest_leave_hours = rs.getString("rest_leave");
							String personal_leave_hours = rs.getString("personal_leave");
							String sick_leave_hours = rs.getString("sick_leave");
							
						tf_rest_leave.setText(rest_leave_hours);
						tf_personal_leave.setText(personal_leave_hours);
						tf_sick_leave.setText(sick_leave_hours);
												
						}else {
							tf_rest_leave.setText("");
							tf_personal_leave.setText("");
							tf_sick_leave.setText("");
						}
						
						
						conn.close();
						pstmt.close();	
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
									
					}});	
			
			//點「人員編號」時的觸發事件2 →「人員姓名」的文字區域	
			cb_idcomp.addActionListener(new ActionListener() {      /*點擊「人員編號」的下拉式選單時，「人員姓名」的文字區域的聯動*/
				public void actionPerformed(ActionEvent e) {
					PageQuery pq = new PageQuery();                 /*使用自定的PageQuery類別建構物件pq*/
					
					tf_name.setText(pq.From_IdComp_get_Name((String)cb_idcomp.getSelectedItem()));	/*將「人員編號」項目帶入From_IdComp_get_Name方法中找「人員姓名」*/			
					}
				}
			);

					JButton btn_check = new JButton("送出");
					btn_check.setBounds(213, 464, 85, 37);
					add(btn_check);
					btn_check.setFont(new Font("微軟正黑體", Font.BOLD, 20));
					
					// 清除按鈕
					JButton btn_clear = new JButton("清除");
					btn_clear.setBounds(382, 464, 85, 37);
					add(btn_clear);
					btn_clear.setFont(new Font("微軟正黑體", Font.BOLD, 20));
					
					//點擊「清除」按鈕的觸發事件 → 資料清除
					btn_clear.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							//清除時間
							dateChooser_stday.setCalendar(null);
							dateChooser_edday.setCalendar(null);
							//清除假別
							bg.clearSelection();									
							//清除時數
							tf_leave.setText("");
							//清除事由
							tf_leave_reason.setText("");							
						}										
					});
					
					JLabel lb_has = new JLabel("已請假時數");
					lb_has.setForeground(Color.WHITE);
					lb_has.setBounds(460, 272, 106, 30);
					add(lb_has);
					lb_has.setFont(new Font("微軟正黑體", Font.BOLD, 20));					
					
					JLabel lblNewLabel = new JLabel("");
					lblNewLabel.setIcon(new ImageIcon(Vacation_Page.class.getResource("/img/Holiday_background.png")));
					lblNewLabel.setBounds(418, 258, 189, 179);
					//調整圖像大小符合外框
					lblNewLabel.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Holiday_background.png")).getImage().getScaledInstance(188, 181, Image.SCALE_SMOOTH)));
					add(lblNewLabel);					
					
			        //半透明圓角視窗
			        JLabel lblMainContent = new JLabel("");
					lblMainContent.setHorizontalAlignment(SwingConstants.CENTER);
					lblMainContent.setIcon(new ImageIcon(FrameDashboard.class.getResource("/img/JPanel-1.png")));
					lblMainContent.setBounds(0, 0, getWidth(), getHeight());
					//調整圖像大小符合外框
					lblMainContent.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/img/JPanel-1.png")).getImage().getScaledInstance(lblMainContent.getWidth(), lblMainContent.getHeight(), Image.SCALE_SMOOTH)));
					add(lblMainContent);
					
					
					//點擊「送出」按鈕的觸發事件 → 送出請假時數
					btn_check.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e) {				
							
							//確認起始時間比截止時間早		
							Date date_st = dateChooser_stday.getDate();
							Date date_ed = dateChooser_edday.getDate();
							DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	  					
	 		    try {	 		    	
	 		    	if (date_ed.before(date_st)) {
					        	JOptionPane.showMessageDialog(null,"起始日期不得晚於截止日期","注意",JOptionPane.INFORMATION_MESSAGE);
					        	}else{
					        	 
					        	 //確認請假時數小於該日天的工作時數					    
							     Long st = Long.valueOf(dateFormat.format(date_st).replaceAll("-", ""));  /*起始日期轉為數字*/
							     Long ed = Long.valueOf(dateFormat.format(date_ed).replaceAll("-", ""));  /*截止日期轉為數字*/
							     Long day = (ed-st)+1;                           /*請假天數*/ 
							     Long hours = Long.valueOf(tf_leave.getText());  /*請假時數*/				
							    			    
							     if ( hours > day*8 ){
							    	JOptionPane.showMessageDialog(null,"請假總時數大於每日工作時間","注意",JOptionPane.INFORMATION_MESSAGE);
							    	}else {
							    		
											try {
												Connection conn = con();
												PreparedStatement pstmt;
												String sql1 = "UPDATE Emp_Treat SET rest_leave = rest_leave + ? WHERE name = ?";
												String sql2 = "UPDATE Emp_Treat SET personal_leave = personal_leave + ? WHERE name = ?";		
												String sql3 = "UPDATE Emp_Treat SET sick_leave = sick_leave + ? WHERE name = ?";		
												String sql4 = "SELECT `rest_leave`, `personal_leave`, `sick_leave` FROM Emp_Treat WHERE name = ?";
												
												pstmt = conn.prepareStatement(sql4);
												pstmt.setString(1,tf_name.getText());
												pstmt.execute();
													
												ResultSet rs = pstmt.executeQuery();
												if(rs.next()) {
												String rest_leave_hours = rs.getString("rest_leave");
												String personal_leave_hours = rs.getString("personal_leave");
												String sick_leave_hours = rs.getString("sick_leave");
														
												tf_rest_leave.setText(rest_leave_hours);
												tf_personal_leave.setText(personal_leave_hours);
												tf_sick_leave.setText(sick_leave_hours);}																								
												
											if(rb_leave_type.isSelected()) {
												pstmt = conn.prepareStatement(sql1);
																						
												pstmt.setDouble(1, Double.parseDouble(tf_leave.getText()));
												pstmt.setString(2, tf_name.getText());
												pstmt.execute();
												
												JOptionPane.showMessageDialog(null, "已送出「休假」: "+ tf_leave.getText() + "小時");
												conn.close();
												pstmt.close();	
											}
											 else if (rb_leave_type1.isSelected()){
												pstmt = conn.prepareStatement(sql2);
																							
												pstmt.setDouble(1, Double.parseDouble(tf_leave.getText()));
												pstmt.setString(2, tf_name.getText());
												pstmt.execute();
												JOptionPane.showMessageDialog(null, "已送出「事假」: "+ tf_leave.getText() + "小時");
												conn.close();
												pstmt.close();	
												}								 
											 else if (rb_leave_type2.isSelected()){
												pstmt = conn.prepareStatement(sql3);
																								
												pstmt.setDouble(1, Double.parseDouble(tf_leave.getText()));
												pstmt.setString(2, tf_name.getText());
												pstmt.execute();
												JOptionPane.showMessageDialog(null, "已送出「其他假」: "+ tf_leave.getText() + "小時");
												conn.close();
												pstmt.close();	
												};
												
												} catch (SQLException e3) {
													e3.printStackTrace();
													}
											}
							     }
	 		    	}catch(Exception e2) {
	 		    		JOptionPane.showMessageDialog(null,"請確實填妥所需資訊","注意",JOptionPane.INFORMATION_MESSAGE);
	 		        	}
	 		    }});
					
			// 關閉資料庫連結
//			rs_depart.close();
            stmt.close();
            conn.close();	
            
	        }catch(SQLException se){
	        	se.printStackTrace();
	        }catch(Exception e1){
	        	e1.printStackTrace();
	        }
	        System.out.println("資料處理結束!");		   	
		}
		
	private void getIdCompFromDepart(String beSelected) {
		cb_idcomp.removeAllItems();                    
		
		Connection con = con();					
		try {
			String Id_comp = "SELECT * FROM emp_data WHERE department = ?";			
			PreparedStatement ps = con.prepareStatement(Id_comp);
			
			ps.setString(1, beSelected);			
			ps.execute();
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String s = rs.getString("id_comp");	
				cb_idcomp.addItem(s);					
				}
			}catch (Exception e) {			
				System.out.println("Error:" + e);
				}
		}
	
	public String getSelectedButtonText(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                return button.getText();
            }
        }
        return null;
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
}