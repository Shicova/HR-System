package PageWork;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public  class ExitX{
	//右上角x加入判斷是否關閉的視窗
	
	public ExitX(JFrame frame, JLabel lblExit_) {
		
		lblExit_.addMouseListener(new MouseAdapter() {
				
				@Override
				public void mouseClicked(MouseEvent e) {
					if (JOptionPane.showConfirmDialog(null, 
							"Are you sure you want to close this application?",
							"Confirmation",JOptionPane.YES_NO_OPTION)==0) {
						frame.dispose();
					}else {
						
					}
					
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
			lblExit_.setBounds(966, 10, 14, 23);
			
	}
}