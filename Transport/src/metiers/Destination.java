package metiers;

import javafx.collections.ObservableList;

public class Destination {
	private Long id ;
	private String nomDestination;
	private Double distance;
	private String ligne;
	private Long idLigne;
	private ObservableList<Depart> lesDaparts=null;
	private ObservableList<Billet> lesBillet=null;
	public Destination(Long id, String nomDestination, Double distance) {
		super();
		this.id = id;
		this.nomDestination = nomDestination;
		this.distance = distance;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNomDestination() {
		return nomDestination;
	}
	public void setNomDestination(String nomDestination) {
		this.nomDestination = nomDestination;
	}
	public Double getDistance() {
		return distance;
	}
	public void setDistance(Double distance) {
		this.distance = distance;
	}
	public String toString() {
		return nomDestination;
		
	}
	public ObservableList<Depart> getLesDaparts() {
		return lesDaparts;
	}
	public void setLesDaparts(ObservableList<Depart> lesDaparts) {
		this.lesDaparts = lesDaparts;
	}
	public ObservableList<Billet> getLesBillet() {
		return lesBillet;
	}
	public void setLesBillet(ObservableList<Billet> lesBillet) {
		this.lesBillet = lesBillet;
	}
	public String getLigne() {
		return ligne;
	}
	public void setLigne(String ligne) {
		this.ligne = ligne;
	}
	public Long getIdLigne() {
		return idLigne;
	}
	public void setIdLigne(Long idLigne) {
		this.idLigne = idLigne;
	}
	

}
