package gsb.modele.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import gsb.modele.Medicament;
import gsb.modele.Stocker;
import gsb.modele.Visiteur;

public class StockerDao {
	public static Stocker rechercher(String MED_DEPOTLEGAL, String MATRICULE){
		Stocker unStock = null;
		Medicament unMedicament= null;
		Visiteur unVisiteur = null;
		ResultSet reqSelection = ConnexionMySql.execReqSelection("select * from STOCKER where MED_DEPOTLEGAL='"+MED_DEPOTLEGAL+"'and MATRICULE='"+MATRICULE+"'");
		try {
			if (reqSelection.next()) {
				unVisiteur = VisiteurDao.rechercher(reqSelection.getString(3));
				unMedicament = MedicamentDao.rechercher(reqSelection.getString(2));
				unStock = new Stocker(reqSelection.getInt(1),unVisiteur,unMedicament);	
			};
			}
		catch(Exception e) {
			System.out.println("erreur reqSelection.next() pour la requête - select * from STOCKER where MED_DEPOTLEGAL='"+MED_DEPOTLEGAL+"'and MATRICULE='"+MATRICULE+"'");
			e.printStackTrace();
			}
		ConnexionMySql.fermerConnexionBd();
		return unStock;
	}


	
	public static int creer(Stocker unStock){
		String requeteInsertion;
		int result = 0;
		int qteStock = unStock.getQteStock();
		String unMedicament =  unStock.getUnMedicament().getMED_DEPOTLEGAL();
		String unVisiteur =unStock.getUnVisiteur().getMatricule();
		requeteInsertion = "insert into STOCKER values("+qteStock+",'"+unMedicament+"','"+unVisiteur+"')";
		try{
			result = ConnexionMySql.execReqMaj(requeteInsertion);
		}
		catch (Exception e){
			System.out.println("echec insertion : "+requeteInsertion);
		}
		ConnexionMySql.fermerConnexionBd();	
		return result;
}
	
	public static int modifierStock (Stocker unStock){
		String requeteInsertion;
		int result = 0;
		int qteStock = unStock.getQteStock();
		String unMedicament =  unStock.getUnMedicament().getMED_DEPOTLEGAL();
		String unVisiteur =unStock.getUnVisiteur().getMatricule();
		requeteInsertion = "UPDATE STOCKER SET QTESTOCK = "+qteStock+" WHERE MED_DEPOTLEGAL='"+unMedicament+"' and MATRICULE='"+unVisiteur+"'";
		try{
			result = ConnexionMySql.execReqMaj(requeteInsertion);
		}
		catch (Exception e){
			System.out.println("echec insertion : "+requeteInsertion);
		}
		ConnexionMySql.fermerConnexionBd();	
		return result;
}
	
	public static ArrayList<Stocker> retournerCollectionDesStock(){
		ArrayList<Stocker>lesStocks = new ArrayList<Stocker>();
		ResultSet reqSelection = ConnexionMySql.execReqSelection("select * from STOCKER");
		try{
		while (reqSelection.next()) {
			String depotLegal = reqSelection.getString(2);
			String matricule = reqSelection.getString(3);
		    lesStocks.add(StockerDao.rechercher(depotLegal,matricule));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("erreur retournerCollectionDesStocks()");
		}
		return lesStocks;
	}
	
	public static ArrayList<Stocker> retournerCollectionDesStockParVisiteur(String matricule){
		ArrayList<Stocker>lesStocks = new ArrayList<Stocker>();
		String requete="select * from STOCKER WHERE MATRICULE ='"+matricule+"'";
		System.out.println(requete);
		ResultSet reqSelection = ConnexionMySql.execReqSelection(requete);
		try{
		while (reqSelection.next()) {
			String depotLegal = reqSelection.getString(2);
		    lesStocks.add(StockerDao.rechercher(depotLegal,matricule));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println(requete);
		}
		return lesStocks;
	}
}
