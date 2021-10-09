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

import PageWork.ExitX;
import PageWork.FirstBackground_B;
import PageWork.Menu;
import PageWork.MenuEvent;
import PageWork.MenuEvent_B;
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

public class FrameB_Dashboard extends JFrame {


    private JPanel contentPane;
	private Vacation_B_Page vacation_B_Page;
	private Information_B_Page information_B_Page;
	private Salary_B_Page salary_B_Page;
	private Proclamationl_B_Page proclamationl_B_Page;
	private CheckList chackList;
	private CheckList_S chackList_S;
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameB_Dashboard frame = new FrameB_Dashboard();
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
	public FrameB_Dashboard() {
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
		new ExitX(FrameB_Dashboard.this,lblExit_); /*�غc�����������O*/
		contentPane.add(lblExit_);
				
		proclamationl_B_Page = new Proclamationl_B_Page(); 
		information_B_Page = new Information_B_Page();
		salary_B_Page = new Salary_B_Page();
		vacation_B_Page = new Vacation_B_Page();
		chackList = new CheckList();
		chackList_S = new CheckList_S();

	//�����G���]�w
		JLabel lblFirst_background = new JLabel("");
		new FirstBackground_B(lblFirst_background); /*�غc�����I�����O*/
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
		JPanel paneChecklist = new JPanel();
		JPanel labeltext = new JPanel();
		JPanel paneChecklist_S = new JPanel();
		
		new MenuEvent_B(paneProclamation, 
				        paneInformation, 
				        paneSalary, 
				        paneVacation,
				        paneChecklist,
				        labeltext,
				        paneChecklist_S,
				        black);
		//���i���s��ť
		paneProclamation.addMouseListener(new PanelButtonMouseAdapter(paneProclamation) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(proclamationl_B_Page);
				}
			});	
		//�Ӹ���s��ť
		paneInformation.addMouseListener(new PanelButtonMouseAdapter(paneInformation) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(information_B_Page);
				}
			});
		//�~����s��ť
		paneSalary.addMouseListener(new PanelButtonMouseAdapter(paneSalary) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(salary_B_Page);
				}
			});
		//�������s��ť
		paneVacation.addMouseListener(new PanelButtonMouseAdapter(paneVacation) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(vacation_B_Page);
			}
		});
		//���u�M����s��ť
		paneChecklist.addMouseListener(new PanelButtonMouseAdapter(paneChecklist) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(chackList);
			}
		});
		
		//�~��M����s��ť
		paneChecklist_S.addMouseListener(new PanelButtonMouseAdapter(paneChecklist_S) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(chackList_S);
			}
		});
		
		paneMenu.add(labeltext);
		paneMenu.add(paneProclamation);
		paneMenu.add(paneInformation);
		paneMenu.add(paneSalary);
		paneMenu.add(paneVacation);
		paneMenu.add(paneChecklist);
		paneMenu.add(paneChecklist_S);
		
		
		
	//�ӤH�b���]�w	
//		JLabel lblUser_Name = new JLabel("User Name");
//		JLabel lblUser_picture = new JLabel("");
//		new MenuProfile(lblUser_Name, lblUser_picture);
//		paneMenu.add(lblUser_Name);
//		paneMenu.add(lblUser_picture);
		
		
		//�����P�\���涵�سs��
		lblFirst_background.add(proclamationl_B_Page);
		lblFirst_background.add(information_B_Page);
		lblFirst_background.add(salary_B_Page);		
		lblFirst_background.add(vacation_B_Page);
		lblFirst_background.add(chackList);
		lblFirst_background.add(chackList_S);
		

		menuClicked(proclamationl_B_Page);
	}
	
	public void menuClicked(JPanel panel) {
		proclamationl_B_Page.setVisible(false);
		information_B_Page.setVisible(false);
		salary_B_Page.setVisible(false);
		vacation_B_Page.setVisible(false);
		chackList.setVisible(false);
		chackList_S.setVisible(false);

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




