package log121.lab3.tests;

import static org.junit.Assert.*;
import log121.lab3.api.CollectionDes;
import log121.lab3.api.CollectionJoueurs;
import log121.lab3.api.CreateurJeu;
import log121.lab3.api.De;
import log121.lab3.api.Jeu;
import log121.lab3.api.Joueur;
import log121.lab3.api.ListeIterateur;
import log121.lab3.bunco.JeuBunco;
import log121.lab3.bunco.StrategieBunco;

import org.junit.Before;
import org.junit.Test;

public class TestIStrategie {

	JeuBunco bunco;
	Jeu buncoSimple;

	@Before
	public void setUp() {
		bunco = new JeuBunco();

		buncoSimple = new Jeu(6, new StrategieBunco(), new CreateurJeu() {

			@Override
			public CollectionJoueurs creerJoueurs() {

				CollectionJoueurs j = new CollectionJoueurs();
				j.ajouterDebut(new Joueur("Maxime"));
				return j;
			}

			@Override
			public CollectionDes creerDes() {
				CollectionDes d = new CollectionDes();
				d.ajouterFin(new De());
				d.ajouterFin(new De());
				d.ajouterFin(new De());
				return d;
			}
		});
	}

	private static void assigneDesCalculeScoreTour(Jeu j, int[] vals) {
		if (vals.length != j.getListeDes().taille())
			return;
		int i = 0;
		for (De de : j.getListeDes()) {
			de.setFaceObtenue(vals[i]);
			i++;
		}
		j.calculerScoreTour();
	}

