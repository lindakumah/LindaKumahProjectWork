import java.awt.BorderLayout;
import java.awt.EventQueue;

import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

public class StudentHome extends JFrame {

	private JPanel contentPane;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentHome frame = new StudentHome();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection  connection = null;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	
	
	public void refreachable() {
		String RollNumber = textField_4.getText();
		
		try {
			
			String query = "select * from Admin inner join InsertResult where Admin.RollNumber  = '"+RollNumber+"' and InsertResult.RollNumber = '"+RollNumber+"' ";
			
			Statement ps = connection.createStatement();
			ResultSet rs = ps.executeQuery(query);
			if (rs.next()) {
				textField_1.setText(rs.getString(2));
				textField_2.setText(rs.getString(3));
				textField_3.setText(rs.getString(5));
				textField_5.setText(rs.getString(6));
				textField_6.setText(rs.getString(7));
				
				
				
				textField_7.setText(rs.getString(10));
				textField_8.setText(rs.getString(11));
				textField_9.setText(rs.getString(12));
				textField_10.setText(rs.getString(13));
				textField_11.setText(rs.getString(14));
				
				
		
				int s1 = Integer.parseInt(textField_7.getText());
				int s2 = Integer.parseInt(textField_8.getText());
				int s3 = Integer.parseInt(textField_9.getText());
				int s4 = Integer.parseInt(textField_10.getText());
				int s5 = Integer.parseInt(textField_11.getText());
				
				int results = s1 + s2 + s3 + s4 + s5;
				String s = String.valueOf(results);
				
				textField_12.setText(s);
				
				if(s1 < 50 || s2 < 50 || s3 < 50 || s4 < 50 || s5 < 50 ) {
					textField_13.setText("Fail");
				}else {
					textField_13.setText("Pass");
				}
					
			}
			
			
		   
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "Connection Error");
		}

	}
	
	
	
	
	/**
	 * Create the frame.
	 */
	public StudentHome() {
	
		initComponent();
		
	}

	

	public StudentHome(String RollNumber) {
		// TODO Auto-generated constructor stub
		initComponent();
		connection = ConnectionClass.dbConnector();
		
		textField_4.setText(RollNumber);
		refreachable();
	}

	private void initComponent() {
		// TODO Auto-generated method stub
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 656, 510);
		contentPane = new JPanel();
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.BLACK);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Student Results", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 0, 0)));
	
		panel.setBackground(Color.CYAN);
		panel.setBounds(0, 0, 640, 471);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblRollNumber = new JLabel("Name");
		lblRollNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRollNumber.setBounds(93, 79, 41, 14);
		panel.add(lblRollNumber);
		
		JLabel lblName = new JLabel("Roll Number");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblName.setBounds(331, 79, 77, 14);
		panel.add(lblName);
		
		JLabel lblFathersName = new JLabel("Mother's Name");
		lblFathersName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFathersName.setBounds(311, 110, 97, 14);
		panel.add(lblFathersName);
		
		JLabel lblNewLabel = new JLabel("Course Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(44, 45, 97, 14);
		panel.add(lblNewLabel);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGender.setBounds(85, 110, 49, 14);
		panel.add(lblGender);
		
		JLabel lblBranchName = new JLabel("Branch Name");
		lblBranchName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBranchName.setBounds(321, 45, 97, 14);
		panel.add(lblBranchName);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 141, 640, 330);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("History");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(10, 51, 119, 14);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Computer");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(10, 88, 119, 14);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Communication");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(10, 136, 119, 14);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Hardware");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4.setBounds(10, 182, 119, 14);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Data Science");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_5.setBounds(10, 230, 119, 14);
		panel_1.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Total Marks");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_6.setBounds(10, 285, 119, 14);
		panel_1.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Total Marks");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_7.setBounds(154, 11, 373, 14);
		panel_1.add(lblNewLabel_7);
		
		JLabel lblNewLabel_7_1 = new JLabel("Passing Marks");
		lblNewLabel_7_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_7_1.setBounds(274, 11, 253, 14);
		panel_1.add(lblNewLabel_7_1);
		
		JLabel lblNewLabel_7_2 = new JLabel("Marks Obtained");
		lblNewLabel_7_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_7_2.setBounds(403, 11, 124, 14);
		panel_1.add(lblNewLabel_7_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("100%");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(164, 51, 46, 14);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("100%");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(164, 88, 46, 14);
		panel_1.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("100%");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3_1.setBounds(164, 136, 46, 14);
		panel_1.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_4_1 = new JLabel("100%");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4_1.setBounds(164, 182, 46, 14);
		panel_1.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_5_1 = new JLabel("100%");
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_5_1.setBounds(164, 230, 46, 14);
		panel_1.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_6_1 = new JLabel("100% ");
		lblNewLabel_6_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_6_1.setBounds(164, 285, 46, 14);
		panel_1.add(lblNewLabel_6_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("50%");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(296, 51, 46, 14);
		panel_1.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_2_2 = new JLabel("50%");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_2.setBounds(296, 88, 46, 14);
		panel_1.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_3_2 = new JLabel("50%");
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3_2.setBounds(296, 136, 46, 14);
		panel_1.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_4_2 = new JLabel("50%");
		lblNewLabel_4_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4_2.setBounds(296, 182, 46, 14);
		panel_1.add(lblNewLabel_4_2);
		
		JLabel lblNewLabel_5_2 = new JLabel("50%");
		lblNewLabel_5_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_5_2.setBounds(296, 230, 46, 14);
		panel_1.add(lblNewLabel_5_2);
		
		JLabel lblNewLabel_6_2 = new JLabel("50%");
		lblNewLabel_6_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_6_2.setBounds(296, 285, 46, 14);
		panel_1.add(lblNewLabel_6_2);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_7.setEditable(false);
		textField_7.setBounds(413, 43, 86, 29);
		panel_1.add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_8.setEditable(false);
		textField_8.setColumns(10);
		textField_8.setBounds(413, 80, 86, 29);
		panel_1.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_9.setEditable(false);
		textField_9.setColumns(10);
		textField_9.setBounds(413, 128, 86, 29);
		panel_1.add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_10.setEditable(false);
		textField_10.setColumns(10);
		textField_10.setBounds(413, 174, 86, 29);
		panel_1.add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_11.setEditable(false);
		textField_11.setColumns(10);
		textField_11.setBounds(413, 222, 86, 29);
		panel_1.add(textField_11);
		
		textField_12 = new JTextField();
		textField_12.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_12.setEditable(false);
		textField_12.setColumns(10);
		textField_12.setBounds(413, 277, 86, 29);
		panel_1.add(textField_12);
		
		textField_13 = new JTextField();
		textField_13.setEditable(false);
		textField_13.setBounds(534, 237, 86, 29);
		panel_1.add(textField_13);
		textField_13.setColumns(10);
		
		JButton btnNewButton = new JButton("Logout");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				StudentLogin dd = new StudentLogin();
				dd.setVisible(true);
				dd.setLocationRelativeTo(null);
			}
		});
		btnNewButton.setBounds(531, 285, 89, 34);
		panel_1.add(btnNewButton);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_1.setEditable(false);
		textField_1.setBounds(143, 40, 129, 28);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_2.setEditable(false);
		textField_2.setBounds(418, 40, 137, 28);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_3.setEditable(false);
		textField_3.setText("");
		textField_3.setBounds(144, 74, 128, 28);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_4.setEditable(false);
		textField_4.setBounds(418, 74, 137, 28);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_5.setEditable(false);
		textField_5.setText("");
		textField_5.setBounds(144, 105, 128, 28);
		panel.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_6.setEditable(false);
		textField_6.setBounds(419, 105, 137, 28);
		panel.add(textField_6);
		textField_6.setColumns(10);
	}

}
