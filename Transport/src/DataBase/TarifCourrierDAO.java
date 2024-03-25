package DataBase;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import metiers.Recu;

public class TarifCourrierDAO extends DAO<Recu> {

	@Override
	public Recu create(Recu object) {
		try {
			Statement statement=connection.createStatement();
			PreparedStatement prepare=connection.prepareStatement(
					"INSERT INTO `recu`( `prix`, `ID_Destination`) VALUES (?,?)");
			prepare.setDouble(1, object.getMontant());
			prepare.setLong(2, object.getIdDest());
			prepare.executeUpdate();
			 ResultSet result = statement.executeQuery("SELECT id FROM recu ORDER BY id DESC LIMIT 1;");
			 if(result.next()) {
				 long ID = result.getLong("id");
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
			ResultSet Rs=statement.executeQuery("SELECT * FROM recu JOIN villledestinations "
					+ "ON recu.ID_destination=villledestinations.ID_Destination WHERE id="+id);
			if(Rs.next()) {
				recu=new Recu(id,Rs.getDouble("prix"),Rs.getLong("ID_Destination"));
				recu.setDestination(Rs.getString("Nom_Destination"));
			}
				
			
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
			prepare = connection.prepareStatement("UPDATE `recu` SET `prix`=?,`ID_Destination`=? WHERE id="+object.getId());
			 prepare.setDouble(1, object.getMontant());
			 prepare.setLong(2, object.getIdDest());
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
			statement.executeUpdate("DELETE FROM `recu` WHERE id= "+object.getId());
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
			Rs=statement.executeQuery("SELECT * FROM `recu`");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Rs;
	}

}
