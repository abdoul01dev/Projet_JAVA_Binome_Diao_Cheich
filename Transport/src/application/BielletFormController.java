package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

import javafx.stage.Stage;


import javafx.scene.control.Alert.AlertType;
import metiers.Billet;
import metiers.Depart;
import metiers.Destination;
import metiers.Passager;
import outils.Outils;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.util.Optional;
import java.util.ResourceBundle;

import DataBase.DAOfactory;
import DataBase.DestinationDAO;
import DataBase.PassagerDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.scene.control.Label;

import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;

public class BielletFormController extends BaseController implements Initializable{
	//variable indicateur de la manière dont la fenetre sera ouverte ie en mode passager ou en mode reservation
	public static int indiacteur;
	//variable determinant l'action à effectuer ie ajout ou modification
	public static int action;
	//le passager temporaire pour les opération de modification
	public static Passager tmpPassager;
	//liste de choix pour le combo destination
	ObservableList<Destination> destination= FXCollections.observableArrayList();
	//liste de choix pour le combo depart
	ObservableList<Depart> depart= FXCollections.observableArrayList();
	//liste de choix pour le combo type de billet
	ObservableList<String> type= FXCollections.observableArrayList();
	@FXML
	private DatePicker dateV;
	@FXML
	private Label labID;
	@FXML
	private TextField champNom;
	@FXML
	private TextField champPrenom;
	@FXML
	private TextField champTel;
	@FXML
	private ComboBox<Destination> CombDest;
	@FXML
	private ComboBox<Billet> CombType;
	@FXML
	private ComboBox <Depart>CombDep;
	@FXML
	private Label labMontant;
	@FXML
	private Button btnAnnuler;
	@FXML
	private Button btnVF;
	@FXML
	private Button btnValider;

