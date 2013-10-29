package log121.lab3.api;

import java.util.Iterator;

public class CollectionJoueur extends Liste<Joueur> {

	
	public void ajouterJoueur(Joueur p)
	{
		this.ajouterFin(p);
	}
	
	public Iterator<Joueur> creerIterateur(){
		return this.iterator();
	}
	
	
}
