package application;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import DataBase.DAOfactory;
import DataBase.DepartDAO;
import DataBase.DestinationDAO;
import DataBase.LigneDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import metiers.Depart;
import metiers.Destination;
import metiers.Ligne;
import outils.Jours;
import outils.Outils;

public class LignesTransController2 implements Initializable {
	ObservableList<Destination> listeDestination=FXCollections.observableArrayList();
	ObservableList<Depart> listeDepart=FXCollections.observableArrayList();
	ObservableList<Ligne> listeLigne=FXCollections.observableArrayList();
	Depart departCourent=null;
	Destination destinationCourent=null;
	

    @FXML
    private TextField HeureDepart;

    @FXML
    private TableView<Destination> TableDest;

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
    private Button btn_annule_dest;

    @FXML
    private Button btn_valideDest;

    @FXML
    private Button btnannuleDepart;

    @FXML
    private Button btnvalideDepart;

    @FXML
    private Button voirLigne;

    @FXML
    private Button voirTarif;


    @FXML
    private TextField champRechDepart1;

    @FXML
    private TextField champRechDestination;

    @FXML
    private TableColumn<Destination, String> col_NomDest;

    @FXML
    private TableColumn<Destination, String> col_courier;
    
    @FXML
    private TableColumn<Destination, String> col_distance;

    @FXML
    private TableColumn<Depart, String> col_heure;

    @FXML
    private TableColumn<Destination, Long> col_id;

    @FXML
    private TableColumn<Depart, Long> col_idDespart;

    @FXML
    private TableColumn<Depart, String> col_jourD;

    @FXML 
    private TableColumn<Depart, String> col_ligne;
    
    @FXML
    private TableColumn<Depart, Integer> col_nbPlc;

    @FXML
    private TableColumn<Depart, Double> col_tarifA;

    @FXML
    private TableColumn<Depart, Double> col_tarifAR;
   
    @FXML
    private TableColumn<Depart, String> col_ligne2;


    @FXML
    private ComboBox<?> combTitreDepart1;

    @FXML
    private ComboBox<?> combTitreDestination;

    @FXML
    private ComboBox<?> comboDestination;

    @FXML
    private ComboBox<Jours> comboJour;

    @FXML
    private ComboBox<Ligne> comboLigne;

    @FXML
    private ComboBox<Ligne> comboLigne1;

    @FXML
    private TextField distance;

    @FXML
    private Spinner<Integer> nbrPlcs;
    @FXML
    private TextField nbrPlc;

    @FXML
    private TextField nom_dest;

    @FXML
    private TableView<Depart> table_depart;

    @FXML
    private TextField tarifA;

    @FXML
    private TextField tarifAR;
    
    DAOfactory DAOF=new DAOfactory();
    DepartDAO dapartDAO=DAOF.getDepartDAO();
    DestinationDAO destiDAO=DAOF.getDestinationDAO();

    @FXML
    void annuleDepart(ActionEvent event) {
    	comboJour.getSelectionModel().select(null);
		HeureDepart.setText(null);
		nbrPlc.setText(null);
		comboLigne1.getSelectionModel().select(null);
		
    }

    @FXML
    void annuleDest(ActionEvent event) {
    	nom_dest.setText(null);
		distance.setText(null);
		comboLigne.getSelectionModel().select(null);
    }

    @FXML
    void modifDestination(ActionEvent event) {
    	destinationCourent=TableDest.getSelectionModel().getSelectedItem();
    	if(destinationCourent!=null) {
    		nom_dest.setText(destinationCourent.getNomDestination());
    		distance.setText(String.valueOf(destinationCourent.getDistance()));
    	}
    }

    @FXML
    void modifDpart(ActionEvent event) {
    	 departCourent=table_depart.getSelectionModel().getSelectedItem();
    	if(departCourent!=null) {
    		comboJour.getSelectionModel().selectFirst();
    		HeureDepart.setText(departCourent.getHeure());
    		nbrPlc.setText(String.valueOf(departCourent.getNbrPlaces()));
    		
    	}
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
    	if(Outils.confirmer("Voullez-vous vraiment supprimer ce départ?")) {
    		Depart dep=table_depart.getSelectionModel().getSelectedItem();
    		dapartDAO.delete(dep);
    		listeDepart.remove(dep);
    		Outils.info("Depart supprimé avec succès");
    	}
    }

    @FXML
    void supDestination(ActionEvent event) {
    	if(Outils.confirmer("Voullez-vous vraiment supprimer cette destination?")) {
    		Destination des=TableDest.getSelectionModel().getSelectedItem();
    		destiDAO.delete(des);
    		listeDestination.remove(des);
    		Outils.info("Destination supprimé avec succès");
    	}
    }

