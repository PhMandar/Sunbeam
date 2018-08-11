package com.sunbeaminfo.sh.onlinefood.beans;

import com.sunbeaminfo.sh.onlinefood.daos.CustomerDao;
import com.sunbeaminfo.sh.onlinefood.entities.Customer;

public class LoginBean {
	private String email;
	private String password;
	public LoginBean() {
		
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean getStatus() {
		Customer cust = null;
		try(CustomerDao dao = new CustomerDao()) {
			dao.open();
			cust = dao.getCustomer(email);
			System.out.println("\n\n " + cust);
			if(password.equals(cust.getPassword()))
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
