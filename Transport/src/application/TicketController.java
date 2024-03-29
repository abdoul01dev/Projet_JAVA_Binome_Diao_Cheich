package application;

import javafx.event.ActionEvent;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;

import com.jfoenix.controls.JFXButton;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import metiers.Passager;
import outils.Outils;

public class TicketController implements Initializable{
	public static Passager passager;

	@FXML
    private JFXButton Imprimer;
		
    @FXML
    private Label Nom;

    @FXML
    private Label Prenom;

    @FXML
    private Label date;

    @FXML
    private Label depart;

    @FXML
    private Label destination;

    @FXML
    private Label montant1;

    @FXML
    private Label references;

    @FXML
    private AnchorPane root;

    @FXML
    private GridPane tickets;

    @FXML
    private Label type;
    
    
   


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
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		if(passager!=null) {
			Nom.setText(passager.getNom());
			Prenom.setText(passager.getPrenom());
			date.setText(passager.getDate());
			type.setText(passager.getTypeBillet());
			montant1.setText(String.valueOf(passager.getMontant())+" FCFA");
			destination.setText(passager.getDestination());
			depart.setText(passager.getHeure());
			LocalDateTime ld=LocalDateTime.now();
			references.setText(String.valueOf(ld));
		}else {
			Outils.erreur("Une erreur est survenu lors de chargement des informations");
		}
		
		
		
	}
}

