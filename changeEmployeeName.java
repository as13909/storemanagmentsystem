package gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class changeEmployeeName implements ActionListener{
	JFrame change_employee_name_frame;
	JTextField search_employee, new_name;
	JButton back, search, change, roster;
	JLabel search_employee_prompt, new_name_prompt, roster_prompt;
	
	changeEmployeeName()
	{
		change_employee_name_frame = new JFrame();
		change_employee_name_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		change_employee_name_frame.setSize(560, 175);
		change_employee_name_frame.setLayout(null);
		change_employee_name_frame.setVisible(true);
		
		search_employee_prompt = new JLabel("Enter the name of the employee you are searching for:");
		search_employee_prompt.setBounds(10, 10, 375, 25);
		change_employee_name_frame.add(search_employee_prompt);
		
		new_name_prompt = new JLabel("Enter the new name for the employee:");
		new_name_prompt.setBounds(10, 40, 375, 25);
		change_employee_name_frame.add(new_name_prompt);
		
		search_employee = new JTextField();
		search_employee.setBounds(355, 10, 80, 25);
		change_employee_name_frame.add(search_employee);
		
		new_name = new JTextField();
		new_name.setBounds(355, 40, 80, 25);
		change_employee_name_frame.add(new_name);
		
		search = new JButton("Search");
		search.setBounds(445, 10, 110, 25);
		search.addActionListener(this);
		change_employee_name_frame.add(search);
		
		back = new JButton("Back");
		back.setBounds(5, 75, 110, 25);
		back.addActionListener(this);
		change_employee_name_frame.add(back);
		
		change = new JButton("Change");
		change.setBounds(105, 75,110, 25);
		change.addActionListener(this);
		change_employee_name_frame.add(change);
		
		roster = new JButton("Get Roster");
		roster.setBounds(205, 75, 110, 25);
		roster.addActionListener(this);
		change_employee_name_frame.add(roster);
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		if(arg0.getSource() == search);
		{
			
		}
		
		if(arg0.getSource() == back)
		{
			editEmployee bck = new editEmployee();
			change_employee_name_frame.dispose();
			
		}
		else if(arg0.getSource() == change)
		{
			changeEmployeeName more = new changeEmployeeName();
			change_employee_name_frame.dispose();
		}
		
		else if(arg0.getSource() == roster)
		{
			
		}
	
		
	}
}
