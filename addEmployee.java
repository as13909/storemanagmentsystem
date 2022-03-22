package gui;

import javax.swing.JButton;

import java.awt.*; 
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class addEmployee implements ActionListener, ItemListener {
	JFrame add_employee_frame;
	JTextField name, username, payrate;
	JPasswordField password;
	JCheckBox admin;
	JLabel name_prompt, username_prompt, password_prompt, payrate_prompt, add_employee;
	JButton confirm, back;
	Color main = new Color(149, 205, 151);
	
	//create panels for border layout
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel panel3 = new JPanel();
	JPanel panel4 = new JPanel();
	JPanel panel5 = new JPanel();
	
	addEmployee()
	{
		//create frame 
		add_employee_frame = new JFrame();
		add_employee_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add_employee_frame.setSize(500, 500);
		add_employee_frame.setLayout(new BorderLayout());
		add_employee_frame.setVisible(true);
		
		//panel1 layout + add to frame
		panel1.setBackground(main);
		panel1.setPreferredSize(new Dimension(100,50));
		add_employee_frame.add(panel1, BorderLayout.NORTH); 
		panel1.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		//panel 2 layout + add to frame
		panel2.setBackground(main);
		panel2.setPreferredSize(new Dimension(100,50));
		add_employee_frame.add(panel2, BorderLayout.WEST); 
		
		//oanel 3 layout + add to frame
		panel3.setBackground(main);
		panel3.setPreferredSize(new Dimension(100,100));
		add_employee_frame.add(panel3, BorderLayout.EAST); 
		
		//panel 4 layout + add to frame
		panel4.setBackground(main);
		panel4.setPreferredSize(new Dimension(50,50));
		add_employee_frame.add(panel4, BorderLayout.SOUTH); 
		
		//panel 5 layout + add to frame (panel 5 contains buttons and labels
		panel5.setBackground(Color.white);
		panel5.setPreferredSize(new Dimension(100,100));
		add_employee_frame.add(panel5, BorderLayout.CENTER); 
		panel5.setLayout(new FlowLayout());
		
		//add Employee JLabel
		add_employee = new JLabel("Add An Employee");
		add_employee.setHorizontalAlignment(JLabel.CENTER);
		add_employee.setVerticalAlignment(JLabel.CENTER);
		add_employee.setForeground(new Color(12, 57, 14));
		Font font = new Font("SansSerif",Font.BOLD, 25);
		add_employee.setFont(font);
		panel1.add(add_employee); 
		
		//Employee name JLabel
		name_prompt = new JLabel("New Employee's Name:");
		name_prompt.setBounds(10, 5, 200, 25);
		name_prompt.setFont(new Font("SansSerif",Font.PLAIN, 16));
		panel5.add(name_prompt);
		
		//employee neame TextField
		name = new JTextField();
		name.setBounds(210, 5, 110, 25);
		name.setPreferredSize(new Dimension(250,40));
		name.setBackground(new Color(235, 255, 235));
		panel5.add(name);
		
		//user name JLabel
		username_prompt = new JLabel("New Employee's Username:");
		username_prompt.setBounds(10, 30, 200, 25);
		username_prompt.setFont(new Font("SansSerif",Font.PLAIN, 16));
		panel5.add(username_prompt);
		
		//Username TextField
		username = new JTextField();
		username.setBounds(210, 30, 110, 25);
		username.setPreferredSize(new Dimension(250,40));
		username.setBackground(new Color(235, 255, 235));
		panel5.add(username);
		
		//Employee password JLabel
		password_prompt = new JLabel("New Employee's Password:");
		password_prompt.setBounds(10, 55, 200, 25);
		password_prompt.setFont(new Font("SansSerif",Font.PLAIN, 16));
		panel5.add(password_prompt);
		
		//Employee password TextField
		password = new JPasswordField();
		password.setBounds(210, 55, 110, 25);
		password.setPreferredSize(new Dimension(250,40));
		password.setBackground(new Color(235, 255, 235));
		panel5.add(password);
		
		//Employee payrate JLabel
		payrate_prompt = new JLabel("New Employee's Hourly Payrate:");
		payrate_prompt.setBounds(10, 80, 200, 25);
		payrate_prompt.setFont(new Font("SansSerif",Font.PLAIN, 16));
		panel5.add(payrate_prompt);
		
		//Payrate TextField
		payrate = new JTextField();
		payrate.setBounds(210, 80, 110, 25);
		payrate.setPreferredSize(new Dimension(250,40));
		payrate.setBackground(new Color(235, 255, 235));
		panel5.add(payrate);
		
		//JButtons 
		admin = new JCheckBox("Make Admin");
		admin.setBounds(10, 105, 200, 25);
		panel5.add(admin);
		
		confirm = new JButton("Confirm");
		confirm.setBounds(10, 135, 80, 25);
		confirm.addActionListener(this);
		panel5.add(confirm);
		
		back = new JButton("Back");
		back.setBounds(100, 135, 80, 25);
		back.addActionListener(this);
		panel5.add(back);
		
		add_employee_frame.setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {

		if(arg0.getSource() == back)
		{
			StoreOwner bck = new StoreOwner();
			add_employee_frame.dispose();
		}
		else if(arg0.getSource() == confirm);
		{
			StoreOwner bck = new StoreOwner();
			add_employee_frame.dispose();
		}
		
	}
	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource() == admin)
		{
			
		}
	}
}
