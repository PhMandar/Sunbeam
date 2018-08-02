package com.sunbeaminfo.sh.hib.dao;

import org.hibernate.Session;

import com.sunbeaminfo.sh.hib.entity.Dept;
import com.sunbeaminfo.sh.hib.entity.util.HbUtil;

public class DeptEmpDao {

	public Dept getDeptById(int deptno) {
		Session session = HbUtil.getSession();
		return session.get(Dept.class, deptno);
	}

	public void addDept(Dept d) {
		Session session = HbUtil.getSession();
		session.persist(d);
	}

	public void delDept(Dept d) {
		Session session = HbUtil.getSession();
		session.remove(d);
	}
	
	public void mergeDept(Dept d) {
		Session session = HbUtil.getSession();
		session.merge(d);
		// session.saveOrUpdate(d);  // SaveOrUpdate is not working for child tables
	}
}
