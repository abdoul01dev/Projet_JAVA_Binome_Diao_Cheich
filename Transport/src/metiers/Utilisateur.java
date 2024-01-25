package metiers;

public class Utilisateur {
	private Long id;
	private String mail;
	private String nomUt;
	private String motdepasse;
	private String groupeUt;
	private String statut;
	public Utilisateur() {
	}
	public Utilisateur(Long id,String mail, String nomUt,String motdepasse,String group,String statut) {
		super();
		this.mail = mail;
		this.nomUt=nomUt;
		this.motdepasse=motdepasse;
		this.groupeUt=group;
		this.setStatut(statut);
	}
	public Utilisateur(Long id, String mail, String nomUt,String motdepasse) {
		super();
		this.id = id;
		this.mail = mail;
		this.nomUt=nomUt;
		this.motdepasse=motdepasse;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getId() {
		return id;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getNomUt() {
		return nomUt;
	}
	public void setNomUt(String nom) {
		this.nomUt = nom;
	}
	public String getMotdepasse() {
		return motdepasse;
	}
	public void setMotdepasse(String motdepasse) {
		this.motdepasse = motdepasse;
	}
	@Override
	public String toString() {
		return "Utilisateur [id=" + id + ", mail=" + mail + ", nom=" + nomUt + ", motdepasse="
				+ motdepasse + "]";
	}
	public String getGroupeUt() {
		return groupeUt;
	}
	public void setGroupeUt(String groupeUt) {
		this.groupeUt = groupeUt;
	}
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	
}
