package PageWork;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class MenuProfile {
	
	public MenuProfile(JLabel lblUser_Name, JLabel lblUser_picture) {
		lblUser_Name.setHorizontalAlignment(SwingConstants.CENTER);
		lblUser_Name.setForeground(Color.WHITE);
		lblUser_Name.setFont(new Font("Arial", Font.BOLD, 20));
		lblUser_Name.setBounds(0, 150, 250, 50);
				
		lblUser_picture.setHorizontalAlignment(SwingConstants.CENTER);
		lblUser_picture.setIcon(new ImageIcon(MenuProfile.class.getResource("/img/logo1.png")));
		lblUser_picture.setBounds(0, 47, 250, 94);
		//調整圖像大小符合外框
		lblUser_picture.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo1.png")).getImage().getScaledInstance(107, 58, Image.SCALE_SMOOTH)));
		
		
		
	}
	
	

}
