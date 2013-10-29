package log121.lab3.api;

public abstract class FabriquePartie{
	
	public abstract CollectionJoueur creerJoueurs();	
	public abstract CollectionDes creerDes();
	
	public final Partie creerJeu(){
		creerJoueurs();
		creerDes();
		return null;
	}

}
