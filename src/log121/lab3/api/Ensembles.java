package log121.lab3.api;

import java.util.Comparator;

public class Ensembles {

	/**
	 * Retourne l'inverse d'un comparateur (utilisé pour trier en ordre déscendant)
	 * @param comp comparateur à inverser
	 * @return comparateur inverse
	 */
	public static <T> Comparator<T> ordreInverse(final Comparator<T> comp) {
		return new Comparator<T>() {
			@Override
			public int compare(T o1, T o2) {
				return comp.compare(o1, o2) * -1;
			}
		};
	}
	
	
	/**
	 * Tri la collection avec un comparateur par défaut Source :
	 * http://docs.oracle.com/javase/6/docs/api/java/util/Collections.html
	 * 
	 * @param col
	 * @return Nouvelle collection trié
	 */
	public static <T extends Comparable<? super T>> Ensemble<T> quicksort(
			final Ensemble<T> col) {
		return quicksort(col, new Comparator<T>() {
			@Override
			public int compare(T o1, T o2) {
				return o1.compareTo(o2);
			}
		});
	}

	/**
	 * Implémentation du QuickSort Source :
	 * http://rosettacode.org/wiki/Sorting_algorithms/Quicksort#Java 
	 * Pire cas : O(n^2) 
	 * Meilleur cas : O(nlogn)
	 * 
	 * Note : Comme le quicksort est implémenté en utilisant une liste chainée, 
	 * le pivot est le premier élément de la liste.
	 * 
	 * @param col collection à trier
	 * @param comp comprarateur utilisé pour effectuer la comparaison
	 * @return Nouvelle collection trié
	 */
	public static <T> Ensemble<T> quicksort(final Ensemble<T> col,
			Comparator<? super T> comp) {

		if (comp == null)
			return col;

		if (col.taille() <= 1)
			return col;

		T pivot = col.premier();

		Ensemble<T> less, more, even;
		less = new Liste<T>();
		more = new Liste<T>();
		even = new Liste<T>();

		for (T elem : col) {
			if (comp.compare(elem, pivot) < 0)
				less.ajouterFin(elem);
			else if (comp.compare(elem, pivot) > 0)
				more.ajouterFin(elem);
			else
				even.ajouterFin(elem);
		}

		less = quicksort(less, comp);
		more = quicksort(more, comp);

		less.fusionnerFin(even);
		less.fusionnerFin(more);

		return less;

	}

}
