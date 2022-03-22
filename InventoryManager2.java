/*
 *
 * Inventory manager on merchant side
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


public class InventoryManager2 implements ActionListener{

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
    String fPath = "gui/data/inventory.txt";
	
	

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ItemCart window = new ItemCart();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public InventoryManager2() {
		
		
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
            addItem.readFile(fPath, tableItems);
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
		

        // ADD BUTTON
		JButton btnNewButton = new JButton("Add");

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                // declarations
                ArrayList<Item> items = new ArrayList<Item>();
                String nameText, priceString, quantityString, idString;
                double priceText;
                int quantityText, idText;

                // check that fields are filled out
				if(itemName.getText().equals("") || itemId.getText().equals("") || numItem.getText().equals("") || price.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Please fill in the information");
				}
				else {

                    // booleans denoting if certain item fields are the same
                    // boolean all = false;
                    // boolean one = false;
                    // boolean two = false;
                    // boolean three = false;
                    
                    // int num1 = 1;
                    // int num2 = 1;
                    // int num3 = 1;

                    // getting text from input fields and converting to 
                    // data types to be fed into Item() constructor
                    nameText = itemName.getText();
                    priceString = price.getText();
                    quantityString = numItem.getText();
                    idString = itemId.getText();

                    priceText = Double.parseDouble(priceString);
                    quantityText = Integer.parseInt(quantityString);
                    idText = Integer.parseInt(idString);

                    // creating new Item object
                    Item newItem = new Item(nameText, priceText, quantityText, idText);

                    // handle exceptions
                    try{
                        // read from file into list of items
                        addItem.readFile(fPath, items);
                        // add new item to list of items
                        items.add(newItem);
                        // write updated items list to file
                        addItem.writeFile(fPath, items);
                    } catch(IOException ex) {
                        // System.out.println("Ran into an error while reading/writing");
                        JOptionPane.showMessageDialog(null, ex+"");
                    }
				
                    // adding values to table row
                    row[0] = nameText;
                    row[1] = idString;
                    row[2] = quantityString;
                    row[3] = priceString;

                    // adding values to columns
                    itemNames.add(nameText);
                    itemIds.add(itemId.getText());
                    itemNums.add(numItem.getText());
                    itemPrices.add(price.getText());

                    // add row to table
                    model.addRow(row);

                    // if (one && two && three && num1 == num2 && num2 == num3) {
                    //     all = true;
                    // }
                    // if (all) {
                    //     int temp = Integer.parseInt(itemNums.get(num1));
                    //     int temp2 = Integer.parseInt(numItem.getText());
                    //     itemNums.set(num1, String.valueOf(temp + temp2));
                        
                    //     model.setValueAt(itemNums.get(num1), num1, 2);
                    // }
                    // else {
                    //     row[0] = itemName.getText();
                    //     row[1] = itemId.getText();
                    //     row[2] = numItem.getText();
                    //     row[3] = price.getText();
                        
                    //     itemNames.add(itemName.getText());
                    //     itemIds.add(itemId.getText());
                    //     itemNums.add(numItem.getText());
                    //     itemPrices.add(price.getText());	
                        
                    //     model.addRow(row);
                    // }
                    
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
		

        // REMOVE BUTTON -- UNDER CONSTRUCTION
		JButton btnNewButton_1 = new JButton("Remove");

		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                // declarations
                ArrayList<Item> items = new ArrayList<Item>();
                String nameText;
                int index = 0;

                // // check that all fields are filled out
				// if(itemName.getText().equals("") || itemId.getText().equals("") || numItem.getText().equals("") || price.getText().equals("")) {
				// 	JOptionPane.showMessageDialog(null, "Please fill in the information");
				// }
				// else {
                    // handle exceptions
                    try{
                        // read from file into list of items
                        addItem.readFile(fPath, items);

                        // getting text from input fields and converting to 
                        // data types to be checked against items in inventory
                        nameText = itemName.getText();

                        // find first item with desired name to remove
                        for(int i = 0; i < items.size(); i++){
                            // check if name matches item name
                            String itemName = items.get(i).getName();
                            if(nameText.equals(itemName)){
                                System.out.println(itemName);
                                index = i;
                                break;
                            }
                        }

                        // write updated items list to txt file
                        // remove first item that matches from above
                        items.remove(index);
                        // clear file
                        String emp = " ";
                        ArrayList<String> empty = new ArrayList<String>();
                        empty.add(emp);
                        File file = new File(fPath);
                        PrintWriter pw = new PrintWriter(file);
                        pw.print(emp);
                        pw.close();
                        // write updated items list to file
                        addItem.writeFile(fPath, items);
                    } catch(IOException ex) {
                        // System.out.println("Ran into an error while reading/writing");
                        JOptionPane.showMessageDialog(null, ex+"");
                    }

                    // refresh page
                    InventoryManager2 refresh =  new InventoryManager2();
                    frame.dispose();

                    // updating the table
                    // handle exceptions
                    // try{
                    //     // read from file into list of items
                    //     addItem.readFile(fPath, items);
                    //     // populate table columns, item by item
                    //     for(int i = 0; i < items.size(); i++){
                    //         // temp declarations
                    //         String tempName, tempQuantity, tempPrice, tempId;
                    //         Item tempItem;

                    //         // get arraylist value at i
                    //         tempItem = items.get(i);

                    //         // get and store invidual item parameters as strings
                    //         tempName = tempItem.getName();
                    //         tempQuantity = String.valueOf(tempItem.getStock());
                    //         tempPrice = String.valueOf(tempItem.getPrice());
                    //         tempId = String.valueOf(tempItem.getId());

                    //         // adding values to table row
                    //         row[0] = tempName;
                    //         row[1] = tempId;
                    //         row[2] = tempQuantity;
                    //         row[3] = tempPrice;

                    //         // adding row to table
                    //         model.addRow(row);
                    //     }
                    // } catch(IOException ex) {
                    //     // System.out.println("Ran into an error while reading/writing");
                    //     JOptionPane.showMessageDialog(null, ex+"");
                    // }

                    // ------------------------------

                    // boolean all = false;
                    // boolean one = false;
                    // boolean two = false;
                    // boolean three = false;
                    
                    // int num1 = 1;
                    // int num2 = 1;
                    // int num3 = 1;
                    
                    // for (int i = 0; i < itemNames.size(); i++) {
                    //     String temp =  itemName.getText();
                    //     String temp2 = itemNames.get(i);
                    //     if (temp.equals(temp2)) {
                    //         one = true;
                    //         num1 = i;
                    //     }
                    // }
                    // for (int i = 0; i < itemIds.size(); i++) {
                    //     String temp =  itemId.getText();
                    //     String temp2 = itemIds.get(i);
                    //     if (temp.equals(temp2)) {
                    //         two = true;
                    //         num2 = i;
                    //     }

                    // }for (int i = 0; i < itemPrices.size(); i++) {
                    //     String temp =  price.getText();
                    //     String temp2 = itemPrices.get(i);
                    //     if (temp.equals(temp2)) {
                    //         three = true;
                    //         num3 = i;
                    //     }
                    // }
                    
                    // if (one && two && three && num1 == num2 && num2 == num3) {
                    //     all = true;
                    // }
                    // if (all) {
                    //     int temp = Integer.parseInt(itemNums.get(num1));
                    //     int temp2 = Integer.parseInt(numItem.getText());
                    //     if(temp - temp2 >= 0) {
                    //         itemNums.set(num1, String.valueOf(temp - temp2));
                    //         model.setValueAt(itemNums.get(num1), num1, 2);
                    //         JOptionPane.showMessageDialog(null, "Saved!");
                    //     }
                    //     else {
                    //         JOptionPane.showMessageDialog(null, "You do not have enough to remove that much");

                    //     }
                        
                        
                    // }
                    // else {
                    //     JOptionPane.showMessageDialog(null, "Please input the correct information");

                    // }
                    
                    
                    itemName.setText("");
                    itemId.setText("");
                    numItem.setText("");
                    price.setText("");
                    
                // }
			}
		});
		btnNewButton_1.setBounds(133, 211, 117, 29);
		panel.add(btnNewButton_1);


        // BACK BUTTON
        JButton back = new JButton("Back");
		
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				StoreOwner bck = new StoreOwner();
				frame.dispose();
			}
		
		});
		back.setBounds(18, 241, 117, 29);
		panel.add(back);
	}

    

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}


}