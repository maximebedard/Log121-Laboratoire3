package log121.lab3.api;

public class Jeu {
	
	private final int DEBUT_TOUR_COURANT = 1;
	
	private CollectionJoueurs listeJoueurs = new CollectionJoueurs();
	private CollectionDes listeDes = new CollectionDes();
	private int nombreTours;
	private int tourCourant = DEBUT_TOUR_COURANT;
	private ListeIterateur<Joueur> iteratorJoueur;
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
		builder.creerJeu(this);
		
		iteratorJoueur = listeJoueurs.creerIterateur();
	}	
	
	
	/**
	 * Retourne la liste des joueurs
	 * @return
	 */
	public CollectionJoueurs getListeJoueurs() {
		return listeJoueurs;
	}

	/**
	 * Assigne la liste des joueurs
	 * @param listeJoueurs
	 */
	public void setListeJoueurs(CollectionJoueurs listeJoueurs) {
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
	public ListeIterateur<Joueur> getIterator(){
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
	 * Assigne le tour courant
	 * @param tourCourant
	 */
	public void setTourCourant(int tourCourant){
		this.tourCourant = tourCourant;
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
