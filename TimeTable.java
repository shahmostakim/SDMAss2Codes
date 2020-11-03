package com.railway.org;
import java.util.List;
import java.util.ArrayList;
import java.time.*;
public class TimeTable {
	
	private List<Connection> t_table = new ArrayList<Connection>();
	
	public TimeTable() {
		// TimeTable is a List of all the connection objects
		// create all the connection objects and initialize the list 
		
		// create few stations  
		Station peel = new Station(1, "peel");
		Station mcGill = new Station(2, "mcGill");
		Station uqam = new Station(3, "uqam");
		Station parc = new Station (4, "parc");
		Station angrignon = new Station(5, "angrignon");
		Station monk = new Station(6, "monk");
		
		// create connections
		Connection c1 = new Connection();
		c1.origin = peel;
		c1.destination = monk;
		c1.date = LocalDate.parse("2021-02-20");
		c1.time = LocalTime.parse("06:30");
		t_table.add(c1);
		
		Connection c2 = new Connection();
		c2.origin = uqam;
		c2.destination = parc;
		c2.date = LocalDate.parse("2021-02-21");
		c2.time = LocalTime.parse("05:30");
		t_table.add(c2);
		
		Connection c3 = new Connection();
		c3.origin = mcGill;
		c3.destination = angrignon;
		c3.date = LocalDate.parse("2021-02-21");
		c3.time = LocalTime.parse("06:30");
		t_table.add(c3);
		
		System.out.println("TimeTable is created");
		
		// printing all timetable entries 
		System.out.println("---Printing all the connections---");
		for(Connection entry : t_table) {
			System.out.println("connection "+entry.origin.getStationName()+" to "+entry.destination.getStationName()+" created");
		}
		
	}
	
	// search for a specific connection 
	public Connection findConnection(LocalDate date, LocalTime time, Station origin, Station destination) {
		boolean response = true; // initial guess
		Connection connection = null;
		
		for(Connection entry : t_table) {
			response = true; // initial guess 
			//System.out.println("=> comparing input origin "+origin.getStationName()+" with timetable "+entry.origin.getStationName());
			
			if(!date.isEqual(entry.date)) {
				//System.out.println("date did not match");
				response = false;
			}
			else if(time.compareTo(entry.time)!=0) {
				//System.out.println("time did not match");
				response = false;
			}
			else if(origin.getStationName()!=entry.origin.getStationName()) {
				//System.out.println("origin did not match");
				response = false;
			}
			else if(destination.getStationName()!=entry.destination.getStationName()){
				//System.out.println("destination did not match");
				response = false;
			}
			
			// check flag status before going to next iteration
			// if still response=true then we got the connection so now end searching 
			if(response==true) {
				//System.out.println("--Connection found for the given criteria!--");
				connection = entry;
				break;
			}
		}
		
		return connection;
	}
}
