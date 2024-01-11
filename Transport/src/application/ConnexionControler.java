package application;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class ConnexionControler extends BaseController{

	    @FXML
	    private Button btnAband;

	    @FXML
	    private Button btnConn;

	    @FXML
	    private CheckBox btnSouv;

	    @FXML
	    private PasswordField pwd;

	    @FXML
	    private TextField user;

		

	    @FXML
	    void Abandonner(ActionEvent event) {
	    	

	    }

	    @FXML
	    void Connecter(ActionEvent event) {
	    	getMainApp().afficherPage("Menu.fxml", "Menu",1);
           
	    }

	    @FXML
	    void Souvenir(ActionEvent event) {

	    }


}
