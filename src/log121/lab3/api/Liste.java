package log121.lab3.api;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Liste<T> implements Ensemble<T> {

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
	public Liste(Ensemble<T> other) {
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
					current.getPrevious());

			if (current.hasPrevious())
				current.getPrevious().setNext(nouveau);

			if (current.hasNext())
				current.getNext().setPrevious(nouveau);

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
			temp.setPrevious(start);
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
			end.setNext(new ListeNoeud<T>(elem, null, a));
			end = end.getNext();
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
		return trouveNoeud(index).getElem();
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
		return new ListeIterateur<T>(start, true);
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
			supprimer.getPrevious().setNext(supprimer.getNext());
			supprimer.getNext().setPrevious(supprimer.getPrevious());
			size--;
			return supprimer.getElem();
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
			start = start.getNext();
		} else {
			start = null;
			end = null;
		}
		size--;
		return node.getElem();
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
			end = end.getPrevious();
		} else {
			end = null;
			start = null;
		}
		size--;
		return node.getElem();
	}

	/**
	 * Retourne un iterateur pour parcourir les éléments dans la liste en sens
	 * inverse
	 */
	@Override
	public Iterator<T> reverseIterator() {
		return new ListeIterateur<T>(end, false);
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
			found = found.getNext();
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
		return start.getElem();
	}
	
	/**
	 * Retourne le dernier élement de la liste
	 * @return dernier élément
	 */
	@Override
	public T dernier() {
		if (end == null)
			throw new NoSuchElementException();
		return end.getElem();
	}

}
