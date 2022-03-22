package gui;

import javax.swing.JButton;
import java.awt.*; 
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class passwordChange implements ActionListener {
	JFrame password_frame;
	JLabel old_password_prompt;
	JLabel new_password_prompt;
	JLabel bad_password;
	JLabel change_password; 
	JPasswordField old_password;
	JPasswordField new_password;
	JButton confirm;
	JButton exit;
	Color main = new Color(149, 205, 151);
	
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel panel3 = new JPanel();
	JPanel panel4 = new JPanel();
	JPanel panel5 = new JPanel();
	
	passwordChange()
	{
		password_frame = new JFrame();
		password_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		password_frame.setSize(500,500);
		password_frame.setLayout(new BorderLayout());
		password_frame.setVisible(true);
		
		//panel1 layout + add to frame
		panel1.setBackground(main);
		panel1.setPreferredSize(new Dimension(100,70));
		password_frame.add(panel1, BorderLayout.NORTH); 
		panel1.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		//panel 2 layout + add to frame
		panel2.setBackground(main);
		panel2.setPreferredSize(new Dimension(50,50));
		password_frame.add(panel2, BorderLayout.WEST); 
		
		//oanel 3 layout + add to frame
		panel3.setBackground(main);
		panel3.setPreferredSize(new Dimension(50,100));
		password_frame.add(panel3, BorderLayout.EAST); 
		
		//panel 4 layout + add to frame
		panel4.setBackground(main);
		panel4.setPreferredSize(new Dimension(50,150));
		password_frame.add(panel4, BorderLayout.SOUTH); 
		
		//panel 5 layout + add to frame (panel 5 contains buttons and labels
		panel5.setBackground(Color.white);
		panel5.setPreferredSize(new Dimension(100,100));
		password_frame.add(panel5, BorderLayout.CENTER); 
		panel5.setLayout(new FlowLayout());
		
		//"Change Password" Jlabel 
		change_password = new JLabel("Change Password");
		change_password.setHorizontalAlignment(JLabel.CENTER);
		change_password.setVerticalAlignment(JLabel.CENTER);
		change_password.setForeground(new Color(12, 57, 14));
		Font font = new Font("SansSerif",Font.BOLD, 35);
		change_password.setFont(font);
		panel1.add(change_password); 
		
		//old password JLabel
		old_password_prompt = new JLabel("Please enter the old password:");
		old_password_prompt.setBounds(10, 10, 200, 25);
		old_password_prompt.setFont(new Font("SansSerif",Font.PLAIN, 18));
		panel5.add(old_password_prompt);
		
		//?
		bad_password = new JLabel("");
		bad_password.setBounds(10, 100, 200, 25);
		panel5.add(bad_password);
		
		//Old password PassWordField
		old_password = new JPasswordField(30);
		old_password.setBounds(210, 10, 200, 25);
		old_password.setPreferredSize(new Dimension(250,40));
		old_password.setBackground(new Color(235, 255, 235));
		panel5.add(old_password);
		
		//new password JLabel
		new_password_prompt = new JLabel("Please enter the new password:");
		new_password_prompt.setBounds(10, 40, 200, 25);
		new_password_prompt.setFont(new Font("SansSerif",Font.PLAIN, 18));
		panel5.add(new_password_prompt);
		
		//new password Password Field 
		new_password = new JPasswordField(30);
		new_password.setBounds(210, 40, 200, 25);
		new_password.setPreferredSize(new Dimension(250,40));
		new_password.setBackground(new Color(235, 255, 235));
		panel5.add(new_password);
		
		//Confirm Button
		confirm = new JButton("Confirm New password");
		confirm.setBounds(10, 70, 200, 25);
		confirm.addActionListener(this);
		panel5.add(confirm);
		
		//back button 
		exit = new JButton("Back");
		exit.setBounds(205, 70, 100, 25);
		exit.addActionListener(this);
		panel5.add(exit);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String temp_old_password = old_password.getText(); 
		String temp_new_password = new_password.getText();
		if(arg0.getSource() == confirm && temp_old_password.equals(Main.correct_pass))
		{
			Main.correct_pass = temp_new_password;
			StoreOwner bck = new StoreOwner();
			password_frame.dispose();
		}
		else if(arg0.getSource() == exit)
		{
			StoreOwner bck = new StoreOwner();
			password_frame.dispose();
		}
		else
		{
			bad_password.setText("Incorrect password");
		}
		
	}
}
