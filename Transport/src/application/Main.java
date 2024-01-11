package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	Stage primaryStage;
	public static Object [] parents=new Object[3];
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage=primaryStage;
		afficherPage("Connexion.fxml", "Connexion",0);
	}
	
	//Affichage des pages
	public void afficherPage(String Ficfxml, String titre,int i) {
		if(parents[i]==null) {
			try {
	            FXMLLoader loader = new FXMLLoader(getClass().getResource(Ficfxml));
	            Parent root = loader.load();
	            parents[i]=root;
	            Scene scene = new Scene((Parent) parents[i]);
	            
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
		}else {
			
		}
        
    }
	
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
