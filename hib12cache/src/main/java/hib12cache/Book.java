package hib12cache;

import java.io.Serializable;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Cache(usage=CacheConcurrencyStrategy.READ_ONLY/*NONE*/)
@Entity
@Table(name = "Books")
public class Book implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;
	
	private String name;

	private String author;

	private String subject;

	private double price;
	
	public Book() {
		this(-1, "", "", "", 0.0);
	}
	
	public Book(int pid, String pName, String pAuthor, String pSubject, double pPrice) {
		this.id = pid;
		this.name = pName;
		this.author = pAuthor;
		this.subject = pSubject;
		this.price = pPrice;
	}

	@Column
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Column
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Column
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", author=" + author + ", subject=" + subject + ", price=" + price
				+ "]";
	}
}
