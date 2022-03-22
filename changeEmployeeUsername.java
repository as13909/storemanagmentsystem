package gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class changeEmployeeUsername implements ActionListener{
	JFrame change_employee_username_frame;
	JTextField search_employee, new_username;
	JButton back, search, change, roster;
	JLabel search_employee_prompt, new_username_prompt, roster_prompt, old_username_prompt;
	
	changeEmployeeUsername()
	{
		change_employee_username_frame = new JFrame();
		change_employee_username_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		change_employee_username_frame.setSize(560, 175);
		change_employee_username_frame.setLayout(null);
		change_employee_username_frame.setVisible(true);
		
		search_employee_prompt = new JLabel("Enter the name of the employee you are searching for:");
		search_employee_prompt.setBounds(10, 10, 375, 25);
		change_employee_username_frame.add(search_employee_prompt);
		
		new_username_prompt = new JLabel("Enter the new username for the employee:");
		new_username_prompt.setBounds(10, 40, 375, 25);
		change_employee_username_frame.add(new_username_prompt);
		
		search_employee = new JTextField();
		search_employee.setBounds(355, 10, 80, 25);
		change_employee_username_frame.add(search_employee);
		
		new_username = new JTextField();
		new_username.setBounds(355, 40, 80, 25);
		change_employee_username_frame.add(new_username);
		
		search = new JButton("Search");
		search.setBounds(445, 10, 110, 25);
		search.addActionListener(this);
		change_employee_username_frame.add(search);
		
		back = new JButton("Back");
		back.setBounds(5, 90, 110, 25);
		back.addActionListener(this);
		change_employee_username_frame.add(back);
		
		change = new JButton("Change");
		change.setBounds(105, 90,110, 25);
		change.addActionListener(this);
		change_employee_username_frame.add(change);
		
		roster = new JButton("Get Roster");
		roster.setBounds(205, 90, 110, 25);
		roster.addActionListener(this);
		change_employee_username_frame.add(roster);
		
		old_username_prompt = new JLabel("");
		old_username_prompt.setBounds(5, 65, 300, 25);
		change_employee_username_frame.add(old_username_prompt);
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		if(arg0.getSource() == search);
		{
			old_username_prompt.setText("*The current username for NAME is USERNAME");
		}
		
		if(arg0.getSource() == back)
		{
			editEmployee bck = new editEmployee();
			change_employee_username_frame.dispose();
			
		}
		else if(arg0.getSource() == change)
		{
			changeEmployeeUsername more = new changeEmployeeUsername();
			change_employee_username_frame.dispose();
		}
		
		else if(arg0.getSource() == roster)
		{
			
		}
	
		
	}
}
