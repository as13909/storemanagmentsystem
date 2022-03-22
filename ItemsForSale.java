/*
 *
 * ItemsForSale on customer side
 * 
 * 
 */


package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.io.*;


public class ItemsForSale implements ActionListener{

	private JFrame frame;
	private JTable table;
	DefaultTableModel model;
	private JTextField itemName;
	private JTextField itemId;
	private JTextField numItem;
	private JTextField price;
	private ArrayList<ArrayList<String>> itemCols = new ArrayList<ArrayList<String>>();
	private ArrayList<String> itemNames = new ArrayList<String>();
	private ArrayList<String> itemIds = new ArrayList<String>();
	private ArrayList<String> itemNums = new ArrayList<String>();
	private ArrayList<String> itemPrices = new ArrayList<String>();
    private ArrayList<Item> tableItems = new ArrayList<Item>();
    String iPath = "src/data/inventory.txt"; // path to inventory file
    String cPath = "src/data/cart.txt"; // path to cart file
	
	


	/**
	 * Create the application.
	 */
	public ItemsForSale() {
		
		
		itemCols.add(itemNames);
		itemCols.add(itemIds);
		itemCols.add(itemNums);
		itemCols.add(itemPrices);
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 822, 575);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 250, 240));
		panel.setBounds(0, 0, 822, 552);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(314, 41, 449, 459);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(211, 211, 211));
		model = new DefaultTableModel();
		Object[] column = {"Name", "ID", "Quantity", "Price"};
		final Object[] row = new Object[4];
		model.setColumnIdentifiers(column);
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		JLabel lblItemName = new JLabel("Item Name:");
		lblItemName.setBounds(18, 57, 80, 22);
		panel.add(lblItemName);
		
		JLabel lblItemId = new JLabel("Item ID:");
		lblItemId.setBounds(18, 91, 80, 22);
		panel.add(lblItemId);
		
		JLabel lblNumerOfItem = new JLabel("Numer of Item:");
		lblNumerOfItem.setBounds(18, 125, 103, 22);
		panel.add(lblNumerOfItem);
		
		JLabel lblPrice = new JLabel("Price:");
		lblPrice.setBounds(18, 159, 44, 22);
		panel.add(lblPrice);
		
		itemName = new JTextField();
		itemName.setBounds(120, 55, 130, 26);
		panel.add(itemName);
		itemName.setColumns(10);
		
		itemId = new JTextField();
		itemId.setBounds(120, 89, 130, 26);
		panel.add(itemId);
		itemId.setColumns(10);
		
		numItem = new JTextField();
		numItem.setBounds(120, 123, 130, 26);
		panel.add(numItem);
		numItem.setColumns(10);
		
		price = new JTextField();
		price.setBounds(120, 159, 130, 26);
		panel.add(price);
		price.setColumns(10);

        // populating table with existing values
        // handle exceptions
        try{
            // read from file into list of items
            addItem.readFile(iPath, tableItems);
            // populate table columns, item by item
            for(int i = 0; i < tableItems.size(); i++){
                // temp declarations
                String tempName, tempQuantity, tempPrice, tempId;
                Item tempItem;

                // get arraylist value at i
                tempItem = tableItems.get(i);

                // get and store invidual item parameters as strings
                tempName = tempItem.getName();
                tempQuantity = String.valueOf(tempItem.getStock());
                tempPrice = String.valueOf(tempItem.getPrice());
                tempId = String.valueOf(tempItem.getId());

                // adding values to table row
                row[0] = tempName;
                row[1] = tempId;
                row[2] = tempQuantity;
                row[3] = tempPrice;

                // adding row to table
                model.addRow(row);
            }
        } catch(IOException ex) {
            // System.out.println("Ran into an error while reading/writing");
            JOptionPane.showMessageDialog(null, ex+"");
        }
		

        // ADD TO CART BUTTON
		JButton btnNewButton = new JButton("Add to Cart");

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                // declarations
                ArrayList<Item> inventoryItems = new ArrayList<Item>();
                ArrayList<Item> cartItems = new ArrayList<Item>();
                String nameText, priceString, quantityString, idString, desiredNameText;
                double priceText;
                int quantityText, idText; 
                int index = 0;

                // check that fields are filled out
				if(itemName.getText().equals("") || itemId.getText().equals("") || numItem.getText().equals("") || price.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Please fill in the information");
				}
				else {
                    // getting text from input fields and converting to 
                    // data types to be fed into Item() constructor
                    nameText = itemName.getText();
                    priceString = price.getText();
                    quantityString = numItem.getText();
                    idString = itemId.getText();

                    priceText = Double.parseDouble(priceString);
                    quantityText = Integer.parseInt(quantityString);
                    idText = Integer.parseInt(idString);

                    // handle exceptions
                    try{
                        // read from inventory file into list of inventory items
                        addItem.readFile(iPath, inventoryItems);
                        // read from cart file into list of cart items
                        addItem.readFile(cPath, cartItems);
                        // find location of desired item in inventoryItems list
                        // getting name of desired item from input field 
                        desiredNameText = itemName.getText();
                        // find first item with desired name to remove
                        for(int i = 0; i < inventoryItems.size(); i++){
                            // check if name matches item name
                            String itemName = inventoryItems.get(i).getName();
                            if(nameText.equals(itemName)){
                                index = i;
                                break;
                            }
                        }
                        // copy desired item from inventory into cart
                        cartItems.add(inventoryItems.get(index));
                        // write updated cart items list to file
                        addItem.writeFile(cPath, cartItems);
                    } catch(IOException ex) {
                        // System.out.println("Ran into an error while reading/writing");
                        JOptionPane.showMessageDialog(null, ex+"");
                    }
                    // resetting input text fields to empty
                    itemName.setText("");
                    itemId.setText("");
                    numItem.setText("");
                    price.setText("");
                    JOptionPane.showMessageDialog(null, "Saved!");
				}
			}
		});
		btnNewButton.setBounds(18, 211, 117, 29);
		panel.add(btnNewButton);
		

        // REMOVE BUTTON -- WILL BE DELETED FROM ITEMSFORSALE, thus not
        // allowing the user to remove items from their cart
		// JButton btnNewButton_1 = new JButton("Remove");

		// btnNewButton_1.addActionListener(new ActionListener() {
		// 	public void actionPerformed(ActionEvent e) {
        //         // declarations
        //         ArrayList<Item> items = new ArrayList<Item>();
        //         String nameText;
        //         int index = 0;

        //         // handle exceptions
        //         try{
        //             // read from file into list of items
        //             addItem.readFile(iPath, items);

        //             // getting text from input fields and converting to 
        //             // data types to be checked against items in inventory
        //             nameText = itemName.getText();

        //             // find first item with desired name to remove
        //             for(int i = 0; i < items.size(); i++){
        //                 // check if name matches item name
        //                 String itemName = items.get(i).getName();
        //                 if(nameText.equals(itemName)){
        //                     System.out.println(itemName);
        //                     index = i;
        //                     break;
        //                 }
        //             }

        //             // write updated items list to txt file
        //             // remove first item that matches from above
        //             items.remove(index);
        //             // clear file
        //             String emp = " ";
        //             ArrayList<String> empty = new ArrayList<String>();
        //             empty.add(emp);
        //             File file = new File(iPath);
        //             PrintWriter pw = new PrintWriter(file);
        //             pw.print(emp);
        //             pw.close();
        //             // write updated items list to file
        //             addItem.writeFile(iPath, items);
        //         } catch(IOException ex) {
        //             // System.out.println("Ran into an error while reading/writing");
        //             JOptionPane.showMessageDialog(null, ex+"");
        //         }

        //         // refresh page
        //         ItemsForSale refresh =  new ItemsForSale();
        //         frame.dispose();
                

        //         // reset text boxes to empty
        //         itemName.setText("");
        //         itemId.setText("");
        //         numItem.setText("");
        //         price.setText("");
		// 	}
		// });
		// btnNewButton_1.setBounds(133, 211, 117, 29);
		// panel.add(btnNewButton_1);


        // BACK BUTTON
        JButton back = new JButton("Back");
		
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// go back to customer homepage
				Customer bck = new Customer();
				frame.dispose();
			}
		});
		back.setBounds(18, 241, 117, 29);
		panel.add(back);
	}

	@Override
	public void actionPerformed(ActionEvent e) {		
	}
}