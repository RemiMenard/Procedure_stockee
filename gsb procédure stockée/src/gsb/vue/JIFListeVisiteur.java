package gsb.vue;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import gsb.modele.Medecin;
import gsb.modele.Visiteur;
import gsb.modele.dao.MedecinDao;
import gsb.modele.dao.VisiteurDao;

public class JIFListeVisiteur extends JInternalFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	private ArrayList<Visiteur> lesVisiteurs;

	protected JPanel p;

	protected JScrollPane scrollPane;

	protected JPanel pSaisie;

	protected JTextField JTcodeVisiteur;

	protected JButton JBafficherFiche;

	protected MenuPrincipal fenetreContainer;

	public JIFListeVisiteur(MenuPrincipal uneFenetreContainer) {
		
		
		fenetreContainer = uneFenetreContainer;
	
		// récupération des données Medecin dans la collection
	
		lesVisiteurs = VisiteurDao.retournerCollectionDesVisiteur();
	
		int nbLignes = lesVisiteurs.size();
	
		JTable table;
	
		p = new JPanel(); // panneau principal de la fenêtre
	
		int i=0;
	
		String[][] data = new String[nbLignes][3] ;
	
		for(Visiteur unVisiteur : lesVisiteurs){
	
			data[i][0] = unVisiteur.getMatricule();
			data[i][1] = unVisiteur.getNom();
			data[i][2] = unVisiteur.getPrenom();
			i++;
	
		}
	
		String[] columnNames = {"Matricule", "Nom","Prenom"};
	
		table = new JTable(data, columnNames);
			
		scrollPane = new JScrollPane(table);
	
		scrollPane.setPreferredSize(new Dimension(400, 200));
	
		p.add(scrollPane);
	
		pSaisie = new JPanel();
	
		JTcodeVisiteur = new JTextField(20);
	
		JTcodeVisiteur.setMaximumSize(JTcodeVisiteur.getPreferredSize());
	
		JBafficherFiche = new JButton("Afficher Fiche visiteur");
	
		JBafficherFiche.addActionListener(this);
	
		pSaisie.add(JTcodeVisiteur);
	
		pSaisie.add(JBafficherFiche);
	
		p.add(pSaisie);
	
		
		 
		
		// mise en forme de la fenêtre
	
		Container contentPane = getContentPane();
	
		contentPane.add(p);
		setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object source = arg0.getSource();
   		if (source == JBafficherFiche){
   			Visiteur unVisiteur = VisiteurDao.rechercher(JTcodeVisiteur.getText());
   			if (unVisiteur!=null){
   	   			fenetreContainer.ouvrirFenetre(new JIFVisiteurFiche(unVisiteur));
   			}
   		}	
	}
}

		    
		    