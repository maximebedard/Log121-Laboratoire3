package log121.lab3.tests;

import static org.junit.Assert.*;
import log121.lab3.api.Joueur;

import org.junit.Before;
import org.junit.Test;

public class JoueurTest {

	Joueur p1;
	Joueur p2;

	@Before
	public void createPlayerTest() {
		p1 = new Joueur("Maxime");
		p2 = new Joueur("Daniel");
	}

	@Test(expected = IllegalArgumentException.class)
	public void createrPlayerNull() {
		new Joueur(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void createrPlayerEmpty() {
		new Joueur("");
	}

	@Test
	public void superiorTest() {
		p1.setScore(5);
		p2.setScore(4);
		assertTrue(p1.compareTo(p2) > 0);
	}

	@Test
	public void inferiorTest() {
		p1.setScore(4);
		p2.setScore(5);
		assertTrue(p1.compareTo(p2) < 0);
	}

	@Test
	public void sameTest() {
		p1.setScore(4);
		assertTrue(p1.compareTo(p1) == 0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void nullTest() {
		p1.setScore(4);
		p1.compareTo(null);
	}

}
