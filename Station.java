package com.railway.org;

import java.util.List;
import java.util.ArrayList;

public class Station {
	private int stationID;
	private String stationName; 
	
	public Station(int id, String name) {
		this.stationID = id;
		this.stationName = name;
	}
	
	public int getStationID() {
		return this.stationID;
	}
	
	public String getStationName() {
		return this.stationName;
	}
}
