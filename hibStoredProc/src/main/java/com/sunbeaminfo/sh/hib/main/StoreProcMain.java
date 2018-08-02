package com.sunbeaminfo.sh.hib.main;

import java.util.List;

import com.sunbeaminfo.sh.hib.dao.EmpDao;
import com.sunbeaminfo.sh.hib.entity.Emp;
import com.sunbeaminfo.sh.hib.util.HbUtil;

/***
 * Calling following stored procedures : 1. With in parameter
 * 
 * DELIMITER $$ CREATE PROCEDURE SP_EMPLOYEE_By_SALGT(IN p_sal double) BEGIN
 * SELECT `EMPNO`, `ENAME`, `SAL`, `DEPTNO` FROM `employee` WHERE `SAL` >=
 * p_sal; END $$ DELIMITER ;
 *
 */

public class StoreProcMain {
	public static void main(String[] args) {
		callNamedInQuery();
	}

	private static void callNamedInQuery() {
		try {
			HbUtil.beginTransaction();
			getAllEmpsWithGreaterSal();
			// System.out.println("Number of updated employees : " + updateEmp(100, 40000, 10));
			HbUtil.commitTransaction();
		} catch (Exception ex) {
			ex.printStackTrace();
			HbUtil.rollbackTransaction();
		} finally {
			HbUtil.shutdown();
		}
	}

	private static int updateEmp(int empNo, int sal, int deptNo) {
		return EmpDao.updateEmp(empNo, sal, deptNo);
	}

	private static void getAllEmpsWithGreaterSal() {
		List<Emp> lstEmployees = EmpDao.getAllEmpsBySalary(444.44); 
		for(Emp objEmp : lstEmployees) {
			System.out.println(objEmp);
		}
	}
}
