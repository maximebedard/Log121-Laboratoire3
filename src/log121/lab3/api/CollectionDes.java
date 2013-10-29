package log121.lab3.api;

import java.util.Iterator;

public class CollectionDes extends Liste<De> {
	
	public void ajouterJoueur(De p)
	{
		this.ajouterFin(p);
	}
	
	public Iterator<De> creerIterateur(){
		return this.iterator();
	}
	
}
