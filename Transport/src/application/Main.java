package application;
	


import DataBase.DAOfactory;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;
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
		//Passager P=DAOF.getPassagerDAO().find(1l);
		//Ligne l=DAOF.getLigneDAO().find(1l);
		
		DAOF.getPassagerDAO().findPassagerByDate("2024-01-30");
		
		Outils outil=new Outils();
		System.out.println("le sha 256 de admin :"+outil.sha256("admin"));
		//DataBaseConnect.sqlite();
		
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
