package DataBase;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import metiers.Passager;
import metiers.Utilisateur;

public class PassagerDAO extends DAO<Passager>{
	Passager PassagerCourent=null;

	@Override
	public Passager create(Passager object) {
		try {
			Statement statement= this.connection.createStatement();
			
			
			 PreparedStatement prepare=connection.prepareStatement("INSERT INTO `passagers` (`ID_Passager`, `Nom_Pasager`, "
			 		+ "`prenom_Passager`, `Tel_Pasager`, `Age_Passager`, `Sexe_Passager`, `Date_voy`, `ID_billet`, `ID_Destination`, `ID_Depart`)"
			 		+ " VALUES (?,?,?,?,?,?,?,?,?);");
			 prepare.setString(1, object.getNom());
			 prepare.setString(2, object.getPrenom());
			 prepare.setString(3, object.getNumTel());
			 prepare.setInt(4, object.getAge());
			 prepare.setString(5, object.getSexe());
			 prepare.setString(6, object.getDate());
			 prepare.setString(7, object.getTypeBillet());
			 prepare.setLong(8, object.getIdDestination());
			 prepare.setLong(9, object.getDepart());
			 prepare.executeUpdate();
			 ResultSet result = statement.executeQuery("SELECT ID_Passager FROM passagers ORDER BY ID_Ut DESC LIMIT 1;");
			 if(result.next()) {
				 long ID = result.getLong("ID_Passager");
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
	public Passager find(Long id) {
		Passager passager=null;
		try {
			Statement statement=this.connection.createStatement();
			ResultSet result=statement.executeQuery("SELECT * FROM passagers LEFT JOIN billet ON passagers.ID_billet=billet.ID_Billet "
					+ "LEFT JOIN departs ON passagers.ID_Depart=departs.ID_Depart"
					+ " INNER JOIN villledestinations ON departs.ID_Destination=villledestinations.ID_Destination "
					+ "WHERE ID_Passager="+id+";");
			if(result.next()) {
				passager=new Passager(id, result.getString("Nom_Passager"), 
						result.getString("prenom_Passager"),result.getString("Sexe_Passager"),
						result.getInt("Age_Passager"), result.getString("Tel_Passager"),result.getLong("ID_billet"), 
						result.getLong("ID_destination"), result.getDouble("Prix"), result.getLong("ID_depart"),
						result.getString("Date_voy"));
				passager.setTypeBillet(result.getString("titre"));
				passager.setDestination(result.getString("Nom_Destination"));
				passager.setHeure(result.getString("Heure"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return passager;
	}

	@Override
	public Passager update(Passager object) {
		 PreparedStatement prepare;
		try {
			prepare = connection.prepareStatement("UPDATE `passagers` SET `ID_Passager`=?, `Nom_Pasager`=?, "
			 		+ "`prenom_Passager`=?, `Tel_Pasager`=?, `Age_Passager`=?, `Sexe_Passager`=?, `Date_voy`=?, "
			 		+ "`ID_billet`=?, `ID_Destination`=?, `ID_Depart`=?");
			 prepare.setString(1, object.getNom());
			 prepare.setString(2, object.getPrenom());
			 prepare.setString(3, object.getNumTel());
			 prepare.setInt(4, object.getAge());
			 prepare.setString(5, object.getSexe());
			 prepare.setString(6, object.getDate());
			 prepare.setString(7, object.getTypeBillet());
			 prepare.setLong(8, object.getIdDestination());
			 prepare.setLong(9, object.getDepart());
			 prepare.executeUpdate();
			 object=find(object.getId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return object;
	}

	@Override
	public void delete(Passager object) {
		try {
			Statement statement=this.connection.createStatement();
			statement.executeUpdate("DELETE FROM passagers WHERE ID_Passager="+object.getId());
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
			Rs=statement.executeQuery("SELECT * FROM passagers LEFT JOIN billet ON passagers.ID_billet=billet.ID_Billet "
					+ "LEFT JOIN departs ON passagers.ID_Depart=departs.ID_Depart"
					+ " INNER JOIN villledestinations ON departs.ID_Destination=villledestinations.ID_Destination ");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Rs;
	}
	
	
}