	@Test
	public void testTour1() {
		CollectionJoueurs joueurs = bunco.getListeJoueurs();

		ListeIterateur<Joueur> iter = bunco.getIterator();

		// DEBUT DE LA PARTIE
		assertEquals("Maxime", iter.getCurrent().getName());
		assertEquals(0, iter.getCurrent().getScore());

		// JOUEUR 1
		assigneDesCalculeScoreTour(bunco, new int[] { 1, 3, 1 });
		assertEquals("Maxime", iter.getCurrent().getName());
		assertEquals(2, iter.getCurrent().getScore());

		assigneDesCalculeScoreTour(bunco, new int[] { 4, 2, 1 });
		assertEquals("Maxime", iter.getCurrent().getName());
		assertEquals(3, iter.getCurrent().getScore());

		assigneDesCalculeScoreTour(bunco, new int[] { 6, 6, 2 });
		assertEquals("Maxime", iter.getPrevious().getName());
		assertEquals(3, iter.getPrevious().getScore());
		assertEquals("Daniel", iter.getCurrent().getName());
		assertEquals(0, iter.getCurrent().getScore());

		// JOUEUR 2
		assigneDesCalculeScoreTour(bunco, new int[] { 2, 1, 6 });
		assertEquals("Daniel", iter.getCurrent().getName());
		assertEquals(1, iter.getCurrent().getScore());

		assigneDesCalculeScoreTour(bunco, new int[] { 5, 4, 1 });
		assertEquals("Daniel", iter.getCurrent().getName());
		assertEquals(2, iter.getCurrent().getScore());

		assigneDesCalculeScoreTour(bunco, new int[] { 3, 4, 5 });
		assertEquals("Daniel", iter.getPrevious().getName());
		assertEquals(2, iter.getPrevious().getScore());
		assertEquals("Guy", iter.getCurrent().getName());
		assertEquals(0, iter.getCurrent().getScore());

		// JOUEUR 3
		assigneDesCalculeScoreTour(bunco, new int[] { 3, 3, 3 });
		assertEquals("Guy", iter.getCurrent().getName());
		assertEquals(5, iter.getCurrent().getScore());

		assigneDesCalculeScoreTour(bunco, new int[] { 4, 5, 2 });
		assertEquals("Guy", iter.getPrevious().getName());
		assertEquals(5, iter.getPrevious().getScore());
		assertEquals("Henry", iter.getCurrent().getName());
		assertEquals(0, iter.getCurrent().getScore());

		// JOUEUR 4
		assigneDesCalculeScoreTour(bunco, new int[] { 1, 1, 1 });
		assertEquals("Henry", iter.getPrevious().getName());
		assertEquals(21, iter.getPrevious().getScore());
		assertEquals("Bob", iter.getCurrent().getName());
		assertEquals(0, iter.getCurrent().getScore());
		assertEquals(1, bunco.getTourCourant());

		// JOUEUR 5
		assigneDesCalculeScoreTour(bunco, new int[] { 4, 5, 2 });
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

	@Test
	public void testBunco() {
		ListeIterateur<Joueur> iter = buncoSimple.getIterator();

		// DEBUT DE LA PARTIE
		assertEquals("Maxime", iter.getCurrent().getName());
		assertEquals(0, iter.getCurrent().getScore());
		assertEquals(1, buncoSimple.getTourCourant());

		// JOUEUR 1
		assigneDesCalculeScoreTour(buncoSimple, new int[] { 1, 1, 1 });
		assertEquals("Maxime", iter.getPrevious().getName());
		assertEquals(21, iter.getPrevious().getScore());
		assertEquals(2, buncoSimple.getTourCourant());

		// JOUEUR 2
		assigneDesCalculeScoreTour(buncoSimple, new int[] { 2, 2, 2 });
		assertEquals("Maxime", iter.getPrevious().getName());
		assertEquals(42, iter.getPrevious().getScore());
		assertEquals(3, buncoSimple.getTourCourant());

		// JOUEUR 3
		assigneDesCalculeScoreTour(buncoSimple, new int[] { 3, 3, 3 });
		assertEquals("Maxime", iter.getPrevious().getName());
		assertEquals(63, iter.getPrevious().getScore());
		assertEquals(4, buncoSimple.getTourCourant());

		// JOUEUR 4
		assigneDesCalculeScoreTour(buncoSimple, new int[] { 4, 4, 4 });
		assertEquals("Maxime", iter.getPrevious().getName());
		assertEquals(84, iter.getPrevious().getScore());
		assertEquals(5, buncoSimple.getTourCourant());

		// JOUEUR 5
		assigneDesCalculeScoreTour(buncoSimple, new int[] { 5, 5, 5 });
		assertEquals("Maxime", iter.getPrevious().getName());
		assertEquals(105, iter.getPrevious().getScore());
		assertEquals(6, buncoSimple.getTourCourant());

		// JOUEUR 6
		assigneDesCalculeScoreTour(buncoSimple, new int[] { 6, 6, 6 });
		assertEquals("Maxime", iter.getPrevious().getName());
		assertEquals(126, iter.getPrevious().getScore());
		assertEquals(7, buncoSimple.getTourCourant());

		assigneDesCalculeScoreTour(buncoSimple, new int[] { 6, 6, 6 });
		assertEquals("Maxime", iter.getPrevious().getName());
		assertEquals(126, iter.getPrevious().getScore());
		assertEquals(7, buncoSimple.getTourCourant());

	}

	@Test
	public void testIdentique() {
		ListeIterateur<Joueur> iter = buncoSimple.getIterator();

		// DEBUT DE LA PARTIE
		assertEquals("Maxime", iter.getCurrent().getName());
		assertEquals(0, iter.getCurrent().getScore());
		assertEquals(1, buncoSimple.getTourCourant());

		// JOUEUR 1
		for (int i = 2; i < 6; i++) {
			assigneDesCalculeScoreTour(buncoSimple, new int[] { i, i, i });
			assertEquals("Maxime", iter.getCurrent().getName());
			assertEquals((i - 1) * 5, iter.getCurrent().getScore());
			assertEquals(1, buncoSimple.getTourCourant());
		}
		assigneDesCalculeScoreTour(buncoSimple, new int[] { 1, 1, 1 });
		assertEquals("Maxime", iter.getPrevious().getName());
		assertEquals(41, iter.getPrevious().getScore());
		assertEquals(2, buncoSimple.getTourCourant());

	}

	@Test
	public void testMemeNombre() {
		ListeIterateur<Joueur> iter = buncoSimple.getIterator();

		// DEBUT DE LA PARTIE
		assertEquals("Maxime", iter.getCurrent().getName());
		assertEquals(0, iter.getCurrent().getScore());
		assertEquals(1, buncoSimple.getTourCourant());

		// JOUEUR 1
		assigneDesCalculeScoreTour(buncoSimple, new int[] { 6, 6, 1 });
		assertEquals("Maxime", iter.getCurrent().getName());
		assertEquals(1, iter.getCurrent().getScore());
		assertEquals(1, buncoSimple.getTourCourant());

		assigneDesCalculeScoreTour(buncoSimple, new int[] { 6, 1, 6 });
		assertEquals("Maxime", iter.getCurrent().getName());
		assertEquals(2, iter.getCurrent().getScore());
		assertEquals(1, buncoSimple.getTourCourant());

		assigneDesCalculeScoreTour(buncoSimple, new int[] { 1, 6, 6 });
		assertEquals("Maxime", iter.getCurrent().getName());
		assertEquals(3, iter.getCurrent().getScore());
		assertEquals(1, buncoSimple.getTourCourant());

		assigneDesCalculeScoreTour(buncoSimple, new int[] { 1, 6, 1 });
		assertEquals("Maxime", iter.getCurrent().getName());
		assertEquals(5, iter.getCurrent().getScore());
		assertEquals(1, buncoSimple.getTourCourant());

		assigneDesCalculeScoreTour(buncoSimple, new int[] { 1, 1, 6 });
		assertEquals("Maxime", iter.getCurrent().getName());
		assertEquals(7, iter.getCurrent().getScore());
		assertEquals(1, buncoSimple.getTourCourant());		
	}
	
	@Test
	public void testJouerPartie()
	{
		bunco.jouerPartie();
		ListeIterateur<Joueur> iter = bunco.getListeJoueurs().creerIterateur();
		Joueur prec = iter.next();
		while(iter.hasNext())
		{
			Joueur courant = iter.next();
			assertTrue(prec.compareTo(courant) <= 0);
			prec = courant;
		}
		Joueur gagnant = bunco.getListeJoueurs().dernier();
		String out = String.format("Vainqueur : %s (%d)", gagnant.getName(), gagnant.getScore());
		System.out.println(out);
	}
	
	public void testJouerTour()
	{
		assertEquals(1, bunco.getTourCourant());
		for(int i = 2; i <= 6; i++)
		{
			bunco.jouerTour();
			assertEquals(i , bunco.getTourCourant());
		}
	}
	
	
	

}
