package DataBase;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import metiers.Billet;
import metiers.Depart;
import metiers.Destination;

public class DestinationDAO extends DAO<Destination> {

	@Override
	public Destination create(Destination object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Destination find(Long id) {
	    Destination destination = null;
	    try {
	        Statement statement = this.connection.createStatement();
	        ResultSet Rs = statement.executeQuery("SELECT * FROM villledestinations WHERE ID_Destination=" + id);
	        if (Rs.next())
	            destination = new Destination(id, Rs.getString("Nom_Destination"), Rs.getDouble("Distance"));

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    if (destination != null) {
	        DAOfactory DAOF = new DAOfactory();
	        DepartDAO departDAO = DAOF.getDepartDAO();
	        BilletDAO billetDAO = DAOF.getBilletDAO();
	        ResultSet RsDepart = departDAO.findByIdDeDestination(id);
	        ResultSet RsBillet = billetDAO.findByIdDeDestination(id);
	        ObservableList<Depart> listDepart = FXCollections.observableArrayList(); 
	        ObservableList<Billet> listBillet = FXCollections.observableArrayList(); 
	        
	        //charger les differents depart pour une destination données 
	        try {
	            while (RsDepart.next()) {
	                listDepart.add(departDAO.find(RsDepart.getLong("ID_Depart")));
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        
	      //charger les differents billets pour une destination données 
		    try {
	            while (RsBillet.next()) {
	                listBillet.add(billetDAO.find(RsBillet.getLong("ID_Billet")));
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		    
		   
	        destination.setLesDaparts(listDepart);
	        destination.setLesBillet(listBillet);
	     
	    }
	    
	    return destination;
	}


	@Override
	public Destination update(Destination object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Destination object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ResultSet findAll() {
		ResultSet Rs=null;
		try {
			Statement statement=this.connection.createStatement();
			Rs=statement.executeQuery("SELECT * FROM villledestinations");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Rs;
	}
	
}
