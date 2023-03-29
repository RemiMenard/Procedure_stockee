/*
 * Créé le 22 févr. 2015
 *
 * TODO Pour changer le modèle de ce fichier généré, allez à :
 * Fenêtre - Préférences - Java - Style de code - Modèles de code
 */
package gsb.vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 * @author Isabelle 22 févr. 2015 TODO Pour changer le modèle de ce commentaire
 *         de type généré, allez à : Fenêtre - Préférences - Java - Style de
 *         code - Modèles de code
 */
public class MenuPrincipal extends JFrame implements ActionListener {

	/**
	 * Commentaire pour <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = 2591453837113855452L;

	protected JInternalFrame myJInternalFrame;
	protected JDesktopPane desktopPane;
	protected JMenuBar mbar;
	protected JMenu mMedecins;
	protected JMenu mMedicaments;
	protected JMenu mVisiteurs;
	protected JMenu mStock;
	protected JPanel p;

	JMenu mVisites;

	/**
	 * 
	 */
	public MenuPrincipal() {

		myJInternalFrame = new JInternalFrame(); // pour affichage d'une seule
													// JInternalFrame à la fois
		desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.gray);
		JPanel contentPane = (JPanel) this.getContentPane();
		contentPane.add(desktopPane, BorderLayout.CENTER);

		setTitle("GSB");
		setSize(600, 500);

		// Ajout d'une barre de menus à la fenêtre
		mbar = new JMenuBar();
		mMedecins = new JMenu("Medecins");
		JMenuItem mC1 = new JMenuItem("Consultation Medecin");
		mC1.addActionListener(this); // installation d'un écouteur d'action
		mMedecins.add(mC1);
		JMenuItem mC2 = new JMenuItem("Liste Medecins");
		mC2.addActionListener(this);
		mMedecins.add(mC2);
		JMenuItem mC3 = new JMenuItem("Associer un responsable au médecin");
		mC3.addActionListener(this);
		mMedecins.add(mC3);

		mMedicaments = new JMenu("Medicaments");
		JMenuItem mE1 = new JMenuItem("Consultation Medicament");
		mE1.addActionListener(this); // installation d'un écouteur d'action
		mMedicaments.add(mE1);
		JMenuItem mE2 = new JMenuItem("Ajout Medicaments");
		mE2.addActionListener(this);
		mMedicaments.add(mE2);

		mVisites = new JMenu("Visites");
		JMenuItem mA1 = new JMenuItem("Consultation Visite");
		mE1.addActionListener(this); // installation d'un écouteur d'action
		mVisites.add(mA1);
		JMenuItem mA2 = new JMenuItem("Ajout Visite");
		mA2.addActionListener(this);
		mVisites.add(mA2);
		
		mVisiteurs = new JMenu("Visiteur");
		JMenuItem mB1 = new JMenuItem("Liste Visiteurs");
		mB1.addActionListener(this); // installation d'un écouteur d'action
		mVisiteurs.add(mB1);
		JMenuItem mB2 = new JMenuItem("Ajout Visiteur");
		mB2.addActionListener(this);
		mVisiteurs.add(mB2);
		JMenuItem mB3 = new JMenuItem("Associer un responsable au visiteur");
		mB3.addActionListener(this);
		mVisiteurs.add(mB3);

		mStock = new JMenu("Stock");
		JMenuItem mS1 = new JMenuItem("Stock échantillons Visiteurs");
		mS1.addActionListener(this); // installation d'un écouteur d'action
		mStock.add(mS1);
		JMenuItem mS2 = new JMenuItem("Ajout échantillons Visiteur");
		mS2.addActionListener(this);
		mStock.add(mS2);

		mbar.add(mMedecins);
		mbar.add(mMedicaments);
		mbar.add(mVisites);
		mbar.add(mVisiteurs);
		mbar.add(mStock);
		setJMenuBar(mbar);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		// TODO Raccord de méthode auto-généré
		if (evt.getSource() instanceof JMenuItem) {
			String ChoixOption = evt.getActionCommand();

			if (ChoixOption.equals("Consultation Medecin")) {
				// Creation d'une sous-fenêtre
				ouvrirFenetre(new JIFMedecinCons());
			} 
			
			else if (ChoixOption.equals("Liste Medecins")) 
			{
				ouvrirFenetre(new JIFMedecinListeDic(this));
			}
			
			else if (ChoixOption.equals("Liste Visiteurs")) 
			{
				ouvrirFenetre(new JIFListeVisiteur(this));
			}
			else if (ChoixOption.equals("Ajout Visiteur")) 
			{
				ouvrirFenetre(new JIFAjoutVisiteur());
			}
			else if (ChoixOption.equals("Stock échantillons Visiteurs")) 
			{
				ouvrirFenetre(new JIFListeStock(this));
			}
			else if (ChoixOption.equals("Ajout échantillons Visiteur")) 
			{
				ouvrirFenetre(new JIFAjoutEchantillon());
			}
			else if (ChoixOption.equals("Associer un responsable au médecin")) 
			{
				ouvrirFenetre(new JIFResponsableMedecin());
			}
			else if (ChoixOption.equals("Associer un responsable au visiteur")) 
			{
				ouvrirFenetre(new JIFResponsableVisiteur());
			}
		}

	}


	public void ouvrirFenetre(JInternalFrame uneFenetre) {
		myJInternalFrame.dispose(); // si une fenêtre était dejà affichée, elle
									// est libérée
		myJInternalFrame = uneFenetre;
		myJInternalFrame.setVisible(true);
		myJInternalFrame.setResizable(true);
		myJInternalFrame.setMaximizable(true);
		myJInternalFrame.setClosable(true);
		myJInternalFrame.setSize(480, 380);
		desktopPane.add(myJInternalFrame);
	}

}
