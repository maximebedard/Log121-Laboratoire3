package log121.lab3.tests;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

import log121.lab3.api.Ensemble;
import log121.lab3.api.Liste;
import log121.lab3.api.Predicate;

import org.junit.Before;
import org.junit.Test;

public class ListeTest {

	private Liste<Integer> list;
	
	
	@Before
	public void createLinkedListTest(){
		list = new Liste<Integer>();
	}


	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void ajouterArrayOutOfBoundOverTest() {
		list.ajouter(1, 0);
	}

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void ajouterArrayOutOfBoundUnderTest() {
		list.ajouter(-1, 0);
	}

	@Test
	public void ajouterBeginningTest() {
		list.ajouter(0, 1);
		list.ajouter(0, 2);
		list.ajouter(0, 3);

		assertEquals(3, list.taille());

		assertEquals(3, (int) list.trouver(0));
		assertEquals(2, (int) list.trouver(1));
		assertEquals(1, (int) list.trouver(2));
	}

	@Test
	public void ajouterEndTest() {
		list.ajouter(list.taille(), 1);
		list.ajouter(list.taille(), 2);
		list.ajouter(list.taille(), 3);

		assertEquals(3, list.taille());

		assertEquals(1, (int) list.trouver(0));
		assertEquals(2, (int) list.trouver(1));
		assertEquals(3, (int) list.trouver(2));
	}

	@Test
	public void ajouterMiddleTest() {
		list.ajouter(0, 9);
		list.ajouter(0, 9);
		list.ajouter(1, 1);

		assertEquals(3, list.taille());

		assertEquals(9, (int) list.trouver(0));
		assertEquals(1, (int) list.trouver(1));
		assertEquals(9, (int) list.trouver(2));
	}

	@Test(expected = IllegalArgumentException.class)
	public void ajouterNullTest() {
		list.ajouter(0, null);
	}

	@Test
	public void ajouterDebutMultipleTest() {
		list.ajouterDebut(1);
		list.ajouterDebut(2);
		list.ajouterDebut(3);

		assertEquals(3, list.taille());

		assertEquals(3, (int) list.trouver(0));
		assertEquals(2, (int) list.trouver(1));
		assertEquals(1, (int) list.trouver(2));
	}

	@Test(expected = IllegalArgumentException.class)
	public void ajouterDebutNullTest() {
		list.ajouterDebut(null);
	}

	@Test
	public void ajouterDebutTest() {
		list.ajouterDebut(1);

		assertEquals(1, list.taille());
		assertEquals(1, (int) list.trouver(0));
	}

	@Test
	public void ajouterFinMultipleTest() {
		remplirListe();

		assertEquals(3, list.taille());

		assertEquals(1, (int) list.trouver(0));
		assertEquals(2, (int) list.trouver(1));
		assertEquals(3, (int) list.trouver(2));
	}

	@Test(expected = IllegalArgumentException.class)
	public void ajouterFinNullTest() {
		list.ajouterFin(null);
	}

	@Test
	public void ajouterFinTest() {
		list.ajouterFin(1);

		assertEquals(1, list.taille());
		assertEquals(1, (int) list.trouver(0));
	}

	@Test
	public void viderTest() {
		remplirListe();

		assertEquals(3, list.taille());

		list.vider();

		assertEquals(true, list.estVide());
	}

	private void remplirListe() {
		list.ajouterFin(1);
		list.ajouterFin(2);
		list.ajouterFin(3);
	}

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void trouveArrayOutOfBoundOverTest() {
		remplirListe();

		list.trouver(3);
	}

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void trouveArrayOutOfBoundUnderTest() {
		remplirListe();

		list.trouver(-1);
	}

	@Test
	public void trouveTest() {
		remplirListe();

		assertEquals(1, (int) list.trouver(0));
		assertEquals(2, (int) list.trouver(1));
		assertEquals(3, (int) list.trouver(2));
	}

	@Test
	public void estVideTest() {
		assertEquals(true, list.estVide());
	}

	@Test
	public void iteratorTest() {
		remplirListe();

		int i = 1;
		Iterator<Integer> it = list.iterator();
		while (it.hasNext()) {
			int j = it.next();
			assertEquals(i, j);
			i++;
		}
	}

	@Test
	public void fusionnerDebutTest() {
		list.ajouterFin(0);

		Liste<Integer> toMerge = new Liste<Integer>();
		toMerge.ajouterFin(1);
		toMerge.ajouterFin(2);

		list.fusionnerDebut(toMerge);

		assertEquals(3, list.taille());

		assertEquals(2, (int) list.trouver(0));
		assertEquals(1, (int) list.trouver(1));
		assertEquals(0, (int) list.trouver(2));
	}

	@Test
	public void fusionnerFinTest() {
		list.ajouterFin(0);

		Liste<Integer> toMerge = new Liste<Integer>();
		toMerge.ajouterFin(1);
		toMerge.ajouterFin(2);

		list.fusionnerFin(toMerge);

		assertEquals(3, list.taille());

		assertEquals(0, (int) list.trouver(0));
		assertEquals(1, (int) list.trouver(1));
		assertEquals(2, (int) list.trouver(2));
	}
	
	@Test(expected = NullPointerException.class)
	public void fusionnerFinNullTest() {
		list.fusionnerFin(null);
	}

	@Test(expected = NullPointerException.class)
	public void fusionnerDebutNullTest() {
		list.fusionnerDebut(null);
	}
	
	@Test(expected = NoSuchElementException.class)
	public void enleverEmptyTest() {
		list.enlever(0);
	}

	@Test(expected = NoSuchElementException.class)
	public void enleverDebutEmptyTest() {
		list.enleverDebut();
	}

	@Test(expected = NoSuchElementException.class)
	public void enleverFinEmptyTest() {
		list.enleverFin();
	}

	@Test
	public void reverseIteratorTest() {
		remplirListe();

		int i = 3;
		Iterator<Integer> it = list.reverseIterator();
		while (it.hasNext()) {
			int j = it.next();
			assertEquals(i, j);
			i--;
		}
	}

	@Test
	public void premierTest() {
		remplirListe();
		assertEquals(1, (int)list.premier());
	}

	@Test(expected = NoSuchElementException.class)
	public void premierEmptyTest() {
		list.premier();		
	}

	@Test
	public void dernierTest() {
		remplirListe();
		assertEquals(3, (int)list.dernier());
	}

	@Test(expected = NoSuchElementException.class)
	public void dernierEmptyTest() {
		list.dernier();
	}

	@Test
	public void matchesEmptyTest(){
		remplirListe();
		Ensemble<Integer> noMatches = list.matches(new Predicate<Integer>() {	
			@Override
			public boolean compare(Integer elem) {
				return Integer.compare(elem, 5) == 0;
			}
		});
		
		assertEquals(0, noMatches.taille());
		
		
		Ensemble<Integer> hasMatches = list.matches(new Predicate<Integer>() {
			@Override
			public boolean compare(Integer elem) {
				return Integer.compare(elem, 2) == 0;
			}
		});
		
		assertEquals(1, hasMatches.taille());
		assertEquals(2, (int)hasMatches.premier());
	}
	
}
