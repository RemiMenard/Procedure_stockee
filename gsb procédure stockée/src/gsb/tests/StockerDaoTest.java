package gsb.tests;

import java.util.ArrayList;

import gsb.modele.Medicament;
import gsb.modele.Stocker;
import gsb.modele.Visiteur;
import gsb.modele.dao.MedicamentDao;
import gsb.modele.dao.StockerDao;
import gsb.modele.dao.VisiteurDao;

public class StockerDaoTest {

public static void main(String[] args) {
		
		
		//Stocker unStock = StockerDao.rechercher("3MYC7");
		//System.out.println("qte stock = "+unStock.getQteStock());
		//System.out.println("MED_DEPOTLEGAL = "+unStock.getUnMedicament());
		//System.out.println("Matricule = "+unStock.getUnVisiteur());
		
		
		
	//Visiteur unVisiteur2 = VisiteurDao.rechercher("a131");
	//Medicament unMedicament2 = MedicamentDao.rechercher("AMOX45");	
	//Stocker unStock2 = new Stocker (3,unVisiteur2,unMedicament2);
		//int nb = StockerDao.creer(unStock2);
		//System.out.println(nb);
	
	ArrayList<Stocker> lesStocks=StockerDao.retournerCollectionDesStockParVisiteur("a131");
	System.out.println(lesStocks.size());
	System.out.println(lesStocks);
	}
}
