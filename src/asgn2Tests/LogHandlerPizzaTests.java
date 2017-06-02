package asgn2Tests;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.time.LocalTime;
import java.util.ArrayList;

import org.junit.Test;

import asgn2Exceptions.LogHandlerException;
import asgn2Exceptions.PizzaException;
import asgn2Pizzas.MargheritaPizza;
import asgn2Pizzas.Pizza;
import asgn2Pizzas.PizzaFactory;
import asgn2Restaurant.LogHandler;

/** A class that tests the methods relating to the creation of Pizza objects in the asgn2Restaurant.LogHander class.
* 
* @author Person B
* 
*/
public class LogHandlerPizzaTests {
	
	 private String file = ("20:00:00,20:25:00,April O'Neal,0987654321,DNC,3,4,PZM,1");
	 private String exceedingQuantityFile = ("20:00:00,20:25:00,April O'Neal,0987654321,DNC,3,4,PZM,20");
	 private String belowZeroQuantityFile = ("20:00:00,20:25:00,April O'Neal,0987654321,DNC,3,4,PZM,-1");
	 private String beforeOpeningfile = ("12:00:00,20:25:00,April O'Neal,0987654321,DNC,3,4,PZM,1");
	 private String afterClosingfile = ("23:50:00,20:25:00,April O'Neal,0987654321,DNC,3,4,PZM,1");
	 private String invalidFile = ("1, 2, 3");
	 private LocalTime deliveryTime = LocalTime.of(20, 25);
	 private LocalTime orderTime = LocalTime.of(20, 0);
	 String fileName = ("20170101.txt");
	
	@Test 
	public void MatchingPizzaTest() throws PizzaException, LogHandlerException{
		Pizza newPizza = LogHandler.createPizza(file);
		Pizza matchingPizza = PizzaFactory.getPizza("PZM", 1, orderTime, deliveryTime);
		assertEquals(matchingPizza, newPizza);
	}
	
	@Test 
	public void LogReaderTypeTest() throws PizzaException, LogHandlerException{
		Pizza newPizza = LogHandler.createPizza(file);
		assertEquals("Margherita", newPizza.getPizzaType());
	}
	
	@Test 
	public void LogReaderQuantityTest() throws PizzaException, LogHandlerException{
		Pizza newPizza = LogHandler.createPizza(file);
		assertEquals(1, newPizza.getQuantity());
	}
	
	@Test (expected = LogHandlerException.class)
	public void InvalidStringSizeTest() throws PizzaException, LogHandlerException{
		LogHandler.createPizza(invalidFile);
	}
	
	@Test (expected = PizzaException.class)
	public void QuantityExceededTest() throws PizzaException, LogHandlerException{
		LogHandler.createPizza(exceedingQuantityFile);
	}
	
	@Test (expected = PizzaException.class)
	public void QuantityBelowZeroTest() throws PizzaException, LogHandlerException{
		LogHandler.createPizza(belowZeroQuantityFile);
	}
	
	@Test (expected = PizzaException.class)
	public void AfterClosingTest() throws PizzaException, LogHandlerException{
		LogHandler.createPizza(afterClosingfile);
	}
	
	@Test (expected = PizzaException.class)
	public void BeforeOpeningTest() throws PizzaException, LogHandlerException{
		LogHandler.createPizza(beforeOpeningfile);
	}
	
	@Test 
	public void PopulateDatasetTest() throws PizzaException, LogHandlerException{
		ArrayList<Pizza> testPizzaList= new ArrayList<Pizza>();
		testPizzaList = LogHandler.populatePizzaDataset(fileName);
		assertEquals(3, testPizzaList.size());
	}
	
	@Test 
	public void PopulateMatchingPizzaTest() throws PizzaException, LogHandlerException{
		ArrayList<Pizza> testPizzaList= new ArrayList<Pizza>();
		testPizzaList = LogHandler.populatePizzaDataset(fileName);
		Pizza newPizza = LogHandler.createPizza(file);
		assertEquals(newPizza, testPizzaList.get(1));
	}
}
