package application;


import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import DataBase.DAOfactory;
import DataBase.PassagerDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import metiers.Passager;
import outils.Outils;


public class ListePassagerController implements Initializable{
	public static Long idLigne;
	public static Long idDepart;
	public static String date;

	public static ObservableList<Passager>ListePassager=FXCollections.observableArrayList();

	@FXML
    private JFXButton Imprimer;

    @FXML
    private TableColumn<?, ?> col_dest;

    @FXML
    private TableColumn<?, ?> col_id;

    @FXML
    private TableColumn<?, ?> col_nom;

    @FXML
    private TableColumn<?, ?> col_prenom;

    @FXML
    private TableColumn<?, ?> col_tel;

    @FXML
    private TableColumn<?, ?> col_type;

    @FXML
    private Label references;

    @FXML
    private AnchorPane root;

    @FXML
    private TableView<Passager> tablePassager;

    @FXML
    private GridPane tickets;

    @FXML
    void ImpressionTicket(ActionEvent event) {
    	imprimerInformations();
    }
    private void imprimerInformations() {
        
        PrinterJob job = PrinterJob.createPrinterJob();
        if (job != null) {
            boolean proceed = job.showPrintDialog(tickets.getScene().getWindow());
            if (proceed) {
                boolean success = job.printPage(ticketsWithoutButton());
                if (success) {
                    job.endJob();
                }
            }
        }
    }
    private GridPane ticketsWithoutButton() {
        if (tickets == null) {
            return new GridPane();  
        }
        GridPane printedGridPane = new GridPane();
        printedGridPane.getColumnConstraints().addAll(tickets.getColumnConstraints());
        printedGridPane.getRowConstraints().addAll(tickets.getRowConstraints());
       List<Node> childrenCopy = new ArrayList<>(tickets.getChildren());
        for (Node node : childrenCopy) {
            if (!(node instanceof Button)) {
                int columnIndex = GridPane.getColumnIndex(node) != null ? GridPane.getColumnIndex(node) : 0;
                int rowIndex = GridPane.getRowIndex(node) != null ? GridPane.getRowIndex(node) : 0;
                printedGridPane.add(node, columnIndex, rowIndex);
            }
        }

        return printedGridPane;
    }

    @FXML
    void OK(ActionEvent event) {

    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		col_id.setCellValueFactory(new PropertyValueFactory<>("code"));
		col_nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
		col_prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
		col_tel.setCellValueFactory(new PropertyValueFactory<>("NumTel"));
		col_dest.setCellValueFactory(new PropertyValueFactory<>("destination"));
		col_type.setCellValueFactory(new PropertyValueFactory<>("typeBillet"));
		DAOfactory DAOF=new DAOfactory();
		PassagerDAO passagerDAO=DAOF.getPassagerDAO();
		ResultSet Rs=passagerDAO.findPassagerByDateAndLigne(date,idLigne,idDepart);
		if(Rs!=null) {
			ListePassager.clear();
			try {
				while(Rs.next()) {
					Long id=Rs.getLong("ID_Passager");
					ListePassager.add(passagerDAO.find(id));
					BoiteImpressionController.estvide=false;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			Outils.info("Aucun passager trouvé");
		}
		//ListePassager.add(P);
		tablePassager.setItems(ListePassager);
		LocalDateTime ld=LocalDateTime.now();
		references.setText(String.valueOf(ld));
		
	}

}
