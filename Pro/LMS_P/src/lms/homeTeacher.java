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
import javax.swing.JProgressBar;
import javax.swing.JSlider;
import javax.swing.JScrollBar;
import javax.swing.JTree;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.util.Date;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class homeTeacher {

	public JFrame homeTeacher ;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					homeTeacher window = new homeTeacher(1);
					window.homeTeacher.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public homeTeacher(int id) {
		initialize(id);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(int id) {
		
		
		database data = new database();
		Connection connect = data.getConnection();
		
		
		homeTeacher = new JFrame();
		homeTeacher.getContentPane().setBackground(Color.WHITE);
		homeTeacher.setBounds(100, 100, 839, 600);
		homeTeacher.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		homeTeacher.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
		tabbedPane.setBorder(new CompoundBorder(new CompoundBorder(), null));
		tabbedPane.setToolTipText("");
		tabbedPane.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		tabbedPane.setForeground(new Color(0, 51, 102));
		tabbedPane.setBounds(0, 0, 825, 563);
		homeTeacher.getContentPane().add(tabbedPane);
		
		
		/////////////////////////////////////////////////////        homeTeacher        //////////////////////////////////////////////////////////////////////
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		tabbedPane.addTab("homeTeacher", null, panel, null);
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
		
		JLabel lblNewLabel_1_2 = new JLabel("Father Name:");
		lblNewLabel_1_2.setForeground(new Color(0, 51, 102));
		lblNewLabel_1_2.setFont(new Font("Bahnschrift", Font.PLAIN, 17));
		lblNewLabel_1_2.setBounds(20, 135, 112, 34);
		panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("CNIC:");
		lblNewLabel_1_3.setForeground(new Color(0, 51, 102));
		lblNewLabel_1_3.setFont(new Font("Bahnschrift", Font.PLAIN, 17));
		lblNewLabel_1_3.setBounds(20, 162, 58, 34);
		panel.add(lblNewLabel_1_3);
		
		teacher t =data.viewTeacher(id);
		
		JLabel lblNewLabel_1_2_1 = new JLabel(t.name);
		lblNewLabel_1_2_1.setFont(new Font("Bahnschrift", Font.PLAIN, 17));
		lblNewLabel_1_2_1.setBounds(192, 105, 287, 34);
		panel.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_2_3 = new JLabel(t.fatherName);
		lblNewLabel_1_2_3.setFont(new Font("Bahnschrift", Font.PLAIN, 17));
		lblNewLabel_1_2_3.setBounds(191, 135, 223, 34);
		panel.add(lblNewLabel_1_2_3);
		
		JLabel lblNewLabel_1_2_4 = new JLabel(t.cnic);
		lblNewLabel_1_2_4.setFont(new Font("Bahnschrift", Font.PLAIN, 17));
		lblNewLabel_1_2_4.setBounds(192, 162, 112, 34);
		panel.add(lblNewLabel_1_2_4);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(20, 206, 685, 2);
		panel.add(separator_1);
		
		
		JButton btnNewButton = new JButton("Logout");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				gui hm = new gui();
				hm.frame.setVisible(true);
				homeTeacher.setVisible(false);
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 51, 102));
		btnNewButton.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		btnNewButton.setBounds(20, 294, 90, 34);
		panel.add(btnNewButton);
		
		
		
		
		
		////////////////////////////////////////////    MARKS    ////////////////////////////////////////////////////
	
		
		////////////////////////////////////////        ATTENDANCE PANEL      ///////////////////////////////////////////////////////////////
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		tabbedPane.addTab("Manage Attendance", null, panel_1, null);
		panel_1.setLayout(null);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(358, 5, 5, 5);
		panel_1.add(tabbedPane_1);
		
		JTabbedPane tabbedPane_2 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_2.setBounds(36, 73, 597, 459);
		panel_1.add(tabbedPane_2);
		
		
		
		///////////////////////////////////////////////////////////////////////////////////
		
		course cs[]= data.get_sec(id);
		
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Manage Evaluations", null, panel_2, null);
		panel_2.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 255, 255));
		panel_4.setBounds(58, 87, 555, 437);
		panel_2.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Section");
		lblNewLabel_3.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		lblNewLabel_3.setBackground(new Color(240, 240, 240));
		lblNewLabel_3.setBounds(33, 21, 97, 30);
		panel_4.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Type");
		lblNewLabel_3_1.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		lblNewLabel_3_1.setBackground(SystemColor.menu);
		lblNewLabel_3_1.setBounds(168, 21, 97, 30);
		panel_4.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Total");
		lblNewLabel_3_1_1.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		lblNewLabel_3_1_1.setBackground(SystemColor.menu);
		lblNewLabel_3_1_1.setBounds(312, 21, 97, 30);
		panel_4.add(lblNewLabel_3_1_1);
		
		JLabel lblNewLabel_3_1_2 = new JLabel("Weightage");
		lblNewLabel_3_1_2.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		lblNewLabel_3_1_2.setBackground(SystemColor.menu);
		lblNewLabel_3_1_2.setBounds(443, 21, 97, 30);
		panel_4.add(lblNewLabel_3_1_2);
		
		JLabel lblNewLabel_3_1_5 = new JLabel(String.valueOf(id));
		lblNewLabel_3_1_2.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		lblNewLabel_3_1_2.setBackground(SystemColor.menu);
		lblNewLabel_3_1_2.setBounds(443, 21, 97, 30);
		panel_4.add(lblNewLabel_3_1_5);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {1+"-"+cs[0].Name +"-"+cs[0].SecName ,2+"-"+cs[1].Name +"-"+cs[1].SecName,3+"-"+cs[2].Name+"-"+cs[2].SecName,4+"-"+cs[3].Name+"-"+cs[3].SecName}));
		comboBox_1.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		comboBox_1.setBounds(10, 61, 112, 38);
		panel_4.add(comboBox_1);
		
		JComboBox comboBox_1_1 = new JComboBox();
		comboBox_1_1.setModel(new DefaultComboBoxModel(new String[] {"Quiz", "Assignment", "Project", "Final", "Sessional"}));
		comboBox_1_1.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		comboBox_1_1.setBounds(144, 61, 116, 38);
		panel_4.add(comboBox_1_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		textField_2.setBounds(287, 62, 116, 38);
		panel_4.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		textField_3.setColumns(10);
		textField_3.setBounds(424, 61, 116, 38);
		panel_4.add(textField_3);
		
		
		
		JButton btnNewButton_1 = new JButton("Add");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				
				String a = comboBox_1.getSelectedItem().toString();
				String type = comboBox_1_1.getSelectedItem().toString();
				char b= a.charAt(0);
				int cc=Character.getNumericValue(b);
				int cido = cs[cc-1].courseId;
				int tido=Integer.parseInt(lblNewLabel_3_1_5.getText()); 
				int Total = Integer.parseInt(textField_2.getText());
				int Weightage = Integer.parseInt(textField_3.getText());
				
				data.addEvaluation(tido,cido,type,Total,Weightage);
				
				homeTeacher hm = new homeTeacher(id);
				hm.homeTeacher.setVisible(true);
				homeTeacher.setVisible(false);
			}
		});
		btnNewButton_1.setBackground(new Color(0, 51, 102));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		btnNewButton_1.setBounds(413, 382, 127, 45);
		panel_4.add(btnNewButton_1);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Manage Marks", null, panel_5, null);
		panel_5.setLayout(null);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(30, 80, 604, 451);
		panel_5.add(panel_6);
		panel_6.setLayout(null);
		
		
		course csc[]= data.get_sec(id);
		
		String secs[] = new String[csc[0].size];
		
		for (int i=0 ; i<csc[0].size ;i++)
		{
			secs[i]=new String();
			secs[i]=i+1+"-"+csc[i].Name+"-" +csc[i].SecName;
		}
		
		
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				String a = comboBox_2.getSelectedItem().toString();
				char b= a.charAt(0);
				int cc=Character.getNumericValue(b);
				int cido = cs[cc-1].courseId;
				
				evaluation e[] = data.getEvaluation(id,cido);
				
			    String evs[] = new String[e[0].size];
				
				for (int i=0 ; i<e[0].size ;i++)
				{
					evs[i]=new String();
					evs[i]=i+1+"-"+e[i].Name;
				}
				
				
				JComboBox comboBox_2_1 = new JComboBox();
				comboBox_2_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) 
					{

						String aa = comboBox_2_1.getSelectedItem().toString();
						char bb= aa.charAt(0);
						int ccc=Character.getNumericValue(bb);
						
						
						int eido = e[ccc-1].id;
						
						int marks[]= new int[10];
						
						
						int numberOfFields = 10;
						JTextField[] tfs = new JTextField[numberOfFields];

						for (int j = 0; j < tfs.length; j++) 
						{
						  tfs[j] = new JTextField();
						}
						
						JButton btnNewButton_2 = new JButton("Add");
						btnNewButton_2.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) 
							{
								System.out.print(ccc);
								std s[]= data.get_stds(id,cido);
								int kaboo=0;
								for (int i =0 ,y=102 ; i < s[0].size ; y=y+35, i++)
								{
								JLabel lblNewLabel_4 = new JLabel(s[i].Name);
								lblNewLabel_4.setForeground(new Color(0, 51, 102));
								lblNewLabel_4.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
								lblNewLabel_4.setBounds(20, y, 126, 31);
								panel_6.add(lblNewLabel_4);
								
								JLabel lblNewLabel_4_1 = new JLabel( String.valueOf(s[i].roll));
								lblNewLabel_4_1.setForeground(new Color(0, 51, 102));
								lblNewLabel_4_1.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
								lblNewLabel_4_1.setBounds(203, y, 126, 31);
								panel_6.add(lblNewLabel_4_1);
								
								JLabel lblNewLabel_4_2 = new JLabel(String.valueOf( e[ccc-1].total));
								lblNewLabel_4_2.setForeground(new Color(0, 51, 102));
								lblNewLabel_4_2.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
								lblNewLabel_4_2.setBounds(362, y, 126, 31);
								panel_6.add(lblNewLabel_4_2);
								
								//textField_4 = new JTextField();
								tfs[i].setText("");
								tfs[i].addActionListener(new ActionListener() 
								{
									public void actionPerformed(ActionEvent arg0) 
									{
										String text = textField.getText();
									}
								});
								tfs[i].setBounds(498, y-1, 73, 31);
								panel_6.add(tfs[i]);
								tfs[i].setColumns(10);
								
								
								homeTeacher.setVisible(false);
								homeTeacher.setVisible(true);
								
								}
								
							
								
								JLabel lblNewLabel_4_3 = new JLabel("Name");
								lblNewLabel_4_3.setForeground(new Color(0, 0, 0));
								lblNewLabel_4_3.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
								lblNewLabel_4_3.setBounds(30, 73, 126, 31);
								panel_6.add(lblNewLabel_4_3);
								
								JLabel lblNewLabel_4_3_1 = new JLabel("RollNum");
								lblNewLabel_4_3_1.setForeground(Color.BLACK);
								lblNewLabel_4_3_1.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
								lblNewLabel_4_3_1.setBounds(191, 73, 126, 31);
								panel_6.add(lblNewLabel_4_3_1);
								
								JLabel lblNewLabel_4_3_2 = new JLabel("Total");
								lblNewLabel_4_3_2.setForeground(Color.BLACK);
								lblNewLabel_4_3_2.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
								lblNewLabel_4_3_2.setBounds(350, 73, 126, 31);
								panel_6.add(lblNewLabel_4_3_2);
								
								JLabel lblNewLabel_4_3_3 = new JLabel("Obtained");
								lblNewLabel_4_3_3.setForeground(Color.BLACK);
								lblNewLabel_4_3_3.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
								lblNewLabel_4_3_3.setBounds(502, 73, 126, 31);
								panel_6.add(lblNewLabel_4_3_3);
								
								
								
								JButton btnNewButton_3 = new JButton("Update");
								btnNewButton_3.addActionListener(new ActionListener() 
								{
									public void actionPerformed(ActionEvent arg0) 
									{
										for (int i =0 ; i < s[0].size ; i++)
										{
											int mark = Integer.parseInt(tfs[i].getText());
											data.addMarks(eido,s[i].id,mark);
											
											
										}
										
										homeTeacher hm = new homeTeacher(id);
										hm.homeTeacher.setVisible(true);
										homeTeacher.setVisible(false);
									}
								});
								btnNewButton_3.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
								btnNewButton_3.setForeground(new Color(0, 51, 102));
								btnNewButton_3.setBounds(497, 405, 97, 36);
								panel_6.add(btnNewButton_3);
								
							}
						});
						btnNewButton_2.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
						btnNewButton_2.setBounds(456, 10, 126, 41);
						panel_6.add(btnNewButton_2);
						
						
						JSeparator separator_3 = new JSeparator();
						separator_3.setBounds(10, 61, 584, 2);
						panel_6.add(separator_3);
						
						homeTeacher.setVisible(false);
						homeTeacher.setVisible(true);

					}
				});
				comboBox_2_1.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
				comboBox_2_1.setModel(new DefaultComboBoxModel(evs));
				comboBox_2_1.setBounds(162, 10, 126, 41);
				panel_6.add(comboBox_2_1);
				
				homeTeacher.setVisible(false);
				homeTeacher.setVisible(true);

			}
		});
		
		comboBox_2.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		comboBox_2.setForeground(new Color(0, 0, 0));
		comboBox_2.setModel(new DefaultComboBoxModel(secs));
		comboBox_2.setBounds(10, 10, 126, 41);
		panel_6.add(comboBox_2);
		
		
			
		
				
		
		

		
		
		//////////////////////////////////////////////////////////////////////////////////////
		course c[]= data.get_sec(id);
		
	for (int i=0, y=0 ;i< c[0].size ; y=y+35,i++)		
	{	
		JScrollPane scrollPane = new JScrollPane();
		tabbedPane_2.addTab(c[i].Name + "-"+ c[i].SecName, null, scrollPane, null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		scrollPane.setViewportView(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Name");
		lblNewLabel_2.setFont(new Font("Bahnschrift", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(20, 10, 75, 27);
		panel_3.add(lblNewLabel_2);
		
		int k=c[i].courseId;
		
		JLabel lblNewLabel_7 = new JLabel(String.valueOf(k));
		lblNewLabel_2.setFont(new Font("Bahnschrift", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(20, 10, 75, 27);
		panel_3.add(lblNewLabel_7);
		
		JLabel lblNewLabel_2_1 = new JLabel("RollNum");
		lblNewLabel_2_1.setFont(new Font("Bahnschrift", Font.PLAIN, 17));
		lblNewLabel_2_1.setBounds(164, 10, 75, 27);
		panel_3.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Date");
		lblNewLabel_2_2.setFont(new Font("Bahnschrift", Font.PLAIN, 17));
		lblNewLabel_2_2.setBounds(342, 10, 75, 27);
		panel_3.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("Status");
		lblNewLabel_2_3.setFont(new Font("Bahnschrift", Font.PLAIN, 17));
		lblNewLabel_2_3.setBounds(505, 10, 75, 27);
		panel_3.add(lblNewLabel_2_3);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(20, 35, 544, 2);
		panel_3.add(separator_2);
		
		JButton btnAddAttendance = new JButton("Add Attendance");
		btnAddAttendance.setBounds(20, 393, 144, 27);
		panel_3.add(btnAddAttendance);
		btnAddAttendance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				int cid = Integer.parseInt(lblNewLabel_7.getText());
				std s[]= data.get_stds(id,cid);
				
				
				for (int k=0 ,y= 56 ; k< s[0].size ;k++ , y=y+35)
				{
				JLabel lblNewLabel_2_4 = new JLabel(s[k].Name);
				lblNewLabel_2_4.setForeground(new Color(0, 51, 102));
				lblNewLabel_2_4.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
				lblNewLabel_2_4.setBounds(20, y, 90, 30);
				panel_3.add(lblNewLabel_2_4);
				
				JLabel lblNewLabel_2_8 = new JLabel(String.valueOf (s[k].id));
				lblNewLabel_2_4.setForeground(new Color(0, 51, 102));
				lblNewLabel_2_4.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
				lblNewLabel_2_4.setBounds(20, y, 90, 30);
				panel_3.add(lblNewLabel_2_8);
				
				JLabel lblNewLabel_2_4_1 = new JLabel(String.valueOf (s[k].roll));
				lblNewLabel_2_4_1.setForeground(new Color(0, 51, 102));
				lblNewLabel_2_4_1.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
				lblNewLabel_2_4_1.setBounds(174, y, 75, 30);
				panel_3.add(lblNewLabel_2_4_1);
				
				Date d=new Date(); 
				
				JLabel lblNewLabel_2_4_2 = new JLabel( String.valueOf (d));
				lblNewLabel_2_4_2.setForeground(new Color(0, 51, 102));
				lblNewLabel_2_4_2.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
				lblNewLabel_2_4_2.setBounds(326, y, 91, 30);
				panel_3.add(lblNewLabel_2_4_2);
				
				
				
				JComboBox comboBox = new JComboBox();
				comboBox.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) 
					{
						 
						int cid = Integer.parseInt(lblNewLabel_7.getText());
						int sid = Integer.parseInt(lblNewLabel_2_8.getText());
						String a = comboBox.getSelectedItem().toString();
						
						System.out.println(a);
						data.addAttendance(sid,cid,a);
					}
				});
				comboBox.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
				comboBox.setModel(new DefaultComboBoxModel(new String[] {"-", "A", "P"}));
				comboBox.setBounds(505, y+3, 47, 21);
				panel_3.add(comboBox);
				
				homeTeacher.setVisible(false);
				homeTeacher.setVisible(true);
				
				}
				
				JButton btnApply = new JButton("Apply");
				btnApply.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) 
					{
						homeTeacher hm = new homeTeacher(id);
						hm.homeTeacher.setVisible(true);
						homeTeacher.setVisible(false);
					}
				});
				btnApply.setBackground(new Color(0, 51, 102));
				btnApply.setForeground(new Color(255, 255, 255));
				btnApply.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
				btnApply.setBounds(475, 393, 105, 27);
				panel_3.add(btnApply);
				
			}
		});
		btnAddAttendance.setForeground(Color.WHITE);
		btnAddAttendance.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		btnAddAttendance.setBackground(new Color(0, 51, 102));
		
	//////////////////////////////////////////////////////////////////////////////////////////////////////////
		
	
		
	}
		
		

		
		////////////////////////////////////////////   REGISTRATION    ////////////////////////////////////////////////////
		
		
	}
}
