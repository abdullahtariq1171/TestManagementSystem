package GUI;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Data.Admin;
import Data.Student;
import Data.Teacher;
import Data.User;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Profile {

	private JFrame frame;
	private JTextField name;
	private JTextField id;
	private JTextField age;
	private JButton edit_Button;
	private JTextField genderField;
	private JTextField discipline_Field;

	String sname;
	String sid;
	String susername;
	User user;
	private JFrame home_frame;
	
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Profile window = new Profile();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	
	public void run(){
		
		//UserDAO udao = new UserDAO();
		//Student user = udao.getUser();
	
//		name.setText(user.getName());
//		id.setText(user.getPassword());
//		username.setText(user.getName());		
		frame.setVisible(true);
		
	}
	public Profile(User user, JFrame home_frame) {
		initialize(user.getType()+" id");
		
		this.user = user;
		this.home_frame = home_frame;
		
		name.setText(user.getName());
		age.setText(String.valueOf(user.getAge()));
		
		JButton btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				frame.dispose();
				home_frame.setVisible(true);
			}
		});
		btnHome.setBounds(10, 21, 89, 23);
		frame.getContentPane().add(btnHome);
		if(user.is_male()==true){
		genderField.setText("Male");
		}
		else{
			
			genderField.setText("Female");
		}
		
		if(user.getType().equals("Student")){
			
			Student st = (Student) user;
			
			id.setText(st.getRollno());
			discipline_Field.setText(st.getDiscipline());
		}
		
		else if(user.getType().equals("Teacher")){
			
			Teacher t = (Teacher) user;
			
			id.setText(t.getId());
			discipline_Field.setText(t.getDiscipline());
		}
		
		else if(user.getType().equals("Admin")){
			
			Admin a = (Admin) user;
	
			id.setText(a.getId());
			discipline_Field.setText("Non");
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String user_id){
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel profile_title = new JLabel("Profile");
		profile_title.setFont(new Font("Tahoma", Font.BOLD, 16));
		profile_title.setBounds(180, 30, 69, 14);
		frame.getContentPane().add(profile_title);
		
		JLabel name_Label = new JLabel("Name");
		name_Label.setBounds(51, 58, 46, 14);
		frame.getContentPane().add(name_Label);
		
		JLabel id_Label = new JLabel("id");
		id_Label.setText(user_id);
		id_Label.setBounds(51, 86, 69, 14);
		frame.getContentPane().add(id_Label);
		
		JLabel age_Label = new JLabel("Age");
		age_Label.setBounds(51, 120, 59, 14);
		frame.getContentPane().add(age_Label);
		
		name = new JTextField();
		name.setEditable(false);
		name.setBounds(190, 55, 127, 20);
		frame.getContentPane().add(name);
		name.setColumns(10);
		
		id = new JTextField();
		id.setEditable(false);
		id.setBounds(190, 86, 127, 20);
		frame.getContentPane().add(id);
		id.setColumns(10);
		
		age = new JTextField();
		age.setEditable(false);
		age.setBounds(191, 117, 127, 20);
		frame.getContentPane().add(age);
		age.setColumns(10);
		
		edit_Button = new JButton("Edit");
		edit_Button.setBounds(213, 211, 89, 23);
		frame.getContentPane().add(edit_Button);
		
		genderField = new JTextField();
		genderField.setEditable(false);
		genderField.setColumns(10);
		genderField.setBounds(191, 148, 127, 20);
		frame.getContentPane().add(genderField);
		
		JLabel genderLabel = new JLabel("Gender");
		genderLabel.setBounds(51, 151, 46, 14);
		frame.getContentPane().add(genderLabel);
		
		discipline_Field = new JTextField();
		discipline_Field.setEditable(false);
		discipline_Field.setColumns(10);
		discipline_Field.setBounds(191, 179, 127, 21);
		frame.getContentPane().add(discipline_Field);
		
		JLabel disciplineLabel = new JLabel("Discipline");
		disciplineLabel.setBounds(51, 182, 69, 14);
		frame.getContentPane().add(disciplineLabel);
		
	}
}
