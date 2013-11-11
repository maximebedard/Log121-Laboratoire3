package log121.lab3.tests;

import static org.junit.Assert.*;
import log121.lab3.api.CollectionDes;
import log121.lab3.api.CollectionJoueur;
import log121.lab3.api.De;
import log121.lab3.api.IStrategie;
import log121.lab3.api.Jeu;
import log121.lab3.api.Joueur;
import log121.lab3.bunco.Bunco;
import log121.lab3.bunco.StrategieBunco;

import org.junit.Before;
import org.junit.Test;

public class GameTest {

	private Jeu jeu;
	private IStrategie strategie;
	private IStrategie strategieNull;
	
	@Before
	public void testInitialiserJeu(){
		strategie = new StrategieBunco();
		jeu = new Jeu(3, strategie, new Bunco());
	}
	
	@Test(expected = NullPointerException.class)
	public void testConstructorStrategie(){		
		new Jeu(2, strategieNull, new Bunco());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testConstructeurNbTours()
	{
		new Jeu(-1, strategie, new Bunco());		
	}
	
	@Test(expected = NullPointerException.class)
	public void testContructeurCreateurJeuNull()
	{
		new Jeu(2, strategie, null);
	}
	
	@Test
	public void testCreerJeu(){
		Jeu testJeu = new Jeu(3, strategie, new Bunco());
		assertNotNull(testJeu);
	}
	
	@Test
	public void testNombreTours(){
		assertTrue(jeu.getNombreTours() >= 1);
	}
	
	@Test(expected = NullPointerException.class)
	public void testSetListeJoueurVide(){
		CollectionJoueur collectionJoueur = null;
		jeu.setListeJoueurs(collectionJoueur);
	}
	
	@Test
	public void testSetListeJoueurPleine(){
		CollectionJoueur collectionJoueur = new CollectionJoueur();
		assertNotNull(collectionJoueur);
		collectionJoueur.ajouter(0, new Joueur("Maxime"));
		collectionJoueur.ajouter(1, new Joueur("Daniel"));
		jeu.setListeJoueurs(collectionJoueur);
		assertNotNull(jeu.getListeJoueurs());
	}
	
	@Test(expected = NullPointerException.class)
	public void testSetListeDesVide(){
		CollectionDes collectionDes = null;
		jeu.setListeDes(collectionDes);
	}
	
	@Test
	public void testSetListeDesPleine(){
		CollectionDes collectionDes = new CollectionDes();
		assertNotNull(collectionDes);
		collectionDes.ajouter(0, new De());
		collectionDes.ajouter(1, new De());
		jeu.setListeDes(collectionDes);
		assertNotNull(jeu.getListeDes());
	}
	
	@Test
	public void testGetIterator(){
		assertNotNull(jeu.getIterator());
	}

}
