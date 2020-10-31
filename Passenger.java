package com.railway.org;

public class Passenger {
	private String Name;
	private String phoneNo;
	
	public Passenger(String name, String phoneNo) {
		this.Name = name;
		this.phoneNo = phoneNo;
	}
	
	public String getName() {
		return this.Name;
	}
	
	public String getPhoneNo() {
		return this.phoneNo;
	}
}
