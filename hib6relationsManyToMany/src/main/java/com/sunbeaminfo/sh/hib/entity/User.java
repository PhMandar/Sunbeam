package com.sunbeaminfo.sh.hib.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column
	int userId;
	
	@Column
	String userName;
	
	@OneToOne/*(mappedBy="usr", cascade=CascadeType.ALL)*/ // Combi 1
	@PrimaryKeyJoinColumn // combi 2
	private Vehicle vehicle;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}
	
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}	
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + "]";
	}
}