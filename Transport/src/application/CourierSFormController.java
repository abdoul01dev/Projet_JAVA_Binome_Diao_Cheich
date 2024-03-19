package application;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.stage.Stage;

import metiers.Courrier;
import metiers.Destination;
import metiers.Peseonne;
import outils.Outils;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;


import DataBase.CourierDAO;
import DataBase.DAOfactory;
import DataBase.DestinationDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.scene.control.Label;

import javafx.scene.control.ComboBox;

import javafx.scene.control.DatePicker;

public class CourierSFormController implements Initializable{
	public static Courrier tmpcourier ;
	public static int indicateur;
	ObservableList<Destination> Listdestination= FXCollections.observableArrayList();
	public static String code;
	@FXML
	private TextField nomExp;
	@FXML
	private TextField PrenomExp;
	@FXML
	private DatePicker dateRecep;
	@FXML
	private TextField description;
	@FXML
	private TextField TelExp;
	@FXML
	private TextField telDest;
	@FXML
	private TextField prenomDest;
	@FXML
	private TextField nomDes;
	@FXML
	private ComboBox<Destination> comboDest;
	@FXML
	public Label Dest_Prov;
	@FXML
	private Button btnAnnuler;
	@FXML
	private Button btnAnnulerFermer;
	@FXML
	private Button btnValider;
	@FXML
	private Label codeColis;
	
	

	DAOfactory DAOF=new DAOfactory();
	CourierDAO courierDAO=DAOF.getCourierDAO(); 

	// Event Listener on Button[#btnAnnuler].onAction
	@FXML
	public void annuler(ActionEvent event) {
		Stage stage=(Stage)comboDest.getScene().getWindow();
		stage.close();
	}
	// Event Listener on Button[#btnAnnulerFermer].onAction
	@FXML
	public void annulerFermer(ActionEvent event) {
		valider(event);
		Stage stage=(Stage)comboDest.getScene().getWindow();
		stage.close();
	}
	// Event Listener on Button[#btnValider].onAction
	@FXML
	public void valider(ActionEvent event) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		if(nomDes!=null && prenomDest!=null &&telDest!=null && nomExp!=null && PrenomExp!=null &&
				TelExp!=null && dateRecep.getValue()!=null && comboDest.getSelectionModel().getSelectedItem()!=null
				) {
			String sdate=formatter.format(dateRecep.getValue());
			Peseonne expediteur=new Peseonne(1l, nomExp.getText(), PrenomExp.getText(),"", null, TelExp.getText());
			Peseonne destinataire=new Peseonne(1l, nomDes.getText(), prenomDest.getText(), "", null, telDest.getText());
			//Double val=Double.parseDouble(valeur.getText());
			Courrier courier=new Courrier(null,codeColis.getText(),1, sdate, null, description.getText(),0.0, expediteur, destinataire);
			courier.setIdDestination(comboDest.getSelectionModel().getSelectedItem().getId());
			courier.setFrais(0.0);
			if(indicateur==0) {
				Long idMax;
				idMax=courierDAO.idMax();
				String code=String.format("COS-%04d", idMax);
				codeColis.setText(code);
				courier=courierDAO.create(courier);
				ColisController.listecourierSortant.add(courier);
				Outils.info("Courrier ajouté avec succès");
				DashBordController.nbcourierS++;
			}else {
				if(Outils.confirmer("Voulez-vous vraiment enregistrer ces modifications?")) {
					courier.setId(tmpcourier.getId());
					courier.setType(1);
					courier=courierDAO.update(courier);
					int index=ColisController.listecourierSortant.indexOf(tmpcourier);
					ColisController.listecourierSortant.set(index, courier);
					
				}
			}
		}else {
			Outils.erreur("Des champs réquis n'o,t pas été saisie");
		}
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Long idMax;
		idMax=courierDAO.idMax();
		//String code=String.format("CS-%04d", idMax);
		if(indicateur==0)
			codeColis.setText(code);
		else
			codeColis.setText(tmpcourier.getCode());
		
		DestinationDAO destinationDAO=DAOF.getDestinationDAO();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		if(indicateur==1) {
			
			codeColis.setText(tmpcourier.getCode());
			nomExp.setText(tmpcourier.getNomE());
			PrenomExp.setText(tmpcourier.getPrenomE());
			TelExp.setText(tmpcourier.getNumE());
			nomDes.setText(tmpcourier.getNomD());
			prenomDest.setText(tmpcourier.getPrenomD());
			telDest.setText(tmpcourier.getNumD());
			//valeur.setText(String.valueOf(tmpcolis.getValeur()));
			Destination destination=destinationDAO.find(tmpcourier.getIdDestination());
			comboDest.getSelectionModel().select(destination);
			//frais.setText(String.valueOf(tmpcolis.getFrais()));
			LocalDate localDate = LocalDate.parse(tmpcourier.getDateRecep(), formatter);
			dateRecep.setValue(localDate );
			description.setText(tmpcourier.getDescription());
			
		}else {
			idMax=courierDAO.idMax();
			String code=String.format("COS-%04d", idMax);
			codeColis.setText(code);
			nomExp.setText(null);
			PrenomExp.setText(null);
			TelExp.setText(null);
			nomDes.setText(null);
			prenomDest.setText(null);
			telDest.setText(null);
			//valeur.setText(null);
			comboDest.getSelectionModel().select(null);
			//frais.setText(null);
			dateRecep.setValue(null );
			description.setText(null);
			
		}
		
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
		
		telDest.setTextFormatter(Outils.formater());
		TelExp.setTextFormatter(Outils.formater());
	}
		
}

