package log121.lab3.tests;

import static org.junit.Assert.*;
import log121.lab3.api.ListeNoeud;

import org.junit.Before;
import org.junit.Test;

public class ListeNoeudTest {

	ListeNoeud<Integer> n1;
	ListeNoeud<Integer> n2;
	ListeNoeud<Integer> n3;
	
	@Before
	public void setUp() throws Exception {
		n1 = new ListeNoeud<Integer>(1);
		n2 = new ListeNoeud<Integer>(2);
		n3 = new ListeNoeud<Integer>(3);
		
		n1.setNext(n2);
		n2.setPrevious(n1);
		
		n2.setNext(n3);
		n3.setPrevious(n2);
	}

	@Test
	public void hasNextTest() {
		assertTrue(n1.hasNext());
		assertTrue(n2.hasNext());
		assertFalse(n3.hasNext());
	}
	
	public void hasPrevious()
	{
		assertFalse(n1.hasPrevious());
		assertTrue(n2.hasPrevious());
		assertTrue(n3.hasPrevious());
	}

}
