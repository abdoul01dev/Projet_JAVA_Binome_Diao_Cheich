package metiers;

public class Recu {
	private Long id;
	private String nom;
	private Double montant;
	private Long idDest; 
	private String destination;
	public Recu(Long id, String nom, Double montant,Long idDest) {
		super();
		this.id = id;
		this.nom = nom;
		this.montant = montant;
		this.setIdDest(idDest);
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Double getMontant() {
		return montant;
	}
	public void setMontant(Double montant) {
		this.montant = montant;
	}
	public Long getIdDest() {
		return idDest;
	}
	public void setIdDest(Long idDest) {
		this.idDest = idDest;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	
}
