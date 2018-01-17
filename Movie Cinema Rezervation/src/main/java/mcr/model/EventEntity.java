package mcr.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="event")
public class EventEntity {
	
	@Id @GeneratedValue
	@Column(name="id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name="movie_id")
	private MovieEntity movie;
	
	@Column(name="time")
	private LocalDateTime startTime;
	
	@ManyToOne
	@JoinColumn(name="monitor_id")
	private MonitorEntity monitor;

	public EventEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EventEntity(MovieEntity movie, LocalDateTime startTime, MonitorEntity monitor) {
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

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}
	
}
