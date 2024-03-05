package DataBase;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import metiers.Billet;


public class BilletDAO extends DAO<Billet> {

	@Override
	public Billet create(Billet object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Billet find(Long id) {
		Billet billet=null;
		try {
			Statement statement=this.connection.createStatement();
			ResultSet Rs=statement.executeQuery("SELECT * FROM billet JOIN villledestinations "
					+ "ON billet.ID_Destination=villledestinations.ID_Destination"
					+ " WHERE ID_Billet="+id);
			if(Rs.next())
				billet=new Billet(id, Rs.getString("titre"),Rs.getString("Prix"), Rs.getLong("ID_Destination"));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return billet;
	}

	@Override
	public Billet update(Billet object) {
		PreparedStatement prepare;
		try {
			prepare = connection.prepareStatement("UPDATE `billet` SET `titre`=?,"
					+ "`Prix`=?,`ID_Destination`=? WHERE ="+object.getId());
			 prepare.setString(1, object.getTitre());
			 prepare.setString(2, object.getPrix());
			 prepare.setLong(3, object.getIdDestination());
			 prepare.executeUpdate();
			 object=find(object.getId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return object;

	}

	@Override
	public void delete(Billet object) {
		try {
			Statement statement=this.connection.createStatement();
			statement.executeUpdate("DELETE FROM `billet` WHERE ID_billet="+object.getId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public ResultSet findAll() {
		ResultSet Rs = null;
		try {
			Statement statement=this.connection.createStatement();
			Rs=statement.executeQuery("SELECT * FROM billet");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return  Rs;
	}
	

	
	public ResultSet findByIdDeDestination(Long idDes) {
		ResultSet Rs=null;
		try {
			Statement statement=this.connection.createStatement();
			Rs=statement.executeQuery("SELECT * FROM billet WHERE ID_Destination="+idDes);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Rs;
		
	}
}
