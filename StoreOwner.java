package gui;

import java.awt.event.ActionEvent;
import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class StoreOwner implements ActionListener{
	JFrame owner_frame;
	JButton log_out;
	JButton change_username;
	JButton change_password;
	JButton change_name;
	JButton add_item;
	JButton remove_item, add_employee, edit_employee, get_employee_info, change_pay, get_balance, clear;
	JLabel header1;
	JLabel header2, welcome; //nerd_reference;
	Color main = new Color(149, 205, 151);
	
	StoreOwner()
	{
		owner_frame = new JFrame();
		owner_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		owner_frame.setSize(590, 500);
		owner_frame.setLayout(null);
		owner_frame.setVisible(true);
		owner_frame.getContentPane().setBackground(main);
		
		log_out = new JButton("Logout");
		log_out.setBounds(5, 50, 150, 25);
		log_out.addActionListener(this);
		owner_frame.add(log_out);
		
		change_username = new JButton("Change Username");
		change_username.setBounds(150, 50, 150, 25);
		change_username.addActionListener(this);
		owner_frame.add(change_username);
		
		change_password = new JButton("Change Password");
		change_password.setBounds(295, 50, 150, 25);
		change_password.addActionListener(this);
		owner_frame.add(change_password);
		
		change_name = new JButton("Change Store Name");
		change_name.setBounds(440, 50, 150, 25);
		change_name.addActionListener(this);
		owner_frame.add(change_name);
		
		header1 = new JLabel(Main.store_name);
		header1.setBounds(0, 0, 600, 25);
		header1.setHorizontalAlignment(JLabel.CENTER);
	    header1.setVerticalAlignment(JLabel.CENTER);
	    header1.setFont(new Font("SansSerif",Font.BOLD, 25));
		owner_frame.add(header1);
		
		header2 = new JLabel("Command Center");
		header2.setBounds(0, 0, 600, 75);
		header2.setHorizontalAlignment(JLabel.CENTER);
	    header2.setVerticalAlignment(JLabel.CENTER);
		owner_frame.add(header2);
		
		welcome = new JLabel("Welcome " + Main.correct_user +"!");
		welcome.setBounds(10, 5, 150, 25);
		welcome.setFont(new Font("SansSerif",Font.PLAIN, 15)); 
		owner_frame.add(welcome);
		
		add_item = new JButton("Add Products");
		add_item.setBounds(150, 80, 150, 25);
		add_item.addActionListener(this);
		owner_frame.add(add_item);
		
		remove_item = new JButton("Remove Products");
		remove_item.setBounds(295, 80, 150, 25);
		remove_item.addActionListener(this);
		owner_frame.add(remove_item);
		
		add_employee = new JButton("Add Employee");
		add_employee.setBounds(440, 80, 150, 25);
		add_employee.addActionListener(this);
		owner_frame.add(add_employee);
		
		edit_employee = new JButton("Edit Employee");
		edit_employee.setBounds(5, 80, 150, 25);
		edit_employee.addActionListener(this);
		owner_frame.add(edit_employee);
		
		get_employee_info = new JButton("Employee Info");
		get_employee_info.setBounds(5, 110, 150, 25);
		get_employee_info.addActionListener(this);
		owner_frame.add(get_employee_info);
		
		change_pay = new JButton("Change Payrate");
		change_pay.setBounds(150, 110, 150, 25);
		change_pay.addActionListener(this);
		owner_frame.add(change_pay);
		
		get_balance = new JButton("Store Finances");
		get_balance.setBounds(295, 110, 150, 25);
		get_balance.addActionListener(this);
		owner_frame.add(get_balance);
		
		clear = new JButton("Clear All Data");
		clear.setBounds(440, 110, 150, 25);
		clear.addActionListener(this);
		owner_frame.add(clear);
		
		/*nerd_reference = new JLabel("I'm sorry " + Main.correct_user + ", I'm afraid I can't do that");
		nerd_reference.setBounds(0, 140, 600, 25);
		nerd_reference.setHorizontalAlignment(JLabel.CENTER);
	    nerd_reference.setVerticalAlignment(JLabel.BOTTOM);
	    nerd_reference.setForeground(Color.RED);
	    owner_frame.add(nerd_reference);*/
	    
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource() == log_out)
		{
			NewLaunchPage bck2 = new NewLaunchPage();
			owner_frame.dispose();
		}
		else if(arg0.getSource() == change_password)
		{
			passwordChange new_pass = new passwordChange();
			owner_frame.dispose();
		}
		else if(arg0.getSource() == change_username)
		{
			usernameChange new_username = new usernameChange();
			owner_frame.dispose();
		}
		else if(arg0.getSource() == change_name)
		{
			changeName new_name = new changeName();
			owner_frame.dispose();
		}
		else if(arg0.getSource() == add_item)
		{
			addItem item = new addItem();
			owner_frame.dispose();
		}
		else if(arg0.getSource() == remove_item)
		{
			removeItem item = new removeItem();
			owner_frame.dispose();
		}
		else if(arg0.getSource() == add_employee)
		{
			addEmployee new_emp = new addEmployee();
			owner_frame.dispose();
		}
		else if(arg0.getSource() == edit_employee)
		{
			editEmployee emp = new editEmployee();
			owner_frame.dispose();
		}
		else if(arg0.getSource() == get_employee_info)
		{
			getEmployeeInfo get = new getEmployeeInfo();
			owner_frame.dispose();
		}
		else if(arg0.getSource() == change_pay)
		{
			changePay pay = new changePay();
			owner_frame.dispose();
		}
		else if(arg0.getSource() == get_balance)
		{
			storeMoney pay = new storeMoney();
			owner_frame.dispose();
		}
		
		else if(arg0.getSource() == clear)
		{
			securityCheck clr = new securityCheck();
			owner_frame.dispose();
		}
	}
}