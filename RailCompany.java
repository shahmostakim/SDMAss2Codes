package com.railway.org;

public class RailCompany {
	public static void makeBooking(Passenger passenger, Connection connection) {
		//System.out.println("Passenger: "+passenger.getName());
		//System.out.println("Destination: "+connection.destination.getStationName());
		Tickets.makeTicket(passenger, connection);
	}
}
