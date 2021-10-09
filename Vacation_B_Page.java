package HR_Package;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

public class Vacation_B_Page extends JPanel {
	private JTable table_Va;
	DefaultTableModel model;

	/**
	 * Create the panel.
	 */
	public Vacation_B_Page() {
		setBackground(SystemColor.menu);
		setBounds(35,43,670, 550);
		setLayout(null);
		setBorder(null);
		setOpaque(false);//�I���z��
		
		Connection con = con();
		DefaultTableModel model = new DefaultTableModel();
		
		model.addColumn("���u�s��");
		model.addColumn("��¾���");
		model.addColumn("����");
		model.addColumn("¾��");
		model.addColumn("����m�W");
		model.addColumn("�^��m�W");
		model.addColumn("�𰲮ɼ�");
		model.addColumn("�ư��ɼ�");
		model.addColumn("�f���ɼ�");
		//model.addColumn("�`�ɼ�");
		//model.addColumn("�а��ƥ�");
		

		try {
			String query = "select * from emp_treat";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				model.addRow(new Object[] {
						rs.getString("id_comp"),//1
						rs.getString("onduty"),//2
						rs.getString("department"),//3
						rs.getString("position"),//4
						rs.getString("name"),//5
						rs.getString("name_EN"),//6
						rs.getString("rest_leave"),//7
						rs.getString("personal_leave"),//8
						rs.getString("sick_leave"),//9
						
						
				});
			}
	
		rs.close();
		st.close();
		con.close();
		
		}catch (Exception e) {
			System.out.println("Error:" + e);
		}
		
		JTable table = new JTable(model){
		  @Override
		    public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		      Component component = super.prepareRenderer(renderer, row, column);
		      int rendererWidth = component.getPreferredSize().width;
		      TableColumn tableColumn = getColumnModel().getColumn(column);
		      tableColumn.setPreferredWidth(Math.max((rendererWidth+40) + getIntercellSpacing().width, tableColumn.getPreferredWidth()));
		      tableColumn.setMinWidth(100);
		      JTableHeader tab_header = getTableHeader();
		      tab_header.setFont(new Font("�L�n������", Font.BOLD, 18));
		      return component;
		      
		    }
		  	
		  };
		makeFace(table);
		table.setShowGrid(false);//�h�����ؽu
		table.setFont(new Font("�L�n������", Font.BOLD, 16));
		table.getTableHeader().setBackground(new Color(163, 160, 153));//���Y�C��
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);//�e���H��Ƥ��e�ܼe
		table.setRowHeight(25);
		
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);//�ݭn����ܤ����u�ʱ�
		scrollPane.getVerticalScrollBar().setUI(null);//���ë����u�ʱ�
		scrollPane.setViewportBorder(new EmptyBorder(0, 0, 0, 0));//�������(�n��U�@��@�_)
		scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));//�������(�n��W�@��@�_)
		
		scrollPane.setBounds(35, 35, 600, 480);
		add(scrollPane);
		
		
		
        //�b�z���ꨤ����
        JLabel lblMainContent = new JLabel("");
		lblMainContent.setHorizontalAlignment(SwingConstants.CENTER);
		lblMainContent.setIcon(new ImageIcon(FrameDashboard.class.getResource("/img/JPanel-1.png")));
		lblMainContent.setBounds(0, 0, getWidth(), getHeight());
		//�վ�Ϲ��j�p�ŦX�~��
		lblMainContent.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/img/JPanel-1.png")).getImage().getScaledInstance(lblMainContent.getWidth(), lblMainContent.getHeight(), Image.SCALE_SMOOTH)));
		add(lblMainContent);


	}
	
	
	static Connection con() {
		try {
			String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
			String DB_URL = "jdbc:mysql://localhost:3306/HRsystem?"
	            	+ "useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
			String USERNAME = "root";
		    String PASSWORD = "12345678";
			Class.forName(JDBC_DRIVER);
			return DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
		}catch (Exception e) {
			System.out.println("Connection Failed!" + e);
		}
		return null;
	}

	public static void makeFace(JTable table) {
		try {
			DefaultTableCellRenderer tcr = new DefaultTableCellRenderer() {
				@Override
				public Component getTableCellRendererComponent(JTable table,
						Object value, boolean isSelected, boolean hasFocus,
						int row, int column) {
					if (row % 2 == 0) {
						setBackground(new Color(217, 210, 207)); //�]�w�_�Ʀ橳��
					}else {
						setBackground(new Color(193, 187, 184)); //�]�w���Ʀ橳��
					}
						setHorizontalAlignment(SwingConstants.CENTER);//���e��r�~��
					return super.getTableCellRendererComponent(table, value,
							isSelected, hasFocus, row, column);
				}
			};

			for (int i = 0; i < table.getColumnCount(); i++) {
				table.getColumn(table.getColumnName(i)).setCellRenderer(tcr);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}