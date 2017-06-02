package asgn2Tests;


import org.junit.Test;
import static org.junit.Assert.assertEquals;
import asgn2Customers.Customer;
import asgn2Customers.CustomerFactory;

import asgn2Exceptions.CustomerException;

/**
 * A class the that tests the asgn2Customers.CustomerFactory class.
 * 
 * @author Person A
 *
 */
public class CustomerFactoryTests {
	
	
//Test Customer creation
	@Test
	public void TestPickUpFactory() throws CustomerException{
	
	
	Customer PickUpCustomer= CustomerFactory.getCustomer("PUC","Josh Man","0405696680",0,0);
	assertEquals(0,PickUpCustomer.getDeliveryDistance(),0.1);
	assertEquals("Pick Up",PickUpCustomer.getCustomerType());
	assertEquals("Josh Man",PickUpCustomer.getName());			
	}
	
	@Test
	public void TestDriverFactory() throws CustomerException{
	
	
	Customer DriverCustomer= CustomerFactory.getCustomer("DVC","Josh Man","0405696680",-2,7);
	assertEquals(9,DriverCustomer.getDeliveryDistance(),0.1);
	assertEquals("Driver Delivery",DriverCustomer.getCustomerType());
	assertEquals("Josh Man",DriverCustomer.getName());			
	}
	
	@Test
	public void TestDroneFactory() throws CustomerException{
	
	
	Customer DroneCustomer= CustomerFactory.getCustomer("DNC","Josh Man","0405696680",-10,4);
	assertEquals(10.77,DroneCustomer.getDeliveryDistance(),0.01);
	assertEquals("Drone Delivery",DroneCustomer.getCustomerType());
	assertEquals("Josh Man",DroneCustomer.getName());			
	}
	
	
//Test Invalid Customer code inputs
	@Test(expected=CustomerException.class)
	public void invalidInput() throws CustomerException{
	
	
	Customer DroneCustomer= CustomerFactory.getCustomer("DC","Josh Man","0405696680",5,4);
			
	}
	
	
	@Test(expected=CustomerException.class)
	public void invalidInput2() throws CustomerException{
	CustomerFactory factory= new CustomerFactory();
		
	Customer DroneCustomer= CustomerFactory.getCustomer("213","Josh Man","0405696680",-3,1);
				
	}
	
	@Test(expected=CustomerException.class)
	public void invalidInput3() throws CustomerException{
	CustomerFactory factory= new CustomerFactory();
		
	Customer DroneCustomer= CustomerFactory.getCustomer("AASLKASLANMSKLANMKSKLA","Josh Man","0405696680",-6,1);
				
	}
	
	@Test(expected=CustomerException.class)
	public void invalidInput4() throws CustomerException{
	CustomerFactory factory= new CustomerFactory();
		
	Customer DroneCustomer= CustomerFactory.getCustomer("","Josh Man","0405696680",-6,1);
				
	}
	
	
	
}
