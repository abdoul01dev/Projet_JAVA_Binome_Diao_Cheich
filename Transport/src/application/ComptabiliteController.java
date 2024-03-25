package application;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import DataBase.CaisseDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import metiers.Caisse;
import outils.Outils;

public class ComptabiliteController implements Initializable{

	public static ObservableList<Caisse> listeCaisse=FXCollections.observableArrayList();
	CaisseDAO caisseDAO=new CaisseDAO();
    @FXML
    private DatePicker au;

    @FXML
    private Label billet;

    @FXML
    private Button btnAnnule;

    @FXML
    private Button btnValider;
    @FXML
    private Button btnOk;

    @FXML
    private Label colis;

    @FXML
    private Label courrier;

    @FXML
    private TableColumn<Caisse, String> date;

    @FXML
    private Label depense;

    @FXML
    private DatePicker du;

    @FXML
    private TableColumn<Caisse, Long> id;

    @FXML
    private TableColumn<Caisse, String> justif;

    @FXML
    private TableColumn<Caisse, Double> montant;

    @FXML
    private Label reserv;

    @FXML
    private TableColumn<Caisse, String> responsable;

    @FXML
    private TextField sai_justif;

    @FXML
    private TextField sai_montant;

    @FXML
    private Label solde;

    @FXML
    private TableView<Caisse> tableDepense;

    
    public void calculateur() {
    	ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        Runnable task = () -> {
        	
        	depense.setText(String.valueOf(caisseDAO.getMDepense(null,null))+" FCFA");
    		reserv.setText(String.valueOf(caisseDAO.getMreservation(null,null))+" FCFA");
    		billet.setText(String.valueOf(caisseDAO.getMbillet(null,null))+" FCFA");
    		colis.setText(String.valueOf(caisseDAO.getMcolis(null, null))+" FCFA");
    		courrier.setText(String.valueOf(caisseDAO.getMcourriers(null, null))+" FCFA");
    		solde.setText(String.valueOf(caisseDAO.getSolde(null, null))+" FCFA");
        	 
        };
        int intervalInSeconds = 10;
        scheduler.scheduleAtFixedRate(task, 0, intervalInSeconds, TimeUnit.SECONDS);
    }
    
    @FXML
    void annuler(ActionEvent event) {

    	sai_montant.clear();
    	sai_justif.clear();
    }

    @FXML
    void valider(ActionEvent event) {

    	if(!sai_montant.getText().isEmpty()&& !sai_justif.getText().isEmpty()) {
    		if(Outils.confirmer("Voulez-vous vraiment ajouter cette depense? "
    				+ "Vous ne pourrez pas la supprimer et la modifier")) {
    			Caisse caisse=new Caisse(null, Outils.DateEnChaine(LocalDate.now()),
    					sai_justif.getText(), null, Double.parseDouble(sai_montant.getText()), 1);
    			if(MenuController.utilisateur!=null) {
    				caisse.setResponsable(MenuController.utilisateur.getNomUt());
    			}
    			caisse=caisseDAO.create(caisse);
    			if(caisse!=null) {
    				listeCaisse.add(caisse);
    				annuler(event);
    				depense.setText(String.valueOf(caisseDAO.getMDepense(null,null))+" FCFA");
    	    		reserv.setText(String.valueOf(caisseDAO.getMreservation(null,null))+" FCFA");
    	    		billet.setText(String.valueOf(caisseDAO.getMbillet(null,null))+" FCFA");
    	    		colis.setText(String.valueOf(caisseDAO.getMcolis(null, null))+" FCFA");
    	    		courrier.setText(String.valueOf(caisseDAO.getMcourriers(null, null))+" FCFA");
    	    		solde.setText(String.valueOf(caisseDAO.getSolde(null, null))+" FCFA");
    			}
    		}
    	}else {
    		Outils.erreur("Tous les champs sont obligatoires");
    	}
    }
    
    @FXML
    void ok(ActionEvent event) {
    	if(du.getValue()!=null &&au.getValue()!=null) {
    		if(du.getValue().isBefore(au.getValue())||du.getValue().isEqual(au.getValue()) ) {
    			String dateDu= Outils.DateEnChaine(du.getValue());
            	String dateAu= Outils.DateEnChaine(au.getValue());
            	miseAjour(dateDu,dateAu);
    		}else {
    			Outils.erreur("L'intervalle de date que vous avez choisie est incorrect");
    		}
    		
    	}else {
    		Outils.erreur("Veuillez choisir un intervalle de date");
    	}
    	
    }
    
    public void miseAjour(String dateDu,String dateAu) {
    	if(dateDu!=null && dateAu!=null) {
    		depense.setText(String.valueOf(caisseDAO.getMDepense(dateDu,dateAu))+" FCFA");
    		reserv.setText(String.valueOf(caisseDAO.getMreservation(dateDu,dateAu))+" FCFA");
    		billet.setText(String.valueOf(caisseDAO.getMbillet(dateDu,dateAu))+" FCFA");
    		colis.setText(String.valueOf(caisseDAO.getMcolis(dateDu, dateAu))+" FCFA");
    		courrier.setText(String.valueOf(caisseDAO.getMcourriers(dateDu, dateAu))+" FCFA");
    		solde.setText(String.valueOf(caisseDAO.getSolde(dateDu, dateAu))+" FCFA");
    	}else if(dateDu==null || dateAu==null){
    		Outils.erreur("Veuillez choisir un intervalle de date");
    	}else if(LocalDate.parse(dateDu).isAfter(LocalDate.parse(dateAu))) {
    		Outils.erreur("L'intervalle de date que vous avez choisie est incorrect");
    	}else {
    		depense.setText(String.valueOf(caisseDAO.getMDepense(null,null))+" FCFA");
    		reserv.setText(String.valueOf(caisseDAO.getMreservation(null,null))+" FCFA");
    		billet.setText(String.valueOf(caisseDAO.getMbillet(null,null))+" FCFA");
    		colis.setText(String.valueOf(caisseDAO.getMcolis(null, null))+" FCFA");
    		courrier.setText(String.valueOf(caisseDAO.getMcourriers(null, null))+" FCFA");
    		solde.setText(String.valueOf(caisseDAO.getSolde(null, null))+" FCFA");
    	}
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		id.setCellValueFactory(new PropertyValueFactory<>("id"));
		date.setCellValueFactory(new PropertyValueFactory<>("date"));
		justif.setCellValueFactory(new PropertyValueFactory<>("justification"));
		responsable.setCellValueFactory(new PropertyValueFactory<>("responsable"));
		montant.setCellValueFactory(new PropertyValueFactory<>("montant"));
		ResultSet Rs=caisseDAO.findAll();
		try {
			listeCaisse.clear();
			while(Rs.next()) {
				listeCaisse.add(caisseDAO.find(Rs.getLong("ID_caisse")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tableDepense.setItems(listeCaisse);
		
		calculateur();
		sai_montant.setTextFormatter(Outils.formater());
	}

}
