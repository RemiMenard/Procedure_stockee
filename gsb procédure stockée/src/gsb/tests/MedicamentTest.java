package gsb.tests;

import gsb.modele.Medicament;

public class MedicamentTest {
	public static void main (String[] args) {
		Medicament unMedicament = new Medicament("azerty64","Nom commercial","med composition","effet du medicament","med contre indic",5.0, "famille code","famille libelle");
		System.out.println("Med depot "+ unMedicament.getMED_DEPOTLEGAL());
		System.out.println("Med nom com "+ unMedicament.getMED_NOMCOMMERCIAL());
	}
}
