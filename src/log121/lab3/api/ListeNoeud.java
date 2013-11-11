package log121.lab3.api;


public class ListeNoeud<T> {
	private T elem;

	private ListeNoeud<T> next;

	private ListeNoeud<T> previous;

	/**
	 * Créé un nouveau noeud avec la donné à contenir
	 * @param value
	 */
	public ListeNoeud(T value) {
		this(value, null, null);
	}

	/**
	 * Créé un nouveau noeud avec la donnée à contenir, une référence vers le 
	 * noeud suivant et un référence vers le noeud précédent
	 * @param value
	 * @param next
	 * @param previous
	 */
	public ListeNoeud(T value, ListeNoeud<T> next,
			ListeNoeud<T> previous) {
		this.setElem(value);
		this.setNext(next);
		this.setPrevious(previous);
	}

	/**
	 * Retourne vrai si le noeud à une référence vers le noeud suivant
	 * @return
	 */
	public boolean hasNext() {
		return getNext() != null;
	}

	/**
	 * Retourne vrai si le noeud à une référence vers le noeud précédent
	 * @return
	 */
	public boolean hasPrevious() {
		return getPrevious() != null;
	}

	/**
	 * Retourne le noeud suivant
	 * @return
	 */
	public ListeNoeud<T> getNext() {
		return next;
	}

	/**
	 * Assigne le noeud suivant
	 * @param next
	 */
	public void setNext(ListeNoeud<T> next) {
		this.next = next;
	}
	
	/**
	 * Retourne le noeud précédent
	 * @return
	 */
	public ListeNoeud<T> getPrevious() {
		return previous;
	}

	/**
	 * Assigne le noeud précédent
	 * @param previous
	 */
	public void setPrevious(ListeNoeud<T> previous) {
		this.previous = previous;
	}

	/**
	 * Retourne l'élément contenu dans le noeud
	 * @return
	 */
	public T getElem() {
		return elem;
	}

	/**
	 * Assigne l'élément contenu dans le noeud
	 * @param elem
	 */
	public void setElem(T elem) {
		this.elem = elem;
	}
}