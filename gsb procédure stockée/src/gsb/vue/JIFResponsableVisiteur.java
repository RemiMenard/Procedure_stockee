package gsb.vue;



import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import gsb.modele.Medecin;
import gsb.modele.Medicament;
import gsb.modele.Stocker;
import gsb.modele.Visiteur;
import gsb.modele.dao.MedecinDao;
import gsb.modele.dao.MedicamentDao;
import gsb.modele.dao.StockerDao;
import gsb.modele.dao.VisiteurDao;
import utils.ValidationUtils;

public class JIFResponsableVisiteur extends JInternalFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	protected JPanel p;  
	protected JPanel pBoutons;
	protected JPanel pTexte;
	protected JButton JBValider;
	protected JScrollPane scrollPane;
	

	protected JLabel txtVisiteur;
	protected JLabel txtVisiteurResp;
	
	protected JTextField JTQteStock;
	protected JTextField JTMed_DepotLegal;
	protected JTextField JTMatricule;
	
	protected ArrayList<Visiteur> lesVisiteurs;
	protected ArrayList<Medecin> lesMedecins;

	
    public JIFResponsableVisiteur() {
    	p = new JPanel();
        pBoutons = new JPanel();    // panneau supportant les boutons
        pTexte = new JPanel(new GridLayout(13,2));
      
        String matricule=null;
        JComboBox<String> listeVisiteurResp = new JComboBox();
        JComboBox<String> listeVisiteur = new JComboBox();
        
        lesVisiteurs=VisiteurDao.retournerCollectionDesVisiteur();
        
        for (Visiteur unVisiteur : lesVisiteurs){
			matricule = unVisiteur.getMatricule();
			listeVisiteur.addItem(matricule);
		}
		
		for (Visiteur unVisiteur : lesVisiteurs){
			matricule = unVisiteur.getMatricule();
			listeVisiteurResp.addItem(matricule);
		}
        

         JBValider = new JButton("Valider");
         JBValider.addActionListener(this);
		
        // mise en forme de la fenêtre
         txtVisiteurResp = new JLabel("Choix visiteur responsable");
         txtVisiteur = new JLabel("Choix visiteur");
         
         pTexte.add(txtVisiteurResp);      
         pTexte.add(listeVisiteurResp);
         pTexte.add(txtVisiteur);   
         pTexte.add(listeVisiteur);
      
         p.add(pTexte);
        
         JBValider.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String uniteVisiteurResp = null;
				String uniteVisiteur = null;
				uniteVisiteurResp = String.valueOf(listeVisiteurResp.getSelectedItem());
				uniteVisiteur = String.valueOf(listeVisiteur.getSelectedItem());
				
				Visiteur visiteurResp = VisiteurDao.rechercher(uniteVisiteurResp);
				Visiteur visiteur = VisiteurDao.rechercher(uniteVisiteur);
				
				VisiteurDao.assigner_visiteurResp_visiteur(uniteVisiteurResp, uniteVisiteur);
				
				Visiteur visiteurResp2 = VisiteurDao.rechercher(uniteVisiteurResp);
				Visiteur visiteur2 = VisiteurDao.rechercher(uniteVisiteur);
				
				if(visiteur2.getResponsable_visiteur() == visiteurResp2.getMatricule()) {
					JOptionPane.showMessageDialog(p,"Le visiteur "+visiteurResp2.getMatricule()+" est maintenant responsable du visiteur "+visiteur2.getMatricule(),"Attention",JOptionPane.INFORMATION_MESSAGE);
				}
				else if(visiteur2.getResponsable_visiteur() == visiteurResp2.getMatricule()) {
					JOptionPane.showMessageDialog(p,"Le visiteur "+visiteurResp2.getMatricule()+" ne peut pas être responsable du visiteur "+visiteur2.getMatricule()+" car ils ne sont pas de la même unité","Attention",JOptionPane.INFORMATION_MESSAGE);

				}
			}
		});
         
         p.add(JBValider);
         Container contentPane = getContentPane();
         contentPane.add(p);
        
         

	}
    
    public void actionPerformed(ActionEvent arg0) {
    	
			
	   		}
    	
   
    
}


