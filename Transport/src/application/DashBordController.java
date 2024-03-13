package application;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import DataBase.ColisDAO;
import DataBase.CourierDAO;
import DataBase.DAOfactory;
import DataBase.PassagerDAO;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import metiers.Passager;


public class DashBordController implements Initializable {
	public static int nbPassager;
	public static int nbreservation;
	public static int nbcolisE;
	public static int nbcolisS;
	public static int nbcourierE;
	public static int nbcourierS;

    @FXML
    private BorderPane borderpane;

    @FXML
    private Label colis;

    @FXML
    private Label courier;

    @FXML
    private Label notif;

    @FXML
    private Label passager;

    @FXML
    private Label reservation1;

    @FXML
    private Label colis1;

    @FXML
    private Label courier1;
    @FXML
    void notification(MouseEvent event) {

    }

    @FXML
    void notification1(MouseEvent event) {

    }
    public void compteur() {
    	ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        Runnable task = () -> {
        	passager.setText(String.valueOf(nbPassager));
        	reservation1.setText(String.valueOf(nbreservation));
        	colis.setText(String.valueOf(nbcolisS));
        	colis1.setText(String.valueOf(nbcolisE));
        	courier.setText(String.valueOf(nbcourierS));
        	courier1.setText(String.valueOf(nbcourierE));
        	
        };
        int intervalInSeconds = 5;
        scheduler.scheduleAtFixedRate(task, 0, intervalInSeconds, TimeUnit.SECONDS);
    }
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		nbPassager=0;
		nbreservation=0;
		nbcolisE=0;
		nbcolisS=0;
		nbcourierE=0;
		nbcourierS=0;
		ResultSet RS=null;
		DAOfactory daof=new DAOfactory();
		PassagerDAO pDAO=daof.getPassagerDAO();
		ColisDAO colDAO=daof.getColisDAO();
		CourierDAO courDAO=daof.getCourierDAO();
		String dt = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		RS=pDAO.findPassagerByDate(dt);
		//int i=0;
		try {
			if(RS!=null) {
				while(RS.next()) {
					//i++;
					nbPassager++;
				}
					
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		passager.setText(String.valueOf(nbPassager));
		
		RS=pDAO.findReservationToDay(dt);
		//int j=0;
		try {
			if(RS!=null) {
				while(RS.next()) {
					//j++;
					nbreservation++;
				}
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		reservation1.setText(String.valueOf(nbreservation));
		
		
		RS=colDAO.findAllByDate(dt);
		try {
			if(RS!=null) {
				while(RS.next()) {
					nbcolisS++;
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		colis.setText(String.valueOf(nbcolisS));
		
		RS=colDAO.findAllByDateV2(dt);
		try {
			if(RS!=null) {
				while(RS.next()) {
					nbcolisE++;
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		colis1.setText(String.valueOf(nbcolisE));
		
		RS=courDAO.findAllByDate(dt);
		try {
			if(RS!=null) {
				while(RS.next()) {
					nbcourierS++;
				}

			}
					} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		courier.setText(String.valueOf(nbcourierS));
		
		
		RS=courDAO.findAllByDatev2(dt);
		try {
			if(RS!=null) {
				while(RS.next()) {
					nbcourierE++;
				}

			}
					} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		courier1.setText(String.valueOf(nbcourierE));
		
		this.compteur();
	}
	
	}


