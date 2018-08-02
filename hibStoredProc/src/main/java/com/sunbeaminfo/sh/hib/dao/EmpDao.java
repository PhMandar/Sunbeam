package com.sunbeaminfo.sh.hib.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import com.sunbeaminfo.sh.hib.entity.Emp;
import com.sunbeaminfo.sh.hib.util.HbUtil;

public class EmpDao {

	public static List<Emp> getAllEmpsBySalary(double d) {
		Session session = HbUtil.getSession();
		NativeQuery<Emp> query = session.getNamedNativeQuery("spEmpBySal");
		query.setParameter("pSal", d);
		return query.getResultList();
	}

	// :pEmpId, :pSal, :pDeptNo
	public static int updateEmp(int empNo, double sal, int deptNo) {
		Session session = HbUtil.getSession();
		NativeQuery<Emp> query = session.getNamedNativeQuery("spUpdateEmp");
		query.setParameter("pEmpId", empNo);
		query.setParameter("pDeptNo", deptNo);
		query.setParameter("pSal", sal);
		return query.executeUpdate();
	}
	
	

}
