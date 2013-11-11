package log121.lab3.bunco;

import java.util.Iterator;

import log121.lab3.api.CollectionDes;
import log121.lab3.api.CollectionJoueur;
import log121.lab3.api.De;
import log121.lab3.api.Ensembles;
import log121.lab3.api.IStrategie;
import log121.lab3.api.Jeu;
import log121.lab3.api.Joueur;

public class StrategieBunco implements IStrategie{
	
	private final int NBRDESMAX = 3;
	private final int SCOREBANCO = 21;
	private final int SCORETROISDESIDENTIQUES = 5;
	private final int SCOREDESIDENTIQUES = 1;
	@Override
	public void calculerLeVainqueur(Jeu jeu) {
		CollectionJoueur collectionJoueur = jeu.getListeJoueurs();
		
		Ensembles.quicksort(collectionJoueur);
	}

	@Override
	public void calculerScoreTour(Jeu jeu) {
		int tourCourant = jeu.getTourCourant();
		Iterator<Joueur> iteratorJoueur = jeu.getIterator();
		CollectionDes collectionDes = jeu.getListeDes();
		int nbrDesIdentiques = 0;
		int nbrDesIdentiquesAuTour = 0;
		int score = 0;
		int valeurDe = 0;
		int valeurDePrecedent = 0;
		boolean changerTour = false;
		
		for (De de: collectionDes) {
			valeurDe = de.getValue();
			if (valeurDe == tourCourant) {
				nbrDesIdentiquesAuTour++;
			}
			if (valeurDePrecedent != 0 && valeurDe == valeurDePrecedent) {
				nbrDesIdentiques++;
			}
			valeurDePrecedent = valeurDe;
			
		}
		if (nbrDesIdentiquesAuTour == NBRDESMAX) {
			score = SCOREBANCO;
			changerTour = true;
		}
		else if (nbrDesIdentiquesAuTour < NBRDESMAX && nbrDesIdentiquesAuTour != 0)
			score = nbrDesIdentiquesAuTour*SCOREDESIDENTIQUES;
		else if (nbrDesIdentiques == NBRDESMAX)
			score = SCORETROISDESIDENTIQUES;
		else
			changerTour = true;

		
		//Partie a modifier, car il faut verifier ou est rendu l'iterateur
		//et non quel jour possede la main (hasHand)
		/*while (iteratorJoueur.hasNext()) {
			Joueur joueur = iteratorJoueur.next();
			if (joueur.hasHand()) {
				joueur.increaseScore(score);
				if (changerTour) {
					joueur.setHasHand(false);
					iteratorJoueur.next().setHasHand(true);
				}
			}
		}	*/
	}
	
	@Override
	public boolean partieTerminee(Jeu jeu) {
		return jeu.getNombreTours() == jeu.getTourCourant() && !jeu.getIterator().hasNext();
	}

}
