package com.sunbeaminfo.spring.services;

import com.sunbeaminfo.spring.entities.Customer;

public interface CustomerService {
	Customer getCustomerById(int id);
	Customer getCustomerByEmail(String email);
	void saveCustomer(Customer customer);
	Customer getCustomerByEmailAndPassword(String email, String password);
}
