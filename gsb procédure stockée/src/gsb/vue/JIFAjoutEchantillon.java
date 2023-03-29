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
import javax.swing.JTextField;

import gsb.modele.Medicament;
import gsb.modele.Stocker;
import gsb.modele.Visiteur;
import gsb.modele.dao.MedicamentDao;
import gsb.modele.dao.StockerDao;
import gsb.modele.dao.VisiteurDao;
import utils.ValidationUtils;

public class JIFAjoutEchantillon extends JInternalFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	protected JPanel p;  
	protected JPanel pTexte;
	protected JPanel pBoutons;
	protected JButton JBAjouter;
	

	protected JLabel JLQteStock;
	protected JLabel JLMed_DepotLegal;
	protected JLabel JLMatricule;
	
    
    
	protected JTextField JTQteStock;
	protected JTextField JTMed_DepotLegal;
	protected JTextField JTMatricule;

	
    public JIFAjoutEchantillon() {
    	p = new JPanel();  // panneau principal de la fenêtre
        pBoutons = new JPanel();    // panneau supportant les boutons
        pTexte = new JPanel(new GridLayout(3,2));
    	
    	 JLQteStock = new JLabel("Quantité ");
         JLMed_DepotLegal = new JLabel("Dépôt légal ");
         JLMatricule = new JLabel("Matricule ");
        
         
         
         JTQteStock = new JTextField();
         JTMed_DepotLegal = new JTextField();
         JTMatricule = new JTextField(20);
         JTMatricule.setMaximumSize(JTMatricule.getPreferredSize());
        
         
        
         pTexte.add(JLQteStock);
         pTexte.add(JTQteStock);
         pTexte.add(JLMed_DepotLegal);
         pTexte.add(JTMed_DepotLegal);
         pTexte.add(JLMatricule);
         pTexte.add(JTMatricule);
        
        
         JBAjouter = new JButton("Ajouter échantillon");
         JBAjouter.addActionListener(this);
		
        // mise en forme de la fenêtre

         p.add(pTexte);
         p.add(JBAjouter);
         Container contentPane = getContentPane();
         contentPane.add(p);
        
         

	}
    
    public void viderText() 	
    {  // méthode qui permet de vider les zones de texte 
    	JTQteStock.setText("");
        JTMed_DepotLegal.setText("");
        JTMatricule.setText("");
     }



    public void actionPerformed(ActionEvent arg0) {
    	
			Object source = arg0.getSource();
	   		if (source == JBAjouter) {
	   			try {
   					if(JTQteStock.getText() == null ||JTMatricule.getText() == null ||JTMed_DepotLegal.getText()== null ) {
   						throw new Exception("Saisie non conforme !");
   					}
   					else if(VisiteurDao.rechercher(JTMatricule.getText()) == null) {
   						throw new Exception("visiteur existe pas");
   					}
   					else if(MedicamentDao.rechercher(JTMed_DepotLegal.getText()) == null) {
   						throw new Exception("medicament existe pas ");
   					}
   					else if(!ValidationUtils.estUnEntier(JTQteStock.getText())){
   	   					throw new Exception("Saisie non conforme !");
   	   				}
   					else {
	   					Visiteur unVisiteur = VisiteurDao.rechercher(JTMatricule.getText());
	   		   			Medicament unMedicament = MedicamentDao.rechercher(JTMed_DepotLegal.getText());
	   		   			if(StockerDao.rechercher(unMedicament.getMED_DEPOTLEGAL(),unVisiteur.getMatricule()) == null) {
	   		   				Stocker unStock = new Stocker(Integer.valueOf(JTQteStock.getText()),unVisiteur,unMedicament);
	   		   				StockerDao.creer(unStock);
	   		   			}
	   		   			else{  				
	   		   				Stocker unStock = new Stocker(Integer.valueOf(JTQteStock.getText()),unVisiteur,unMedicament);
	   		   				Stocker stockExistant = StockerDao.rechercher(unMedicament.getMED_DEPOTLEGAL(),unVisiteur.getMatricule());
	   		   				int newQteStock=unStock.getQteStock()+stockExistant.getQteStock();
	   		   				Stocker newStock = new Stocker(newQteStock,unVisiteur,unMedicament);
	   		   				StockerDao.modifierStock(newStock);
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


