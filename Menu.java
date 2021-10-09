package PageWork;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;



public class Menu {

	public Menu(JPanel paneMenu, JLabel lblLogo, Color black) {
//		Color  black  = new Color(44, 47, 51); /*設定頁面底色*/
		
		paneMenu.setBackground(black);
		paneMenu.setBounds(0, 2, 250, 626);
		paneMenu.setLayout(null);
		
		
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setIcon(new ImageIcon(Menu.class.getResource("/img/logo1.png")));
		lblLogo.setBounds(0, 47, 250, 94);
		//調整圖像大小符合外框
		lblLogo.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo1.png")).getImage().getScaledInstance(107, 58, Image.SCALE_SMOOTH)));
		paneMenu.add(lblLogo);
		
		
	}
	
	
}
