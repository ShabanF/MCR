package mcr.model;

public class Rezervation {
	
	private int id;
	
	private Event event;
	
	private Person person;
	
	private Seat seat;

	public Rezervation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Rezervation(Event event, Person person, Seat seat) {
		super();
		this.event = event;
		this.person = person;
		this.seat = seat;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Seat getSeat() {
		return seat;
	}

	public void setSeat(Seat seat) {
		this.seat = seat;
	}

}
