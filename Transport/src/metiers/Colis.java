package metiers;

public class Colis {
	private Long id;
	private int type;
	private String dateRecep;
	private String dateSortie;
	private String description;
	private Double valeur;
	private Peseonne expediteur;
	private Peseonne destinataire;
	public Colis(Long id, int type, String dateRecep, String dateSortie, String description, Double valeur,
			Peseonne expediteur, Peseonne destinataire) {
		super();
		this.id = id;
		this.type = type;
		this.dateRecep = dateRecep;
		this.dateSortie = dateSortie;
		this.description = description;
		this.valeur = valeur;
		this.expediteur = expediteur;
		this.destinataire = destinataire;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getDateRecep() {
		return dateRecep;
	}
	public void setDateRecep(String dateRecep) {
		this.dateRecep = dateRecep;
	}
	public String getDateSortie() {
		return dateSortie;
	}
	public void setDateSortie(String dateSortie) {
		this.dateSortie = dateSortie;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getValeur() {
		return valeur;
	}
	public void setValeur(Double valeur) {
		this.valeur = valeur;
	}
	public Peseonne getExpediteur() {
		return expediteur;
	}
	public void setExpediteur(Peseonne expediteur) {
		this.expediteur = expediteur;
	}
	public Peseonne getDestinataire() {
		return destinataire;
	}
	public void setDestinataire(Peseonne destinataire) {
		this.destinataire = destinataire;
	}

}
