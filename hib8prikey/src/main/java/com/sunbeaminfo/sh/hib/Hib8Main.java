package com.sunbeaminfo.sh.hib;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.GeneratedValue;

import org.hibernate.Session;
import org.hibernate.annotations.GenericGenerator;

import com.sunbeaminfo.sh.util.HbUtil;

public class Hib8Main {

	public static void main(String[] args) {
		try {
			HbUtil.beginTransaction();
			// 1. strategy=GenerationType.IDENTITY
			// generationTypeIDENTITY();
			
			// 2. strategy=GenerationType.AUTO
			// generationTypeAuto();
			
			// 3. strategy=GenerationType.TABLE
			// generationTypeTable();
			
			// 4. GenericGenerator using strategy = 
			// generationTypeGenericGenerator();
			
			// 5. Compositekey example
			compositePrimaryKey();
			
			
			HbUtil.commitTransaction();
		} catch (Exception e) {
			e.printStackTrace();
			HbUtil.rollbackTransaction();
		}
		finally {
			HbUtil.shutdown();
		}
		
	}

	
	/***
	 * Steps to follow : 
	 * 1. CREATE TABLE STUDENTS (roll int, std int, name varchar(50), marks double, primary key(roll, std));
	 * 2. Create separate class called StudStdRoll which is annoted with @Embeddable and with variables 
	 *    which forms composite keys like roll and std
	 * 3. In Student entity class use the object of  StudStdRoll as composite key and annotate it as @EmbeddedId 
	 * 
	 * The queries gets generated are :
	 * Hibernate: insert into STUDENTS (marks, name, roll, std) values (?, ?, ?, ?)
	 */
	private static void compositePrimaryKey() {
		Session session = HbUtil.getSession();
		Student std = new Student(new StudStdRoll(1,2), "Mandar", 92.99);
		session.persist(std);
	}

	/***
	 * @GenericGenerator(name="gen", strategy="native" / * strategy="increment" * /)
	 * @GeneratedValue(generator="gen")
	 * 
	 * The queries gets generated are :
	 * Hibernate: insert into Items (category, info, name, price) values (?, ?, ?, ?)
	 */
	private static void generationTypeGenericGenerator() {
		Session session = HbUtil.getSession();
		Item i = new Item(0, "A", "B", "C", 4);
		session.persist(i);
	}

	/***
	 * Step 1 : Create following table id_gen
	 * CREATE TABLE id_gen(name VARCHAR(20) PRIMARY KEY, id INT);
	 * 
	 * For this following needs to be used for Item.id
	 * @TableGenerator(name="gen", initialValue=200, allocationSize=1, table="id_gen", pkColumnName="name", valueColumnName="id")
	 * @GeneratedValue(generator="gen", strategy = GenerationType.TABLE)
	 * 
	 * The queries gets generated are :
	 * Hibernate: select tbl.id from id_gen tbl where tbl.name=? for update
	 * Hibernate: insert into id_gen (name, id)  values (?,?) 
	 * Hibernate: update id_gen set id=?  where id=? and name=? 
	 * Hibernate: insert into Items (category, info, name, price, id) values (?, ?, ?, ?, ?)
	 */
	private static void generationTypeTable() {
		Session session = HbUtil.getSession();
		Item i = new Item(0, "A", "B", "C", 4);
		session.persist(i);
	}

	/**
	 * For this following needs to be used for Item.id
	 * @GenericGenerator(name="generator", strategy="increment")
	 * @GeneratedValue(generator="generator", strategy = GenerationType.AUTO)
	 * 
	 * The queries gets generated are :
	 * Hibernate: select max(id) from Items
	 * Hibernate: insert into Items (category, info, name, price, id) values (?, ?, ?, ?, ?)
	 * 
	 * */
	private static void generationTypeAuto() {
		Session session = HbUtil.getSession();
		Item i = new Item(0, "A", "B", "C", 4);
		session.persist(i);
	}

	/**
	 * For this following needs to be used for Item.id
	 * @GeneratedValue(generator="gen", strategy=GenerationType.IDENTITY)
	 * 
	 * The queries gets generated are :
	 * Hibernate: insert into Items (category, info, name, price) values (?, ?, ?, ?)
	 * */
	private static void generationTypeIDENTITY() {
		Session session = HbUtil.getSession();
		Item i = new Item(0, "A", "B", "C", 4);
		session.persist(i);
	}

}
