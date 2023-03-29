package gsb.vue;


import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import gsb.modele.Localite;
import gsb.modele.Visiteur;
import gsb.modele.dao.LocaliteDao;
import gsb.modele.dao.VisiteurDao;
import utils.ValidationUtils;

public class JIFAjoutVisiteur extends JInternalFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	protected JPanel p;  
	protected JPanel pTexte;
	protected JPanel pBoutons;
	protected JButton JBAjouter;
	

	protected JLabel JLmatricule;
	protected JLabel JLnom;
	protected JLabel JLprenom;
	protected JLabel JLlogin;
	protected JLabel JLmdp;
	protected JLabel JLadresse;
	protected JLabel JLcp;
	protected JLabel JLville;
    protected JLabel JLtelephone;
    protected JLabel JLdateEntree;
    protected JLabel JLprime;
    protected JLabel JLcodeUnite;
    protected JLabel JLnomUnite;
    protected JLabel JLspecialite;
    
    
	protected JTextField JTmatricule;
	protected JTextField JTnom;
	protected JTextField JTprenom;
	protected JTextField JTlogin;
	protected JTextField JTmdp;
	protected JTextField JTadresse;
	protected JTextField JTcp;
	protected JTextField JTville;
    protected JTextField JTtelephone;
    protected JTextField JTdateEntree;
    protected JTextField JTprime;
    protected JTextField JTcodeUnite;
    protected JTextField JTnomUnite;
    protected JTextField JTspecialite;
	
    public JIFAjoutVisiteur() {
    	p = new JPanel();  // panneau principal de la fenêtre
        pBoutons = new JPanel();    // panneau supportant les boutons
        pTexte = new JPanel(new GridLayout(14,2));
    	
    	 JLmatricule = new JLabel("Matricule");
         JLnom = new JLabel("Nom");
         JLprenom = new JLabel("Prénom");
         JLlogin=new JLabel("Login");
     	 JLmdp=new JLabel("Mot de passe");
         JLadresse = new JLabel("Adresse rue");
         JLcp = new JLabel("Code postal");
         JLville = new JLabel("Ville");
         JLtelephone = new JLabel("Téléphone");
         JLdateEntree = new JLabel("Date Entree");
         JLprime= new JLabel("Prime");
         JLcodeUnite= new JLabel("Code Unite");
         JLnomUnite= new JLabel("Nom Unite");
         JLspecialite= new JLabel("Spécialité");
         
         
         JTmatricule = new JTextField(20);
         JTmatricule.setMaximumSize(JTmatricule.getPreferredSize());
         JTnom = new JTextField();
         JTprenom = new JTextField();
         JTlogin=new JTextField();
         JTmdp=new JPasswordField(8);
         JTmdp.setMinimumSize(JTmatricule.getMinimumSize());
         JTadresse = new JTextField();    
         JTcp = new JTextField();
         JTville = new JTextField();
         JTtelephone = new JTextField();
         JTdateEntree = new JTextField();
         JTprime= new JTextField();
         JTcodeUnite= new JTextField();
         JTnomUnite= new JTextField();
         JTspecialite= new JTextField();
         
         pTexte.add(JLmatricule);
         pTexte.add(JTmatricule);
         pTexte.add(JLnom);
         pTexte.add(JTnom);
         pTexte.add(JLprenom);
         pTexte.add(JTprenom);
         pTexte.add(JLlogin);
         pTexte.add(JTlogin);
         pTexte.add(JLmdp);
         pTexte.add(JTmdp);
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
         
        
         JBAjouter = new JButton("Ajouter le visiteur");
         JBAjouter.addActionListener(this);
		
        // mise en forme de la fenêtre

         p.add(pTexte);
         p.add(JBAjouter);
         Container contentPane = getContentPane();
         contentPane.add(p);

	}
    
    public void viderText() 	
    {  // méthode qui permet de vider les zones de texte 
    	 JTmatricule.setText("");
         JTnom.setText("");
         JTprenom.setText("");
         JTlogin.setText("");
         JTmdp.setText("");
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
    
   
    
    public void actionPerformed(ActionEvent arg0) {
		Object source = arg0.getSource();
   		if (source == JBAjouter) {
   			try {
   				if(JTmatricule.getText() == null ||  JTnom.getText() == null || JTprenom.getText()== null || JTlogin.getText()== null || JTmdp.getText()== null || JTadresse.getText() == null || JTcp== null || JTtelephone.getText()== null || JTdateEntree.getText()== null || JTprime== null || JTcodeUnite.getText()== null || JTnomUnite.getText()==null || JTspecialite.getText()==null){
   					throw new Exception("Saisie non conforme !");
   				}
   				else if(!ValidationUtils.isTelephoneValide(JTtelephone.getText())){
   					throw new Exception("Saisie non conforme !");
   				}
   				else if(!ValidationUtils.isCodePostalValide(JTcp.getText())){
   					throw new Exception("Saisie non conforme !");
   				}
   				else if(!ValidationUtils.isDateValide(JTdateEntree.getText())){
   					throw new Exception("Saisie non conforme !");
   				}
   				else if(!ValidationUtils.estUnEntier(JTprime.getText())){
   					throw new Exception("Saisie non conforme !");
   				}
	   			else {
		   			if(LocaliteDao.rechercher(JTcp.getText()) == null) {
		   				Localite uneLocalite = new Localite(JTcp.getText(), JTville.getText());
		   				int nb = LocaliteDao.creerLocalite(uneLocalite);
		   				int prime =  Integer.parseInt(JTprime.getText());	
		   				String specialite=JTspecialite.getText();
			   			Visiteur unVisiteur = new Visiteur (JTmatricule.getText(), JTnom.getText(), JTprenom.getText(), JTlogin.getText(), JTmdp.getText(), JTadresse.getText() , uneLocalite, JTtelephone.getText(), JTdateEntree.getText(), prime, JTcodeUnite.getText(), JTnomUnite.getText(), specialite,null);
			   			VisiteurDao.creer(unVisiteur);
			   			
		   			}
		   			else{
		   				Localite uneLocalite=LocaliteDao.rechercher(JTcp.getText());
		   				int prime =  Integer.parseInt(JTprime.getText());
		   				String specialite=JTspecialite.getText();
		   				System.out.println(specialite);
			   			Visiteur unVisiteur = new Visiteur (JTmatricule.getText(), JTnom.getText(), JTprenom.getText(), JTlogin.getText(), JTmdp.getText(), JTadresse.getText() , uneLocalite, JTtelephone.getText(), JTdateEntree.getText(), prime, JTcodeUnite.getText(), JTnomUnite.getText(), specialite,null);
			   			VisiteurDao.creer(unVisiteur);
			   			
		   			}
	   			}
	   		
   			}
   			catch(Exception e){
					JOptionPane.showMessageDialog(p,"Saisie non conforme !","Attention",JOptionPane.WARNING_MESSAGE); 
					}
   			}
   		viderText();
   		}
    
}

