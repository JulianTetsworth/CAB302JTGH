package asgn2Restaurant;


import java.io.File;
import java.lang.reflect.Array;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import asgn2Customers.Customer;
import asgn2Customers.CustomerFactory;
import asgn2Exceptions.CustomerException;
import asgn2Exceptions.LogHandlerException;
import asgn2Exceptions.PizzaException;
import asgn2Pizzas.Pizza;
import asgn2Pizzas.PizzaFactory;

/**
 *
 * A class that contains methods that use the information in the log file to return Pizza 
 * and Customer object - either as an individual Pizza/Customer object or as an
 * ArrayList of Pizza/Customer objects.
 * 
 * @author Person A and Person B
 *
 */
public class LogHandler {
	

	/**
	 * Returns an ArrayList of Customer objects from the information contained in the log file ordered as they appear in the log file.
	 * @param filename The file name of the log file
	 * @return an ArrayList of Customer objects from the information contained in the log file ordered as they appear in the log file. 
	 * @throws CustomerException If the log file contains semantic errors leading that violate the customer constraints listed in Section 5.3 of the Assignment Specification or contain an invalid customer code (passed by another class).
	 * @throws LogHandlerException If there was a problem with the log file not related to the semantic errors above
	 * 
	 */
	public static ArrayList<Customer> populateCustomerDataset(String filename) throws CustomerException, LogHandlerException{
		ArrayList<Customer> customerList=null;
	
		try{
			
			Scanner input = new Scanner(new File(filename));
			
			if(!input.hasNextLine()){ 
				throw new LogHandlerException("Log file empty"); }
			else{
			while(input.hasNextLine()){
				String line= input.nextLine();
				try{
				customerList.add(createCustomer(line));
				} catch (Exception CustomerException){
					System.err.println(CustomerException.getMessage());}
				}			
			
			input.close();}
				} catch (Exception LogHandlerException){
					  System.err.println("Error: " + LogHandlerException.getMessage());
				}
			
		return customerList;
	}

	/**
	 * Returns an ArrayList of Pizza objects from the information contained in the log file ordered as they appear in the log file. .
	 * @param filename The file name of the log file
	 * @return an ArrayList of Pizza objects from the information contained in the log file ordered as they appear in the log file. .
	 * @throws PizzaException If the log file contains semantic errors leading that violate the pizza constraints listed in Section 5.3 of the Assignment Specification or contain an invalid pizza code (passed by another class).
	 * @throws LogHandlerException If there was a problem with the log file not related to the semantic errors above
	 * 
	 */
	public static ArrayList<Pizza> populatePizzaDataset(String filename) throws PizzaException, LogHandlerException{
		ArrayList<Pizza> PizzaList= new ArrayList<Pizza>();
		
		
		try{
			Scanner input = new Scanner(new File(".//logs/" + filename));
			
			if(!input.hasNextLine()){
				input.close();
				throw new LogHandlerException();
			}
			
			else{
				while(input.hasNextLine()){
				String textData = input.nextLine();
				try{
					PizzaList.add(createPizza(textData));
					} catch (Exception PizzaException){
						input.close();
						throw new PizzaException();
					}
				}	
				input.close();
			}

		}
		catch (Exception LogHandlerException){
			System.err.println("Error " + LogHandlerException.getMessage());
		}
		return PizzaList;
	}		

	
	/**
	 * Creates a Customer object by parsing the  information contained in a single line of the log file. The format of 
	 * each line is outlined in Section 5.3 of the Assignment Specification.  
	 * @param line - A line from the log file
	 * @return- A Customer object containing the information from the line in the log file
	 * @throws CustomerException - If the log file contains semantic errors leading that violate the customer constraints listed in Section 5.3 of the Assignment Specification or contain an invalid customer code (passed by another class).
	 * @throws LogHandlerException - If there was a problem parsing the line from the log file.
	 */
	public static Customer createCustomer(String line) throws CustomerException, LogHandlerException{
		Customer newCustomer=null;
		CustomerFactory factory= new CustomerFactory();
		
		
		String strArray[]=line.split(",");
		
		if(Array.getLength(strArray)!=8){throw new LogHandlerException("");}
		try{
		newCustomer=factory.getCustomer(strArray[4],strArray[2],strArray[3],Integer.parseInt(strArray[4]),Integer.parseInt(strArray[5]));
		}catch(Exception CustomerException){
			throw new CustomerException();
		}
		return newCustomer;
	
		
		
		
	}
	
	
	/**
	 * Creates a Pizza object by parsing the information contained in a single line of the log file. The format of 
	 * each line is outlined in Section 5.3 of the Assignment Specification.  
	 * @param line - A line from the log file
	 * @return- A Pizza object containing the information from the line in the log file
	 * @throws PizzaException If the log file contains semantic errors leading that violate the pizza constraints listed in Section 5.3 of the Assignment Specification or contain an invalid pizza code (passed by another class).
	 * @throws LogHandlerException - If there was a problem parsing the line from the log file.
	 */
	public static Pizza createPizza(String line) throws PizzaException, LogHandlerException{
		LocalTime openingTime = LocalTime.of(19, 0);
		LocalTime closingTime = LocalTime.of(23, 0); 
		String PizzaStrArray[]=line.split(",");	
		
		if (PizzaStrArray.length != 9){
			throw new LogHandlerException();
		}
		
		int quantity = Integer.parseInt(PizzaStrArray[8]);
		String pizzaCode = PizzaStrArray[7];
		LocalTime orderTime = LocalTime.parse(PizzaStrArray[0]);
		LocalTime deliveryTime = LocalTime.parse(PizzaStrArray[1]);
		
		if (quantity > 10 | quantity < 1 | orderTime.isAfter(closingTime) | orderTime.isBefore(openingTime)){
			throw new PizzaException();
		}
		
		
		return  PizzaFactory.getPizza(pizzaCode, quantity, orderTime , deliveryTime);
	}
}
