package gui;

import javax.swing.JButton;
import java.awt.*; 
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class removeItem implements ActionListener{
	JFrame remove_item_frame;
	JLabel item_id_prompt, item_quantity_prompt, remove_item;
	JTextField item_id, item_quantity;
	JButton confirm, get_list, back;
	Color main = new Color(149, 205, 151);
	
	//create panels for border layout
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel panel3 = new JPanel();
	JPanel panel4 = new JPanel();
	JPanel panel5 = new JPanel();
	
	removeItem()
	{
		//create frame 
		remove_item_frame = new JFrame();
		remove_item_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		remove_item_frame.setSize(500, 500);
		remove_item_frame.setLayout(new BorderLayout());
		remove_item_frame.setVisible(true);
		
		//panel1 layout + add to frame
		panel1.setBackground(main);
		panel1.setPreferredSize(new Dimension(100,50));
		remove_item_frame.add(panel1, BorderLayout.NORTH); 
		panel1.setLayout(new FlowLayout(FlowLayout.CENTER));
				
		//panel 2 layout + add to frame
		panel2.setBackground(main);
		panel2.setPreferredSize(new Dimension(100,50));
		remove_item_frame.add(panel2, BorderLayout.WEST); 
				
		//oanel 3 layout + add to frame
		panel3.setBackground(main);
		panel3.setPreferredSize(new Dimension(100,100));
		remove_item_frame.add(panel3, BorderLayout.EAST); 
				
		//panel 4 layout + add to frame
		panel4.setBackground(main);
		panel4.setPreferredSize(new Dimension(50,150));
		remove_item_frame.add(panel4, BorderLayout.SOUTH); 
				
		//panel 5 layout + add to frame (panel 5 contains buttons and labels
		panel5.setBackground(Color.white);
		panel5.setPreferredSize(new Dimension(100,100));
		remove_item_frame.add(panel5, BorderLayout.CENTER); 
		panel5.setLayout(new FlowLayout());
		
		//remove item Jlabel
		remove_item = new JLabel("Remove An Item From Inventory");
		remove_item.setHorizontalAlignment(JLabel.CENTER);
		remove_item.setVerticalAlignment(JLabel.CENTER);
		remove_item.setForeground(new Color(12, 57, 14));
		Font font = new Font("SansSerif",Font.BOLD, 25);
		remove_item.setFont(font);
		panel1.add(remove_item); 
		
		//Enter Id JLabel
		item_id_prompt = new JLabel("Enter Item Id");
		item_id_prompt.setBounds(10, 10, 400, 25);
		item_id_prompt.setFont(new Font("SansSerif",Font.PLAIN, 13));
		panel5.add(item_id_prompt);
		
		//Enter Id TextField
		item_id = new JTextField();
		item_id.setBounds(5, 30, 200, 25);
		item_id.setPreferredSize(new Dimension(250,40));
		item_id.setBackground(new Color(235, 255, 235));
		panel5.add(item_id);
		
		//Enter Number of Items JLabel
		item_quantity_prompt = new JLabel("Enter the Numbers of Items to Remove");
		item_quantity_prompt.setBounds(10, 50, 300, 25);
		item_quantity_prompt.setFont(new Font("SansSerif",Font.PLAIN, 13));
		panel5.add(item_quantity_prompt);

		//Item Quantity TextField
		item_quantity = new JTextField();
		item_quantity.setBounds(5, 70, 60, 25);
		item_quantity.setPreferredSize(new Dimension(250,40));
		item_quantity.setBackground(new Color(235, 255, 235));
		panel5.add(item_quantity);
		
		//Confirm JButton 
		confirm = new JButton("Confirm Removals");
		confirm.setBounds(1, 100, 160, 25);
		confirm.addActionListener(this);
		panel5.add(confirm);
		
		//See all Items JButton 
		get_list = new JButton("See All Items");
		get_list.setBounds(155, 100, 160, 25);
		get_list.addActionListener(this);
		panel5.add(get_list);
		
		//Back Button 
		back = new JButton("Back");
		back.setBounds(1, 130, 160, 25);
		back.addActionListener(this);
		panel5.add(back);
		
		remove_item_frame.setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == confirm)
		{
			removeItem bck = new removeItem();
			remove_item_frame.dispose();
		}
		else if(e.getSource() == get_list)
		{
			itemsList lst = new itemsList();
		}
		else if(e.getSource() == back)
		{
			StoreOwner bck = new StoreOwner();
			remove_item_frame.dispose();
		}
		
		
		
	}
}
