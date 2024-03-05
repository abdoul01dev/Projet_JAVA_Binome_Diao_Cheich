package outils;

public class Jours {
	String jour;
	int numero;
	String abvreviation;
	public Jours(String jour, int numero, String abvreviation) {
		super();
		this.jour = jour;
		this.numero = numero;
		this.abvreviation = abvreviation;
	}
	public String getJour() {
		return jour;
	}
	public void setJour(String jour) {
		this.jour = jour;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getAbvreviation() {
		return abvreviation;
	}
	public void setAbvreviation(String abvreviation) {
		this.abvreviation = abvreviation;
	}
	@Override
	public String toString() {
		return jour ;
	}
	
	public Jours findMe(String jour) {
		if(this.jour.equals(jour))
			return this;
		return null;
	}
	
}