    @FXML
    void valideDepart(ActionEvent event) {
    	if(
    			comboJour.getSelectionModel().getSelectedItem()!=null
    			&&distance.getText()!=null
    			&&comboLigne1.getSelectionModel().getSelectedItem()!=null
    			&&HeureDepart.getText()!=null
    	    ) {
	    		
	    		if(departCourent!=null) {
	    			if(Outils.confirmer("Voullez-vous vraiment sauvegarder les modifications?")) {
	    				int index=listeDepart.indexOf(departCourent);
	    				departCourent.setJour(comboJour.getSelectionModel().getSelectedItem().getJour());
	    				departCourent.setHeure(HeureDepart.getText());
	    				departCourent.setIdLigne(comboLigne1.getSelectionModel().getSelectedItem().getId());
	    				departCourent.setNbrPlaces(Integer.parseInt(nbrPlc.getText()));	    				
	    				departCourent=dapartDAO.update(departCourent);
	    				listeDepart.set(index, departCourent);
	        			departCourent=null;
	        			Outils.info("Modification éffectuée avec succès");
	    			}
	        	}else {
	        		Depart dep=new Depart(null, comboJour.getSelectionModel().getSelectedItem().getJour(), 
	        				HeureDepart.getText(), Integer.parseInt(nbrPlc.getText()), null);
	        		dep.setIdLigne(comboLigne1.getSelectionModel().getSelectedItem().getId());
	        		dep.setLigne(comboLigne1.getSelectionModel().getSelectedItem().getNom());
	        		dep.setIdDestination(1l);
	        		dapartDAO.create(dep);
	        		listeDepart.add(dep);
	        		Outils.info("Départ ajouté avec succès");
	        	}
    	}else {
    		Outils.erreur("Les champs ne doivent pas etre vides");
    	}
    	comboJour.getSelectionModel().select(null);
		HeureDepart.setText(null);
		nbrPlc.setText(null);
		comboLigne1.getSelectionModel().select(null);
		

    }

    @FXML
    void valideDest(ActionEvent event) {
    	if(
    			nom_dest.getText()!=null &&
    			distance.getText()!=null &&
    			comboLigne.getSelectionModel().getSelectedItem()!=null
    	    ) {
    		if(destinationCourent!=null) {
    			if(Outils.confirmer("Voullez-vous vraiment sauvegarder les modifications?")) {
    				int index=listeDestination.indexOf(destinationCourent);
    				destinationCourent.setNomDestination(nom_dest.getText()); 
    				destinationCourent.setDistance(Double.parseDouble(distance.getText())); 
    				destinationCourent.setIdLigne(comboLigne.getSelectionModel().getSelectedItem().getId());	
    				destinationCourent=destiDAO.update(destinationCourent);
    				listeDestination.set(index, destinationCourent);
    				destinationCourent=null;
        			Outils.info("Modification éffectuée avec succès");
    			}
        	}else {
        		Destination desti=new Destination(null, nom_dest.getText(), Double.valueOf(distance.getText()));
        		desti.setIdLigne(comboLigne.getSelectionModel().getSelectedItem().getId());
        		desti.setLigne(comboLigne.getSelectionModel().getSelectedItem().getNom());
        		desti=destiDAO.create(desti);
        		listeDestination.add(desti);
        		Outils.info("Destination ajoutée avec succès");
        		nom_dest.setText(null);
    			distance.setText(null);
    			comboLigne.getSelectionModel().select(null);
        	}
    	}

    }
    

    @FXML
    void OnvoirLTarif(ActionEvent event) {
    	try {
			Parent parent=FXMLLoader.load(getClass().getResource("Recu.fxml"));
			Scene scene=new Scene(parent,720,500);
			Stage stage=new Stage();
			stage.setScene(scene);
			stage.setTitle("Billets");
			stage.setResizable(false);
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    @FXML
    void OnvoirLinge(ActionEvent event) {
    	try {
			Parent parent=FXMLLoader.load(getClass().getResource("Trajet.fxml"));
			Scene scene=new Scene(parent,600,400);
			Stage stage=new Stage();
			stage.setScene(scene);
			stage.setTitle("Lignes");
			stage.setResizable(false);
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//nbrPlcs= new Spinner<>(1, 500, 1);
		col_idDespart.setCellValueFactory(new PropertyValueFactory<>("id"));
		col_jourD.setCellValueFactory(new PropertyValueFactory<>("jour"));
		col_heure.setCellValueFactory(new PropertyValueFactory<>("heure"));
		col_ligne2.setCellValueFactory(new PropertyValueFactory<>("ligne"));
		col_nbPlc.setCellValueFactory(new PropertyValueFactory<>("nbrPlaces"));

		ResultSet result=dapartDAO.findAll();
		try {
			while(result.next()) {
				Depart depart=dapartDAO.find(result.getLong("ID_depart"));
				if(depart!=null)
					listeDepart.add(depart);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(listeDepart!=null)
			table_depart.setItems(listeDepart);
		
		
		
		
		col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
		col_NomDest.setCellValueFactory(new PropertyValueFactory<>("NomDestination"));
		col_distance.setCellValueFactory(new PropertyValueFactory<>("distance"));
		col_ligne.setCellValueFactory(new PropertyValueFactory<>("ligne"));
		
		result=destiDAO.findAll();
		try {
			while(result.next()) {
				Destination desti=destiDAO.find(result.getLong("ID_destination"));
				if(desti!=null)
					listeDestination.add(desti);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(listeDepart!=null)
			TableDest.setItems(listeDestination);
		
		ObservableList<Jours> jours=FXCollections.observableArrayList();
		jours.add(new Jours("Lundi",1,"Lun"));
		jours.add(new Jours("Mardi",2,"Mar"));
		jours.add(new Jours("Mercredi",3,"Mer"));
		jours.add(new Jours("Jeudi",4,"Jeu"));
		jours.add(new Jours("Vendredi",5,"Ven"));
		jours.add(new Jours("Samedi",6,"Sam"));
		jours.add(new Jours("Dimanche",7,"Dim"));
		comboJour.setItems(jours);
		LigneDAO ligneDAO =DAOF.getLigneDAO();
		ResultSet rs=ligneDAO.findAll();
		if(rs!=null) {
			//Long id=0l;
			try {
				while(rs.next()) {
					Ligne l=ligneDAO.find(rs.getLong("ID_ligne"));
					listeLigne.add(l);
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			comboLigne.setItems(listeLigne);
			comboLigne1.setItems(listeLigne);
		}
		
		
	}
	
}
