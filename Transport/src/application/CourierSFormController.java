package application;

import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import metiers.Courrier;
import metiers.Destination;
import javafx.event.ActionEvent;

import javafx.scene.control.Label;

import javafx.scene.control.ComboBox;

import javafx.scene.control.DatePicker;

public class CourierSFormController {
	public static Courrier courier ;
	public static int indicateur;
	@FXML
	private TextField nomExp;
	@FXML
	private TextField PrenomExp;
	@FXML
	private DatePicker dateRecep;
	@FXML
	private TextField destination;
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

	// Event Listener on Button[#btnAnnuler].onAction
	@FXML
	public void annuler(ActionEvent event) {
		// TODO Autogenerated
	}
	// Event Listener on Button[#btnAnnulerFermer].onAction
	@FXML
	public void annulerFermer(ActionEvent event) {
		// TODO Autogenerated
	}
	// Event Listener on Button[#btnValider].onAction
	@FXML
	public void valider(ActionEvent event) {
		// TODO Autogenerated
	}
}
