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
import gsb.modele.dao.ConnexionMySql;
import gsb.modele.dao.MedecinDao;
import gsb.modele.dao.MedicamentDao;
import gsb.modele.dao.StockerDao;
import gsb.modele.dao.VisiteurDao;
import utils.ValidationUtils;

public class JIFResponsableMedecin extends JInternalFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	protected JPanel p;  
	protected JPanel pBoutons;
	protected JPanel pTexte;
	protected JButton JBValider;
	protected JScrollPane scrollPane;
	
	protected JLabel txtVisiteur;
	protected JLabel txtMedecin;
	
	protected JTextField JTQteStock;
	protected JTextField JTMed_DepotLegal;
	protected JTextField JTMatricule;
	
	protected ArrayList<Visiteur> lesVisiteurs;
	protected ArrayList<Medecin> lesMedecins;

	
    public JIFResponsableMedecin() {
    	p = new JPanel();
        pBoutons = new JPanel();    // panneau supportant les boutons
        pTexte = new JPanel(new GridLayout(13,2));
      
        String matricule=null;
        JComboBox<String> listeMedecin = new JComboBox();
        JComboBox<String> listeVisiteur = new JComboBox();
        
        lesVisiteurs=VisiteurDao.retournerCollectionDesVisiteur();
        lesMedecins=MedecinDao.retournerCollectionDesMedecins();
        
		for (Visiteur unVisiteur : lesVisiteurs){
			matricule = unVisiteur.getMatricule();
			listeVisiteur.addItem(matricule);
		}
		
		for (Medecin unMedecin : lesMedecins){
			matricule = unMedecin.getCodeMed();
			listeMedecin.addItem(matricule);
		}

         JBValider = new JButton("Valider");
         JBValider.addActionListener(this);
		
        // mise en forme de la fenêtre
         txtMedecin = new JLabel("Choix visiteur");
         txtVisiteur = new JLabel("Choix médecin");
         
         pTexte.add(txtMedecin);      
         pTexte.add(listeVisiteur);
         pTexte.add(txtVisiteur);   
         pTexte.add(listeMedecin);
      
         p.add(pTexte);
         
        
         JBValider.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String matriculeVisiteur = null;
				String matriculeMedecin = null;
				matriculeVisiteur = String.valueOf(listeVisiteur.getSelectedItem());
				matriculeMedecin = String.valueOf(listeMedecin.getSelectedItem());
				Visiteur unVisiteur=VisiteurDao.rechercher(matriculeVisiteur);
				Medecin unMedecin=MedecinDao.rechercher(matriculeMedecin);
				
				MedecinDao.verifier_unite_responsable(unVisiteur.getMatricule(), unMedecin.getCodeMed());
				
				Visiteur unVisiteur2=VisiteurDao.rechercher(matriculeVisiteur);
				Medecin unMedecin2=MedecinDao.rechercher(matriculeMedecin);
				
				System.out.println(unVisiteur2.getMatricule()+""+unMedecin2.getResponsable());
				
				
				if(unMedecin2.getResponsable() == unVisiteur2.getMatricule()) {
					JOptionPane.showMessageDialog(p,"Le visiteur "+unVisiteur.getMatricule()+" est maintenant responsable du médecin "+unMedecin.getCodeMed(),"Information",JOptionPane.INFORMATION_MESSAGE);
				}
				else if(unMedecin2.getResponsable() != unVisiteur2.getMatricule()) {
					JOptionPane.showMessageDialog(p,"Le visiteur "+unVisiteur.getMatricule()+" ne peut pas être responsable du médecin "+unMedecin.getCodeMed()+" car ils n'ont pas la même spécialité","Information",JOptionPane.INFORMATION_MESSAGE);

				}
			}
		});
        
         p.add(JBValider);
         Container contentPane = getContentPane();
         contentPane.add(p);
        
         

	}
    
 /**   String matriculeVisiteur = null;
	String matriculeMedecin = null;
	matriculeVisiteur = String.valueOf(listeVisiteur.getSelectedItem());
	matriculeMedecin = String.valueOf(listeMedecin.getSelectedItem());
	Visiteur unVisiteur=VisiteurDao.rechercher(matriculeVisiteur);
	Medecin unMedecin=MedecinDao.rechercher(matriculeMedecin);
	System.out.println(unVisiteur.getSpecialite() +" "+ unMedecin.getSpecialite());

		if(unVisiteur.getSpecialite() == unMedecin.getSpecialite()) {
			System.out.println("meme spe");
		}
		else if(unVisiteur.getSpecialite() != unMedecin.getSpecialite()) {
			System.out.println("pas meme spe");
			}**/


    public void actionPerformed(ActionEvent arg0) {
    	
			
	   		}
    	
   
    
}


