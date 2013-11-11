package log121.lab3.tests;

import static org.junit.Assert.*;
import log121.lab3.api.FabriquePartie;
import log121.lab3.api.Jeu;
import log121.lab3.bunco.Bunco;

import org.junit.Before;
import org.junit.Test;

public class BuncoTest {
	
	private FabriquePartie partie;
	private Jeu jeu;
	
	@Before
	public void testInitialiserPartie(){
		partie = new Bunco();
		jeu = partie.creerJeu();
	}
	
	@Test
	public void testContenueBunco(){
		assertNotNull(partie);
	}

	@Test
	public void testCreerJoueurs() {
		assertNotNull(partie.creerJoueurs());
	}
	
	@Test
	public void testCreerDes() {
		assertNotNull(partie.creerDes());
	}
	
	@Test
	public void testCreerJeu() {		
		assertNotNull(jeu);
	}
	
	@Test
	public void testPartieListeDes(){
		assertNotNull(jeu.getListeDes());
	}
	
	@Test
	public void testJeuListeJoueurs(){
		assertNotNull(jeu.getListeJoueurs());
	}

}
