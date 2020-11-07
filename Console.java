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
		boolean connectionFound = makeNewBooking2(passenger, date, departure, origin, destination);
		
	}
	
	static boolean makeNewBooking(Passenger passenger, LocalDate date, LocalTime departure, Station origin, Station destination) {
		
		Connection connection = t.findConnection(date, departure, origin, destination);
		
		// checks if connection was found  
		if(connection!=null) {
			System.out.println("connection found!");
			System.out.println("Creating tickets...");
			
			// execution of ticket creation process 
			RailCompany.makeBooking(passenger, connection);
			
			// print all the tickets created so far
			for(Ticket t : Tickets.ticketList) {
				System.out.println("Ticket issued for passenger: "+t.getPassenger().getName()+" for station "+connection.origin.getStationName()+" to station "+connection.destination.getStationName());
			}
			return true;
		}
		else {
			System.out.println("No connection available for user. Please try another search...");
			System.out.println("Executing failure scenario...");
			return false;
		}
			
	}
	
	// alternate implementation with try catch 
	static boolean makeNewBooking2(Passenger passenger, LocalDate date, LocalTime departure, Station origin, Station destination) {
		
		Connection connection = t.findConnection(date, departure, origin, destination);
		
		try {
			Station startingPoint = connection.origin; // if connection is null it should throw exception
			
			System.out.println("connection found!");
			System.out.println("Creating tickets...");
			
			// execution of ticket creation process 
			RailCompany.makeBooking(passenger, connection);
			
			// print all the tickets created so far
			for(Ticket t : Tickets.ticketList) {
				//System.out.println("Ticket issued for passenger: "+t.getPassenger().getName());
				System.out.println("Ticket issued for passenger: "+t.getPassenger().getName()+" for station "+connection.origin.getStationName()+" to station "+connection.destination.getStationName());
			}
			return true;
			
		}catch(Exception e) {
			System.out.println("No connection available for user. Please try another search...\"");
			System.out.println("Executing failure scenario...");
			return false;
		}
 
	}
}
