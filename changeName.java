package gui;

import javax.swing.JButton;
import java.awt.*; 
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class changeName implements ActionListener {
	JFrame name_frame;
	JLabel name_prompt;
	JTextField new_name;
	JButton confirm;
	JButton exit;
	JLabel change_name; 
	Color main = new Color(149, 205, 151);
	
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel panel3 = new JPanel();
	JPanel panel4 = new JPanel();
	JPanel panel5 = new JPanel();
	
	changeName()
	{
		//create frame
		name_frame = new JFrame();
		name_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		name_frame.setSize(500,500);
		name_frame.setLayout(new BorderLayout());
		name_frame.setVisible(true);
		
		//panel1 layout + add to frame
		panel1.setBackground(main);
		panel1.setPreferredSize(new Dimension(100,70));
		name_frame.add(panel1, BorderLayout.NORTH); 
		panel1.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		//panel 2 layout + add to frame
		panel2.setBackground(main);
		panel2.setPreferredSize(new Dimension(50,50));
		name_frame.add(panel2, BorderLayout.WEST); 
		
		//oanel 3 layout + add to frame
		panel3.setBackground(main);
		panel3.setPreferredSize(new Dimension(50,100));
		name_frame.add(panel3, BorderLayout.EAST); 
		
		//panel 4 layout + add to frame
		panel4.setBackground(main);
		panel4.setPreferredSize(new Dimension(50,150));
		name_frame.add(panel4, BorderLayout.SOUTH); 
		
		//panel 5 layout + add to frame (panel 5 contains buttons and labels
		panel5.setBackground(Color.white);
		panel5.setPreferredSize(new Dimension(100,100));
		name_frame.add(panel5, BorderLayout.CENTER); 
		panel5.setLayout(new FlowLayout());
		
		//"Change store name" JLabel
		change_name = new JLabel("Change Username");
		change_name.setHorizontalAlignment(JLabel.CENTER);
		change_name.setVerticalAlignment(JLabel.CENTER);
		change_name.setForeground(new Color(12, 57, 14));
		Font font = new Font("SansSerif",Font.BOLD, 35);
		change_name.setFont(font);
		panel1.add(change_name); 
		
		//"Enter a new store name" JLabel
		name_prompt = new JLabel("Please enter the new store name:");
		name_prompt.setBounds(10, 10, 250, 10);
		name_prompt.setFont(new Font("SansSerif",Font.PLAIN, 18));
		panel5.add(name_prompt);
		
		//New store name TextField
		new_name = new JTextField(30);
		new_name.setBounds(230, 5, 200, 25);
		new_name.setPreferredSize(new Dimension(250,40));
		new_name.setBackground(new Color(235, 255, 235));
		panel5.add(new_name);
		
		//Confirm button
		confirm = new JButton("Confirm New Store Name");
		confirm.setBounds(10, 40, 200, 25);
		confirm.addActionListener(this);
		panel5.add(confirm);
		
		//back Button 
		exit = new JButton("Back");
		exit.setBounds(205, 40, 100, 25);
		exit.addActionListener(this);
		panel5.add(exit);
		
		
		
		name_frame.setVisible(true);
	}
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() == confirm)
		{
			Main.store_name = new_name.getText();
			StoreOwner bck = new StoreOwner();
			name_frame.dispose();
		}
		else if(arg0.getSource() == exit)
		{
			StoreOwner bck = new StoreOwner();
			name_frame.dispose();
		}
	}
}
