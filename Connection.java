package com.railway.org;
import java.time.*;
import com.railway.org.Station;
public class Connection {
	
	private Station origin;
	private Station destination;
	private LocalDate date;
	private LocalTime time;
	
	public Connection(Station origin, Station destination, LocalDate date, LocalTime time) {
		this.origin = origin;
		this.destination = destination;
		this.date = date;
		this.time = time;
	}

	public Station getOrigin() {
		return this.origin;
	}

	public Station getDestination() {
		return this.destination;
	}

	public LocalDate getDate() {
		return this.date;
	}

	public LocalTime getTime() {
		return this.time;
	}
	
	
}
