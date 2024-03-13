package DataBase;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import metiers.Courrier;
import metiers.Peseonne;

public class CourierDAO extends DAO<Courrier> {

	@Override
	public Courrier create(Courrier object) {
		try {
			Statement statement= this.connection.createStatement();
			
			
			 PreparedStatement prepare=connection.prepareStatement("INSERT INTO `couriers`(`Nom_Exp`, `prenom_Exp`, `Tel_Exp`, `Ref_Exp`, "
						+ "`Code`, `Nom_Dest`, `prenom_Dest`, `Tel_Dest`, `Ref_Dest`, `Date_recep`, `codeES`, "
						+ "`ID_Destination`,ID_Depart, `Date_envoie`)  VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?);");
			 
			 prepare.setString(1, object.getExpediteur().getNom());
			 prepare.setString(2, object.getExpediteur().getPrenom());
			 prepare.setString(3, object.getExpediteur().getNumTel());
			 prepare.setString(4, object.getExpediteur().getRef());
			 prepare.setString(5, object.getCode());
			 prepare.setString(6, object.getDestinataire().getNom());
			 prepare.setString(7, object.getDestinataire().getPrenom());
			 prepare.setString(8, object.getDestinataire().getNumTel());
			 prepare.setString(9, object.getDestinataire().getRef());
			 prepare.setString(10, object.getDateRecep());
			 prepare.setInt(11, object.getType());
			 prepare.setLong(12, object.getIdDestination());
			 prepare.setLong(13, object.getIdDepart());
			 prepare.setString(14, object.getDateSortie());
			 prepare.executeUpdate();
			 ResultSet result = statement.executeQuery("SELECT ID_Courier FROM couriers ORDER BY ID_Courier DESC LIMIT 1;");
			 if(result.next()) {
				 long ID = result.getLong("ID_Courier");
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
	public Courrier find(Long id) {
		Courrier courrier=null;
		try {
			Statement statement=this.connection.createStatement();
			ResultSet result=statement.executeQuery("SELECT * FROM couriers "
					+ "LEFT JOIN villledestinations ON couriers.ID_Destination=villledestinations.ID_Destination LEFT "
					+ "JOIN recu ON recu.ID_Destination=villledestinations.ID_Destination "
					+ "WHERE ID_Courier="+id);
			if(result.next()) {
				Peseonne expediteur=new Peseonne(1l, result.getString("Nom_Exp"),  result.getString("prenom_Exp"), "", null, result.getString("Tel_Exp"));
				expediteur.setRef("Ref_Exp");
				Peseonne destinateur=new Peseonne(1l, result.getString("Nom_Dest"),  result.getString("prenom_Dest"), "", null, result.getString("Tel_Dest"));
				destinateur.setRef("Ref_Dest");
				courrier=new Courrier(id, result.getString("Code"),result.getInt("codeES"), result.getString("Date_Recep"), result.getString("Date_envoie"),
						null, 0.0, expediteur, destinateur);
				courrier.setDestination(result.getString("Nom_Destination"));
				courrier.setFrais(result.getDouble("prix"));
				courrier.setIdDestination(result.getLong("ID_Destination"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return courrier;
	}

	@Override
	public Courrier update(Courrier object) {
		PreparedStatement prepare;
		try {
			prepare=connection.prepareStatement("UPDATE `couriers` SET `Nom_Exp`=?,`prenom_Exp`=?,`Tel_Exp`=?,"
					+ "`Ref_Exp`=?,`Code`=?,`Nom_Dest`=?,`prenom_Dest`=?,`Tel_Dest`=?,`Ref_Dest`=?,`Date_recep`=?, "
					+ "`ID_Destination`=?,`ID_Depart`=?,`Date_envoie`=? WHERE ID_Courier="+object.getId());
			 
			 prepare.setString(1, object.getExpediteur().getNom());
			 prepare.setString(2, object.getExpediteur().getPrenom());
			 prepare.setString(3, object.getExpediteur().getNumTel());
			 prepare.setString(4, object.getExpediteur().getRef());
			 prepare.setString(5, object.getCode());
			 prepare.setString(6, object.getDestinataire().getNom());
			 prepare.setString(7, object.getDestinataire().getPrenom());
			 prepare.setString(8, object.getDestinataire().getNumTel());
			 prepare.setString(9, object.getDestinataire().getRef());
			 prepare.setString(10, object.getDateRecep());
			 prepare.setLong(11, object.getIdDestination());
			// prepare.setInt(12, object.getType());
			 prepare.setLong(12, object.getIdDepart());
			 prepare.setString(13, object.getDateSortie());
			 prepare.executeUpdate();
			 object=this.find(object.getId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return object;
	}

	@Override
	public void delete(Courrier object) {
		try {
			Statement statement=this.connection.createStatement();
			statement.executeUpdate("DELETE FROM couriers WHERE ID_Courier="+object.getId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public ResultSet findAll() {
		Statement statement;
		ResultSet result=null;
		try {
			statement = this.connection.createStatement();
			result=statement.executeQuery("SELECT * FROM couriers WHERE codeES=1 ; ");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	public ResultSet findAllv2() {
		Statement statement;
		ResultSet result=null;
		try {
			statement = this.connection.createStatement();
			result=statement.executeQuery("SELECT * FROM couriers WHERE codeES=2 ; ");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	public ResultSet findAllByDatev2(String date) {
		Statement statement;
		ResultSet result=null;
		try {
			statement = this.connection.createStatement();
			result=statement.executeQuery("SELECT * FROM couriers WHERE codeES=2 AND Date_recep='"+date+"';" );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	public ResultSet findAllByDate(String date) {
		//Statement statement;
		ResultSet result=null;
		try {
			//statement = this.connection.createStatement();
			//result=statement.executeQuery("SELECT * FROM couriers WHERE codeES=1 AND Date_recep='"+date+"';" );
			String query = "SELECT * FROM couriers WHERE codeES=? AND Date_recep=?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, 2); 
			preparedStatement.setString(2, date); 
			result = preparedStatement.executeQuery();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	public Long idMax() {
		Statement statement;
		ResultSet result =null;
		Long ID=0l;
		try {
			statement = this.connection.createStatement();
			result = statement.executeQuery("SELECT ID_Courier FROM couriers ORDER BY ID_Courier DESC LIMIT 1;");
			if(result.next())
				ID=result.getLong("ID_Courier");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return ID+1;
	}
	

}
