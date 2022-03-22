package gui;



import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LaunchPage implements ActionListener {
	
	JFrame frame = new JFrame();
	JButton login, cart;
	JLabel store_name;
	
	LaunchPage(){
		
		login = new JButton("Login");
		login.setBounds(395, 60, 100, 40);
		login.addActionListener(this);
		frame.add(login);
		
		cart = new JButton("Go to Cart");
		cart.setBounds(290, 60, 100, 40);
		cart.addActionListener(this);
		frame.add(cart);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		frame.setLayout(null);
		frame.setVisible(true);
		
		store_name = new JLabel(Main.store_name);
		store_name.setBounds(0, 0, 500, 100);
		store_name.setHorizontalAlignment(JLabel.CENTER);
	    store_name.setVerticalAlignment(JLabel.CENTER);
		frame.add(store_name);
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == login)
		{
			frame.dispose();
			LoginPage myWindow = new LoginPage();
		}
		else if(e.getSource() == cart)
		{
			checkout crt = new checkout();
			frame.dispose();
		}
		
		
		
	}
}
