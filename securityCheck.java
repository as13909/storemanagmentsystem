package gui;



import javax.swing.JButton;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class securityCheck implements ActionListener
{
	JLabel no_success;
	JButton button;
	JPasswordField passwordText;
	JTextField userText;
	JLabel passwordLabel;
	JLabel userlabel;
	JButton myButton_BACK;
	JFrame login_frame;
	JLabel first_time_note;
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel panel3 = new JPanel();
	JPanel panel4 = new JPanel();
	JPanel panel5 = new JPanel();
	Color main = new Color(149, 205, 151);
	
	securityCheck()
	{
		login_frame = new JFrame();
		
		/*userlabel = new JLabel("Username");
		passwordLabel = new JLabel("Password"); 
		userText = new JTextField(20);
		passwordText = new JPasswordField(20);
		button = new JButton("Login");
		no_success = new JLabel("");
		myButton_BACK = new JButton("Back");*/
		first_time_note = new JLabel("Please re-enter your username and password to proceed to the delete page");
		
		
		//create frame 
				login_frame = new JFrame();
				login_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				login_frame.setSize(500, 500);
				login_frame.setVisible(true);
				login_frame.setLayout(new BorderLayout());
				
				//create panels
				panel1.setBackground(main);
				panel1.setPreferredSize(new Dimension(100,50));
				panel1.setLayout(new FlowLayout(FlowLayout.CENTER));
				login_frame.add(panel1, BorderLayout.NORTH); 
				
				panel2.setBackground(main);
				panel2.setPreferredSize(new Dimension(100,100));
				login_frame.add(panel2, BorderLayout.WEST); 
				
				panel3.setBackground(main);
				panel3.setPreferredSize(new Dimension(100,100));
				login_frame.add(panel3, BorderLayout.EAST); 
				
			
				panel4.setBackground(main);
				panel4.setPreferredSize(new Dimension(100,100));
				login_frame.add(panel4, BorderLayout.SOUTH); 
				
				panel5.setBackground(Color.white);
				panel5.setPreferredSize(new Dimension(100,100));
				login_frame.add(panel5, BorderLayout.CENTER); 
				panel5.setLayout(new FlowLayout());
				

				login_frame.setVisible(true);
				
				//Enter your username label
				userlabel = new JLabel("Enter your username: ");
				userlabel.setBounds(10, 20, 80, 25);
				userlabel.setFont(new Font("SansSerif",Font.PLAIN, 16));
				panel5.add(userlabel);
				
				
				//username textfield
				userText = new JTextField(20);
				userText.setBounds(100, 20, 165, 25);
				userText.setBackground(new Color(235, 255, 235));
				userText.setPreferredSize(new Dimension(250,40));
				panel5.add(userText);
				
				//enter password label
				passwordLabel = new JLabel("Enter your password: "); 
				passwordLabel.setBounds(10, 60, 80, 25);
				passwordLabel.setFont(new Font("SansSerif",Font.PLAIN, 16));
				panel5.add(passwordLabel);
				
				//password textfield 
				passwordText = new JPasswordField(20);
				passwordText.setBounds(100, 60, 165, 25);
				passwordText.setBackground(new Color(235, 255, 235));
				passwordText.setPreferredSize(new Dimension(250,40));
				panel5.add(passwordText);
				
				//login button
				button = new JButton("Login");
				button.setBounds(10, 90, 80, 25);
				panel5.add(button);
				button.addActionListener(this);
				
				//incorrect input label
				no_success = new JLabel("");
				no_success.setBounds(10, 110, 300, 25);
				panel5.add(no_success);
				
				//back button
				myButton_BACK = new JButton("Back");
				myButton_BACK.setBounds(90, 90, 80, 25);
				myButton_BACK.addActionListener(this);
				panel5.add(myButton_BACK);
	
		first_time_note.setBounds(10, 140, 1000, 25);
		panel1.add(first_time_note);
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String user = userText.getText();
		String password = passwordText.getText();

		
		if (user.equals(Main.correct_user) && password.equals(Main.correct_pass) && arg0.getSource() == button)
		{
			clear owner = new clear();
			login_frame.dispose();
		}
		else if(arg0.getSource() == button)
		{
			no_success.setText("Incorrect Username or Password");
		}
		
		
		if(arg0.getSource() == myButton_BACK)
		{
			StoreOwner bck = new StoreOwner();
			login_frame.dispose();
		}
	}

}
