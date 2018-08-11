package com.sunbeaminfo.pizza.assignment.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/*
 * Columns :
 * ID, CustomerId, OrderTime, STATUS
 * */

@Table(name="pizza_orders")
@Entity
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column
	private int id;
	
	@Column
	private Date orderTime;
	
	@Column
	private String status;
	
	@ManyToOne
	@JoinColumn(name="CustomerId")
	private Customer cust;
	
	@OneToMany(mappedBy="id", cascade={CascadeType.ALL})
	private List<OrderDetails> detailList;
	
	public Order() {
		this(-1, null, null, "");
	}
	
	public Order(int id, Customer customer, Date orderTime, String status) {
		this.id = id;
		this.cust = customer;
		this.orderTime = orderTime;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", orderTime=" + orderTime + ", status=" + status + "]";
	}

	public Customer getCust() {
		return cust;
	}

	public void setCust(Customer cust) {
		this.cust = cust;
	}

	public List<OrderDetails> getDetailList() {
		return detailList;
	}

	public void setDetailList(List<OrderDetails> detailList) {
		this.detailList = detailList;
	}

	

	
}
