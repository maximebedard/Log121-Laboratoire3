package log121.lab3.tests;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

import log121.lab3.api.Collection;
import log121.lab3.api.LinkedList;
import log121.lab3.api.Predicate;

import org.junit.Before;
import org.junit.Test;

public class LinkedListTest {

	private LinkedList<Integer> list;
	
	
	@Before
	public void createLinkedListTest(){
		list = new LinkedList<Integer>();
	}


	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void addAtArrayOutOfBoundOverTest() {
		list.addAt(1, 0);
	}

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void addAtArrayOutOfBoundUnderTest() {
		list.addAt(-1, 0);
	}

	@Test
	public void addAtBeginningTest() {
		list.addAt(0, 1);
		list.addAt(0, 2);
		list.addAt(0, 3);

		assertEquals(3, list.size());

		assertEquals(3, (int) list.findAt(0));
		assertEquals(2, (int) list.findAt(1));
		assertEquals(1, (int) list.findAt(2));
	}

	@Test
	public void addAtEndTest() {
		list.addAt(list.size(), 1);
		list.addAt(list.size(), 2);
		list.addAt(list.size(), 3);

		assertEquals(3, list.size());

		assertEquals(1, (int) list.findAt(0));
		assertEquals(2, (int) list.findAt(1));
		assertEquals(3, (int) list.findAt(2));
	}

	@Test
	public void addAtMiddleTest() {
		list.addAt(0, 9);
		list.addAt(0, 9);
		list.addAt(1, 1);

		assertEquals(3, list.size());

		assertEquals(9, (int) list.findAt(0));
		assertEquals(1, (int) list.findAt(1));
		assertEquals(9, (int) list.findAt(2));
	}

	@Test(expected = IllegalArgumentException.class)
	public void addAtNullTest() {
		list.addAt(0, null);
	}

	@Test
	public void addFirstMultipleTest() {
		list.addFirst(1);
		list.addFirst(2);
		list.addFirst(3);

		assertEquals(3, list.size());

		assertEquals(3, (int) list.findAt(0));
		assertEquals(2, (int) list.findAt(1));
		assertEquals(1, (int) list.findAt(2));
	}

	@Test(expected = IllegalArgumentException.class)
	public void addFirstNullTest() {
		list.addFirst(null);
	}

	@Test
	public void addFirstTest() {
		list.addFirst(1);

		assertEquals(1, list.size());
		assertEquals(1, (int) list.findAt(0));
	}

	@Test
	public void addLastMultipleTest() {
		fillList();

		assertEquals(3, list.size());

		assertEquals(1, (int) list.findAt(0));
		assertEquals(2, (int) list.findAt(1));
		assertEquals(3, (int) list.findAt(2));
	}

	@Test(expected = IllegalArgumentException.class)
	public void addLastNullTest() {
		list.addLast(null);
	}

	@Test
	public void addLastTest() {
		list.addLast(1);

		assertEquals(1, list.size());
		assertEquals(1, (int) list.findAt(0));
	}

	@Test
	public void clearTest() {
		fillList();

		assertEquals(3, list.size());

		list.clear();

		assertEquals(true, list.isEmpty());
	}

	private void fillList() {
		list.addLast(1);
		list.addLast(2);
		list.addLast(3);
	}

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void findArrayOutOfBoundOverTest() {
		fillList();

		list.findAt(3);
	}

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void findArrayOutOfBoundUnderTest() {
		fillList();

		list.findAt(-1);
	}

	@Test
	public void findTest() {
		fillList();

		assertEquals(1, (int) list.findAt(0));
		assertEquals(2, (int) list.findAt(1));
		assertEquals(3, (int) list.findAt(2));
	}

	@Test
	public void isEmptyTest() {
		assertEquals(true, list.isEmpty());
	}

	@Test
	public void iteratorTest() {
		fillList();

		int i = 1;
		Iterator<Integer> it = list.iterator();
		while (it.hasNext()) {
			int j = it.next();
			assertEquals(i, j);
			i++;
		}
	}

	@Test
	public void mergeFirstTest() {
		list.addLast(0);

		LinkedList<Integer> toMerge = new LinkedList<Integer>();
		toMerge.addLast(1);
		toMerge.addLast(2);

		list.mergeFirst(toMerge);

		assertEquals(3, list.size());

		assertEquals(2, (int) list.findAt(0));
		assertEquals(1, (int) list.findAt(1));
		assertEquals(0, (int) list.findAt(2));
	}

	@Test
	public void mergeLastTest() {
		list.addLast(0);

		LinkedList<Integer> toMerge = new LinkedList<Integer>();
		toMerge.addLast(1);
		toMerge.addLast(2);

		list.mergeLast(toMerge);

		assertEquals(3, list.size());

		assertEquals(0, (int) list.findAt(0));
		assertEquals(1, (int) list.findAt(1));
		assertEquals(2, (int) list.findAt(2));
	}
	
	@Test(expected = NullPointerException.class)
	public void mergeLastNullTest() {
		list.mergeLast(null);
	}

	@Test(expected = NullPointerException.class)
	public void mergeFirstNullTest() {
		list.mergeFirst(null);
	}
	
	@Test(expected = NoSuchElementException.class)
	public void removeAtEmptyTest() {
		list.removeAt(0);
	}

	@Test(expected = NoSuchElementException.class)
	public void removeFirstEmptyTest() {
		list.removeFirst();
	}

	@Test(expected = NoSuchElementException.class)
	public void removeLastEmptyTest() {
		list.removeLast();
	}

	@Test
	public void reverseIteratorTest() {
		fillList();

		int i = 3;
		Iterator<Integer> it = list.reverseIterator();
		while (it.hasNext()) {
			int j = it.next();
			assertEquals(i, j);
			i--;
		}
	}

	@Test
	public void firstTest() {
		fillList();
		assertEquals(1, (int)list.first());
	}

	@Test(expected = NoSuchElementException.class)
	public void firstEmptyTest() {
		list.first();		
	}

	@Test
	public void lastTest() {
		fillList();
		assertEquals(3, (int)list.last());
	}

	@Test(expected = NoSuchElementException.class)
	public void lastEmptyTest() {
		list.last();
	}

	@Test
	public void matchesEmptyTest(){
		fillList();
		Collection<Integer> noMatches = list.matches(new Predicate<Integer>() {	
			@Override
			public boolean compare(Integer elem) {
				return Integer.compare(elem, 5) == 0;
			}
		});
		
		assertEquals(0, noMatches.size());
		
		
		Collection<Integer> hasMatches = list.matches(new Predicate<Integer>() {
			@Override
			public boolean compare(Integer elem) {
				return Integer.compare(elem, 2) == 0;
			}
		});
		
		assertEquals(1, hasMatches.size());
		assertEquals(2, (int)hasMatches.first());
	}
	
}