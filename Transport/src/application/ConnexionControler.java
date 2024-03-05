package application;


import java.net.URL;
import java.util.ResourceBundle;

import DataBase.UtilisateurDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import metiers.Utilisateur;
import outils.Outils;

public class ConnexionControler extends BaseController implements Initializable{

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
		
	    Outils outils=new Outils();
	    
	    
	    @FXML
	    void Abandonner(ActionEvent event) {
	    	//confirmer();
	    	if(Outils.confirmer("Voulez-vous vraiment abandonner ?"))
	    		getMainApp().primaryStage.close();
	    }

	    @FXML
	    void Connecter(ActionEvent event) {
	    	UtilisateurDAO userDAO= new UtilisateurDAO();
	    	Utilisateur utilsateur= userDAO.findLogin(user.getText(),outils.sha256(pwd.getText()) );
	    	if(utilsateur != null) {
	    		MenuController.utilisateur=utilsateur;
	    		System.out.println( utilsateur.getStatut());
	    		if(utilsateur.getCodeStatut()==1) {
	    			getMainApp().afficherPage("Menu.fxml", "Menu");
	    		}else {
	    			dialog.setText("Connection non autorisée,veuillez contactez votre administrateur");
		    		dialog.setTextFill(Color.WHITE);
		    		dialog.setStyle("-fx-background-color: orange;");
	    		}
	    		
	    	}
	    	else {
	    		dialog.setText("Nom d'utilisateur ou mot de passe incorrect");
	    		dialog.setTextFill(Color.WHITE);
	    		dialog.setStyle("-fx-background-color: #a82400;");
	    	} 
	    }

	   
	    
	    @FXML
	    void Souvenir(ActionEvent event) {

	    }

		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			user.requestFocus();
			
		}


}
