package gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class changeEmployeePassword implements ActionListener{
	JFrame change_employee_password_frame;
	JTextField search_employee;
	JPasswordField new_password;
	JButton back, search, change, roster;
	JLabel search_employee_prompt, new_password_prompt, roster_prompt, old_password_prompt;
	
	changeEmployeePassword()
	{
		change_employee_password_frame = new JFrame();
		change_employee_password_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		change_employee_password_frame.setSize(560, 175);
		change_employee_password_frame.setLayout(null);
		change_employee_password_frame.setVisible(true);
		
		search_employee_prompt = new JLabel("Enter the name of the employee you are searching for:");
		search_employee_prompt.setBounds(10, 10, 375, 25);
		change_employee_password_frame.add(search_employee_prompt);
		
		new_password_prompt = new JLabel("Enter the new password for the employee:");
		new_password_prompt.setBounds(10, 40, 375, 25);
		change_employee_password_frame.add(new_password_prompt);
		
		search_employee = new JTextField();
		search_employee.setBounds(355, 10, 80, 25);
		change_employee_password_frame.add(search_employee);
		
		new_password = new JPasswordField();
		new_password.setBounds(355, 40, 80, 25);
		change_employee_password_frame.add(new_password);
		
		search = new JButton("Search");
		search.setBounds(445, 10, 110, 25);
		search.addActionListener(this);
		change_employee_password_frame.add(search);
		
		back = new JButton("Back");
		back.setBounds(5, 90, 110, 25);
		back.addActionListener(this);
		change_employee_password_frame.add(back);
		
		change = new JButton("Change");
		change.setBounds(105, 90,110, 25);
		change.addActionListener(this);
		change_employee_password_frame.add(change);
		
		roster = new JButton("Get Roster");
		roster.setBounds(205, 90, 110, 25);
		roster.addActionListener(this);
		change_employee_password_frame.add(roster);
		
		old_password_prompt = new JLabel("");
		old_password_prompt.setBounds(5, 65, 300, 25);
		change_employee_password_frame.add(old_password_prompt);
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		if(arg0.getSource() == search);
		{
			old_password_prompt.setText("*The current password for NAME is password");
		}
		
		if(arg0.getSource() == back)
		{
			editEmployee bck = new editEmployee();
			change_employee_password_frame.dispose();
			
		}
		else if(arg0.getSource() == change)
		{
			changeEmployeePassword more = new changeEmployeePassword();
			change_employee_password_frame.dispose();
		}
		
		else if(arg0.getSource() == roster)
		{
			
		}
	
		
	}
}
