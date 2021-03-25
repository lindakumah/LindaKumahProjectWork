import java.awt.BorderLayout;
import java.awt.EventQueue;

import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;


import net.proteanit.sql.DbUtils;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StudentIndex extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentIndex frame = new StudentIndex();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection  connection = null;
	
	/**
	 * Create the frame.
	 */
	public StudentIndex() {
		initComponent();
		connection = ConnectionClass.dbConnector();
	}
	

	private void initComponent() {
		// TODO Auto-generated method stub
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 719, 499);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		panel.setBounds(0, 0, 710, 460);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter Roll Number");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(80, 149, 273, 41);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(10, 204, 363, 33);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String RollNumber = textField.getText();
				try {
					
					String query = "select * from Admin inner join InsertResult where Admin.RollNumber  = '"+RollNumber+"' and InsertResult.RollNumber = '"+RollNumber+"' ";
					
					Statement ps = connection.createStatement();
					ResultSet rs = ps.executeQuery(query);
					if (rs.next()) {
						setVisible(false);
						new StudentHome(RollNumber).setVisible(true);		
					}else {
						JOptionPane.showMessageDialog(null, "Incorrect Roll Number");
					}
					
					rs.close();
				   ps.close();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Connection Error");
				}
			}
		});
		btnNewButton.setBounds(26, 267, 145, 41);
		panel.add(btnNewButton);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				StudentLogin dd = new StudentLogin();
				dd.setVisible(true);
			}
		});
		btnBack.setBounds(217, 267, 157, 41);
		panel.add(btnBack);
		
		JLabel lblNewLabel_1 = new JLabel("");
		ImageIcon ggg = new ImageIcon("images/StudentPage.jpg");
		lblNewLabel_1.setIcon(ggg);
		lblNewLabel_1.setBounds(0, 0, 721, 460);
		panel.add(lblNewLabel_1);
	}
}