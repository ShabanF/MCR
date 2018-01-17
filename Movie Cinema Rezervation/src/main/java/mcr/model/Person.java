package mcr.model;

public class Person {
	
	private int id;
	
	private String name;
	
	private String lastname;
	
	private Role role;

	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Person(String name, String lastname, Role role) {
		super();
		this.name = name;
		this.lastname = lastname;
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	
	
}
