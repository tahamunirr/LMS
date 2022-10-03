package lms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import lms.home;
import lms.homeTeacher;

public class gui {

	public JFrame frame;
	private JTextField textField;
	private JButton btnNewButton;
	private JPasswordField passwordField;
	
	database data = new database();
	Connection connect = data.getConnection();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gui window = new gui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public gui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 10));
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 819, 601);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblUserId = new JLabel("LMS");
		lblUserId.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 99));
		lblUserId.setForeground(new Color(0, 51, 102));
		lblUserId.setBounds(39, 54, 242, 111);
		frame.getContentPane().add(lblUserId);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Tw Cen MT", Font.PLAIN, 41));
		lblNewLabel.setBounds(88, 256, 97, 46);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
	
		textField.setForeground(Color.BLACK);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setColumns(10);
		textField.setBackground(Color.WHITE);
		textField.setBounds(45, 326, 192, 33);
		frame.getContentPane().add(textField);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(39, 175, 242, 2);
		frame.getContentPane().add(separator);
		
	
		
		JLabel lblNewLabel_1 = new JLabel("Learning Management System");
		lblNewLabel_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(39, 152, 249, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setToolTipText("Password");
		passwordField.setBounds(45, 377, 192, 33);
		frame.getContentPane().add(passwordField);
		
		JLabel lblNewLabel_2 = new JLabel("User Id");
		lblNewLabel_2.setBounds(46, 312, 45, 13);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Password");
		lblNewLabel_2_1.setBounds(46, 365, 74, 13);
		frame.getContentPane().add(lblNewLabel_2_1);
		
		
		
		btnNewButton = new JButton("login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				String str = textField.getText();
				char[] str2 = passwordField.getPassword();
				int i=Integer.parseInt(str);
				String s=String.valueOf(str2);
				int result=data.login(i,s);
				 
				if (result == 1)
				{
					home hm = new home(i);
					hm.home.setVisible(true);
					frame.setVisible(false);
				}
				else if (result == 2)
				{
					homeTeacher hm = new homeTeacher(i);
					hm.homeTeacher.setVisible(true);
					frame.setVisible(false);
				}
				else if (result == 3)
				{
					homeAdmin hm = new homeAdmin();
					hm.home.setVisible(true);
					frame.setVisible(false);
				}
				
				
				
				
				System.out.println(result);
			}
		});
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setBounds(99, 431, 85, 21);
		frame.getContentPane().add(btnNewButton);
		
		
		
	}
}
