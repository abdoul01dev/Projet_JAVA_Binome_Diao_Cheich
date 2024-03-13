package DataBase;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Date;

import metiers.Passager;
import metiers.Utilisateur;
import outils.Outils;

public class PassagerDAO extends DAO<Passager>{
	Passager PassagerCourent=null;

	@Override
	public Passager create(Passager object) {
		try {
			Statement statement= this.connection.createStatement();		
			 PreparedStatement prepare=connection.prepareStatement("INSERT INTO `passagers` (`Code_Passager`, `Nom_Passager`, "
			 		+ "`prenom_Passager`, `Tel_Passager`, `Age_Passager`, `Sexe_Passager`, `Date_voy`, `ID_billet`,`Type_Passager`, `ID_Destination`, `ID_Depart`, etat , Date_enreg)"
			 		+ " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?);");
			 prepare.setString(1, object.getCode());
			 prepare.setString(2, object.getNom());
			 prepare.setString(3, object.getPrenom());
			 prepare.setString(4, object.getNumTel());
			 prepare.setInt(5, object.getAge());
			 prepare.setString(6, object.getSexe());
			 prepare.setString(7, object.getDate());
			 prepare.setLong(8, object.getIdBillet());
			 prepare.setInt(9, object.getTypePassager());
			 prepare.setLong(10, object.getIdDestination());
			 prepare.setLong(11, object.getDepart());
			 prepare.setInt(12, object.getEtat());
			 prepare.setString(13, Outils.DateEnChaine(LocalDate.now()));
			 prepare.executeUpdate();
			 ResultSet result = statement.executeQuery("SELECT ID_Passager FROM passagers ORDER BY ID_Passager DESC LIMIT 1;");
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
				passager.setCode(result.getString("Code_Passager"));
				passager.setTypePassager(result.getInt("Type_Passager"));
				passager.setEtat(result.getInt("etat"));
				if(passager.getEtat()==1) {
					passager.setEtatR("Résolu");
				}else if(passager.getEtat()==2) {
					passager.setEtatR("En cours");
				}else {
					passager.setEtatR("Annulé");
					passager.setMontant(result.getDouble("cout"));
				}
				
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
			prepare = connection.prepareStatement("UPDATE `passagers` SET `Code_Passager`=?, `Nom_Passager`=?, "
			 		+ "`prenom_Passager`=?, `Tel_Passager`=?, `Age_Passager`=?, `Sexe_Passager`=?, `Date_voy`=?, "
			 		+ "`ID_billet`=?,`ID_Destination`=?, `ID_Depart`=? WHERE ID_Passager=?");
			 prepare.setString(1, object.getCode());
			 prepare.setString(2, object.getNom());
			 prepare.setString(3, object.getPrenom());
			 prepare.setString(4, object.getNumTel());
			 prepare.setInt(5, object.getAge());
			 prepare.setString(6, object.getSexe());
			 prepare.setString(7, object.getDate());
			 prepare.setLong(8, object.getIdBillet());
			 prepare.setLong(9, object.getIdDestination());
			 prepare.setLong(10, object.getDepart());
			 prepare.setLong(11, object.getId());
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
					+ " INNER JOIN villledestinations ON departs.ID_Destination=villledestinations.ID_Destination"
					+ " WHERE passagers.Type_Passager=1 ;");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Rs;
	}
	
	public ResultSet findPassagerByDate(String date) {
		ResultSet Rs=null;
		try {
			Statement statement=this.connection.createStatement();
			Rs=statement.executeQuery("SELECT * FROM passagers LEFT JOIN billet ON passagers.ID_billet=billet.ID_Billet "
					+ "LEFT JOIN departs ON passagers.ID_Depart=departs.ID_Depart"
					+ " INNER JOIN villledestinations ON departs.ID_Destination=villledestinations.ID_Destination"
					+ " WHERE passagers.Type_Passager=1 AND passagers.Date_voy="+"'"+date+"'"+";");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Rs;
		
	}
	
	public ResultSet findAllReservation() {
		ResultSet Rs=null;
		try {
			Statement statement=this.connection.createStatement();
			Rs=statement.executeQuery("SELECT * FROM passagers LEFT JOIN billet ON passagers.ID_billet=billet.ID_Billet "
					+ "LEFT JOIN departs ON passagers.ID_Depart=departs.ID_Depart"
					+ " INNER JOIN villledestinations ON departs.ID_Destination=villledestinations.ID_Destination"
					+ " WHERE passagers.Type_Passager=2 ;");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Rs;
	}
	
	public ResultSet findReservationByDate(String date) {
		ResultSet Rs=null;
		try {
			Statement statement=this.connection.createStatement();
			Rs=statement.executeQuery("SELECT * FROM passagers LEFT JOIN billet ON passagers.ID_billet=billet.ID_Billet "
					+ "LEFT JOIN departs ON passagers.ID_Depart=departs.ID_Depart"
					+ " INNER JOIN villledestinations ON departs.ID_Destination=villledestinations.ID_Destination"
					+ " WHERE passagers.Type_Passager=2 AND passagers.Date_voy="+"'"+date+"'"+";");
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
			result = statement.executeQuery("SELECT ID_Passager FROM passagers ORDER BY ID_Passager DESC LIMIT 1;");
			if(result.next())
				ID=result.getLong("ID_Passager");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return ID+1;
	}
	
	
	
	public Passager updateEtat(Passager object) {
		 PreparedStatement prepare;
		
			try {
				prepare = connection.prepareStatement("UPDATE passagers SET cout=?,etat=? WHERE ID_Passager=?");
				prepare.setDouble(1, object.getMontant());
				prepare.setInt(2, object.getEtat());
				prepare.setLong(3, object.getId());
				prepare.executeUpdate();
				 object=find(object.getId());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return object;
			 
	}
			public ResultSet findReservationToDay(String date){
				ResultSet Rs=null;
					Statement statement;
					try {
						statement = this.connection.createStatement();
						Rs=statement.executeQuery("SELECT * FROM passagers WHERE Date_enreg='"+date+"' AND Type_Passager=2");
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					return Rs;
	}
			
	}
	

