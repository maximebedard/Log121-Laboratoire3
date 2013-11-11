package log121.lab3.api;

public abstract class CreateurJeu{
		
	public final void creerJeu(Jeu jeu)
	{
		jeu.setListeJoueurs(creerJoueurs());
		jeu.setListeDes(creerDes());
	}
	
	/**
	 * 
	 * @return
	 */
	public abstract CollectionJoueur creerJoueurs();
	
	/**
	 * 
	 * @return
	 */
	public abstract CollectionDes creerDes();

}
