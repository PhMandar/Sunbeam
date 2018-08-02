package com.sunbeaminfo.sh.hib.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table(name="DEPARTMENT")
@Entity
public class Dept {
	@Id
	@Column
	private int deptno;
	@Column
	private String dname;
	@Column
	private String loc;
	
	@OneToMany(mappedBy="dept1", /*mappedBy is referring to the class veriable and not the name of the column of RDBMS table*/ 
			fetch = FetchType.EAGER,
			cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE})
	private List<Emp> empList;

	public Dept() {
		this(0, "", "");
	}

	public Dept(int deptno, String dname, String loc) {
		this.deptno = deptno;
		this.dname = dname;
		this.loc = loc;
	}

	public List<Emp> getEmpList() {
		return empList;
	}

	public void setEmpList(List<Emp> empList) {
		this.empList = empList;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	@Override
	public String toString() {
		return "Dept [deptno=" + deptno + ", dname=" + dname + ", loc=" + loc + "]";
	}
}
