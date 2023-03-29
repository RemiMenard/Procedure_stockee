package gsb.service;

import gsb.modele.Medicament;
import gsb.modele.Visiteur;
import gsb.modele.dao.MedicamentDao;
import gsb.modele.dao.VisiteurDao;

public class MedicamentService {
	public static Medicament rechercher(String depotLegal){
		Medicament unMedicament = null;
		try{
		if (depotLegal==null) {
            throw new Exception("Donnée obligatoire : Matricule du visiteur");
        }
		unMedicament = MedicamentDao.rechercher(depotLegal);
		}
		catch(Exception e){
			System.out.println( e.getMessage());
		}
		return unMedicament;
	}
	
	public static int creer(Medicament unMedicament){
		int nb = 0;
		try{
			nb=MedicamentDao.creer(unMedicament); 
		}
		catch(Exception e){
			System.out.println( e.getMessage());
		}
		return nb;
	}

}
