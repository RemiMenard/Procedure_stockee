package gsb.vue;

import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import gsb.modele.Stocker;
import gsb.modele.Visiteur;
import gsb.modele.dao.StockerDao;
import gsb.modele.dao.VisiteurDao;

public class afficherStockerParVisiteur extends JIFListeStock{

	public afficherStockerParVisiteur(MenuPrincipal uneFenetreContainer) {
		super(uneFenetreContainer);
		fenetreContainer = uneFenetreContainer;
		
		JTable table;
		p = new JPanel(); // panneau principal de la fenêtre
		
		String matricule=null;
		JComboBox<String> liste = new JComboBox();
		liste.addActionListener(this);
		lesVisiteurs=VisiteurDao.retournerCollectionDesVisiteur();
		for (Visiteur unVisiteur : lesVisiteurs){
			matricule = unVisiteur.getMatricule();
			liste.addItem(matricule);
		}
		
		liste.setBounds(10,10,200,50);
		p.add(liste);
		Container contentPane = getContentPane();
		String Choix=null;
		Choix = (String) liste.getSelectedItem();
		contentPane.add(p);
		
		
		
		lesStocks=StockerDao.retournerCollectionDesStockParVisiteur(Choix);
		int i=0;
		int nbLignes = lesStocks.size();
		String[][] data = new String[nbLignes][3] ;
		
		for(Stocker unStock : lesStocks){
			data[i][0] = String.valueOf(unStock.getQteStock());
			data[i][1] = unStock.getUnMedicament().getMED_DEPOTLEGAL();
			data[i][2] = unStock.getUnVisiteur().getMatricule();
			i++;
		}
	
		String[] columnNames = {"Quantité Stock", "Dépôt légal","Matricule"};
	
		 table= new JTable(data, columnNames);
		 scrollPane = new JScrollPane(table);
		 scrollPane.setPreferredSize(new Dimension(400, 200));
		
		 p.add(scrollPane);
		 
		// p.add(JBactualiser);
		 //JBactualiser = new JButton("Actualiser le contenu");
		 //JBactualiser.addActionListener(new ActionListener() {
			   // @Override
			   // public void actionPerformed(ActionEvent e) {
			    	//String Choix = (String) liste.getSelectedItem();
			    	//lesStocks=StockerDao.retournerCollectionDesStockParVisiteur(Choix);
			   // }
			//});
		 
		 setVisible(true);
		 
		 
	}

	

}
