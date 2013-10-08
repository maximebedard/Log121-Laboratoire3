package log121.lab3.tests;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import log121.lab3.api.LinkedList;

import org.junit.Before;
import org.junit.Test;

public class LinkedListTest {

	private LinkedList<Integer> list;

	@Before
	public void createDicesTest() {
		list = new LinkedList<Integer>();
	}

	@Test(expected = IllegalArgumentException.class)
	public void addLastNullTest() {
		list.addLast(null);
	}

	@Test
	public void addLastTest() {
		list.addLast(1);
		assertEquals(1, list.getSize());
		assertEquals(1, (int) list.findAt(1));
	}

	@Test
	public void addLastMultipleTest() {
		list.addLast(1);
		list.addLast(2);
		assertEquals(2, list.getSize());
		assertEquals(2, (int) list.findAt(1));
	}

	@Test(expected = IllegalArgumentException.class)
	public void addFirstNullTest() {
		list.addFirst(null);
	}

	@Test
	public void addFirstTest() {
		list.addFirst(1);
		assertEquals(1, list.getSize());
		assertEquals(1, (int) list.findAt(1));
	}

	@Test
	public void addFirstMultipleTest() {
		list.addFirst(1);
		list.addFirst(2);
		assertEquals(2, list.getSize());
		assertEquals(2, (int) list.findAt(1));
	}

	@Test(expected = IllegalArgumentException.class)
	public void addAtNullTest() {
		list.addAt(0, null);
	}

	@Test(expected = NoSuchElementException.class)
	public void removeFirstEmptyTest() {
		list.removeFirst();
	}

	@Test(expected = NoSuchElementException.class)
	public void removeLastEmptyTest() {
		list.removeLast();
	}

	@Test(expected = NoSuchElementException.class)
	public void removeEmptyTest() {
		list.removeAt(0);
	}

}
