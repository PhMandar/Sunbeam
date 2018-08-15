package com.sunbeaminfo.spring.daos;

import com.sunbeaminfo.spring.entities.Customer;

public interface CustomerDao {
	Customer getCustomerById(int id);
	Customer getCustomerByEmail(String email);
	void saveCustomer(Customer customer);
}
