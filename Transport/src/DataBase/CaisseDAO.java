package DataBase;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import metiers.Caisse;

public class CaisseDAO extends DAO<Caisse> {

	@Override
	public Caisse create(Caisse object) {
		try {
			Statement statement=connection.createStatement();
			PreparedStatement prepare=connection.prepareStatement(
					"INSERT INTO `caisse` ( `Date`, `justification`, `Responsable`, `Montant`, `code`)"
					+ " VALUES ( ?, ?, ?, ?, ?);");
			prepare.setString(1, object.getDate());
			prepare.setString(2, object.getJustification());
			prepare.setString(3, object.getResponsable());
			prepare.setDouble(4, object.getMontant());
			prepare.setInt(5, object.getCode());
			prepare.executeUpdate();
			 ResultSet result = statement.executeQuery("SELECT ID_caisse FROM caisse ORDER BY ID_caisse DESC LIMIT 1;");
			 if(result.next()) {
				 long ID = result.getLong("ID_caisse");
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
	public Caisse find(Long id) {
		Caisse caisse=null;
		try {
			Statement statement=this.connection.createStatement();
			ResultSet Rs=statement.executeQuery("SELECT * FROM `caisse` WHERE code=1 AND ID_caisse="+id);
			if(Rs.next()) {
				caisse=new Caisse(id, Rs.getString("Date"), Rs.getString("justification"),
						Rs.getString("Responsable"), Rs.getDouble("Montant"), Rs.getInt("code"));	
			}
				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return caisse;
	}

	@Override
	public Caisse update(Caisse object) {
		PreparedStatement prepare;
		try {
			prepare = connection.prepareStatement("UPDATE `caisse` SET `Date`=?,`justification`=?,`Responsable`=?,`Montant`=?,`code`=? WHERE ID_caisse="+object.getId());
			prepare.setString(1, object.getDate());
			prepare.setString(2, object.getJustification());
			prepare.setString(3, object.getResponsable());
			prepare.setDouble(4, object.getMontant());
			prepare.setInt(5, object.getCode());
			 prepare.executeUpdate();
			 object=find(object.getId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return object;
	}

	@Override
	public void delete(Caisse object) {
		Statement statement;
		try {
			statement = this.connection.createStatement();
			statement.executeUpdate("DELETE FROM `caisse` WHERE 0 ID_caisse= "+object.getId());
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
			Rs=statement.executeQuery("SELECT * FROM `caisse` WHERE code=1 ");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Rs;
	}
	
	public Double getMDepense(String dateDu,String dateAu) {
		ResultSet Rs=null;
		Double montant=0.0;
		if(dateDu!=null && dateAu!=null) {
			try {
				Statement statement=this.connection.createStatement();
				Rs=statement.executeQuery("SELECT\r\n"
						+ "    SUM(Montant)\r\n"
						+ "FROM\r\n"
						+ "    caisse\r\n"
						+ "    WHERE\r\n"
						+ "    code=1\r\n"
						+ "    AND\r\n"
						+ "    Date BETWEEN '"+dateDu+"' AND '"+dateAu+"'");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			try {
				Statement statement=this.connection.createStatement();
				Rs=statement.executeQuery("SELECT\r\n"
						+ "    SUM(Montant)\r\n"
						+ "FROM\r\n"
						+ "    caisse\r\n"
						+ "    WHERE\r\n"
						+ "    code=1\r\n"
						);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		try {
			if(Rs.next()) {
				montant= Rs.getDouble(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return montant;
	}
	
	public Double getMbillet(String dateDu,String dateAu) {
		ResultSet Rs=null;
		Double montant=0.0;
		if(dateDu!=null && dateAu!=null) {
			try {
				Statement statement=this.connection.createStatement();
				Rs=statement.executeQuery("SELECT\r\n"
						+ "    SUM(Montant)\r\n"
						+ "FROM\r\n"
						+ "    caisse\r\n"
						+ "    WHERE\r\n"
						+ "    code=2\r\n"
						+ "    AND\r\n"
						+ "    Date BETWEEN '"+dateDu+"' AND '"+dateAu+"'");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			try {
				Statement statement=this.connection.createStatement();
				Rs=statement.executeQuery("SELECT\r\n"
						+ "    SUM(Montant)\r\n"
						+ "FROM\r\n"
						+ "    caisse\r\n"
						+ "    WHERE\r\n"
						+ "    code=2\r\n"
						);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		try {
			if(Rs.next()) {
				montant= Rs.getDouble(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return montant;
	}
	
	public Double getMreservation(String dateDu,String dateAu) {
		ResultSet Rs=null;
		Double montant=0.0;
		if(dateDu!=null && dateAu!=null) {
			try {
				Statement statement=this.connection.createStatement();
				Rs=statement.executeQuery("SELECT\r\n"
						+ "    SUM(Montant)\r\n"
						+ "FROM\r\n"
						+ "    caisse\r\n"
						+ "    WHERE\r\n"
						+ "    code=3\r\n"
						+ "    AND\r\n"
						+ "    Date BETWEEN '"+dateDu+"' AND '"+dateAu+"'");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			try {
				Statement statement=this.connection.createStatement();
				Rs=statement.executeQuery("SELECT\r\n"
						+ "    SUM(Montant)\r\n"
						+ "FROM\r\n"
						+ "    caisse\r\n"
						+ "    WHERE\r\n"
						+ "    code=3\r\n"
						);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		try {
			if(Rs.next()) {
				montant= Rs.getDouble(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return montant;
	}
	public Double getMcolis(String dateDu,String dateAu) {
		ResultSet Rs=null;
		Double montant=0.0;
		if(dateDu!=null && dateAu!=null) {
			try {
				Statement statement=this.connection.createStatement();
				Rs=statement.executeQuery("SELECT\r\n"
						+ "    SUM(Montant)\r\n"
						+ "FROM\r\n"
						+ "    caisse\r\n"
						+ "    WHERE\r\n"
						+ "    code=4\r\n"
						+ "    AND\r\n"
						+ "    Date BETWEEN '"+dateDu+"' AND '"+dateAu+"'");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			try {
				Statement statement=this.connection.createStatement();
				Rs=statement.executeQuery("SELECT\r\n"
						+ "    SUM(Montant)\r\n"
						+ "FROM\r\n"
						+ "    caisse\r\n"
						+ "    WHERE\r\n"
						+ "    code=4\r\n"
						);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		try {
			if(Rs.next()) {
				montant= Rs.getDouble(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return montant;
	}

	public Double getMcourriers(String dateDu,String dateAu) {
		ResultSet Rs=null;
		Double montant=0.0;
		if(dateDu!=null && dateAu!=null) {
			try {
				Statement statement=this.connection.createStatement();
				Rs=statement.executeQuery("SELECT\r\n"
						+ "    SUM(Montant)\r\n"
						+ "FROM\r\n"
						+ "    caisse\r\n"
						+ "    WHERE\r\n"
						+ "    code=5\r\n"
						+ "    AND\r\n"
						+ "    Date BETWEEN '"+dateDu+"' AND '"+dateAu+"'");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			try {
				Statement statement=this.connection.createStatement();
				Rs=statement.executeQuery("SELECT\r\n"
						+ "    SUM(Montant)\r\n"
						+ "FROM\r\n"
						+ "    caisse\r\n"
						+ "    WHERE\r\n"
						+ "    code=5\r\n"
						);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		try {
			if(Rs.next()) {
				montant= Rs.getDouble(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return montant;
	}
	
	public Double getSolde(String dateDu,String dateAu) {
		return (getMbillet(dateDu, dateAu)+
				getMreservation(dateDu, dateAu)+
				getMcourriers(dateDu, dateAu)+
				getMcolis(dateDu, dateAu)-
				getMDepense(dateDu, dateAu));
				
	}
	public boolean getJustif(String justif) {
		ResultSet Rs=null;
		boolean j=false;
		try {
			Statement statement=this.connection.createStatement();
			Rs=statement.executeQuery("SELECT * FROM caisse WHERE justification='"+justif+"' ");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if(Rs.next()) {
				j=true;
			}else {
				j=false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return j;
		
	}
	

}
