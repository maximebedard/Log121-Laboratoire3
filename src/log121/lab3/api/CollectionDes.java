package log121.lab3.api;

import java.util.Iterator;

public class CollectionDes extends Liste<De> {
	
	private void ajouterJoueur(De p)
	{
		this.ajouterFin(p);
	}
	
	private Iterator<De> creerIterateur(){
		return this.iterator();
	}
	
}
