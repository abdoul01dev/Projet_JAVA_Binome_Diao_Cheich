package metiers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Ligne {
	private Long id;
	private String nom;
	private ObservableList<Depart> listDepart=FXCollections.observableArrayList();
	
	public Ligne(Long id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
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
	@Override
	public String toString() {
		return   nom ;
	}
	public ObservableList<Depart> getListDepart() {
		return listDepart;
	}
	public void setListDepart(ObservableList<Depart> listDepart) {
		this.listDepart = listDepart;
	}
	
	
}
