package com.sunbeaminfo.sh.hib.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Vehicle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	int vehicleid;
	
	@Column
	String vehiclename;

	@OneToOne(mappedBy="vehicle", cascade=CascadeType.ALL) // combi 2
	// @PrimaryKeyJoinColumn // -combi 1
	User usr;
	
	public int getVehicleid() {
		return vehicleid;
	}

	public void setVehicleid(int vehicleid) {
		this.vehicleid = vehicleid;
	}

	public String getVehiclename() {
		return vehiclename;
	}

	public void setVehiclename(String vehiclename) {
		this.vehiclename = vehiclename;
	}
	
	public User getUsr() {
		return usr;
	}

	@Override
	public String toString() {
		return "Vehicle [vehicleid=" + vehicleid + ", vehiclename=" + vehiclename + "]";
	}
	
	
}
