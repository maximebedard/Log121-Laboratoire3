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
	
	public Jeu(int _nombreTours, IStrategie strategie){
		if(strategie == null)
			throw new NullPointerException("La strategie est null");
		if(_nombreTours < 1)
			throw new IllegalArgumentException("Nombre de tours inferieur a 1");
		
		this.nombreTours = _nombreTours;
		this.strategie = strategie;
		this.iteratorJoueur = listeJoueurs.creerIterateur();
	}	
	
	public CollectionJoueur getListeJoueurs() {
		return listeJoueurs;
	}

	public void setListeJoueurs(CollectionJoueur listeJoueurs) {
		if(listeJoueurs == null)
			throw new NullPointerException("Liste de joueurs est null");
		this.listeJoueurs = listeJoueurs;
	}

	public CollectionDes getListeDes() {
		return listeDes;
	}

	public void setListeDes(CollectionDes listeDes) {
		if(listeDes == null)
			throw new NullPointerException("Liste de des est null");
		this.listeDes = listeDes;
	}

	public Iterator<Joueur> getIterator(){
		return this.iteratorJoueur;
	}
	
	public int getNombreTours(){
		return this.nombreTours;
	}
	
	public int getTourCourant(){
		return this.tourCourant;
	}
	
	public void calculerScoreTour(){
		for(De de : listeDes){
			if(de != null){
				de.roll();
			}
		}
		strategie.calculerScoreTour(this);
	}
	
	public void jouerTour(){		
		while(iteratorJoueur.hasNext()){
			calculerScoreTour();
		}
		
		iteratorJoueur = listeJoueurs.creerIterateur();
		tourCourant+=1;
	}
	
	public void jouerPartie(){
		for(int i = 0; i < this.nombreTours; i++){
			jouerTour();
		}
		calculerLeVainqueur();
	}
	
	public void calculerLeVainqueur(){
		strategie.calculerLeVainqueur(this);
	}

}
