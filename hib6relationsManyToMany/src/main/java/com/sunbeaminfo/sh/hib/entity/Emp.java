package com.sunbeaminfo.sh.hib.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToOne;
import javax.persistence.QueryHint;
import javax.persistence.Table;


@NamedNativeQuery(name="spEmpBySal",
		query="CALL SP_EMPLOYEE_By_SALGT(:pSal)") 
		/*,resultClass=Emp.class,
		hints= {@QueryHint(name = "org.hibernate.callable", value = "true")})*/
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
	
	@ManyToMany(mappedBy = "empList")
	private List<Meeting> meetingList;
	
	@OneToOne
	private String empAddress;
	

	public Emp() {
		this(0, "", 0.0, -1);
	}
			
	public Emp(int empno, String ename, double sal, int deptNum) {
		super();
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
	
	public List<Meeting> getMeetingList() {
		return meetingList;
	}

	public void setMeetingList(List<Meeting> meetingList) {
		this.meetingList = meetingList;
	}

	@Override
	public String toString() {
		return "Emp [empno=" + empno + ", ename=" + ename + ", sal=" + sal + ", deptNum=" + deptNum + "]";
	}
}
