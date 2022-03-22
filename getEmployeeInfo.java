package gui;

import javax.swing.JButton;
import java.awt.*; 
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class getEmployeeInfo implements ActionListener{
	JFrame get_employee_info_frame;
	JLabel search_employee_prompt, MainLabel;
	JTextField search_employee;
	JButton search, back;
	Color main = new Color(149, 205, 151);
	
	//create panels for border layout
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel panel3 = new JPanel();
	JPanel panel4 = new JPanel();
	JPanel panel5 = new JPanel();
	
	getEmployeeInfo()
	{
		//create frame
		get_employee_info_frame = new JFrame();
		get_employee_info_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		get_employee_info_frame.setSize(500,500);
		get_employee_info_frame.setLayout(new BorderLayout());
		get_employee_info_frame.setVisible(true);
		
		//panel 1 layout + add to frame
		panel1.setBackground(main);
		panel1.setPreferredSize(new Dimension(100,50));
		get_employee_info_frame.add(panel1, BorderLayout.NORTH); 
		panel1.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		//panel 2 layout + add to frame
		panel2.setBackground(main);
		panel2.setPreferredSize(new Dimension(30,50));
		get_employee_info_frame.add(panel2, BorderLayout.WEST); 
		
		//oanel 3 layout + add to frame
		panel3.setBackground(main);
		panel3.setPreferredSize(new Dimension(30,100));
		get_employee_info_frame.add(panel3, BorderLayout.EAST); 
		
		//panel 4 layout + add to frame
		panel4.setBackground(main);
		panel4.setPreferredSize(new Dimension(50,300));
		get_employee_info_frame.add(panel4, BorderLayout.SOUTH); 
		
		//panel 5 layout + add to frame (panel 5 contains buttons and labels
		panel5.setBackground(Color.white);
		panel5.setPreferredSize(new Dimension(100,100));
		get_employee_info_frame.add(panel5, BorderLayout.CENTER); 
		panel5.setLayout(new FlowLayout());
		
		//Add item Jlabel
		MainLabel = new JLabel("Get Employee Info");
		MainLabel.setHorizontalAlignment(JLabel.CENTER);
		MainLabel.setVerticalAlignment(JLabel.CENTER);
		MainLabel.setForeground(new Color(12, 57, 14));
		Font font = new Font("SansSerif",Font.BOLD, 25);
		MainLabel.setFont(font);
		panel1.add(MainLabel); 
		
		//employee prompt JLabel
		search_employee_prompt = new JLabel("Enter the name of the employee you are searching for or type 'ALL':");
		search_employee_prompt.setBounds(10, 10, 500, 25);
		search_employee_prompt.setFont(new Font("SansSerif",Font.PLAIN, 13));
		panel5.add(search_employee_prompt);
		
		//Search employee JTextField
		search_employee = new JTextField();
		search_employee.setBounds(430, 10, 80, 25);
		search_employee.setPreferredSize(new Dimension(250,40));
		search_employee.setBackground(new Color(235, 255, 235));
		panel5.add(search_employee);
		
		//JButtons
		search = new JButton("Search");
		search.setBounds(510, 10, 110, 25);
		search.addActionListener(this);
		panel5.add(search);
		
		back = new JButton("Back");
		back.setBounds(5, 30, 110, 25);
		back.addActionListener(this);
		panel5.add(back);
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() == back)
		{
			StoreOwner bck = new StoreOwner();
			get_employee_info_frame.dispose();
		}
		else if(arg0.getSource() == search)
		{
			
		}
		
	}
}
