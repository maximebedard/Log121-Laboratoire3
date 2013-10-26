package log121.lab3.api;

public abstract class GameBuilder {

	public final Game buildGame(int nbTurns, GameStrategy strategy) {
		Game game = new Game(nbTurns, strategy);
		game.setPlayers(makePlayers());
		game.setDices(makeDices());
		return game;
	}

	protected abstract PlayerCollection makePlayers();

	protected abstract DiceCollection makeDices();
}
