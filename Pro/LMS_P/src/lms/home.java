//package lms;
//
//import java.awt.EventQueue;
//
//import javax.swing.JFrame;
//import java.awt.Color;
//import javax.swing.JSplitPane;
//import javax.swing.JDesktopPane;
//import javax.swing.JSpinner;
//import javax.swing.JList;
//import javax.swing.JTabbedPane;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//import javax.swing.border.LineBorder;
//import java.awt.Font;
//import javax.swing.border.CompoundBorder;
//import javax.swing.JSeparator;
//import java.awt.SystemColor;
//import java.sql.Connection;
//
//import javax.swing.JProgressBar;
//import javax.swing.JSlider;
//import javax.swing.JScrollBar;
//import javax.swing.JTree;
//import javax.swing.JTextPane;
//import javax.swing.JScrollPane;
//import javax.swing.JTable;
//import javax.swing.JButton;
//import java.awt.event.ActionListener;
//import java.awt.event.ActionEvent;
//import javax.swing.JComboBox;
//import javax.swing.DefaultComboBoxModel;
//
//public class home {
//
//	public JFrame home;
//	
//	
//
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					home window = new home(1);
//					window.home.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
//	/**
//	 * Create the application.
//	 */
//	public home(int id) 
//	{
//		initialize(id);
//	}
//
//	/**
//	 * Initialize the contents of the frame.
//	 */
//	private void initialize(int id) {
//		
//		database data = new database();
//		Connection connect = data.getConnection();
//		
//		int RegistrationPeriod= 1;
//		
//		home = new JFrame();
//		home.getContentPane().setBackground(Color.WHITE);
//		home.setBounds(100, 100, 839, 600);
//		home.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		home.getContentPane().setLayout(null);
//		
//		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
//		tabbedPane.setBorder(new CompoundBorder(new CompoundBorder(), null));
//		tabbedPane.setToolTipText("");
//		tabbedPane.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
//		tabbedPane.setForeground(new Color(0, 51, 102));
//		tabbedPane.setBounds(0, 0, 825, 563);
//		home.getContentPane().add(tabbedPane);
//		
//		
//		/////////////////////////////////////////////////////        HOME        //////////////////////////////////////////////////////////////////////
//		
//		JPanel panel = new JPanel();
//		panel.setForeground(new Color(0, 51, 102));
//		panel.setBackground(Color.WHITE);
//		tabbedPane.addTab("Home", null, panel, null);
//		panel.setLayout(null);
//		
//		JLabel lblNewLabel = new JLabel("Welcome to LMS");
//		lblNewLabel.setForeground(new Color(0, 51, 102));
//		lblNewLabel.setFont(new Font("Bahnschrift", Font.PLAIN, 40));
//		lblNewLabel.setBounds(179, 10, 351, 73);
//		panel.add(lblNewLabel);
//		
//		JSeparator separator = new JSeparator();
//		separator.setBounds(20, 81, 691, 2);
//		panel.add(separator);
//		
//		JLabel lblNewLabel_1 = new JLabel("Name:");
//		lblNewLabel_1.setForeground(new Color(0, 51, 102));
//		lblNewLabel_1.setFont(new Font("Bahnschrift", Font.PLAIN, 17));
//		lblNewLabel_1.setBounds(20, 105, 58, 34);
//		panel.add(lblNewLabel_1);
//		
//		JLabel lblNewLabel_1_1 = new JLabel("Roll Num:");
//		lblNewLabel_1_1.setForeground(new Color(0, 51, 102));
//		lblNewLabel_1_1.setFont(new Font("Bahnschrift", Font.PLAIN, 17));
//		lblNewLabel_1_1.setBounds(20, 135, 74, 34);
//		panel.add(lblNewLabel_1_1);
//		
//		JLabel lblNewLabel_1_2 = new JLabel("Father Name:");
//		lblNewLabel_1_2.setForeground(new Color(0, 51, 102));
//		lblNewLabel_1_2.setFont(new Font("Bahnschrift", Font.PLAIN, 17));
//		lblNewLabel_1_2.setBounds(20, 165, 112, 34);
//		panel.add(lblNewLabel_1_2);
//		
//		JLabel lblNewLabel_1_3 = new JLabel("CNIC:");
//		lblNewLabel_1_3.setForeground(new Color(0, 51, 102));
//		lblNewLabel_1_3.setFont(new Font("Bahnschrift", Font.PLAIN, 17));
//		lblNewLabel_1_3.setBounds(20, 195, 58, 34);
//		panel.add(lblNewLabel_1_3);
//		
//		JLabel lblNewLabel_1_4 = new JLabel("City:");
//		lblNewLabel_1_4.setForeground(new Color(0, 51, 102));
//		lblNewLabel_1_4.setFont(new Font("Bahnschrift", Font.PLAIN, 17));
//		lblNewLabel_1_4.setBounds(20, 225, 58, 34);
//		panel.add(lblNewLabel_1_4);
//		
//		student st =data.view(id);
//		
//	
//		
//		
//		JLabel lblNewLabel_1_2_1 = new JLabel( st.name);
//		lblNewLabel_1_2_1.setFont(new Font("Bahnschrift", Font.PLAIN, 17));
//		lblNewLabel_1_2_1.setBounds(192, 105, 287, 34);
//		panel.add(lblNewLabel_1_2_1);
//		
//		JLabel lblNewLabel_1_2_2 = new JLabel(st.rollNo);
//		lblNewLabel_1_2_2.setFont(new Font("Bahnschrift", Font.PLAIN, 17));
//		lblNewLabel_1_2_2.setBounds(192, 135, 287, 34);
//		panel.add(lblNewLabel_1_2_2);
//		
//		JLabel lblNewLabel_1_2_3 = new JLabel(st.fatherName);
//		lblNewLabel_1_2_3.setFont(new Font("Bahnschrift", Font.PLAIN, 17));
//		lblNewLabel_1_2_3.setBounds(192, 165, 223, 34);
//		panel.add(lblNewLabel_1_2_3);
//		
//		JLabel lblNewLabel_1_2_4 = new JLabel(st.cnic);
//		lblNewLabel_1_2_4.setFont(new Font("Bahnschrift", Font.PLAIN, 17));
//		lblNewLabel_1_2_4.setBounds(192, 195, 112, 34);
//		panel.add(lblNewLabel_1_2_4);
//		
//		JLabel lblNewLabel_1_2_5 = new JLabel(st.city);
//		lblNewLabel_1_2_5.setFont(new Font("Bahnschrift", Font.PLAIN, 17));
//		lblNewLabel_1_2_5.setBounds(192, 225, 112, 34);
//		panel.add(lblNewLabel_1_2_5);
//		
//		JSeparator separator_1 = new JSeparator();
//		separator_1.setBounds(10, 282, 705, 2);
//		panel.add(separator_1);
//		
//		JButton btnNewButton = new JButton("Logout");
//		btnNewButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) 
//			{
//				gui hm = new gui();
//				hm.frame.setVisible(true);
//				home.setVisible(false);
//			}
//		});
//		btnNewButton.setForeground(new Color(255, 255, 255));
//		btnNewButton.setBackground(new Color(0, 51, 102));
//		btnNewButton.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
//		btnNewButton.setBounds(20, 294, 90, 34);
//		panel.add(btnNewButton);
//		
//		////////////////////////////////////////        ATTENDANCE PANEL      ///////////////////////////////////////////////////////////////
//		JPanel panel_1 = new JPanel();
//		
//		JLabel lblNewLabel_3 = new JLabel("Attendance");
//		lblNewLabel_3.setFont(new Font("Bahnschrift", Font.PLAIN, 27));
//		lblNewLabel_3.setBounds(66, 10, 345, 46);
//		panel_1.add(lblNewLabel_3);
//		
//		panel_1.setBackground(Color.WHITE);
//		tabbedPane.addTab("Attendance", null, panel_1, null);
//		panel_1.setLayout(null);
//		
//		JTabbedPane tabbedPane_2 = new JTabbedPane(JTabbedPane.TOP);
//		tabbedPane_2.setBounds(66, 90, 597, 442);
//		panel_1.add(tabbedPane_2);
//		
//		JPanel panel_5 = new JPanel();
//		panel_5.setBackground(new Color(255, 255, 255));
//		tabbedPane_2.addTab("SDA", null, panel_5, null);
//		panel_5.setLayout(null);
//		
//		JLabel lblNewLabel_2 = new JLabel("Lecture Number");
//		lblNewLabel_2.setForeground(new Color(0, 51, 102));
//		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
//		lblNewLabel_2.setBounds(37, 58, 141, 21);
//		panel_5.add(lblNewLabel_2);
//		
//		JLabel lblNewLabel_2_1 = new JLabel("Date");
//		lblNewLabel_2_1.setForeground(new Color(0, 51, 102));
//		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
//		lblNewLabel_2_1.setBounds(262, 58, 141, 21);
//		panel_5.add(lblNewLabel_2_1);
//		
//		JLabel lblNewLabel_2_2 = new JLabel("Attendance");
//		lblNewLabel_2_2.setForeground(new Color(0, 51, 102));
//		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
//		lblNewLabel_2_2.setBounds(451, 58, 141, 21);
//		panel_5.add(lblNewLabel_2_2);
//		
//		JProgressBar progressBar = new JProgressBar();
//		progressBar.setBackground(new Color(0, 51, 102));
//		progressBar.setForeground(new Color(102, 204, 0));
//		progressBar.setValue(90);
//		progressBar.setStringPainted(true);
//		progressBar.setBounds(423, 15, 146, 21);
//		panel_5.add(progressBar);
//		
//		JLabel lblNewLabel_2_3 = new JLabel("Percentage:");
//		lblNewLabel_2_3.setForeground(new Color(0, 51, 102));
//		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
//		lblNewLabel_2_3.setBounds(327, 15, 97, 21);
//		panel_5.add(lblNewLabel_2_3);
//		
//		JSeparator separator_2 = new JSeparator();
//		separator_2.setBounds(10, 93, 572, 2);
//		panel_5.add(separator_2);
//
//		for (int i =0, y=105 ; i< 20 ; i++,y=y+30)
//		{
//			
//		String s=String.valueOf(i+1);
//		JLabel lblNewLabel_2_4 = new JLabel(s);
//		lblNewLabel_2_4.setForeground(new Color(0, 51, 102));
//		lblNewLabel_2_4.setFont(new Font("Tahoma", Font.PLAIN, 17));
//		lblNewLabel_2_4.setBounds(88, y, 141, 21);
//		panel_5.add(lblNewLabel_2_4);
//		
//		JLabel lblNewLabel_2_5 = new JLabel("10/10/2020");
//		lblNewLabel_2_5.setForeground(new Color(0, 51, 102));
//		lblNewLabel_2_5.setFont(new Font("Tahoma", Font.PLAIN, 17));
//		lblNewLabel_2_5.setBounds(241, y, 141, 21);
//		panel_5.add(lblNewLabel_2_5);
//		
//		JLabel lblNewLabel_2_6 = new JLabel("P");
//		lblNewLabel_2_6.setForeground(new Color(204, 0, 51));
//		lblNewLabel_2_6.setFont(new Font("Tahoma", Font.PLAIN, 17));
//		lblNewLabel_2_6.setBounds(483, y, 141, 21);
//		panel_5.add(lblNewLabel_2_6);
//		
//		}
//		JPanel panel_6 = new JPanel();
//		tabbedPane_2.addTab("TBW", null, panel_6, null);
//		
//		
//	//	}
//		
//		////////////////////////////////////////////    MARKS    ////////////////////////////////////////////////////
//		JPanel panel_2 = new JPanel();
//		panel_2.setBackground(Color.WHITE);
//		tabbedPane.addTab("Marks", null, panel_2, null);
//		panel_2.setLayout(null);
//		
//		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
//		tabbedPane_1.setBounds(358, 5, 5, 5);
//		panel_2.add(tabbedPane_1);
//		
//		JTabbedPane tabbedPane_3 = new JTabbedPane(JTabbedPane.TOP);
//		tabbedPane_3.setBounds(65, 87, 588, 435);
//		panel_2.add(tabbedPane_3);
//		
//		JPanel panel_7 = new JPanel();
//		panel_7.setBackground(Color.WHITE);
//		tabbedPane_3.addTab("New tab", null, panel_7, null);
//		panel_7.setLayout(null);
//		
//		JLabel lblNewLabel_4 = new JLabel("Assesment");
//		lblNewLabel_4.setForeground(new Color(0, 51, 102));
//		lblNewLabel_4.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
//		lblNewLabel_4.setBounds(28, 37, 79, 26);
//		panel_7.add(lblNewLabel_4);
//		
//		JLabel lblNewLabel_4_1 = new JLabel("Total");
//		lblNewLabel_4_1.setForeground(new Color(0, 51, 102));
//		lblNewLabel_4_1.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
//		lblNewLabel_4_1.setBounds(181, 37, 79, 26);
//		panel_7.add(lblNewLabel_4_1);
//		
//		JLabel lblNewLabel_4_1_1 = new JLabel("Obtained");
//		lblNewLabel_4_1_1.setForeground(new Color(0, 51, 102));
//		lblNewLabel_4_1_1.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
//		lblNewLabel_4_1_1.setBounds(306, 37, 79, 26);
//		panel_7.add(lblNewLabel_4_1_1);
//		
//		JLabel lblNewLabel_4_1_2 = new JLabel("Weightage");
//		lblNewLabel_4_1_2.setForeground(new Color(0, 51, 102));
//		lblNewLabel_4_1_2.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
//		lblNewLabel_4_1_2.setBounds(466, 37, 79, 26);
//		panel_7.add(lblNewLabel_4_1_2);
//		
//		JSeparator separator_3 = new JSeparator();
//		separator_3.setBounds(10, 73, 563, 2);
//		panel_7.add(separator_3);
//		
//		JLabel lblNewLabel_4_1_3 = new JLabel("Quiz");
//		lblNewLabel_4_1_3.setForeground(new Color(0, 0, 0));
//		lblNewLabel_4_1_3.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
//		lblNewLabel_4_1_3.setBounds(45, 94, 79, 26);
//		panel_7.add(lblNewLabel_4_1_3);
//		
//		JLabel lblNewLabel_4_1_3_1 = new JLabel("10");
//		lblNewLabel_4_1_3_1.setForeground(Color.BLACK);
//		lblNewLabel_4_1_3_1.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
//		lblNewLabel_4_1_3_1.setBounds(193, 94, 79, 26);
//		panel_7.add(lblNewLabel_4_1_3_1);
//		
//		JLabel lblNewLabel_4_1_3_2 = new JLabel("9");
//		lblNewLabel_4_1_3_2.setForeground(Color.BLACK);
//		lblNewLabel_4_1_3_2.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
//		lblNewLabel_4_1_3_2.setBounds(328, 94, 79, 26);
//		panel_7.add(lblNewLabel_4_1_3_2);
//		
//		JLabel lblNewLabel_4_1_3_3 = new JLabel("3.33");
//		lblNewLabel_4_1_3_3.setForeground(Color.BLACK);
//		lblNewLabel_4_1_3_3.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
//		lblNewLabel_4_1_3_3.setBounds(482, 94, 79, 26);
//		panel_7.add(lblNewLabel_4_1_3_3);
//		
//		JLabel lblNewLabel_3_1 = new JLabel("Marks");
//		lblNewLabel_3_1.setFont(new Font("Bahnschrift", Font.PLAIN, 27));
//		lblNewLabel_3_1.setBounds(65, 10, 345, 46);
//		panel_2.add(lblNewLabel_3_1);
//		
//		////////////////////////////////////////////   REGISTRATION    ////////////////////////////////////////////////////
//		
//		JPanel panel_3 = new JPanel();
//		panel_3.setBackground(new Color(255, 255, 255));
//		tabbedPane.addTab("Registration", null, panel_3, null);
//		panel_3.setLayout(null);
//		
//		JTabbedPane tabbedPane_3_1 = new JTabbedPane(JTabbedPane.TOP);
//		tabbedPane_3_1.setBounds(63, 87, 588, 435);
//		panel_3.add(tabbedPane_3_1);
//		
//		JPanel panel_8 = new JPanel();
//		panel_8.setBackground(new Color(255, 255, 255));
//		tabbedPane_3_1.addTab("New tab", null, panel_8, null);
//		panel_8.setLayout(null);
//		
//	
//		course c[]= data.off_course(id);
//		
//		//////////////////////////////
//	
//	
//		
//		/////////////////
//		
//		for (int i=0,y=32 ; i < c[0].size+1 ;i++,y=y+50 )
//		{		
//			
//			JPanel panel_9 = new JPanel();			
//			panel_9.setBackground(SystemColor.inactiveCaption);
//			panel_9.setBounds(10, y, 563, 42);
//			panel_8.add(panel_9);
//			panel_9.setLayout(null);
//			
//			
//			
//		JLabel lblNewLabel_4_2 = new JLabel(c[i].Name);
//		lblNewLabel_4_2.setBounds(10, 13, 76, 19);
//		lblNewLabel_4_2.setForeground(new Color(0, 51, 102));
//		lblNewLabel_4_2.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
//		panel_9.add(lblNewLabel_4_2);
//		
//		int k=c[i].courseId;
//		
//		JLabel lblNewLabel_4_6 = new JLabel( String.valueOf (k) );
//		lblNewLabel_4_2.setBounds(10, 13, 76, 19);
//		lblNewLabel_4_2.setForeground(new Color(0, 51, 102));
//		lblNewLabel_4_2.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
//		panel_9.add(lblNewLabel_4_6);
//		
//		JLabel lblNewLabel_4_7 = new JLabel( String.valueOf (id) );
//		lblNewLabel_4_2.setBounds(10, 13, 76, 19);
//		lblNewLabel_4_2.setForeground(new Color(0, 51, 102));
//		lblNewLabel_4_2.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
//		panel_9.add(lblNewLabel_4_7);
//		
//		JLabel lblNewLabel_4_2_1 = new JLabel(c[i].creditHours +"crd hrs");
//		lblNewLabel_4_2_1.setForeground(new Color(0, 51, 102));
//		lblNewLabel_4_2_1.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
//		lblNewLabel_4_2_1.setBounds(108, 13, 76, 19);
//		panel_9.add(lblNewLabel_4_2_1);
//		
//		
//		JLabel lblNewLabel_4_2_1_1 = new JLabel(c[i].SecName);
//		lblNewLabel_4_2_1_1.setForeground(new Color(0, 51, 102));
//		lblNewLabel_4_2_1_1.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
//		lblNewLabel_4_2_1_1.setBounds(211, 13, 76, 19);
//		panel_9.add(lblNewLabel_4_2_1_1);
//		
//		if (RegistrationPeriod != 0)
//		{
//		JButton btnNewButton_1_1 = new JButton("Drop");
//		btnNewButton_1_1.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) 
//			
//			{
//				int stid = Integer.parseInt(lblNewLabel_4_7 .getText());
// 				int cid = Integer.parseInt(lblNewLabel_4_6.getText());
// 				data.dropCourse(stid,cid);
//				panel_9.setBackground(SystemColor.inactiveCaption);
//			}
//		});
//		btnNewButton_1_1.setForeground(Color.WHITE);
//		btnNewButton_1_1.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
//		btnNewButton_1_1.setBackground(new Color(0, 51, 102));
//		btnNewButton_1_1.setBounds(444, 11, 97, 22);
//		panel_9.add(btnNewButton_1_1);
//		
//		
//		
//		JButton btnNewButton_1 = new JButton("Register");
//		btnNewButton_1.setBounds(318, 11, 97, 22);
//		panel_9.add(btnNewButton_1);
//		btnNewButton_1.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) 
//			{
//			    int stid = Integer.parseInt(lblNewLabel_4_7 .getText());
// 				int cid = Integer.parseInt(lblNewLabel_4_6.getText());
//				panel_9.setBackground(new Color(95, 158, 160));
//				data.regCourse(stid,cid);
//			}
//		});
//		btnNewButton_1.setBackground(new Color(0, 51, 102));
//		btnNewButton_1.setForeground(new Color(255, 255, 255));
//		btnNewButton_1.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
//		}
//		
//		}
//		
//		
//		
//		JLabel lblNewLabel_3_2 = new JLabel("Registeration");
//		lblNewLabel_3_2.setFont(new Font("Bahnschrift", Font.PLAIN, 27));
//		lblNewLabel_3_2.setBounds(63, 10, 345, 46);
//		panel_3.add(lblNewLabel_3_2);
//		
//		////////////////////////////////////////////   TRANSCRIPT    ////////////////////////////////////////////////////
//		
//		JPanel panel_4 = new JPanel();
//		panel_4.setBackground(new Color(255, 255, 255));
//		tabbedPane.addTab("Transcript", null, panel_4, null);
//		panel_4.setLayout(null);
//		
//		JLabel lblNewLabel_3_2_1 = new JLabel("Transcript");
//		lblNewLabel_3_2_1.setFont(new Font("Bahnschrift", Font.PLAIN, 27));
//		lblNewLabel_3_2_1.setBounds(40, 24, 345, 46);
//		panel_4.add(lblNewLabel_3_2_1);
//		
//		JScrollPane scrollPane = new JScrollPane();
//		scrollPane.setBounds(35, 133, 651, 350);
//		panel_4.add(scrollPane);
//		
//		JPanel panel_10 = new JPanel();
//		panel_10.setBackground(new Color(255, 255, 255));
//		scrollPane.setViewportView(panel_10);
//		panel_10.setLayout(null);
//		
//		for (int i=0, y=10 ; i<2 ;y=y+200, i++)
//		{
//		JPanel panel_11 = new JPanel();
//		panel_11.setBackground(SystemColor.inactiveCaptionBorder);
//		panel_11.setBounds(10, y, 628, 194);
//		panel_10.add(panel_11);
//		panel_11.setLayout(null);
//		
//		
//		
//		
//		}
//		
////		JLabel lblNewLabel_5 = new JLabel("Semester 1");
////		lblNewLabel_5.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
////		lblNewLabel_5.setBounds(10, 10, 94, 19);
////		panel_11.add(lblNewLabel_5);
////		
////		JLabel lblNewLabel_5_1_1 = new JLabel("sgpa");
////		lblNewLabel_5_1_1.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
////		lblNewLabel_5_1_1.setBounds(114, 10, 94, 19);
////		panel_11.add(lblNewLabel_5_1_1);
////		
////		JLabel lblNewLabel_5_1_2 = new JLabel("OOP");
////		lblNewLabel_5_1_2.setForeground(new Color(0, 51, 102));
////		lblNewLabel_5_1_2.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
////		lblNewLabel_5_1_2.setBounds(10, 47, 94, 19);
////		panel_11.add(lblNewLabel_5_1_2);
////		
////		JLabel lblNewLabel_5_1_2_1 = new JLabel("3 crd hr");
////		lblNewLabel_5_1_2_1.setForeground(new Color(0, 51, 102));
////		lblNewLabel_5_1_2_1.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
////		lblNewLabel_5_1_2_1.setBounds(269, 47, 94, 19);
////		panel_11.add(lblNewLabel_5_1_2_1);
////		
////		JLabel lblNewLabel_5_1_2_2 = new JLabel("A-");
////		lblNewLabel_5_1_2_2.setForeground(new Color(0, 153, 0));
////		lblNewLabel_5_1_2_2.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
////		lblNewLabel_5_1_2_2.setBounds(590, 47, 94, 19);
////		panel_11.add(lblNewLabel_5_1_2_2);
////		
////		JSeparator separator_4 = new JSeparator();
////		separator_4.setBounds(10, 64, 608, 2);
////		panel_11.add(separator_4);
//		
//		JLabel lblNewLabel_5_1 = new JLabel("cgpa");
//		lblNewLabel_5_1.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
//		lblNewLabel_5_1.setBounds(40, 75, 94, 19);
//		panel_4.add(lblNewLabel_5_1);
//		
//		JLabel lblNewLabel_5_2 = new JLabel("crd hr earned");
//		lblNewLabel_5_2.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
//		lblNewLabel_5_2.setBounds(40, 104, 94, 19);
//		panel_4.add(lblNewLabel_5_2);
//		
//		////////////////////////////////////////////////////////////////////////////////////////
//	}
//}













