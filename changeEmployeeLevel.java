package gui;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class changeEmployeeLevel implements ActionListener{
	JFrame change_employee_level_frame;
	JTextField search_employee;
	JCheckBox new_level_prompt;
	JButton back, search, change, roster;
	JLabel search_employee_prompt, roster_prompt, old_level_prompt;
	
	changeEmployeeLevel()
	{
		change_employee_level_frame = new JFrame();
		change_employee_level_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		change_employee_level_frame.setSize(585, 175);
		change_employee_level_frame.setLayout(null);
		change_employee_level_frame.setVisible(true);
		
		search_employee_prompt = new JLabel("Enter the name of the employee you are searching for:");
		search_employee_prompt.setBounds(10, 10, 405, 25);
		change_employee_level_frame.add(search_employee_prompt);
		
		new_level_prompt = new JCheckBox("Change Employee's Admin Status");
		new_level_prompt.setBounds(10, 40, 405, 25);
		change_employee_level_frame.add(new_level_prompt);
		
		search_employee = new JTextField();
		search_employee.setBounds(385, 10, 80, 25);
		change_employee_level_frame.add(search_employee);
		
		search = new JButton("Search");
		search.setBounds(475, 10, 110, 25);
		search.addActionListener(this);
		change_employee_level_frame.add(search);
		
		back = new JButton("Back");
		back.setBounds(5, 90, 110, 25);
		back.addActionListener(this);
		change_employee_level_frame.add(back);
		
		change = new JButton("Change");
		change.setBounds(105, 90,110, 25);
		change.addActionListener(this);
		change_employee_level_frame.add(change);
		
		roster = new JButton("Get Roster");
		roster.setBounds(205, 90, 110, 25);
		roster.addActionListener(this);
		change_employee_level_frame.add(roster);
		
		old_level_prompt = new JLabel("");
		old_level_prompt.setBounds(5, 65, 400, 25);
		change_employee_level_frame.add(old_level_prompt);
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		if(arg0.getSource() == search);
		{
			old_level_prompt.setText("* NAME is CURRENTLY / CURRENTLY NOT an Admin");
		}
		
		if(arg0.getSource() == back)
		{
			editEmployee bck = new editEmployee();
			change_employee_level_frame.dispose();
			
		}
		else if(arg0.getSource() == change)
		{
			changeEmployeeLevel more = new changeEmployeeLevel();
			change_employee_level_frame.dispose();
		}
		
		else if(arg0.getSource() == roster)
		{
			
		}
	
		
	}
}
