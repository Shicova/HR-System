package PageWork;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class FirstBackground {
	
	public FirstBackground(JLabel lblFirst_background) {
		
		
		lblFirst_background.setIcon(new ImageIcon(FirstBackground.class.getResource("/img/First_background.png")));
		lblFirst_background.setBounds(250, 2, 740, 626);
		//�վ�Ϲ��j�p�ŦX�~��
		lblFirst_background.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/img/First_background.png")).getImage().getScaledInstance(740, 626, Image.SCALE_SMOOTH)));
		
	}
	
	
	

}
