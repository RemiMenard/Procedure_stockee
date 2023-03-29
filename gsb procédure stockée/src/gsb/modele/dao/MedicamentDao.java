package gsb.modele.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import gsb.modele.Localite;
import gsb.modele.Medicament;
import gsb.modele.Visiteur;

public class MedicamentDao {
	public static Medicament rechercher(String depotLegal) {
		Medicament unMedicament = null;
		ResultSet reqSelection = ConnexionMySql.execReqSelection("select * from MEDICAMENT where MED_DEPOTLEGAL ='" + depotLegal + "'");
		try {
			if (reqSelection.next()) {
				//`MED_DEPOTLEGAL`, `MED_NOMCOMMERCIAL`, `MED_COMPOSITION`, `MED_EFFETS`, 
				//`MED_CONTREINDIC`, `MED_PRIXECHANTILLON`, `FAM_CODE`, `FAM_LIBELLE`
				unMedicament = new Medicament(reqSelection.getString(1),reqSelection.getString(2),reqSelection.getString(3),reqSelection.getString(4),reqSelection.getString(5),reqSelection.getDouble(6),reqSelection.getString(7),reqSelection.getString(8));
			}
			;
		} catch (Exception e) {
			System.out.println("select * from MEDICAMENT where MED_DEPOTLEGAL ='" + depotLegal + "'");
			e.printStackTrace();
		}
		ConnexionMySql.fermerConnexionBd();
		return unMedicament;
	}
	
	
	public static int creer (Medicament unMedicament){
		String requeteInsertion;
		int result = 0;
		String MED_DEPOTLEGAL= unMedicament.getMED_DEPOTLEGAL();
		String MED_NOMCOMMERCIAL = unMedicament.getMED_NOMCOMMERCIAL();
		String MED_COMPOSITION = unMedicament.getMED_COMPOSITION();
		String MED_EFFETS =  unMedicament.getMED_EFFETS();
		String MED_CONTREINDIC =  unMedicament.getMED_CONTREINDIC();
		double MED_PRIXECHANTILLON =  unMedicament.getMED_PRIXECHANTILLON();
		String FAM_CODE = unMedicament.getFAM_CODE();
		String FAM_LIBELLE = unMedicament.getFAM_LIBELLE();
		
		requeteInsertion = "insert into MEDICAMENT values('"+MED_DEPOTLEGAL+"','"+MED_NOMCOMMERCIAL+"','"+MED_COMPOSITION+"','"+MED_EFFETS+"','"+MED_CONTREINDIC+"','"+MED_PRIXECHANTILLON+"','"+FAM_CODE+"','"+FAM_LIBELLE+"')";
		try{
			result = ConnexionMySql.execReqMaj(requeteInsertion);
		}
		catch (Exception e){
			System.out.println("echec insertion : "+requeteInsertion);
		}
		ConnexionMySql.fermerConnexionBd();	
		return result;
	}
	
	public static ArrayList<Medicament> retournerCollectionDesMedicament(){
		ArrayList<Medicament>lesMedicaments = new ArrayList<Medicament>();
		ResultSet reqSelection = ConnexionMySql.execReqSelection("select MED_DEPOTLEGAL from MEDICAMENT");
		try{
		while (reqSelection.next()) {
			String depotLegal = reqSelection.getString(1);
		    lesMedicaments.add(MedicamentDao.rechercher(depotLegal));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("erreur retournerCollectionDesMedicaments()");
		}
		return lesMedicaments;
	}
	
	
}
