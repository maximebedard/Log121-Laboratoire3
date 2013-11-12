package log121.lab3.api;

import java.util.NoSuchElementException;

public abstract class CreateurJeu{
		
	public final void creerJeu(Jeu jeu)
	{
		
		CollectionJoueurs joueurs = creerJoueurs();
		if(joueurs == null)
			throw new NullPointerException();
		
		if(joueurs.taille() == 0)
			throw new NoSuchElementException();
		
		CollectionDes des = creerDes();
		if(des == null)
			throw new NullPointerException();
		
		if(des.taille() == 0)
			throw new NoSuchElementException();
		
		jeu.setListeJoueurs(joueurs);
		jeu.setListeDes(des);
	}
	
	/**
	 * 
	 * @return
	 */
	public abstract CollectionJoueurs creerJoueurs();
	
	/**
	 * 
	 * @return
	 */
	public abstract CollectionDes creerDes();

}
