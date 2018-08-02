package com.sunbeaminfo.sh.hib.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "EMPLOYEE")
@Entity
public class Emp implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column
	private int empno;
	@Column
	private String ename;
	@Column
	private double sal;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DEPTNO")/*here deptno is referring to the db table column and not the class variable */
	private Dept dept1;

	public Emp() {
		this(0, "", 0.0);
	}

	public Emp(int empno, String ename, double sal) {
		this.empno = empno;
		this.ename = ename;
		this.sal = sal;
	}

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public double getSal() {
		return sal;
	}

	public void setSal(double sal) {
		this.sal = sal;
	}
	
	public Dept getDept1() {
		return dept1;
	}
	
	public void setDept1(Dept dept1) {
		this.dept1 = dept1;
	}

	@Override
	public String toString() {
		return "Emp [empno=" + empno + ", ename=" + ename + ", sal=" + sal + ", dept1=" + dept1 + "]";
	}
	
	
}
