package presentation;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import abstraction.modules.AnalyseDesRisques;
import abstraction.modules.EvenementsRedoutes;

public class FenetreAnalyseDesRisques extends JPanel{
	private ModeleAnalyseDesRisques modele=new ModeleAnalyseDesRisques();
	private JTable tableau;
	private AnalyseDesRisques analyse;
		
	
	public FenetreAnalyseDesRisques(AnalyseDesRisques analyse){
		
		
		 super(new GridLayout(1,0));
			this.analyse=analyse;
			
			this.tableau=new JTable(modele);
			tableau.setPreferredScrollableViewportSize(new Dimension(500, 70));
	        tableau.setFillsViewportHeight(true);
			
	        JScrollPane scrollPane = new JScrollPane(tableau);
			this.tableau.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			
			add(scrollPane);
			
			
			
			this.setVisible(true);
		
		
		
		this.tableau=new JTable(modele);
		
		this.setVisible(true);
		
	}
	
	
}
