package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;



public class DataBaseConnect {
	private static String Url="jdbc:mysql://localhost:3306/bd-trans";
	private static String User="root";
	private static String PassWord="";
	public static Connection connection;
	public DataBaseConnect(String url, String user, String passWord) {
		super();
		Url = url;
		User = user;
		PassWord = passWord;
	}
	public String getUrl() {
		return Url;
	}
	public void setUrl(String url) {
		Url = url;
	}
	public String getUser() {
		return User;
	}
	public void setUser(String user) {
		User = user;
	}
	public String getPassWord() {
		return PassWord;
	}
	public void setPassWord(String passWord) {
		PassWord = passWord;
	}
	public static Connection getConnection() {
		if(connection==null) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				connection=DriverManager.getConnection(Url,User,PassWord);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return connection;
	}
	public static void sqlite() {
		 Connection connection = null;

	     try {
	         Class.forName("org.sqlite.JDBC");
	         String dbURL = "jdbc:sqlite:/Bureau/donnees.db";
	         connection = DriverManager.getConnection(dbURL);

	         if (connection != null) {
	             System.out.println("Connexion réussie à la base de données SQLite.");
	         }
	     } catch ( Exception e) {
	         ((Throwable) e).printStackTrace();
	     } finally {
	         try {
	             if (connection != null) {
	                 connection.close();
	             }
	         } catch (Exception e) {
	             e.printStackTrace();
	         }
	     }
	}
	
}
