package gui;

import javax.swing.JButton;

import java.awt.*; 
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;




//ADD PRICE YOU FUCKING IDIOT!!!!!!!!!
public class itemsList implements ActionListener{
	JFrame item_frame;
	JButton close;
	JLabel item; 
	
	itemsList()
	{
		item_frame = new JFrame();
		item_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		item_frame.setSize(500, 200);
		item_frame.setLayout(null);
		item_frame.setVisible(true);
		
		close = new JButton("Close");
		close.setBounds(10, 10, 80, 25);
		close.addActionListener(this);
		item_frame.add(close);

	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() == close)
		{
			item_frame.dispose(); 
		}
		
	}
}
