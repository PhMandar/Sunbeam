package com.sunbeaminfo.pizza.assignment.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/* Columns :
 * ID(PK) , OrderId(FK), PRICEID(FK)
 * */

@Table(name="pizza_orderdetails")
@Entity
public class OrderDetails implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column
	@GenericGenerator(name="generator", strategy="increment")
	@GeneratedValue(generator="generator", strategy = GenerationType.AUTO)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="OrderId")
	private Order order;
	
	@ManyToOne
	@JoinColumn(name="PRICEID")
	private ItemPrice itemPrice;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public ItemPrice getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(ItemPrice itemPrice) {
		this.itemPrice = itemPrice;
	}

	@Override
	public String toString() {
		return "OrderDetails [id=" + id + ", order=" + order + ", itemPrice=" + itemPrice + "]";
	}

	public OrderDetails() {
		this.id = -1;
		this.order = null;
		this.itemPrice = null;
	}
			
	public OrderDetails(int id, Order order, ItemPrice itemPrice) {
		this.id = id;
		this.order = order;
		this.itemPrice = itemPrice;
	}
}
