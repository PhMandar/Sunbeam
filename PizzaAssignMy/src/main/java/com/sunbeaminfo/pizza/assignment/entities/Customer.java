package com.sunbeaminfo.pizza.assignment.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/* Columns :
 * ID, Name, Password, Mobile, Address, Email
 * */

@Table(name="pizza_customers")
@Entity
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column
	private int id;
	
	@Column
	private String name;
	
	@Column
	private String password;
	
	@Column
	private String mobile;
	
	@Column
	private String address;
	
	@Column
	private String email;
	
	@OneToMany(mappedBy = "id",
			fetch = FetchType.LAZY,/*fetch = FetchType.LAZY*/
			cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE}
			)
	private List<Order> orderList;

	public Customer() {
		this(-1, "", "", "", "", "");
	}
	
	public Customer(int id, String name, String password, String mobile, String address, String email) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.mobile = mobile;
		this.address = address;
		this.email = email;
		this.orderList = new ArrayList<>();
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public List<Order> getOrderList() {
		return orderList;
	}
	
	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", password=" + password + ", mobile=" + mobile + ", address="
				+ address + ", email=" + email + "]";
	}
	
}
