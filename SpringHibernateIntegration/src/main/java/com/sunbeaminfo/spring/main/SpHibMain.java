package com.sunbeaminfo.spring.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sunbeaminfo.spring.entities.Customer;
import com.sunbeaminfo.spring.services.CustomerService;

public class SpHibMain {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		ctx.registerShutdownHook();
		
		CustomerService custService = ctx.getBean(CustomerService.class);
		Customer customer = custService.getCustomerByEmailAndPassword("nitin@sunbeaminfo.com", "nitin");
		System.out.println(customer == null ? "Customer not found" : customer);
		
		customer = custService.getCustomerByEmail("nilesh@sunbeaminfo.com");
		System.out.println(customer == null ? "Customer not found" : customer);
		
		customer = custService.getCustomerById(1);
		System.out.println(customer == null ? "Customer not found" : customer);
		
		
		customer = new Customer(5, "Shubhangi", "shubhangi", "8446293055", "Keshav Nagar", "shubhangi@sunbeaminfo.com");
		custService.saveCustomer(customer);
		customer = custService.getCustomerById(5);
		System.out.println(customer == null ? "Customer not found" : customer);
	}
}