	// Event Listener on ComboBox[#CombDest].onAction
	@FXML
	public void ActCombDest(ActionEvent event) {
		// TODO Autogenerated
	}
	// Event Listener on ComboBox[#CombType].onAction
	@FXML
	public void ActCopType(ActionEvent event) {
		Billet billet= CombType.getSelectionModel().getSelectedItem();
	    if(billet!=null) {
	    	labMontant.setText(billet.getPrix());
	    }else {
	    	labMontant.setText("");
	    }
	}
	// Event Listener on ComboBox[#CombDep].onAction
	@FXML
	public void ActComboDep(ActionEvent event) {
		
	}
	// Event Listener on Button[#btnAnnuler].onAction
	@FXML
	public void annuler(ActionEvent event) {
		Stage stage=(Stage)CombDep.getScene().getWindow();
		stage.close();
	}
	// Event Listener on Button[#btnVF].onAction
	@FXML
	public void valFerm(ActionEvent event) {
		Valider(event);
		Stage stage=(Stage)CombDep.getScene().getWindow();
		stage.close();
	}
	// Event Listener on Button[#btnValider].onAction
	@FXML
	public void Valider(ActionEvent event) {
		//Outils u=new Outils();
		DAOfactory DAOF=new DAOfactory();
		PassagerDAO passagerDAO=DAOF.getPassagerDAO();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		//pour un nouveau passager
		if(action==0) {
			
			if(champNom.equals(null)||champPrenom.equals(null)||CombDep.getSelectionModel().isEmpty()
					||CombDest.getSelectionModel().isEmpty()||CombType.getSelectionModel().isEmpty()) {
				Outils.erreur("Des champs réquis n'ont pas été saisie");
			}else {
				LocalDate date = LocalDate.now();
				String sdate=formatter.format(date);
				Passager passager=new Passager(null, champNom.getText(), champPrenom.getText(), null, 0, champTel.getText(),
						CombType.getSelectionModel().getSelectedItem().getId(),
						CombDest.getSelectionModel().getSelectedItem().getId(), 
						Double.parseDouble(labMontant.getText()), CombDep.getSelectionModel().getSelectedItem().getId(), sdate);
				passager.setCode(labID.getText());
				passager.setDate_Enreg(Outils.DateEnChaine(LocalDate.now()));
				
				if(indiacteur==0) {
					passager.setTypePassager(1);
					passager.setEtat(1);
					passager=passagerDAO.create(passager);
					BilletController.ListePassager.add(passager);
					Outils.info("Passager ajouté avec succès");
					DashBordController.nbPassager++;
					TicketController.passager=passager;
					try {
						Parent parent=FXMLLoader.load(getClass().getResource("Ticket.fxml"));
						Scene scene=new Scene(parent,720,500);
						Stage stage=new Stage();
						stage.setScene(scene);
						stage.setTitle("Enregistrement de colis sortant");
						stage.setResizable(false);
						stage.show();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else {
					
					if(dateV.getValue()!=null) {
						passager.setTypePassager(2);
						passager.setEtat(2);
						passager.setDate(formatter.format(dateV.getValue()));
						passager=passagerDAO.create(passager);						
						BilletController.ListeReservation.add(passager);
						Outils.info("Réservation ajoutée avec succès");
						DashBordController.nbreservation++;
					}else {
						Outils.erreur("Vous n'avez pas choisi la date du voyage");
					}
				}
			}
		//sinon si c'est une mise à jour
		}else {
			if(champNom.equals(null)||champPrenom.equals(null)||CombDep.getSelectionModel().getSelectedItem().equals(null)
					||CombDest.getSelectionModel().getSelectedItem().equals(null)||CombType.getSelectionModel().getSelectedItem().equals(null)) {
				/*System.out.println("Donnée manquante");
				System.out.println(CombType.getSelectionModel().getSelectedItem().getId());*/
				Outils.erreur("Des champs réquis n'ont pas été saisie");
			}else {
				//LocalDate date = LocalDate.now();
				//String sdate=formatter.format(date);
				Passager passager=new Passager(null, champNom.getText(), champPrenom.getText(), null, 0, champTel.getText(),
						CombType.getSelectionModel().getSelectedItem().getId(),
						CombDest.getSelectionModel().getSelectedItem().getId(), 
						Double.parseDouble(labMontant.getText()), CombDep.getSelectionModel().getSelectedItem().getId(), tmpPassager.getDate());
				//passager.setCode(labID.getText());
				//passager.setTypePassager(1);
				passager.setId(tmpPassager.getId());
				passager.setCode(tmpPassager.getCode());
				if(indiacteur==0) {
					if(confirmer("Voullez-vous vraiment modifié ce passager?")) {
						passager=passagerDAO.update(passager);
						int index=BilletController.ListePassager.indexOf(tmpPassager);
						if(index!=-1) {
							BilletController.ListePassager.set(index, passager);
							Outils.info("Passager modifié avec succès");
						}	
						Stage stage=(Stage)CombDep.getScene().getWindow();
						//reinitialiser le passager temporaire à null
						tmpPassager=null;
						stage.close();
					}
				}else {
					if(confirmer("Voullez-vous vraiment modifié cette réservation?")) {
						passager=passagerDAO.update(passager);
						int index=BilletController.ListeReservation.indexOf(tmpPassager);
						if(index!=-1) {
							BilletController.ListeReservation.set(index, passager);
							Outils.info("Résevation modifié avec succès");
						}							
						Stage stage=(Stage)CombDep.getScene().getWindow();
						//reinitialiser le passager temporaire à null
						tmpPassager=null;
						stage.close();
					}
				}
			}
		}
		
	}
	
	private boolean confirmer(String message) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText(null);
        alert.setContentText(message);

        
        ButtonType buttonTypeYes = new ButtonType("Oui");
        ButtonType buttonTypeNo = new ButtonType("Non");
        alert.getButtonTypes().setAll(buttonTypeYes, buttonTypeNo);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == buttonTypeYes) {
        	return true;
        } else {
        	return false;
        }
    }
	
