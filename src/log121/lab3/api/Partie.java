package log121.lab3.api;

import java.util.Iterator;

public class Partie {
	
	private final int DEBUT_TOUR_COURANT = 0;
	
	private CollectionJoueur listeJoueurs = new CollectionJoueur();
	private CollectionDes listeDes = new CollectionDes();
	private int nombreTours;
	private int tourCourant = DEBUT_TOUR_COURANT;
	private Iterator<Joueur> iteratorJoueur;
	private IStrategie strategie;
	
	public Partie(int _nombreTours, IStrategie strategie){
		this.nombreTours = _nombreTours;
		this.strategie = strategie;
	}	
	
	public CollectionJoueur getListeJoueurs() {
		return listeJoueurs;
	}

	public void setListeJoueurs(CollectionJoueur listeJoueurs) {
		this.listeJoueurs = listeJoueurs;
	}

	public CollectionDes getListeDes() {
		return listeDes;
	}

	public void setListeDes(CollectionDes listeDes) {
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
	
	
	public void roulerDes(){
		
	}
	
	public void calculerScoreTour(){

	}
	
	public void calculerLeVainqueur(){
		
	}

}
