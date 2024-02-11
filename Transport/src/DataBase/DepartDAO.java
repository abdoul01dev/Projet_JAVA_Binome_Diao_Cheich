package DataBase;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import metiers.Billet;
import metiers.Depart;

public class DepartDAO extends DAO<Depart>{

	@Override
	public Depart create(Depart object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Depart find(Long id) {
		Depart depart=null;
		try {
			Statement statement=this.connection.createStatement();
			ResultSet Rs=statement.executeQuery("SELECT * FROM departs WHERE ID_Depart="+id);
			if(Rs.next())
				depart=new Depart(id,Rs.getString("Jour"), Rs.getString("Heure"), Rs.getInt("NbrsPlcs"), Rs.getLong("ID_Destination"));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return depart;
	}

	@Override
	public Depart update(Depart object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Depart object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ResultSet findAll() {
		ResultSet Rs=null;
		try {
			Statement statement=this.connection.createStatement();
			Rs=statement.executeQuery("SELECT * FROM departs");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Rs;
	}
	
	public ResultSet findByIdDeDestination(Long idDes) {
		ResultSet Rs=null;
		try {
			Statement statement=this.connection.createStatement();
			Rs=statement.executeQuery("SELECT * FROM departs WHERE ID_Destination="+idDes);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Rs;
		
	}
}
