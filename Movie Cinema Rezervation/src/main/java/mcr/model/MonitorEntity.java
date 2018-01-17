package mcr.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="monitor")
public class MonitorEntity {
	
	@Id @GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;

	public MonitorEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MonitorEntity(String name) {
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
