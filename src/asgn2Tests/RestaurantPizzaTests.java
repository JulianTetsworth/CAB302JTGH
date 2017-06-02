package asgn2Tests;

import static org.junit.Assert.*;

import java.io.File;
import java.time.LocalTime;

import org.junit.Test;

import asgn2Exceptions.CustomerException;
import asgn2Exceptions.LogHandlerException;
import asgn2Exceptions.PizzaException;
import asgn2Pizzas.Pizza;
import asgn2Pizzas.PizzaFactory;
import asgn2Restaurant.PizzaRestaurant;

/**
 * A class that tests the methods relating to the handling of Pizza objects in the asgn2Restaurant.PizzaRestaurant class as well as
 * processLog and resetDetails.
 * 
 * @author Person B
 *
 */
public class RestaurantPizzaTests {
	
	PizzaRestaurant restaurant = new PizzaRestaurant();
	String fileName = ("20170101.txt");
	private LocalTime deliveryTime = LocalTime.of(20, 25);
	private LocalTime orderTime = LocalTime.of(20, 0);
	
	@Test 
	public void DeconstructorTest() throws PizzaException{ 
		restaurant.resetDetails();
		assertEquals(null, restaurant);
	}
	
	@Test 
	public void PizzaIndexQuantityTest() throws PizzaException, CustomerException, LogHandlerException{ 
		restaurant.processLog(fileName);
		assertEquals(2, restaurant.getPizzaByIndex(0).getQuantity());
	}
	@Test 
	public void PizzaIndexTypeTest() throws PizzaException, CustomerException, LogHandlerException{ 
		restaurant.processLog(fileName);
		assertEquals("Vegetarian", restaurant.getPizzaByIndex(0).getPizzaType());
	}
	@Test 
	public void PizzaIndexProfitTest() throws PizzaException, CustomerException, LogHandlerException{ 
		restaurant.processLog(fileName);
		assertEquals(9, restaurant.getPizzaByIndex(0).getOrderProfit(), 0.01);
	}
	
	@Test 
	public void NumPizzaOrdersTest() throws PizzaException, CustomerException, LogHandlerException{ 
		restaurant.processLog(fileName);
		assertEquals(3, restaurant.getNumPizzaOrders());
	}
	
	@Test 
	public void TotalProfitTest() throws PizzaException, CustomerException, LogHandlerException{ 
		restaurant.processLog(fileName);
		assertEquals(36.5, restaurant.getTotalProfit(), 0.01);
	}
	
	@Test 
	public void MatchingPizzaAtIndexTest() throws PizzaException, CustomerException, LogHandlerException{ 
		restaurant.processLog(fileName);
		Pizza matchingPizza = PizzaFactory.getPizza("PZM", 1, orderTime, deliveryTime);
		assertEquals(matchingPizza, restaurant.getPizzaByIndex(1));
	}
}
