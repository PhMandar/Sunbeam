package com.sunbeaminfo.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunbeaminfo.spring.daos.CustomerDao;
import com.sunbeaminfo.spring.entities.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerDao custDao;
	
	@Transactional
	@Override
	public Customer getCustomerById(int id) {
		return custDao.getCustomerById(id);
	}

	@Transactional
	@Override
	public Customer getCustomerByEmail(String email) {
		return custDao.getCustomerByEmail(email);
	}

	@Transactional
	@Override
	public void saveCustomer(Customer customer) {
		custDao.saveCustomer(customer);
	}

	@Transactional
	public Customer getCustomerByEmailAndPassword(String email, String password) {
		Customer cust = this.getCustomerByEmail(email);
		return password.equals(cust.getPassword()) ? cust:null;
	}

}
