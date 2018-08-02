package com.sunbeaminfo.sh.hib.entity.main;

import org.hibernate.Session;

import com.sunbeaminfo.sh.hib.entity.Vehicle;
import com.sunbeaminfo.sh.hib.entity.util.HbUtil;

/**
 * Involved tables are user and vehicle
 * */

public class OneToOneMain {

	public static void main(String[] args) {
		try {
			HbUtil.beginTransaction();
			Session session = HbUtil.getSession();
			/* // Combi 1
			User usr = session.get(User.class, 2);
			System.out.println(usr);
			
			System.out.println(usr.getVehicle());*/
			
			// Combi 2
			Vehicle vehicle = session.get(Vehicle.class, 2);
			System.out.println(vehicle);
			System.out.println(vehicle.getUsr());
			
			HbUtil.commitTransaction();
		}catch(Exception ex) {
			HbUtil.rollbackTransaction();
		}
		
		HbUtil.shutdown();
		
	}

}
