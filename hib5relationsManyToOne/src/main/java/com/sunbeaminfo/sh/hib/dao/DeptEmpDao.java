package com.sunbeaminfo.sh.hib.dao;


import org.hibernate.Session;
import com.sunbeaminfo.sh.hib.entity.Emp;
import com.sunbeaminfo.sh.hib.entity.util.HbUtil;

public class DeptEmpDao {

	public Emp getEmpById(int empId) {
		Session session = HbUtil.getSession();
		return session.get(Emp.class, empId);
	}
}
