package asgn2Tests;


import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import asgn2Customers.Customer;
import asgn2Exceptions.CustomerException;
import asgn2Exceptions.LogHandlerException;
import asgn2Restaurant.LogHandler;

/**
 * A class that tests the methods relating to the creation of Customer objects in the asgn2Restaurant.LogHander class.
 *
 * @author Person A
 */


public class LogHandlerCustomerTests {
	@Test
	public void Testcreate() throws CustomerException, LogHandlerException {
		String input="9:00:00,19:20:00,Casey Jones,0123456789,DVC,5,5,PZV,2";
		Customer TestCustomer= LogHandler.createCustomer(input);
		
		assertEquals("Driver Delivery",TestCustomer.getCustomerType());
		assertEquals(10,TestCustomer.getDeliveryDistance(),0.1);				
	}	
	
	
	@Test(expected=LogHandlerException.class)
	public void TestLogException() throws CustomerException, LogHandlerException {
		String input="9:00:00,Casey Jones,0123456789,DVC,5,5,PZV,2";
		Customer TestCustomer= LogHandler.createCustomer(input);
		
		assertEquals("Driver Delivery",TestCustomer.getCustomerType());
		assertEquals(10,TestCustomer.getDeliveryDistance(),0.1);		
	}
	
	@Test(expected=LogHandlerException.class)
	public void TestEmptyLog() throws CustomerException, LogHandlerException {
		ArrayList<Customer> customerList= LogHandler.populateCustomerDataset("empty.txt");;	
		
	}
	
	
	
	@Test
	public void testCustomerPopulate() throws CustomerException, LogHandlerException{
		
		ArrayList<Customer> customerList= LogHandler.populateCustomerDataset("20170101.txt");
		
		assertEquals("Driver Delivery",customerList.get(0).getCustomerType());
		assertEquals("Drone Delivery",customerList.get(1).getCustomerType());
		assertEquals("Pick Up",customerList.get(2).getCustomerType());
		
		
		
	}
	
	
	
	
	
	
	
	
}

