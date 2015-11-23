package abstraction.modules;
import java.util.Hashtable;
import abstraction.autres.*;

/**
 * Cette classe correspond � la mod�lisation de la base de donn�es pr�existante
 * de biens supports augment�e de nouveaux biens supports que l'on peut rajouter
 * 
 * @author Francois Adam
 */

public class BiensSupports extends Module{
	
	private static Hashtable<String,Bien> bdcBiensSupports ;
	
	// ---Variables d'instance

	private Hashtable<String, Bien> lesBiens;

	// ---Constructeurs---

	public BiensSupports() {
		super("Biens supports");
		this.importerBDC();
		this.lesBiens = new Hashtable<String, Bien>(); // useless ?
		this.successeurs.add(MappingDesBiens.getInstance());
		this.successeurs.add(ScenariosDeMenacesTypes.getInstance());
		this.predecesseurs.add(TypologieDesBiensSupports.getInstance());
		this.cree = false;
		this.coherent = false;
		this.disponible = false;
		this.lesBiens = BiensSupports.getBDC();
	}

	// ---Getters et setters---

	public Hashtable<String, Bien> getLesBiens() {
		return lesBiens;
	}

	public void setLesBiens(Hashtable<String, Bien> lesBiens) {
		this.lesBiens = lesBiens;
	}

	public Bien getBien(String nomBien) {
		return this.getLesBiens().get(nomBien);
	}
	
	public static Hashtable<String,Bien> getBDC(){
		return bdcBiensSupports;
	}


	// ---Services---

	public void ajouterBien(Bien bien) {
		this.getLesBiens().put(bien.getIntitule(), bien);
	}

	public void supprimerBien(String nomBien) {
		this.getLesBiens().remove(nomBien);
	}

	public Hashtable<String, Bien> getBiensRetenus() {
		Hashtable<String, Bien> resultat = new Hashtable<String, Bien>();
		for (Bien bien : this.getLesBiens().values()) {
			if (bien.isRetenu()) {
				resultat.put(bien.getIntitule(), bien);
			}
		}
		return resultat;
	}

	public void retenirBien(String intituleBien) {
		this.getBien(intituleBien).setRetenu(true);
	}

	public void retenirBien(Bien bien) {
		this.retenirBien(bien.getIntitule());
	}
	
	public void importerBDC(){
		//TODO importer la BDC via le fichier excel
	}
}
