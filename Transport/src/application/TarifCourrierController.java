package application;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.converter.DoubleStringConverter;
import metiers.Destination;
import metiers.Recu;
import outils.Outils;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import DataBase.DestinationDAO;
import DataBase.TarifCourrierDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.scene.control.ComboBox;

import javafx.scene.control.TableView;

import javafx.scene.control.TableColumn;

public class TarifCourrierController implements Initializable{
	TarifCourrierDAO recuDAO=new TarifCourrierDAO();
	Recu recuCourent=null;
	DestinationDAO destinationDAO=new DestinationDAO();
	ObservableList<Recu> ListRecu=FXCollections.observableArrayList();
	@FXML
	private TableView <Recu>tableRecu;
	@FXML
	private TableColumn <Recu,Long>col_id;
	@FXML
	private TableColumn<Recu,String> col_dest;
	@FXML
	private TableColumn<Recu,Double> col_frais;
	@FXML
	private Button btnValide;
	@FXML
	private Button btnModif;
	@FXML
	private Button btnSupprime;
	@FXML
	private ComboBox<Destination> comboDest;
	@FXML
	private TextField cahmpsFrais;

	// Event Listener on Button[#btnValide].onAction
	@FXML
	public void valide(ActionEvent event) {
		if(!cahmpsFrais.getText().isEmpty() && comboDest.getSelectionModel().getSelectedItem()!=null) {
			if(recuCourent==null) {
				recuCourent=new Recu(null, Double.valueOf(cahmpsFrais.getText()),
						comboDest.getSelectionModel().getSelectedItem().getId());
				recuCourent=recuDAO.create(recuCourent);
				if(recuCourent!=null) {
					ListRecu.add(recuCourent);
					recuCourent=null;
					cahmpsFrais.clear();
					comboDest.getSelectionModel().clearSelection();
				}
			}else {
				
				int index=tableRecu.getSelectionModel().getSelectedIndex();
				recuCourent.setMontant(Double.valueOf(cahmpsFrais.getText()));
				recuCourent.setIdDest(comboDest.getSelectionModel().getSelectedItem().getId());
				recuCourent=recuDAO.update(recuCourent);
				if(recuCourent!=null) {
					ListRecu.set(index, recuCourent);
					recuCourent=null;
					cahmpsFrais.clear();
					comboDest.getSelectionModel().clearSelection();
				}
		}
		}else {
			Outils.erreur("veullez remplir tous les champs");
		}
	}
	// Event Listener on Button[#btnModif].onAction
	@FXML
	public void modif(ActionEvent event) {
		recuCourent=tableRecu.getSelectionModel().getSelectedItem();
		if(recuCourent!=null) {
			if(Outils.confirmer("Voullez-vous vraiment modifier ce tarif?")) {
				cahmpsFrais.setText(String.valueOf(recuCourent.getMontant()));
				comboDest.getSelectionModel().select(destinationDAO.find(recuCourent.getIdDest()));
			}
		}else {
			Outils.erreur("veullez selctionner un tarif");
		}
		
	}
	// Event Listener on Button[#btnSupprime].onAction
	@FXML
	public void supprime(ActionEvent event) {
		Recu recu=tableRecu.getSelectionModel().getSelectedItem();
		if(recu!=null) {
			if(Outils.confirmer("Voullez-vous vraiment supprimer ce tarif?")) {
				recuDAO.delete(recu);
				ListRecu.remove(recu);
			}
		}else {
			Outils.erreur("veullez selctionner un tarif");
		}
	}
		
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
		col_dest.setCellValueFactory(new PropertyValueFactory<>("destination"));
		col_frais.setCellValueFactory(new PropertyValueFactory<>("montant"));
		
		
		ObservableList<Destination> Listdestination=FXCollections.observableArrayList();
		ResultSet Rs= destinationDAO.findAll();
		try {
			while(Rs.next()) {
				Long id=Rs.getLong("ID_Destination");
				Destination dest=destinationDAO.find(id);
				if(dest!=null)
					Listdestination.add(dest);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		comboDest.setItems(Listdestination);
		comboDest.getSelectionModel().selectFirst();
		cahmpsFrais.setTextFormatter(Outils.Tranformateur(new DoubleStringConverter()));
		

		Rs= recuDAO.findAll();
		try {
			while(Rs.next()) {
				Long id=Rs.getLong("id");
				Recu tc=recuDAO.find(id);
				if(tc!=null)
					ListRecu.add(tc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tableRecu.setItems(ListRecu);
	}
}