/////////////////////////////////////////////NEWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWw



package lms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JSplitPane;
import javax.swing.JDesktopPane;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Font;
import javax.swing.border.CompoundBorder;
import javax.swing.JSeparator;
import java.awt.SystemColor;
import java.sql.Connection;

import javax.swing.JProgressBar;
import javax.swing.JSlider;
import javax.swing.JScrollBar;
import javax.swing.JTree;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class home {

	public JFrame home;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					home window = new home(1);
					window.home.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public home(int id) 
	{
		initialize(id);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(int id) {
		
		database data = new database();
		Connection connect = data.getConnection();
		
		int RegistrationPeriod= data.getreg();
		
		System.out.println(" aslkdddddddddddddddddd  "+RegistrationPeriod);
		
		home = new JFrame();
		home.getContentPane().setBackground(Color.WHITE);
		home.setBounds(100, 100, 839, 600);
		home.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		home.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
		tabbedPane.setBorder(new CompoundBorder(new CompoundBorder(), null));
		tabbedPane.setToolTipText("");
		tabbedPane.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		tabbedPane.setForeground(new Color(0, 51, 102));
		tabbedPane.setBounds(0, 0, 825, 563);
		home.getContentPane().add(tabbedPane);
		
		
		/////////////////////////////////////////////////////        HOME        //////////////////////////////////////////////////////////////////////
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(0, 51, 102));
		panel.setBackground(Color.WHITE);
		tabbedPane.addTab("Home", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome to LMS");
		lblNewLabel.setForeground(new Color(0, 51, 102));
		lblNewLabel.setFont(new Font("Bahnschrift", Font.PLAIN, 40));
		lblNewLabel.setBounds(179, 10, 351, 73);
		panel.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(20, 81, 691, 2);
		panel.add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("Name:");
		lblNewLabel_1.setForeground(new Color(0, 51, 102));
		lblNewLabel_1.setFont(new Font("Bahnschrift", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(20, 105, 58, 34);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Roll Num:");
		lblNewLabel_1_1.setForeground(new Color(0, 51, 102));
		lblNewLabel_1_1.setFont(new Font("Bahnschrift", Font.PLAIN, 17));
		lblNewLabel_1_1.setBounds(20, 135, 74, 34);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Father Name:");
		lblNewLabel_1_2.setForeground(new Color(0, 51, 102));
		lblNewLabel_1_2.setFont(new Font("Bahnschrift", Font.PLAIN, 17));
		lblNewLabel_1_2.setBounds(20, 165, 112, 34);
		panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("CNIC:");
		lblNewLabel_1_3.setForeground(new Color(0, 51, 102));
		lblNewLabel_1_3.setFont(new Font("Bahnschrift", Font.PLAIN, 17));
		lblNewLabel_1_3.setBounds(20, 195, 58, 34);
		panel.add(lblNewLabel_1_3);
		
//		JLabel lblNewLabel_1_4 = new JLabel("CGPA:");
//		lblNewLabel_1_4.setForeground(new Color(0, 51, 102));
//		lblNewLabel_1_4.setFont(new Font("Bahnschrift", Font.PLAIN, 17));
//		lblNewLabel_1_4.setBounds(20, 225, 58, 34);
//		panel.add(lblNewLabel_1_4);
		
		student std =data.view(id);
		
		JLabel lblNewLabel_1_2_1 = new JLabel(std.name);
		lblNewLabel_1_2_1.setFont(new Font("Bahnschrift", Font.PLAIN, 17));
		lblNewLabel_1_2_1.setBounds(192, 105, 287, 34);
		panel.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_2_2 = new JLabel(std.rollNo);
		lblNewLabel_1_2_2.setFont(new Font("Bahnschrift", Font.PLAIN, 17));
		lblNewLabel_1_2_2.setBounds(192, 135, 287, 34);
		panel.add(lblNewLabel_1_2_2);
		
		JLabel lblNewLabel_1_2_3 = new JLabel(std.fatherName);
		lblNewLabel_1_2_3.setFont(new Font("Bahnschrift", Font.PLAIN, 17));
		lblNewLabel_1_2_3.setBounds(192, 165, 223, 34);
		panel.add(lblNewLabel_1_2_3);
		
		JLabel lblNewLabel_1_2_4 = new JLabel(std.cnic);
		lblNewLabel_1_2_4.setFont(new Font("Bahnschrift", Font.PLAIN, 17));
		lblNewLabel_1_2_4.setBounds(192, 195, 112, 34);
		panel.add(lblNewLabel_1_2_4);
		
//		JLabel lblNewLabel_1_2_5 = new JLabel(s.cgpa));
//		lblNewLabel_1_2_5.setFont(new Font("Bahnschrift", Font.PLAIN, 17));
//		lblNewLabel_1_2_5.setBounds(192, 225, 112, 34);
//		panel.add(lblNewLabel_1_2_5);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 282, 705, 2);
		panel.add(separator_1);
		
		JButton btnNewButton = new JButton("Logout");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				gui hm = new gui();
				hm.frame.setVisible(true);
				home.setVisible(false);
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 51, 102));
		btnNewButton.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		btnNewButton.setBounds(20, 294, 90, 34);
		panel.add(btnNewButton);
		
		int open =data.Open(id);
		
		System.out.print( "dasdasdasdasda: "+ open);
		
		if (open ==1 )
		{
		JLabel lblNewLabel_5 = new JLabel("The Cousrse You apllied for is Open");
		lblNewLabel_5.setForeground(new Color(0, 153, 51));
		lblNewLabel_5.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(258, 294, 249, 34);
		panel.add(lblNewLabel_5);
		}
		
		////////////////////////////////////////        ATTENDANCE PANEL      ///////////////////////////////////////////////////////////////
		JPanel panel_1 = new JPanel();
		
		JLabel lblNewLabel_3 = new JLabel("Attendance");
		lblNewLabel_3.setFont(new Font("Bahnschrift", Font.PLAIN, 27));
		lblNewLabel_3.setBounds(66, 10, 345, 46);
		panel_1.add(lblNewLabel_3);
		
		panel_1.setBackground(Color.WHITE);
		tabbedPane.addTab("Attendance", null, panel_1, null);
		panel_1.setLayout(null);
		
		JTabbedPane tabbedPane_2 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_2.setBounds(66, 90, 597, 442);
		panel_1.add(tabbedPane_2);
		
		course c1[] = data.get_sec_std(id);
		
		for (int k=0, l=0 ;k< c1[0].size ; l=l+35,k++)		
		{	
			
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 255, 255));
		tabbedPane_2.addTab(c1[k].Name + "-"+ c1[k].SecName, null, panel_5, null);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Lecture Number");
		lblNewLabel_2.setForeground(new Color(0, 51, 102));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(37, 58, 141, 21);
		panel_5.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Date");
		lblNewLabel_2_1.setForeground(new Color(0, 51, 102));
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_2_1.setBounds(262, 58, 141, 21);
		panel_5.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Attendance");
		lblNewLabel_2_2.setForeground(new Color(0, 51, 102));
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_2_2.setBounds(451, 58, 141, 21);
		panel_5.add(lblNewLabel_2_2);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBackground(new Color(0, 51, 102));
		progressBar.setForeground(new Color(102, 204, 0));
		progressBar.setValue(90);
		progressBar.setStringPainted(true);
		progressBar.setBounds(423, 15, 146, 21);
		panel_5.add(progressBar);
		
		JLabel lblNewLabel_2_3 = new JLabel("Percentage:");
		lblNewLabel_2_3.setForeground(new Color(0, 51, 102));
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_2_3.setBounds(327, 15, 97, 21);
		panel_5.add(lblNewLabel_2_3);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 93, 572, 2);
		panel_5.add(separator_2);
		
		int co=c1[k].courseId;
		
		Attendance a[]= data.get_course_attendence(id,co);
		for (int i =0, y=105 ; i< a[0].size ; i++,y=y+30)
		{
			
		String s=String.valueOf(i+1);
		JLabel lblNewLabel_2_4 = new JLabel(s);
		lblNewLabel_2_4.setForeground(new Color(0, 51, 102));
		lblNewLabel_2_4.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_2_4.setBounds(88, y, 141, 21);
		panel_5.add(lblNewLabel_2_4);
		
		JLabel lblNewLabel_2_5 = new JLabel(a[i].date);
		lblNewLabel_2_5.setForeground(new Color(0, 51, 102));
		lblNewLabel_2_5.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_2_5.setBounds(241, y, 141, 21);
		panel_5.add(lblNewLabel_2_5);
		
		JLabel lblNewLabel_2_6 = new JLabel(a[i].status);
		lblNewLabel_2_6.setForeground(new Color(204, 0, 51));
		lblNewLabel_2_6.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_2_6.setBounds(483, y, 141, 21);
		panel_5.add(lblNewLabel_2_6);
		
		}
		}
		
	//	}
		
		////////////////////////////////////////////    MARKS    ////////////////////////////////////////////////////
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		tabbedPane.addTab("Marks", null, panel_2, null);
		panel_2.setLayout(null);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(358, 5, 5, 5);
		panel_2.add(tabbedPane_1);
		
		JTabbedPane tabbedPane_3 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_3.setBounds(65, 87, 588, 435);
		panel_2.add(tabbedPane_3);
		course c2[]= data.get_sec_std(id);
		
		for (int k=0, l=0 ;k< c2[0].size ; l=l+35,k++)		
		{	
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(Color.WHITE);
		tabbedPane_3.addTab(c2[k].Name + "-"+ c2[k].SecName, null, panel_7, null);
		panel_7.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Assesment");
		lblNewLabel_4.setForeground(new Color(0, 51, 102));
		lblNewLabel_4.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(28, 37, 79, 26);
		panel_7.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("Total");
		lblNewLabel_4_1.setForeground(new Color(0, 51, 102));
		lblNewLabel_4_1.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		lblNewLabel_4_1.setBounds(181, 37, 79, 26);
		panel_7.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("Obtained");
		lblNewLabel_4_1_1.setForeground(new Color(0, 51, 102));
		lblNewLabel_4_1_1.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		lblNewLabel_4_1_1.setBounds(306, 37, 79, 26);
		panel_7.add(lblNewLabel_4_1_1);
		
		JLabel lblNewLabel_4_1_2 = new JLabel("Weightage");
		lblNewLabel_4_1_2.setForeground(new Color(0, 51, 102));
		lblNewLabel_4_1_2.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		lblNewLabel_4_1_2.setBounds(466, 37, 79, 26);
		panel_7.add(lblNewLabel_4_1_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(10, 73, 563, 2);
		panel_7.add(separator_3);
		
		int cou=c1[k].courseId;
		
		marks m[]= data.get_marks(id,cou);
		for (int i =0, y=94 ; i< m[0].size ; i++,y=y+30)
		{
		
		JLabel lblNewLabel_4_1_3 = new JLabel(m[i].type);
		lblNewLabel_4_1_3.setForeground(new Color(0, 0, 0));
		lblNewLabel_4_1_3.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		lblNewLabel_4_1_3.setBounds(45, y, 79, 26);
		panel_7.add(lblNewLabel_4_1_3);
		
		JLabel lblNewLabel_4_1_3_1 = new JLabel(String.valueOf(m[i].total));
		lblNewLabel_4_1_3_1.setForeground(Color.BLACK);
		lblNewLabel_4_1_3_1.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		lblNewLabel_4_1_3_1.setBounds(193, y, 79, 26);
		panel_7.add(lblNewLabel_4_1_3_1);
		
		JLabel lblNewLabel_4_1_3_2 = new JLabel(String.valueOf(m[i].obtMarks));
		lblNewLabel_4_1_3_2.setForeground(Color.BLACK);
		lblNewLabel_4_1_3_2.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		lblNewLabel_4_1_3_2.setBounds(328, y, 79, 26);
		panel_7.add(lblNewLabel_4_1_3_2);
		
		JLabel lblNewLabel_4_1_3_3 = new JLabel(String.valueOf(m[i].weightage));
		lblNewLabel_4_1_3_3.setForeground(Color.BLACK);
		lblNewLabel_4_1_3_3.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		lblNewLabel_4_1_3_3.setBounds(482, y, 79, 26);
		panel_7.add(lblNewLabel_4_1_3_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Marks");
		lblNewLabel_3_1.setFont(new Font("Bahnschrift", Font.PLAIN, 27));
		lblNewLabel_3_1.setBounds(65, 10, 345, 46);
		panel_2.add(lblNewLabel_3_1);
		}
		}
		////////////////////////////////////////////   REGISTRATION    ////////////////////////////////////////////////////
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Registration", null, panel_3, null);
		panel_3.setLayout(null);
		
		JTabbedPane tabbedPane_3_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_3_1.setBounds(63, 87, 588, 435);
		panel_3.add(tabbedPane_3_1);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(255, 255, 255));
		tabbedPane_3_1.addTab("New tab", null, panel_8, null);
		panel_8.setLayout(null);
		
	
		course c[]= data.off_course(id);
		
		//////////////////////////////
	
	
		
		/////////////////
		
		
		
		
		for (int i=0,y=32 ; i < c[0].size+1 ;i++,y=y+50 )
		{		
			
			JPanel panel_9 = new JPanel();			
			panel_9.setBackground(SystemColor.inactiveCaption);
			panel_9.setBounds(10, y, 563, 42);
			panel_8.add(panel_9);
			panel_9.setLayout(null);
			
			
			
		JLabel lblNewLabel_4_2 = new JLabel(c[i].Name);
		lblNewLabel_4_2.setBounds(10, 13, 76, 19);
		lblNewLabel_4_2.setForeground(new Color(0, 51, 102));
		lblNewLabel_4_2.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		panel_9.add(lblNewLabel_4_2);
		
		int k=c[i].courseId;
		
		JLabel lblNewLabel_4_6 = new JLabel( String.valueOf (k) );
		lblNewLabel_4_2.setBounds(10, 13, 76, 19);
		lblNewLabel_4_2.setForeground(new Color(0, 51, 102));
		lblNewLabel_4_2.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		panel_9.add(lblNewLabel_4_6);
		
		JLabel lblNewLabel_4_7 = new JLabel( String.valueOf (id) );
		lblNewLabel_4_2.setBounds(10, 13, 76, 19);
		lblNewLabel_4_2.setForeground(new Color(0, 51, 102));
		lblNewLabel_4_2.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		panel_9.add(lblNewLabel_4_7);
		
		JLabel lblNewLabel_4_2_1 = new JLabel(c[i].creditHours +"crd hrs");
		lblNewLabel_4_2_1.setForeground(new Color(0, 51, 102));
		lblNewLabel_4_2_1.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		lblNewLabel_4_2_1.setBounds(108, 13, 76, 19);
		panel_9.add(lblNewLabel_4_2_1);
		
		
		JLabel lblNewLabel_4_2_1_1 = new JLabel(c[i].SecName);
		lblNewLabel_4_2_1_1.setForeground(new Color(0, 51, 102));
		lblNewLabel_4_2_1_1.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		lblNewLabel_4_2_1_1.setBounds(211, 13, 76, 19);
		panel_9.add(lblNewLabel_4_2_1_1);
		
		
		
	
		
		
		
		if (RegistrationPeriod != 0)
		{
		JButton btnNewButton_1_1 = new JButton("Drop");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			
			{
				int stid = Integer.parseInt(lblNewLabel_4_7 .getText());
 				int cid = Integer.parseInt(lblNewLabel_4_6.getText());
 				data.dropCourse(stid,cid);
				panel_9.setBackground(SystemColor.inactiveCaption);
			}
		});
		btnNewButton_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		btnNewButton_1_1.setBackground(new Color(0, 51, 102));
		btnNewButton_1_1.setBounds(444, 11, 97, 22);
		panel_9.add(btnNewButton_1_1);
		
		
		
		JButton btnNewButton_111 = new JButton("Apply");
		btnNewButton_111.setBounds(250, 11, 60, 22);
		panel_9.add(btnNewButton_111);
		btnNewButton_111.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				int stid = Integer.parseInt(lblNewLabel_4_7 .getText());
 				int cid = Integer.parseInt(lblNewLabel_4_6.getText());
				data. Application(stid,cid);
			}
		});
		btnNewButton_111.setBackground(new Color(0, 51, 102));
		btnNewButton_111.setForeground(new Color(255, 255, 255));
		btnNewButton_111.setFont(new Font("Bahnschrift", Font.PLAIN, 8));
		
		
		
		
		
		JButton btnNewButton_1 = new JButton("Register");
		btnNewButton_1.setBounds(318, 11, 97, 22);
		panel_9.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
			    int stid = Integer.parseInt(lblNewLabel_4_7 .getText());
 				int cid = Integer.parseInt(lblNewLabel_4_6.getText());
				int rr= data.regCourse(stid,cid);
				System.out.print(rr);
				
				if (rr != -1)
				{
					panel_9.setBackground(new Color(95, 158, 160));
				}
			}
		});
		btnNewButton_1.setBackground(new Color(0, 51, 102));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		}
		
		}
		
		
		
		JLabel lblNewLabel_3_2 = new JLabel("Registeration");
		lblNewLabel_3_2.setFont(new Font("Bahnschrift", Font.PLAIN, 27));
		lblNewLabel_3_2.setBounds(63, 10, 215, 46);
		panel_3.add(lblNewLabel_3_2);
		
		
		
		////////////////////////////////////////////   TRANSCRIPT    ////////////////////////////////////////////////////
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Transcript", null, panel_4, null);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_3_2_1 = new JLabel("Transcript");
		lblNewLabel_3_2_1.setBounds(40, 24, 345, 46);
		lblNewLabel_3_2_1.setFont(new Font("Bahnschrift", Font.PLAIN, 27));
		panel_4.add(lblNewLabel_3_2_1);
		
	
		
