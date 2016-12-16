package p;

import java.util.List;

//Par Malo Dupont
//Classe pour les objets qui ouvrent des passages secrets, menant � d'autres salles, voire � la sortie 

public class ClePorteSecrete extends Objet {

    protected String newpieceName;
    protected String accessType;
    int cleId;
    
    //Constructeur pour definir un objet qui ouvre un passage secret
    public ClePorteSecrete(String itempiece, String name, String accessType,int id) {
    	this.itempiece = itempiece;
    	this.name = name;
    	this.accessType = accessType;
    	this.cleId=id;
    }
    
    
    //voir dans Objet
    public String getAction(){
    	return (name+", ouvre la porte "+accessType+"."+description+".");
    }

    
    /*M�thode pour cr�er un nouveau passage, non termin�, il faut faire le lien avec la partie de Nicolas
    *void addNewpiece(String newpieceName, String accessType) {
    *	new Porte(this.newpieceName, this.accessType);
    }
	*/


	@Override
	public String utliserObjet(Personnage p, Carte c,List<Objet> listObj) {
		listObj.remove(this);
		c.debloquerPorte(this.cleId);
		System.out.println("Porte avec cl�e"+ cleId +"d�bloqu�.");
		return null;
	}

}