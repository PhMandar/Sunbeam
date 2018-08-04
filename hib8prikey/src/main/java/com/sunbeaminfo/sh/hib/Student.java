package com.sunbeaminfo.sh.hib;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name="STUDENTS")
public class Student implements Serializable{
	private static final long serialVersionUID = 1L;

	// CREATE TABLE STUDENTS (roll int, std int, name varchar(50), marks double, primary key(roll, std));
	
	@EmbeddedId
	StudStdRoll stdRollPK;
	
	@Column
	String name;
	
	@Column
	double marks;
	
	public Student() {
	}

	public Student(StudStdRoll stdRollPK, String name, double marks) {
		this.stdRollPK = stdRollPK;
		this.name = name;
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "Student [stdRollPK=" + stdRollPK + ", name=" + name + ", marks=" + marks + "]";
	}
	
	
}
