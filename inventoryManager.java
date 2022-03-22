/*
 * Window for the inventory management console
 * 
 * last-edited: 2021-12-03
 * 
 */ 


package gui;

import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class inventoryManager implements ActionListener{
    // declarations
	JFrame frame;
    JLabel header1;
	JButton back, add, remove, edit;
    private String fPath = "/data/inventory.txt";
    private ArrayList<Item> items;

    // constructor
	inventoryManager(){
        // creating arraylist to store inventory
        items = new ArrayList<Item>();

        // creating the window
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		frame.setLayout(null);
		frame.setVisible(true);
		
        // 'Inventory Manager' page header
        header1 = new JLabel("Inventory Manager");
		header1.setBounds(0, 0, 600, 25);
		header1.setHorizontalAlignment(JLabel.CENTER);
	    header1.setVerticalAlignment(JLabel.CENTER);
		frame.add(header1);

        // add new item button
        add = new JButton("Add");
		add.setBounds(50, 50, 150, 25);
		add.addActionListener(this);
		frame.add(add);

        // remove current item button
        remove = new JButton("Remove");
        remove.setBounds(50, 125, 150, 25);
        remove.addActionListener(this);
        frame.add(remove);

        // back button
		back = new JButton("Back");
		back.setBounds(1, 150, 160, 25);
		back.addActionListener(this);
		frame.add(back);	
	}
    // read file at fPath and store contents in the ArrayList dest
    // change `throws` to try/catch that displays message in window? probably can leave as is though
    // static void readFile(String fPath, ArrayList<Item> dest) throws IOException{
    //     // declarations
    //     File file = new File(fPath);
    //     Scanner input = new Scanner(file);
    //     String[] itemData;

    //     // read from the file
    //     while(input.hasNext()){
    //         // declarations
    //         String name;
    //         int stock, id;
    //         double price;
    //         Item item;

    //         // parsing dash delimited string of Item
    //         // split on dash
    //         itemData = input.nextLine().split("\\-");
    //         // assigning Item attributes from split string
    //         name = itemData[0];
    //         stock = Integer.parseInt(itemData[1]);
    //         price = Double.parseDouble(itemData[2]);
    //         id = Integer.parseInt(itemData[3]);

    //         // instantiate Item object
    //         item = new Item(name, price, stock, id);

    //         // add to ArrayList of Items
    //         dest.add(item);

    //         // closing Scanner
    //         input.close();
    //     }
    // }
    // write to file at fPath from ArrayList src
    // static void writeFile(String fPath, ArrayList<Item> src) throws IOException{
    //     // declarations
    //     boolean openToAppend = true;
    //     FileWriter fWriter = new FileWriter(fPath, openToAppend);
    //     PrintWriter pWriter = new PrintWriter(fWriter);

    //     // loop through Item objects in src and write to the file
    //     for(Item i: src){
    //         pWriter.print(i.toString());
    //     }

    //     // close file
    //     pWriter.close();
    // }

	@Override
	public void actionPerformed(ActionEvent e) 
	{
        // add item
        if(e.getSource() == add){
            // open menu for removing an item
            addItem plus = new addItem();
            frame.dispose();
        }
        // remove item
        if(e.getSource() == remove){
            // open menu for removing an item
            removeItem rm = new removeItem();
            frame.dispose();
        }
        // go back
		else if(e.getSource() == back)
		{
            // return to merchant management console
			StoreOwner bck = new StoreOwner();
			frame.dispose();
		}
	}
}
