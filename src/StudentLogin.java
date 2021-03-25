import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.border.TitledBorder;

public class StudentLogin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentLogin frame = new StudentLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection connection = null;
	
	/**
	 * Create the frame.
	 */
	public StudentLogin() {
		initComponent();
		connection = ConnectionClass.dbConnector();
	}

	private void initComponent() {
		// TODO Auto-generated method stub
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 557, 482);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Student Login Page", TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));
		panel.setBackground(Color.CYAN);
		panel.setBounds(0, 0, 541, 443);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try {
						
						String query = "Select * from User where username = ? and password = ? ";
						PreparedStatement ps = connection.prepareStatement(query);
						ps.setString(1, textField.getText());
						ps.setString(2, passwordField.getText());
						 
						ResultSet rs = ps.executeQuery();
					    int count = 0;
						while(rs.next()) {
							count = count + 1 ;
						}
						if (count == 1) {
								setVisible(false);
								StudentIndex hh = new StudentIndex();
								hh.setVisible(true);
								hh.setLocationRelativeTo(null);
							 
						}else if (count > 1) {
							JOptionPane.showMessageDialog(null, "Duplicate Username and Password");
						}else {
							JOptionPane.showMessageDialog(null, "Username and Password is not Correct.... Try Again...");
						}
						rs.close();
						ps.close();
						  }catch(Exception e1) {
							  JOptionPane.showMessageDialog(null, e1);
							  
						  }
			}
		});
		btnNewButton.setBounds(103, 366, 379, 36);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(47, 290, 88, 14);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(138, 285, 309, 28);
		panel.add(textField);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(138, 324, 309, 28);
		panel.add(passwordField);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPassword.setBounds(47, 329, 88, 14);
		panel.add(lblPassword);
		
		JLabel lblNewLabel_1 = new JLabel("");
		ImageIcon ggg = new ImageIcon("images/LoginPage.jpg");
		lblNewLabel_1.setIcon(ggg);
		lblNewLabel_1.setBounds(150, 11, 252, 268);
		panel.add(lblNewLabel_1);
	}
}
