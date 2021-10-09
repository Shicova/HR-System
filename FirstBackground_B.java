package PageWork;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class FirstBackground_B {
	
	public FirstBackground_B(JLabel lblFirst_background) {
		
		
		lblFirst_background.setIcon(new ImageIcon(FirstBackground_B.class.getResource("/img/First_background1.png")));
		lblFirst_background.setBounds(250, 2, 740, 626);
		//調整圖像大小符合外框
		lblFirst_background.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/img/First_background1.png")).getImage().getScaledInstance(740, 626, Image.SCALE_SMOOTH)));
		
	}
	
	
	

}
