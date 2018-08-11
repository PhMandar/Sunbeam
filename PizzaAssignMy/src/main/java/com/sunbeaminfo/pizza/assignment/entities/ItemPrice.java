package com.sunbeaminfo.pizza.assignment.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/* Columns : 
 * ID	ITEMID	SIZES	Price
 * */

@Table(name="pizza_pricing")
@Entity
public class ItemPrice implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column
	private int id;
	
	@Column
	private int itemId;
	
	@Column
	private String sizes;
	
	@Column
	private double price;
	
	@ManyToOne
	@JoinColumn(name="ITEMID")
	private Item item;
	
	@OneToMany(mappedBy="id", cascade={CascadeType.ALL})
	private List<OrderDetails> detailList;

	public ItemPrice() {
		this(-1, -1, "", 0.0);
	}
	
	public ItemPrice(int id, int itemId, String sizes, double price) {
		this.id = id;
		this.itemId = itemId;
		this.sizes = sizes;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getSizes() {
		return sizes;
	}

	public void setSizes(String sizes) {
		this.sizes = sizes;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public Item getItem() {
		return item;
	}

	@Override
	public String toString() {
		return "ItemPrice [id=" + id + ", itemId=" + itemId + ", sizes=" + sizes + ", price=" + price + "]";
	}
}
