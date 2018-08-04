package com.sunbeaminfo.sh.hib;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.GenericGenerator;

@Table(name="Items")
@Entity
public class Item implements Serializable {
	private static final long serialVersionUID = 1L;

	/*@GeneratedValue(generator="gen", strategy=GenerationType.IDENTITY)*/

	/*@GenericGenerator(name="generator", strategy="increment")
	@GeneratedValue(generator="generator", strategy = GenerationType.AUTO) */
	
	/*@TableGenerator(name="gen", initialValue=100, allocationSize=1, table="id_gen", pkColumnName="name", valueColumnName="id")
	@GeneratedValue(generator="gen", strategy = GenerationType.TABLE)*/
	
	@GenericGenerator(name="gen", strategy="native" /*strategy="increment"*/)
	@GeneratedValue(generator="gen")
	@Id
	@Column
	private int id;
	
	@Column
	private String name;
	
	@Column
	private String category;
	
	@Column
	private String info;
	
	@Column
	private double price;
	
	public Item() {
		
	}
	public Item(int id, String name, String category, String info, double price) {
		this.id = id;
		this.name = name;
		this.category = category;
		this.info = info;
		this.price = price;
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
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", category=" + category + ", info=" + info + ", price=" + price
				+ "]";
	}
}
