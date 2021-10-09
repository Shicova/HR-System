package PageWork;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;


import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;


public class MenuEvent_B {
	/**
	 * @wbp.nonvisual location=52,101
	 */

	public MenuEvent_B(JPanel paneProclamation, 
			         JPanel paneInformation, 
			         JPanel paneSalary,
			         JPanel paneVacation,
			         JPanel paneChecklist,
			         JPanel labeltext,
			         JPanel paneChecklist_S,
			         Color black) {

		


		
	          
		
	       	 //說明文字
                //底圖設定				
		        labeltext.setBackground(black);
		        //paneProclamation.setBorder(new MatteBorder(2, 0, 1, 0, (Color) new Color(128, 128, 128)));
		        labeltext.setBounds(0, 150, 250, 50);				
		        labeltext.setLayout(null);
		        //文字設定
		        JLabel labeltext1 = new JLabel("\u5F8C\u53F0\u7CFB\u7D71");
		        labeltext1.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		        labeltext1.setForeground(Color.WHITE);
		        labeltext1.setBounds(90, 0, 99, 50);
		        labeltext.add(labeltext1);
		        
		
		     //公告欄設定
		        //底圖設定				
				paneProclamation.setBackground(black);
				paneProclamation.setBorder(new MatteBorder(2, 0, 1, 0, (Color) new Color(128, 128, 128)));
				paneProclamation.setBounds(0, 220, 250, 50);				
				paneProclamation.setLayout(null);
				//文字設定
				JLabel lblProclamationl = new JLabel("\u516C \u544A \u6B04");
				lblProclamationl.setForeground(Color.WHITE);
				lblProclamationl.setFont(new Font("微軟正黑體", Font.BOLD, 20));
				lblProclamationl.setBounds(96, 0, 99, 50);
				paneProclamation.add(lblProclamationl);
				//Icon設定
				JLabel lblProclamationl_icon = new JLabel("");
				lblProclamationl_icon.setHorizontalAlignment(SwingConstants.RIGHT);
				lblProclamationl_icon.setIcon(new ImageIcon(MenuEvent_B.class.getResource("/img/Proclamationl.png")));
				lblProclamationl_icon.setBounds(0, 0, 80, 50);
				//調整圖像大小符合外框
				lblProclamationl_icon.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Proclamationl.png")).getImage().getScaledInstance(19, 19, Image.SCALE_SMOOTH)));
				paneProclamation.add(lblProclamationl_icon);
				
			 //個人資料設定	
				//底圖設定	
				paneInformation.setBackground(black);
				paneInformation.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(128, 128, 128)));
				paneInformation.setBounds(0, 270, 250, 50);				
				paneInformation.setLayout(null);
				//文字設定
				JLabel lblInformation = new JLabel("員 工 個 資");
				lblInformation.setForeground(Color.WHITE);
				lblInformation.setFont(new Font("微軟正黑體", Font.BOLD, 20));
				lblInformation.setBounds(96, 0, 96, 50);
				paneInformation.add(lblInformation);
				//Icon設定
				JLabel lblInformation_icon = new JLabel("");
				lblInformation_icon.setHorizontalAlignment(SwingConstants.RIGHT);
				lblInformation_icon.setIcon(new ImageIcon(MenuEvent_B.class.getResource("/img/Information.png")));
				lblInformation_icon.setBounds(0, 0, 80, 50);
				//調整圖像大小符合外框
				lblInformation_icon.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Information.png")).getImage().getScaledInstance(16, 15, Image.SCALE_SMOOTH)));
				paneInformation.add(lblInformation_icon);
				
			//薪資設定
				//底圖設定	
				paneSalary.setBackground(black);
				paneSalary.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(128, 128, 128)));
				paneSalary.setBounds(0, 320, 250, 50);				
				paneSalary.setLayout(null);
				//文字設定
				JLabel lblSalary = new JLabel("員 工 薪 資");
				lblSalary.setForeground(Color.WHITE);
				lblSalary.setFont(new Font("微軟正黑體", Font.BOLD, 20));
				lblSalary.setBounds(96, 0, 105, 50);
				paneSalary.add(lblSalary);
				//Icon設定
				JLabel lblSalary_icon = new JLabel("");
				lblSalary_icon.setHorizontalAlignment(SwingConstants.RIGHT);
				lblSalary_icon.setIcon(new ImageIcon(MenuEvent_B.class.getResource("/img/Salary.png")));
				lblSalary_icon.setBounds(0, 0, 80, 50);
				//調整圖像大小符合外框
				lblSalary_icon.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Salary.png")).getImage().getScaledInstance(19, 19, Image.SCALE_SMOOTH)));
				paneSalary.add(lblSalary_icon);
				
		   //假期設定
				//底圖設定	
				paneVacation.setBackground(black);
				paneVacation.setBorder(new MatteBorder(1, 0, 2, 0, (Color) new Color(128, 128, 128)));
				paneVacation.setBounds(0, 370, 250, 50);		
				paneVacation.setLayout(null);
				//文字設定
				JLabel lblVacation = new JLabel("\u8ACB \u5047 \u7C3D \u6838");
				lblVacation.setForeground(Color.WHITE);
				lblVacation.setFont(new Font("微軟正黑體", Font.BOLD, 20));
				lblVacation.setBounds(96, 0, 102, 50);
				paneVacation.add(lblVacation);
				//Icon設定
				JLabel lblVacation_icon = new JLabel("");
				lblVacation_icon.setHorizontalAlignment(SwingConstants.RIGHT);
				lblVacation_icon.setIcon(new ImageIcon(MenuEvent_B.class.getResource("/img/Vacation.png")));
				lblVacation_icon.setBounds(0, 0, 80, 50);
				//調整圖像大小符合外框
				lblVacation_icon.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Vacation.png")).getImage().getScaledInstance(18, 16, Image.SCALE_SMOOTH)));
				paneVacation.add(lblVacation_icon);

				//員工清單設定
				//底圖設定	
				paneChecklist.setBackground(black);
				paneChecklist.setBorder(new MatteBorder(1, 0, 2, 0, (Color) new Color(128, 128, 128)));
				paneChecklist.setBounds(0, 420, 250, 50);		
				paneChecklist.setLayout(null);
				//文字設定
				JLabel lblChecklist = new JLabel("員 工 清 單");
				lblChecklist.setForeground(Color.WHITE);
				lblChecklist.setFont(new Font("微軟正黑體", Font.BOLD, 20));
				lblChecklist.setBounds(96, 0, 102, 50);
				paneChecklist.add(lblChecklist);
				//Icon設定
				JLabel lblChecklist_icon = new JLabel("");
				lblChecklist_icon.setHorizontalAlignment(SwingConstants.RIGHT);
				lblChecklist_icon.setIcon(new ImageIcon(MenuEvent_B.class.getResource("/img/CheckList.png")));
				lblChecklist_icon.setBounds(0, 0, 80, 50);
				//調整圖像大小符合外框
				lblChecklist_icon.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/img/CheckList.png")).getImage().getScaledInstance(18, 16, Image.SCALE_SMOOTH)));
				paneChecklist.add(lblChecklist_icon);				
				
				
				//薪資清單設定
				//底圖設定	
				paneChecklist_S.setBackground(black);
				paneChecklist_S.setBorder(new MatteBorder(1, 0, 2, 0, (Color) new Color(128, 128, 128)));
				paneChecklist_S.setBounds(0, 470, 250, 50);		
				paneChecklist_S.setLayout(null);
				//文字設定
				JLabel lblChecklist_S = new JLabel("薪 資 清 單");
				lblChecklist_S.setForeground(Color.WHITE);
				lblChecklist_S.setFont(new Font("微軟正黑體", Font.BOLD, 20));
				lblChecklist_S.setBounds(96, 0, 102, 50);
				paneChecklist_S.add(lblChecklist_S);
				//Icon設定
				JLabel lblChecklist_S_icon = new JLabel("");
				lblChecklist_S_icon.setHorizontalAlignment(SwingConstants.RIGHT);
				lblChecklist_S_icon.setIcon(new ImageIcon(MenuEvent_B.class.getResource("/img/CheckList_S.png")));
				lblChecklist_S_icon.setBounds(0, 0, 80, 50);
				//調整圖像大小符合外框
				lblChecklist_S_icon.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/img/CheckList_S.png")).getImage().getScaledInstance(18, 16, Image.SCALE_SMOOTH)));
				paneChecklist_S.add(lblChecklist_S_icon);	
				
		
	}

}
