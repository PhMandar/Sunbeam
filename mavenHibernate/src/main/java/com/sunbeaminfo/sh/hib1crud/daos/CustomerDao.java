package com.sunbeaminfo.sh.hib1crud.daos;

import org.hibernate.Session;

import com.sunbeaminfo.sh.hib1crud.entities.Customer;
import com.sunbeaminfo.sh.hib1crud.util.HbUtil;

public class CustomerDao implements AutoCloseable {
	private Session session;
	public void open() {
		session = HbUtil.getSession();
	}
	public void close() {
		if(session != null)
			session.close();
	}
	public Customer getCustomerById(int id) {
		return session.get(Customer.class, id);
	}
	public void addCustomer(Customer cust) {
		try {
			session.getTransaction().begin();
			session.persist(cust);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
	}
	public void updateCustomer(Customer cust) {
		try {
			session.getTransaction().begin();
			session.update(cust);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
	}
	public void deleteCustomerById(int id) {
		try {
			session.getTransaction().begin();
			Customer cust = getCustomerById(id);
			if(cust != null)
				session.delete(cust);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
	}
}
