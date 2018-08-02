package com.sunbeaminfo.sh.hib.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;


@NamedNativeQueries(
		{
			@NamedNativeQuery(name="spEmpBySal", query="CALL SP_EMPLOYEE_By_SALGT(:pSal)", resultClass = Emp.class),
			@NamedNativeQuery(name="spUpdateEmp", query="CALL SP_UPDATE_EMPLOYEE(:pEmpId, :pSal, :pDeptNo)", resultClass = Emp.class)
		}
	)


// spUpdateEmp
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

	@Column(name="deptno")
	private int deptNum;
	
	public Emp() {
		this(0, "", 0.0, -1);
	}
			
	public Emp(int empno, String ename, double sal, int deptNum) {
		this.empno = empno;
		this.ename = ename;
		this.sal = sal;
		this.deptNum = deptNum;
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

	public int getDeptNum() {
		return deptNum;
	}

	public void setDeptNum(int deptNum) {
		this.deptNum = deptNum;
	}

	@Override
	public String toString() {
		return "Emp [empno=" + empno + ", ename=" + ename + ", sal=" + sal + ", deptNum=" + deptNum + "]";
	}
}
