package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;

import javafx.scene.layout.BorderPane;
import metiers.Utilisateur;
import outils.Outils;

public class MenuController extends BaseController implements Initializable{
	
	@FXML
    private Label UserName;

    @FXML
    private Label UserRole;

	
	@FXML
	private BorderPane PanePrincipal;
	
	 @FXML
	 private JFXButton brnAc;

	 @FXML
	 private JFXButton btnBil;

	 @FXML
	 private JFXButton btnColis;

	 @FXML
	 private JFXButton btnParam;

	 @FXML
	 private JFXButton btnProg;

	 @FXML
	 private JFXButton btnQuit;

	 @FXML
	 private JFXButton btnStat;

	 @FXML
	 private JFXButton btnUsers;
	 
	 public static Utilisateur utilisateur=null; 
	
	Object[] Pages= new Object[10];
	// Event Listener on Button[#brnAc].onAction
	
	//initialisation du tableau de bord au lancement
	
	
	
	 @FXML
	 void accueil(ActionEvent event) {
		 brnAc.setStyle("-fx-background-color: darkblue; -fx-text-fill: grey;");
		 btnBil.setStyle("-fx-background-color:  #0978f6; -fx-text-fill: white;");
		 btnColis.setStyle("-fx-background-color:  #0978f6; -fx-text-fill: white;");
		 btnProg.setStyle("-fx-background-color:  #0978f6; -fx-text-fill: white;");
		 btnUsers.setStyle("-fx-background-color:  #0978f6; -fx-text-fill: white;");
		 btnParam.setStyle("-fx-background-color:  #0978f6; -fx-text-fill: white;");
		 btnStat.setStyle("-fx-background-color:  #0978f6; -fx-text-fill: white;");
	    	if(Pages[1]==null) {    		
				try {
					Parent root=FXMLLoader.load(getClass().getResource("DashBoard.fxml"));
					Pages[1]=root;
					PanePrincipal.setCenter((Node) Pages[1]);
					
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}else {PanePrincipal.setCenter((Node) Pages[1]);}
			
	    }
	// Event Listener on Button[#btnBil].onAction
	@FXML
	public void biellet(ActionEvent event) {
		 btnBil.setStyle("-fx-background-color: darkblue; -fx-text-fill: grey;");
		 brnAc.setStyle("-fx-background-color:  #0978f6; -fx-text-fill: white;");
		 btnColis.setStyle("-fx-background-color:  #0978f6; -fx-text-fill: white;");
		 btnProg.setStyle("-fx-background-color:  #0978f6; -fx-text-fill: white;");
		 btnUsers.setStyle("-fx-background-color:  #0978f6; -fx-text-fill: white;");
		 btnParam.setStyle("-fx-background-color:  #0978f6; -fx-text-fill: white;");
		 btnStat.setStyle("-fx-background-color:  #0978f6; -fx-text-fill: white;");
		if(Pages[2]==null) {
			try {
				Parent root=FXMLLoader.load(getClass().getResource("Billet.fxml"));
				Pages[2]=root;
				PanePrincipal.setCenter((Node) Pages[2]);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
		}else {PanePrincipal.setCenter((Node) Pages[2]);}
		
		
	}
	@FXML
	public void user(ActionEvent event) {
		 btnUsers.setStyle("-fx-background-color: darkblue; -fx-text-fill: grey;");
		 brnAc.setStyle("-fx-background-color:  #0978f6; -fx-text-fill: white;");
		 btnColis.setStyle("-fx-background-color:  #0978f6; -fx-text-fill: white;");
		 btnProg.setStyle("-fx-background-color:  #0978f6; -fx-text-fill: white;");
		 btnBil.setStyle("-fx-background-color:  #0978f6; -fx-text-fill: white;");
		 btnParam.setStyle("-fx-background-color:  #0978f6; -fx-text-fill: white;");
		 btnStat.setStyle("-fx-background-color:  #0978f6; -fx-text-fill: white;");
	    	if(Pages[3]==null) {
				try {
					Parent root=FXMLLoader.load(getClass().getResource("Utilisateurs.fxml"));
					Pages[3]=root;
					PanePrincipal.setCenter((Node) Pages[3]);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}else {PanePrincipal.setCenter((Node) Pages[3]);}
	    }
	    

	  @FXML
	  public void colis(ActionEvent event) {
		     btnColis.setStyle("-fx-background-color: darkblue; -fx-text-fill: grey;");
			 brnAc.setStyle("-fx-background-color:  #0978f6; -fx-text-fill: white;");
			 btnBil.setStyle("-fx-background-color:  #0978f6; -fx-text-fill: white;");
			 btnProg.setStyle("-fx-background-color:  #0978f6; -fx-text-fill: white;");
			 btnUsers.setStyle("-fx-background-color:  #0978f6; -fx-text-fill: white;");
			 btnParam.setStyle("-fx-background-color:  #0978f6; -fx-text-fill: white;");
			 btnStat.setStyle("-fx-background-color:  #0978f6; -fx-text-fill: white;");
	    	if(Pages[4]==null) {
				try {
					Parent root=FXMLLoader.load(getClass().getResource("Colis.fxml"));
					Pages[4]=root;
					PanePrincipal.setCenter((Node) Pages[4]);
				} catch (IOException e) {
					
					e.printStackTrace();
				}
				
			}else {PanePrincipal.setCenter((Node) Pages[4]);}
	    }

	@FXML
	public void program(ActionEvent event) {
		 btnProg.setStyle("-fx-background-color: darkblue; -fx-text-fill: grey;");
		 brnAc.setStyle("-fx-background-color:  #0978f6; -fx-text-fill: white;");
		 btnColis.setStyle("-fx-background-color:  #0978f6; -fx-text-fill: white;");
		 btnBil.setStyle("-fx-background-color:  #0978f6; -fx-text-fill: white;");
		 btnUsers.setStyle("-fx-background-color:  #0978f6; -fx-text-fill: white;");
		 btnParam.setStyle("-fx-background-color:  #0978f6; -fx-text-fill: white;");
		 btnStat.setStyle("-fx-background-color:  #0978f6; -fx-text-fill: white;");
		if(Pages[5]==null) {
			try {
				Parent root=FXMLLoader.load(getClass().getResource("LignesTrans.fxml"));
				Pages[5]=root;
				PanePrincipal.setCenter((Node) Pages[5]);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else {PanePrincipal.setCenter((Node) Pages[5]);}
	}
	@FXML
	public void param(ActionEvent event) {
		 btnParam.setStyle("-fx-background-color: darkblue; -fx-text-fill: grey;");
		 brnAc.setStyle("-fx-background-color:  #0978f6; -fx-text-fill: white;");
		 btnColis.setStyle("-fx-background-color:  #0978f6; -fx-text-fill: white;");
		 btnProg.setStyle("-fx-background-color:  #0978f6; -fx-text-fill: white;");
		 btnUsers.setStyle("-fx-background-color:  #0978f6; -fx-text-fill: white;");
		 btnBil.setStyle("-fx-background-color:  #0978f6; -fx-text-fill: white;");
		 btnStat.setStyle("-fx-background-color:  #0978f6; -fx-text-fill: white;");
		 
		 if(Pages[6]==null) {
				try {
					Parent root=FXMLLoader.load(getClass().getResource("Parametre.fxml"));
					Pages[6]=root;
					PanePrincipal.setCenter((Node) Pages[6]);
				} catch (IOException e) {
					
					e.printStackTrace();
				}
				
			}else {PanePrincipal.setCenter((Node) Pages[6]);}
	}
	// Event Listener on Button[#btnQuit].onAction
	
	@FXML
	public void quitter(ActionEvent event) {
		if(Outils.confirmer("Voulez-vous vous déconnecter?"))
			getMainApp().afficherPage("Connexion.fxml", "Connexion");
		
	}


	@FXML
	void stat(ActionEvent event) {
		btnStat.setStyle("-fx-background-color: darkblue; -fx-text-fill: grey;");
		 brnAc.setStyle("-fx-background-color:  #0978f6; -fx-text-fill: white;");
		 btnColis.setStyle("-fx-background-color:  #0978f6; -fx-text-fill: white;");
		 btnProg.setStyle("-fx-background-color:  #0978f6; -fx-text-fill: white;");
		 btnUsers.setStyle("-fx-background-color:  #0978f6; -fx-text-fill: white;");
		 btnParam.setStyle("-fx-background-color:  #0978f6; -fx-text-fill: white;");
		 btnBil.setStyle("-fx-background-color:  #0978f6; -fx-text-fill: white;");
		 if(Pages[7]==null) {
				try {
					Parent root=FXMLLoader.load(getClass().getResource("Comptabilite.fxml"));
					Pages[7]=root;
					PanePrincipal.setCenter((Node) Pages[7]);
				} catch (IOException e) {
					
					e.printStackTrace();
				}
				
			}else {PanePrincipal.setCenter((Node) Pages[7]);}

	}
	
	//@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		try {
			Parent root=FXMLLoader.load(getClass().getResource("DashBoard.fxml"));
			Pages[1]=root;
			PanePrincipal.setCenter((Node) Pages[1]);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if(utilisateur!=null) {
			UserName.setText(utilisateur.getNomUt());
			UserRole.setText(utilisateur.getGroupeUt());
			if(utilisateur.getGroupeUt().equals("Gestionnaire de colis")) {
				btnParam.setVisible(false);
				btnProg.setVisible(false);
				btnStat.setVisible(false);
				btnUsers.setVisible(false);
			}
		}
	}
}

