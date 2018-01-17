package mcr.model;

import java.time.LocalDate;

public class User extends Person{
	
	private int id;
	
	private String email;
	
	private String password;
	
	private LocalDate birthdate;
	
	

	public User() {
		super();
	}

	public User(Person person, String email, String password, LocalDate birthdate) {
		super(person.getName(), person.getLastname(), person.getRole());
		this.email = email;
		this.password = password;
		this.birthdate = birthdate;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public LocalDate getBirthdate() {
		return birthdate;
	}



	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}
	
}
