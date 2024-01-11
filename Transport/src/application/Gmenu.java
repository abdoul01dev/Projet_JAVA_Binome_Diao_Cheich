package application;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class Gmenu extends MenuController {
	public void SetPage(String Page) {
		FXMLLoader loader = new FXMLLoader(getClass().getResource(Page));
      /*  try {
			Parent root = loader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		//this.setDefaultPane((Pane) root);
	}
}
