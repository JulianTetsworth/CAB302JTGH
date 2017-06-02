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
public void totalDistance() throws CustomerException, PizzaException, LogHandlerException{
	PizzaRestaurant testRestaurant= new PizzaRestaurant();
	assertEquals(true,testRestaurant.processLog("20170101.txt"));
	
	System.out.println(testRestaurant.getTotalDeliveryDistance());
		
	}
	




}