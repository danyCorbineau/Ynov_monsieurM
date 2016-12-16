package p;

//Nicolas Durand

import java.util.*;
import java.io.*;


	// A partir d'un fichier .txt, la classe carte r�cup�re les informations et les classes en fonction de leur type dans les classes Lieu et Porte
public class Carte {
	
	private String nom;
    private List<Lieu> listLieux= new ArrayList<>();

    
    // Ce constructeur permet de charger un fichier carte.txt et d'en r�cup�rer les informations.
	public Carte(String nomFichier) throws FileNotFoundException {

			DataInputStream dis = new DataInputStream(new FileInputStream(new File(nomFichier)));
			String fulltext="";
			
			String temp;
			try {
				while(( temp=dis.readLine())!=null)
				{
					fulltext+=temp+"\n";
				}
			} catch (IOException e1) {
			}
			
			
			String[] strLieu=fulltext.split(">");
			
			for(String s: strLieu)
			{
				
				String[] strParam=s.split("\\\\");
				if (strParam.length>1) {
				listLieux.add(new Lieu(strParam[0].split("\"")[1],strParam[1]));
				
				
				String[] strPorte=strParam[2].split("\n");
				
				listLieux.get(listLieux.size()-1).chargerPorte(strPorte);
			}
			}
			
			
			try {
				dis.close();
			} catch (IOException e) {
				System.err.println("\n/!\\Erreur � la fermeture de la carte /!\\\n");
				e.printStackTrace();
			}

			
		
	}

// ajouter une m�thode static dans carte pour connaitre les porte d'un lieu en rentrant un lieu	
// Convertir String nom de lieu en lieu
	

	// Cette m�thode permet de v�rifier si la carte � bien �t� charg�. Elle permet �galement de visualiser la carte.
    public void describe() {
		for (int i = 0; i < listLieux.size(); i++){
			listLieux.get(i).seDecrire();
		}
	
		
	}
    public boolean isTotalVisite() {
		return getTotalVisite();
	}

	public boolean getTotalVisite() {
		for(Lieu lieu : listLieux) {
			if (!lieu.isVisite()) {
				Main.println("\n--> Il reste a visiter "+lieu.getNom()+".");
				return false;
			}
		}
		Main.print("--> Vous avez tout visit�.");
		return true;
	}

	// Permet de r�cuperer le premier lieu d'une carte (la premi�re salle, le point de d�part du niveau...)
    public Lieu getPremierLieux() 
    {
		return listLieux.get(0);
	}

	// Permet de connaitre le nombre de lieux que poss�de une carte.
    public int getSize()
    {
    	return this.listLieux.size();
    }
    
    public Lieu getLieuByName(String name)
    {
    	for(Lieu l: this.listLieux)
    	{
    		if(l.getNom().compareTo(name)==0)
    			return l;
    	}
    	return null;
    }
    
    public void debloquerPorte(int clePorte)
    {
    	for(Lieu l: this.listLieux)
    	{
    		l.debloquerPorte(clePorte);
    	}
    	
    }
    

}