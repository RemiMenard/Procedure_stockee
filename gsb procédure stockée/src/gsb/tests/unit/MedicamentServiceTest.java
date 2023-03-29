package gsb.tests.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import gsb.modele.Localite;
import gsb.modele.Medicament;
import gsb.modele.Visiteur;
import gsb.modele.dao.LocaliteDao;
import gsb.service.MedicamentService;
import gsb.service.VisiteurService;

class MedicamentServiceTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testRechercherMedicamentNull() {
		assertNull("Resultat rechercher :", MedicamentService.rechercher("a999"));
	}
	
	@Test
	void testRechercherMedicamentReussi() {
		assertEquals("MED_NOMCOMMERCIAL du médicament : ","TRIMYCINE",MedicamentService.rechercher("3MYC7").getMED_NOMCOMMERCIAL());
	}
	
	@Test
	void testCreerMedicamentEchoue() {
		Medicament unMedicament2 = new Medicament("Q5H6D","Nom commercial","med composition","effet du medicament","med contre indic",5.0, "fam","famille libelle");
		assertEquals("Resultat creer :",0, MedicamentService.creer(unMedicament2));
	}
	
	@Test
	void testCreerMedicamentReussi() {
			Medicament unMedicament2 = new Medicament("ACVDE","Nom commercial","med composition","effet du medicament","med contre indic",5.0, "fam","famille libelle");
			assertEquals("Resultat creer :",1, MedicamentService.creer(unMedicament2));
	}

}
