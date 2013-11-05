package log121.lab3.api;

public abstract class FabriquePartie{
	
	public abstract CollectionJoueur creerJoueurs();	
	public abstract CollectionDes creerDes();
	
	public final Jeu creerJeu(int nombreTours, IStrategie strategie){
		Jeu jeu = new Jeu(nombreTours, strategie);
		jeu.setListeJoueurs(creerJoueurs());
		jeu.setListeDes(creerDes());
		return null;
	}

}
