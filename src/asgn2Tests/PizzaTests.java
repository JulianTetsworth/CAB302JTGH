package asgn2Tests;

import static org.junit.Assert.assertEquals;

import java.time.LocalTime;

import org.junit.Test;

import asgn2Exceptions.PizzaException;
import asgn2Pizzas.MargheritaPizza;
import asgn2Pizzas.MeatLoversPizza;
import asgn2Pizzas.Pizza;
import asgn2Pizzas.PizzaTopping;
import asgn2Pizzas.VegetarianPizza;

/**
 * A class that that tests the asgn2Pizzas.MargheritaPizza, asgn2Pizzas.VegetarianPizza, asgn2Pizzas.MeatLoversPizza classes. 
 * Note that an instance of asgn2Pizzas.MeatLoversPizza should be used to test the functionality of the 
 * asgn2Pizzas.Pizza abstract class. 
 * 
 * @author Person B
 *
 */

public class PizzaTests {
	
	private LocalTime orderTime = LocalTime.of(20, 0);
	private LocalTime deliveryTime = LocalTime.of(21, 0); 
	private LocalTime beforeOpening = LocalTime.of(6, 0);
	private LocalTime afterClosing = LocalTime.of(23, 50);
	
	@Test 
	public void costPerMargheritaTest() throws PizzaException{
		double expectedCost = 1.5;
		Pizza newPizza = new MargheritaPizza(1, orderTime, deliveryTime);
		assertEquals(expectedCost, newPizza.getCostPerPizza(), 0.1);
	}
	@Test 
	public void costPerVegetarianTest() throws PizzaException{
		double expectedCost = 5.5;
		Pizza newPizza = new VegetarianPizza(1, orderTime, deliveryTime);
		assertEquals(expectedCost, newPizza.getCostPerPizza(), 0.1);
	}
	@Test 
	public void costPerMeatLoversTest() throws PizzaException{
		double expectedCost = 5;
		Pizza newPizza = new MeatLoversPizza(1, orderTime, deliveryTime);
		assertEquals(expectedCost, newPizza.getCostPerPizza(), 0.1);
	}@Test
	public void pricePerMeatLoversTest() throws PizzaException{
		double expectedPrice = 12;
		Pizza newPizza = new MeatLoversPizza(1, orderTime, deliveryTime);
		assertEquals(expectedPrice, newPizza.getPricePerPizza(), 0.1);
	}@Test
	public void pricePerMargheritaTest() throws PizzaException{
		double expectedPrice = 8;
		Pizza newPizza = new MargheritaPizza(1, orderTime, deliveryTime);
		assertEquals(expectedPrice, newPizza.getPricePerPizza(), 0.1);
	}@Test
	public void pricePerVegetarianTest() throws PizzaException{
		double expectedPrice = 10;
		Pizza newPizza = new VegetarianPizza(1, orderTime, deliveryTime);
		assertEquals(expectedPrice, newPizza.getPricePerPizza(), 0.1);
	}
	@Test (expected = PizzaException.class)
	public void TooManyPizzaTest() throws PizzaException{
		Pizza newPizza = new MargheritaPizza(11, orderTime, deliveryTime);
	}
	@Test (expected = PizzaException.class)
	public void TooFewPizzaTest() throws PizzaException{
		Pizza newPizza = new MargheritaPizza(-1, orderTime, deliveryTime);
	}
	@Test (expected = PizzaException.class)
	public void ZeroPizzaTest() throws PizzaException{
		Pizza newPizza = new MargheritaPizza(0, orderTime, deliveryTime);
	}
	@Test (expected = PizzaException.class)
	public void BeforeOpeningTimeTest() throws PizzaException{
		Pizza newPizza = new MargheritaPizza(1, beforeOpening, deliveryTime);
	}
	@Test (expected = PizzaException.class)
	public void AfterClosingTimeTest() throws PizzaException{
		Pizza newPizza = new MargheritaPizza(1, afterClosing, deliveryTime);
	}
	@Test 
	public void MargheritaOrderCostTest() throws PizzaException{
		double expectedOrderCost = 7.5;
		Pizza newPizza = new MargheritaPizza(5, orderTime, deliveryTime);
		assertEquals(expectedOrderCost, newPizza.getOrderCost(), 0.1);
	}
	@Test 
	public void VegetarianOrderCostTest() throws PizzaException{
		double expectedOrderCost = 27.5;
		Pizza newPizza = new VegetarianPizza(5, orderTime, deliveryTime);
		assertEquals(expectedOrderCost, newPizza.getOrderCost(), 0.1);
	}
	@Test 
	public void MeatLoversOrderCostTest() throws PizzaException{
		double expectedOrderCost = 25;
		Pizza newPizza = new MeatLoversPizza(5, orderTime, deliveryTime);
		assertEquals(expectedOrderCost, newPizza.getOrderCost(), 0.1);
	}
	@Test 
	public void MargheritaOrderPriceTest() throws PizzaException{
		double expectedOrderPrice = 40;
		Pizza newPizza = new MargheritaPizza(5, orderTime, deliveryTime);
		assertEquals(expectedOrderPrice, newPizza.getOrderPrice(), 0.1);
	}
	@Test 
	public void MeatLoversOrderPriceTest() throws PizzaException{
		double expectedOrderPrice = 60;
		Pizza newPizza = new MeatLoversPizza(5, orderTime, deliveryTime);
		assertEquals(expectedOrderPrice, newPizza.getOrderPrice(), 0.1);
	}
	@Test 
	public void VegetarianOrderPriceTest() throws PizzaException{
		double expectedOrderPrice = 50;
		Pizza newPizza = new VegetarianPizza(5, orderTime, deliveryTime);
		assertEquals(expectedOrderPrice, newPizza.getOrderPrice(), 0.1);
	}
	
