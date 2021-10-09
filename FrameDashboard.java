package HR_Package;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.MatteBorder;

import HR_Package.FrameB_Dashboard.PanelButtonMouseAdapter;
import PageWork.ExitX;
import PageWork.FirstBackground;
import PageWork.Menu;
import PageWork.MenuEvent;
import PageWork.MenuProfile;

import javax.swing.border.LineBorder;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.SystemColor;

public class FrameDashboard extends JFrame {

private JPanel contentPane;
	
	private Vacation_Page vacation_Page;
	private Information_Page information_Page;
	private Salary_Page salary_Page;
	private Proclamationl_Page proclamationl_Page;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameDashboard frame = new FrameDashboard(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
					}
				}
			});
		}
	
	/**
	 * Create the frame.
	 */
	public FrameDashboard(String currentUser) {
		// �����G���]�w
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(130, 20, 990, 630);
		setUndecorated(true); /*�ϥ~�ؤ��ಾ��*/
		setLocationRelativeTo(null); /*�ϥ~�ئb�e������*/		
		contentPane = new JPanel();
//		contentPane.setForeground(Color.GRAY);
//		contentPane.setBackground(Color.GRAY);
//		contentPane.setBorder(new LineBorder(UIManager.getColor("windowBorder"), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//���������Ÿ�
		JLabel lblExit_ = new JLabel("X");	
		new ExitX(FrameDashboard.this,lblExit_); /*�غc�����������O*/
		contentPane.add(lblExit_);
				
		proclamationl_Page = new Proclamationl_Page(); 
		information_Page = new Information_Page(currentUser);
		salary_Page = new Salary_Page(currentUser);
		vacation_Page = new Vacation_Page();

		//�����G���]�w
		JLabel lblFirst_background = new JLabel("");
		new FirstBackground(lblFirst_background); /*�غc�����I�����O*/
		contentPane.add(lblFirst_background);
			
    //�\����G���]�w
		Color  black  = new Color(44, 47, 51); /*�]�w��������*/		
		//���]�w
		JPanel paneMenu = new JPanel();
		JLabel lblLogo = new JLabel("");
		new Menu(paneMenu, lblLogo, black); /*�غc������O*/
		contentPane.add(paneMenu);
	
	//�\���涵�س]�w
		JPanel paneProclamation = new JPanel();
		JPanel paneInformation = new JPanel();
		JPanel paneSalary = new JPanel();
		JPanel paneVacation = new JPanel();
		JPanel labeltext = new JPanel();
		
		new MenuEvent(paneProclamation, 
				      paneInformation, 
				      paneSalary, 
				      paneVacation, 
				      labeltext,
				      black);
		//���i���s��ť
		paneProclamation.addMouseListener(new PanelButtonMouseAdapter(paneProclamation) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(proclamationl_Page);
				}
			});	
		//�Ӹ���s��ť
		paneInformation.addMouseListener(new PanelButtonMouseAdapter(paneInformation) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(information_Page);
				}
			});
		//�~����s��ť
		paneSalary.addMouseListener(new PanelButtonMouseAdapter(paneSalary) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(salary_Page);
				}
			});
		//�������s��ť
		paneVacation.addMouseListener(new PanelButtonMouseAdapter(paneVacation) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(vacation_Page);
			}
		});
		
		paneMenu.add(paneProclamation);
		paneMenu.add(paneInformation);
		paneMenu.add(paneSalary);
		paneMenu.add(paneVacation);
		paneMenu.add(labeltext);
		
		//�ӤH�b���]�w	
//		JLabel lblUser_Name = new JLabel("User Name");
//		JLabel lblUser_picture = new JLabel("");
//		new MenuProfile(lblUser_Name, lblUser_picture);
//		paneMenu.add(lblUser_Name);
//		paneMenu.add(lblUser_picture);
		
		
		//�����P�\���涵�سs��
		lblFirst_background.add(proclamationl_Page);
		lblFirst_background.add(information_Page);
		lblFirst_background.add(salary_Page);		
		lblFirst_background.add(vacation_Page);
		

		menuClicked(proclamationl_Page);
		

	}
	
	public void menuClicked(JPanel panel) {
		proclamationl_Page.setVisible(false);
		information_Page.setVisible(false);
		salary_Page.setVisible(false);
		vacation_Page.setVisible(false);

		panel.setVisible(true);	
		
	}
	
    //�\���橳����s��ť
	public class PanelButtonMouseAdapter extends MouseAdapter{
		
		JPanel panel;
		public PanelButtonMouseAdapter(JPanel panel) {
			this.panel = panel;
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			panel.setBackground(new Color(87,89,92));
		}
		
		@Override
		public void mouseExited(MouseEvent e) {
			panel.setBackground(new Color(44, 47, 51));			
		}
		
		@Override
		public void mousePressed(MouseEvent e) {
			panel.setBackground(new Color(111,119,112));
		}
		
		@Override
		public void mouseReleased(MouseEvent e) {
			panel.setBackground(new Color(87,89,92));
		
		
	    }
		

		}
	}




