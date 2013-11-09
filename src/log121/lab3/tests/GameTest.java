package log121.lab3.tests;

import static org.junit.Assert.*;
import log121.lab3.api.IStrategie;
import log121.lab3.api.Jeu;
import log121.lab3.bunco.StrategieBunco;

import org.junit.Before;
import org.junit.Test;

public class GameTest {

	private Jeu jeu;
	private IStrategie strategie;
	
	@Before
	public void testInitialiserVariable(){
		strategie = new StrategieBunco();
	}
	
	@Test
	public void testCreerJeu(){
		jeu = new Jeu(0, strategie);
		assertNotNull(jeu);
	}
	
	

}
