package log121.lab3.api;

import java.util.Iterator;

public class CollectionJoueur extends Liste<Joueur> {

	
	private void ajouterJoueur(Joueur p)
	{
		this.ajouterFin(p);
	}
	
	private Iterator<Joueur> creerIterateur(){
		return this.iterator();
	}
	
	
}
