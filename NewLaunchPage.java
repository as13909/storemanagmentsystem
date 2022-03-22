package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewLaunchPage implements ActionListener
{
	JFrame frame = new JFrame();
	JButton login, cart, userLogin, createAccount;
	JLabel store_name, cartwarning;
	Color main = new Color(149, 205, 151);
	JTextField getUser_username = new JTextField();
	JPasswordField getUser_password = new JPasswordField(); 
	
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel panel3 = new JPanel();
	JPanel panel4 = new JPanel();
	JPanel panel5 = new JPanel();
	
		
	
	NewLaunchPage()
	{		
		//create main frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		
		
		//create north,east,south, west, center panels
		
		panel1.setBackground(main);
		panel1.setPreferredSize(new Dimension(100,100));
		frame.add(panel1, BorderLayout.NORTH); 
		panel1.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		panel2.setBackground(main);
		panel2.setPreferredSize(new Dimension(50,100));
		frame.add(panel2, BorderLayout.WEST); 
		
		panel3.setBackground(main);
		panel3.setPreferredSize(new Dimension(120,100));
		frame.add(panel3, BorderLayout.EAST); 
		
	
		panel4.setBackground(main);
		panel4.setPreferredSize(new Dimension(50,100));
		frame.add(panel4, BorderLayout.SOUTH); 
		
		panel5.setBackground(Color.white);
		panel5.setPreferredSize(new Dimension(100,100));
		frame.add(panel5, BorderLayout.CENTER); 
		panel5.setLayout(new FlowLayout());
		
		
		//create owner login and cart buttons
		
		login = new JButton("Owner Login");			
		login.setBounds(395, 60, 100, 40);
		login.addActionListener(this);
		panel3.add(login);
			
		cart = new JButton("Go to Cart");
		cart.setBounds(290, 60, 100, 40);
		cart.addActionListener(this);
		panel3.add(cart);
			
		//create labels for username, password, store name
		store_name = new JLabel(Main.store_name);
		store_name.setBounds(0, 0, 500, 100);
		store_name.setHorizontalAlignment(JLabel.CENTER);
		store_name.setVerticalAlignment(JLabel.CENTER);
		store_name.setForeground(new Color(12, 57, 14));
		Font font = new Font("SansSerif",Font.PLAIN, 60);
		store_name.setFont(font);
		panel1.add(store_name);
		
		JLabel username = new JLabel("Enter your username: ");
		username.setBounds(0, 0, 500, 100); 
		username.setForeground(new Color(12, 57, 14)); 
		Font textfieldlabel = new Font("SansSerif", Font.PLAIN, 16); 
		username.setFont(textfieldlabel);
		panel5.add(username); 
		
		//username textfield
		getUser_username.setPreferredSize(new Dimension(250,40)); 
		getUser_username.setBackground(new Color(235, 255, 235));
		panel5.add(getUser_username);
		
		JLabel password = new JLabel("Enter your password: "); 
		password.setForeground(new Color(12, 5, 14)); 
		password.setFont(textfieldlabel);
		panel5.add(password);
		
		//password textfield
		getUser_password.setPreferredSize(new Dimension(250,40)); 
		getUser_password.setBackground(new Color(235, 255, 235));
		panel5.add(getUser_password);
		
		//user login and create account buttons
		
		userLogin = new JButton("Login"); 
		userLogin.setBounds(0,0,500,100); 
		userLogin.addActionListener(this); 
		panel5.add(userLogin);
		
		JLabel accountnote = new JLabel("Don't have an account yet? "); 
		accountnote.setForeground(new Color(12, 5, 14)); 
		accountnote.setBounds(0,0,500,100);
		accountnote.setFont(new Font("SansSerif", Font.PLAIN,15));
		panel5.add(accountnote);
		
		createAccount = new JButton("Create Account"); 
		createAccount.setBounds(0,0,500,100); 
		createAccount.addActionListener(this);
		panel5.add(createAccount);
		
			
		frame.setVisible(true);
			
		}
	
	
		
		
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == login) //owner login
		{
			frame.dispose();
			NewWindow login = new NewWindow(); 
		}
		else if(e.getSource() == cart)
		{

			cartwarning = new JLabel("Login first!"); 
			cartwarning.setForeground(Color.red);
			cartwarning.setBounds(0,0,500,100);
			cartwarning.setFont(new Font("SansSerif", Font.BOLD,12));
			panel3.add(cartwarning);
		}
		else if(e.getSource() == userLogin) 
		{ 
			String username = getUser_username.getText(); 
			String password = getUser_password.getText();
			
			if( username.equals(Main.correct_useruser) && password.equals(Main.correct_userpass))
			{
				frame.dispose(); 
				Customer customer = new Customer(); 
				
			}
			
		}
		else if(e.getSource() == createAccount)
		{
			//CreateAccount newaccount = new CreateAccount(); 
			//frame.dispose(); 
		}
		

	}
}
