package metiers;

public class Billet {
	private Long id;
	private String titre;
	private String prix;
	private Long idDestination;
	public Billet(Long id, String titre, String prix, Long idDestination) {
		super();
		this.id = id;
		this.titre = titre;
		this.prix = prix;
		this.idDestination = idDestination;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getPrix() {
		return prix;
	}
	public void setPrix(String prix) {
		this.prix = prix;
	}
	public Long getIdDestination() {
		return idDestination;
	}
	public void setIdDestination(Long idDestination) {
		this.idDestination = idDestination;
	}
	@Override
	public String toString() {
		return getTitre();
	}
	
}
