package log121.lab3.api;

public class CollectionJoueurs extends Liste<Joueur> {


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
	public ListeIterateur<Joueur> creerIterateur(){
		return (ListeIterateur<Joueur>)this.iterator();
	}
	
	
}