//		JLabel lblNewLabel_5 = new JLabel("Semester 1");
//		lblNewLabel_5.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
//		lblNewLabel_5.setBounds(10, 10, 94, 19);
//		panel_11.add(lblNewLabel_5);
//		
//		JLabel lblNewLabel_5_1_1 = new JLabel("sgpa");
//		lblNewLabel_5_1_1.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
//		lblNewLabel_5_1_1.setBounds(114, 10, 94, 19);
//		panel_11.add(lblNewLabel_5_1_1);
//		
//		JLabel lblNewLabel_5_1_2 = new JLabel("OOP");
//		lblNewLabel_5_1_2.setForeground(new Color(0, 51, 102));
//		lblNewLabel_5_1_2.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
//		lblNewLabel_5_1_2.setBounds(10, 47, 94, 19);
//		panel_11.add(lblNewLabel_5_1_2);
//		
//		JLabel lblNewLabel_5_1_2_1 = new JLabel("3 crd hr");
//		lblNewLabel_5_1_2_1.setForeground(new Color(0, 51, 102));
//		lblNewLabel_5_1_2_1.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
//		lblNewLabel_5_1_2_1.setBounds(269, 47, 94, 19);
//		panel_11.add(lblNewLabel_5_1_2_1);
//		
//		JLabel lblNewLabel_5_1_2_2 = new JLabel("A-");
//		lblNewLabel_5_1_2_2.setForeground(new Color(0, 153, 0));
//		lblNewLabel_5_1_2_2.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
//		lblNewLabel_5_1_2_2.setBounds(590, 47, 94, 19);
//		panel_11.add(lblNewLabel_5_1_2_2);
//		
//		JSeparator separator_4 = new JSeparator();
//		separator_4.setBounds(10, 64, 608, 2);
//		panel_11.add(separator_4);
		
		
		
		
		JLabel lblNewLabel_5_1 = new JLabel("cgpa:");
		lblNewLabel_5_1.setBounds(40, 75, 94, 19);
		lblNewLabel_5_1.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		panel_4.add(lblNewLabel_5_1);
		
		JTabbedPane tabbedPane_4 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_4.setBounds(40, 147, 639, 372);
		panel_4.add(tabbedPane_4);
		
		JLabel lblNewLabel_5_1_1 = new JLabel(String.valueOf(data.getcgpa(id)));
		lblNewLabel_5_1_1.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		lblNewLabel_5_1_1.setBounds(140, 77, 94, 19);
		panel_4.add(lblNewLabel_5_1_1);
		
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 255, 255));
		
	
		
		int sems = data.sem_std(id);
		
		
				
		for (int i=0;  i < sems ; i++)
		{	
		
		semester[] semss = data.Transcript(id,i+1);
		
		
		JPanel panel_71 = new JPanel();
		panel_71.setBackground(Color.WHITE);
		
		
		
		
		
		
		JLabel lblNewLabel_6 = new JLabel("Course");
		lblNewLabel_6.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(23, 41, 56, 24);
		panel_71.add(lblNewLabel_6);
		
		JLabel lblNewLabel_6_1 = new JLabel("Section");
		lblNewLabel_6_1.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		lblNewLabel_6_1.setBounds(166, 41, 56, 24);
		panel_71.add(lblNewLabel_6_1);
		
		JLabel lblNewLabel_6_2 = new JLabel("Grade");
		lblNewLabel_6_2.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		lblNewLabel_6_2.setBounds(336, 41, 56, 24);
		panel_71.add(lblNewLabel_6_2);
		
		JLabel lblNewLabel_6_3 = new JLabel("Sub gpa");
		lblNewLabel_6_3.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		lblNewLabel_6_3.setBounds(525, 41, 74, 24);
		panel_71.add(lblNewLabel_6_3);
		
		JLabel lblNewLabel_6_4 = new JLabel("sgpa:");
		lblNewLabel_6_4.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		lblNewLabel_6_4.setBounds(461, 10, 56, 24);
		panel_71.add(lblNewLabel_6_4);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(20, 75, 590, 2);
		panel_71.add(separator_2);
		
		int semstrr=i+1;
			
		tabbedPane_4.addTab("Semester: "+(semstrr), null, panel_71, null);
		panel_71.setLayout(null);
		
		JLabel lblNewLabel_6_5 = new JLabel(String.valueOf(semss[i].sgpa));
		lblNewLabel_6_5.setForeground(new Color(0, 51, 102));
		lblNewLabel_6_5.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		lblNewLabel_6_5.setBounds(525, 10, 56, 24);
		panel_71.add(lblNewLabel_6_5);
		
	for (int j =0 , y=99; j <semss[0].size ;y=y+36, j++ )
		
	{	
		
		
		JLabel lblNewLabel_6_6 = new JLabel(semss[j].course);
		lblNewLabel_6_6.setForeground(new Color(0, 51, 102));
		lblNewLabel_6_6.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		lblNewLabel_6_6.setBounds(23,y , 56, 24);
		panel_71.add(lblNewLabel_6_6);
		
		JLabel lblNewLabel_6_7 = new JLabel(semss[j].section);
		lblNewLabel_6_7.setForeground(new Color(0, 51, 102));
		lblNewLabel_6_7.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		lblNewLabel_6_7.setBounds(179, y, 56, 24);
		panel_71.add(lblNewLabel_6_7);
		
		JLabel lblNewLabel_6_8 = new JLabel(semss[j].cs_grade);
		lblNewLabel_6_8.setForeground(new Color(0, 51, 102));
		lblNewLabel_6_8.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		lblNewLabel_6_8.setBounds(349, y, 56, 24);
		panel_71.add(lblNewLabel_6_8);
		
		JLabel lblNewLabel_6_8_1 = new JLabel(String.valueOf(semss[j].grade));
		lblNewLabel_6_8_1.setForeground(new Color(0, 51, 102));
		lblNewLabel_6_8_1.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		lblNewLabel_6_8_1.setBounds(543, y, 56, 24);
		panel_71.add(lblNewLabel_6_8_1);
		
	}
		
		}
		
		////////////////////////////////////////////////////////////////////////////////////////
	}
}




