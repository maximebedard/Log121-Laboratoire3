package log121.lab3.api;
import java.util.Iterator;



public interface Collection<T> extends Iterable<T> {

	void addFirst(T element);
	void mergeFirst(Collection<T> col);
	
	void addLast(T element);
	void mergeLast(Collection<T> col);
	
	void addAt(int index, T element);
	
	T removeFirst();	
	T removeLast();
	T removeAt(int index);
	
	void clear();
	
	boolean isEmpty();
	
	int size();
	
	T findAt(int index);
	T first();
	T last();
	
	Collection<T> matches(Predicate<T> predicat);
	
	Iterator<T> reverseIterator();
	
}
