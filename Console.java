package com.railway.org;
import java.time.*;
import java.util.List;
import java.util.ArrayList;

public class Console {
	
	private TimeTable t;
	private List<Station> allStations;
	
	public static void main(String[ ] args) {
		
		Console console = new Console();
		console.allStations = new ArrayList<Station>();
		console.t = new TimeTable(); // creates empty timetable (list of connections)
		console.initConnectionData(); // initializes timetable
		console.showAvailableConnections();
		
		
		// initialize required data for a new booking search for the passenger
		Passenger passenger = new Passenger("shakil","438-560-9981");
		LocalDate date = LocalDate.parse("2021-02-21");
		LocalTime departure = LocalTime.parse("05:30");
		Station origin = new Station(3, "uqam");
		Station destination = new Station(4, "parc");
	
		// search for the connection 
		System.out.println("\nSearching for connection: "+origin.getStationName()+" to "+destination.getStationName());
		boolean isConnectionFound = console.makeNewBooking(passenger, date, departure, origin, destination);
		
	}
	
	public void showAvailableConnections() {
		// printing all timetable entries 
		System.out.println("---Showing all available connections---");
		for(Connection entry : t.t_table) {
			System.out.println("connection "+entry.getOrigin().getStationName()+" to "+entry.getDestination().getStationName()+" available");
		}
	}
	
	private void initConnectionData() {
		Station peel = new Station(1,"peel");
		Station monk = new Station(6, "monk");
		allStations.add(peel);
		allStations.add(monk);
		LocalDate date = LocalDate.parse("2021-02-20");
		LocalTime time = LocalTime.parse("06:30");
		Connection peelToMonk = new Connection(peel,monk,date,time);
		t.addConnection(peelToMonk);
		
		Station uqam = new Station(3, "uqam");
		Station parc = new Station(4, "parc");
		allStations.add(uqam);
		allStations.add(parc);
		LocalDate date2 = LocalDate.parse("2021-02-21");
		LocalTime time2 = LocalTime.parse("05:30");
		Connection uqamToParc = new Connection(uqam,parc,date2,time2);
		t.addConnection(uqamToParc);
		
		Station mcgill = new Station(2, "mcgill");
		Station angrignon = new Station(5, "angrignon");
		allStations.add(mcgill);
		allStations.add(angrignon);
		LocalDate date3 = LocalDate.parse("2021-02-21");
		LocalTime time3 = LocalTime.parse("06:30");
		Connection mcgillToAngrignon = new Connection(mcgill,angrignon,date3,time3);
		t.addConnection(mcgillToAngrignon);
		
	}
	 
	private boolean makeNewBooking(Passenger passenger, LocalDate date, LocalTime departure, Station origin, Station destination) {
		
		Connection connection = t.findConnection(date, departure, origin, destination);
		
		try {
			Station startingPoint = connection.getOrigin(); // if connection is null it should throw exception
			
			System.out.println("connection found!");
			System.out.println("Creating ticket...");
			
			// execution of ticket creation process 
			RailCompany.makeBooking(passenger, connection);
			
			// print all the tickets created so far
			for(Ticket t : Tickets.ticketList) {
				System.out.println("Ticket issued for passenger: "+t.getPassenger().getName());
				//System.out.println("Ticket issued for passenger: "+t.getPassenger().getName()+" for station "+connection.getOrigin().getStationName()+" to station "+connection.getDestination().getStationName());
			}
			return true;
			
		}catch(Exception e) {
			System.out.println("No connection available for user. Please try another search...\"");
			System.out.println("Executing failure procedure...");
			return false;
		}
 
	}
}
