package log121.lab3.api;

import java.util.Iterator;

public class Jeu {
	
	private final int DEBUT_TOUR_COURANT = 0;
	
	private CollectionJoueur listeJoueurs = new CollectionJoueur();
	private CollectionDes listeDes = new CollectionDes();
	private int nombreTours;
	private int tourCourant = DEBUT_TOUR_COURANT;
	private Iterator<Joueur> iteratorJoueur;
	private IStrategie strategie;
	
	/**
	 * Créé un nouveau jeu à partir du nombre de tour et de la stratégie adopté
	 * @param _nombreTours
	 * @param strategie
	 */
	public Jeu(int _nombreTours, IStrategie strategie, CreateurJeu builder){
		if(strategie == null)
			throw new NullPointerException("La strategie est null");
		if(_nombreTours < 1)
			throw new IllegalArgumentException("Nombre de tours inferieur a 1");
		if(builder == null)
			throw new NullPointerException("Le createur du jeu est null");
		
		this.nombreTours = _nombreTours;
		this.strategie = strategie;
		this.iteratorJoueur = listeJoueurs.creerIterateur();
		
		builder.creerJeu(this);
	}	
	
	
	/**
	 * Retourne la liste des joueurs
	 * @return
	 */
	public CollectionJoueur getListeJoueurs() {
		return listeJoueurs;
	}

	/**
	 * Assigne la liste des joueurs
	 * @param listeJoueurs
	 */
	public void setListeJoueurs(CollectionJoueur listeJoueurs) {
		if(listeJoueurs == null)
			throw new NullPointerException("Liste de joueurs est null");
		this.listeJoueurs = listeJoueurs;
	}

	/**
	 * Retourne la liste des dés 
	 * @return
	 */
	public CollectionDes getListeDes() {
		return listeDes;
	}

	/**
	 * Assigne la liste des dés
	 * @param listeDes
	 */
	public void setListeDes(CollectionDes listeDes) {
		if(listeDes == null)
			throw new NullPointerException("Liste de des est null");
		this.listeDes = listeDes;
	}

	/**
	 * Retourne l'itérateur des joueurs
	 * @return
	 */
	public Iterator<Joueur> getIterator(){
		return this.iteratorJoueur;
	}
	
	/**
	 * Retourne le nombre de tour d'une partie
	 * @return
	 */
	public int getNombreTours(){
		return this.nombreTours;
	}
	
	/**
	 * Retourne le tour courant
	 * @return
	 */
	public int getTourCourant(){
		return this.tourCourant;
	}
	
	/**
	 * Calcul le score pour une partie
	 */
	public void calculerScoreTour(){
		strategie.calculerScoreTour(this);
	}
	
	/**
	 * Joue le tour actuel
	 */
	public void jouerTour(){		
		while(iteratorJoueur.hasNext()){
			calculerScoreTour();
		}
		
		iteratorJoueur = listeJoueurs.creerIterateur();
		tourCourant+=1;
	}
	
	/**
	 * Joue la partie au complet
	 */
	public void jouerPartie(){
		for(int i = 0; i < this.nombreTours; i++){
			jouerTour();
		}
		calculerLeVainqueur();
	}
	
	/**
	 * Calcule le score du vainceur
	 */
	public void calculerLeVainqueur(){
		strategie.calculerLeVainqueur(this);
	}

}
