package DataBase;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import metiers.Depart;

public class DepartDAO extends DAO<Depart>{

	@Override
	public Depart create(Depart object) {
		try {
			Statement statement=connection.createStatement();
			PreparedStatement prepare=connection.prepareStatement(
					"INSERT INTO `departs`(`Jour`, `Heure`, `NbrsPlcs`, `ID_Destination`, `ID_ligne`) "
					+ "VALUES (?,?,?,?,?)");
			prepare.setString(1, object.getJour());
			prepare.setString(2, object.getHeure());
			prepare.setInt(3, object.getNbrPlaces());
			prepare.setLong(4, object.getIdDestination());
			prepare.setLong(5, object.getIdLigne());
			prepare.executeUpdate();
			 ResultSet result = statement.executeQuery("SELECT ID_Depart FROM departs ORDER BY ID_Depart DESC LIMIT 1;");
			 if(result.next()) {
				 long ID = result.getLong("ID_Depart");
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
	public Depart find(Long id) {
		Depart depart=null;
		try {
			Statement statement=this.connection.createStatement();
			//ResultSet Rs=statement.executeQuery("SELECT * FROM departs WHERE ID_Depart="+id);
			ResultSet Rs=statement.executeQuery("SELECT * FROM departs JOIN ligne ON departs.ID_ligne=ligne.ID_ligne"
					+ " WHERE ID_Depart="+id);
			if(Rs.next()) {
				depart=new Depart(id,Rs.getString("Jour"), Rs.getString("Heure"), Rs.getInt("NbrsPlcs"), Rs.getLong("ID_Destination"));
				depart.setIdLigne(Rs.getLong("ID_ligne"));
				depart.setLigne(Rs.getString("nomLingne"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return depart;
	}

	@Override
	public Depart update(Depart object) {
		 PreparedStatement prepare;
			try {
				prepare = connection.prepareStatement("UPDATE `departs` SET `Jour`=?,`Heure`=?,`NbrsPlcs`=?,"
						+ "`ID_Destination`=?,`ID_ligne`=? WHERE ID_Depart="+object.getId());
				 prepare.setString(1, object.getJour());
				 prepare.setString(2, object.getHeure());
				 prepare.setInt(3, object.getNbrPlaces());
				 prepare.setLong(4, object.getIdDestination());
				 prepare.setLong(5, object.getIdLigne());
				 
				 prepare.executeUpdate();
				 object=find(object.getId());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return object;
	}

	@Override
	public void delete(Depart object) {
		Statement statement;
		try {
			statement = this.connection.createStatement();
			statement.executeUpdate("DELETE FROM `departs` WHERE ID_Depart= "+object.getId());
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
			Rs=statement.executeQuery("SELECT * FROM departs");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Rs;
	}
	
	public ResultSet findByIdDeDestination(Long idDes) {
		ResultSet Rs=null;
		try {
			Statement statement=this.connection.createStatement();
			Rs=statement.executeQuery("SELECT * FROM departs WHERE ID_Destination="+idDes);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Rs;
		
	}
	
	public ResultSet findByIdLigne(Long idLigne) {
		ResultSet Rs=null;
		try {
			Statement statement=this.connection.createStatement();
			Rs=statement.executeQuery("SELECT * FROM departs WHERE ID_ligne="+idLigne);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Rs;
		
	}
}
