package log121.lab3.bunco;

import log121.lab3.api.CollectionDes;
import log121.lab3.api.CollectionJoueurs;
import log121.lab3.api.De;
import log121.lab3.api.Ensembles;
import log121.lab3.api.IStrategie;
import log121.lab3.api.Jeu;
import log121.lab3.api.Joueur;
import log121.lab3.api.ListeIterateur;

public class StrategieBunco implements IStrategie {

	private final static int SCOREBUNCO = 21;
	private final static int SCORETROISDESIDENTIQUES = 5;
	private final static int SCOREDESIDENTIQUES = 1;

	@Override
	public void calculerLeVainqueur(Jeu jeu) {
		jeu.setListeJoueurs((CollectionJoueurs) Ensembles.quicksort(jeu
				.getListeJoueurs()));
	}

	@Override
	public void calculerScoreTour(Jeu jeu) {
		int tourCourant = jeu.getTourCourant();
		ListeIterateur<Joueur> iter = jeu.getIterator();
		CollectionDes collectionDes = jeu.getListeDes();

		int nbrDesIdentiques = 0;
		int nbrDesIdentiquesAuTour = 0;
		int score = 0;
		boolean changerTour = false;

		for (De de : collectionDes) {
			if (de.getValue() == tourCourant)
				nbrDesIdentiquesAuTour++;

			if (de.getValue() == collectionDes.premier().getValue())
				nbrDesIdentiques++;
		}

		System.out.println("ID TOUR : " + nbrDesIdentiquesAuTour);
		System.out.println("ID : " + nbrDesIdentiques);

		if (nbrDesIdentiquesAuTour == collectionDes.taille()) {
			score = SCOREBUNCO;
			changerTour = true;
			System.out.println("BUNCO");
		} else if (nbrDesIdentiques == collectionDes.taille()) {
			score = SCORETROISDESIDENTIQUES;
			System.out.println("3 IDENTIQUES");
		} else if (nbrDesIdentiquesAuTour < collectionDes.taille()
				&& nbrDesIdentiquesAuTour > 0) {
			score = nbrDesIdentiquesAuTour * SCOREDESIDENTIQUES;
			System.out.println("<3 IDENTIQUES");
		} else {
			changerTour = true;
			System.out.println("FUCKALL");
		}

		iter.getCurrent().increaseScore(score);

		if (changerTour && iter.hasNext()) {
			iter.next();
		}

	}

}
