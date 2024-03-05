package DataBase;



public class DAOfactory {
	public UtilisateurDAO getUtilisateurDAO() {
		return new UtilisateurDAO();
	}
	public GpUtilisateurDAO getGpUtilisateurDAO() {
		return new GpUtilisateurDAO(); 
	}
	public PassagerDAO getPassagerDAO() {
		return new PassagerDAO();
	}
	public DestinationDAO getDestinationDAO() {
		return new DestinationDAO();
	}
	public DepartDAO getDepartDAO() {
		return new DepartDAO();
	}
	public BilletDAO getBilletDAO() {
		return new BilletDAO();
	}
	public ColisDAO getColisDAO(){
		return new ColisDAO();
	}
	public CourierDAO getCourierDAO() {
		return new CourierDAO();
	}
	public LigneDAO getLigneDAO() {
		return new LigneDAO();
	}
}
