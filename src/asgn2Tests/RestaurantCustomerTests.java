package asgn2Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import asgn2Exceptions.CustomerException;
import asgn2Exceptions.LogHandlerException;
import asgn2Exceptions.PizzaException;
import asgn2Restaurant.PizzaRestaurant;

/**
 * A class that that tests the methods relating to the handling of Customer objects in the asgn2Restaurant.PizzaRestaurant
 * class as well as processLog and resetDetails.
 * 
 * @author Person A
 */
public class RestaurantCustomerTests {
	
	
	@Test
	public void processTest() throws CustomerException, PizzaException, LogHandlerException{
		PizzaRestaurant testRestaurant= new PizzaRestaurant();
		assertEquals(true,testRestaurant.processLog("20170101.txt"));
			
		}
	
	@Test 
	public void CustomerIndexTest() throws PizzaException, CustomerException, LogHandlerException{
		PizzaRestaurant testRestaurant= new PizzaRestaurant();
		testRestaurant.processLog("20170101.txt");
		assertEquals(10, testRestaurant.getCustomerByIndex(0).getDeliveryDistance(),0.1);
	}
	
	@Test 
	public void CustomerSizeTest() throws PizzaException, CustomerException, LogHandlerException{
		PizzaRestaurant testRestaurant= new PizzaRestaurant();
		testRestaurant.processLog("20170101.txt");
		assertEquals(3, testRestaurant.getNumCustomerOrders());
	}	
		
	

	@Test
public void totalDistance() throws CustomerException, PizzaException, LogHandlerException{
	PizzaRestaurant testRestaurant= new PizzaRestaurant();
	assertEquals(true,testRestaurant.processLog("20170101.txt"));
	
	assertEquals(15,testRestaurant.getTotalDeliveryDistance(),0.01);
		
	}
	




}