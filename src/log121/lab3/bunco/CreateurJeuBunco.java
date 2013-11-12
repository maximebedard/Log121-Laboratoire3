package log121.lab3.bunco;

import log121.lab3.api.CollectionDes;
import log121.lab3.api.CollectionJoueurs;
import log121.lab3.api.CreateurJeu;
import log121.lab3.api.De;
import log121.lab3.api.Joueur;

public class CreateurJeuBunco extends CreateurJeu{

	@Override
	public CollectionJoueurs creerJoueurs() {
		CollectionJoueurs listeJoueurs = new CollectionJoueurs();
		listeJoueurs.ajouterFin(new Joueur("Maxime"));
		listeJoueurs.ajouterFin(new Joueur("Daniel"));
		listeJoueurs.ajouterFin(new Joueur("Guy"));
		listeJoueurs.ajouterFin(new Joueur("Henry"));
		listeJoueurs.ajouterFin(new Joueur("Bob"));
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

}
