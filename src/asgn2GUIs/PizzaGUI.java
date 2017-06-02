package asgn2GUIs;

import java.awt.event.ActionEvent;


import java.awt.event.ActionListener;
import java.io.File;
import java.text.DecimalFormat;

import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.DefaultCaret;

//import asgn2Customers.Customer;
//import asgn2Pizzas.Pizza;
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
		f.setSize(400,500);
		f.setLayout(null);
		f.setVisible(true);
		
		JButton loadFile=new JButton("Load File");
		loadFile.setBounds(130,100,100, 40);          
		f.add(loadFile);
		loadFile.addActionListener(this);     
		
		JButton displayInfo=new JButton("displayInfo");
		loadFile.setBounds(130,100,100, 40);          
		f.add(loadFile);
		loadFile.addActionListener(this); 

	}
	
	 public void actionPerformed(ActionEvent e) {
		 JFileChooser chooser = new JFileChooser();
		    int returnVal = chooser.showOpenDialog(getParent());
		    if(returnVal == JFileChooser.APPROVE_OPTION) {
		       System.out.println("You chose to open this file: " +
		            chooser.getSelectedFile().getName());
		       try {
		       		restaurant.processLog(chooser.getSelectedFile().getName());
		       		fileIsLoaded = true; 
		       		
		       } catch (Exception LogFileException){
		    	   System.err.println("Error " + LogFileException.getMessage());
		    	   fileIsLoaded = false;
		       }
		    }
 }

	// private void displayInformatio  
	
	@Override
	public void run() {
		// TO DO
	}

	

}
