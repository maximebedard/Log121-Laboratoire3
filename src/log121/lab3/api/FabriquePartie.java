package log121.lab3.api;

public abstract class FabriquePartie{
		
	public Jeu construire()
	{
		Jeu jeu = creerJeu();
		jeu.setListeDes(creerDes());
		jeu.setListeJoueurs(creerJoueurs());
		return jeu;
	}
	
		
	protected abstract CollectionJoueur creerJoueurs();	
	protected abstract CollectionDes creerDes();
	protected abstract Jeu creerJeu();

}
