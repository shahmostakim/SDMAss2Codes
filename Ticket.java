package com.railway.org;

public class Ticket {
	private Passenger passenger;
	private Connection connection;
	
	/* *** setters are replaced by create(passenger, connection) method
	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}
	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	*/ 
	
	public void create(Passenger passenger, Connection connection) {
		this.passenger = passenger;
		this.connection = connection;
	}
	
	public Passenger getPassenger() {
		return passenger;
	}
	public Connection getConnection() {
		return connection;
	}
	
}
