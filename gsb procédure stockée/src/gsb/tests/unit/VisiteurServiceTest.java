package gsb.tests.unit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import gsb.modele.Localite;
import gsb.modele.Visiteur;
import gsb.modele.dao.LocaliteDao;
import gsb.service.VisiteurService;
import junit.framework.TestCase;



class VisiteurServiceTest extends TestCase {

	@BeforeEach
	protected
	void setUp() throws Exception {
	}

	@AfterEach
	protected
	void tearDown() throws Exception {
		if(VisiteurService.rechercher("a667") != null){
			VisiteurService.supprimer("a667");
		}
	}

	@Test
	void testRechercherVisiteurNull() {
		assertNull("Resultat rechercher :", VisiteurService.rechercher("a999"));
	}
	
	@Test
	void testRechercherVisiteurReussi() {
		assertEquals("Nom visiteur : ","Villechalane",VisiteurService.rechercher("a131").getNom());
	}
	
	@Test
	void testCreerVisiteurEchoue() {
		Localite paris = LocaliteDao.rechercher("75011");
		Visiteur unVisiteur2 = new Visiteur ("a131", "Villechalane", "Louis", "mdupont", "mdpDupont", "4 rue des lilas", paris , "0658891247", "09/04/2020", 80, "awaw", "unit01","généraliste","a1");
		assertEquals("Resultat creer :",0, VisiteurService.creer(unVisiteur2));
	}
	
	@Test
	void testCreerVisiteurReussi() {
		Localite paris = LocaliteDao.rechercher("75011");
		Visiteur unVisiteur2 = new Visiteur ("a667", "Dupont", "Martin", "mdupont", "mdpDupont", "4 rue des lilas", paris , "0658891247", "09/04/2020", 80, "awaw", "unit01","généraliste","a1");
		assertEquals("Nom visiteur : ",1,VisiteurService.creer(unVisiteur2));
	}
	
	@Test
	void testSupprimerVisiteurEchoue() {
		assertEquals("Nom visiteur : ",0,VisiteurService.supprimer("am78"));
	}
	
	@Test
	void testSupprimerVisiteurReussi() {
		assertEquals("Nom visiteur : ",1,VisiteurService.supprimer("a667"));
	}
	

}
