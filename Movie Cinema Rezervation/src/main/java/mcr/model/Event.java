package mcr.model;

import java.time.LocalDateTime;

public class Event {
	
	private int id;
	
	private Movie movie;
	
	private LocalDateTime startTime;
	
	private Monitor monitor;

	public Event() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Event(Movie movie, LocalDateTime startTime, Monitor monitor) {
		super();
		this.movie = movie;
		this.startTime = startTime;
		this.monitor = monitor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public Monitor getMonitor() {
		return monitor;
	}

	public void setMonitor(Monitor monitor) {
		this.monitor = monitor;
	}
	
}
