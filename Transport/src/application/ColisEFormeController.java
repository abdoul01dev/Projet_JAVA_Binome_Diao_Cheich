package application;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.stage.Stage;
import metiers.Colis;
import metiers.Destination;
import metiers.Peseonne;
import outils.Outils;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import DataBase.ColisDAO;
import DataBase.DAOfactory;
import DataBase.DestinationDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.scene.control.Label;

import javafx.scene.control.ComboBox;

import javafx.scene.control.DatePicker;

public class ColisEFormeController implements Initializable{
	ObservableList<Destination> Listdestination= FXCollections.observableArrayList();
	public static String code;
	public static Colis tmpcolis;
	public static int indicateur;
	@FXML
	private TextField telDest;
	@FXML
	private TextField prenomDest;
	@FXML
	private TextField nomDes;
	@FXML
	private ComboBox<Destination> comboProvenance;
	@FXML
	private TextField nomExp;
	@FXML
	private TextField PrenomExp;
	@FXML
	private DatePicker dateRecep;
	@FXML
	private TextField description;
	@FXML
	private TextField valeur;
	@FXML
	private TextField TelExp;
	@FXML
	private Button btnAnnuler;
	@FXML
	private Button btnAnnulerFermer;
	@FXML
	private Button btnValider;
	@FXML
	private Label codeColis;
	
	
	DAOfactory DAOF=new DAOfactory();
	ColisDAO colisDAO=DAOF.getColisDAO(); 

	// Event Listener on Button[#btnAnnuler].onAction
	@FXML
	public void annuler(ActionEvent event) {
		Stage stage=(Stage)comboProvenance.getScene().getWindow();
		stage.close();
	}
	// Event Listener on Button[#btnAnnulerFermer].onAction
	@FXML
	public void annulerFermer(ActionEvent event) {
		valider(event);
		Stage stage=(Stage)comboProvenance.getScene().getWindow();
		stage.close();
	}
	// Event Listener on Button[#btnValider].onAction
	@FXML
	public void valider(ActionEvent event) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String sdate=formatter.format(dateRecep.getValue());
		if(nomDes!=null && prenomDest!=null &&telDest!=null && nomExp!=null && PrenomExp!=null &&
				TelExp!=null && dateRecep.getValue()!=null && comboProvenance.getSelectionModel().getSelectedItem()!=null
				) {
			Peseonne expediteur=new Peseonne(1l, nomExp.getText(), PrenomExp.getText(),"", null, TelExp.getText());
			Peseonne destinataire=new Peseonne(1l, nomDes.getText(), prenomDest.getText(), "", null, telDest.getText());
			Double val=Double.parseDouble(valeur.getText());
			Colis colis=new Colis(null,codeColis.getText(),2, sdate, null, description.getText(),val, expediteur, destinataire);
			colis.setIdDestination(comboProvenance.getSelectionModel().getSelectedItem().getId());
			colis.setFrais(0.0);
			if(indicateur==0) {
				Long idMax;
				idMax=colisDAO.idMax();
				String code=String.format("CE-%04d", idMax);
				if(indicateur==0)
					codeColis.setText(code);
				colis=colisDAO.create(colis);
				ColisController.listecolisEntrant.add(colis);
			}else {
				if(Outils.confirmer("Voulez-vous vraiment enregistrer ces modifications?")) {
					colis.setId(tmpcolis.getId());
					colis=colisDAO.update(colis);
					int index=ColisController.listecolisEntrant.indexOf(tmpcolis);
					ColisController.listecolisEntrant.set(index, colis);
					
				}
				
			}
			
			
			nomDes.setText(null); prenomDest.setText(null);telDest.setText(null); nomExp.setText(null);PrenomExp.setText(null);
			TelExp.setText(null);dateRecep.setValue(null); ;comboProvenance.getSelectionModel().select(null);
			/*frais.setText(null);*/valeur.setText(null);description.setText(null);
			
					
		}
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Long idMax;
		idMax=colisDAO.idMax();
		//String code=String.format("CS-%04d", idMax);
		if(indicateur==0)
			codeColis.setText(code);
		else
			codeColis.setText(tmpcolis.getCode());
		
		DestinationDAO destinationDAO=DAOF.getDestinationDAO();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		if(indicateur==1) {
			
			codeColis.setText(tmpcolis.getCode());
			nomExp.setText(tmpcolis.getNomE());
			PrenomExp.setText(tmpcolis.getPrenomE());
			TelExp.setText(tmpcolis.getNumE());
			nomDes.setText(tmpcolis.getNomD());
			prenomDest.setText(tmpcolis.getPrenomD());
			telDest.setText(tmpcolis.getNumD());
			valeur.setText(String.valueOf(tmpcolis.getValeur()));
			Destination destination=destinationDAO.find(tmpcolis.getIdDestination());
			comboProvenance.getSelectionModel().select(destination);
			//frais.setText(String.valueOf(tmpcolis.getFrais()));
			LocalDate localDate = LocalDate.parse(tmpcolis.getDateRecep(), formatter);
			dateRecep.setValue(localDate );
			description.setText(tmpcolis.getDescription());
			
		}else {
			idMax=colisDAO.idMax();
			String code=String.format("CE-%04d", idMax);
			codeColis.setText(code);
			nomExp.setText(null);
			PrenomExp.setText(null);
			TelExp.setText(null);
			nomDes.setText(null);
			prenomDest.setText(null);
			telDest.setText(null);
			valeur.setText(null);
			comboProvenance.getSelectionModel().select(null);
			//frais.setText(null);
			dateRecep.setValue(null );
			description.setText(null);
			
		}
		
		ResultSet Rs= destinationDAO.findAll();
		try {
			while(Rs.next()) {
				Long id=Rs.getLong("ID_Destination");
				Destination dest=destinationDAO.find(id);
				System.out.println(dest.getLesBillet().isEmpty());
				Listdestination.add(dest);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		comboProvenance.setItems(Listdestination);
		comboProvenance.getSelectionModel().selectFirst();
	}
		
}
