package GUI;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import DAL.UserDAO;
import Data.Student;

public class Profile {

	private JFrame frame;
	private JTextField name;
	private JTextField id;
	private JTextField username;
	private JButton edit_Button;

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
	
	public void run(String uname){
		
		UserDAO udao = new UserDAO();
		Student user = udao.getUser();
	
		name.setText(user.getName());
		id.setText(user.getPassword());
		username.setText(user.getName());		
		frame.setVisible(true);
		
	}
	public Profile(String username) {
		initialize();
		
		
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(){
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel profile_title = new JLabel("Profile");
		profile_title.setFont(new Font("Tahoma", Font.BOLD, 16));
		profile_title.setBounds(180, 30, 69, 14);
		frame.getContentPane().add(profile_title);
		
		JLabel name_Label = new JLabel("Name");
		name_Label.setBounds(51, 74, 46, 14);
		frame.getContentPane().add(name_Label);
		
		JLabel id_Label = new JLabel("id");
		id_Label.setBounds(51, 100, 46, 14);
		frame.getContentPane().add(id_Label);
		
		JLabel username_Label = new JLabel("User Name");
		username_Label.setBounds(51, 125, 59, 14);
		frame.getContentPane().add(username_Label);
		
		name = new JTextField();
		name.setEditable(false);
		name.setBounds(122, 71, 127, 20);
		frame.getContentPane().add(name);
		name.setColumns(10);
		
		id = new JTextField();
		id.setEditable(false);
		id.setBounds(122, 97, 127, 20);
		frame.getContentPane().add(id);
		id.setColumns(10);
		
		username = new JTextField();
		username.setEditable(false);
		username.setBounds(122, 122, 127, 20);
		frame.getContentPane().add(username);
		username.setColumns(10);
		
		edit_Button = new JButton("Edit");
		edit_Button.setBounds(132, 154, 89, 23);
		frame.getContentPane().add(edit_Button);
	}

}
