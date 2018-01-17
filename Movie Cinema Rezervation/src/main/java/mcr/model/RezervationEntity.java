package mcr.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="rezervation")
public class RezervationEntity {
	
	@Id @GeneratedValue
	@Column(name="id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name="event_id")
	private EventEntity event;
	
	@ManyToOne
	@JoinColumn(name="person_id")
	private PersonEntity person;
	
	@Column(name="seat_nr")
	private int seatNumber;

	public RezervationEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RezervationEntity(EventEntity event, PersonEntity person, Seat seat) {
		super();
		this.event = event;
		this.person = person;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public EventEntity getEvent() {
		return event;
	}

	public void setEvent(EventEntity event) {
		this.event = event;
	}

	public PersonEntity getPerson() {
		return person;
	}

	public void setPerson(PersonEntity person) {
		this.person = person;
	}
}
