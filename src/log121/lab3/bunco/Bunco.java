package log121.lab3.bunco;

import log121.lab3.api.CollectionDes;
import log121.lab3.api.CollectionJoueur;
import log121.lab3.api.De;
import log121.lab3.api.FabriquePartie;
import log121.lab3.api.Jeu;
import log121.lab3.api.Joueur;

public class Bunco extends FabriquePartie{

	@Override
	public CollectionJoueur creerJoueurs() {
		CollectionJoueur listeJoueurs = new CollectionJoueur();
		listeJoueurs.ajouter(0, new Joueur("Maxime"));
		listeJoueurs.ajouter(1, new Joueur("Daniel"));
		listeJoueurs.ajouter(2, new Joueur("Guy"));
		return listeJoueurs;
	}

	@Override
	public CollectionDes creerDes() {
		CollectionDes listeDes = new CollectionDes();
		listeDes.ajouter(0, new De(6));
		listeDes.ajouter(1, new De(6));
		listeDes.ajouter(2, new De(6));
		return listeDes;
	}

	@Override
	public Jeu creerJeu() {
		return new Jeu(2, new StrategieBunco());
	}



}
