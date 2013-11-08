package log121.lab3.api;

import java.util.Iterator;

public class CollectionDes extends Liste<De> {
	
	/**
	 * Ajoute un nouveau dé à la liste
	 * @param p
	 */
	public void ajouterJoueur(De p)
	{
		this.ajouterFin(p);
	}
	
	/**
	 * Retourne un itérateur pour la liste
	 * @return
	 */
	public Iterator<De> creerIterateur(){
		return this.iterator();
	}
	
}
