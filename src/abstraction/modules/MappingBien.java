package abstraction.modules;
import java.util.LinkedList;

import abstraction.autres.*;

/**
 * Cette classe permet d'associer un bien essentiel et les biens
 * supports entre eux
 * 
 * @author Francois Adam
 */

public class MappingBien {
	//Variables d'instance
	private LinkedList<String> mappingBien; // table qui relie un bien essentiel aux biens supports
	private LinkedList<String> bienAssocies; // table qui relie les biens supports aux case du mapping
	private BiensSupports biensSupports;
	private Bien bienEssentiel;
	
	//Constructeur
	public MappingBien(BiensSupports biensSupports, Bien bienEssentiel){
		this.mappingBien = new LinkedList<String>();
		this.bienAssocies = new LinkedList<String>();
		this.biensSupports = biensSupports;
		this.bienEssentiel = bienEssentiel;
		for (int i=0; i<this.biensSupports.nombreDeBiens(); i++){
			if (this.biensSupports.getBien(i).isRetenu()){
				this.mappingBien.add("");
				this.bienAssocies.add(this.biensSupports.getBien(i).getIntitule());
			}
		}
	}
	
	//Getters et Setters
	public BiensSupports getBiensSupports(){
		return biensSupports;
	}
	
	public void setBiensSupports(BiensSupports biensSupports){
		this.biensSupports = biensSupports;
	}
	
	public Bien getBienEssentiel(){
		return bienEssentiel;
	}
	
	public void setBienEssentiel(Bien bienEssentiel){
		this.bienEssentiel=bienEssentiel;
	}
	
	public LinkedList<String> getMappingBien(){
		return this.mappingBien;
	}
	
	public String getCase(String bienEssentiel, String bienSupport){
		String caseMapping = "";
		if (bienEssentiel.equals(this.getBienEssentiel().getIntitule())){
			for (int i=0; i<this.getMappingBien().size(); i++){
				if (this.getBienAssocies().get(i).equals(bienSupport)){
					caseMapping = this.getMappingBien().get(i);
				}
			}
		}
		return caseMapping;
	}
	
	public String getValueAt(int index){
		return mappingBien.get(index);
	}
	
	public void setValueAt(String value, int index){
		if (value.equals("") || value.equals("X") || value.equals("O")){
			mappingBien.set(index, value);
		}
	}
	
	public void setValueAt(String bienSupport, String value){
		for (int i=0; i<this.getMappingBien().size(); i++){
			if (this.getBienAssocies().get(i).equals(bienSupport)){
				this.setValueAt(value, i);
			}
		}
	}
	
	public void setMappingBien(LinkedList<String> mappingBien){
		this.mappingBien=mappingBien;
	}
	
	public boolean estComplet(){
		int nombreCasesVides = 0;
		int index = 0;
		while (nombreCasesVides<this.getMappingBien().size() && index<this.getMappingBien().size()){
			if (this.getMappingBien().get(index).equals("")){
				nombreCasesVides++;
			}
			index++;
		}
		return nombreCasesVides<this.getMappingBien().size();
	}
	
	public String toString(){
		return "{Mapping Bien : intitulé = "+this.getBienEssentiel().getIntitule()+"}";
	}

	public LinkedList<String> getBienAssocies() {
		return bienAssocies;
	}

	public void setBienAssocies(LinkedList<String> bienAssocies) {
		this.bienAssocies = bienAssocies;
	}
}
