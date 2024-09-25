package com.nt.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Customer;
import com.nt.service.ICustomerMgmtService;

@Component
public class JPARepoRunner implements CommandLineRunner {

	@Autowired
	private ICustomerMgmtService custService;
	
	
	@Override
	public void run(String... args) throws Exception {
		
		/*try {
			//gives exception becauz List.of() not allows null values and deleteCustomersByIds() allows null values
			//String msg1 = custService.deleteCustomersByIds(List.of(1202, 1203, 1204, null)); 
			
			// no exception becauz Arrays.asList() allows null values and deleteCustomersByIds() allows null values
			//String msg2 = custService.deleyteCustomersByIds(Arrays.asList(1202, 1203, 1204, null));
			
			 //arg value must not be null
			//String msg3 = custService.deleyteCustomersByIds(null);
			
			String msg = custService.deleyteCustomersByIds(List.of(1202, 1203, 1204, 456));
			System.out.println(msg);	
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		/*try {
			Customer cust = custService.getCustomerById(1154);
			System.out.println("-------------------------------------------------------------------------------");
			System.out.println(cust.getClass());
			System.out.println("-------------------------------------------------------------------------------");
			System.out.println(cust.getCid());
			System.out.println("-------------------------------------------------------------------------------");
			System.out.println(cust.getClass());
			System.out.println("-------------------------------------------------------------------------------");
			System.out.println(cust.getBillamt());
			System.out.println("-------------------------------------------------------------------------------");
			System.out.println(cust.getClass());
			System.out.println("-------------------------------------------------------------------------------");
			//System.out.println(cust==null?"Customer not found":cust);	
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		/*try {
			Customer cust = new Customer();
			cust.setCadd("Hyd");
			cust.setCname("Raja");
			List<Customer> list = custService.showCustomersByExampleData(cust, true, "billamt", "cname");
			list.forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		try {
			Customer cust1 = new Customer("Jay", "Mysore", 46751.1f);
			Customer cust2 = new Customer("Sai", "Pune", 42476.6f);
			List<Customer> list = List.of(cust1, cust2);
			String msg = custService.groupCustomerRegistrations(list);
			System.out.println(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}//Runner method

}//class
