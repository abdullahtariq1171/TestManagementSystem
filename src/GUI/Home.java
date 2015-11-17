package GUI;

import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

import Data.User;

public class Home {

	private JFrame frame;
	private User user;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the application.
	 */
	public Home(User user) {
		this.user = user;
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
		
		JLabel lblProfile = new JLabel("Profile");
		lblProfile.setBounds(10, 53, 46, 14);
		frame.getContentPane().add(lblProfile);
		
		lblProfile.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				//Profile window = new Profile(success);
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
				frame.setVisible(false);
				Profile window = new Profile(user,frame);
				window.run();
			}
		});
		
		JLabel lblCourseList = new JLabel("Course List");
		lblCourseList.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				frame.setVisible(false);
				Course_List window = new Course_List(user,frame);
				window.run();
			}
		});
		lblCourseList.setBounds(10, 73, 68, 14);
		frame.getContentPane().add(lblCourseList);
		
		JLabel lblHome = new JLabel("Home");
		lblHome.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblHome.setBounds(192, 11, 58, 14);
		frame.getContentPane().add(lblHome);
		
	}
}
