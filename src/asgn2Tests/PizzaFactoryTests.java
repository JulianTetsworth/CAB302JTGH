package asgn2Tests;

import static org.junit.Assert.assertEquals;

import java.time.LocalTime;

import org.junit.Test;

import asgn2Exceptions.PizzaException;
import asgn2Pizzas.MargheritaPizza;
import asgn2Pizzas.Pizza;
import asgn2Pizzas.PizzaFactory;
import asgn2Pizzas.PizzaTopping;

/** 
 * A class that tests the asgn2Pizzas.PizzaFactory class.
 * 
 * @author Person B 
 * 
 * +
 */
public class PizzaFactoryTests {
	
	private LocalTime orderTime = LocalTime.of(20, 0);
	private LocalTime deliveryTime = LocalTime.of(21, 0);
	private LocalTime beforeOpening = LocalTime.of(6, 0);
	private LocalTime afterClosing = LocalTime.of(23, 50);
	
	@Test 
	public void GetPizzaTypeLTest() throws PizzaException{
		Pizza newPizza = PizzaFactory.getPizza("PZL", 1, orderTime, deliveryTime);
		assertEquals("MeatLovers", newPizza.getPizzaType());
	}
	
	@Test 
	public void GetPizzaTypeMTest() throws PizzaException{
		Pizza newPizza = PizzaFactory.getPizza("PZM", 1, orderTime, deliveryTime);
		assertEquals("Margherita", newPizza.getPizzaType());
	}
	
	@Test 
	public void GetPizzaTypeVTest() throws PizzaException{
		Pizza newPizza = PizzaFactory.getPizza("PZV", 1, orderTime, deliveryTime);
		assertEquals("Vegetarian", newPizza.getPizzaType());
	}
	
	@Test (expected = PizzaException.class)
	public void NoCodeTest() throws PizzaException{
		Pizza newPizza = PizzaFactory.getPizza(" ", 1, beforeOpening, deliveryTime);
	}
	
	@Test (expected = PizzaException.class)
	public void InvalidCodeTest() throws PizzaException{
		Pizza newPizza = PizzaFactory.getPizza("PZ#$%^", 1, beforeOpening, deliveryTime);
	}
	
	@Test (expected = PizzaException.class)
	public void InvalidPizzaCodeTest() throws PizzaException{
		Pizza newPizza = PizzaFactory.getPizza("PZP", 1, beforeOpening, deliveryTime);
	}
	
	@Test (expected = PizzaException.class)
	public void BeforeOpeningTest() throws PizzaException{
		Pizza newPizza = PizzaFactory.getPizza("PZM", 1, beforeOpening, deliveryTime);
	}
	
	@Test (expected = PizzaException.class)
	public void AfterClosingTest() throws PizzaException{
		Pizza newPizza = PizzaFactory.getPizza("PZM", 1, afterClosing, deliveryTime);
	}
	
	@Test 
	public void MatchingPizzaTest() throws PizzaException{
		Pizza newPizza = PizzaFactory.getPizza("PZM", 1, orderTime, deliveryTime);
		Pizza matchingPizza = new MargheritaPizza(1, orderTime, deliveryTime);
		assertEquals(matchingPizza, newPizza);
	}
}

