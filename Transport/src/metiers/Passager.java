package metiers;



public class Passager extends Peseonne{
	private String typeBillet;
	private Long idDestination;
	private Double montant;
	private String codeDepart;
	private Long depart;
	private Long idBillet;
	private String date;
	private String destination;
	private String heure;
	private Integer etat=1;
	private Integer typePassager;
	private String etatR;
	private String code;
	public Passager(Long id, String nom, String prenom, String sexe, Integer age, String numTel, Long idBillet,
			Long destination, Double montant, Long depart, String date) {
		super(id, nom, prenom, sexe, age, numTel);
		this.idBillet =idBillet;
		this.idDestination = destination;
		this.montant = montant;
		this.depart = depart;
		this.date = date;
	}
	//constructeur basé sur le précedent pour prendre en compte la reservation
	//public Passager()
	public String getTypeBillet() {
		return typeBillet;
	}
	public void setTypeBillet(String typeBillet) {
		this.typeBillet = typeBillet;
	}
	public String getDestination() {
		return destination;
	}
	public void setIDdestination(Long destination) {
		this.idDestination = destination;
	}
	public Double getMontant() {
		return montant;
	}
	public void setMontant(Double montant) {
		this.montant = montant;
	}
	public String getCodeDepart() {
		return codeDepart;
	}
	public void setCodeDepart(String codeDepart) {
		this.codeDepart = codeDepart;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Long getDepart() {
		return depart;
	}
	public void setDepart(Long depart) {
		this.depart = depart;
	}
	public Long getIdBillet() {
		return idBillet;
	}
	public void setIdBillet(Long idBillet) {
		this.idBillet = idBillet;
	}
	public Long getIdDestination() {
		return idDestination;
	}
	public void setIdDestination(Long idDestination) {
		this.idDestination = idDestination;
	}
	public String getHeure() {
		return heure;
	}
	public void setHeure(String heure) {
		this.heure = heure;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public Integer getEtat() {
		return etat;
	}
	public void setEtat(Integer etat) {
		this.etat = etat;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getEtatR() {
		return etatR;
	}
	public void setEtatR(String etatR) {
		this.etatR = etatR;
	}
	public Integer getTypePassager() {
		return typePassager;
	}
	public void setTypePassager(Integer typePassager) {
		this.typePassager = typePassager;
	}
	
}
