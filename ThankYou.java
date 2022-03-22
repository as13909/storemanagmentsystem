package gui;

import java.awt.event.ActionEvent;
import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ThankYou implements ActionListener
{
	JFrame thanks_frame; 
	JLabel TY, note; 
	JButton back; 
	Color main = new Color(149, 205, 151); 
	Font font = new Font("SansSerif",Font.BOLD, 35);
	
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel panel3 = new JPanel();
	JPanel panel4 = new JPanel();
	JPanel panel5 = new JPanel();
	
	ThankYou()
	{
		//create frame 
		thanks_frame = new JFrame(); 
		thanks_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		thanks_frame.setSize(500, 500);
		thanks_frame.setVisible(true);
		thanks_frame.setLayout(new BorderLayout());
		
		//create panels
		panel1.setBackground(main);
		panel1.setPreferredSize(new Dimension(100,100));
		panel1.setLayout(new FlowLayout(FlowLayout.CENTER));
		thanks_frame.add(panel1, BorderLayout.NORTH); 
		
		panel2.setBackground(main);
		panel2.setPreferredSize(new Dimension(100,100));
		thanks_frame.add(panel2, BorderLayout.WEST); 
		
		panel3.setBackground(main);
		panel3.setPreferredSize(new Dimension(100,100));
		thanks_frame.add(panel3, BorderLayout.EAST); 
		
	
		panel4.setBackground(main);
		panel4.setPreferredSize(new Dimension(100,100));
		thanks_frame.add(panel4, BorderLayout.SOUTH); 
		
		panel5.setBackground(Color.white);
		panel5.setPreferredSize(new Dimension(100,100));
		thanks_frame.add(panel5, BorderLayout.CENTER); 
		panel5.setLayout(new FlowLayout());
		
		TY = new JLabel("THANK YOU!"); 
		TY.setBounds(10, 20, 80, 25);
		TY.setFont(font);
		panel5.add(TY);
		
		note = new JLabel("See you soon :)"); 
		note.setBounds(10, 20, 80, 25);
		note.setFont(new Font("SansSerif",Font.PLAIN, 16));
		panel5.add(note);
		
		back = new JButton("Back to Login");
		back.setBounds(90, 90, 80, 25);
		back.addActionListener(this);
		panel1.add(back);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == back)
		{
			NewLaunchPage bck = new NewLaunchPage(); 
			thanks_frame.dispose(); 
		}
		
	}
}
