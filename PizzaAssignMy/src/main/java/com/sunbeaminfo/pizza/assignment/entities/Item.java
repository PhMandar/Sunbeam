package com.sunbeaminfo.pizza.assignment.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/* Columns :
 * ID, Name, Type, Category, Description
 * */

@Table(name="pizza_items")
@Entity
public class Item implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column
	private int id;
	
	@Column
	private String name;
	
	@Column
	private String type;
	
	@Column
	private String category;
	
	@Column
	private String description;

	@OneToMany(mappedBy="itemId")
	private List<ItemPrice> priceList;
	
	public Item() {
		this(-1, "", "", "", "");
	}
	
	public Item(int id, String name, String type, String category, String description) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.category = category;
		this.description = description;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<ItemPrice> getPriceList() {
		return priceList;
	}
	
	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", type=" + type + ", category=" + category + ", description="
				+ description + "]";
	}
}
