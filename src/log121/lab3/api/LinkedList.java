package log121.lab3.api;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<T> implements Collection<T> {

	private final class LinkedListIterator implements Iterator<T> {
		private LinkedListNode<T> prev;
		private LinkedListNode<T> current;
		private boolean ascending;

		public LinkedListIterator(LinkedListNode<T> current, boolean ascending) {
			this.prev = null;
			this.current = current;
			this.ascending = ascending;
		}

		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public T next() {
			if (current == null) {
				throw new NoSuchElementException();
			}

			prev = current;
			if (ascending)
				current = current.next;
			else
				current = current.previous;
			return prev.elem;
		}

		@Override
		public void remove() {
			throw new IllegalArgumentException("Not implemented");
		}
	}

	private final class LinkedListNode<U> {
		public U elem;

		public LinkedListNode<U> next;

		public LinkedListNode<U> previous;

		public LinkedListNode(U value) {
			this(value, null, null);
		}

		public LinkedListNode(U value, LinkedListNode<U> next, LinkedListNode<U> previous) {
			this.elem = value;
			this.next = next;
			this.previous = previous;
		}

		public boolean hasNext() {
			return next != null;
		}

		public boolean hasPrevious() {
			return previous != null;
		}
	}

	/**
	 * Nombre d'éléments dans la file
	 */
	private int size;

	/**
	 * Noeud au début de la file
	 */
	private LinkedListNode<T> start;

	/**
	 * Noeud à la fin de la file
	 */
	private LinkedListNode<T> end;

	/**
	 * Construit une liste d'éléments vide
	 */
	public LinkedList() {
		start = end = null;
		size = 0;
	}
	
	/**
	 * Construit une liste d'éléments à partir d'une autre liste
	 */
	public LinkedList(LinkedList<T> other) {
		this();
		for(T elem : other)
			addLast(elem);
	}
	

	/**
	 * Ajoute un élément à la suite de l'index s Opération en O(n)
	 * 
	 * @param index
	 * @param elem
	 * @throws ArrayIndexOutOfBoundsException
	 * @throws IllegalArgumentException
	 */
	@Override
	public void addAt(int index, T elem) {
		if (index < 0 || index > size)
			throw new ArrayIndexOutOfBoundsException("index");

		if (elem == null)
			throw new IllegalArgumentException("elem");

		if (index == 0)
			addFirst(elem);
		else if (index == size)
			addLast(elem);
		else {
			LinkedListNode<T> current = trouveNoeud(index);
			LinkedListNode<T> nouveau = new LinkedListNode<T>(elem, current, current.previous);

			if (current.hasPrevious())
				current.previous.next = nouveau;

			if (current.hasNext())
				current.next.previous = nouveau;

			size++;
		}
	}

	/**
	 * Ajoute un forme au debut de la file Opération en O(1)
	 * 
	 * @param elem
	 * 
	 * @throws IllegalArgumentException
	 */
	@Override
	public void addFirst(T elem) {
		if (elem == null)
			throw new IllegalArgumentException("elem");

		// on ajoute le premier noeud
		if (start == null) {
			start = new LinkedListNode<T>(elem);
			end = start;
		} else {
			LinkedListNode<T> temp = start;
			start = new LinkedListNode<T>(elem, temp, null);
			temp.previous = start;
		}

		size++;
	}

	/**
	 * Ajoute une forme à la fin de la file Opération en O(1)
	 * 
	 * @param elem
	 * @throws IllegalArgumentException
	 */
	@Override
	public void addLast(T elem) {
		if (elem == null)
			throw new IllegalArgumentException("elem");

		// on ajoute le premier noeud
		if (start == null) {
			start = new LinkedListNode<T>(elem);
			end = start;
		}
		// on ajoute le noeud é la fin
		else {
			LinkedListNode<T> a = end;
			end.next = new LinkedListNode<T>(elem, null, a);
			end = end.next;
		}

		size++;
	}

	/**
	 * Retire tous les éléments de la liste
	 */
	@Override
	public void empty() {
		for (@SuppressWarnings("unused")
		T elem : this)
			removeLast();
	}

	/**
	 * Trouve l'élément situé à l'index demandé Opération en O(n)
	 * 
	 * @param index
	 * @return Noeud<T> dans la chaine
	 * 
	 * @throws ArrayIndexOutOfBoundsException
	 */
	@Override
	public T findAt(int index) {
		return trouveNoeud(index).elem;
	}

	/**
	 * Retourne le nombre d'element dans la liste
	 * 
	 * @return nombre de formes
	 */
	@Override
	public int getSize() {
		return size;
	}

	/**
	 * Retoure vrai si la liste est vide
	 */
	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Retoune un iterateur pour parcourir les elements dans la liste
	 */
	@Override
	public Iterator<T> iterator() {
		return new LinkedListIterator(start, true);
	}

	/**
	 * Ajoute tous les éléments d'une autre liste chainée au débute de la liste
	 * actuelle
	 */
	@Override
	public void mergeFirst(Collection<T> col) {
		for (T elem : col)
			addFirst(elem);
	}

	/**
	 * Ajoute tous les éléments d'une autre liste chainée à la fin de la liste
	 * actuelle
	 */
	@Override
	public void mergeLast(Collection<T> col) {
		for (T elem : col)
			addLast(elem);
	}

	/**
	 * Retire un element à l'index donné
	 * 
	 * @throws NoSuchElementException
	 *             si la file est vide
	 */
	@Override
	public T removeAt(int index) {
		if (index < 0 || index > size)
			throw new ArrayIndexOutOfBoundsException("index");

		if (index == 0)
			return removeFirst();
		else if (index == size)
			return removeLast();
		else {
			LinkedListNode<T> supprimer = trouveNoeud(index);
			supprimer.previous.next = supprimer.next;
			supprimer.next.previous = supprimer.previous;
			size--;
			return supprimer.elem == null ? null : supprimer.elem;
		}
	}

	/**
	 * Retire un element au debut de la liste
	 */
	@Override
	public T removeFirst() {
		if (start == null)
			throw new NoSuchElementException();

		LinkedListNode<T> node = start;
		if (start.hasNext()) {
			start = start.next;
		} else {
			start = null;
			end = null;
		}
		size--;
		return node == null ? null : node.elem;
	}

	/**
	 * Retire un element a la fin de la liste
	 */
	@Override
	public T removeLast() {
		if (end == null)
			throw new NoSuchElementException();

		LinkedListNode<T> node = end;
		if (end.hasPrevious()) {
			end = end.previous;
		} else {
			end = null;
			start = null;
		}
		size--;
		return node == null ? null : node.elem;
	}

	/**
	 * Retourne un iterateur pour parcourir les éléments dans la liste en sens
	 * inverse
	 */
	@Override
	public Iterator<T> reverseIterator() {
		return new LinkedListIterator(end, false);
	}

	/**
	 * Trouve le noeud dans la liste chainé et le retourne
	 * 
	 * @param index
	 *            position du noeud dans la chaine
	 * @return Noeud<T> dans la chaine
	 * 
	 * @throws ArrayIndexOutOfBoundsException
	 */
	private LinkedListNode<T> trouveNoeud(int index) {
		if (index < 0 || index >= size)
			throw new ArrayIndexOutOfBoundsException("index");

		LinkedListNode<T> found = start;
		int i = 0;

		while (found.hasNext() && i++ != index) {
			found = found.next;
		}

		return found;
	}

}
