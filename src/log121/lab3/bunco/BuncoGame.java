package log121.lab3.bunco;

import log121.lab3.api.Dice;
import log121.lab3.api.DiceCollection;
import log121.lab3.api.GameBuilder;
import log121.lab3.api.GameStrategy;
import log121.lab3.api.Player;
import log121.lab3.api.PlayerCollection;

public class BuncoGame extends GameBuilder {

	public BuncoGame(GameStrategy strategy, int nbTurns) {
		super(strategy, nbTurns);
		// TODO Auto-generated constructor stub
	}

	public static final int NUMBER_OF_DICES = 3;

	@Override
	protected PlayerCollection makePlayers() {
		PlayerCollection players = new PlayerCollection();
		players.addLast(new Player("Maxime Bédard"));
		players.addLast(new Player("Stéphanie Fortier"));
		players.addLast(new Player("Xavier Drdak"));
		players.addLast(new Player("Gabriel Couvrette"));
		players.addLast(new Player("Pascal Robillard"));
		return players;
	}

	@Override
	protected DiceCollection makeDices() {
		DiceCollection dices = new DiceCollection();
		for(int i = 0; i < NUMBER_OF_DICES; i++)
			dices.addLast(new Dice());
		return dices;
	}
}
