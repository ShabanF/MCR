package mcr.model;

public class Seat {
	
	private int id;
	
	private int row;
	
	private int seatNr;
	
	private Monitor monitor;

	public Seat() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Seat(int row, int seatNr, Monitor monitor) {
		super();
		this.row = row;
		this.seatNr = seatNr;
		this.monitor = monitor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getSeatNr() {
		return seatNr;
	}

	public void setSeatNr(int seatNr) {
		this.seatNr = seatNr;
	}

	public Monitor getMonitor() {
		return monitor;
	}

	public void setMonitor(Monitor monitor) {
		this.monitor = monitor;
	}
	
	

}
