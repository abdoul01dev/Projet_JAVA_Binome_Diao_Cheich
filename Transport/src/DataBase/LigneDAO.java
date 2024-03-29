package DataBase;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import metiers.Depart;
import metiers.Ligne;
public class LigneDAO extends DAO<Ligne>{

	@Override
	public Ligne create(Ligne object) {
		try {
			Statement statement=connection.createStatement();
			PreparedStatement prepare=connection.prepareStatement(
					"INSERT INTO `ligne`( `nomLingne`) VALUES (?)");
			prepare.setString(1, object.getNom());
			prepare.executeUpdate();
			 ResultSet result = statement.executeQuery("SELECT ID_ligne FROM ligne ORDER BY ID_ligne DESC LIMIT 1;");
			 if(result.next()) {
				 long ID = result.getLong("ID_ligne");
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
	public Ligne find(Long id) {
		Ligne ligne=null;
		try {
			Statement statement=this.connection.createStatement();
			ResultSet Rs=statement.executeQuery("SELECT * FROM ligne WHERE ID_ligne="+id);
			if(Rs.next()) {
				ligne=new Ligne(id,Rs.getString("nomLingne"));
				DepartDAO departDAO=new DepartDAO();
				ResultSet rs=departDAO.findByIdLigne(id);
				ObservableList <Depart>l=FXCollections.observableArrayList();
				while(rs.next()) {
					l.add(departDAO.find(rs.getLong("ID_depart")));
				}
				ligne.setListDepart(l);
			}
				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ligne;
	}

	@Override
	public Ligne update(Ligne object) {
		PreparedStatement prepare;
		try {
			prepare = connection.prepareStatement("UPDATE `ligne` SET `nomLingne`=? WHERE ID_ligne="+object.getId());
			 prepare.setString(1, object.getNom());
			 prepare.executeUpdate();
			 object=find(object.getId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return object;
	}

	@Override
	public void delete(Ligne object) {
		Statement statement;
		try {
			statement = this.connection.createStatement();
			statement.executeUpdate("DELETE FROM  ligne WHERE ID_Ligne= "+object.getId());
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
			Rs=statement.executeQuery("SELECT * FROM ligne");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Rs;
	}

}
