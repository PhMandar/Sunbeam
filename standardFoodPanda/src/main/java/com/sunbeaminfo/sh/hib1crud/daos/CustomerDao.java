package com.sunbeaminfo.sh.hib1crud.daos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.sunbeaminfo.sh.hib1crud.entities.Customer;
import com.sunbeaminfo.sh.hib1crud.util.HbUtil;

public class CustomerDao implements AutoCloseable {
	private Session session;

	public void open() {
		session = HbUtil.getSession();
	}
	public void close() {

	}
	public Customer getCustomerById(int id) {
		return session.get(Customer.class, id);
	}
	public void addCustomer(Customer cust) {
		session.persist(cust);
	}
	public void updateCustomer(Customer cust) {
		session.update(cust);
	}
	public void deleteCustomerById(int id) {
		Customer cust = getCustomerById(id);
		if(cust != null)
			session.delete(cust);
	}
	public List<Customer> getAllCustomers() {
		Criteria cr = session.createCriteria(Customer.class);
		return cr.list();
	}
	public Customer getCustomer(String email) {
		Criteria cr = session.createCriteria(Customer.class);
		cr.add(Restrictions.eq("email", email));
		return (Customer) cr.uniqueResult();
	}
	public Customer getCustomerByMobile(String mobile) {
		DetachedCriteria dcr = DetachedCriteria.forClass(Customer.class);
		dcr.add(Restrictions.eq("mobile", mobile));
		Criteria cr = dcr.getExecutableCriteria(session);
		return (Customer) cr.uniqueResult();
	}
	public List<Customer> getCustomersByCriteria(DetachedCriteria dcr) {
		Criteria cr = dcr.getExecutableCriteria(session);
		return cr.list();
	}
}
