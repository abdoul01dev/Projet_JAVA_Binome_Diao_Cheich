package DataBase;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import metiers.GpUtilisateur;

public class GpUtilisateurDAO extends DAO<GpUtilisateur> {

	@Override
	public GpUtilisateur create(GpUtilisateur object) {
		try {
			Statement statement= this.connection.createStatement();
			
			
			 PreparedStatement prepare=connection.prepareStatement("INSERT INTO grouputilisateurs(Role_GU,Description) "
			 		+ "values(?,?);");
			 prepare.setString(1, object.getRole());
			 prepare.setString(2, object.getDescription());
			 prepare.executeUpdate();
			 ResultSet result = statement.executeQuery("SELECT ID_GU FROM grouputilisateurs ORDER BY ID_GU DESC LIMIT 1;");
			 if(result.next()) {
				 long ID = result.getLong("ID_GU");
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
	public GpUtilisateur find(Long id) {
		GpUtilisateur gpuser=null;
		try {
			Statement statement=this.connection.createStatement();
			ResultSet result=statement.executeQuery("SELECT * FROM grouputilisateurs  WHERE ID_GU="+id);
			if(result.next()) {
				gpuser=new GpUtilisateur(id, result.getString("Role_GU"),result.getString("Description"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return gpuser;
	}

	@Override
	public GpUtilisateur update(GpUtilisateur object) {
		try {
			PreparedStatement Pstatement = this.connection.prepareStatement("UPDATE grouputilisateurs SET Role_GU=?,Description=?;");
			Pstatement.setString(1, object.getRole());
			Pstatement.setString(2, object.getDescription());
			Pstatement.setLong(4, object.getId());
			Pstatement.executeUpdate();
			object=this.find(object.getId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return object;
	}


	@Override
	public void delete(GpUtilisateur object) {
		try {
			Statement statement=this.connection.createStatement();
			statement.executeUpdate("DELETE  FROM grouputilisateurs WHERE ID_GU="+object.getId());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public ResultSet findAll() {
		ResultSet Rs=null;
		try {
			Statement statement=this.connection.createStatement();
			Rs=statement.executeQuery("SELECT * FROM grouputilisateurs ");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Rs;
		
	}
	
}
