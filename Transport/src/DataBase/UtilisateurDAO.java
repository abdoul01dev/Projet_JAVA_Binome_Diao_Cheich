package DataBase;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import application.UtilisateursController;
import metiers.Utilisateur;

public class UtilisateurDAO extends DAO<Utilisateur> {

	public static Utilisateur userCourent=null;
	@Override
	public Utilisateur create(Utilisateur object) {
		
		try {
			Statement statement= this.connection.createStatement();
			
			
			 PreparedStatement prepare=connection.prepareStatement("INSERT INTO utilisateurs(Nom_Ut,Mail_Ut,MotPass_Ut,statut,Date_Creer,ID_GU) "
			 		+ "values(?,?,?,?,?,?);");
			 prepare.setString(1, object.getNomUt());
			 prepare.setString(2, object.getMail());
			 prepare.setString(3, object.getMotdepasse());
			 prepare.setInt(4, 0);
			 prepare.setString(5, object.getDteCreation());
			 prepare.setLong(6, object.getIdgroupeUt());
			 prepare.executeUpdate();
			 ResultSet result = statement.executeQuery("SELECT ID_Ut FROM utilisateurs ORDER BY ID_Ut DESC LIMIT 1;");
			 if(result.next()) {
				 long ID = result.getLong("ID_Ut");
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
	public Utilisateur find(Long id) {
		Utilisateur user=null;
		try {
			Statement statement=this.connection.createStatement();
			ResultSet result=statement.executeQuery("SELECT * FROM utilisateurs as U RIGHT JOIN grouputilisateurs as GU ON U.ID_GU=GU.ID_GU  WHERE ID_Ut="+id);
			if(result.next()) {
				user=new Utilisateur(id, result.getString("Nom_Ut"), result.getString("Mail_Ut"),
				result.getString("MotPass_Ut"), result.getLong("ID_GU"),result.getInt("statut"),result.getString("Date_Creer"));
				user.setGroupeUt(result.getString("Role_GU"));
				if(user.getCodeStatut()==1) {
					user.setStatut("Actif");
				}else {
					user.setStatut("Inactif");
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
	}

	@Override
	public Utilisateur update(Utilisateur object) {
		try {
			PreparedStatement Pstatement = this.connection.prepareStatement("UPDATE utilisateurs SET Nom_Ut=?,Mail_Ut=?,MotPass_Ut=?,statut=? WHERE ID_Ut=?;");
			Pstatement.setString(1, object.getNomUt());
			Pstatement.setString(2, object.getMail());
			Pstatement.setString(3, object.getMotdepasse());
			Pstatement.setInt(4, object.getCodeStatut());
			Pstatement.setLong(5, object.getId());
			Pstatement.executeUpdate();
			object=this.find(object.getId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return object;
	}

	@Override
	public void delete(Utilisateur object) {
		try {
			Statement statement=this.connection.createStatement();
			statement.executeUpdate("DELETE  FROM utilisateurs WHERE ID_Ut="+object.getId());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public ResultSet findAll() {
		ResultSet Rs=null;
		try {
			Statement statement=this.connection.createStatement();
			Rs=statement.executeQuery("SELECT * FROM utilisateurs as U RIGHT JOIN grouputilisateurs as GU ON U.ID_GU=GU.ID_GU ");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Rs;
		
	}
	
	public Utilisateur findLogin(String nomUser,String mdp) {
		Utilisateur user=null;
		try {
			Statement statement=this.connection.createStatement();
			ResultSet result=statement.executeQuery("SELECT * FROM utilisateurs as U RIGHT JOIN grouputilisateurs as GU ON U.ID_GU=GU.ID_GU "
					+ "WHERE Nom_Ut="+"'"+nomUser+"'"+" AND MotPass_Ut="+"'"+mdp+"'");
			if(result.next()) {
				user=new Utilisateur(result.getLong("ID_Ut"), result.getString("Nom_Ut"), result.getString("Mail_Ut"),
				result.getString("MotPass_Ut"), result.getLong("ID_GU"),result.getInt("statut"),result.getString("Date_Creer"));
				user.setGroupeUt(result.getString("Role_GU"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
	}
}
