package log121.lab3.api;

public abstract class FabriquePartie{
		
	public Jeu construire()
	{
		Jeu jeu = creerJeu();
		jeu.setListeDes(creerDes());
		jeu.setListeJoueurs(creerJoueurs());
		return jeu;
	}
	
		
	public abstract CollectionJoueur creerJoueurs();	
	public abstract CollectionDes creerDes();
	public abstract Jeu creerJeu();

}
