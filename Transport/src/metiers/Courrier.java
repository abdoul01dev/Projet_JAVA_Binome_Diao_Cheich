package metiers;

public class Courrier extends Colis{

	public Courrier(Long id, String code, int type, String dateRecep, String dateSortie, String description,
			Double valeur, Peseonne expediteur, Peseonne destinataire) {
		super(id, code, type, dateRecep, dateSortie, description, valeur, expediteur, destinataire);
		// TODO Auto-generated constructor stub
	}
	
}
