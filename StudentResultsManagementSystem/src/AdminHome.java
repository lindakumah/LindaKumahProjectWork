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
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

public class AdminHome extends JFrame {

	private JPanel contentPane;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminHome frame = new AdminHome();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection  connection = null;
	private JTable table;
	private JTextField textField_1;
	private JTextField textField;
	
	
	 public void RefreshTable() {
	  	   try {
					String query = "select * from Admin";
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
	public AdminHome() {
		initComponent();
		connection = ConnectionClass.dbConnector();
		 RefreshTable();
	}




	private void initComponent() {
		// TODO Auto-generated method stub
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 885, 423);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		panel.setBounds(0, 0, 869, 384);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 188, 384);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnAddNewStudent = new JButton("Add New Student");
		btnAddNewStudent.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAddNewStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				AdminHome ff = new AdminHome();
				ff.setVisible(true);
			}
		});
		btnAddNewStudent.setForeground(Color.RED);
		btnAddNewStudent.setBounds(10, 57, 168, 57);
		panel_1.add(btnAddNewStudent);
		
		JButton btnNewButton = new JButton("Insert New Results");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				InsertTheResults ff = new InsertTheResults();
				ff.setVisible(true);
			}
		});
		btnNewButton.setBounds(10, 162, 168, 57);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_3 = new JButton("Logout");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Index dd = new Index();
				dd.setVisible(true);
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_3.setBounds(40, 296, 89, 33);
		panel_1.add(btnNewButton_3);
		
		JLabel lblNewLabel = new JLabel("Course Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(198, 53, 94, 14);
		panel.add(lblNewLabel);
		
		JLabel lblBranchName = new JLabel("Branch Name");
		lblBranchName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBranchName.setBounds(198, 92, 94, 14);
		panel.add(lblBranchName);
		
		JLabel lblRollNumber = new JLabel("Roll Number");
		lblRollNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRollNumber.setBounds(211, 131, 77, 14);
		panel.add(lblRollNumber);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblName.setBounds(249, 170, 39, 14);
		panel.add(lblName);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGender.setBounds(239, 216, 49, 14);
		panel.add(lblGender);
		
		JLabel lblFathersName = new JLabel("Mother's Name");
		lblFathersName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFathersName.setBounds(198, 261, 101, 14);
		panel.add(lblFathersName);
		
		JComboBox comboBoxCourse = new JComboBox();
		comboBoxCourse.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBoxCourse.setModel(new DefaultComboBoxModel(new String[] {"Select", "Java", "C++", "Python"}));
		comboBoxCourse.setBounds(302, 48, 195, 28);
		panel.add(comboBoxCourse);
		
		JComboBox comboBoxBranch = new JComboBox();
		comboBoxBranch.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBoxBranch.setModel(new DefaultComboBoxModel(new String[] {"Select", "IT", "Network", "Database"}));
		comboBoxBranch.setBounds(300, 87, 195, 28);
		panel.add(comboBoxBranch);
		
		JComboBox comboBoxGender = new JComboBox();
		comboBoxGender.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBoxGender.setModel(new DefaultComboBoxModel(new String[] {"Select", "Male", "Female"}));
		comboBoxGender.setBounds(298, 211, 176, 28);
		panel.add(comboBoxGender);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_2.setColumns(10);
		textField_2.setBounds(302, 256, 195, 28);
		panel.add(textField_2);
		
		JButton btnNewButton_4 = new JButton("Create");
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "insert into Admin (CourseName, BranchName, RollNumber, Name, Gender, Mname) values (?, ?, ?, ?, ?, ?)";
					PreparedStatement ps = connection.prepareStatement(query);
					
					ps.setString(1, comboBoxCourse.getSelectedItem().toString());
					ps.setString(2, comboBoxBranch.getSelectedItem().toString());
					ps.setString(3, textField.getText());
					ps.setString(4, textField_1.getText());
					ps.setString(5, comboBoxGender.getSelectedItem().toString());
					ps.setString(6, textField_2.getText());
					
					ps.execute();
					
					JOptionPane.showMessageDialog(null, "Data Added");
					ps.close();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				RefreshTable();
			}
		});
		btnNewButton_4.setBounds(240, 311, 89, 34);
		panel.add(btnNewButton_4);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(508, 23, 351, 350);
		panel.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				String ID_ = (table.getModel().getValueAt(row, 0)).toString();
				try {
					String query = "select * from Admin where ID = '"+ID_+"'";
					PreparedStatement ps = connection.prepareStatement(query);
		
					ResultSet rs = ps.executeQuery();
					
					while(rs.next()) {
					
						
						comboBoxCourse.setSelectedItem(rs.getString("CourseNumber"));
						comboBoxBranch.setSelectedItem(rs.getString("BranchName"));
						textField.setText(rs.getString("RollNumber"));
						textField_1.setText(rs.getString("Name"));
						comboBoxGender.setSelectedItem(rs.getString("Gender"));
						textField_2.setText(rs.getString("Mname"));
					
						
						
		}
					rs.close();
					ps.close();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		scrollPane.setViewportView(table);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_1.setColumns(10);
		textField_1.setBounds(300, 165, 195, 28);
		panel.add(textField_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setColumns(10);
		textField.setBounds(300, 126, 195, 28);
		panel.add(textField);
	}
}
