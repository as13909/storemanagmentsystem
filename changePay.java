package gui;

import javax.swing.JButton;
import java.awt.*; 
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class changePay implements ActionListener{
	
	JFrame pay_frame;
	JLabel avg_pay, lowest_pay, highest_pay, median_pay, input_prompt;
	JButton change_all, all_up, all_down, back;
	JTextField input;
	Color main = new Color(149, 205, 151);
	
	//create panels for border layout
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel panel3 = new JPanel();
	JPanel panel4 = new JPanel();
	JPanel panel5 = new JPanel();
	
	changePay()
	{
	//create frame
	pay_frame = new JFrame();
	pay_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	pay_frame.setSize(500, 500);
	pay_frame.setLayout(new BorderLayout());
	pay_frame.setVisible(true);
	
	//panel1 layout + add to frame
	panel1.setBackground(main);
	panel1.setPreferredSize(new Dimension(100,50));
	pay_frame.add(panel1, BorderLayout.NORTH); 
	panel1.setLayout(new FlowLayout(FlowLayout.CENTER));
	
	//panel 2 layout + add to frame
	panel2.setBackground(main);
	panel2.setPreferredSize(new Dimension(25,50));
	pay_frame.add(panel2, BorderLayout.WEST); 
	
	//oanel 3 layout + add to frame
	panel3.setBackground(main);
	panel3.setPreferredSize(new Dimension(25,100));
	pay_frame.add(panel3, BorderLayout.EAST); 
	
	//panel 4 layout + add to frame
	panel4.setBackground(main);
	panel4.setPreferredSize(new Dimension(50,50));
	pay_frame.add(panel4, BorderLayout.SOUTH); 
	
	//panel 5 layout + add to frame (panel 5 contains buttons and labels
	panel5.setBackground(Color.white);
	panel5.setPreferredSize(new Dimension(100,100));
	pay_frame.add(panel5, BorderLayout.CENTER); 
	panel5.setLayout(new FlowLayout());
	
	//Average JLabel 
	avg_pay = new JLabel("The average pay for all employees is: MONEY dollars per hour");
	avg_pay.setBounds(10, 10, 400, 25);
	avg_pay.setFont(new Font("SansSerif",Font.PLAIN, 13));
	panel5.add(avg_pay);
	
	//lowest paid JLabel 
	lowest_pay = new JLabel("The lowest paid employees earns: MONEY dollars per hour");
	lowest_pay.setBounds(10, 40, 400, 25);
	lowest_pay.setFont(new Font("SansSerif",Font.PLAIN, 13));
	panel5.add(lowest_pay);
	
	//highest paid JLabel
	highest_pay = new JLabel("The highest paid employees earns: MONEY dollars per hour");
	highest_pay.setBounds(10, 70, 400, 25);
	highest_pay.setFont(new Font("SansSerif",Font.PLAIN, 13));
	panel5.add(highest_pay);
	
	//Median pay JLabel
	median_pay = new JLabel("The median pay for all employees is: MONEY dollars per hour");
	median_pay.setBounds(10, 100, 400, 25);
	median_pay.setFont(new Font("SansSerif",Font.PLAIN, 13));
	panel5.add(median_pay);
	
	//get user value input 
	input_prompt = new JLabel("Enter a value then choose what you want to change below");
	input_prompt.setBounds(10, 130, 400, 25);
	input_prompt.setFont(new Font("SansSerif",Font.PLAIN, 13));
	panel5.add(input_prompt);
	
	//value input JTextField
	input = new JTextField("$");
	input.setBounds(375, 130, 75, 25);
	input.setPreferredSize(new Dimension(250,40));
	input.setBackground(new Color(235, 255, 235));
	panel5.add(input);
	
	//completely change pay JButton 
	change_all = new JButton("Change All Employees Pay");
	change_all.setBounds(5, 160, 265, 25);
	change_all.addActionListener(this);
	panel5.add(change_all);
	
	//Add JButton 
	all_up = new JButton("Add Value to All Employees Pay");
	all_up.setBounds(270, 160, 265, 25);
	all_up.addActionListener(this);
	panel5.add(all_up);
	
	//Subtract JButton 
	all_down = new JButton("Decrease All Employees Pay by Value");
	all_down.setBounds(5, 190, 265, 25);
	all_down.addActionListener(this);
	panel5.add(all_down);
	
	//back button 
	back = new JButton("Back");
	back.setBounds(270, 190, 265, 25);
	back.addActionListener(this);
	panel5.add(back);
	
	
	
	
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource() == change_all)
		{
			changePay more = new changePay();
			pay_frame.dispose();
		}
		else if(arg0.getSource() == all_up)
		{
			changePay more = new changePay();
			pay_frame.dispose();
		}
		else if(arg0.getSource() == all_down)
		{
			changePay more = new changePay();
			pay_frame.dispose();
		}
		else if(arg0.getSource() == back)
		{
			StoreOwner bck = new StoreOwner();
			pay_frame.dispose();
		}
	}
}
