import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

import java.sql.*;
import javax.swing.*;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

public class Index extends JFrame {

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
					Index frame = new Index();
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
	public Index() {
		initComponent();
		connection = ConnectionClass.dbConnector();
		this.setLocationRelativeTo(null);
	}

	private void initComponent() {
		// TODO Auto-generated method stub
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 583, 521);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Admin Login Page", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(61, 315, 83, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setBounds(154, 308, 295, 33);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPassword.setBounds(61, 359, 83, 14);
		contentPane.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		passwordField.setBounds(154, 352, 295, 33);
		contentPane.add(passwordField);
		
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
							AdminHome hh = new AdminHome();
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
		btnNewButton.setBounds(116, 396, 369, 30);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("");	
		ImageIcon ggg = new ImageIcon("images/LoginPage.jpg");
		lblNewLabel_1.setIcon(ggg);
		lblNewLabel_1.setBounds(154, 24, 252, 265);
		contentPane.add(lblNewLabel_1);
	}
}
