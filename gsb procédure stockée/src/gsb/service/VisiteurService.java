package gsb.service;

import gsb.modele.Medecin;
import gsb.modele.Visiteur;
import gsb.modele.dao.MedecinDao;
import gsb.modele.dao.VisiteurDao;
import gsb.tests.VisiteurDaoTest;

public class VisiteurService extends VisiteurDaoTest{
	public static Visiteur rechercher(String unMatricule){
		Visiteur unVisiteur = null;
		try{
		if (unMatricule==null) {
            throw new Exception("Donnée obligatoire : Matricule du visiteur");
        }
		unVisiteur = VisiteurDao.rechercher(unMatricule);
		}
		catch(Exception e){
			System.out.println( e.getMessage());
		}
		return unVisiteur;
	}
	
	public static int creer(Visiteur unVisiteur){
		int nb = 0;
		try{
			nb=VisiteurDao.creer(unVisiteur); 
		}
		catch(Exception e){
			System.out.println( e.getMessage());
		}
		return nb;
	}

	public static int supprimer(String unMatricule) {
		int nb = 0;
		try{
			nb=VisiteurDao.supprimer(unMatricule); 
		}
		catch(Exception e){
			System.out.println( e.getMessage());
		}
		return nb;
		
		
	}
}
