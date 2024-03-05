package metiers;

import java.sql.Date;

public class Utilisateur {
	private Long id;
	private String mail;
	private String nomUt;
	private String motdepasse;
	private Long idgroupeUt=1l;
	private String groupeUt;
	private String statut="innactif";
	private Integer codeStatut;
	private String dteCreation;
	public Utilisateur() {
	}
	public Utilisateur(Long id, String nomUt,String mail,String motdepasse,Long idgroup,Integer codeStatut ,String dtCreation) {
		super();
		this.id = id;
		this.mail = mail;
		this.nomUt=nomUt;
		this.motdepasse=motdepasse;
		this.setIdgroupeUt(idgroup);
		this.codeStatut=codeStatut;
		this.setDteCreation(dtCreation);
	}
	public Utilisateur(Long id,  String nomUt,String mail,String motdepasse) {
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
		return getNomUt();
	}
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	public String getDteCreation() {
		return dteCreation;
	}
	public void setDteCreation(String date) {
		this.dteCreation = date;
	}
	public Long getIdgroupeUt() {
		return idgroupeUt;
	}
	public void setIdgroupeUt(Long idgroupeUt) {
		this.idgroupeUt = idgroupeUt;
	}
	public String getGroupeUt() {
		return groupeUt;
	}
	public void setGroupeUt(String groupeUt) {
		this.groupeUt = groupeUt;
	}
	public Integer getCodeStatut() {
		return codeStatut;
	}
	public void setCodeStatut(Integer codeStatut) {
		this.codeStatut = codeStatut;
	}
	
}
