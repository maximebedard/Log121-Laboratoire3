package log121.lab3.tests;

import static org.junit.Assert.*;
import log121.lab3.api.CollectionJoueurs;
import log121.lab3.api.De;
import log121.lab3.api.Joueur;
import log121.lab3.api.ListeIterateur;
import log121.lab3.bunco.JeuBunco;

import org.junit.Before;
import org.junit.Test;

public class TestIStrategie {

	JeuBunco bunco;

	@Before
	public void setUp() {
		bunco = new JeuBunco();
	}

	private void assigneDesCalculeScoreTour(int[] vals) {
		if (vals.length != bunco.getListeDes().taille())
			return;
		int i = 0;
		for (De de : bunco.getListeDes()) {
			de.setFaceObtenue(vals[i]);
			i++;
		}
		bunco.calculerScoreTour();
	}

	@Test
	public void testTour1() {
		CollectionJoueurs joueurs = bunco.getListeJoueurs();
		
		ListeIterateur<Joueur> iter = bunco.getIterator();
		
		// DEBUT DE LA PARTIE
		assertEquals("Maxime", iter.getCurrent().getName());
		assertEquals(0, iter.getCurrent().getScore());
		
		// JOUEUR 1
		assigneDesCalculeScoreTour(new int[]{1,3,1});
		assertEquals("Maxime", iter.getCurrent().getName());
		assertEquals(2, iter.getCurrent().getScore());
		
		assigneDesCalculeScoreTour(new int[]{4,2,1});
		assertEquals("Maxime", iter.getCurrent().getName());
		assertEquals(3, iter.getCurrent().getScore());
		
		assigneDesCalculeScoreTour(new int[]{6,6,2});
		assertEquals("Maxime", iter.getPrevious().getName());
		assertEquals(3, iter.getPrevious().getScore());
		assertEquals("Daniel", iter.getCurrent().getName());
		assertEquals(0, iter.getCurrent().getScore());
		
		// JOUEUR 2
		assigneDesCalculeScoreTour(new int[]{2,1,6});
		assertEquals("Daniel", iter.getCurrent().getName());
		assertEquals(1, iter.getCurrent().getScore());
		
		assigneDesCalculeScoreTour(new int[]{5,4,1});
		assertEquals("Daniel", iter.getCurrent().getName());
		assertEquals(2, iter.getCurrent().getScore());
		
		assigneDesCalculeScoreTour(new int[]{3,4,5});
		assertEquals("Daniel", iter.getPrevious().getName());
		assertEquals(2, iter.getPrevious().getScore());
		assertEquals("Guy", iter.getCurrent().getName());
		assertEquals(0, iter.getCurrent().getScore());
		
		// JOUEUR 3
		assigneDesCalculeScoreTour(new int[]{3,3,3});
		assertEquals("Guy", iter.getCurrent().getName());
		assertEquals(5, iter.getCurrent().getScore());
		
		assigneDesCalculeScoreTour(new int[]{4,5,2});
		assertEquals("Guy", iter.getPrevious().getName());
		assertEquals(5, iter.getPrevious().getScore());
		assertEquals("Henry", iter.getCurrent().getName());
		assertEquals(0, iter.getCurrent().getScore());
		
		// JOUEUR 4
		assigneDesCalculeScoreTour(new int[]{1,1,1});
		assertEquals("Henry", iter.getPrevious().getName());
		assertEquals(21, iter.getPrevious().getScore());
		assertEquals("Bob", iter.getCurrent().getName());
		assertEquals(0, iter.getCurrent().getScore());
		
		// JOUEUR 5
		assigneDesCalculeScoreTour(new int[]{4,5,2});
		assertEquals("Bob", iter.getPrevious().getName());
		assertEquals(0, iter.getPrevious().getScore());
		assertFalse(iter.hasNext());
		assertEquals(2, bunco.getTourCourant());
		
		assertEquals("Maxime", joueurs.trouver(0).getName());
		assertEquals(3, joueurs.trouver(0).getScore());
		assertEquals("Daniel", joueurs.trouver(1).getName());
		assertEquals(2, joueurs.trouver(1).getScore());
		assertEquals("Guy", joueurs.trouver(2).getName());
		assertEquals(5, joueurs.trouver(2).getScore());
		assertEquals("Henry", joueurs.trouver(3).getName());
		assertEquals(21, joueurs.trouver(3).getScore());
		assertEquals("Bob", joueurs.trouver(4).getName());
		assertEquals(0, joueurs.trouver(4).getScore());
				
	}

}
