package gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.*; 

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class editEmployee implements ActionListener{
	JFrame edit_employee_frame;
	JLabel edit_employee;
	JButton change_name, change_username, change_password, change_payrate, change_level, change_hours, back;
	Color main = new Color(149, 205, 151);
	
	//create panels for border layout
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel panel3 = new JPanel();
	JPanel panel4 = new JPanel();
	JPanel panel5 = new JPanel();
	
	editEmployee()
	{
		edit_employee_frame = new JFrame();
		edit_employee_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		edit_employee_frame.setSize(500,500);
		edit_employee_frame.setLayout(new BorderLayout());
		edit_employee_frame.setVisible(true);
		
		//panel1 layout + add to frame
		panel1.setBackground(main);
		panel1.setPreferredSize(new Dimension(100,70));
		edit_employee_frame.add(panel1, BorderLayout.NORTH); 
		panel1.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		//panel 2 layout + add to frame
		panel2.setBackground(main);
		panel2.setPreferredSize(new Dimension(50,50));
		edit_employee_frame.add(panel2, BorderLayout.WEST); 
		
		//oanel 3 layout + add to frame
		panel3.setBackground(main);
		panel3.setPreferredSize(new Dimension(50,100));
		edit_employee_frame.add(panel3, BorderLayout.EAST); 
		
		//panel 4 layout + add to frame
		panel4.setBackground(main);
		panel4.setPreferredSize(new Dimension(50,150));
		edit_employee_frame.add(panel4, BorderLayout.SOUTH); 
		
		//panel 5 layout + add to frame (panel 5 contains buttons and labels
		panel5.setBackground(Color.white);
		panel5.setPreferredSize(new Dimension(100,100));
		edit_employee_frame.add(panel5, BorderLayout.CENTER); 
		panel5.setLayout(new FlowLayout());
		
		//Edit employee main Jlabel
		edit_employee = new JLabel("Edit Employee");
		edit_employee.setHorizontalAlignment(JLabel.CENTER);
		edit_employee.setVerticalAlignment(JLabel.CENTER);
		edit_employee.setForeground(new Color(12, 57, 14));
		Font font = new Font("SansSerif",Font.BOLD, 35);
		edit_employee.setFont(font);
		panel1.add(edit_employee); 
		
		//Change Employee name JButton
		change_name = new JButton("Change Employee Name");
		change_name.setBounds(10, 10, 250, 25);
		change_name.addActionListener(this);
		panel5.add(change_name);
		
		//Change employee username JButton
		change_username = new JButton("Change Employee Username");
		change_username.setBounds(260, 10, 250, 25);
		change_username.addActionListener(this);
		panel5.add(change_username);
		
		//Change employee Password JButton 
		change_password = new JButton("Change Employee Password");
		change_password.setBounds(510, 10, 250, 25);
		change_password.addActionListener(this);
		panel5.add(change_password);
		
		//Change Employee Pay rate JButton 
		change_payrate = new JButton("Change Employee Payrate");
		change_payrate.setBounds(10, 40, 250, 25);
		change_payrate.addActionListener(this);
		panel5.add(change_payrate);
		
		//Change Employee Clearance Level JButton 
		change_level = new JButton("Change Employee Clearance Level");
		change_level.setBounds(260, 40, 250, 25);
		change_level.addActionListener(this);
		panel5.add(change_level);
		
		//Channge Employee Hours JButton 
		change_hours = new JButton("Change Employee Hours");
		change_hours.setBounds(510, 40, 250, 25);
		change_hours.addActionListener(this);
		panel5.add(change_hours);
		
		//Back Jbutton 
		back = new JButton("Back");
		back.setBounds(260, 70, 250, 25);
		back.addActionListener(this);
		panel5.add(back);
		
		edit_employee_frame.setVisible(true);
		
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == change_name)
		{
			changeEmployeeName new_name = new changeEmployeeName();
			edit_employee_frame.dispose();
		}
		else if (e.getSource() == change_username)
		{
			changeEmployeeUsername chnge = new changeEmployeeUsername();
			edit_employee_frame.dispose();
		}
		else if (e.getSource() == change_password)
		{
			changeEmployeePassword chnge = new changeEmployeePassword();
			edit_employee_frame.dispose();
		}
		else if (e.getSource() == change_payrate)
		{
			changeEmployeePayrate chnge = new changeEmployeePayrate();
			edit_employee_frame.dispose();
		}
		else if (e.getSource() == change_level)
		{
			changeEmployeeLevel chnge = new changeEmployeeLevel();
			edit_employee_frame.dispose();
		}
		else if (e.getSource() == change_hours)
		{
			changeEmployeeHours chnge = new changeEmployeeHours();
			edit_employee_frame.dispose();
		}
		else if (e.getSource() == back)
		{
			StoreOwner bck = new StoreOwner();
			edit_employee_frame.dispose();
		}
	}
}
