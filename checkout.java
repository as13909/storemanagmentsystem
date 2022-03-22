package gui;

import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class checkout implements ActionListener{
	JFrame checkout_frame;
	JButton back;
	checkout()
	{
		checkout_frame = new JFrame();
		checkout_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		checkout_frame.setSize(500, 500);
		checkout_frame.setLayout(null);
		checkout_frame.setVisible(true);
		
		back = new JButton("Back");
		back.setBounds(10, 10, 80, 25);
		back.addActionListener(this);
		checkout_frame.add(back);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == back)
		{
			LaunchPage bck = new LaunchPage();
			checkout_frame.dispose();
		}
		
	}
}