	//@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		DAOfactory DAOF=new DAOfactory();
		PassagerDAO passagerDAO=DAOF.getPassagerDAO();
		Long idMax=0l;
		//gestion de la visibilité du champ date
		if(indiacteur==0) {
			dateV.setVisible(false);
			//sinitialiser la valeur de l'id du nouveau passager
			idMax=passagerDAO.idMax();
			String code=String.format("PA-%04d", idMax);
			labID.setText(code);
			//si c'est une mise à jour initialisé les variable
			if(action==1) {
				Depart depart=DAOF.getDepartDAO().find(tmpPassager.getDepart());
				Destination destination=DAOF.getDestinationDAO().find(tmpPassager.getIdDestination());
				Billet billet=DAOF.getBilletDAO().find(tmpPassager.getIdBillet());
				champNom.setText(tmpPassager.getNom());
				champPrenom.setText(tmpPassager.getPrenom());
				champTel.setText(tmpPassager.getNumTel());
				CombDep.getSelectionModel().select(depart);
				CombDest.getSelectionModel().select(destination);
				CombType.getSelectionModel().select(billet);
				labMontant.setText(String.valueOf(tmpPassager.getMontant()));
				labID.setText(tmpPassager.getCode());
			}else {
				champNom.setText(null);
				champPrenom.setText(null);
				champTel.setText(null);
				CombDep.getSelectionModel().select(null);
				CombDest.getSelectionModel().select(null);
				CombType.getSelectionModel().select(null);
				labMontant.setText(null);
			}
		}
		else { 
			dateV.setVisible(true);
			idMax=passagerDAO.idMax();
			String code=String.format("RE-%04d", idMax);
			labID.setText(code);
			if(action==1) {
				Depart depart=DAOF.getDepartDAO().find(tmpPassager.getDepart());
				Destination destination=DAOF.getDestinationDAO().find(tmpPassager.getIdDestination());
				Billet billet=DAOF.getBilletDAO().find(tmpPassager.getIdBillet());
				champNom.setText(tmpPassager.getNom());
				champPrenom.setText(tmpPassager.getPrenom());
				champTel.setText(tmpPassager.getNumTel());
				CombDep.getSelectionModel().select(depart);
				CombDest.getSelectionModel().select(destination);
				CombType.getSelectionModel().select(billet);
				labMontant.setText(String.valueOf(tmpPassager.getMontant()));
				labID.setText(tmpPassager.getCode());
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				LocalDate localDate = LocalDate.parse(tmpPassager.getDate(), formatter);
				dateV.setValue(localDate);
				
			}else {
				champNom.setText(null);
				champPrenom.setText(null);
				champTel.setText(null);
				CombDep.getSelectionModel().select(null);
				CombDest.getSelectionModel().select(null);
				CombType.getSelectionModel().select(null);
				labMontant.setText(null);
			}
		}
		
		
		//DAOfactory DAOF=new DAOfactory();
		DestinationDAO destinationDAO= DAOF.getDestinationDAO();
		
		ResultSet Rs= destinationDAO.findAll();
		try {
			while(Rs.next()) {
				Long id=Rs.getLong("ID_Destination");
				Destination dest=destinationDAO.find(id);
				//System.out.println(dest.getLesBillet().isEmpty());
				if(dest!=null)
					destination.add(dest);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CombDest.setItems(destination);
		CombDest.getSelectionModel().selectFirst();
		
		//remplir le combo depart au clic sur celui-ci en fonction de la destination choisie
		CombDep.setOnMouseClicked(event->{
			 Destination selectedDestination = CombDest.getSelectionModel().getSelectedItem();

			    if (selectedDestination != null) {
			        ObservableList<Depart> departList = selectedDestination.getLesDaparts();
			        if (departList != null) {
			            CombDep.setItems(departList);
			            
			        } else {
			        	System.out.println("Ko");
			        }
			    }
		});
		
		
		//remplir le combo billet au clic sur celui-ci en fonction de la destination choisie
		 CombType.setOnMouseClicked(event->{
			 Destination selectedDestination = CombDest.getSelectionModel().getSelectedItem();

			    if (selectedDestination != null) {
			        ObservableList<Billet> billetList = selectedDestination.getLesBillet();
			        if (billetList!= null) {
			            CombType.setItems(billetList);
			            //CombType.getSelectionModel().selectFirst();
			         
			        } else {
			        	CombDep.setItems(null);
			        	Alert alert = new Alert(AlertType.WARNING);
			            alert.setTitle("Alert");
			            alert.setHeaderText("\"Veuillez sélectionner le départ d'abord\"");
			            alert.setContentText("Veuillez sélectionner le départ d'abord");
			            alert.showAndWait();
			        }
			        
			        ObservableList<Depart> departList = selectedDestination.getLesDaparts();
			        if (departList != null) {
			            CombDep.setItems(departList);
			            
			        } else {
			        	System.out.println("Ko");
			        }
			    }
			     
		});
		
		 champTel.setTextFormatter(Outils.formater());
		
		
	}
}
