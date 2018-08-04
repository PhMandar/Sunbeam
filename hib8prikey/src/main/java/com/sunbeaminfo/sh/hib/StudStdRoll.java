package com.sunbeaminfo.sh.hib;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Embeddable
public class StudStdRoll implements Serializable{
	private static final long serialVersionUID = 1L;

	@Column
	int std;
	
	// Can we do something like following : Among Composite key one key is getting auto incremented
	/* @GeneratedValue(generator="gen", strategy=GenerationType.IDENTITY) */
	@Column
	int roll;

	public StudStdRoll() {}
	
	public StudStdRoll(int std, int roll) {
		this.std = std;
		this.roll = roll;
	}

	public int getStd() {
		return std;
	}

	public void setStd(int std) {
		this.std = std;
	}

	public int getRoll() {
		return roll;
	}

	public void setRoll(int roll) {
		this.roll = roll;
	}

	
}
