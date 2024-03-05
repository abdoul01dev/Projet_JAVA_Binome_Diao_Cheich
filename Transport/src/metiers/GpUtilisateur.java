package metiers;

public class GpUtilisateur {
	Long id;
	String role;
	String description;
	public GpUtilisateur(Long id, String role, String description) {
		super();
		this.id = id;
		this.role = role;
		this.description = description;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return  role ;
	}
	
}
