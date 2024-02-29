package application;

import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.TextField;

import javafx.event.ActionEvent;

import javafx.scene.control.ComboBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableView;

import javafx.scene.control.TableColumn;

public class LignesTransController2  {
		@FXML
	    private TextField HeureDepart;

	    @FXML
	    private TableView<?> TableDepart;

	    @FXML
	    private Button btnModifDepart;

	    @FXML
	    private Button btnModifDestination;

	    @FXML
	    private Button btnNewDepart;

	    @FXML
	    private Button btnNewDestination;

	    @FXML
	    private Button btnRechDepart1;

	    @FXML
	    private Button btnRechDestination;

	    @FXML
	    private Button btnSupDepart;

	    @FXML
	    private Button btnSupDestination;

	    @FXML
	    private Button btnannuleDepart;

	    @FXML
	    private Button btnvalideDepart;

	    @FXML
	    private TextField champRechDepart1;

	    @FXML
	    private TextField champRechDestination;

	    @FXML
	    private TableColumn<?, ?> col_code;

	    @FXML
	    private TableColumn<?, ?> col_dest;

	    @FXML
	    private TableColumn<?, ?> col_heure;

	    @FXML
	    private TableColumn<?, ?> col_id;

	    @FXML
	    private TableColumn<?, ?> col_jour;

	    @FXML
	    private TableColumn<?, ?> col_nbPlcs;

	    @FXML
	    private ComboBox<?> combTitreDepart1;

	    @FXML
	    private ComboBox<?> combTitreDestination;

	    @FXML
	    private ComboBox<?> comboDestination;

	    @FXML
	    private ComboBox<?> comboJour;

	    @FXML
	    private Spinner<?> nbrPlcs;

	    @FXML
	    void annuleDepart(ActionEvent event) {

	    }

	    @FXML
	    void modifDestination(ActionEvent event) {

	    }

	    @FXML
	    void modifDpart(ActionEvent event) {

	    }

	    @FXML
	    void newDepart(ActionEvent event) {

	    }

	    @FXML
	    void rechercheDepart(ActionEvent event) {

	    }

	    @FXML
	    void rechercheDestination(ActionEvent event) {

	    }

	    @FXML
	    void supDapart(ActionEvent event) {

	    }

	    @FXML
	    void supDestination(ActionEvent event) {

	    }

	    @FXML
	    void valideDepart(ActionEvent event) {

	    }
}
