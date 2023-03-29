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
import java.util.Locale;
import java.util.Vector;
import java.util.logging.FileHandler;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import gsb.modele.Medecin;
import gsb.modele.Stocker;
import gsb.modele.Visiteur;
import gsb.modele.dao.MedecinDao;
import gsb.modele.dao.StockerDao;
import gsb.modele.dao.VisiteurDao;

public class JIFListeStock extends JInternalFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	private static final String unVisiteur = null;

	protected ArrayList<Visiteur> lesVisiteurs;
	
	protected ArrayList<Stocker> lesStocks;

	protected JPanel p;
	
	protected JButton BoutonActualiser;

	protected JScrollPane scrollPane;

	protected JPanel pSaisie;
	
	protected JTable table;

	protected JTextField JTcodeVisiteur;

	protected MenuPrincipal fenetreContainer;

	public JIFListeStock(MenuPrincipal uneFenetreContainer) {
		
		
		fenetreContainer = uneFenetreContainer;
	
		
		p = new JPanel(); // panneau principal de la fenêtre
		
		String matricule=null;
		JComboBox<String> liste = new JComboBox();
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
		DefaultTableModel model = new DefaultTableModel(data, columnNames);
		 table= new JTable(model);
		 scrollPane = new JScrollPane(table);
		 scrollPane.setPreferredSize(new Dimension(400, 200));
		
		 p.add(scrollPane);

		 
		 liste.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int k=0;
				int currFormLine = 0;
				int nbLignes = lesStocks.size();
				lesStocks=StockerDao.retournerCollectionDesStock();
				String[][] updateData = new String[nbLignes][3] ;
				
				
				for(Stocker unStock2 : lesStocks){
					
					if(lesStocks.get(k).getUnVisiteur().getMatricule().equals(liste.getItemAt(liste.getSelectedIndex()))) {

	                    updateData[currFormLine][0] = Integer.toString(unStock2.getQteStock());
	                    updateData[currFormLine][1] = unStock2.getUnMedicament().getMED_DEPOTLEGAL();
	                    updateData[currFormLine][2] = unStock2.getUnVisiteur().getMatricule();
	                    currFormLine++;
	                }

	                k++;
				}
				DefaultTableModel updateModel = new DefaultTableModel(updateData, columnNames);
				 table.setModel(updateModel);
				
			}
		});

		 contentPane.add(p);
		 setVisible(true);
		 
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
		
	 

	


	
	}



		    
		    