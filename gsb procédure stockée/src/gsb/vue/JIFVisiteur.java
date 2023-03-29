package gsb.vue;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import gsb.modele.Visiteur;

public class JIFVisiteur extends JInternalFrame {
	private static final long serialVersionUID = 1L;
	protected JPanel p;  
	protected JPanel pTexte;
	protected JPanel pBoutons;
	

	protected JLabel JLmatricule;
	protected JLabel JLnom;
	protected JLabel JLprenom;
	protected JLabel JLadresse;
	protected JLabel JLcp;
    protected JLabel JLville;
    protected JLabel JLtelephone;
    protected JLabel JLdateEntree;
    protected JLabel JLprime;
    protected JLabel JLcodeUnite;
    protected JLabel JLnomUnite;
    protected JLabel JLspecialite;
    protected JLabel JLresponsable;
    
    
	protected JTextField JTmatricule;
	protected JTextField JTnom;
	protected JTextField JTprenom;
	protected JTextField JTadresse;
	protected JTextField JTcp;
    protected JTextField JTville;
    protected JTextField JTtelephone;
    protected JTextField JTdateEntree;
    protected JTextField JTprime;
    protected JTextField JTcodeUnite;
    protected JTextField JTnomUnite;
    protected JTextField JTspecialite;
    protected JTextField JTresponsable;
	
    public JIFVisiteur() {
    	p = new JPanel();  // panneau principal de la fenêtre
        pBoutons = new JPanel();    // panneau supportant les boutons
        pTexte = new JPanel(new GridLayout(13,2));
    	
    	 JLmatricule = new JLabel("Matricule");
         JLnom = new JLabel("Nom");
         JLprenom = new JLabel("Prénom");
         JLadresse = new JLabel("Adresse rue");
         JLcp = new JLabel("Code postal");
         JLville = new JLabel("Ville");
         JLtelephone = new JLabel("Téléphone");
         JLdateEntree = new JLabel("Date Entree");
         JLprime= new JLabel("Prime");
         JLcodeUnite= new JLabel("Code Unite");
         JLnomUnite= new JLabel("Nom Unite");
         JLspecialite= new JLabel("Spécialité");
         JLresponsable= new JLabel("Responsable");
         
         JTmatricule = new JTextField(20);
         JTmatricule.setMaximumSize(JTmatricule.getPreferredSize());
         JTnom = new JTextField();
         JTprenom = new JTextField();
         JTadresse = new JTextField();    
         JTcp = new JTextField();
         JTville = new JTextField();
         JTtelephone = new JTextField();
         JTdateEntree = new JTextField();
         JTprime= new JTextField();
         JTcodeUnite= new JTextField();
         JTnomUnite= new JTextField();
         JTspecialite= new JTextField();
         JTresponsable= new JTextField();
         
         pTexte.add(JLmatricule);
         pTexte.add(JTmatricule);
         pTexte.add(JLnom);
         pTexte.add(JTnom);
         pTexte.add(JLprenom);
         pTexte.add(JTprenom);
         pTexte.add(JLadresse);
         pTexte.add(JTadresse);
         pTexte.add(JLcp);
         pTexte.add(JTcp);
         pTexte.add(JLville);
         pTexte.add(JTville);
         pTexte.add(JLtelephone);
         pTexte.add(JTtelephone);
         pTexte.add(JLdateEntree);
         pTexte.add(JTdateEntree);
         pTexte.add(JLprime);
         pTexte.add(JTprime);
         pTexte.add(JLcodeUnite);
         pTexte.add(JTcodeUnite);
         pTexte.add(JLnomUnite);
         pTexte.add(JTnomUnite);
         pTexte.add(JLspecialite);
         pTexte.add(JTspecialite);
         pTexte.add(JLresponsable);
         pTexte.add(JTresponsable);
         
		
        // mise en forme de la fenêtre

         p.add(pTexte);
         p.add(pBoutons);
         Container contentPane = getContentPane();
         contentPane.add(p);

	}
    
    public void remplirText(Visiteur unVisiteur) 	
    {  // méthode qui permet de remplir les zones de texte à partir des valeurs passées en paramètres
        JTmatricule.setText(unVisiteur.getMatricule());        
        JTnom.setText(unVisiteur.getNom());
        JTprenom.setText(unVisiteur.getPrenom());
        JTadresse.setText(unVisiteur.getAdresse());    
        JTcp.setText(unVisiteur.getUneLocalite().getCodePostal());
        JTville.setText(unVisiteur.getUneLocalite().getVille());
        JTtelephone.setText(unVisiteur.getTelephone());
        JTdateEntree.setText(unVisiteur.getDateEntree());
        JTprime.setText(String.valueOf(unVisiteur.getPrime()));
        JTcodeUnite.setText(unVisiteur.getCodeUnite());
        JTnomUnite.setText(unVisiteur.getNomUnite());
        JTspecialite.setText(unVisiteur.getSpecialite());
        JTresponsable.setText(unVisiteur.getResponsable_visiteur());
     }
     
      public void viderText() 	
    {  // méthode qui permet de vider les zones de texte 
        JTmatricule.setText("");        
        JTnom.setText("");
        JTprenom.setText("");
        JTadresse.setText("");    
        JTcp.setText("");
        JTville.setText("");
        JTtelephone.setText("");
        JTdateEntree.setText("");
        JTprime.setText("");
        JTcodeUnite.setText("");
        JTnomUnite.setText("");
        JTspecialite.setText("");
     }
}
