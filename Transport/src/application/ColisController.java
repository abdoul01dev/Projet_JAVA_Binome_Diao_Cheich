package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import metiers.Colis;
import metiers.Courrier;
import outils.Outils;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import DataBase.ColisDAO;
import DataBase.CourierDAO;
import DataBase.DAOfactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ColisController implements Initializable {
	public static ObservableList<Colis> listecolisSortant= FXCollections.observableArrayList();
	public static ObservableList<Colis> listecolisEntrant= FXCollections.observableArrayList();
	public static ObservableList<Courrier> listecourierSortant= FXCollections.observableArrayList();
	public static ObservableList<Courrier> listecourierEntant= FXCollections.observableArrayList();
	
	DAOfactory DAOF=new DAOfactory();
	ColisDAO colisDAO=DAOF.getColisDAO();
	CourierDAO courierDAO=DAOF.getCourierDAO();
	Outils outil=new Outils();
	@FXML
	private Button btnNewColisS;
	@FXML
	private Button btnModifColisS;
	@FXML
	private Button btnSupColisS;
	@FXML
	private ComboBox combTitreColisS;
	@FXML
	private TextField champRechColisS;
	@FXML
	private Button btnRechColisS;
	@FXML
	private Button btnNewColisE;
	@FXML
	private Button btnModifColisE;
	@FXML
	private Button btnSupColisE;
	@FXML
	private ComboBox combTitreColisE;
	@FXML
	private TextField champRechColisE;
	@FXML
	private Button btnRechColisE;
	@FXML
	private Button btnNewCourierS;
	@FXML
	private Button btnModifCourierS;
	@FXML
	private Button btnSupCourierS;
	@FXML
	private ComboBox combTitreCourierS;
	@FXML
	private TextField champRechCourierS;
	@FXML
	private Button btnRechCourierS;
	@FXML
	private Button btnNewCourierE;
	@FXML
	private Button btnModifCourierE;
	@FXML
	private Button btnSupCourierE;
	@FXML
	private ComboBox combTitreCourierE;
	@FXML
	private TextField champRechCourierE;
	@FXML
	private Button btnRechCourierE;
	
	
	
//table colis Entrant
    @FXML
    private TableView<Colis> tableColisEntrant;   
    @FXML
    private TableColumn<?, ?> col_valeur20;
    @FXML
    private TableColumn<Colis, String> col_dateRetrait21;
    @FXML
    private TableColumn<Colis, String> col_date_entrer20;
    @FXML
    private TableColumn<Colis, String> col_destin20;
    @FXML
    private TableColumn<Colis, String> col_nom20;
    @FXML
    private TableColumn<Colis, String> col_nom21;
    @FXML
    private TableColumn<Colis, String> col_id20;
    @FXML
    private TableColumn<Colis, String> col_num20;
    @FXML
    private TableColumn<Colis, String> col_num21;
    @FXML
    private TableColumn<Colis, String> col_prenom20;
    @FXML
    private TableColumn<Colis, String> col_prenom21;
    @FXML
    private TableColumn<Colis, Double> col_frais20;

    
//table colis sortant
    @FXML
    private TableView<Colis> tableColisSortant;
    @FXML
    private TableColumn<Colis, String> col_prenom10;
    @FXML
    private TableColumn<Colis, String> col_prenom11;
    @FXML
    private TableColumn<Colis, String> col_date_rep1;
    @FXML
    private TableColumn<Colis, String>col_date_sort10;
    @FXML
    private TableColumn<Colis, String> col_descrip1;
    @FXML
    private TableColumn<Colis, String> col_description;
    @FXML
    private TableColumn<Colis, String> col_dest10;
    @FXML
    private TableColumn<Colis, String> col_expedit10;
    @FXML
    private TableColumn<Colis, String> col_provenace;
    @FXML
    private TableColumn<Colis, Double> col_valeur1;
    @FXML
    private TableColumn<Colis, String> col_id10;
    @FXML
    private TableColumn<Colis, String> col_num10;
    @FXML
    private TableColumn<Colis, String>col_num11;
    @FXML
    private TableColumn<Colis, String> col_nom10;
    @FXML
    private TableColumn<Colis, String> col_nom11;
    @FXML
    private TableColumn<Colis, Double> col_frais10;

 //table couriers entrant
	@FXML
    private TableView<Courrier> TableCourierEntrant;
	@FXML
    private TableColumn<Courrier,String> clo_num41;
    @FXML
    private TableColumn<Courrier,String> col_dateEntre41;
    @FXML
    private TableColumn<Courrier,String> col_dateRetrai41;
    @FXML
    private TableColumn<Courrier,String> col_dest41;
    @FXML
    private TableColumn<Courrier,String> col_expedit41;
    @FXML
    private TableColumn<Courrier,String> col_nom41;
    @FXML
    private TableColumn<Courrier,String> col_nom42;
    @FXML
    private TableColumn<Courrier,String> col_prenom41;
    @FXML
    private TableColumn<Courrier,String> col_prenom42;
    @FXML
    private TableColumn<Courrier,String> col_proven41;
    @FXML
    private TableColumn<Courrier,String> col_id41;
    @FXML
    private TableColumn<Courrier,String> col_num42;

    
    
  //table couriers sortant
    @FXML
    private TableView<Courrier> TablecourierSortant;
    @FXML
    private TableColumn<Courrier,String> col_dateRecep31;
    @FXML
    private TableColumn<Courrier,String> col_dateSortie31;
    @FXML
    private TableColumn<Courrier,String> col_destin31;
    @FXML
    private TableColumn<Courrier,String> col_expedit31;
    @FXML
    private TableColumn<Courrier,String> col_id31;
    @FXML
    private TableColumn<Courrier,String> col_nom31;
    @FXML
    private TableColumn<Courrier,String> col_nom32;
    @FXML
    private TableColumn<Courrier,String> col_num31;
    @FXML
    private TableColumn<Courrier,String> col_num32;
    @FXML
    private TableColumn<Courrier,String> col_prenom31;
    @FXML
    private TableColumn<Courrier,String> col_prenom32;
    @FXML
    private TableColumn<Courrier,String> col_frais30;

    
    
    
	
	
	//le controlleur de courier pour le choix du type de courier
	//private CourierSFormController =new CourierSFormController();

	// Event Listener on Button[#btnNewColisS].onAction
	@FXML
	public void newColisS(ActionEvent event) {
		// TODO Autogenerated
		ColisFormController.indicateur=0;
		ColisFormController.tmpcolis=null;
		try {
			Parent parent=FXMLLoader.load(getClass().getResource("ColisForm.fxml"));
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
	}
	// Event Listener on Button[#btnModifColisS].onAction
	@FXML
	public void modifColisS(ActionEvent event) {
		Colis colis=tableColisSortant.getSelectionModel().getSelectedItem();
		if(colis!=null) {
			ColisFormController.indicateur=1;
			ColisFormController.tmpcolis=colis;
			System.out.println(colis.getId()+"***");
			try {
				Parent parent=FXMLLoader.load(getClass().getResource("ColisForm.fxml"));
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
			Outils.erreur("Veuillez sélectionner un colis");
		}
	}
	// Event Listener on Button[#btnSupColisS].onAction
	@FXML
	public void supColisS(ActionEvent event) {
		Colis colis=tableColisSortant.getSelectionModel().getSelectedItem();
		if(colis!=null) {
			if(Outils.confirmer("Voulez vous vraiment suprimer ce colis? ")) {
				colisDAO.delete(colis);
				listecolisSortant.remove(colis);
			}
			
		}else {
			Outils.erreur("Veuillez sélectionner un colis");
		}
	}
	// Event Listener on Button[#btnRechColisS].onAction
	@FXML
	public void rechercheColisS(ActionEvent event) {
		// TODO Autogenerated
	}
	// Event Listener on Button[#btnNewColisE].onAction
	@FXML
	public void newColisE(ActionEvent event) {
		// TODO Autogenerated
		ColisEFormeController.indicateur=0;
		ColisEFormeController.tmpcolis=null;
		try {
			Parent parent=FXMLLoader.load(getClass().getResource("ColisEForme.fxml"));
			Scene scene=new Scene(parent,720,500);
			Stage stage=new Stage();
			stage.setScene(scene);
			stage.setTitle("Enregistrement de colis entrant");
			stage.setResizable(false);
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// Event Listener on Button[#btnModifColisE].onAction
	@FXML
	public void modifColisE(ActionEvent event) {
		Colis colis=tableColisEntrant.getSelectionModel().getSelectedItem();
		if(colis!=null) {
			ColisEFormeController.indicateur=1;
			ColisEFormeController.tmpcolis=colis;
			System.out.println(colis.getId()+"***");

			try {
				Parent parent=FXMLLoader.load(getClass().getResource("ColisEForme.fxml"));
				Scene scene=new Scene(parent,720,500);
				Stage stage=new Stage();
				stage.setScene(scene);
				stage.setTitle("Modification de colis");
				stage.setResizable(false);
				stage.show();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			Outils.erreur("Veuillez sélectionner un colis");
		}
	}
	// Event Listener on Button[#btnSupColisE].onAction
	@FXML
	public void supColisE(ActionEvent event) {
		Colis colis=tableColisEntrant.getSelectionModel().getSelectedItem();
		if(colis!=null) {
			if(Outils.confirmer("Voulez vous vraiment suprimer ce colis? ")) {
				colisDAO.delete(colis);
				listecolisEntrant.remove(colis);
			}
			
		}else {
			Outils.erreur("Veuillez sélectionner un colis");
		}
	}
	// Event Listener on Button[#btnRechColisE].onAction
	@FXML
	public void rechercheColisE(ActionEvent event) {
		// TODO Autogenerated
	}
	// Event Listener on Button[#btnNewCourierS].onAction
	@FXML
	public void NewCourierS(ActionEvent event) {
		// TODO Autogenerated
		
		try {
			Parent parent=FXMLLoader.load(getClass().getResource("CourierSForm.fxml"));
			Scene scene=new Scene(parent,720,500);
			Stage stage=new Stage();
			stage.setScene(scene);
			stage.setTitle("Enregistrement de colis entrant");
			stage.setResizable(false);
			stage.show();
			CourierSFormController.indicateur=0;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// Event Listener on Button[#btnModifCourierS].onAction
	@FXML
	public void modifCourierS(ActionEvent event) {
		Courrier courrier=TablecourierSortant.getSelectionModel().getSelectedItem();
		if(courrier!=null) {
			CourierSFormController.indicateur=1;
			CourierSFormController.tmpcourier=courrier;
			try {
				Parent parent=FXMLLoader.load(getClass().getResource("CourierSForm.fxml"));
				Scene scene=new Scene(parent,720,500);
				Stage stage=new Stage();
				stage.setScene(scene);
				stage.setTitle("modification de colis entrant");
				stage.setResizable(false);
				stage.show();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			Outils.erreur("Veuillez sélectionner un colis");
		}
		
	}
	// Event Listener on Button[#btnSupCourierS].onAction
	@FXML
	public void supprimeCourierS(ActionEvent event) {
		Courrier courier=TablecourierSortant.getSelectionModel().getSelectedItem();
		if(courier!=null) {
			if(Outils.confirmer("Voulez vous vraiment suprimer ce courier? ")) {
				courierDAO.delete(courier);
				listecourierSortant.remove(courier);
			}
		}else {
			Outils.erreur("Veuillez sélectionner un courrier");
		}
	}
	// Event Listener on Button[#btnRechCourierS].onAction
	@FXML
	public void rechercheCourierS(ActionEvent event) {
		// TODO Autogenerated
	}
	// Event Listener on Button[#btnNewCourierE].onAction
	@FXML
	public void newCourierE(ActionEvent event) {
		// TODO Autogenerated
		try {
			Parent parent=FXMLLoader.load(getClass().getResource("CourierEForm.fxml"));
			Scene scene=new Scene(parent,720,500);
			Stage stage=new Stage();
			stage.setScene(scene);
			stage.setTitle("Enregistrement de colis entrant");
			stage.setResizable(false);
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	// Event Listener on Button[#btnModifCourierE].onAction
	@FXML
	public void modifCourierE(ActionEvent event) {
		Courrier courier=TableCourierEntrant.getSelectionModel().getSelectedItem();
		if(courier!=null) {
			CourierEFormController.indicateur=1;
			CourierEFormController.tmpcourier=courier;
			try {
				Parent parent=FXMLLoader.load(getClass().getResource("CourierEForm.fxml"));
				Scene scene=new Scene(parent,720,500);
				Stage stage=new Stage();
				stage.setScene(scene);
				stage.setTitle("Enregistrement de colis entrant");
				stage.setResizable(false);
				stage.show();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	// Event Listener on Button[#btnSupCourierE].onAction
	@FXML
	public void supprimeCourierE(ActionEvent event) {
		Courrier courier=TableCourierEntrant.getSelectionModel().getSelectedItem();
		if(courier!=null) {
			if(Outils.confirmer("Voulez vous vraiment suprimer ce courier? ")) {
				courierDAO.delete(courier);
				listecourierEntant.remove(courier);
			}
		}else {
			Outils.erreur("Veuillez sélectionner un courrier");
		}
	}
	// Event Listener on Button[#btnRechCourierE].onAction
	@FXML
	public void rechercheCourierE(ActionEvent event) {
		// TODO Autogenerated
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		DAOfactory DAOF=new DAOfactory();
		ColisDAO colisDAO=DAOF.getColisDAO();
		ResultSet Rs=null;
		//Colis colis=null;
		Long id=null;
	
		//colis sortants
		col_id10.setCellValueFactory(new PropertyValueFactory<>("code"));
		col_nom10.setCellValueFactory(new PropertyValueFactory<>("nomE"));
		col_prenom10.setCellValueFactory(new PropertyValueFactory<>("prenomE"));
		col_num10.setCellValueFactory(new PropertyValueFactory<>("numE"));
		col_nom11.setCellValueFactory(new PropertyValueFactory<>("nomD"));
		col_prenom11.setCellValueFactory(new PropertyValueFactory<>("prenomD"));
		col_num11.setCellValueFactory(new PropertyValueFactory<>("numD"));
		col_dest10.setCellValueFactory(new PropertyValueFactory<>("destination"));
		col_descrip1.setCellValueFactory(new PropertyValueFactory<>("description"));
		col_date_sort10.setCellValueFactory(new PropertyValueFactory<>("dateSortie"));
		col_date_rep1.setCellValueFactory(new PropertyValueFactory<>("dateRecep"));
		col_valeur1.setCellValueFactory(new PropertyValueFactory<>("valeur"));
		col_frais10.setCellValueFactory(new PropertyValueFactory<>("frais"));
		Rs=colisDAO.findAll();
		try {
			while(Rs.next()) {
				id=Rs.getLong("ID_Colis");
				listecolisSortant.add(colisDAO.find(id));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		tableColisSortant.setItems(listecolisSortant);
		
		
		//colis entrant
		col_id20.setCellValueFactory(new PropertyValueFactory<>("code"));
		col_nom20.setCellValueFactory(new PropertyValueFactory<>("nomE"));
		col_prenom20.setCellValueFactory(new PropertyValueFactory<>("prenomE"));
		col_num20.setCellValueFactory(new PropertyValueFactory<>("numE"));
		col_nom21.setCellValueFactory(new PropertyValueFactory<>("nomD"));
		col_prenom21.setCellValueFactory(new PropertyValueFactory<>("prenomD"));
		col_num21.setCellValueFactory(new PropertyValueFactory<>("numD"));
		col_provenace.setCellValueFactory(new PropertyValueFactory<>("destination"));
		col_description.setCellValueFactory(new PropertyValueFactory<>("description"));
		col_dateRetrait21.setCellValueFactory(new PropertyValueFactory<>("dateSortie"));
		col_date_entrer20.setCellValueFactory(new PropertyValueFactory<>("dateRecep"));
		col_valeur20.setCellValueFactory(new PropertyValueFactory<>("valeur"));
		col_frais20.setCellValueFactory(new PropertyValueFactory<>("frais"));
		Rs=colisDAO.findAllV2();
		try {
			while(Rs.next()) {
				id=Rs.getLong("ID_Colis");
				listecolisEntrant.add(colisDAO.find(id));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		tableColisEntrant.setItems(listecolisEntrant);
		
		
		//courier sotant
		col_id31.setCellValueFactory(new PropertyValueFactory<>("code"));
		col_nom31.setCellValueFactory(new PropertyValueFactory<>("nomE"));
		col_prenom31.setCellValueFactory(new PropertyValueFactory<>("prenomE"));
		col_num31.setCellValueFactory(new PropertyValueFactory<>("numE"));
		col_nom32.setCellValueFactory(new PropertyValueFactory<>("nomD"));
		col_prenom32.setCellValueFactory(new PropertyValueFactory<>("prenomD"));
		col_num32.setCellValueFactory(new PropertyValueFactory<>("numD"));
		col_destin31.setCellValueFactory(new PropertyValueFactory<>("destination"));
		col_dateSortie31.setCellValueFactory(new PropertyValueFactory<>("dateSortie"));
		col_dateRecep31.setCellValueFactory(new PropertyValueFactory<>("dateRecep"));
		col_frais30.setCellValueFactory(new PropertyValueFactory<>("frais"));
		Rs=courierDAO.findAll();
		try {
			listecourierSortant.clear();
			while(Rs.next()) {
				id=Rs.getLong("ID_Courier");
				listecourierSortant.add(courierDAO.find(id));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		TablecourierSortant.setItems(listecourierSortant);
		
		
		//courrier entrant
		col_id41.setCellValueFactory(new PropertyValueFactory<>("code"));
		col_nom41.setCellValueFactory(new PropertyValueFactory<>("nomE"));
		col_prenom41.setCellValueFactory(new PropertyValueFactory<>("prenomE"));
		clo_num41.setCellValueFactory(new PropertyValueFactory<>("numE"));
		col_nom42.setCellValueFactory(new PropertyValueFactory<>("nomD"));
		col_prenom42.setCellValueFactory(new PropertyValueFactory<>("prenomD"));
		col_num42.setCellValueFactory(new PropertyValueFactory<>("numD"));
		col_proven41.setCellValueFactory(new PropertyValueFactory<>("destination"));
		col_dateRetrai41.setCellValueFactory(new PropertyValueFactory<>("dateSortie"));
		col_dateEntre41.setCellValueFactory(new PropertyValueFactory<>("dateRecep"));
		Rs=courierDAO.findAllv2();
		try {
			listecourierEntant.clear();
			while(Rs.next()) {
				id=Rs.getLong("ID_Courier");
				listecourierEntant.add(courierDAO.find(id));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		TableCourierEntrant.setItems(listecourierEntant);

		
		
		
	}
	
}
