package log121.lab3.tests;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import log121.lab3.api.Liste;
import log121.lab3.api.ListeIterateur;

import org.junit.Before;
import org.junit.Test;

public class ListeIterateurTest {

	ListeIterateur<Integer> iter;

	@Before
	public void testListeIterateurTest() {
		Liste<Integer> liste = new Liste<Integer>();
		liste.ajouterFin(1);
		liste.ajouterFin(2);
		liste.ajouterFin(3);
		iter = (ListeIterateur<Integer>) liste.iterator();
	}

	@Test
	public void testListeIterateur() {
		new ListeIterateur<Integer>(null, false);
	}

	@Test
	public void testHasNext() {
		assertTrue(iter.hasNext());
		iter.next();
		assertTrue(iter.hasNext());
		iter.next();
		assertTrue(iter.hasNext());
		iter.next();
		assertFalse(iter.hasNext());
	}

	@Test
	public void testNext() {
		assertEquals(1, (int) iter.next());
		assertEquals(2, (int) iter.next());
		assertEquals(3, (int) iter.next());
	}

	@Test(expected = NoSuchElementException.class)
	public void testNextEmpty() {
		ListeIterateur<Integer> it = new ListeIterateur<Integer>(null, false);
		it.next();
	}

	@Test(expected = IllegalArgumentException.class)
	public void testRemove() {
		iter.remove();
	}

}
