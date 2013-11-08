package log121.lab3.api;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Liste<T> implements Ensemble<T> {

	private final class ListeIterateur implements Iterator<T> {
		private ListeNoeud<T> prev;
		private ListeNoeud<T> current;
		private boolean ascending;

		public ListeIterateur(ListeNoeud<T> current, boolean ascending) {
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

	private final class ListeNoeud<U> {
		public U elem;

		public ListeNoeud<U> next;

		public ListeNoeud<U> previous;

		public ListeNoeud(U value) {
			this(value, null, null);
		}

		public ListeNoeud(U value, ListeNoeud<U> next,
				ListeNoeud<U> previous) {
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
	private ListeNoeud<T> start;

	/**
	 * Noeud à la fin de la file
	 */
	private ListeNoeud<T> end;

	/**
	 * Construit une liste d'éléments vide
	 */
	public Liste() {
		start = end = null;
		size = 0;
	}

	/**
	 * Construit une liste d'éléments à partir d'une autre liste
	 */
	public Liste(Liste<T> other) {
		this();
		for (T elem : other)
			ajouterFin(elem);
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
	public void ajouter(int index, T elem) {
		if (index < 0 || index > size)
			throw new ArrayIndexOutOfBoundsException("index");

		if (elem == null)
			throw new IllegalArgumentException("elem");

		if (index == 0)
			ajouterDebut(elem);
		else if (index == size)
			ajouterFin(elem);
		else {
			ListeNoeud<T> current = trouveNoeud(index);
			ListeNoeud<T> nouveau = new ListeNoeud<T>(elem, current,
					current.previous);

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
	public void ajouterDebut(T elem) {
		if (elem == null)
			throw new IllegalArgumentException("elem");

		// on ajoute le premier noeud
		if (start == null) {
			start = new ListeNoeud<T>(elem);
			end = start;
		} else {
			ListeNoeud<T> temp = start;
			start = new ListeNoeud<T>(elem, temp, null);
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
	public void ajouterFin(T elem) {
		if (elem == null)
			throw new IllegalArgumentException("elem");

		// on ajoute le premier noeud
		if (start == null) {
			start = new ListeNoeud<T>(elem);
			end = start;
		}
		// on ajoute le noeud é la fin
		else {
			ListeNoeud<T> a = end;
			end.next = new ListeNoeud<T>(elem, null, a);
			end = end.next;
		}

		size++;
	}

	/**
	 * Retire tous les éléments de la liste
	 */
	@Override
	public void vider() {
		for (@SuppressWarnings("unused")
		T elem : this)
			enleverFin();
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
	public T trouver(int index) {
		return trouveNoeud(index).elem;
	}

	/**
	 * Retourne le nombre d'element dans la liste
	 * 
	 * @return nombre de formes
	 */
	@Override
	public int taille() {
		return size;
	}

	/**
	 * Retoure vrai si la liste est vide
	 */
	@Override
	public boolean estVide() {
		return size == 0;
	}

	/**
	 * Retoune un iterateur pour parcourir les elements dans la liste
	 */
	@Override
	public Iterator<T> iterator() {
		return new ListeIterateur(start, true);
	}

	/**
	 * Ajoute tous les éléments d'une autre liste chainée au débute de la liste
	 * actuelle
	 */
	@Override
	public void fusionnerDebut(Ensemble<T> col) {
		for (T elem : col)
			ajouterDebut(elem);
	}

	/**
	 * Ajoute tous les éléments d'une autre liste chainée à la fin de la liste
	 * actuelle
	 */
	@Override
	public void fusionnerFin(Ensemble<T> col) {
		for (T elem : col)
			ajouterFin(elem);
	}

	/**
	 * Retire un element à l'index donné
	 * 
	 * @throws NoSuchElementException
	 *             si la file est vide
	 */
	@Override
	public T enlever(int index) {
		if (index < 0 || index > size)
			throw new ArrayIndexOutOfBoundsException("index");

		if (index == 0)
			return enleverDebut();
		else if (index == size)
			return enleverFin();
		else {
			ListeNoeud<T> supprimer = trouveNoeud(index);
			supprimer.previous.next = supprimer.next;
			supprimer.next.previous = supprimer.previous;
			size--;
			return supprimer.elem;
		}
	}

	/**
	 * Retire un element au debut de la liste
	 */
	@Override
	public T enleverDebut() {
		if (start == null)
			throw new NoSuchElementException();

		ListeNoeud<T> node = start;
		if (start.hasNext()) {
			start = start.next;
		} else {
			start = null;
			end = null;
		}
		size--;
		return node.elem;
	}

	/**
	 * Retire un element a la fin de la liste
	 */
	@Override
	public T enleverFin() {
		if (end == null)
			throw new NoSuchElementException();

		ListeNoeud<T> node = end;
		if (end.hasPrevious()) {
			end = end.previous;
		} else {
			end = null;
			start = null;
		}
		size--;
		return node.elem;
	}

	/**
	 * Retourne un iterateur pour parcourir les éléments dans la liste en sens
	 * inverse
	 */
	@Override
	public Iterator<T> reverseIterator() {
		return new ListeIterateur(end, false);
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
	private ListeNoeud<T> trouveNoeud(int index) {
		if (index < 0 || index >= size)
			throw new ArrayIndexOutOfBoundsException("index");

		ListeNoeud<T> found = start;
		int i = 0;

		while (found.hasNext() && i++ != index) {
			found = found.next;
		}

		return found;
	}

	/**
	 * Retourne le premier élément de la liste
	 * @return premier élément
	 */
	@Override
	public T premier() {
		if (start == null)
			throw new NoSuchElementException();
		return start.elem;
	}
	
	/**
	 * Retourne le dernier élement de la liste
	 * @return dernier élément
	 */
	@Override
	public T dernier() {
		if (end == null)
			throw new NoSuchElementException();
		return end.elem;
	}

}
