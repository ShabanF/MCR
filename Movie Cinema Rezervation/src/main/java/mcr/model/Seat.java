package mcr.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="seat")
public class Seat {
	
	private int seatNumber;
	
	private boolean free;

	public Seat() {
		super();
		this.free = true;
		// TODO Auto-generated constructor stub
	}

	public int getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}

	public boolean isFree() {
		return free;
	}

	public void setFree(boolean free) {
		this.free = free;
	}

}
