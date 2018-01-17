package mcr.model;

public class Client extends User{
	
	private int id;
	
	private int capital;

	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Client(User user, int capital) {
		super((Person) user, user.getEmail(), user.getPassword(), user.getBirthdate());
		this.capital = capital;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCapital() {
		return capital;
	}

	public void setCapital(int capital) {
		this.capital = capital;
	}
	
}
