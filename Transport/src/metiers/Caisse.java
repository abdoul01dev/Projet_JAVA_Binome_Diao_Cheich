package metiers;

public class Caisse {

	private Long id;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getJustification() {
		return justification;
	}
	public void setJustification(String justification) {
		this.justification = justification;
	}
	public String getResponsable() {
		return responsable;
	}
	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}
	public Double getMontant() {
		return montant;
	}
	public void setMontant(Double montant) {
		this.montant = montant;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	private String date;
	private String justification;
	private String responsable;
	private Double montant;
	private int code;
	public Caisse(Long id, String date, String justification, String responsable, Double montant, int code) {
		super();
		this.id = id;
		this.date = date;
		this.justification = justification;
		this.responsable = responsable;
		this.montant = montant;
		this.code = code;
	}
	
}
