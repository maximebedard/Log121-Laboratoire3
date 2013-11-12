package log121.lab3.tests;

import static org.junit.Assert.*;
import log121.lab3.api.CollectionDes;
import log121.lab3.api.CollectionJoueurs;
import log121.lab3.api.CreateurJeu;
import log121.lab3.api.De;
import log121.lab3.api.Jeu;
import log121.lab3.api.Joueur;
import log121.lab3.bunco.CreateurJeuBunco;
import log121.lab3.bunco.StrategieBunco;

import org.junit.Before;
import org.junit.Test;

public class CreateurJeuTest {

	CreateurJeuBunco bunco;
	@Before
	public void testInitialiserPartie(){
		bunco = new CreateurJeuBunco();
	}
	
	@Test
	public void testCreerJoueurs(){
		CollectionJoueurs joueurs = bunco.creerJoueurs();
		assertEquals(5, joueurs.taille());
		assertEquals("Maxime", joueurs.trouver(0).getName());
		assertEquals("Daniel", joueurs.trouver(1).getName());
		assertEquals("Guy", joueurs.trouver(2).getName());
		assertEquals("Henry", joueurs.trouver(3).getName());
		assertEquals("Bob", joueurs.trouver(4).getName());
	}
	
	@Test
	public void testCreerDes() {
		CollectionDes des = bunco.creerDes();
		assertEquals(3, des.taille());
	}
	
	@Test(expected = NullPointerException.class)
	public void testCreerJeuJoueursNull() {
		CreateurJeu builder = new CreateurJeu(){
			@Override
			public CollectionJoueurs creerJoueurs() {
				return null;
			}

			@Override
			public CollectionDes creerDes() {
				CollectionDes des = new CollectionDes();
				des.ajouterFin(new De());
				return des;
			}};
		
		new Jeu(6, new StrategieBunco(), builder);
	}
	
	@Test(expected = NullPointerException.class)
	public void testCreerJeuDesNull() {
		CreateurJeu builder = new CreateurJeu(){
			@Override
			public CollectionJoueurs creerJoueurs() {
				CollectionJoueurs joueurs = new CollectionJoueurs();
				joueurs.ajouterFin(new Joueur("Maxime"));
				return joueurs;
			}

			@Override
			public CollectionDes creerDes() {
				return null;
			}};
		
		new Jeu(6, new StrategieBunco(), builder);
	}
	
	public void testCreerJeuJoueursVide() {
		CreateurJeu builder = new CreateurJeu(){
			@Override
			public CollectionJoueurs creerJoueurs() {
				CollectionJoueurs joueurs = new CollectionJoueurs();
				return joueurs;
			}

			@Override
			public CollectionDes creerDes() {
				CollectionDes des = new CollectionDes();
				des.ajouterFin(new De());
				return des;	
			}};
		
		new Jeu(6, new StrategieBunco(), builder);
	}
	
	public void testCreerJeuDesVide() {
		CreateurJeu builder = new CreateurJeu(){
			@Override
			public CollectionJoueurs creerJoueurs() {
				CollectionJoueurs joueurs = new CollectionJoueurs();
				joueurs.ajouterFin(new Joueur("Maxime"));
				return joueurs;
			}
			
			@Override
			public CollectionDes creerDes() {
				CollectionDes des = new CollectionDes();
				des.ajouterFin(new De());
				return des;	
			}};
			
		
		new Jeu(6, new StrategieBunco(), builder);
	}
}