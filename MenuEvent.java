package PageWork;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;


import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;


public class MenuEvent {

	public MenuEvent(JPanel paneProclamation, 
			         JPanel paneInformation, 
			         JPanel paneSalary,
			         JPanel paneVacation,
			         JPanel labeltext,
			         Color black) {
		

		
         	 //������r
               //���ϳ]�w				
	            labeltext.setBackground(black);
	            //paneProclamation.setBorder(new MatteBorder(2, 0, 1, 0, (Color) new Color(128, 128, 128)));
	            labeltext.setBounds(0, 150, 250, 50);				
	            labeltext.setLayout(null);
	            //��r�]�w
	            JLabel labeltext1 = new JLabel("���u�t��");
	            labeltext1.setFont(new Font("�L�n������", Font.BOLD, 20));
	            labeltext1.setForeground(Color.WHITE);
	            labeltext1.setBounds(90, 0, 99, 50);
	            labeltext.add(labeltext1);
		
		     //���i��]�w
		        //���ϳ]�w				
				paneProclamation.setBackground(black);
				paneProclamation.setBorder(new MatteBorder(2, 0, 1, 0, (Color) new Color(128, 128, 128)));
				paneProclamation.setBounds(0, 220, 250, 50);				
				paneProclamation.setLayout(null);
				//��r�]�w
				JLabel lblProclamationl = new JLabel("\u516C \u544A \u6B04");
				lblProclamationl.setForeground(Color.WHITE);
				lblProclamationl.setFont(new Font("�L�n������", Font.BOLD, 20));
				lblProclamationl.setBounds(96, 0, 99, 50);
				paneProclamation.add(lblProclamationl);
				//Icon�]�w
				JLabel lblProclamationl_icon = new JLabel("");
				lblProclamationl_icon.setHorizontalAlignment(SwingConstants.RIGHT);
				lblProclamationl_icon.setIcon(new ImageIcon(MenuEvent.class.getResource("/img/Proclamationl.png")));
				lblProclamationl_icon.setBounds(0, 0, 80, 50);
				//�վ�Ϲ��j�p�ŦX�~��
				lblProclamationl_icon.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Proclamationl.png")).getImage().getScaledInstance(19, 19, Image.SCALE_SMOOTH)));
				paneProclamation.add(lblProclamationl_icon);
				
			 //���u�M��]�w	
				//���ϳ]�w	
				paneInformation.setBackground(black);
				paneInformation.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(128, 128, 128)));
				paneInformation.setBounds(0, 270, 250, 50);				
				paneInformation.setLayout(null);
				//��r�]�w
				JLabel lblInformation = new JLabel("�� �u �� ��");
				lblInformation.setForeground(Color.WHITE);
				lblInformation.setFont(new Font("�L�n������", Font.BOLD, 20));
				lblInformation.setBounds(96, 0, 96, 50);
				paneInformation.add(lblInformation);
				//Icon�]�w
				JLabel lblInformation_icon = new JLabel("");
				lblInformation_icon.setHorizontalAlignment(SwingConstants.RIGHT);
				lblInformation_icon.setIcon(new ImageIcon(MenuEvent.class.getResource("/img/Information.png")));
				lblInformation_icon.setBounds(0, 0, 80, 50);
				//�վ�Ϲ��j�p�ŦX�~��
				lblInformation_icon.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Information.png")).getImage().getScaledInstance(16, 15, Image.SCALE_SMOOTH)));
				paneInformation.add(lblInformation_icon);
				
			//�~��]�w
				//���ϳ]�w	
				paneSalary.setBackground(black);
				paneSalary.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(128, 128, 128)));
				paneSalary.setBounds(0, 320, 250, 50);				
				paneSalary.setLayout(null);
				//��r�]�w
				JLabel lblSalary = new JLabel("\u85AA \u8CC7 \u660E \u7D30");
				lblSalary.setForeground(Color.WHITE);
				lblSalary.setFont(new Font("�L�n������", Font.BOLD, 20));
				lblSalary.setBounds(96, 0, 105, 50);
				paneSalary.add(lblSalary);
				//Icon�]�w
				JLabel lblSalary_icon = new JLabel("");
				lblSalary_icon.setHorizontalAlignment(SwingConstants.RIGHT);
				lblSalary_icon.setIcon(new ImageIcon(MenuEvent.class.getResource("/img/Salary.png")));
				lblSalary_icon.setBounds(0, 0, 80, 50);
				//�վ�Ϲ��j�p�ŦX�~��
				lblSalary_icon.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Salary.png")).getImage().getScaledInstance(19, 19, Image.SCALE_SMOOTH)));
				paneSalary.add(lblSalary_icon);
				
		   //�����]�w
				//���ϳ]�w	
				paneVacation.setBackground(black);
				paneVacation.setBorder(new MatteBorder(1, 0, 2, 0, (Color) new Color(128, 128, 128)));
				paneVacation.setBounds(0, 370, 250, 50);		
				paneVacation.setLayout(null);
				//��r�]�w
				JLabel lblVacation = new JLabel("\u8ACB \u5047 \u7C3D \u6838");
				lblVacation.setForeground(Color.WHITE);
				lblVacation.setFont(new Font("�L�n������", Font.BOLD, 20));
				lblVacation.setBounds(96, 0, 102, 50);
				paneVacation.add(lblVacation);
				//Icon�]�w
				JLabel lblVacation_icon = new JLabel("");
				lblVacation_icon.setHorizontalAlignment(SwingConstants.RIGHT);
				lblVacation_icon.setIcon(new ImageIcon(MenuEvent.class.getResource("/img/Vacation.png")));
				lblVacation_icon.setBounds(0, 0, 80, 50);
				//�վ�Ϲ��j�p�ŦX�~��
				lblVacation_icon.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Vacation.png")).getImage().getScaledInstance(18, 16, Image.SCALE_SMOOTH)));
				paneVacation.add(lblVacation_icon);

		
	}

}
