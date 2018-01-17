package mcr.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="person")
public class PersonEntity {
	
	@Id @GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="lastname")
	private String lastname;
	
	@ManyToOne
	@JoinColumn(name="role_id")
	private RoleEntity role;

	public PersonEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PersonEntity(String name, String lastname, RoleEntity role) {
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

	public RoleEntity getRole() {
		return role;
	}

	public void setRole(RoleEntity role) {
		this.role = role;
	}
	
}
