package DataBase;
import java.sql.PreparedStatement;
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
		try {
			Statement statement=connection.createStatement();
			PreparedStatement prepare=connection.prepareStatement(
					"INSERT INTO `villledestinations`( `Nom_Destination`, `Distance`, `ID_ligne`) "
					+ "VALUES (?,?,?)");
			prepare.setString(1, object.getNomDestination());
			prepare.setDouble(2, object.getDistance());
			prepare.setLong(3, object.getIdLigne());
			prepare.executeUpdate();
			 ResultSet result = statement.executeQuery("SELECT ID_Destination FROM villledestinations ORDER BY ID_Destination DESC LIMIT 1;");
			 if(result.next()) {
				 long ID = result.getLong("ID_Destination");
				 object.setId(ID);
				 object=this.find(ID);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return object;
	}

	@Override
	public Destination find(Long id) {
	    Destination destination = null;
	    try {
	        Statement statement = this.connection.createStatement();
	        //ResultSet Rs = statement.executeQuery("SELECT * FROM villledestinations WHERE ID_Destination=" + id);
	        ResultSet Rs = statement.executeQuery("SELECT * FROM villledestinations JOIN ligne ON villledestinations.ID_ligne= ligne.ID_ligne"
	        		+ " WHERE ID_Destination=" + id);
	        if (Rs.next()) {
	            destination = new Destination(id, Rs.getString("Nom_Destination"), Rs.getDouble("Distance"));
	            destination.setLigne(Rs.getString("nomLingne"));
	            destination.setIdLigne(Rs.getLong("ID_ligne"));
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    if (destination != null) {
	        DAOfactory DAOF = new DAOfactory();
	        DepartDAO departDAO = DAOF.getDepartDAO();
	        BilletDAO billetDAO = DAOF.getBilletDAO();
	        ResultSet RsDepart = departDAO.findByIdLigne(destination.getIdLigne());
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
		PreparedStatement prepare;
		try {
			prepare = connection.prepareStatement("UPDATE `villledestinations` SET `Nom_Destination`=?,"
					+ "`Distance`=?,`ID_ligne`=? WHERE ID_Destination="+object.getId());
			 prepare.setString(1, object.getNomDestination());
			 prepare.setDouble(2, object.getDistance());
			 prepare.setLong(3, object.getIdLigne());
			 prepare.executeUpdate();
			 object=find(object.getId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return object;

	}

	@Override
	public void delete(Destination object) {
		Statement statement;
		try {
			statement = this.connection.createStatement();
			statement.executeUpdate("DELETE FROM  villledestinations WHERE ID_Destination= "+object.getId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
