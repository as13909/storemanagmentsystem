package gui;

import javax.swing.JFrame;
import java.awt.*; 

//Finance is too hard to spell over and over :1

public class storeMoney {
	JFrame money_frame;
	Color main = new Color(149, 205, 151);
	
	storeMoney()
	{
		money_frame = new JFrame();
		money_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		money_frame.setSize(500, 500);
		money_frame.setLayout(null);
		money_frame.setBackground(main); 
		money_frame.setVisible(true);
	}
}
