package com.foodpanda.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="items")
public class Items {
	@Id
    @Column(name = "id")
	private int id;
	@Column
	private String category;
	@Column
	private String name;
	@Column
	private String info;
	@Column
	private Double price;
	
	public Items() {
		this(-1, "", "", "", 0.0);
	}
	
	public Items(int id, String category, String name, String info, Double price) {
		this.id = id;
		this.category =category;
		this.name = name;
		this.info = info;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "[id =" + id + ", category = + " + category + ", name = " + name + ", info = " + info + " , price" + price + "]";
	}
}
