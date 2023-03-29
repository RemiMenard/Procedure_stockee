package gsb.service;

import gsb.modele.Stocker;
import gsb.modele.dao.StockerDao;

public class StockerService {
	public static Stocker rechercher(String MED_DEPOTLEGAL, String MATRICULE){
		Stocker unStock = null;
		try{
		if (unStock==null) {
            throw new Exception("Donnée obligatoire : Matricule du visiteur");
        }
		unStock = StockerDao.rechercher(MED_DEPOTLEGAL, MATRICULE);
		}
		catch(Exception e){
			System.out.println( e.getMessage());
		}
		return unStock;
	}
	
	public static int creer(Stocker unStock){
		int nb = 0;
		try{
			nb=StockerDao.creer(unStock); 
		}
		catch(Exception e){
			System.out.println( e.getMessage());
		}
		return nb;
	}
}
