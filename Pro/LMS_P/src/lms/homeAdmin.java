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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;

public class homeAdmin {

	public JFrame home;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					homeAdmin window = new homeAdmin();
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
	public homeAdmin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		database data = new database();
		Connection connect = data.getConnection();
		
		
		home = new JFrame();
		home.getContentPane().setBackground(Color.WHITE);
		home.setBounds(100, 100, 839, 600);
		home.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		home.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("END SEMESTER");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				data.EndSem();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton.setBounds(126, 55, 179, 57);
		home.getContentPane().add(btnNewButton);
		
		JButton btnOpenRegistration = new JButton("open Registration");
		btnOpenRegistration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				data.openreg();
			}
		});
		btnOpenRegistration.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnOpenRegistration.setForeground(new Color(0, 0, 0));
		btnOpenRegistration.setBounds(457, 55, 179, 57);
		home.getContentPane().add(btnOpenRegistration);
		
		JButton btnCloseRegistration = new JButton("close Registration");
		btnCloseRegistration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				data.closereg();
			}
		});
		btnCloseRegistration.setForeground(Color.BLACK);
		btnCloseRegistration.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnCloseRegistration.setBounds(457, 186, 179, 57);
		home.getContentPane().add(btnCloseRegistration);
		
		JButton btnCloseRegistration_1 = new JButton("Logout");
		btnCloseRegistration_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gui hm = new gui();
				hm.frame.setVisible(true);
				home.setVisible(false);
			}
		});
		btnCloseRegistration_1.setForeground(Color.BLACK);
		btnCloseRegistration_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnCloseRegistration_1.setBounds(126, 186, 179, 57);
		home.getContentPane().add(btnCloseRegistration_1);
		
		
	
		
		////////////////////////////////////////////////////////////////////////////////////////
	}
}
