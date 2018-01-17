package mcr.model;

public class Role {
	
	private int id;
	
	private String roleName;

	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Role(String roleName) {
		super();
		this.roleName = roleName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	

}
