package log121.lab3.tests;

import static org.junit.Assert.*;

import java.util.Comparator;

import log121.lab3.api.Ensemble;
import log121.lab3.api.Ensembles;
import log121.lab3.api.Liste;

import org.junit.Before;
import org.junit.Test;

public class EnsemblesTest {
	
	private final class ReverseIntegerComparator implements Comparator<Integer> {
		@Override
		public int compare(Integer o1, Integer o2) {
			return Integer.compare(o2, o1);
		}
	}

	// Ensemble qui contient un seul élément 
	Ensemble<Integer> sList;
	
	// Ensemble qui contient plusieurs éléments
	Ensemble<Integer> bList;
	
	@Before
	public void createEnsemblesTests()
	{
		bList = new Liste<Integer>();
		bList.ajouterFin(3);
		bList.ajouterFin(3);
		bList.ajouterFin(2);
		bList.ajouterFin(2);
		bList.ajouterFin(1);
		bList.ajouterFin(1);
		bList.ajouterFin(0);
		
		sList = new Liste<Integer>();
		sList.ajouterFin(1);
	}

	@Test
	public void quicksortSmallListTest() {
		Ensemble<Integer> list = Ensembles.quicksort(sList);
		assertEquals(1, list.taille());
		assertEquals(1, (int)list.trouver(0));
	}
	
	@Test
	public void quicksortBigListTest(){
		Ensemble<Integer> list = Ensembles.quicksort(bList);
		assertEquals(7, list.taille());
		assertEquals(0, (int)list.trouver(0));
		assertEquals(1, (int)list.trouver(1));
		assertEquals(1, (int)list.trouver(2));
		assertEquals(2, (int)list.trouver(3));
		assertEquals(2, (int)list.trouver(4));
		assertEquals(3, (int)list.trouver(5));
		assertEquals(3, (int)list.trouver(6));
	}
	
	@Test
	public void quicksortSmallListComparatorTest() {
		Ensemble<Integer> list = Ensembles.quicksort(sList, new ReverseIntegerComparator());
		assertEquals(1, list.taille());
		assertEquals(1, (int)list.trouver(0));
	}
	
	@Test
	public void quicksortBigListComparatorTest() {
		Ensemble<Integer> list = Ensembles.quicksort(bList, new ReverseIntegerComparator());
		assertEquals(7, list.taille());
		assertEquals(3, (int)list.trouver(0));
		assertEquals(3, (int)list.trouver(1));
		assertEquals(2, (int)list.trouver(2));
		assertEquals(2, (int)list.trouver(3));
		assertEquals(1, (int)list.trouver(4));
		assertEquals(1, (int)list.trouver(5));
		assertEquals(0, (int)list.trouver(6));
	}
	
	@Test
	public void reverseComparatorTest()
	{
		Comparator<Integer> reverseComp = new ReverseIntegerComparator();
		Comparator<Integer> comp = Ensembles.ordreInverse(reverseComp);
		
		assertTrue(comp.compare(1, 2) < 0);
		assertTrue(comp.compare(2, 1) > 0);
		assertTrue(comp.compare(1, 1) == 0);
		
		assertTrue(reverseComp.compare(1, 2) > 0);
		assertTrue(reverseComp.compare(2, 1) < 0);
		assertTrue(reverseComp.compare(1, 1) == 0);
		
		
	}
	
	
}
