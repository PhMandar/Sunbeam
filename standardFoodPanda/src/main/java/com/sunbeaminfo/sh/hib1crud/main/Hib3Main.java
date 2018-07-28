package com.sunbeaminfo.sh.hib1crud.main;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.sunbeaminfo.sh.hib1crud.daos.CustomerDao;
import com.sunbeaminfo.sh.hib1crud.entities.Customer;
import com.sunbeaminfo.sh.hib1crud.util.HbUtil;

public class Hib3Main {
	public static void main(String[] args) {
		try(CustomerDao dao = new CustomerDao()) {
			dao.open();
			HbUtil.beginTransaction();

			DetachedCriteria dcr = DetachedCriteria.forClass(Customer.class);
			dcr.add(
				Restrictions.or(
						Restrictions.eq("email", "nilesh@sunbeaminfo.com"),
						Restrictions.eq("mobile", "9881208115")
					)
				);
			dcr.addOrder(Order.desc("name"));
			
			List<Customer> list = dao.getCustomersByCriteria(dcr);
			for (Customer cust : list) {
				System.out.println(cust);
			}
			
			HbUtil.commitTransaction();
		} catch (Exception e) {
			HbUtil.rollbackTransaction();
			e.printStackTrace();
		}
		
		/*
		try(CustomerDao dao = new CustomerDao()) {
			dao.open();
			HbUtil.beginTransaction();
			Customer cust = dao.getCustomerByMobile("9881208115");
			System.out.println(cust);
			HbUtil.commitTransaction();
		} catch (Exception e) {
			HbUtil.rollbackTransaction();
			e.printStackTrace();
		}
		*/
		/*
		try(CustomerDao dao = new CustomerDao()) {
			dao.open();
			HbUtil.beginTransaction();
			Customer cust = dao.getCustomer("nilesh@sunbeaminfo.com");
			System.out.println(cust);
			HbUtil.commitTransaction();
		} catch (Exception e) {
			HbUtil.rollbackTransaction();
			e.printStackTrace();
		}
		*/
		
		/*
		try(CustomerDao dao = new CustomerDao()) {
			dao.open();
			HbUtil.beginTransaction();
			List<Customer> custList = dao.getAllCustomers();
			for (Customer cust : custList) {
				System.out.println(cust);
			}
			HbUtil.commitTransaction();
		} catch (Exception e) {
			HbUtil.rollbackTransaction();
			e.printStackTrace();
		}
		*/
		/*
		try(CustomerDao dao = new CustomerDao()) {
			dao.open();
			HbUtil.beginTransaction();
			Customer cust = dao.getCustomerById(1);
			if(cust == null)
				System.out.println("Customer Not Found");
			else
				System.out.println(cust.toString());
			HbUtil.commitTransaction();
		} catch (Exception e) {
			HbUtil.rollbackTransaction();
			e.printStackTrace();
		}
		*/
		/*		
		try(CustomerDao dao = new CustomerDao()) {
			dao.open();
			HbUtil.beginTransaction();
			Customer cust = new Customer(5, "Abc", "Pqr", "abc@gmail.com", "1234567890", "Xyz");
			dao.addCustomer(cust);
			HbUtil.commitTransaction();
		} catch (Exception e) {
			HbUtil.rollbackTransaction();
			e.printStackTrace();
		}
		*/
		/*
		try(CustomerDao dao = new CustomerDao()) {
			dao.open();
			HbUtil.beginTransaction();
			Customer cust = dao.getCustomerById(5);
			if(cust == null)
				System.out.println("Customer Not Found");
			else {
				cust.setAddress("Lmn");
				cust.setName("Def");
				dao.updateCustomer(cust);
			}
			HbUtil.commitTransaction();
		} catch (Exception e) {
			HbUtil.rollbackTransaction();
			e.printStackTrace();
		}
		*/
		/*
		try(CustomerDao dao = new CustomerDao()) {
			dao.open();
			HbUtil.beginTransaction();
			dao.deleteCustomerById(5);
			HbUtil.commitTransaction();
		} catch (Exception e) {
			HbUtil.rollbackTransaction();
			e.printStackTrace();
		}
		*/
		HbUtil.shutdown();
	}
}
