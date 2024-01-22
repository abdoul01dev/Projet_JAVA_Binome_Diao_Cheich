package application;
	
import com.jfoenix.controls.JFXButton;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;


public class Main extends Application {
	Stage primaryStage;
	MenuController<JFXButton> menu=null;
	public static Object [] parents=new Object[3];
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage=primaryStage;
		this.menu=new MenuController<JFXButton>();
		afficherPage("Connexion.fxml", "Connexion");
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
