package application;


import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.*;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

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
	    private Label dialog;
		

	    @FXML
	    void Abandonner(ActionEvent event) {
	    	confirmer();
	    }

	    @FXML
	    void Connecter(ActionEvent event) {
	    	if(user.getText().equals("Amin")&& pwd.getText().equals("admin"))
	    		getMainApp().afficherPage("Menu.fxml", "Menu");
	    	else {
	    		dialog.setText("Nom d'utilisateur ou mot de passe incorrect");
	    		dialog.setTextFill(Color.WHITE);
	    		dialog.setStyle("-fx-background-color: #a82400;");
	    	} 
	    }

	    
	    private void confirmer() {
	        Alert alert = new Alert(AlertType.CONFIRMATION);
	        alert.setTitle("Confirmation");
	        alert.setHeaderText(null);
	        alert.setContentText("Voulez-vous vraiment abandonner ?");

	        
	        ButtonType buttonTypeYes = new ButtonType("Oui");
	        ButtonType buttonTypeNo = new ButtonType("Non");
	        alert.getButtonTypes().setAll(buttonTypeYes, buttonTypeNo);
	        Optional<ButtonType> result = alert.showAndWait();
	        if (result.isPresent() && result.get() == buttonTypeYes) {
	        	getMainApp().primaryStage.close();
	        } else {
	        
	        }
	    }
	    
	    @FXML
	    void Souvenir(ActionEvent event) {

	    }


}
