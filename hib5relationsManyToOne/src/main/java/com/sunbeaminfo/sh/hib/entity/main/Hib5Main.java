package com.sunbeaminfo.sh.hib.entity.main;


import com.sunbeaminfo.sh.hib.dao.DeptEmpDao;
import com.sunbeaminfo.sh.hib.entity.Emp;
import com.sunbeaminfo.sh.hib.entity.util.HbUtil;

public class Hib5Main {
	public static void main(String[] args) {
		try {
			DeptEmpDao dao = new DeptEmpDao();
			HbUtil.beginTransaction();
			Emp e = dao.getEmpById(100);
			if (e == null) {
				System.out.printf("Employee with %d id is not found", 100);
			} else {
				System.out.println(e);
				System.out.println(e.getDept1());
			}
			HbUtil.commitTransaction();
		} catch (Exception e) {
			HbUtil.rollbackTransaction();
		}

		HbUtil.shutdown();
	}
}
