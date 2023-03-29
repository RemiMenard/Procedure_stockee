package gsb.tests;


import gsb.modele.Medicament;
import gsb.modele.dao.MedicamentDao;




public class MedicamentDaoTest {
	
	public static void main(String[] args) {

		Medicament unMedicament = null;
		
		unMedicament = MedicamentDao.rechercher("3MYC7");
		
		System.out.println(unMedicament.getMED_DEPOTLEGAL());
		System.out.println(unMedicament.getMED_NOMCOMMERCIAL());
		System.out.println(unMedicament.getMED_COMPOSITION());
		System.out.println(unMedicament.getMED_EFFETS());
		System.out.println(unMedicament.getMED_CONTREINDIC());
		System.out.println(unMedicament.getMED_PRIXECHANTILLON());
		System.out.println(unMedicament.getFAM_CODE());
		System.out.println(unMedicament.getFAM_LIBELLE());
		
		Medicament unMedicament2 = new Medicament("Q5H6D","Nom commercial","med composition","effet du medicament","med contre indic",5.0, "fam","famille libelle");
		int nb = MedicamentDao.creer(unMedicament2);
		System.out.println(nb); 
	}
}
