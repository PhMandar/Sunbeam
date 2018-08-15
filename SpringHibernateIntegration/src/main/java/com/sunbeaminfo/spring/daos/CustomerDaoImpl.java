package com.sunbeaminfo.spring.daos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sunbeaminfo.spring.entities.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	private SessionFactory factory;
	
	@Override
	public Customer getCustomerById(int id) {
		Session session = factory.getCurrentSession();
		return session.get(Customer.class ,id);
	}

	@Override
	public Customer getCustomerByEmail(String email) {
		Session session = factory.getCurrentSession();
		Query<Customer> query = session.createQuery("from Customer  c where c.email=:p_email");
		query.setParameter("p_email", email);
		return query.getSingleResult();
	}

	@Override
	public void saveCustomer(Customer customer) {
		Session session = factory.getCurrentSession();
		session.persist(customer);
	}

}
