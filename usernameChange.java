package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class usernameChange implements ActionListener {
	JFrame username_frame;
	JLabel old_username_prompt;
	JLabel new_username_prompt;
	JLabel bad_username;
	JLabel change_username;
	JTextField old_username;
	JTextField new_username;
	JButton confirm;
	JButton exit;
	Color main = new Color(149, 205, 151);
	
	//create panels for border layout
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel panel3 = new JPanel();
	JPanel panel4 = new JPanel();
	JPanel panel5 = new JPanel();
	
	usernameChange()
	{
		//create frame
		username_frame = new JFrame();
		username_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		username_frame.setSize(500,500);
		username_frame.setLayout(new BorderLayout());
		username_frame.setVisible(true);
		
		//panel1 layout + add to frame
		panel1.setBackground(main);
		panel1.setPreferredSize(new Dimension(100,70));
		username_frame.add(panel1, BorderLayout.NORTH); 
		panel1.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		//panel 2 layout + add to frame
		panel2.setBackground(main);
		panel2.setPreferredSize(new Dimension(50,50));
		username_frame.add(panel2, BorderLayout.WEST); 
		
		//oanel 3 layout + add to frame
		panel3.setBackground(main);
		panel3.setPreferredSize(new Dimension(50,100));
		username_frame.add(panel3, BorderLayout.EAST); 
		
		//panel 4 layout + add to frame
		panel4.setBackground(main);
		panel4.setPreferredSize(new Dimension(50,150));
		username_frame.add(panel4, BorderLayout.SOUTH); 
		
		//panel 5 layout + add to frame (panel 5 contains buttons and labels
		panel5.setBackground(Color.white);
		panel5.setPreferredSize(new Dimension(100,100));
		username_frame.add(panel5, BorderLayout.CENTER); 
		panel5.setLayout(new FlowLayout());
		
		//"Change Username" main Jlabel
		change_username = new JLabel("Change Username");
		change_username.setHorizontalAlignment(JLabel.CENTER);
		change_username.setVerticalAlignment(JLabel.CENTER);
		change_username.setForeground(new Color(12, 57, 14));
		Font font = new Font("SansSerif",Font.BOLD, 35);
		change_username.setFont(font);
		panel1.add(change_username); 
		
		//old user name prompt label 
		old_username_prompt = new JLabel("Please enter the old username:");
		old_username_prompt.setFont(new Font("SansSerif",Font.PLAIN, 18));
		old_username_prompt.setBounds(10, 10, 200, 25);
		panel5.add(old_username_prompt);
		
		//old username prompt TextField
		old_username = new JTextField(30);
		old_username.setBounds(210, 10, 200, 25);
		old_username.setPreferredSize(new Dimension(250,40));
		old_username.setBackground(new Color(235, 255, 235));
		panel5.add(old_username);
		
		//new user name prompt 
		new_username_prompt = new JLabel("Please enter the new username:");
		new_username_prompt.setBounds(10, 40, 200, 25);
		new_username_prompt.setFont(new Font("SansSerif",Font.PLAIN, 18));
		panel5.add(new_username_prompt);
		
		//? 
		bad_username = new JLabel("");
		bad_username.setBounds(10, 100, 200, 25);
		panel5.add(bad_username);
		
		//new username TextField
		new_username = new JTextField(30);
		new_username.setBounds(210, 40, 200, 25);
		new_username.setPreferredSize(new Dimension(250,40));
		new_username.setBackground(new Color(235, 255, 235));
		panel5.add(new_username);
		
		//Confirm button 
		confirm = new JButton("Confirm New Username");
		confirm.setBounds(10, 70, 200, 25);
		confirm.addActionListener(this);
		panel5.add(confirm);
		
		//back button 
		exit = new JButton("Back");
		exit.setBounds(205, 70, 100, 25);
		exit.addActionListener(this);
		panel5.add(exit);
		
		username_frame.setVisible(true); 
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String temp_old_username = old_username.getText(); 
		String temp_new_username = new_username.getText();
		if(arg0.getSource() == confirm && temp_old_username.equals(Main.correct_user))
		{
			Main.correct_user = temp_new_username;
			StoreOwner bck = new StoreOwner();
			username_frame.dispose();
		}
		else if(arg0.getSource() == exit)
		{
			StoreOwner bck = new StoreOwner();
			username_frame.dispose();
		}
		else
		{
			bad_username.setText("Incorrect username");
		}
		
	}
}
