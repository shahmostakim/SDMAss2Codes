package com.railway.org;

public class Station {
	private int stationID;
	private String stationName;
	
	public Station(int stationID, String stationName) {
		this.stationID = stationID;
		this.stationName = stationName;
	}
	
	public int getStationID() {
		return this.stationID;
	}
	
	public String getStationName() {
		return this.stationName;
	}
}
