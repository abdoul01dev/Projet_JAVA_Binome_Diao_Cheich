package DataBase;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import metiers.Colis;
import metiers.Peseonne;

public class ColisDAO extends DAO<Colis> {

	@Override
	public Colis create(Colis object) {
		try {
			Statement statement= this.connection.createStatement();
			
			
			 PreparedStatement prepare=connection.prepareStatement("INSERT INTO `colis` ( `Code_Cl`, `Nom_Exp`, `prenom_Exp`, `Tel_Exp`,"
			 		+ " `Ref_Exp`, `Nom_Dest`, `prenom_Dest`, `Tel_Dest`, `Ref_Dest`, `Date_Recep_Cl`, `Date_envoie`, `codeES`, `ID_Destination`, "
			 		+ "`ID_Depart`, `Cout`, `Description`, `valeur`) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
			 prepare.setString(1, object.getCode());
			 prepare.setString(2, object.getExpediteur().getNom());
			 prepare.setString(3, object.getExpediteur().getPrenom());
			 prepare.setString(4, object.getExpediteur().getNumTel());
			 prepare.setString(5, object.getExpediteur().getRef());
			 prepare.setString(6, object.getDestinataire().getNom());
			 prepare.setString(7, object.getDestinataire().getPrenom());
			 prepare.setString(8, object.getDestinataire().getNumTel());
			 prepare.setString(9, object.getDestinataire().getRef());
			 prepare.setString(10, object.getDateRecep());
			 prepare.setString(11, object.getDateSortie());
			 prepare.setInt(12, object.getType());
			 prepare.setLong(13, object.getIdDestination());
			 prepare.setLong(14, object.getIdDepart());
			 prepare.setDouble(15, object.getFrais());
			 prepare.setString(16, object.getDescription());
			 prepare.setDouble(17, object.getValeur());
			 prepare.executeUpdate();
			 ResultSet result = statement.executeQuery("SELECT ID_Colis FROM colis ORDER BY ID_Colis DESC LIMIT 1;");
			 if(result.next()) {
				 long ID = result.getLong("ID_Colis");
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
	public Colis find(Long id) {
		Colis colis=null;
		try {
			Statement statement=this.connection.createStatement();
			//ResultSet result=statement.executeQuery("SELECT * FROM colis WHERE ID_Colis="+id);
			ResultSet result=statement.executeQuery("SELECT * FROM colis "
					+ "LEFT JOIN villledestinations ON colis.ID_Destination=villledestinations.ID_Destination "
					+ "WHERE ID_Colis="+id);
			if(result.next()) {
				Peseonne expediteur=new Peseonne(1l, result.getString("Nom_Exp"),  result.getString("prenom_Exp"), "", null, result.getString("Tel_Exp"));
				expediteur.setRef("Ref_Exp");
				Peseonne destinateur=new Peseonne(1l, result.getString("Nom_Dest"),  result.getString("prenom_Dest"), "", null, result.getString("Tel_Dest"));
				destinateur.setRef("Ref_Dest");
				colis=new Colis(id, result.getString("Code_Cl"),result.getInt("codeES"), result.getString("Date_Recep_Cl"), result.getString("Date_envoie"),
						result.getString("Description"), result.getDouble("valeur"), expediteur, destinateur);
				colis.setDestination(result.getString("Nom_Destination"));
				colis.setFrais(result.getDouble("Cout"));
				colis.setIdDestination(result.getLong("ID_Destination"));
				//colis.setId(result.getLong("ID_Colis"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return colis;
	}

	@Override
	public Colis update(Colis object) {
		PreparedStatement prepare;
		try {
			prepare=connection.prepareStatement("UPDATE `colis` SET `Code_Cl`=?, `Nom_Exp`=?, "
			 		+ "`prenom_Exp`=?,`Tel_Exp`=?, `Ref_Exp`=?, `Nom_Dest`=?, `prenom_Dest`=?, `Tel_Dest`=?, `Ref_Dest`=?, "+
					 "`Date_Recep_Cl`=?, `Date_envoie`=?, `codeES`=?, `ID_Destination`=?, `ID_Depart`=?, `Cout`=? ,`Description`=?,`valeur`=? "
					 + "WHERE ID_Colis= "+object.getId());
			 prepare.setString(1, object.getCode());
			 prepare.setString(2, object.getExpediteur().getNom());
			 prepare.setString(3, object.getExpediteur().getPrenom());
			 prepare.setString(4, object.getExpediteur().getNumTel());
			 prepare.setString(5, object.getExpediteur().getRef());
			 prepare.setString(6, object.getDestinataire().getNom());
			 prepare.setString(7, object.getDestinataire().getPrenom());
			 prepare.setString(8, object.getDestinataire().getNumTel());
			 prepare.setString(9, object.getDestinataire().getRef());
			 prepare.setString(10, object.getDateRecep());
			 prepare.setString(11, object.getDateSortie());
			 prepare.setInt(12, object.getType());
			 prepare.setLong(13, object.getIdDestination());
			 prepare.setLong(14, object.getIdDepart());
			 prepare.setDouble(15, object.getFrais());
			 prepare.setString(16, object.getDescription());
			 prepare.setDouble(17, object.getValeur());
			 //prepare.setLong(16, object.getId());
			 prepare.executeUpdate();
			 object=this.find(object.getId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return object;
	}

	@Override
	public void delete(Colis object) {
		try {
			Statement statement=this.connection.createStatement();
			statement.executeUpdate("DELETE FROM colis WHERE ID_Colis="+object.getId());
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
			Rs=statement.executeQuery("SELECT * FROM colis WHERE codeES=1");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Rs;
	}
	
	public ResultSet findAllV2() {
		ResultSet Rs=null;
		try {
			Statement statement=this.connection.createStatement();
			Rs=statement.executeQuery("SELECT * FROM colis WHERE codeES=2");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Rs;
	}
	
	public Long idMax() {
		Statement statement;
		ResultSet result =null;
		Long ID=0l;
		try {
			statement = this.connection.createStatement();
			result = statement.executeQuery("SELECT ID_Colis FROM colis ORDER BY ID_Colis DESC LIMIT 1;");
			if(result.next())
				ID=result.getLong("ID_Colis");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return ID+1;
	}
	
	
}
