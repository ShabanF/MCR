package mcr.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="client")
public class ClientEntity extends User{
	
	@Id @GeneratedValue
	@Column(name="id_user")
	private int id;
	
	@Column(name="capital")
	private int capital;

	public ClientEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ClientEntity(User user, int capital) {
		super((PersonEntity) user, user.getEmail(), user.getPassword(), user.getBirthdate());
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
