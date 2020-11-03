package com.railway.org;
import java.util.List;
import java.util.ArrayList;
public class Tickets {
	
	public static List<Ticket> ticketList = new ArrayList<Ticket>();
	
	public static void makeTicket(Passenger passenger, Connection connection) {
		Ticket ticket = new Ticket(); // creates a blank ticket without any data
		ticket.create(passenger, connection); // initializes the ticket instance with appropriate data
		ticketList.add(ticket);
		//System.out.println("Ticket issued for customer: "+ticket.getPassenger().getName());
		
	}
}
