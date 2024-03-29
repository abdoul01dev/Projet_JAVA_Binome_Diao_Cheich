package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.stage.Stage;
import metiers.Passager;
import outils.Outils;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;


import DataBase.DAOfactory;
import DataBase.PassagerDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class BilletController implements Initializable {
	public static ObservableList<Passager>ListePassager=FXCollections.observableArrayList();
	public static ObservableList<Passager>ListeReservation=FXCollections.observableArrayList();
	@FXML
	private TableView<Passager>tablePassager;
	@FXML
	private TableColumn<Passager,Long> col_id;
	@FXML
	private TableColumn<Passager,String>  col_nom;
	@FXML
	private TableColumn<Passager,String> col_prenom;
	@FXML
	private TableColumn<Passager,String> col_tel;
	@FXML
	private TableColumn<Passager,String> col_dest;
	@FXML
	private TableColumn<Passager,Double> col_motant;
	@FXML
	private TableColumn<Passager,String> col_type;
	@FXML
	private TableColumn<Passager,String>col_Hdepart;
	@FXML
	private Button btnNewPass;
	@FXML
	private Button btnModif;
	@FXML
	private Button btnDel;
	@FXML
	private Button btnTicket;
	@FXML
	private Button btnTicket1;
	@FXML
	private Button btnListe;
	@FXML
	private ComboBox<?> combTitrePass;
	@FXML
	private TextField champRechPass;
	@FXML
	private Button btnRechPass;
	@FXML
	private Button btnNewResev;
	@FXML
	private Button btnModifResev;
	@FXML
	private Button btnDeletReserv;
	@FXML
	private Button btnAnnuler;
	@FXML
	private TableView<Passager> tableR;
	@FXML
	private TableColumn<Passager,Long>  col_id1;
	@FXML
	private TableColumn <Passager,String> col_nom1;
	@FXML
	private TableColumn <Passager,String> col_prenom1;
	@FXML
	private TableColumn<Passager,String>  col_tel1;
	@FXML
	private TableColumn <Passager,String> col_dest1;
	@FXML
	private TableColumn <Passager,Double> col_motant1;
	@FXML
	private TableColumn <Passager,String> col_type1;
	@FXML
	private TableColumn <Passager,String> col_etat;
	@FXML
	private TableColumn<Passager,String>  col_date;
	@FXML
	private TableColumn<Passager,String>col_Hdepart1;
	@FXML
	private ComboBox<String> combRechReserv;
	@FXML
	private TextField champRechReserv;
	@FXML
	private Button btnRechReserv;
	@FXML
	private TableColumn<?, ?> lecHeure;
	@FXML
	private TableColumn<?, ?> lecPlcsDispo;
	@FXML
	private TableColumn<?, ?> lecPlcsVendu;
	@FXML
	private TableColumn<?, ?> lecDestination;
	@FXML
	private TableColumn<?, ?> lecPlcsTotal;
	@FXML
	private DatePicker calend;
	@FXML
	private Button btnOK;
	
	
	
	@FXML
	private TableColumn<?, ?> lecHeure1;
	@FXML
	private TableColumn<?, ?> lecPlcsDispo1;
	@FXML
	private TableColumn<?, ?> lecPlcsVendu1;
	@FXML
	private TableColumn<?, ?> lecDestination1;
	@FXML
	private TableColumn<?, ?> lecPlcsTotal1;
	@FXML
	private DatePicker calend1;
	@FXML
	private Button btnOK1;
	
	

	@FXML
	public void liste(ActionEvent event) {
		try {
			Parent parent=FXMLLoader.load(getClass().getResource("BoiteImpression.fxml"));
			Scene scene=new Scene(parent,360,250);
			Stage stage=new Stage();
			stage.setScene(scene);
			stage.setTitle("Impression de billet");
			stage.setResizable(false);
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@FXML
	public void ticket(ActionEvent event) {
		Passager passager=tablePassager.getSelectionModel().getSelectedItem();
		if(passager!=null) {
			try {
				TicketController.passager=passager;
				Parent parent=FXMLLoader.load(getClass().getResource("Ticket.fxml"));
				Scene scene=new Scene(parent,760,560);
				Stage stage=new Stage();
				stage.setScene(scene);
				stage.setTitle("Impression de billet");
				stage.setResizable(false);
				stage.show();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			Outils.erreur("Veillez selectioner un passager");
		}
		
	}
	
	@FXML
	public void ticket1(ActionEvent event) {
		Passager passager=tableR.getSelectionModel().getSelectedItem();
		if(passager!=null) {
			try {
				TicketController.passager=passager;
				Parent parent=FXMLLoader.load(getClass().getResource("Ticket.fxml"));
				Scene scene=new Scene(parent,760,560);
				Stage stage=new Stage();
				stage.setScene(scene);
				stage.setTitle("Impression de billet");
				stage.setResizable(false);
				stage.show();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			Outils.erreur("Veillez selectioner un passager");
		}
		
	}
	// Event Listener on Button[#btnNewPass].onAction
	@FXML
	public void NewPass(ActionEvent event) {
		// TODO Autogenerated
		BielletFormController.indiacteur=0;
		BielletFormController.action=0;
		try {
			Parent parent=FXMLLoader.load(getClass().getResource("BielletForm.fxml"));
			Scene scene=new Scene(parent,600,400);
			Stage stage=new Stage();
			stage.setScene(scene);
			stage.setTitle("Enregistrement de passager");
			stage.setResizable(false);
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	// Event Listener on Button[#btnModif].onAction
	@FXML
	public void modifPss(ActionEvent event) {
		Passager passager;
		passager=tablePassager.getSelectionModel().getSelectedItem();
		if(passager!=null) {
			BielletFormController.action=1;
			BielletFormController.indiacteur=0;
			BielletFormController.tmpPassager=passager;
			try {
				Parent parent=FXMLLoader.load(getClass().getResource("BielletForm.fxml"));
				Scene scene=new Scene(parent,600,400);
				Stage stage=new Stage();
				stage.setScene(scene);
				stage.setTitle("Enregistrement de passager");
				stage.setResizable(false);
				stage.show();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			Outils.erreur("Veullez selectionner un passager d'abdord");
		}
		
		
	}
	// Event Listener on Button[#btnDel].onAction
	@FXML
	public void deletePass(ActionEvent event) {
		Passager passager=tablePassager.getSelectionModel().getSelectedItem();
		if(passager!=null) {
			PassagerDAO passagerDAO=new PassagerDAO();
			String messager="";
			messager="Voullez-vous vraiment supprimé ce passager?";
			if(Outils.confirmer(messager)) {
				passagerDAO.delete(passager);
				ListePassager.remove(passager);
				Outils.info("Passager supprimé avec succès");
				if(passager.getDate().compareTo(Outils.DateEnChaine(LocalDate.now()))==0)
					DashBordController.nbPassager--;
			}
		}else {
			Outils.erreur("Veullez selectionner un passager d'abdord");
		}
	}
	// Event Listener on Button[#btnRechPass].onAction
	@FXML
	public void recherchePass(ActionEvent event) {
		// TODO Autogenerated
	}
	// Event Listener on Button[#btnNewResev].onAction
	@FXML
	public void newReserv(ActionEvent event) {
		BielletFormController.indiacteur=1;
		BielletFormController.action=0;
		try {
			Parent parent=FXMLLoader.load(getClass().getResource("BielletForm.fxml"));
			Scene scene=new Scene(parent,600,400);
			Stage stage=new Stage();
			stage.setScene(scene);
			stage.setTitle("Enregistrement de passager");
			stage.setResizable(false);
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// Event Listener on Button[#btnModifResev].onAction
	@FXML
	public void modifReserv(ActionEvent event) {
		Passager passager;
		passager=tableR.getSelectionModel().getSelectedItem();
		if(passager!=null) {
			BielletFormController.indiacteur=1;
			BielletFormController.action=1;
			BielletFormController.tmpPassager=passager;
			try {
				Parent parent=FXMLLoader.load(getClass().getResource("BielletForm.fxml"));
				Scene scene=new Scene(parent,600,400);
				Stage stage=new Stage();
				stage.setScene(scene);
				stage.setTitle("Enregistrement de passager");
				stage.setResizable(false);
				stage.show();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			Outils.erreur("Veullez selectionner une une réservation d'abdord");
		}
	}
	// Event Listener on Button[#btnDeletReserv].onAction
	@FXML
	public void deleteReserv(ActionEvent event) {
		Passager passager=tableR.getSelectionModel().getSelectedItem();
		if(passager!=null) {
			PassagerDAO passagerDAO=new PassagerDAO();
			String messager="";
			messager="Voullez-vous vraiment supprimé ce cette réservation?";
			if(Outils.confirmer(messager)) {
				passagerDAO.delete(passager);
				ListeReservation.remove(passager);
				Outils.info("Réservation supprimée avec succès");
				if(passager.getDate_Enreg()!=null && passager.getDate_Enreg().compareTo(Outils.DateEnChaine(LocalDate.now()))==0)
					DashBordController.nbreservation--;
			}
		
		}else {
			Outils.erreur("Veullez selectionner une une réservation d'abdord");
		}
	}
	
	// Event Listener on Button[#btnDeletReserv].onAction
		@FXML
		public void annuler(ActionEvent event) {
			Passager passager=tableR.getSelectionModel().getSelectedItem();
			if(passager!=null) {
				LocalDate d=LocalDate.parse(passager.getDate());
				if(d.isAfter(LocalDate.now())) {
					if(passager.getEtat()!=3) {
						int index=ListeReservation.indexOf(passager);
						PassagerDAO passagerDAO=new PassagerDAO();
						String messager="";
						messager="Voullez-vous vraiment annuler cette réservation?";
						if(Outils.confirmer(messager)) {
							passager.setEtat(3);
							passager.setMontant(passager.getMontant()*0.2);
							passager=passagerDAO.updateEtat(passager);					
							ListeReservation.set(index,passager);
						}
					}else {
						Outils.info("Cette réservation a été déjà annulée");
					}
				}else {
					Outils.erreur("Impossible d'annuler un réservation dont la date est passée");
					
				}
			}else {
				Outils.erreur("Veullez selectionner une une réservation d'abdord");
			}
		}
	
	// Event Listener on TextField[#champRechReserv].onAction
	@FXML
	public void rechercheReserv(ActionEvent event) {
		// TODO Autogenerated
	}
	
	@FXML
	public void OK(ActionEvent event) {
		LocalDate date =calend.getValue();
		//System.out.println(dt);
		
		if(date!=null) {
			String dt = date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			DAOfactory DAOF=new DAOfactory();
			PassagerDAO passagerDAO=DAOF.getPassagerDAO();
			ResultSet Rs=passagerDAO.findPassagerByDate(dt);
			try {
				if(Rs.next()) {
					ListePassager.clear();
					Long id=Rs.getLong("ID_Passager");
					ListePassager.add(passagerDAO.find(id));
					try {
						while(Rs.next()) {
						id=Rs.getLong("ID_Passager");
						ListePassager.add(passagerDAO.find(id));
						System.out.println(dt+"+++");
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						System.out.println(dt+"+++");
					}
					tablePassager.setItems(ListePassager);
				}else {
				    Alert alert = new Alert(Alert.AlertType.INFORMATION);
				    alert.setTitle("Alert");
				    alert.setHeaderText("Aucune donnée trouvée.");
				    alert.showAndWait();
				
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//ListePassager.add(P);
			
		}else {
		    Alert alert = new Alert(Alert.AlertType.INFORMATION);
		    alert.setTitle("Alert");
		    alert.setHeaderText("Veillez choisir une date!!");
		    alert.showAndWait();
		
		}
	}
	
	
	
	@FXML
	public void OKR(ActionEvent event) {
		LocalDate date =calend1.getValue();
		//System.out.println(dt);
		
		if(date!=null) {
			String dt = date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			DAOfactory DAOF=new DAOfactory();
			PassagerDAO passagerDAO=DAOF.getPassagerDAO();
			ResultSet Rs=passagerDAO.findReservationByDate(dt);
			try {
				if(Rs.next()) {
					ListeReservation.clear();
					Long id=Rs.getLong("ID_Passager");
					ListeReservation.add(passagerDAO.find(id));
					try {
						while(Rs.next()) {
						id=Rs.getLong("ID_Passager");
						ListeReservation.add(passagerDAO.find(id));
						System.out.println(dt+"+++");
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						System.out.println(dt+"+++");
					}
					tableR.setItems(ListeReservation);
				}else {
				    Alert alert = new Alert(Alert.AlertType.INFORMATION);
				    alert.setTitle("Alert");
				    alert.setHeaderText("Aucune donnée trouvée.");
				    alert.showAndWait();
				
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//ListePassager.add(P);
			
		}else {
		    Alert alert = new Alert(Alert.AlertType.INFORMATION);
		    alert.setTitle("Alert");
		    alert.setHeaderText("Veillez choisir une date!!");
		    alert.showAndWait();
		
		}
	}
	
    
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		col_id.setCellValueFactory(new PropertyValueFactory<>("code"));
		col_nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
		col_prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
		col_tel.setCellValueFactory(new PropertyValueFactory<>("NumTel"));
		col_dest.setCellValueFactory(new PropertyValueFactory<>("destination"));
		col_motant.setCellValueFactory(new PropertyValueFactory<>("montant"));
		col_type.setCellValueFactory(new PropertyValueFactory<>("typeBillet"));
		col_Hdepart.setCellValueFactory(new PropertyValueFactory<>("heure"));
		DAOfactory DAOF=new DAOfactory();
		PassagerDAO passagerDAO=DAOF.getPassagerDAO();
		
		ResultSet Rs=passagerDAO.findAll();
		//ResultSet Rs=passagerDAO.findPassagerByDate("2024-01-31");
		if(Rs!=null) {
			try {
				//néttoyer le tableau d'abord avant de procéder au chargement
				ListePassager.clear();
				while(Rs.next()) {
					Long id=Rs.getLong("ID_Passager");
					ListePassager.add(passagerDAO.find(id));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//ListePassager.add(P);
		tablePassager.setItems(ListePassager);
		
		
		
		col_id1.setCellValueFactory(new PropertyValueFactory<>("code"));
		col_nom1.setCellValueFactory(new PropertyValueFactory<>("nom"));
		col_prenom1.setCellValueFactory(new PropertyValueFactory<>("prenom"));
		col_tel1.setCellValueFactory(new PropertyValueFactory<>("NumTel"));
		col_dest1.setCellValueFactory(new PropertyValueFactory<>("destination"));
		col_motant1.setCellValueFactory(new PropertyValueFactory<>("montant"));
		col_type1.setCellValueFactory(new PropertyValueFactory<>("typeBillet"));
		col_date.setCellValueFactory(new PropertyValueFactory<>("date"));
		col_Hdepart1.setCellValueFactory(new PropertyValueFactory<>("heure"));
		col_etat.setCellValueFactory(new PropertyValueFactory<>("etatR"));
		ResultSet RsR=passagerDAO.findAllReservation();
		if(RsR!=null) {
			try {
				//néttoyer le tableau d'abord avant de procéder au chargement
				ListeReservation.clear();
				while(RsR.next()) {
					Long id=RsR.getLong("ID_Passager");
					ListeReservation.add(passagerDAO.find(id));					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		tableR.setItems(ListeReservation);
		Outils.gestionAutoResev();
	}
}

