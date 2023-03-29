package gsb.vue;

import gsb.modele.Medecin;
import gsb.modele.Visiteur;

public class JIFVisiteurFiche extends JIFVisiteur {

	private static final long serialVersionUID = 1L;

	public JIFVisiteurFiche(Visiteur unVisiteur) {
		super();
		this.remplirText(unVisiteur);

	}
	

}
