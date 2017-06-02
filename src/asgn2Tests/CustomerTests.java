package asgn2Tests;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;

import org.junit.Test;

import asgn2Customers.Customer;
import asgn2Customers.DriverDeliveryCustomer;
import asgn2Customers.DroneDeliveryCustomer;
import asgn2Customers.PickUpCustomer;
import asgn2Exceptions.CustomerException;

/**
 * A class that tests the that tests the asgn2Customers.PickUpCustomer, asgn2Customers.DriverDeliveryCustomer,
 * asgn2Customers.DroneDeliveryCustomer classes. Note that an instance of asgn2Customers.DriverDeliveryCustomer 
 * should be used to test the functionality of the  asgn2Customers.Customer abstract class. 
 * 
 * @author Person A
 * 
 *
 */
public class CustomerTests {
	
	//test Customer constructors	
	@Test
	public void CorrectDriverLocation() throws CustomerException{
		Customer hello= new DriverDeliveryCustomer("Bob Mate","0402157387",1,0);		
	}		
	
	@Test
	public void CorrectDroneLocation() throws CustomerException{
		Customer hello= new DroneDeliveryCustomer("Jerry Smith","0402157387",1,0);		
	}
	
	@Test	
	public void CorrectPickUpLocation() throws CustomerException{
		Customer hello= new PickUpCustomer("Lisa Pine","0402157387",0,0);		
	}
	
	@Test(expected=CustomerException.class)
	public void incorrectDriverLocation() throws CustomerException{
		Customer hello= new DriverDeliveryCustomer("Who Dare","0402157387",0,-12);		
	}		
	
	@Test(expected=CustomerException.class)
	public void incorrectDroneLocation() throws CustomerException{
		Customer hello= new DroneDeliveryCustomer("Edwena Stone","0402157387",20,0);		
	}
	
	@Test(expected=CustomerException.class)
	public void incorrectPickUpLocation() throws CustomerException{
		Customer hello= new PickUpCustomer("Bob Smith","0402157387",12,0);		
	}
	
	@Test(expected=CustomerException.class)
	public void WhitespaceName() throws CustomerException{
		Customer hello= new DriverDeliveryCustomer("        ","0402157387",1,0);
	}
	
	@Test(expected=CustomerException.class)
	public void MobileTooShort() throws CustomerException{
		Customer hello= new DriverDeliveryCustomer("Man Manson","04021587",1,0);
	}
	@Test(expected=CustomerException.class)
	public void MobileTooLong() throws CustomerException{
		Customer hello= new DriverDeliveryCustomer("Henry Cake","04021512312387",1,0);
	}
	@Test(expected=CustomerException.class)
	public void MobileNon0() throws CustomerException{
		Customer hello= new DriverDeliveryCustomer("Greg Jefferson","1234567890",1,0);
	}
	
	
	//Test the various forms of getDiliveryDistance	
	@Test
	public void TestgetDeliveryDistance() {
		
		try{
			Customer DriverTest= new DriverDeliveryCustomer("Greg Jefferson","0402168798",-10,5);
			Customer DroneTest= new DroneDeliveryCustomer("Greg Jefferson","0492831723",-10,8);
			Customer PickUpTest= new PickUpCustomer("Greg Jefferson","0402319586",0,0);		
			assertEquals(15,DriverTest.getDeliveryDistance(),0.1);
			assertEquals(12.8,DroneTest.getDeliveryDistance(),0.01);
			assertEquals(0,PickUpTest.getDeliveryDistance(),0.1);
			
			}catch (Exception CustomerException){
				System.err.println("Error " + CustomerException.getMessage());
		}
			
		
		
	}
	
	
	
	
	
	
	
	
}
