package com.sunbeaminfo.sh.hib.entity.main;

import org.hibernate.Session;

import com.sunbeaminfo.sh.hib.entity.Emp;
import com.sunbeaminfo.sh.hib.entity.Meeting;
import com.sunbeaminfo.sh.hib.entity.util.HbUtil;

public class Hib6Main {
	public static void main(String[] args) {
		try {
			Session session = HbUtil.getSession();
			HbUtil.beginTransaction();
			/* Emp e = session.get(Emp.class, 7934);
			System.out.println(e);
			
			for (Meeting m : e.getMeetingList()) 
				System.out.println(m);*/
			
			
			Meeting m = session.get(Meeting.class, 1);
			System.out.println(m);
			
			for(Emp e : m.getEmpList()) {
				System.out.println(e);
			}
			
			HbUtil.commitTransaction();
			
		} catch (Exception e) {
			e.printStackTrace();
			HbUtil.rollbackTransaction();
		}finally {
			HbUtil.shutdown();
		}
	}
}