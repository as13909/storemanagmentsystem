package gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class changeEmployeePayrate implements ActionListener{
	JFrame change_employee_payrate_frame;
	JTextField search_employee, new_payrate;
	JButton back, search, change, roster;
	JLabel search_employee_prompt, new_payrate_prompt, roster_prompt, old_payrate_prompt;
	
	changeEmployeePayrate()
	{
		change_employee_payrate_frame = new JFrame();
		change_employee_payrate_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		change_employee_payrate_frame.setSize(560, 175);
		change_employee_payrate_frame.setLayout(null);
		change_employee_payrate_frame.setVisible(true);
		
		search_employee_prompt = new JLabel("Enter the name of the employee you are searching for:");
		search_employee_prompt.setBounds(10, 10, 375, 25);
		change_employee_payrate_frame.add(search_employee_prompt);
		
		new_payrate_prompt = new JLabel("Enter the new payrate for the employee:");
		new_payrate_prompt.setBounds(10, 40, 375, 25);
		change_employee_payrate_frame.add(new_payrate_prompt);
		
		search_employee = new JTextField();
		search_employee.setBounds(355, 10, 80, 25);
		change_employee_payrate_frame.add(search_employee);
		
		new_payrate = new JTextField();
		new_payrate.setBounds(355, 40, 80, 25);
		change_employee_payrate_frame.add(new_payrate);
		
		search = new JButton("Search");
		search.setBounds(445, 10, 110, 25);
		search.addActionListener(this);
		change_employee_payrate_frame.add(search);
		
		back = new JButton("Back");
		back.setBounds(5, 90, 110, 25);
		back.addActionListener(this);
		change_employee_payrate_frame.add(back);
		
		change = new JButton("Change");
		change.setBounds(105, 90,110, 25);
		change.addActionListener(this);
		change_employee_payrate_frame.add(change);
		
		roster = new JButton("Get Roster");
		roster.setBounds(205, 90, 110, 25);
		roster.addActionListener(this);
		change_employee_payrate_frame.add(roster);
		
		old_payrate_prompt = new JLabel("");
		old_payrate_prompt.setBounds(5, 65, 300, 25);
		change_employee_payrate_frame.add(old_payrate_prompt);
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		if(arg0.getSource() == search);
		{
			old_payrate_prompt.setText("*The current payrate for NAME is payrate");
		}
		
		if(arg0.getSource() == back)
		{
			editEmployee bck = new editEmployee();
			change_employee_payrate_frame.dispose();
			
		}
		else if(arg0.getSource() == change)
		{
			changeEmployeePayrate more = new changeEmployeePayrate();
			change_employee_payrate_frame.dispose();
		}
		
		else if(arg0.getSource() == roster)
		{
			
		}
	
		
	}
}
