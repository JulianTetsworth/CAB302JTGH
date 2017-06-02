package asgn2GUIs;

import java.awt.event.ActionEvent;


import java.awt.event.ActionListener;
import java.io.File;
import java.text.DecimalFormat;

import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.DefaultCaret;

import asgn2Customers.Customer;
import asgn2Exceptions.CustomerException;
import asgn2Customers.Customer;
import asgn2Pizzas.Pizza;
import asgn2Restaurant.PizzaRestaurant;

import javax.swing.JFrame;

//import java.awt.*;
import javax.swing.*;


/**
 * This class is the graphical user interface for the rest of the system. 
 * Currently it is a ‘dummy’ class which extends JFrame and implements Runnable and ActionLister. 
 * It should contain an instance of an asgn2Restaurant.PizzaRestaurant object which you can use to 
 * interact with the rest of the system. You may choose to implement this class as you like, including changing 
 * its class signature – as long as it  maintains its core responsibility of acting as a GUI for the rest of the system. 
 * You can also use this class and asgn2Wizards.PizzaWizard to test your system as a whole
 * 
 * 
 * @author Person A and Person B
 *
 */
public class PizzaGUI extends javax.swing.JFrame implements Runnable, ActionListener {
	
	
	PizzaRestaurant restaurant = new PizzaRestaurant();
	private boolean fileIsLoaded;
	
	/**
	 * Creates a new Pizza GUI with the specified title 
	 * @param title - The title for the supertype JFrame
	 */
	public PizzaGUI(String title) {
		JFrame f=new JFrame(); 
		f.setSize(1200,900);
		f.setLayout(null);
		f.setVisible(true);
		
		JButton displayInfo=new JButton("displayInfo");
		displayInfo.setBounds(400,700,100, 40); 
		displayInfo.setEnabled(false);
		f.add(displayInfo);
		
		JButton loadFile=new JButton("Load File");
		loadFile.setBounds(200,700,100, 40);          
		f.add(loadFile);
		
		JLabel customerLabel = new JLabel("Customer Data");
		customerLabel.setBounds(50, 30, 500, 40);
		f.add(customerLabel);
		customerLabel.setVisible(false);
		
		JTextArea CustomerDetails=new JTextArea(); 
		CustomerDetails.setBounds(50, 70, 500, 400);
		f.add(CustomerDetails);
		CustomerDetails.setVisible(false);
		
		
		JLabel pizzaLabel = new JLabel("Pizza Data");
		pizzaLabel.setBounds(650, 30, 500, 40);
		f.add(pizzaLabel);
		pizzaLabel.setVisible(false);
		
		JTextArea PizzaDetails=new JTextArea(); 
		PizzaDetails.setBounds(650, 70, 500, 400);
		f.add(PizzaDetails);
		PizzaDetails.setVisible(false);
		
		loadFile.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
						
				JFileChooser chooser = new JFileChooser();
			    int returnVal = chooser.showOpenDialog(getParent());
			    if(returnVal == JFileChooser.APPROVE_OPTION) {
			       System.out.println("You chose to open this file: " +
			            chooser.getSelectedFile().getName());
			       try {
			       		restaurant.processLog(chooser.getSelectedFile().getName());
			       		displayInfo.setEnabled(true);
			       		
			       } catch (Exception LogFileException){
			    	   System.err.println("Error " + LogFileException.getMessage());
			    	   fileIsLoaded = false;
			       }
			    }
						
					}
				}	
				
							
			);     
		
		
		displayInfo.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				CustomerDetails.setVisible(true);
				PizzaDetails.setVisible(true);
				pizzaLabel.setVisible(true);
				customerLabel.setVisible(true);
				String Customermessage="Customer Name            Mobile          Type                X           Y         Distance \n";
				String Pizzamessage="Type        Quantity      Order Price       Order Cost       Order Profit \n";
				
				for(int i=0;i<restaurant.getNumCustomerOrders();i++){
					
					try{
						Pizza pizzas=restaurant.getPizzaByIndex(i);
						Customer customers= restaurant.getCustomerByIndex(i);
					Pizzamessage+=pizzas.getPizzaType()+"           " +pizzas.getQuantity()+ "         "+pizzas.getOrderPrice() +"                    "+ pizzas.getOrderCost()+ "             " +pizzas.getOrderProfit()+"\n";
					Customermessage+=customers.getName()+"       "+customers.getMobileNumber()+"       "+customers.getCustomerType()+"     " + customers.getLocationX()+ "      "+ customers.getLocationY()+ "      " +customers.getDeliveryDistance()+" \n";
					}		
					catch (Exception CustomerException){					
						
				}		
					
					
					
				}
				PizzaDetails.setText(Pizzamessage);
				CustomerDetails.setText(Customermessage);
					
	
			} } );
		
		
		
		
		
		
	}
	 public void actionPerformed(ActionEvent e) {
		 
 }

	// private void displayInformatio  
	
	@Override
	public void run() {
		// TO DO
	}

	

}
