package GUI;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import DAL.UserDAO;
import Data.User;

public class Login {
	private JFrame frame;
	private JTextField username;
	private JPasswordField password;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton login_Button = new JButton("Login");
		frame.getRootPane().setDefaultButton(login_Button);
		frame.getContentPane().setLayout(null);
		
		username = new JTextField();
		username.setBounds(186, 126, 89, 20);
		frame.getContentPane().add(username);
		username.setColumns(10);
		
		password = new JPasswordField();
		password.setBounds(186, 170, 89, 20);
		frame.getContentPane().add(password);
		
		JLabel usernameLabel = new JLabel("Username");
		usernameLabel.setBounds(75, 129, 77, 14);
		frame.getContentPane().add(usernameLabel);
		
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(75, 173, 77, 14);
		frame.getContentPane().add(passwordLabel);
		
		JLabel title_Label = new JLabel("Login");
		title_Label.setFont(new Font("Tahoma", Font.BOLD, 16));
		title_Label.setBounds(189, 33, 46, 23);
		frame.getContentPane().add(title_Label);
		
		login_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String uname = username.getText();
				String pass = new String(password.getPassword());
				User success = new UserDAO().validateUser(uname, pass);
				if(success!=null){
					//JOptionPane.showMessageDialog(null, "Login Successful");
					frame.dispose();
					/*
					String data = "";
//					Profile profile = new Profile(success);
					data = "Name: " + success.getName();
					data += "Password: " +success.getPassword();
					data += "\n Age: " + success.getAge();
					data += "\n Type: " + success.getType();
					//JOptionPane.showMessageDialog(null, data);

					data = "\n";
					Course[] cList = success.getCourses();
					for (int i = 0; i < cList.length; i++)
						data += "\nName: " + cList[i].getName() + ", Code: " + cList[i].getCode();*/

					//JOptionPane.showMessageDialog(null, "COURSE LIST : \n " + data);
					//Profile window = new Profile(success);
					Home window = new Home(success);
					window.run();
				}
				else{
					JOptionPane.showMessageDialog(null, "Login Unsuccessful");
				}
			}
		});
		login_Button.setBounds(186, 201, 89, 23);
		frame.getContentPane().add(login_Button);
	}
}
