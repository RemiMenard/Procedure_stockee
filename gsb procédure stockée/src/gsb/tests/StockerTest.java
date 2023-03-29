package gsb.tests;

import gsb.modele.Localite;
import gsb.modele.Medicament;
import gsb.modele.Stocker;
import gsb.modele.Visiteur;
import gsb.modele.dao.MedicamentDao;
import gsb.modele.dao.VisiteurDao;
import gsb.service.StockerService;

public class StockerTest {
	public static void main(String[] args) {
		//Localite uneLocalite = new Localite ("56330","Pluvigner");
		//Visiteur unVisiteur = new Visiteur ("007","Dupont","Charles","CDupont","azerty123","2 rue de la joie",uneLocalite,"0637346255","09/04/2021",50,"008","nomUnite");
		//Medicament unMedicament = new Medicament("azerty64","Nom commercial","med composition","effet du medicament","med contre indic",5.0, "famille code","famille libelle");
		Visiteur unVisiteur = VisiteurDao.rechercher("a131");
		Medicament unMedicament = MedicamentDao.rechercher("3MYC7");
		Stocker unStock = new Stocker (7,unVisiteur,unMedicament);
		System.out.println("visiteur stock : "+unStock.getUnVisiteur().getNom());
		
	}
}
