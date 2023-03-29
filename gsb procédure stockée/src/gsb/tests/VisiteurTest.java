package gsb.tests;

import gsb.modele.Localite;
import gsb.modele.Visiteur;

public class VisiteurTest {
	public static void main (String[] args) {
		Localite uneLocalite = new Localite ("56330","Pluvigner");
		Visiteur unVisiteur = new Visiteur ("007","Dupont","Charles","CDupont","azerty123","2 rue de la joie",uneLocalite,"0637346255","09/04/2021",50,"SW","SWISS","généraliste","a1");
		System.out.println("Nom visiteur :"+unVisiteur.getNom());
		System.out.println("Prénom visiteur :"+unVisiteur.getNom());
		System.out.println("Matricule visiteur :"+unVisiteur.getNom());
	}
}
