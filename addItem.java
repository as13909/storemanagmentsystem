/*
 *
 * Menu for the merchant to add an item to his/her inventory
 * 
 * last-edited: 2021-12-04
 * 
 */ 

package gui;

import java.io.*;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class addItem implements ActionListener{
	// declarations
	String name;
	double price;
	int quantity, id;
	JFrame frame;
	JLabel name_prompt, id_prompt, quantity_prompt, price_prompt, add_item; 
	JTextField nameText, idText, quantityText, priceText;
	JButton confirm, get_list, back;
	String fPath = "src/data/inventory.txt";
    ArrayList<Item> items;
	Color main = new Color(149, 205, 151);
	
	//create panels for border layout
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel panel3 = new JPanel();
	JPanel panel4 = new JPanel();
	JPanel panel5 = new JPanel();

	addItem(){
		//create frame
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);

		//panel1 layout + add to frame
		panel1.setBackground(main);
		panel1.setPreferredSize(new Dimension(100,50));
		frame.add(panel1, BorderLayout.NORTH); 
		panel1.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		//panel 2 layout + add to frame
		panel2.setBackground(main);
		panel2.setPreferredSize(new Dimension(100,50));
		frame.add(panel2, BorderLayout.WEST); 
		
		//oanel 3 layout + add to frame
		panel3.setBackground(main);
		panel3.setPreferredSize(new Dimension(100,100));
		frame.add(panel3, BorderLayout.EAST); 
		
		//panel 4 layout + add to frame
		panel4.setBackground(main);
		panel4.setPreferredSize(new Dimension(50,50));
		frame.add(panel4, BorderLayout.SOUTH); 
		
		//panel 5 layout + add to frame (panel 5 contains buttons and labels
		panel5.setBackground(Color.white);
		panel5.setPreferredSize(new Dimension(100,100));
		frame.add(panel5, BorderLayout.CENTER); 
		panel5.setLayout(new FlowLayout());
		
		//Add item Jlabel
		add_item = new JLabel("Add An Item To Inventory");
		add_item.setHorizontalAlignment(JLabel.CENTER);
		add_item.setVerticalAlignment(JLabel.CENTER);
		add_item.setForeground(new Color(12, 57, 14));
		Font font = new Font("SansSerif",Font.BOLD, 25);
		add_item.setFont(font);
		panel1.add(add_item); 
		
		// NAME -------------
		name_prompt = new JLabel("Item Name:");
		name_prompt.setBounds(10, 10, 400, 25);
		name_prompt.setFont(new Font("SansSerif",Font.PLAIN, 16));
		panel5.add(name_prompt);

		nameText = new JTextField();
		nameText.setBounds(5, 20, 60, 25);
		nameText.setPreferredSize(new Dimension(250,40));
		nameText.setBackground(new Color(235, 255, 235));
		panel5.add(nameText);

		// PRICE ------------
		price_prompt = new JLabel("Price of Item:");
		price_prompt.setBounds(10, 50, 400, 25);
		price_prompt.setFont(new Font("SansSerif",Font.PLAIN, 16));
		panel5.add(price_prompt);

		priceText = new JTextField();
		priceText.setBounds(5, 60, 60, 25);
		priceText.setPreferredSize(new Dimension(250,40));
		priceText.setBackground(new Color(235, 255, 235));
		panel5.add(priceText);

		// STOCK ------------
		quantity_prompt = new JLabel("Number of Items You Wish To Stock:");
		quantity_prompt.setBounds(10, 90, 300, 25);
		quantity_prompt.setFont(new Font("SansSerif",Font.PLAIN, 16));
		panel5.add(quantity_prompt);

		quantityText = new JTextField();
		quantityText.setBounds(5, 100, 60, 25);
		quantityText.setPreferredSize(new Dimension(250,40));
		quantityText.setBackground(new Color(235, 255, 235));
		panel5.add(quantityText);
		
		// ID ----------------
		id_prompt = new JLabel("Item ID:");
		id_prompt.setBounds(10, 130, 400, 25);
		id_prompt.setFont(new Font("SansSerif",Font.PLAIN, 16));
		panel5.add(id_prompt);

		idText = new JTextField();
		idText.setBounds(5, 160, 100, 25);
		idText.setPreferredSize(new Dimension(250,40));
		idText.setBackground(new Color(235, 255, 235));
		panel5.add(idText);
	
		// confirm addition of products
		confirm = new JButton("Confirm Products");
		confirm.setBounds(1, 200, 160, 25);
		confirm.addActionListener(this);
		panel5.add(confirm);
		
		// go back
		back = new JButton("Back");
		back.setBounds(1, 230, 160, 25);
		back.addActionListener(this);
		panel5.add(back);
		
		frame.setVisible(true);
		
	}

	// method for reading file at fPath and storing contents in the ArrayList dest
    public static void readFile(String fPath, ArrayList<Item> dest) throws IOException{
        // declarations
        File file = new File(fPath);
        Scanner input = new Scanner(file);
		BufferedReader br = new BufferedReader(new FileReader(file));
        String[] itemData;
		String line = "";
		int counter = 0;

        // read from the file
        while((line = br.readLine()) != null){
            // declarations
            String name;
            int stock, id;
            double price;
            Item item;

			// DEBUG
			System.out.println("LOG ------- BEGINNING LINE SPLIT...");
            // parsing dash delimited string of Item
            // split on dash
            itemData = line.split("\\-");

			System.out.println("LOG ------- DONE SPLITTING ITEM STRING");
			System.out.println("LOG ------- STARTING TO PARSE DATA FIELDS...");
            // assigning Item attributes from split string
            name = itemData[0];
            stock = Integer.parseInt(itemData[1]);
            price = Double.parseDouble(itemData[2]);
            id = Integer.parseInt(itemData[3]);

			System.out.println("LOG ------- DONE PARSING DATA FIELDS");
			System.out.println("LOG ------- CREATING NEW ITEM...");

            // instantiate Item object
            item = new Item(name, price, stock, id);

			System.out.println("LOG ------- DONE CREATING ITEM, APPENDING...");
            // add to ArrayList of Items
            dest.add(item);
			// DEBUG
			System.out.println("LOG------FINISHED READING LINE "+counter+" AND ADDING ITEM");
			counter++;
        }
		// closing Scanner
		input.close();
		// closing buffered reader
		br.close();
    }

	// method for writing to file at fPath from ArrayList src
	public static void writeFile(String fPath, ArrayList<Item> src) throws IOException{
		// declarations
		File file = new File(fPath);
		PrintWriter pw = new PrintWriter(file);

		// loop through Item objects in src and write to the file
		for(Item i: src){
			pw.println(i.toDelimString());
		}
		System.out.println("LOG-------- FINISHED WRITING");

		// close file
		pw.close();
	}

	@Override
	public void actionPerformed(ActionEvent e){
		// declarations
		items = new ArrayList<Item>();
		// converting user input into useable format
		name = nameText.getText();
		price = Double.parseDouble(priceText.getText());
		quantity = Integer.parseInt(quantityText.getText());
		id = Integer.parseInt(idText.getText());

		if(e.getSource() == confirm)
		{
			// refresh page
			addItem refresh = new addItem();
			frame.dispose();
			// create Item with specifed name, price, etc.
			Item newItem = new Item(name, price, quantity, id);
			// handle exceptions
			try{
				// read from file into list of items
				readFile(fPath, items);
				// add new item to list of items
				items.add(newItem);
				// write updated items list to file
				writeFile(fPath, items);
			} catch(IOException ex) {
				// System.out.println("Ran into an error while reading/writing");
				JOptionPane.showMessageDialog(null, ex+"");
			}
		}
		else if(e.getSource() == back)
		{
			StoreOwner bck = new StoreOwner();
			frame.dispose();
		}
		else
		{}
	}
}
