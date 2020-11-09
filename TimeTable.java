package com.railway.org;
import java.util.List;
import java.util.ArrayList;
import java.time.*;
public class TimeTable {
	
	public List<Connection> t_table;
	
	public void addConnection(Connection c) {
		t_table.add(c);
	}
	
	public TimeTable() {
		t_table = new ArrayList<Connection>();
	}
	
	// search for a specific connection 
	public Connection findConnection(LocalDate date, LocalTime time, Station origin, Station destination) throws ConnectionNotFoundException {
		boolean response = false; // initial guess
		Connection connection = null;
		
		for(Connection entry : t_table) {
			response = true; // initial guess 			
			if(!date.isEqual(entry.getDate())) {
				response = false;
			}
			else if(time.compareTo(entry.getTime())!=0) {
				response = false;
			}
			else if(origin.getStationName()!=entry.getOrigin().getStationName()) {
				response = false;
			}
			else if(destination.getStationName()!=entry.getDestination().getStationName()){
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
		if(response==false)
			throw new ConnectionNotFoundException(); 
		return connection;
	}
}
