import java.awt.BorderLayout;
import java.awt.EventQueue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

public class InsertTheResults extends JFrame {

	private JPanel contentPane;
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
					InsertTheResults frame = new InsertTheResults();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	Connection  connection = null;
	private JTable table;
	
	
	 public void RefreshTable() {
	  	   try {
					String query = "select * from InsertResult";
					PreparedStatement ps = connection.prepareStatement(query);
					ResultSet rs = ps.executeQuery();
					
					table.setModel(DbUtils.resultSetToTableModel(rs));
					rs.close();
					ps.close();
				
	  	   } catch (Exception e1) {
					e1.printStackTrace();
				}
	     }
	
	
	/**
	 * Create the frame.
	 */
	public InsertTheResults() {
		initComponent();
		connection = ConnectionClass.dbConnector();
		 RefreshTable();
	}

	private void initComponent() {
		// TODO Auto-generated method stub
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 838, 452);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		panel.setBounds(0, 0, 822, 413);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(0, 0, 195, 413);
		panel.add(panel_1);
		
		JButton btnAddNewStudent = new JButton("Add New Student");
		btnAddNewStudent.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAddNewStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				AdminHome ff = new AdminHome();
				ff.setVisible(true);
				ff.setLocationRelativeTo(null);
			}
		});
		btnAddNewStudent.setBounds(10, 63, 176, 57);
		panel_1.add(btnAddNewStudent);
		
		JButton btnNewButton = new JButton("Insert New Results");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				InsertTheResults ff = new InsertTheResults();
				ff.setVisible(true);
				ff.setLocationRelativeTo(null);
			}
		});
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setBounds(10, 165, 176, 57);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_3 = new JButton("Logout");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Index dd = new Index();
				dd.setVisible(true);
				dd.setLocationRelativeTo(null);
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_3.setBounds(54, 326, 89, 33);
		panel_1.add(btnNewButton_3);
		
		JLabel lblRollNumber = new JLabel("Roll Number");
		lblRollNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRollNumber.setBounds(212, 42, 87, 14);
		panel.add(lblRollNumber);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setColumns(10);
		textField.setBounds(303, 36, 154, 31);
		panel.add(textField);
		
		JLabel lblPhysics = new JLabel("History");
		lblPhysics.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPhysics.setBounds(226, 78, 73, 23);
		panel.add(lblPhysics);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_1.setColumns(10);
		textField_1.setBounds(302, 75, 155, 33);
		panel.add(textField_1);
		
		JLabel lblChemistry = new JLabel("Computer");
		lblChemistry.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblChemistry.setBounds(212, 122, 73, 20);
		panel.add(lblChemistry);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_2.setColumns(10);
		textField_2.setBounds(303, 119, 154, 31);
		panel.add(textField_2);
		
		JLabel lblMathematics = new JLabel("Communication");
		lblMathematics.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMathematics.setBounds(195, 167, 104, 25);
		panel.add(lblMathematics);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_3.setColumns(10);
		textField_3.setBounds(302, 161, 155, 31);
		panel.add(textField_3);
		
		JLabel lblElectricalEng = new JLabel("Hardware");
		lblElectricalEng.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblElectricalEng.setBounds(205, 209, 98, 23);
		panel.add(lblElectricalEng);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_4.setColumns(10);
		textField_4.setBounds(303, 206, 154, 35);
		panel.add(textField_4);
		
		JLabel lblMechnicalEng = new JLabel("Data Science");
		lblMechnicalEng.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMechnicalEng.setBounds(205, 255, 98, 23);
		panel.add(lblMechnicalEng);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_5.setColumns(10);
		textField_5.setBounds(302, 252, 155, 33);
		panel.add(textField_5);
		
		JButton btnNewButton_3_1 = new JButton("Save");
		btnNewButton_3_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "insert into InsertResult (RollNumber, History, Computer, Communication,Hardware, DataScience) values (?, ?, ?, ?, ?, ?)";
					PreparedStatement ps = connection.prepareStatement(query);
					
				
					ps.setString(1, textField.getText());
					ps.setString(2, textField_1.getText());
					ps.setString(3, textField_2.getText());
					ps.setString(4, textField_3.getText());
					ps.setString(5, textField_4.getText());
					ps.setString(6, textField_5.getText());
					ps.execute();
					
					JOptionPane.showMessageDialog(null, "Data Created");
					ps.close();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				RefreshTable();
			}
		});
		btnNewButton_3_1.setBounds(271, 303, 175, 33);
		panel.add(btnNewButton_3_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(471, 26, 341, 297);
		panel.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				String ID_ = (table.getModel().getValueAt(row, 0)).toString();
				try {
					String query = "select * from InsertResult where ID = '"+ID_+"'";
					PreparedStatement ps = connection.prepareStatement(query);
		
					ResultSet rs = ps.executeQuery();
					
					while(rs.next()) {
					
						
						
						textField.setText(rs.getString("RollNumber"));
						textField_1.setText(rs.getString("History"));
				     	textField_2.setText(rs.getString("Computer"));
				     	textField_3.setText(rs.getString("Communication"));
				     	textField_4.setText(rs.getString("Hardware"));
				     	textField_5.setText(rs.getString("DataScience"));
						
						
		}
					rs.close();
					ps.close();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
			
		});
		scrollPane.setViewportView(table);
	}
}
