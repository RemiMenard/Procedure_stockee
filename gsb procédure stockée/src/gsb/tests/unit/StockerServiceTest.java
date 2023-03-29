package gsb.tests.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import gsb.modele.Medicament;
import gsb.modele.Stocker;
import gsb.modele.Visiteur;
import gsb.modele.dao.MedicamentDao;
import gsb.modele.dao.VisiteurDao;
import gsb.service.MedicamentService;
import gsb.service.StockerService;

class StockerServiceTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testRechercherEchoue() {
		assertNull("Resultat rechercher :", MedicamentService.rechercher("a999"));
	}
	
	@Test
	void testRechercherReussi() {
		assertEquals("qte stock : ",7,StockerService.rechercher("3MYC7", "a131").getQteStock());
	}

	@Test
	void testCreerReussi() {
		Visiteur unVisiteur2 = VisiteurDao.rechercher("a131");
		Medicament unMedicament2 = MedicamentDao.rechercher("3MYC7");	
		Stocker unStock = new Stocker(8,unVisiteur2,unMedicament2);
		assertEquals("Resultat creer :",1, StockerService.creer(unStock));
	}
	
	@Test
	void testCreerEchoue() {
		Visiteur unVisiteur2 = VisiteurDao.rechercher("d489");
		Medicament unMedicament2 = MedicamentDao.rechercher("fqgzh");	
		Stocker unStock = new Stocker(8,unVisiteur2,unMedicament2);
		assertEquals("Resultat creer :",1, StockerService.creer(unStock));
	}

}
