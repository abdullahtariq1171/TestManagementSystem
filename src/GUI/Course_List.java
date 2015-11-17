package GUI;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import Data.Course;
import Data.User;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Course_List {

	private JFrame frame;
	private JTable table;
	User user;
	private JFrame home_frame;
	
	/**
	 * Launch the application.
	 */


	/**
	 * Create the application.
	 */
	public Course_List(User user, JFrame home_frame) {
		this.user = user;
		this.home_frame = home_frame;
		initialize();
	}

	public void run(){
		
		frame.setVisible(true);
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 50, 410, 200);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Course Code", "Course Name"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				frame.dispose();
				home_frame.setVisible(true);
			}
		});
		btnHome.setBounds(0, 11, 89, 23);
		frame.getContentPane().add(btnHome);
		
		JLabel lblCourseList = new JLabel("Course List");
		lblCourseList.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCourseList.setBounds(162, 15, 106, 24);
		frame.getContentPane().add(lblCourseList);
		TableColumn tc = new TableColumn(0, 50);
		String name = "Name";
		tc.setHeaderValue(name);
		
		DefaultTableModel temp  =(DefaultTableModel) table.getModel();
		
		Course[] cList = user.getCourses();

		for (int i = 0; i < cList.length; i++){
			
			temp.addRow(new Object[]{cList[i].getName(),cList[i].getCode()});
		}
			

		
	}
}
