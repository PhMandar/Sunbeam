package com.sunbeaminfo.sh.hib.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="EMPADDRESS")
public class Address implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "EMPID")
	int empId;
	
	@Column(name = "ADDR")
	String address;
	
	@Column(name = "COUNTRY")
	String city;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	Emp emp;
	
	
}