	@Test 
	public void MargheritaOrderProfitTest() throws PizzaException{
		double expectedOrderProfit = 32.5;
		Pizza newPizza = new MargheritaPizza(5, orderTime, deliveryTime);
		assertEquals(expectedOrderProfit, newPizza.getOrderProfit(), 0.1);
	}
	
	@Test 
	public void VegetarianOrderProfitTest() throws PizzaException{
		double expectedOrderProfit = 22.5;
		Pizza newPizza = new VegetarianPizza(5, orderTime, deliveryTime);
		assertEquals(expectedOrderProfit, newPizza.getOrderProfit(), 0.1);
	}
	
	@Test 
	public void MeatLoversOrderProfitTest() throws PizzaException{
		double expectedOrderProfit = 35;
		Pizza newPizza = new MeatLoversPizza(5, orderTime, deliveryTime);
		assertEquals(expectedOrderProfit, newPizza.getOrderProfit(), 0.1);
	}
	
	@Test 
	public void MargheritaContainsToppingTest() throws PizzaException{
		PizzaTopping topping = PizzaTopping.CHEESE;
		Pizza newPizza = new MargheritaPizza(5, orderTime, deliveryTime);
		assertEquals(true, newPizza.containsTopping(topping));
	}
	
	@Test 
	public void VegetarianContainsToppingTest() throws PizzaException{
		PizzaTopping topping = PizzaTopping.CAPSICUM;
		Pizza newPizza = new VegetarianPizza(5, orderTime, deliveryTime);
		assertEquals(true, newPizza.containsTopping(topping));
	}
	@Test 
	public void MeatLoversContainsToppingTest() throws PizzaException{
		PizzaTopping topping = PizzaTopping.BACON;
		Pizza newPizza = new MeatLoversPizza(5, orderTime, deliveryTime);
		assertEquals(true, newPizza.containsTopping(topping));
	}
	
	@Test 
	public void MargheritaNoToppingTest() throws PizzaException{
		PizzaTopping topping = PizzaTopping.BACON;
		Pizza newPizza = new MargheritaPizza(5, orderTime, deliveryTime);
		assertEquals(false, newPizza.containsTopping(topping));
	}
	@Test 
	public void VegetarianNoToppingTest() throws PizzaException{
		PizzaTopping topping = PizzaTopping.SALAMI;
		Pizza newPizza = new VegetarianPizza(5, orderTime, deliveryTime);
		assertEquals(false, newPizza.containsTopping(topping));
	}
	@Test 
	public void MeatLoversNoToppingTest() throws PizzaException{
		PizzaTopping topping = PizzaTopping.CAPSICUM;
		Pizza newPizza = new MeatLoversPizza(5, orderTime, deliveryTime);
		assertEquals(false, newPizza.containsTopping(topping));
	}
	@Test 
	public void GetMargheritaTypeTest() throws PizzaException{
		Pizza newPizza = new MargheritaPizza(5, orderTime, deliveryTime);
		assertEquals("Margherita", newPizza.getPizzaType());
	}
	@Test 
	public void GetVegetarianTypeTest() throws PizzaException{
		Pizza newPizza = new VegetarianPizza(5, orderTime, deliveryTime);
		assertEquals("Vegetarian", newPizza.getPizzaType());
	}
	@Test 
	public void GetMeatLoversTypeTest() throws PizzaException{
		Pizza newPizza = new MeatLoversPizza(5, orderTime, deliveryTime);
		assertEquals("MeatLovers", newPizza.getPizzaType());
	}
}
