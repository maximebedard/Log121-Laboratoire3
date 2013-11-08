package log121.lab3.api;

import java.util.Iterator;

public class CollectionJoueur extends Liste<Joueur> {


	/**
	 * Ajoute un nouveau joueur à la liste
	 * @param p
	 */
	public void ajouterJoueur(Joueur p)
	{
		this.ajouterFin(p);
	}
	

	/**
	 * Retourne un itérateur pour la liste
	 * @return
	 */
	public Iterator<Joueur> creerIterateur(){
		return this.iterator();
	}
	
	
}
