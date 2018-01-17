package mcr.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="genre")
public class GenreEntity {
	
	@Id @GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;

	public GenreEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GenreEntity(String name) {
		super();
		this.name = name;
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

}
