package log121.lab3.bunco;

import log121.lab3.api.Jeu;

public class JeuBunco extends Jeu {

	private static final int BUNCO_MAX_TOURS = 6;

	public JeuBunco() {
		super(BUNCO_MAX_TOURS, new StrategieBunco(), new CreateurJeuBunco());
	}
}
