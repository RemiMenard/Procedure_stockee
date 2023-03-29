package gsb.modele.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import gsb.modele.Localite;
import gsb.modele.Visiteur;

public class VisiteurDao {
	public static Visiteur rechercher(String matriculeVisiteur) {
		Visiteur unVisiteur = null;
		Localite uneLocalite = null;
		ResultSet reqSelection = ConnexionMySql.execReqSelection("select * from VISITEUR where MATRICULE ='" + matriculeVisiteur + "'");
		try {
			if (reqSelection.next()) {
				// `VISITEUR` (`1MATRICULE`, `2NOM`, `3PRENOM`, `4LOGIN`, `5MDP`, `6ADRESSE`,
				// `7CODEPOSTAL`, `8DATEENTREE`, `9CODEUNIT`, `10NOMUNIT` ,11tel, 12prime)
				// Visiteur(String matricule 1,String nom 2, String prenom, String login, String
				// mdp, String adresse,Localite uneLocalite, String telephone, String
				// dateEntree, int prime, String codeUnite, String nomUnite )
				uneLocalite = LocaliteDao.rechercher(reqSelection.getString(7));
				unVisiteur = new Visiteur(reqSelection.getString(1), reqSelection.getString(2),
						reqSelection.getString(3), reqSelection.getString(4), reqSelection.getString(5),
						reqSelection.getString(6), uneLocalite, reqSelection.getString(8), reqSelection.getString(9),
						reqSelection.getInt(10), reqSelection.getString(11), reqSelection.getString(12), reqSelection.getString(13),reqSelection.getString(14));
			}
			;
		} catch (Exception e) {
			System.out.println("erreur reqSelection.next() pour la requête - select * from VISITEUR where MATRICULE ='"
					+ matriculeVisiteur + "'");
			e.printStackTrace();
		}
		ConnexionMySql.fermerConnexionBd();
		return unVisiteur;
	}
	
	public static int creer(Visiteur unVisiteur){
		String requeteInsertion;
		int result = 0;
		String mat= unVisiteur.getMatricule();
		String nom = unVisiteur.getNom();
		String prenom = unVisiteur.getPrenom();
		String login =  unVisiteur.getLogin();
		String mdp =  unVisiteur.getMdp();
		String adresse =  unVisiteur.getAdresse();
		String cp = unVisiteur.getUneLocalite().getCodePostal();
		String tel = unVisiteur.getTelephone();
		String dateEntree = unVisiteur.getDateEntree();
		int prime = unVisiteur.getPrime();
		String codeUnite = unVisiteur.getCodeUnite();
		String nomUnite = unVisiteur.getNomUnite();
		String specialite = unVisiteur.getSpecialite();	

		requeteInsertion = "insert into VISITEUR values('"+mat+"','"+nom+"','"+prenom+"','"+login+"','"+mdp+"','"+adresse+"','"+cp+"','"+tel+"','"+dateEntree+"','"+prime+"','"+codeUnite+"','"+nomUnite+"','"+specialite+"',null)";
		try{
			result = ConnexionMySql.execReqMaj(requeteInsertion);
		}
		catch (Exception e){
			System.out.println("echec insertion : "+requeteInsertion);
		}
		ConnexionMySql.fermerConnexionBd();	
		return result;
	}
	
	public static int supprimer(String unMatricule) {
		String requeteSuppression;
		int result = 0;
		requeteSuppression = "DELETE FROM VISITEUR WHERE MATRICULE='"+unMatricule+"'";
		try{
			result = ConnexionMySql.execReqMaj(requeteSuppression);
		}
		catch (Exception e){
			System.out.println("echec insertion : "+requeteSuppression);
		}
		ConnexionMySql.fermerConnexionBd();	
		return result;
		
	}
	
	public static ArrayList<Visiteur> retournerCollectionDesVisiteur(){
			ArrayList<Visiteur>lesVisiteurs = new ArrayList<Visiteur>();
			ResultSet reqSelection = ConnexionMySql.execReqSelection("select MATRICULE from VISITEUR ORDER BY matricule");
			try{
			while (reqSelection.next()) {
				String matricule = reqSelection.getString(1);
			    lesVisiteurs.add(VisiteurDao.rechercher(matricule));
				}
			}
			catch (Exception e) {
				e.printStackTrace();
				System.out.println("erreur retournerCollectionDesClients()");
			}
			return lesVisiteurs;
		}
	
	
	
	/**	Procédure stockée	**/
	
	public static void assigner_visiteurResp_visiteur(String matriculeVisiteurResp, String matriculeVisiteur) {
		String connectionUrl =
                "jdbc:sqlserver://127.0.0.1:1433;"
                        + "database=gsbv2;"
                        + "user=ADMIN_DB;"
                        + "password=password;"
                        + "encrypt=false;"
                        + "trustServerCertificate=false;"
                        + "loginTimeout=30;";
	 
	 String matVisiteurResp=matriculeVisiteurResp;
        String matVisiteur=matriculeVisiteur;
        ResultSet resultSet= null;
	
	try(Connection connection= DriverManager.getConnection(connectionUrl);
 		Statement statement= connection.createStatement();) 
 {
 	String selectSql= "assigner_visiteurResp_visiteur'"+matVisiteurResp+ "','"+matVisiteur+ "'";
 	resultSet = statement.executeQuery(selectSql);
 	while(resultSet.next()) {
 		System.out.println(resultSet.getString(2) + " "+ resultSet.getString(3));
 		}
 	}
 catch(SQLException e) {
 	e.printStackTrace();
 	}
		
	}

		
}


