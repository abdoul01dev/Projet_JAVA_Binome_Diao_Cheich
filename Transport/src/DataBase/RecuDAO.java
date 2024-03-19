package DataBase;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import metiers.Recu;

public class RecuDAO extends DAO<Recu> {

	@Override
	public Recu create(Recu object) {
		try {
			Statement statement=connection.createStatement();
			PreparedStatement prepare=connection.prepareStatement(
					"INSERT INTO `billet`(`titre`, `Prix`, `ID_Destination`) "
					+ "VALUES (?,?,?)");
			prepare.setString(1, object.getNom());
			prepare.setDouble(2,object.getMontant());
			prepare.setLong(3, object.getIdDest());
			prepare.executeUpdate();
			 ResultSet result = statement.executeQuery("SELECT ID_Billet FROM billet ORDER BY ID_Billet DESC LIMIT 1;");
			 if(result.next()) {
				 long ID = result.getLong("ID_Billet");
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
	public Recu find(Long id) {
		Recu recu=null;
		try {
			Statement statement=this.connection.createStatement();
			ResultSet Rs=statement.executeQuery("SELECT * FROM billet JOIN villledestinations ON billet.ID_Destination=villledestinations.ID_Destination"
					+ " WHERE ID_Billet="+id);
			if(Rs.next())
				recu=new Recu(id, Rs.getString("titre"), Rs.getDouble("prix"), Rs.getLong("ID_Destination"));
				recu.setDestination(Rs.getString("Nom_Destination"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return recu;
	}

	@Override
	public Recu update(Recu object) {
		PreparedStatement prepare;
		try {
			prepare = connection.prepareStatement("UPDATE `billet` SET `titre`=?,`Prix`=?,`ID_Destination`=? WHERE ID_Billet="+object.getId());
			 prepare.setString(1, object.getNom());
			 prepare.setDouble(2, object.getMontant());
			 prepare.setLong(3, object.getIdDest());
			 prepare.executeUpdate();
			 object=find(object.getId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return object;
	}

	@Override
	public void delete(Recu object) {
		Statement statement;
		try {
			statement = this.connection.createStatement();
			statement.executeUpdate("DELETE FROM `billet` WHERE = ID_Billet"+object.getId());
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
			Rs=statement.executeQuery("SELECT * FROM `billet`");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Rs;
	}

}
