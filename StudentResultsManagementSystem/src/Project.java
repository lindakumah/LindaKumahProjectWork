import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Project {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Project window = new Project();
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
	public Project() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.CYAN);
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 16));
		frame.setBounds(100, 100, 562, 463);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnStudent = new JButton("Student");
		btnStudent.setBackground(Color.WHITE);
		btnStudent.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				StudentLogin dd = new StudentLogin();
				dd.setVisible(true);
			}
		});
		btnStudent.setBounds(97, 345, 101, 34);
		frame.getContentPane().add(btnStudent);
		
		JButton btnAdmin = new JButton("Admin");
		btnAdmin.setBackground(Color.WHITE);
		btnAdmin.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				Index dd = new Index();
				dd.setVisible(true);
			}
		});
		btnAdmin.setBounds(281, 345, 101, 34);
		frame.getContentPane().add(btnAdmin);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(Color.WHITE);
		ImageIcon ggg = new ImageIcon("images/page.jpg");
		lblNewLabel.setIcon(ggg);
		lblNewLabel.setBounds(0, 0, 546, 334);
		frame.getContentPane().add(lblNewLabel);
	}
}
