package com.sunbeaminfo.pizza.assignment.daos;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.sunbeaminfo.pizza.assignment.entities.Customer;
import com.sunbeaminfo.pizza.assignment.util.HbUtil;

/**
 * Insert new customer.
 * Fetch customer by email.
 */
public class LoginDao {
	
	/***
	 * Description : Insert new customer.
	 * @param cust
	 * @return
	 */
	public boolean insertCustomer(Customer cust) {
		Session session  = HbUtil.getSession();
		session.persist(cust);
		
		return true;
	}
	
	/***
	 * Description : Fetch customer by email.
	 * @param email
	 * @return
	 */
	public Customer getCustomerByEmail(String email) {
		Session session = HbUtil.getSession();
		Criteria criteria = session.createCriteria(Customer.class);
		criteria.add(Restrictions.eq("email", email));
		Customer tmpCust = (Customer) criteria.uniqueResult();
		System.out.println(tmpCust.getId());
		return session.get(Customer.class, tmpCust.getId()); 
	}
	
	
}
