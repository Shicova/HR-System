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

public class CheckList extends JPanel {

	DefaultTableModel model;

	/**
	 * Create the panel.
	 */
	public CheckList() {
		//setBackground(SystemColor.menu);
		setBounds(35,43,670, 550);
		setLayout(null);
		setBorder(null);
		setOpaque(false);
		
		
		Connection con = con();
		DefaultTableModel model = new DefaultTableModel();
		
		model.addColumn("員工編號");
		model.addColumn("部門");
		model.addColumn("中文姓名");
		model.addColumn("英文姓名");
		model.addColumn("身分證號");
		model.addColumn("到職日期");
		model.addColumn("性別");
		model.addColumn("婚姻狀態");
		model.addColumn("出生日期");
		model.addColumn("聯絡手機");
		model.addColumn("地址");
		model.addColumn("最高學歷");
		model.addColumn("學校系別");
		model.addColumn("電子信箱");
		
		

		try {
			String query = "select * from emp_data";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				model.addRow(new Object[] {
						rs.getString("id_comp"),//1
						rs.getString("department"),//2
						rs.getString("name"),//3
						rs.getString("name_EN"),//4
						rs.getString("id_num"),//5
						rs.getString("onduty"),//6
						rs.getString("gender"),//7
						rs.getString("marital"),//8
						rs.getString("birth"),//9
						rs.getString("phone"),//10
						rs.getString("address"),//11
						rs.getString("school"),//12
						rs.getString("education"),//13
						rs.getString("email"),//14
						
				});
			}
	
		rs.close();
		st.close();
		con.close();
		
		}catch (Exception e) {
			System.out.println("Error:" + e);
		}
		
		JTable table = new JTable(model){
			//資料隨內容變化長度
			  @Override
			    public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
			      Component component = super.prepareRenderer(renderer, row, column);
			      int rendererWidth = component.getPreferredSize().width;
			      TableColumn tableColumn = getColumnModel().getColumn(column);
			      tableColumn.setPreferredWidth(Math.max((rendererWidth+40) + getIntercellSpacing().width, tableColumn.getPreferredWidth()));
			      
			      tableColumn.setMinWidth(100);
			      JTableHeader tab_header = getTableHeader();
			      tab_header.setFont(new Font("微軟正黑體", Font.BOLD, 18));
			      return component;
			      
			    }
			//表格不允許被编辑
			  @Override		
				public boolean isCellEditable(int row, int column){                      
		            	return false;
		            }
			  
			  }; 
		makeFace(table);
		table.setShowGrid(false);//去除表格框線
		table.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		table.getTableHeader().setBackground(new Color(163, 160, 153));//表頭顏色
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);//寬度隨資料內容變寬
		table.setRowHeight(25);
		
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);//需要時顯示水平滾動條
		scrollPane.getVerticalScrollBar().setUI(null);//隱藏垂直滾動條
		scrollPane.setViewportBorder(new EmptyBorder(0, 0, 0, 0));//隱藏邊框(要跟下一行一起)
		scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));//隱藏邊框(要跟上一行一起)
		
		scrollPane.setBounds(35, 35, 600, 480);
		add(scrollPane);
		
		
		
        //半透明圓角視窗
        JLabel lblMainContent = new JLabel("");
		lblMainContent.setHorizontalAlignment(SwingConstants.CENTER);
		lblMainContent.setIcon(new ImageIcon(FrameDashboard.class.getResource("/img/JPanel-1.png")));
		lblMainContent.setBounds(0, 0, getWidth(), getHeight());
		//調整圖像大小符合外框
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
						setBackground(new Color(217, 210, 207)); //設定奇數行底色
					}else {
						setBackground(new Color(193, 187, 184)); //設定偶數行底色
					}
						setHorizontalAlignment(SwingConstants.CENTER);//內容文字居中
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
