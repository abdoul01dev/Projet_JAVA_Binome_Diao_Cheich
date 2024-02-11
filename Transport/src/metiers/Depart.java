package metiers;

public class Depart {
	private Long id;
	private String jour;
	private String heure;
	private int nbrPlaces;
	private Long idDestination;
	public Depart(Long id, String jour, String heure, int nbrPlaces, Long idDestination) {
		super();
		this.id = id;
		this.jour = jour;
		this.heure = heure;
		this.nbrPlaces = nbrPlaces;
		this.idDestination = idDestination;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getJour() {
		return jour;
	}
	public void setJour(String jour) {
		this.jour = jour;
	}
	public String getHeure() {
		return heure;
	}
	public void setHeure(String heure) {
		this.heure = heure;
	}
	public int getNbrPlaces() {
		return nbrPlaces;
	}
	public void setNbrPlaces(int nbrPlaces) {
		this.nbrPlaces = nbrPlaces;
	}
	public Long getIdDestination() {
		return idDestination;
	}
	public void setIdDestination(Long idDestination) {
		this.idDestination = idDestination;
	}
	@Override
	public String toString() {
		return getHeure();
	}
	
}
