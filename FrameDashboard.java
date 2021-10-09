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
		// 頁面佈局設定
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(130, 20, 990, 630);
		setUndecorated(true); /*使外框不能移動*/
		setLocationRelativeTo(null); /*使外框在畫面中央*/		
		contentPane = new JPanel();
//		contentPane.setForeground(Color.GRAY);
//		contentPane.setBackground(Color.GRAY);
//		contentPane.setBorder(new LineBorder(UIManager.getColor("windowBorder"), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//關閉視窗符號
		JLabel lblExit_ = new JLabel("X");	
		new ExitX(FrameDashboard.this,lblExit_); /*建構關閉視窗類別*/
		contentPane.add(lblExit_);
				
		proclamationl_Page = new Proclamationl_Page(); 
		information_Page = new Information_Page(currentUser);
		salary_Page = new Salary_Page(currentUser);
		vacation_Page = new Vacation_Page();

		//顯示欄佈局設定
		JLabel lblFirst_background = new JLabel("");
		new FirstBackground(lblFirst_background); /*建構顯示欄背景類別*/
		contentPane.add(lblFirst_background);
			
    //功能欄佈局設定
		Color  black  = new Color(44, 47, 51); /*設定頁面底色*/		
		//菜單設定
		JPanel paneMenu = new JPanel();
		JLabel lblLogo = new JLabel("");
		new Menu(paneMenu, lblLogo, black); /*建構選單類別*/
		contentPane.add(paneMenu);
	
	//功能欄項目設定
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
		//公告按鈕監聽
		paneProclamation.addMouseListener(new PanelButtonMouseAdapter(paneProclamation) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(proclamationl_Page);
				}
			});	
		//個資按鈕監聽
		paneInformation.addMouseListener(new PanelButtonMouseAdapter(paneInformation) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(information_Page);
				}
			});
		//薪資按鈕監聽
		paneSalary.addMouseListener(new PanelButtonMouseAdapter(paneSalary) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(salary_Page);
				}
			});
		//假期按鈕監聽
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
		
		//個人帳號設定	
//		JLabel lblUser_Name = new JLabel("User Name");
//		JLabel lblUser_picture = new JLabel("");
//		new MenuProfile(lblUser_Name, lblUser_picture);
//		paneMenu.add(lblUser_Name);
//		paneMenu.add(lblUser_picture);
		
		
		//顯示欄與功能欄項目連動
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
	
    //功能欄底色按鈕監聽
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




