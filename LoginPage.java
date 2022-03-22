package gui;



import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage implements ActionListener
{
    // declarations
	JLabel no_success, passwordLabel, userlabel, first_time_note;
	JButton loginButton, myButton_BACK;
	JPasswordField passwordText;
	JTextField usernameText;
	JFrame login_frame;
	
    // constructor
	LoginPage()
	{
		login_frame = new JFrame();
		
		userlabel = new JLabel("Username");
		passwordLabel = new JLabel("Password"); 
		usernameText = new JTextField(20);
		passwordText = new JPasswordField(20);
		loginButton = new JButton("Login");
		no_success = new JLabel("");
		myButton_BACK = new JButton("Back");
		first_time_note = new JLabel("* If this is your first time logging in, the username is: username and the password is: password");
		
		
		login_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		login_frame.setSize(650, 200);
		login_frame.setLayout(null);
		login_frame.setVisible(true);
		 
		userlabel.setBounds(10, 20, 80, 25);
		login_frame.add(userlabel);
		
		usernameText.setBounds(100, 20, 165, 25);
		login_frame.add(usernameText);
		
		passwordLabel.setBounds(10, 60, 80, 25);
		login_frame.add(passwordLabel);
		
		passwordText.setBounds(100, 60, 165, 25);
		login_frame.add(passwordText);
		
		loginButton.setBounds(10, 90, 80, 25);
		login_frame.add(loginButton);
		loginButton.addActionListener(this);
		
		no_success.setBounds(10, 110, 300, 25);
		login_frame.add(no_success);
		
		myButton_BACK.setBounds(90, 90, 80, 25);
		myButton_BACK.addActionListener(this);
		login_frame.add(myButton_BACK);
	
		first_time_note.setBounds(10, 140, 1000, 25);
		login_frame.add(first_time_note);
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
        // instantiate and get user input
		String username = usernameText.getText();
		String password = passwordText.getText();

		// case: correct username, password and `login` is clicked
		if (username.equals(Main.correct_user) && password.equals(Main.correct_pass) && arg0.getSource() == loginButton)
		{
            // go to store manager page
			StoreOwner owner = new StoreOwner();
			login_frame.dispose();
		}
        // case: login is clicked without correct username, password
		else if(arg0.getSource() == loginButton)
		{
			no_success.setText("Incorrect Username or Password");
		}
		
		// back button is clicked
		if(arg0.getSource() == myButton_BACK)
		{
            // return to launch page
			LaunchPage bck = new LaunchPage();
			login_frame.dispose();
		}
	}

}
