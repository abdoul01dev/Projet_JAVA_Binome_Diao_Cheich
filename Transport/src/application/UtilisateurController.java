package application;


import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class UtilisateurController<JFXButton> {

    @FXML
    private Button ResercheGroupe;

    @FXML
    private JFXButton SupUtilis;

    @FXML
    private JFXButton btnNewUtil;

    @FXML
    private JFXButton btnNgroup;

    @FXML
    private Button btnRechercheUtil;

    @FXML
    private JFXButton btnmodifG;

    @FXML
    private TableColumn<?, ?> col_id;

    @FXML
    private TableColumn<?, ?> col_id1;

    @FXML
    private TableColumn<?, ?> col_nom;

    @FXML
    private TableColumn<?, ?> col_nom1;

    @FXML
    private TableColumn<?, ?> col_prenom;

    @FXML
    private TableColumn<?, ?> col_prenom1;

    @FXML
    private TableColumn<?, ?> col_tel1;

    @FXML
    private TableColumn<?, ?> col_type1;

    @FXML
    private TextField rechercheUtil;

    @FXML
    private TextField recherfield;

    @FXML
    private JFXButton supGrou;

    @FXML
    private ComboBox<?> titre;

    @FXML
    private ComboBox<?> titreUtil;
    @FXML
    private BorderPane root;
    
    private Parent fxml;

    @FXML
    void ModifGrou(ActionEvent event) {

    }

    @FXML
    void RechercheUtil(ActionEvent event) {

    }

    @FXML
    void SupUtilisateur(ActionEvent event) {

    }

    @FXML
    void groupeU(ActionEvent event) {

    }

    @FXML
    void openUtilisateur(ActionEvent event) {
    	root.getScene().getWindow();
		Stage compte = new Stage();
		try {
			fxml=FXMLLoader.load(getClass().getResource("Compte.fxml"));
			Scene scene = new Scene(fxml);
			compte.setScene(scene);
			compte.show();
		} catch (IOException e) {
			e.printStackTrace();
		}

    }

    @FXML
    void opengroupe(ActionEvent event) {
    	root.getScene().getWindow();
		Stage groupe = new Stage();
		try {
			fxml=FXMLLoader.load(getClass().getResource("GroupeForm.fxml"));
			Scene scene = new Scene(fxml);
			groupe.setScene(scene);
			groupe.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void supgroup(ActionEvent event) {

    }

}
