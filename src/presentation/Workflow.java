package presentation;



import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import abstraction.Etude;
import abstraction.modules.Module;

/**
 * 
 * @author Maxime Ansquer
 *
 */
public class Workflow extends JPanel {

	
	private Etude etude;
	private Hashtable<String, JButton> lesBoutons;
	private MainMaximeAnsquer fenetre;

	public Workflow(Etude etude, MainMaximeAnsquer fenetrePrincipale) {
		this.etude = etude;
		this.fenetre = fenetrePrincipale;
		this.lesBoutons = new Hashtable<String, JButton>();		
		
		for(final Module m : etude.getLesModules().values()){
			
			System.out.println("Traitement du module " + m + "...");

			JButton bouton = new JButton(m.toString());
			if(!m.estDisponible()){
				bouton.setEnabled(false);
			}
			else{
				if(m.estCree()){
					if(!m.estCoherent()){
						bouton.setBackground(Color.RED);
					}
					else{
						bouton.setBackground(Color.GREEN);
					}
				}				
			}

			lesBoutons.put(m.getNom(), bouton);			
			final String nomModule = m.getNom();

			bouton.addActionListener(new ActionListener(){

				public void actionPerformed(ActionEvent e) {
					fenetre.setContenu(nomModule);
					m.setCree(true);
				}				

			});
		}

		this.setLayout(new GridLayout(8,8));

		//1ere ligne
		this.add(new JLabel());
		this.add(new JLabel());
		this.add(new JLabel());
		this.add(new JLabel());
		this.add(lesBoutons.get("EvenementsRedoutes"));
		this.add(new JLabel());
		this.add(new JLabel());
		this.add(new JLabel());

		//2eme ligne
		this.add(new JLabel());
		this.add(new JLabel());
		this.add(lesBoutons.get("BiensEssentiels"));
		this.add(new JLabel());
		this.add(new JLabel());
		this.add(new JLabel());
		this.add(new JLabel());
		this.add(new JLabel());

		//3eme ligne
		this.add(new JLabel());
		this.add(new JLabel());
		this.add(new JLabel());
		this.add(lesBoutons.get("MappingDesBiens"));
		this.add(new JLabel());
		this.add(lesBoutons.get("AnalyseDesRisques"));
		this.add(new JLabel());
		this.add(lesBoutons.get("MatriceDesRisques"));

		//4eme ligne
		this.add(new JLabel());
		this.add(new JLabel());
		this.add(lesBoutons.get("BiensSupports"));
		this.add(new JLabel());
		this.add(new JLabel());
		this.add(new JLabel());
		this.add(new JLabel());
		this.add(new JLabel());

		//5eme ligne
		this.add(lesBoutons.get("TypologieDesBiensSupports"));
		this.add(new JLabel());
		this.add(new JLabel());
		this.add(new JLabel());
		this.add(new JLabel());
		this.add(new JLabel());
		this.add(new JLabel());
		this.add(new JLabel());

		//6eme ligne
		this.add(new JLabel());
		this.add(lesBoutons.get("ScenariosDeMenacesGeneriques"));		
		this.add(new JLabel());
		this.add(new JLabel());
		this.add(new JLabel());
		this.add(new JLabel());
		this.add(new JLabel());
		this.add(new JLabel());

		//7eme ligne
		this.add(lesBoutons.get("SourcesDeMenaces"));
		this.add(new JLabel());
		this.add(new JLabel());
		this.add(lesBoutons.get("ScenariosDeMenacesTypes"));
		this.add(new JLabel());
		this.add(new JLabel());
		this.add(new JLabel());
		this.add(new JLabel());

		//8eme ligne
		this.add(lesBoutons.get("CriteresDeSecurite"));
		this.add(new JLabel());
		this.add(lesBoutons.get("Metriques"));
		this.add(new JLabel());
		this.add(new JLabel());
		this.add(new JLabel());
		this.add(new JLabel());
		this.add(new JLabel());
	}

	private JButton moduleManquant() {
		JButton moduleManquant = new JButton("Module manquant"); //TODO: a enlever pour le rendu final
		moduleManquant.setEnabled(false); //TODO: a enlever pour le rendu final
		return moduleManquant;
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(new ImageIcon("images/workflow.jpg").getImage(), 0, 0, this.getWidth(), this.getHeight(), null);
	}


}
