package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Customer implements ActionListener
{
	JFrame customerFrame = new JFrame(); 
	JButton back, checkout; 
	
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel panel3 = new JPanel();
	JPanel panel4 = new JPanel();
	JPanel panel5 = new JPanel(); 
	
	
	Color main = new Color(228, 245, 232);
	
	Customer()
	{
		customerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		customerFrame.setSize(500, 500); 
		customerFrame.setLayout(new BorderLayout()); 
		customerFrame.setVisible(true); 
		
		panel1.setBackground(main);
		panel1.setPreferredSize(new Dimension(25,25));
		customerFrame.add(panel1, BorderLayout.NORTH); 
		
		panel2.setBackground(main);
		panel2.setPreferredSize(new Dimension(25,25));
		customerFrame.add(panel2, BorderLayout.WEST); 
		
		panel3.setBackground(main);
		panel3.setPreferredSize(new Dimension(100,100));
		customerFrame.add(panel3, BorderLayout.EAST); 
		
		panel4.setBackground(main);
		panel4.setPreferredSize(new Dimension(25, 25));
		customerFrame.add(panel4, BorderLayout.SOUTH); 
		
		panel5.setBackground(main);
		panel5.setPreferredSize(new Dimension(100,100));
		customerFrame.add(panel5, BorderLayout.CENTER); 
		
		
		checkout = new JButton("Checkout!");
		checkout.setBounds(290, 60, 100, 40);
		checkout.addActionListener((ActionListener) this);
		panel3.add(checkout); 
		
		back = new JButton("Back to login");
		back.setBounds(280,60,100,40);
		back.addActionListener((ActionListener) this);
		panel3.add(back);
		
		

		
	
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == checkout)
		{
			customerFrame.dispose(); 
			ThankYou thanks = new ThankYou(); 
			
		}
		else if(e.getSource() == back)
		{
			customerFrame.dispose();
			NewLaunchPage launchpage2 = new NewLaunchPage();
		}
		
		
	}
}
