package application;
import metiers.GpUtilisateur;
import metiers.Utilisateur;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import DataBase.DAOfactory;
import DataBase.UtilisateurDAO;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.scene.control.ComboBox;

import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import metiers.Utilisateur;
import javafx.scene.control.TableView;

import javafx.scene.control.TableColumn;

public class UtilisateursController implements Initializable{
	public static ObservableList<Utilisateur>ListeUtilisateur=FXCollections.observableArrayList();
	public static ObservableList<GpUtilisateur>ListeGU=FXCollections.observableArrayList();
	@FXML
	private BorderPane root;
	/*table groupe utilisateur*/
	@FXML
	private TableView<GpUtilisateur> TableGUtilisateur;
	@FXML
	private TableColumn <GpUtilisateur,Long>col_idGUt;
	@FXML
	private TableColumn<GpUtilisateur,String> col_nomGU;
	@FXML
	private TableColumn<GpUtilisateur,String>  col_DescGU;
	@FXML
	private JFXButton btnNgroup;
	@FXML
	private JFXButton btnmodifG;
	@FXML
	private JFXButton supGrou;
	@FXML
	private ComboBox titre;
	@FXML
	private TextField recherfield;
	@FXML
	private Button ResercheGroupe;
	@FXML
	private JFXButton btnNewUtil;
	@FXML
	private JFXButton btnModifUt;
	@FXML
	private JFXButton SupUtilis;
	
	@FXML
	private TableView<Utilisateur> TableUtilisateur ;
	
	public TableView<Utilisateur> getTableUtilisateur() {
		return TableUtilisateur;
	}
	public void setTableUtilisateur(TableView<Utilisateur> tableUtilisateur) {
		TableUtilisateur = tableUtilisateur;
	}
	/*table utilisateur*/
	@FXML
	private TableColumn<Utilisateur,Long> col_idUt;
	@FXML
	private TableColumn<Utilisateur,String> col_nomUt;
	@FXML
	private TableColumn<Utilisateur,String>  col_MailUt;
	@FXML
	private TableColumn<Utilisateur,String>  col_MotPass;
	@FXML
	private TableColumn<Utilisateur,String>  col_GUt;
	@FXML
	private TableColumn<Utilisateur,String> col_Statut;
	@FXML
	private TableColumn<Utilisateur,String> col_DateCreer;
	@FXML
	private ComboBox titreUtil;
	@FXML
	private TextField rechercheUtil;
	@FXML
	private JFXButton btnRechercheUtil;

	// Event Listener on JFXButton[#btnNgroup].onAction
	@FXML
	public void opengroupe(ActionEvent event) {
		// TODO Autogenerated
	}
	// Event Listener on JFXButton[#btnmodifG].onAction
	@FXML
	public void ModifGrou(ActionEvent event) {
		// TODO Autogenerated
	}
	// Event Listener on JFXButton[#supGrou].onAction
	@FXML
	public void supgroup(ActionEvent event) {
		// TODO Autogenerated
	}
	// Event Listener on Button[#ResercheGroupe].onAction
	@FXML
	public void groupeU(ActionEvent event) {
		// TODO Autogenerated
	}
	// Event Listener on JFXButton[#btnNewUtil].onAction
	@FXML
	public void openUtilisateur(ActionEvent event) {
		Parent parent;
		try {
			parent = FXMLLoader.load(getClass().getResource("Compte.fxml"));
			Scene scene= new Scene(parent);
			Stage stage=new Stage();
			stage.setScene(scene);
			stage.setTitle("Gestion des utilisateurs");
			stage.setResizable(false);
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	// Event Listener on JFXButton[#btnModifUt].onAction
	@FXML
	public void modifUtilisateur(ActionEvent event) {
		Parent parent;
		try {
			Utilisateur user=TableUtilisateur.getSelectionModel().getSelectedItem();
			if(user!=null) {
				//UtilisateurDAO userDAO=new UtilisateurDAO();
				UtilisateurDAO.userCourent=user;
				
				parent = FXMLLoader.load(getClass().getResource("Compte.fxml"));
				Scene scene= new Scene(parent);
				Stage stage=new Stage();
				stage.setScene(scene);
				stage.setTitle("Gestion des utilisateurs");
				stage.setResizable(false);
				stage.show();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
			
		}

	// Event Listener on JFXButton[#SupUtilis].onAction
	@FXML
	public void SupUtilisateur(ActionEvent event) {
		Utilisateur user=TableUtilisateur.getSelectionModel().getSelectedItem();
		if(user!=null) {
			UtilisateurDAO userDAO=new UtilisateurDAO();
			userDAO.delete(user);
			ListeUtilisateur.remove(user);
		}
	}
	// Event Listener on JFXButton[#btnRechercheUtil].onAction
	@FXML
	public void RechercheUtil(ActionEvent event) {
		// TODO Autogenerated
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		/*initialisateion du tableau utilisateur*/
		col_idUt.setCellValueFactory(new PropertyValueFactory<>("id"));
		col_nomUt.setCellValueFactory(new PropertyValueFactory<>("nomUt"));
		col_MailUt.setCellValueFactory(new PropertyValueFactory<>("mail"));
		col_MotPass.setCellValueFactory(new PropertyValueFactory<>("motdepasse"));
		col_GUt.setCellValueFactory(new PropertyValueFactory<>("groupeUt"));
		col_Statut.setCellValueFactory(new PropertyValueFactory<>("statut"));
		col_DateCreer.setCellValueFactory(new PropertyValueFactory<>("dteCreation"));
		UtilisateurDAO UserDAO=new UtilisateurDAO();
		if(UserDAO.findAll()!=null) {
			ResultSet RS=UserDAO.findAll();
			try {
				while(RS.next()) {
					long i=RS.getLong(1);
					ListeUtilisateur.add(UserDAO.find(i));
					//System.out.println(UserDAO.find(i).getGroupeUt());
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		TableUtilisateur.setItems(ListeUtilisateur);
		
		/*initilisation du tableau groupe utilisateur*/
		col_idGUt.setCellValueFactory(new PropertyValueFactory<>("id"));
		col_nomGU.setCellValueFactory(new PropertyValueFactory<>("role"));
		col_DescGU.setCellValueFactory(new PropertyValueFactory<>("description"));
		DAOfactory DAOfac= new DAOfactory();
		if(DAOfac.getGpUtilisateurDAO().findAll()!=null) {
			ResultSet RS=DAOfac.getGpUtilisateurDAO().findAll();
			try {
				while(RS.next()) {
					long i=RS.getLong(1);
					ListeGU.add(DAOfac.getGpUtilisateurDAO().find(i));
					System.out.println(DAOfac.getGpUtilisateurDAO().find(i));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			TableGUtilisateur.setItems(ListeGU);
		}
		
	}
}
