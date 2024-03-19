package application;
	
import java.time.LocalDate;

import com.jfoenix.controls.JFXButton;

import DataBase.DAOfactory;
import DataBase.UtilisateurDAO;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.converter.LocalDateStringConverter;
import metiers.Ligne;
import metiers.Passager;
import metiers.Utilisateur;
import outils.Outils;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	Stage primaryStage;
	MenuController menu=null;
	public static Object [] parents=new Object[3];
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage=primaryStage;
		this.menu=new MenuController();
		afficherPage("Connexion.fxml", "Connexion");
		DAOfactory DAOF=new DAOfactory();
		Passager P=DAOF.getPassagerDAO().find(1l);
		Ligne l=DAOF.getLigneDAO().find(1l);
		//System.out.println(P.getId());
		/*System.out.println(P.getPrenom());
		System.out.println(P.getTypeBillet());
		System.out.println(P.getHeure());
		System.out.println(P.getDate());
		System.out.println(P.getDestination());
		System.out.println(l.getNom()+"  @@");*/
		//LocalDate date = LocalDate.now();
		DAOF.getPassagerDAO().findPassagerByDate("2024-01-30");
		//Long i=5158960l;
		//String S=String.format("%09d",i);
		Outils outil=new Outils();
		System.out.println("le sha 256 de admin :"+outil.sha256("admin"));

		//Outils.gestionAutoResev();
		//System.out.println(date);
		
	}
	
	//Affichage des pages
	public void afficherPage(String Ficfxml, String titre) {
		try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(Ficfxml));
            Parent root = loader.load();
            //parents[i]=root;
            Scene scene = new Scene(root);
            
            Screen screen = Screen.getPrimary();
            Rectangle2D bounds = screen.getVisualBounds();
            primaryStage.setX(bounds.getMinX());
            primaryStage.setY(bounds.getMinY());
            primaryStage.setWidth(bounds.getWidth());
            primaryStage.setHeight(bounds.getHeight());

            
            primaryStage.setTitle(titre);
            primaryStage.setScene(scene);
            BaseController controller = loader.getController();
            controller.setMainApp(this);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        	}
    }
	
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
