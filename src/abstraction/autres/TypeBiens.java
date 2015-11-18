package abstraction.autres;

/**
 * Classe representant les types de biens supports représentés en mémoire par : 
 * id, description, intitule et retenu
 * Cette classe est utile pour le module "Typologie des biens supports"
 * Elle représente plus généralement une ligne du tableau généré dans "Typologie des biens supports"
 * 
 * @author Belghiti Ali
 */

public class TypeBiens {
	
	// Variables d'instances
	// Il faudra rajouter la couleur
	private String Id ;
	private String Description;
	private String intitule;
	private boolean retenu; 
	private String couleur; 
	// Ex couleur : "red", "yellow", etc...
	
	// IHM : quand retenu=true (cad quand on clique sur la case du tableau correspondante)
	//on a un X qui s'affiche dans cette case. Dans l'autre cas, le X disparait (case vide)
	
	// Constructeur
	public TypeBiens(String id, String description, String intitule, boolean retenu){
		this.Id=id;
		this.Description = description;
		this.intitule = intitule;
		this.retenu = retenu;
	}
	
	// Constructeur : Ligne vide
	public TypeBiens(){
		this("","","",false);
	}
	
	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		this.Description = description;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public boolean isRetenu() {
		return retenu;
	}

	public void setRetenu(boolean retenu) {
		this.retenu = retenu;
	}
	
	// On vérifie si le type a bien toutes les informations renseignées
	// Tous les champs doivent être renseignés
	public boolean isIncomplete() {
		return (this.Id == null && this.Description == null
				&& this.intitule == null);
	}
}
