package application;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

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
	    private Text dialog;
		

	    @FXML
	    void Abandonner(ActionEvent event) {
	    	

	    }

	    @FXML
	    void Connecter(ActionEvent event) {
	    	if(user.getText().equals("Amin")&& pwd.getText().equals("admin"))
	    		getMainApp().afficherPage("Menu.fxml", "Menu");
	    	else {
	    		dialog.setText("Nom d'utilisateur ou mot de passe incorrect");
	    		dialog.setFill(Color.RED);
	    	}
	    		
	    	
	    	
           
	    }

	    @FXML
	    void Souvenir(ActionEvent event) {

	    }


}
