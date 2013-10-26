package log121.lab3.bunco;

import log121.lab3.api.Dice;
import log121.lab3.api.DiceCollection;
import log121.lab3.api.GameBuilder;
import log121.lab3.api.Player;
import log121.lab3.api.PlayerCollection;

public class BuncoGame extends GameBuilder {

	public static final int NUMBER_OF_DICES = 3;

	@Override
	protected PlayerCollection makePlayers() {
		PlayerCollection players = new PlayerCollection();
		players.ajouterFin(new Player("Maxime Bédard"));
		players.ajouterFin(new Player("Stéphanie Fortier"));
		players.ajouterFin(new Player("Xavier Drdak"));
		players.ajouterFin(new Player("Gabriel Couvrette"));
		players.ajouterFin(new Player("Pascal Robillard"));
		return players;
	}

	@Override
	protected DiceCollection makeDices() {
		DiceCollection dices = new DiceCollection();
		for(int i = 0; i < NUMBER_OF_DICES; i++)
			dices.ajouterFin(new Dice());
		return dices;
	}
}
