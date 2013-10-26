package log121.lab3.api;
import java.util.Iterator;



public interface Ensemble<T> extends Iterable<T> {

	void ajouterDebut(T element);
	void fusionnerDebut(Ensemble<T> col);
	
	void ajouterFin(T element);
	void fusionnerFin(Ensemble<T> col);
	
	void ajouter(int index, T element);
	
	T enleverDebut();	
	T enleverFin();
	T enlever(int index);
	
	void vider();
	
	boolean estVide();
	
	int taille();
	
	T trouver(int index);
	T premier();
	T dernier();
	
	Ensemble<T> matches(Predicate<T> predicat);
	
	Iterator<T> reverseIterator();
	
}
