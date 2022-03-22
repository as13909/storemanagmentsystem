package gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class changeEmployeeHours implements ActionListener{
	JFrame change_employee_hours_frame;
	JTextField search_employee, new_hours, date;
	JButton back, search, change, roster;
	JLabel search_employee_prompt, new_hours_prompt, roster_prompt, old_hours_prompt, date_prompt;
	
	changeEmployeeHours()
	{
		change_employee_hours_frame = new JFrame();
		change_employee_hours_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		change_employee_hours_frame.setSize(560, 190);
		change_employee_hours_frame.setLayout(null);
		change_employee_hours_frame.setVisible(true);
		
		search_employee_prompt = new JLabel("Enter the name of the employee you are searching for:");
		search_employee_prompt.setBounds(10, 10, 375, 25);
		change_employee_hours_frame.add(search_employee_prompt);
		
		date_prompt = new JLabel("Enter the date you're looking for (YYYY-MM-DD): ");
		date_prompt.setBounds(10, 40, 375, 25);
		change_employee_hours_frame.add(date_prompt);
		
		date = new JTextField();
		date.setBounds(355, 40, 80, 25);
		change_employee_hours_frame.add(date);
		
		new_hours_prompt = new JLabel("Enter the new hours for the employee:");
		new_hours_prompt.setBounds(10, 70, 375, 25);
		change_employee_hours_frame.add(new_hours_prompt);
		
		search_employee = new JTextField();
		search_employee.setBounds(355, 10, 80, 25);
		change_employee_hours_frame.add(search_employee);
		
		new_hours = new JTextField();
		new_hours.setBounds(355, 70, 80, 25);
		change_employee_hours_frame.add(new_hours);
		
		search = new JButton("Search");
		search.setBounds(445, 10, 110, 50);
		search.addActionListener(this);
		change_employee_hours_frame.add(search);
		
		back = new JButton("Back");
		back.setBounds(5, 120, 110, 25);
		back.addActionListener(this);
		change_employee_hours_frame.add(back);
		
		change = new JButton("Change");
		change.setBounds(105, 120,110, 25);
		change.addActionListener(this);
		change_employee_hours_frame.add(change);
		
		roster = new JButton("Get Roster");
		roster.setBounds(205, 120, 110, 25);
		roster.addActionListener(this);
		change_employee_hours_frame.add(roster);
		
		old_hours_prompt = new JLabel("");
		old_hours_prompt.setBounds(5, 95, 500, 25);
		change_employee_hours_frame.add(old_hours_prompt);
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		if(arg0.getSource() == search);
		{
			old_hours_prompt.setText("*The total hours inputed on DATE by NAME is HOURS");
		}
		
		if(arg0.getSource() == back)
		{
			editEmployee bck = new editEmployee();
			change_employee_hours_frame.dispose();
			
		}
		else if(arg0.getSource() == change)
		{
			changeEmployeeHours more = new changeEmployeeHours();
			change_employee_hours_frame.dispose();
		}
		
		else if(arg0.getSource() == roster)
		{
			
		}
	
		
	}
}
