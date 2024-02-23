package metiers;

public class Colis {
	private Long id;
	private String code;
	private int type;
	private String dateRecep;
	private String dateSortie;
	private String description;
	private Double valeur;
	private Double cout;
	private Peseonne expediteur;
	private Peseonne destinataire;
	private long idDepart;
	private long idDestination;
	private String destination;
	private Double frais;
	public Colis(Long id, String code ,int type, String dateRecep, String dateSortie, String description, Double valeur,
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
		this.code=code;
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
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Double getCout() {
		return cout;
	}
	public void setCout(Double cout) {
		this.cout = cout;
	}
	public long getIdDepart() {
		return idDepart;
	}
	public void setIdDepart(long idDepart) {
		this.idDepart = idDepart;
	}
	public long getIdDestination() {
		return idDestination;
	}
	public void setIdDestination(long idDestination) {
		this.idDestination = idDestination;
	}
	public String getNomE() {
		return expediteur.getNom();
	}
	public void setNomE(String nomE) {
		expediteur.setNom(nomE);;
	}
	public String getPrenomE() {
		return expediteur.getPrenom();
	}
	public void setPrenomE(String prenomE) {
		expediteur.setPrenom(prenomE);;
	}
	public String getNumE() {
		return expediteur.getNumTel();
	}
	public void setNumE(String numE) {
		expediteur.setNumTel(numE);;
	}
	public String getRefE() {
		return expediteur.getRef();
	}
	public void setRefE(String refE) {
		expediteur.setRef(refE);
	}
	public String getNomD() {
		return destinataire.getNom();
	}
	public void setNomD(String nomD) {
		destinataire.setNom(nomD);;
	}
	public String getPrenomD() {
		return destinataire.getPrenom();
	}
	public void setPrenomD(String prenomD) {
		destinataire.setPrenom(prenomD);
	}
	public String getNumD() {
		return destinataire.getNumTel();
	}
	public void setNumD(String numD) {
		destinataire.setNumTel(numD);;
	}
	public String getRefD() {
		return destinataire.getRef();
	}
	public void setRefD(String refD) {
		destinataire.setRef(refD);;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public Double getFrais() {
		return frais;
	}
	public void setFrais(Double frais) {
		this.frais = frais;
	}
	
}
