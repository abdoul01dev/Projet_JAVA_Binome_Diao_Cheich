package outils;

import java.security.MessageDigest;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import DataBase.PassagerDAO;
import application.BielletFormController;
import application.BilletController;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import metiers.Passager;
import javafx.scene.control.Alert.AlertType;


public class Outils {
	public boolean Charger(ResultSet bdData,ObservableList liste ){
		if(bdData!=null) {
			try {
				while(bdData.next()) {
					Long id=bdData.getLong("ID_Passager");
					//liste.add(passagerDAO.find(id));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
		
	}
	
	public static boolean confirmer(String message) {
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
	public static void erreur(String message){
		Alert alert =new Alert(AlertType.ERROR);
		alert.setTitle("ERREUR");
		alert.setContentText(message);
		alert.show();
	}
	
	public static void info(String message) {
		Alert alert =new Alert(AlertType.INFORMATION);
		alert.setTitle("Info");
		alert.setContentText(message);
		alert.show();
	}
	
	public String sha256(String motDePasse) {
		StringBuilder hexString = new StringBuilder();
		 try {
	            MessageDigest digest = MessageDigest.getInstance("SHA-256");
	            byte[] hashedBytes = digest.digest(motDePasse.getBytes());
	            for (byte hashedByte : hashedBytes) {
	                String hex = Integer.toHexString(0xff & hashedByte);
	                if (hex.length() == 1) hexString.append('0');
	                hexString.append(hex);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		 return hexString.toString();
	}
	public static String DateEnChaine(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = date.format(formatter);
        return formattedDate;

	}
	
	public static void Imprimer() {
		 
	}
	
	
	public static void gestionAutoResev() {
		ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
		PassagerDAO passagerDAO=new PassagerDAO();
        Runnable task = () -> {
        	for(Passager p:BilletController.ListeReservation) {
        		if(LocalDate.parse(p.getDate()).compareTo(LocalDate.now())==0&& p.getEtat()==2) {
        			int index=BilletController.ListeReservation.indexOf(p);
        			p.setEtat(1);
        			p.setMontant(p.getMontant());
        			p=passagerDAO.updateEtat(p);
        			BilletController.ListeReservation.set(index, p);
        			System.out.print("~");
        		}
        		
        	}
        };
        int intervalInSeconds = 3;
        scheduler.scheduleAtFixedRate(task, 0, intervalInSeconds, TimeUnit.MINUTES);

	}
}
