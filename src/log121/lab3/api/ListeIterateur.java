package log121.lab3.api;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListeIterateur<T> implements Iterator<T> {
	private ListeNoeud<T> prev;
	private ListeNoeud<T> current;
	private boolean ascending;

	/**
	 * Créé un itérateur pour une liste de noeud
	 * 
	 * @param current
	 * @param ascending
	 */
	public ListeIterateur(ListeNoeud<T> current, boolean ascending) {
		this.prev = null;
		this.current = current;
		this.ascending = ascending;
	}

	/**
	 * Retourne vrai si l'itérateur à d'autres éléments à parcourir
	 */
	@Override
	public boolean hasNext() {
		return current != null;
	}

	/**
	 * Retourne l'élément suivant et avance l'itérateur
	 */
	@Override
	public T next() {
		if (current == null)
			throw new NoSuchElementException();

		prev = current;
		if (ascending)
			current = current.getNext();
		else
			current = current.getPrevious();
		return prev.getElem();
	}

	public T getCurrent() {
		if (current == null)
			throw new NoSuchElementException();

		return current.getElem();
	}

	/**
	 * Supprime l'élément de l'itérateur (not implemented)
	 */
	@Override
	public void remove() {
		throw new IllegalArgumentException("Not implemented");
	}
}