package com.sunbeaminfo.sh.hib.entity.main;

import java.util.ArrayList;
import java.util.List;

import com.sunbeaminfo.sh.hib.dao.DeptEmpDao;
import com.sunbeaminfo.sh.hib.entity.Dept;
import com.sunbeaminfo.sh.hib.entity.Emp;
import com.sunbeaminfo.sh.hib.entity.util.HbUtil;

public class Hib4Main {
	public static void main(String[] args) {
		// Delete employees and department
		/*try {
			DeptEmpDao dao = new DeptEmpDao();
			HbUtil.beginTransaction();
			Dept d = dao.getDeptById(60);
			if(d == null)
				System.out.println("Dept Not Avail.");
			else {
				System.out.println(d);
				dao.delDept(d);
			}
			HbUtil.commitTransaction();
		} catch (Exception e) {
			HbUtil.rollbackTransaction();
		}*/
		
		// Add department along with employee
		/*try {
			DeptEmpDao dao = new DeptEmpDao();
			HbUtil.beginTransaction();
			
			Dept d = new Dept(60, "Security", "Kashmir");
			
			List<Emp> el = new ArrayList<Emp>();
			el.add(new Emp(100, "A", 10000, 60));
			el.add(new Emp(200, "B", 20000, 60));
			el.add(new Emp(300, "C", 30000, 60));
			
			d.setEmpList(el);
			
			dao.addDept(d);
			
			HbUtil.commitTransaction();
		} catch (Exception e) {
			HbUtil.rollbackTransaction();
		}*/
		
		// Merge department and employees
		
		try {
			DeptEmpDao dao = new DeptEmpDao();
			HbUtil.beginTransaction();
			
			Dept d = new Dept(60, "Security", "Mumbai");
			
			List<Emp> el = new ArrayList<Emp>();
			el.add(new Emp(100, "A", 10000, 60));
			el.add(new Emp(200, "B", 20000, 60));
			el.add(new Emp(300, "C", 30000, 60));
			el.add(new Emp(400, "D", 40000, 60));
			d.setEmpList(el);
			
			dao.mergeDept(d);
			
			HbUtil.commitTransaction();
		} catch (Exception e) {
			HbUtil.rollbackTransaction();
		}
		
		
		/*try {
			DeptEmpDao dao = new DeptEmpDao();
			HbUtil.beginTransaction();
			Dept d = dao.getDeptById(10);
			if(d == null)
				System.out.println("Dept Not Avail.");
			else {
				System.out.println(d);
				for (Emp e : d.getEmpList()) {
					System.out.println(e);
				}
			}
			HbUtil.commitTransaction();
		} catch (Exception e) {
			HbUtil.rollbackTransaction();
		}*/
		
		
		HbUtil.shutdown();
	}
}
