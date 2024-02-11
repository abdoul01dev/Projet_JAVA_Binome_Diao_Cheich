package outils;

import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.ObservableList;


public class Outils<E> {
	public boolean Charger(ResultSet bdData,ObservableList<E> liste ){
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

}
