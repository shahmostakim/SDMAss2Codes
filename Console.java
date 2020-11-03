package com.railway.org;
import java.time.*;
import com.railway.org.Passenger;
public class Console {
	
	static TimeTable t;
	
	public static void main(String[ ] args) {
		t = new TimeTable(); // creates timetable (list) of connections 
		
		// initialize required data for a new booking search for the passenger
		Passenger passenger = new Passenger("shakil","438-560-9981");
		LocalDate date = LocalDate.parse("2021-02-21");
		LocalTime departure = LocalTime.parse("05:30");
		Station origin = new Station(3, "uqam");
		Station destination = new Station(4, "parc");
		
		// search for the connection 
		Connection connection = makeNewBooking(passenger, date, departure, origin, destination);
		
	}
	
	static Connection makeNewBooking(Passenger passenger, LocalDate date, LocalTime departure, Station origin, Station destination) {
		
		Connection connection = t.findConnection(date, departure, origin, destination);
		
		// checks if connection was found  
		if(connection!=null) {
			System.out.println("connection found!");
			System.out.println("Creating tickets");
			return connection;
		}
		else {
			System.out.println("connection not found");
			System.out.println("Executing failure scenario");
			return null;
		}
		
			
	}
}
