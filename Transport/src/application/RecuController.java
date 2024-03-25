package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import metiers.Destination;
import metiers.Recu;
import outils.Outils;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import DataBase.DestinationDAO;
import DataBase.RecuDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.scene.control.ComboBox;

import javafx.scene.control.TableView;

import javafx.scene.control.TableColumn;

public class RecuController implements Initializable {
	ObservableList<Recu> listeRecu=FXCollections.observableArrayList();
	ObservableList<Destination> listeDest=FXCollections.observableArrayList();
	ObservableList<String> listeTitre=FXCollections.observableArrayList();
	Recu recuCourent=null;
	RecuDAO recuDAO=new RecuDAO();
	@FXML
	private TableView<Recu> tableRecu;
	@FXML
	private TableColumn<Recu,Long> col_id;
	@FXML
	private TableColumn<Recu,String> col_ville;
	@FXML
	private TableColumn<Recu,Double> col_titre;
	@FXML
	private TableColumn<Recu,Double> col_montant;
	
	@FXML
	private Button btnModif;
	@FXML
	private Button btnSupprime;
	@FXML
	private Button btnValide;
	@FXML
	private Button btnAnnule;
	@FXML
	private Button btnTarC;
	@FXML
	private Button btnFerme;
	@FXML
	private ComboBox<Destination> comboDest;
	@FXML
	private ComboBox<String> comboTitre;
	@FXML
	private TextField TAR;

	// Event Listener on Button[#btnModif].onAction
	@FXML
	public void modif(ActionEvent event) {
		 recuCourent=tableRecu.getSelectionModel().getSelectedItem();
		 if(recuCourent!=null) {
			 TAR.setText(String.valueOf(recuCourent.getMontant()));
			 comboDest.getSelectionModel().select(new DestinationDAO().find(recuCourent.getIdDest()));
			 comboTitre.getSelectionModel().select(recuCourent.getNom());
		 }else {
				Outils.erreur("Veuillez selectionner une ligne");
			}
	}
	// Event Listener on Button[#btnSupprime].onAction
	@FXML
	public void supprime(ActionEvent event) {
		Recu recu=tableRecu.getSelectionModel().getSelectedItem();
		if(recu!=null) {
			if(Outils.confirmer("Voulez-vous vraiment supprimer ce tarif?")) {
				recuDAO.delete(recu);
				listeRecu.remove(recu);
			}
		}else {
			Outils.erreur("Veuillez selectionner une ligne");
		}
	}
	// Event Listener on Button[#btnValide].onAction
	@FXML
	public void valide(ActionEvent event) {
		if(TAR.getText()!=null&& comboDest.getSelectionModel().getSelectedItem()!=null
				&&comboTitre.getSelectionModel().getSelectedItem()!=null) {
			if(recuCourent!=null) {
				if(Outils.confirmer("Voulez-vous vraiment modifier ce tarif?")) {
					int index=listeRecu.indexOf(recuCourent);
					recuCourent.setIdDest(comboDest.getSelectionModel().getSelectedItem().getId());
					recuCourent.setMontant(Double.parseDouble(TAR.getText()));
					recuCourent.setNom(comboTitre.getSelectionModel().getSelectedItem());
					recuCourent=recuDAO.update(recuCourent);
					listeRecu.set(index, recuCourent);
					Outils.info("Tarif modifié avec succès");
					recuCourent=null;
				}
			}else {
				Recu recu=new Recu(null,comboTitre.getSelectionModel().getSelectedItem(),
						Double.parseDouble(TAR.getText()),comboDest.getSelectionModel().getSelectedItem().getId());
				recu=recuDAO.create(recu);
				if(recu!=null) {
					listeRecu.add(recu);
					Outils.info("Tarif ajouté avec succès");
				}
			}
		}else {
			Outils.erreur("Veuillez selectionner une ligne");
		}
		Annuler(event);
	}
	// Event Listener on Button[#btnAnnule].onAction
	@FXML
	public void Annuler(ActionEvent event) {
		TAR.clear();
		comboDest.getSelectionModel().select(null);
		comboTitre.getSelectionModel().select(null);
		recuCourent=null;
	}
	
	@FXML
	public void fermer(ActionEvent event) {
		if(Outils.confirmer("Voullez vous vraiment fermer cette fenetre?")) {
			Stage stage=(Stage)btnFerme.getScene().getWindow();
			stage.close();
		}
	}
	@FXML
	public void tarC(ActionEvent event) {
		try {
			Parent parent=FXMLLoader.load(getClass().getResource("TarifCourrier.fxml"));
			Scene scene=new Scene(parent,600,450);
			Stage stage=new Stage();
			stage.setScene(scene);
			stage.setTitle("Tarif courrier");
			stage.setResizable(false);
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
		col_ville.setCellValueFactory(new PropertyValueFactory<>("destination"));
		col_titre.setCellValueFactory(new PropertyValueFactory<>("nom"));
		col_montant.setCellValueFactory(new PropertyValueFactory<>("montant"));
		
		ResultSet rs=recuDAO.findAll();
		Recu recu=null;
		try {
			listeRecu.clear();
			while(rs.next()) {
				recu=recuDAO.find(rs.getLong("ID_Billet"));
				listeRecu.add(recu);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tableRecu.setItems(listeRecu);
		
		DestinationDAO destDAO=new DestinationDAO();
		rs=destDAO.findAll();
		Destination dest=null;
		try {
			listeDest.clear();
			listeTitre.clear();
			while(rs.next()) {
				dest=destDAO.find(rs.getLong("ID_Destination"));
				listeDest.add(dest);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		comboDest.setItems(listeDest);
		listeTitre.add("Aller");
		listeTitre.add("Aller-Retour");
		comboTitre.setItems(listeTitre);
		//System.out.print(listeTitre.getLast());
		
	}
	
	
}
