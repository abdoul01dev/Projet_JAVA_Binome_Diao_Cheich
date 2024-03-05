package application;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import DataBase.LigneDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import metiers.Ligne;
import outils.Outils;
import javafx.scene.control.TableColumn;

public class TrajetController implements Initializable {
	private ObservableList<Ligne> listeLigne= FXCollections.observableArrayList();
	private Ligne ligneCourente=null;
	@FXML
	private TableView<Ligne> tableLinge;
	@FXML
	private TableColumn<Ligne,Long> col_id;
	@FXML
	private TableColumn<Ligne,String> col_ville;
	@FXML
	private Button btnModif;
	@FXML
	private Button btnSupprime;
	@FXML
	private Button btnvalide;
	@FXML
	private Button btnfermer;
	@FXML
	private TextField nomVille;
	
	LigneDAO ligneDAO=new LigneDAO();

	// Event Listener on Button[#btnModif].onAction
	@FXML
	public void modif(ActionEvent event) {
		Ligne ligne=tableLinge.getSelectionModel().getSelectedItem();
		if(ligne!=null) {
			
			if(Outils.confirmer("Voullez-vous vraiment modifier cette ligne.")) {
				ligneCourente=ligne;
				nomVille.setText(ligne.getNom());
				}
			}else {
				Outils.erreur("Veuillez selectinnée une ligne");
			}
	}
	// Event Listener on Button[#btnSupprime].onAction
	@FXML
	public void supprime(ActionEvent event) {
		Ligne ligne=tableLinge.getSelectionModel().getSelectedItem();
		if(ligne!=null) {
			if(Outils.confirmer("Voullez-vous vraiment supprimer cette ligne.")) {
				ligneDAO.delete(ligne);
				listeLigne.remove(ligne);
				Outils.info("Linge supprimée avec succès");
			}
		}else {
			Outils.erreur("Veuillez selectionner une ligne d'abord");
		}
	}
	// Event Listener on Button[#btnvalide].onAction
	@FXML
	public void valider(ActionEvent event) {
		if(nomVille.getText()!=null){
			if(ligneCourente!=null) {
				ligneCourente.setNom(nomVille.getText());
				ligneCourente=ligneDAO.update(ligneCourente);
				if(ligneCourente!=null) {
					int index=tableLinge.getSelectionModel().getSelectedIndex();
					listeLigne.set(index, ligneCourente);
					ligneCourente=null;
					Outils.info("Ligne modifiée avec succès");
				}
			}else {
				Ligne ligne=new Ligne(null, nomVille.getText());
				ligne=ligneDAO.create(ligne);
				listeLigne.add(ligne);
				if(ligne!=null)
					Outils.info("Ligne ajoutée avec succès");
			}
			nomVille.setText(null);
		}else {
			Outils.erreur("Veillez remplir le champ trajet");
		}
	}
	// Event Listener on Button[#btnfermer].onAction
	@FXML
	public void fermer(ActionEvent event) {
		if(Outils.confirmer("Voullez vous vraiment fermer cette fenetre?")) {
			Stage stage=(Stage)btnfermer.getScene().getWindow();
			stage.close();
		}
			
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
		col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
		col_ville.setCellValueFactory(new PropertyValueFactory<>("nom"));
		
		ResultSet result=ligneDAO.findAll();
		try {
			while(result.next()) {
				Ligne ligne=ligneDAO.find(result.getLong("ID_ligne"));
				if(ligne!=null)
					listeLigne.add(ligne);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(listeLigne!=null)
			tableLinge.setItems(listeLigne);
		
	}
}
