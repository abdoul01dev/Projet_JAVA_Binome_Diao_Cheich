package DataBase;

import java.sql.Connection;
import java.sql.ResultSet;

public abstract  class DAO<T> {
	public Connection connection=DataBaseConnect.getConnection();
	//methode pour créer un objet pour chaque insertion
	public abstract T create(T object);
	//methode pour la recherche d'un objet 
	public abstract T find(Long id);
	//methode pour la mise à jour des objet
	public abstract T update(T object);
	//methode pour la suppression
	public abstract void delete(T object);
	
	public abstract ResultSet findAll();
}
