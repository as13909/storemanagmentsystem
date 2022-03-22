package gui;

import javax.swing.JButton;
import java.awt.Color; 
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
	
public class clear implements ActionListener, ItemListener {
	JFrame clear_frame;
	JButton delete, go_back;
	JLabel question, wrong;
	JCheckBox confirm;
	boolean check = false;
	Color main = new Color(149, 205, 151);
	
	clear()
	{
		//create frame
		clear_frame = new JFrame();
		clear_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		clear_frame.setSize(500, 300);
		clear_frame.setLayout(null);
		clear_frame.getContentPane().setBackground(main);
		clear_frame.setVisible(true);
		
		confirm = new JCheckBox("Confirm you want to delete");
		confirm.setBounds(10, 30, 300, 25);
		confirm.addItemListener(this);
		clear_frame.add(confirm);
		
		delete = new JButton("Delete");
		delete.setBounds(10, 60, 80, 25);
		delete.addActionListener(this);
		clear_frame.add(delete);
		
		go_back = new JButton("Back");
		go_back.setBounds(300, 60, 80, 25);
		go_back.addActionListener(this);
		clear_frame.add(go_back);
		
		question = new JLabel("Are you sure you want to delete all data and reset the store?");
		question.setBounds(5, 1, 400, 25);
		clear_frame.add(question);
		
		wrong = new JLabel("");
		wrong.setBounds(10, 90, 400, 25);
		clear_frame.add(wrong);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == delete && check == true)
		{
			NewLaunchPage rtrn = new NewLaunchPage();
			clear_frame.dispose();
		}
		else if(e.getSource() == go_back)
		{
			StoreOwner bck = new StoreOwner();
			clear_frame.dispose();
		}
		else if(check == false && e.getSource() == delete)
		{
			wrong.setText("Please check the box if you wish to delete all data");
		}
	}
	@Override
	public void itemStateChanged(ItemEvent arg0) {
		if(arg0.getSource() == confirm)
		{
			check = true;
		}
		else
		{
			check = false;
		}

		
	}
}
